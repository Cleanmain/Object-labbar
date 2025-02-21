import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private final Map<Class<? extends Vehicle>, BufferedImage> vehicleImages = new HashMap<>();
    private final List<Vehicle> vehicles;
    private BufferedImage workshopImage;
    private final Point workshopPosition = new Point(300, 300);

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;

    // To keep track of a single car's position
    Point volvoPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(Vehicle vehicle, int x, int y){
        vehicle.x = x;
        vehicle.y = y;
        //Vehicle vehicle i movit

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, List<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = vehicles; // Store the reference

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle v : vehicles) { // ✅ Loop through actual vehicles, NOT vehicleImages
            BufferedImage img = vehicleImages.get(v.getClass()); // Get the correct image
            if (img != null) {
                g.drawImage(img, (int) v.x, (int) v.y, null); // ✅ Now it correctly uses vehicle positions
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);



    }
}

