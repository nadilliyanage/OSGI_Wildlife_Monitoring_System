package habitathealthsystem;


public interface HabitatHealthService {
    void assessHabitat(int temperature, int humidity, int airQuality, double phLevel, int turbidity, int noiseLevel);
}