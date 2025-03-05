package noisesensor;

import java.util.Random;

public class NoiseSensor implements NoiseService {
    private Random random = new Random();

    @Override
    public int getNoiseLevel() {
        int noiseLevel = random.nextInt(100); // Noise level in decibels
        System.out.println("🔊 Noise Sensor: Noise Level is " + noiseLevel + " dB");
        return noiseLevel;
    }
}