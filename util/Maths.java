package util;

import java.lang.Math;

public class Maths {
    
    public static final float PI = 3.14159F;
    public static final float INF = (float)1.0E6;

    public static float degreeToRadians (float angle){
        return (PI/180.0F) * angle;
    }

    public static float cos (float angle) {
        float _angle = degreeToRadians(angle);
        return (float) Math.cos(_angle);
    }

    public static float sin (float angle) {
        float _angle = degreeToRadians(angle);
        return (float) Math.sin(_angle);
    }

    public static float tan (float angle) {
        if (angle == 0.0F || angle == 180.0F) return (float)1.0/INF;
        if (angle == 90.0F || angle == 270.0F) return INF;
        return sin(angle)/cos(angle);
    }

    public static float absolute (float number){
        if (number > 0.0F) return number;
        else return -1.0F * number;
    }

    public static float sqrt (float number){
        return (float)Math.sqrt((double)number);
    }

    public static float distance (float x1, float y1, float x2, float y2) {
        float distSquared = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
        if (distSquared < 0) return INF;
        float dist =  sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        if (dist > INF) return (float)INF;
        else return dist;
    }

    public static float shiftAngleInRange(float angle){
        if (angle < 0.0F) angle += 360.0F;
        else if (angle > 360.0F) angle -= 360.0F;
        return angle;
    }
}
