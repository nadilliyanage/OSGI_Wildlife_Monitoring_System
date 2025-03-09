package watermanagementsystem;

public class WaterManagementSystem implements WaterManagementService {
    private double phLevel;
    private int turbidity;

    @Override
    public void manageWater(double phLevel, int turbidity) {
        this.phLevel = phLevel; // Update pH level data
        this.turbidity = turbidity; // Update turbidity data
        System.out.println("💧 Water Management System: pH Level is " + phLevel + ", Turbidity is " + turbidity + " NTU");
        if (phLevel < 6.8 || phLevel > 7.8 || turbidity > 50) {
            System.out.println("🚿 Water Treatment ON - Poor Water Quality Detected.");
        } else {
            System.out.println("🚿 Water Treatment OFF - Optimal Water Quality.");
        }
    }

    @Override
    public double getPHLevel() {
        return phLevel; // Return the current pH level
    }

    @Override
    public int getTurbidity() {
        return turbidity; // Return the current turbidity
    }
}