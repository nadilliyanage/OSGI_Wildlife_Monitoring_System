package lightsensor;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        LightSensor sensor = new LightSensor();
        registration = context.registerService(LightService.class.getName(), sensor, null);
        System.out.println("🚀 Light Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Light Sensor Bundle Stopped.");
    }
}
