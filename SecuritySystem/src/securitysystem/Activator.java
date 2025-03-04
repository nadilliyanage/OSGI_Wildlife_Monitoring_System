package securitysystem;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import animalmotionsensor.AnimalMotionService;
import camerasensor.CameraService;
import lightsensor.LightService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        SecuritySystem securitySystem = new SecuritySystem();
        registration = context.registerService(SecurityService.class.getName(), securitySystem, null);

        ServiceReference<?> motionRef = context.getServiceReference(AnimalMotionService.class.getName());
        ServiceReference<?> cameraRef = context.getServiceReference(CameraService.class.getName());
        ServiceReference<?> lightRef = context.getServiceReference(LightService.class.getName());

        if (motionRef != null && cameraRef != null && lightRef != null) {
            AnimalMotionService motionService = (AnimalMotionService) context.getService(motionRef);
            CameraService cameraService = (CameraService) context.getService(cameraRef);
            LightService lightService = (LightService) context.getService(lightRef);
            securitySystem.monitorArea(motionService.detectAnimalMotion(), cameraService.captureImage(), lightService.getLightIntensity());
        }

        System.out.println("🚀 Security System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Security System Bundle Stopped.");
    }
}
