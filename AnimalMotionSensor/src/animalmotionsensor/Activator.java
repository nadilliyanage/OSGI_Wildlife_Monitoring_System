package animalmotionsensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        AnimalMotionSensor sensor = new AnimalMotionSensor();
        registration = context.registerService(AnimalMotionService.class.getName(), sensor, null);
        System.out.println("🚀 Animal Motion Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Animal Motion Sensor Bundle Stopped.");
    }
}
