package waterqualitysensor;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        WaterQualitySensor sensor = new WaterQualitySensor();
        registration = context.registerService(WaterQualityService.class.getName(), sensor, null);
        System.out.println("🚀 Water Quality Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Water Quality Sensor Bundle Stopped.");
    }
}