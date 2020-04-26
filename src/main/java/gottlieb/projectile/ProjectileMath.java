package gottlieb.projectile;

import java.lang.Math;
import java.util.*;
import java.util.Random;

public class ProjectileMath
{

    public static final int NUM_PROJECTILES = 5;

    public static void main(String[] args)
    {

        ArrayList<Projectile> projectileArray  =  new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < NUM_PROJECTILES; i++)
        {
            projectileArray.add(new Projectile(
                    rand.nextDouble() * 180,
                    rand.nextDouble() * 100));
        }

        int index = 0;

        for (Projectile proj : projectileArray)
        {

            System.out.println("Projectile " + (index + 1) + ":");

            for (int time = 0; time <= 12; time++)
            {
                proj.getX();
                proj.getY();

                System.out.println(proj.toString());
                proj.increaseTime(1);
            }

            index++;
        }
    }
}