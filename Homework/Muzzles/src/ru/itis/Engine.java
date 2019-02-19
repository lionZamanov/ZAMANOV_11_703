package ru.itis;

class Engine {
    private static final double G = 50;
    private static final double SPEED = 0.7;

    double[] getCoordinatesByVector(double speed, double windResist, double mass, double angle, double time){
        double m = mass;
        double k = windResist;
        double v0 = speed;
        double v0x = v0 * Math.cos(angle * Math.PI / 180);
        double v0y = v0 * Math.sin(angle* Math.PI / 180);
        double x = (v0x * m / k) * (1 - Math.pow(Math.E, -k * time / m));
        double y = (-m / k) * ((v0y + m * G / k) * (1 - Math.pow(Math.E, -k * time / m)) - G * time);
        double[] result = {x, y};
        return result;
    }
}
