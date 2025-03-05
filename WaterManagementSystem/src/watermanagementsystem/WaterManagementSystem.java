package watermanagementsystem;


public class WaterManagementSystem implements WaterManagementService {
    @Override
    public void manageWater(double phLevel, int turbidity) {
        System.out.println("💧 Water Management System: pH Level is " + phLevel + ", Turbidity is " + turbidity + " NTU");
        if (phLevel < 6.8 || phLevel > 7.8 || turbidity > 50) {
            System.out.println("🚿 Water Treatment ON - Poor Water Quality Detected.");
        } else {
            System.out.println("🚿 Water Treatment OFF - Optimal Water Quality.");
        }
    }
}