package temperaturesensor;
	
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        TemperatureSensor sensor = new TemperatureSensor();
        registration = context.registerService(TemperatureService.class.getName(), sensor, null);
        System.out.println("🚀 Temperature Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Temperature Sensor Bundle Stopped.");
    }
}
