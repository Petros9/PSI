import java.util.Random;

public class Asteroid {
    public int asteroidX;
    public int asteroidY;
    Random generator = new Random();

    public Asteroid() {
        asteroidX = generator.nextInt(200) - 100;
        asteroidY = 100;
    }

    public void update(FuzzyRocket rocket) {
        if (asteroidY < 200) {
            asteroidY++;
        } else {
            if (rocket.rocketX > 0)
                asteroidX = Double.valueOf(rocket.rocketX).intValue() + generator.nextInt(50);
            else
                asteroidX = Double.valueOf(rocket.rocketX).intValue() - generator.nextInt(50);
            asteroidY = 0;
        }
    }
}