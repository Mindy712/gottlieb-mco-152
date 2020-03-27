package gottlieb.projectile;

public class Projectile
{
    private static final double EARTH_GRAVITY = -9.8;
    private final double angle;
    private final double velocity;
    private double time;

    public Projectile(double angle, double velocity) {
        this.angle = Math.toRadians(angle);
        this.velocity = velocity;
    }

    public double getX()
    {
        return velocity * Math.cos(angle) * time;

    }

    public double getY()
    {
        return velocity * Math.sin(angle) * time + (EARTH_GRAVITY * time * time);

    }

    public double increaseTime(int delta)
    {
        this.time += delta;
        return time;
    }

    public String toString()
    {
        return time + ": (" + String.format("%.4f", getX()) + "," + String.format("%.4f", getY()) + ")";
    }
}
