package noisemonitoringsystem;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import noisesensor.NoiseService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
    	System.out.println("🚀 Noise Monitoring System Bundle Started.");
        NoiseMonitoringSystem noiseSystem = new NoiseMonitoringSystem();
        registration = context.registerService(NoiseMonitoringService.class.getName(), noiseSystem, null);

        ServiceReference<?> ref = context.getServiceReference(NoiseService.class.getName());
        if (ref != null) {
            NoiseService noiseService = (NoiseService) context.getService(ref);
            noiseSystem.monitorNoise(noiseService.getNoiseLevel());
        }
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Noise Monitoring System Bundle Stopped.");
    }
}
