package climatecontrolsystem;

public class ClimateControlSystem implements ClimateControlService {
    @Override
    public void adjustClimate(int temperature, int humidity) {
        System.out.println("🌡️ Climate Control System: Temperature=" + temperature + "°C, Humidity=" + humidity + "%");
        if (temperature > 25 || humidity > 60) {
            System.out.println("🌬️ Climate Control ON - Adjusting Environment.");
        } else {
            System.out.println("🌿 Climate Control OFF - Optimal Conditions.");
        }
    }
}