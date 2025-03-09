package airqualitycontrolsystem;

public class AirQualityControlSystem implements AirQualityControlService {
    private int airQuality;

    @Override
    public void adjustVentilation(int airQuality) {
        this.airQuality = airQuality; // Update air quality data
        System.out.println("🌬️ Air Quality Control System: CO₂ Level is " + airQuality + " ppm");
        if (airQuality > 400) {
            System.out.println("🌀 Ventilation ON - High CO₂ Levels.");
        } else {
            System.out.println("🌬️ Ventilation OFF - Optimal Air Quality.");
        }
    }

    @Override
    public int getAirQuality() {
        return airQuality; // Return the current air quality
    }
}