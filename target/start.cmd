@echo off

rem JupiterX �N���o�b�`�t�@�C��(Windows��p)

rem �쐬: Itsu
rem �ŏI�X�V: 2017/9/25 17/42


setlocal enabledelayedexpansion

rem Autorestart�ϐ���0�̏ꍇ�͎����ċN���A����ȊO�͏I��
set Autorestart=1

rem count�ϐ��͋N���񐔂̕ێ��Ɏg���܂��B������Ȃ��ł��������B
set count=1

rem Soft�ϐ��͋N������jar�̖��O�ł��B
set Soft=JupiterX-Build-1.0.jar



goto Main

:Main
	if not exist %Soft% (
		goto Finish
	)
	
	cls
	chcp 932 > nul
	
	echo !count!��ڂ̋N���ł��B
	
	java -Djline.terminal=jline.UnsupportedTerminal -jar %Soft%
	
	goto END

:Finish
	echo %Soft%������܂���B
	echo �L�[�������ďI�����Ă��������B
	pause > nul

:END
	if %Autorestart%==0 (
		set /a count=!count!+1
		goto Main
	)

	timeout /t 1 > nul