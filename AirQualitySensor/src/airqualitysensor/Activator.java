package airqualitysensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        AirQualitySensor sensor = new AirQualitySensor();
        registration = context.registerService(AirQualityService.class.getName(), sensor, null);
        System.out.println("🚀 Air Quality Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Air Quality Sensor Bundle Stopped.");
    }
}
