package animaltrackingsystem;

public class AnimalTrackingSystem implements AnimalTrackingService {
    @Override
    public void trackAnimals(boolean motionDetected, boolean imageCaptured) {
        System.out.println("🦌 Animal Tracking System: Motion Detected=" + motionDetected + ", Image Captured=" + imageCaptured);
        if (motionDetected && imageCaptured) {
            System.out.println("📝 Logging Rare Animal Activity...");
        } else {
            System.out.println("📝 No Rare Animal Activity Detected.");
        }
    }
}