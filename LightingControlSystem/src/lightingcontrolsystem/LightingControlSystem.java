package lightingcontrolsystem;

public class LightingControlSystem implements LightingControlService {
    @Override
    public void adjustLighting(int lightIntensity, boolean motionDetected) {
        System.out.println("💡 Lighting Control System: Light Intensity=" + lightIntensity + "%, Motion Detected=" + motionDetected);
        if (lightIntensity < 50 || motionDetected) {
            System.out.println("💡 Lights ON - Low Light or Motion Detected.");
        } else {
            System.out.println("🌙 Lights OFF - Sufficient Light and No Motion.");
        }
    }
}