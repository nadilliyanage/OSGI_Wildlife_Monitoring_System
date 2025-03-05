package noisemonitoringsystem;

public class NoiseMonitoringSystem implements NoiseMonitoringService {
    @Override
    public void monitorNoise(int noiseLevel) {
        System.out.println("🔊 Noise Monitoring System: Noise Level is " + noiseLevel + " dB");
        if (noiseLevel > 70) {
            System.out.println("🚨 Noise Alert - High Noise Levels Detected!");
        } else {
            System.out.println("✅ Noise Levels Normal.");
        }
    }
}