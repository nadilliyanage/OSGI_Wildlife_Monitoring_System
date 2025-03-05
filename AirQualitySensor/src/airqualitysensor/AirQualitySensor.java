package airqualitysensor;

import java.util.Random;

public class AirQualitySensor implements AirQualityService {
    private Random random = new Random();

    @Override
    public int getAirQuality() {
        int airQuality = random.nextInt(500); // CO₂ levels in ppm
        System.out.println("🌬️ Air Quality Sensor: CO₂ Level is " + airQuality + " ppm");
        return airQuality;
    }
}