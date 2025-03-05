package habitathealthsystem;

public class HabitatHealthSystem implements HabitatHealthService {
    @Override
    public void assessHabitat(int temperature, int humidity, int airQuality, double phLevel, int turbidity, int noiseLevel) {
        System.out.println("\n\t🌍 Habitat Health System Report:");
        System.out.println("\t\t\t🌡️ Temperature: " + temperature + "°C");
        System.out.println("\t\t\t💧 Humidity: " + humidity + "%");
        System.out.println("\t\t\t🌬️ Air Quality (CO₂): " + airQuality + " ppm");
        System.out.println("\t\t\t💧 Water Quality - pH: " + phLevel + ", Turbidity: " + turbidity + " NTU");
        System.out.println("\t\t\t🔊 Noise Level: " + noiseLevel + " dB");

        if (temperature > 30 || humidity > 70 || airQuality > 400 || phLevel < 6.5 || phLevel > 8.0 || turbidity > 50 || noiseLevel > 70) {
            System.out.println("\t\t\t🚨 Alert: Habitat Conditions are Suboptimal!");
        } else {
            System.out.println("\t\t\t✅ Habitat Conditions are Optimal.");
        }
    }
}