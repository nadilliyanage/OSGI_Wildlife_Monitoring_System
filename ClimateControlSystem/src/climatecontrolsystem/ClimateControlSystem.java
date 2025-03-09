package climatecontrolsystem;

public class ClimateControlSystem implements ClimateControlService {
    private int temperature; 
    private int humidity; 

    @Override
    public void adjustClimate(int temperature, int humidity) {
        this.temperature = temperature; // Update temperature data
        this.humidity = humidity; // Update humidity data
        System.out.println("🔍 Received Data -> Temperature: " + temperature + "°C, Humidity: " + humidity + "%");

        if (temperature > 25) {
            System.out.println("🔥 Warning: Temperature is above optimal range! ( > 25°C )");
        } else {
            System.out.println("✅ Temperature is within the optimal range.");
        }

        if (humidity > 60) {
            System.out.println("💧 Warning: Humidity is above optimal range! ( > 60% )");
        } else {
            System.out.println("✅ Humidity is within the optimal range.");
        }

        if (temperature > 25 || humidity > 60) {
            System.out.println("🌬️ Climate Control ON - Adjusting Environment...");
        } else {
            System.out.println("🌿 Climate Control OFF - Conditions are optimal.");
        }
    }

    @Override
    public int getTemperature() {
        return temperature; // Return the current temperature
    }

    @Override
    public int getHumidity() {
        return humidity; // Return the current humidity
    }
}