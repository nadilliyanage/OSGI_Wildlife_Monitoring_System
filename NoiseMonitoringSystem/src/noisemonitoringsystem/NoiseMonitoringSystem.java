package noisemonitoringsystem;

public class NoiseMonitoringSystem implements NoiseMonitoringService {
    private int noiseLevel; 
    @Override
    public void monitorNoise(int noiseLevel) {
        this.noiseLevel = noiseLevel; // Update noise level data
        System.out.println("🔊 Noise Monitoring System: Noise Level is " + noiseLevel + " dB");
        if (noiseLevel > 70) {
            System.out.println("🚨 Noise Alert - High Noise Levels Detected!");
        } else {
            System.out.println("✅ Noise Levels Normal.");
        }
    }

    @Override
    public int getNoiseLevel() {
        return noiseLevel; // Return the current noise level
    }
}