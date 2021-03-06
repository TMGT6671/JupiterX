package blue.jupiterx.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import blue.jupiterx.JupiterX;

public class MainLogger extends Thread {

    protected final String logPath;
    protected final boolean logDebug;
    protected final ConcurrentLinkedQueue<String> logBuffer = new ConcurrentLinkedQueue<String>();
    protected boolean shutdown;
    private final Map<TextFormat, String> replacements = new EnumMap<TextFormat, String>(TextFormat.class);
    private final TextFormat[] colors = TextFormat.values();

    protected static MainLogger logger;

    public MainLogger(String logFile) {
        this(logFile, false);
    }

    public MainLogger(String logFile, boolean logDebug) {
        if (logger != null) {
            throw new RuntimeException("MainLogger has been already created");
        }
        logger = this;
        this.logPath = logFile;
        this.logDebug = logDebug;
        this.start();
    }

    public static MainLogger getLogger() {
        return logger;
    }

    public void emergency(String message) {
        this.send(TextFormat.RED + "[EMERGENCY] " +message);
    }

    public void alert(String message) {
        this.send(TextFormat.RED + "[ALERT] " + message);
    }

    public void critical(String message) {
        this.send(TextFormat.RED + "[CRITICAL] " + message);
    }

    public void error(String message) {
        this.send(TextFormat.DARK_RED + "[ERROR] " + message);
    }

    public void warning(String message) {
        this.send(TextFormat.YELLOW + "[WARNING] " + message);
    }

    public void notice(String message) {
        this.send(TextFormat.AQUA + "[NOTICE] " + message);
    }

    public void info(String message) {
        this.send(TextFormat.WHITE + "[INFO] " + message);
    }

    public void debug(String message) {
        this.send(TextFormat.GRAY + "[DEBUG] " + message);
    }

    public void logException(Exception e) {
        this.alert(e.getMessage());
    }

    public void log(LogLevel level, String message) {
        switch (level) {
            case EMERGENCY:
                this.emergency(message);
                break;
            case ALERT:
                this.alert(message);
                break;
            case CRITICAL:
                this.critical(message);
                break;
            case ERROR:
                this.error(message);
                break;
            case WARNING:
                this.warning(message);
                break;
            case NOTICE:
                this.notice(message);
                break;
            case INFO:
                this.info(message);
                break;
            case DEBUG:
                this.debug(message);
                break;
        }
    }

    public void shutdown() {
        this.shutdown = true;
    }

    protected void send(String message) {
        this.send(message + -1);
        synchronized (this) {
            this.notify();
        }
    }

    protected void send(String message, int level) {
        logBuffer.add(message);
    }

    private String colorize(String string) {
        if (string.indexOf(TextFormat.ESCAPE) < 0) {
            return string;
        } else {
            for (TextFormat color : colors) {
                if (replacements.containsKey(color)) {
                    string = string.replaceAll("(?i)" + color, replacements.get(color));
                } else {
                    string = string.replaceAll("(?i)" + color, "");
                }
            }
        }
        return string + Ansi.ansi().reset();
    }


    @Override
    public void run() {
        AnsiConsole.systemInstall();
        File logFile = new File(logPath);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                this.logException(e);
            }
        } else {
            long date = logFile.lastModified();
            String newName = new SimpleDateFormat("Y-M-d HH.mm.ss").format(new Date(date)) + ".log";
            File oldLogs = new File(JupiterX.DATA_PATH, "logs");
            if (!oldLogs.exists()) {
                oldLogs.mkdirs();
            }
            logFile.renameTo(new File(oldLogs, newName));
            logFile = new File(logPath);
            if (!logFile.exists()) {
                try {
                    logFile.createNewFile();
                } catch (IOException e) {
                    this.logException(e);
                }
            }
        }
        replacements.put(TextFormat.BLACK, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).boldOff().toString());
        replacements.put(TextFormat.DARK_BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).boldOff().toString());
        replacements.put(TextFormat.DARK_GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).boldOff().toString());
        replacements.put(TextFormat.DARK_AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).boldOff().toString());
        replacements.put(TextFormat.DARK_RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).boldOff().toString());
        replacements.put(TextFormat.DARK_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).boldOff().toString());
        replacements.put(TextFormat.GOLD, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).boldOff().toString());
        replacements.put(TextFormat.GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).boldOff().toString());
        replacements.put(TextFormat.DARK_GRAY, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLACK).bold().toString());
        replacements.put(TextFormat.BLUE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.BLUE).bold().toString());
        replacements.put(TextFormat.GREEN, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.GREEN).bold().toString());
        replacements.put(TextFormat.AQUA, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.CYAN).bold().toString());
        replacements.put(TextFormat.RED, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.RED).bold().toString());
        replacements.put(TextFormat.LIGHT_PURPLE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.MAGENTA).bold().toString());
        replacements.put(TextFormat.YELLOW, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.YELLOW).bold().toString());
        replacements.put(TextFormat.WHITE, Ansi.ansi().a(Ansi.Attribute.RESET).fg(Ansi.Color.WHITE).bold().toString());
        replacements.put(TextFormat.BOLD, Ansi.ansi().a(Ansi.Attribute.UNDERLINE_DOUBLE).toString());
        replacements.put(TextFormat.STRIKETHROUGH, Ansi.ansi().a(Ansi.Attribute.STRIKETHROUGH_ON).toString());
        replacements.put(TextFormat.UNDERLINE, Ansi.ansi().a(Ansi.Attribute.UNDERLINE).toString());
        replacements.put(TextFormat.ITALIC, Ansi.ansi().a(Ansi.Attribute.ITALIC).toString());
        replacements.put(TextFormat.RESET, Ansi.ansi().a(Ansi.Attribute.RESET).toString());
        this.shutdown = false;
        do {
            flushBuffer(logFile);
        } while (!this.shutdown);
        flushBuffer(logFile);
    }

    private void flushBuffer(File logFile) {
        if (logBuffer.isEmpty()) {
            try {
                synchronized (this) {
                    wait(25000); // Wait for next message
                }
                Thread.sleep(5); // Buffer for 5ms to reduce back and forth between disk
            } catch (InterruptedException ignore) {
            }
        }
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile, true), StandardCharsets.UTF_8), 1024);
            Date now = new Date();
            String consoleDateFormat = new SimpleDateFormat("HH:mm:ss ").format(now);
            String fileDateFormat = new SimpleDateFormat("Y-M-d HH:mm:ss ").format(now);
            int count = 0;
            while (!logBuffer.isEmpty()) {
                String message = logBuffer.poll();
                if (message != null) {
                    writer.write(fileDateFormat);
                    writer.write(TextFormat.clean(message));
                    writer.write("\r\n");
                    System.out.println(colorize(TextFormat.AQUA + consoleDateFormat + TextFormat.RESET + message + TextFormat.RESET));
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            this.logException(e);
        }
    }
}