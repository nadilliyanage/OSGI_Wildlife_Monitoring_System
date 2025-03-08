package climatecontrolsystem;

public class ClimateControlSystem implements ClimateControlService {

    @Override
    public void adjustClimate(int temperature, int humidity) {
        System.out.println("🔍 Received Data -> Temperature: " + temperature + "°C, Humidity: " + humidity + "%");

        // Checking temperature conditions
        if (temperature > 25) {
            System.out.println("🔥 Warning: Temperature is above optimal range! ( > 25°C )");
        } else {
            System.out.println("✅ Temperature is within the optimal range.");
        }

        // Checking humidity conditions
        if (humidity > 60) {
            System.out.println("💧 Warning: Humidity is above optimal range! ( > 60% )");
        } else {
            System.out.println("✅ Humidity is within the optimal range.");
        }

        // Deciding whether to activate climate control
        if (temperature > 25 || humidity > 60) {
            System.out.println("🌬️ Climate Control ON - Adjusting Environment...");
            System.out.println("⚙️ Adjusting temperature and humidity levels...");
            System.out.println("🔄 System is actively regulating climate.");
        } else {
            System.out.println("🌿 Climate Control OFF - Conditions are optimal.");
            System.out.println("🛑 No adjustments needed.");
        }

        System.out.println("✅ Climate control processing completed.\n");
    }
}