package securitysystem;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import animalmotionsensor.AnimalMotionService;
import camerasensor.CameraService;
import noisesensor.NoiseService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        SecuritySystem securitySystem = new SecuritySystem();
        registration = context.registerService(SecurityService.class.getName(), securitySystem, null);

        ServiceReference<?> motionRef = context.getServiceReference(AnimalMotionService.class.getName());
        ServiceReference<?> cameraRef = context.getServiceReference(CameraService.class.getName());
        ServiceReference<?> noiseRef = context.getServiceReference(NoiseService.class.getName());

        if (motionRef != null && cameraRef != null && noiseRef != null) {
            AnimalMotionService motionService = (AnimalMotionService) context.getService(motionRef);
            CameraService cameraService = (CameraService) context.getService(cameraRef);
            NoiseService noiseService = (NoiseService) context.getService(noiseRef);
            securitySystem.monitorArea(motionService.detectAnimalMotion(), cameraService.captureImage(), noiseService.getNoiseLevel());
        }

        System.out.println("🚀 Security System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Security System Bundle Stopped.");
    }
}