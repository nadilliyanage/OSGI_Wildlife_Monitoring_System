package lightingcontrolsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import lightsensor.LightService;
import animalmotionsensor.AnimalMotionService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        LightingControlSystem lightingControl = new LightingControlSystem();
        System.out.println("🚀 Lighting Control System Bundle Started.");
        registration = context.registerService(LightingControlService.class.getName(), lightingControl, null);

        ServiceReference<?> lightRef = context.getServiceReference(LightService.class.getName());
        ServiceReference<?> motionRef = context.getServiceReference(AnimalMotionService.class.getName());

        if (lightRef != null && motionRef != null) {
            LightService lightService = (LightService) context.getService(lightRef);
            AnimalMotionService motionService = (AnimalMotionService) context.getService(motionRef);
            lightingControl.adjustLighting(lightService.getLightIntensity(), motionService.detectAnimalMotion());
        }

        
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Lighting Control System Bundle Stopped.");
    }
}