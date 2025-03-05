package waterqualitysensor;

import java.util.Random;

public class WaterQualitySensor implements WaterQualityService {
    private Random random = new Random();

    @Override
    public double getPHLevel() {
        double phLevel = 6.5 + random.nextDouble() * 1.5; // pH level between 6.5 and 8.0
        System.out.println("💧 Water Quality Sensor: pH Level is " + phLevel);
        return phLevel;
    }

    @Override
    public int getTurbidity() {
        int turbidity = random.nextInt(100); // Turbidity in NTU (Nephelometric Turbidity Units)
        System.out.println("💧 Water Quality Sensor: Turbidity is " + turbidity + " NTU");
        return turbidity;
    }
}