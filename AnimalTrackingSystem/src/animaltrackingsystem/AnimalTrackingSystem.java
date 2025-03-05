package animaltrackingsystem;

public class AnimalTrackingSystem implements AnimalTrackingService {
    @Override
    public void trackAnimals(boolean motionDetected, boolean imageCaptured, int detectionCount) {
        System.out.println("🦌 Animal Tracking System: Motion Detected=" + motionDetected + ", Image Captured=" + imageCaptured);
        if (motionDetected && imageCaptured) {
            System.out.println("📝 Logging Animal Activity... (Detection #" + detectionCount + ")");
        }
    }
}