package humiditysensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        HumiditySensor sensor = new HumiditySensor();
        registration = context.registerService(HumidityService.class.getName(), sensor, null);
        System.out.println("🚀 Humidity Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Humidity Sensor Bundle Stopped.");
    }
}