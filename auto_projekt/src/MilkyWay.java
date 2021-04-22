import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MilkyWay extends JPanel {

    FuzzyRocket rocket;
    Asteroid asteroid;

    public MilkyWay() {
        asteroid = new Asteroid();
        rocket = new FuzzyRocket();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage rocketImage = null;
        BufferedImage asteroidImage = null;
        BufferedImage spaceImage = null;
        try {
            rocketImage = ImageIO.read(new File("src/rocket.png"));
            asteroidImage = ImageIO.read(new File("src/asteroid.png"));
            spaceImage = ImageIO.read(new File("src/space.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        asteroid.update(rocket);
        rocket.update(asteroid);
        g.drawImage(spaceImage, 0, 0, null);
        g.drawImage(asteroidImage, asteroid.asteroidX + 200, asteroid.asteroidY, null);
        g.drawImage(rocketImage, Double.valueOf(rocket.rocketX).intValue() + 200, 178, null);
    }
}