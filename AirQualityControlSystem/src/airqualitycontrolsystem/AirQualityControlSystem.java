package airqualitycontrolsystem;


public class AirQualityControlSystem implements AirQualityControlService {
    @Override
    public void adjustVentilation(int airQuality) {
        System.out.println("🌬️ Air Quality Control System: CO₂ Level is " + airQuality + " ppm");
        if (airQuality > 400) {
            System.out.println("🌀 Ventilation ON - High CO₂ Levels.");
        } else {
            System.out.println("🌬️ Ventilation OFF - Optimal Air Quality.");
        }
    }
}