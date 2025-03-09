package habitathealthsystem;

import airqualitycontrolsystem.AirQualityControlService;
import climatecontrolsystem.ClimateControlService;
import noisemonitoringsystem.NoiseMonitoringService;
import watermanagementsystem.WaterManagementService;

public class HabitatHealthSystem implements HabitatHealthService {

    private AirQualityControlService airQualityControlService;
    private ClimateControlService climateControlService;
    private NoiseMonitoringService noiseMonitoringService;
    private WaterManagementService waterManagementService;

    // Setters for the control services
    public void setAirQualityControlService(AirQualityControlService airQualityControlService) {
        this.airQualityControlService = airQualityControlService;
    }

    public void setClimateControlService(ClimateControlService climateControlService) {
        this.climateControlService = climateControlService;
    }

    public void setNoiseMonitoringService(NoiseMonitoringService noiseMonitoringService) {
        this.noiseMonitoringService = noiseMonitoringService;
    }

    public void setWaterManagementService(WaterManagementService waterManagementService) {
        this.waterManagementService = waterManagementService;
    }

    @Override
    public void assessHabitat() {
        // Fetch data from the control systems
        int airQuality = airQualityControlService.getAirQuality();
        int temperature = climateControlService.getTemperature();
        int humidity = climateControlService.getHumidity();
        double phLevel = waterManagementService.getPHLevel();
        int turbidity = waterManagementService.getTurbidity();
        int noiseLevel = noiseMonitoringService.getNoiseLevel();

        // Display the habitat health report
        System.out.println("\n🌍 Habitat Health System Report:");
        System.out.println("🌡️ Temperature: " + temperature + "°C");
        System.out.println("💧 Humidity: " + humidity + "%");
        System.out.println("🌬️ Air Quality (CO₂): " + airQuality + " ppm");
        System.out.println("💧 Water Quality - pH: " + phLevel + ", Turbidity: " + turbidity + " NTU");
        System.out.println("🔊 Noise Level: " + noiseLevel + " dB");

        // Adjust systems based on the fetched data
      
        airQualityControlService.adjustVentilation(airQuality);
    
        climateControlService.adjustClimate(temperature, humidity);
       
        noiseMonitoringService.monitorNoise(noiseLevel);
      
        waterManagementService.manageWater(phLevel, turbidity);

        // Check overall habitat conditions
        if (temperature > 30 || humidity > 70 || airQuality > 400 || phLevel < 6.5 || phLevel > 8.0 || turbidity > 50 || noiseLevel > 70) {
            System.out.println("\n🚨 Alert: Habitat Conditions are poor!");
        } else {
            System.out.println("\n✅ Habitat Conditions are Optimal.");
        }
    }

	
}