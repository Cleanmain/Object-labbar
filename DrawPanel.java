import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.
public class DrawPanel extends JPanel {
    private final Map<Class<? extends MotorVehicle>, BufferedImage> vehicleImages = new HashMap<>();
    private final List<MotorVehicle> vehicles;

    private BufferedImage volvoWorkshopImage;
    private final Point volvoWorkshopPoint = new Point(300, 300);

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, VehicleTracker tracker) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.vehicles = tracker.getVehicles(); // ✅ Now works correctly

        // ✅ Move try-catch inside the constructor
        try {
            vehicleImages.put(Volvo240.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.put(Saab95.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.put(Scania.class, ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Moves the vehicle to a new position
    //void moveit(MotorVehicle vehicle, int x, int y) {
        //vehicle.x = x;
       // vehicle.y = y;

   // }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MotorVehicle car : vehicles) {
            BufferedImage img = vehicleImages.get(car.getClass());
            if (img != null) {
                g.drawImage(img, (int) (car.x), (int) car.y, null);
            }
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
