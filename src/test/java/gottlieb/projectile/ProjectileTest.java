package gottlieb.projectile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectileTest
{
    @Test
    public void getX()
    {
        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        //when
        double x = projectile.getX();

        //then
        assertEquals(245.2557, x, 0.0001);
    }

    @Test
    public void getY()
    {
        //given
        Projectile projectile = new Projectile(53.26, 82);
        projectile.increaseTime(5);

        //when
        double y = projectile.getY();

        //then
        assertEquals(83.5568, y, 0.0001);
    }

    @Test
    public void increaseTime()
    {
        //given
        Projectile projectile = new Projectile(53.26, 82);

        //when
        double time = projectile.increaseTime(5);

        //then
        assertEquals(5.0, time, 0.1);

        //when
        time = projectile.increaseTime(3);

        //then
        assertEquals(8.0, time, 0.1);

        //when
        time = projectile.increaseTime(-4);

        //then
        assertEquals(4.0, time, 0.1);
    }
}

