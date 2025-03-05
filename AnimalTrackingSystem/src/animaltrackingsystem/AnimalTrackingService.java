package animaltrackingsystem;


public interface AnimalTrackingService {
    void trackAnimals(boolean motionDetected, boolean imageCaptured, int detectionCount);
}