package cs.vsu.ru.skogorevma.gr12;

public class DefaultParabola {
    public double x0;
    public double y0;
    public double a;
    public DefaultParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointAboveOfParabola(double x, double y) {
        return y > a * Math.pow(x - x0, 2) + y0;
    }
}
