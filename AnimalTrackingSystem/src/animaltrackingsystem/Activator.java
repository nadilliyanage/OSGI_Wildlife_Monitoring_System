package animaltrackingsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import animalmotionsensor.AnimalMotionService;
import camerasensor.CameraService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        AnimalTrackingSystem trackingSystem = new AnimalTrackingSystem();
        registration = context.registerService(AnimalTrackingService.class.getName(), trackingSystem, null);

        ServiceReference<?> motionRef = context.getServiceReference(AnimalMotionService.class.getName());
        ServiceReference<?> cameraRef = context.getServiceReference(CameraService.class.getName());

        if (motionRef != null && cameraRef != null) {
            AnimalMotionService motionService = (AnimalMotionService) context.getService(motionRef);
            CameraService cameraService = (CameraService) context.getService(cameraRef);
            trackingSystem.trackAnimals(motionService.detectAnimalMotion(), cameraService.captureImage());
        }

        System.out.println("🚀 Animal Tracking System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Animal Tracking System Bundle Stopped.");
    }
}