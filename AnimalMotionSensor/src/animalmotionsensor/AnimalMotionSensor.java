package animalmotionsensor;

import java.util.Random;

public class AnimalMotionSensor implements AnimalMotionService {
    private Random random = new Random();

    @Override
    public boolean detectAnimalMotion() {
        boolean motionDetected = random.nextBoolean();
        System.out.println("🦌 Animal Motion Sensor: " + (motionDetected ? "Animal Detected!" : "No Animal Movement."));
        return motionDetected;
    }
}