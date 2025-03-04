package securitysystem;

public interface SecurityService {
    void monitorArea(boolean motionDetected, boolean imageCaptured, int lightIntensity);
}