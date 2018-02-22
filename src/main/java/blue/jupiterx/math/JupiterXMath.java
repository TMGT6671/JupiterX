package blue.jupiterx.math;

/**     _             _ _          __  __
 *     | |_   _ _ __ (_) |_ ___ _ _\ \/ /
 *  _  | | | | | '_ \| | __/ _ \ '__\  /
 * | |_| | |_| | |_) | | ||  __/ |  /  \
 *  \___/ \__,_| .__/|_|\__\___|_| /_/\_\
 *             |_|
 *
 * These codes are from PocketMine-MP.
 *
 * JupiterX Project
 *
 * @author JupiterDevelopmentTeam
 * @link http://jupiterx.blue
 */

import java.util.ArrayList;

/**
 * Math related classes, like matrices, bounding boxes and vector
 */
public class JupiterXMath {
    
    public static int floorFloat(float n) {
        int i = (int) n;
        return n >= i ? i : i -1;
    }
    
    public static int celiFloat(float n) {
        int i = (int) (n + 1);
        return n >= i ? i : i -1;
    }
    
    public static ArrayList<Float> solveQuadrotic(float a, float b, float c) {
        ArrayList<Float> result = null;
        float discriminant = (float) (Math.pow(b, 2) - 4 * a * c);
        if(discriminant > 0) {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            result.add((float) ((-b + sqrtDiscriminant) / (2 * a)));
            result.add((float) ((-b - sqrtDiscriminant) / (2 * a)));
            return result;
        } else if(discriminant == 0) {
            result.add(-b / (2 * a));
        } else {
            return result;
        }
        return null;
    }
}