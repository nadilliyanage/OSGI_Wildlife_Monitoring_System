package watermanagementsystem;

public interface WaterManagementService {
    void manageWater(double phLevel, int turbidity);

	double getPHLevel();

	int getTurbidity();
}
