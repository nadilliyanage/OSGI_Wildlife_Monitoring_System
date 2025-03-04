package camerasensor;


import java.util.Random;

public class CameraSensor implements CameraService {
    private Random random = new Random();

    @Override
    public boolean captureImage() {
        boolean imageCaptured = random.nextBoolean();
        System.out.println("📷 Camera Sensor: " + (imageCaptured ? "Image Captured!" : "No Image Captured."));
        return imageCaptured;
    }
}
