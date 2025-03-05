package noisesensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        NoiseSensor sensor = new NoiseSensor();
        registration = context.registerService(NoiseService.class.getName(), sensor, null);
        System.out.println("🚀 Noise Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Noise Sensor Bundle Stopped.");
    }
}
