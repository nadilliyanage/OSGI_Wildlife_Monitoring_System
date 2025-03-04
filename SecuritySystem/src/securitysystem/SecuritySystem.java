package securitysystem;

public class SecuritySystem implements SecurityService {
    @Override
    public void monitorArea(boolean motionDetected, boolean imageCaptured, int lightIntensity) {
        System.out.println("🚨 Security System: Motion Detected=" + motionDetected + ", Image Captured=" + imageCaptured + ", Light Intensity=" + lightIntensity + "%");
        if (motionDetected && imageCaptured) {
            System.out.println("🚨 Intruder Alert - Potential Poacher Detected!");
        } else {
            System.out.println("✅ No Intruders Detected.");
        }
    }
}