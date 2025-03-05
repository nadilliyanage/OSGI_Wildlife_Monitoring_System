package securitysystem;


public class SecuritySystem implements SecurityService {
    @Override
    public void monitorArea(boolean motionDetected, boolean imageCaptured, int noiseLevel) {
        System.out.println("🚨 Security System: Motion Detected=" + motionDetected + ", Image Captured=" + imageCaptured + ", Noise Level=" + noiseLevel + " dB");
        if (motionDetected && imageCaptured && noiseLevel > 70) {
            System.out.println("🚨 Intruder Alert - Potential Threat Detected!");
        } else {
            System.out.println("✅ No Threats Detected.");
        }
    }
}