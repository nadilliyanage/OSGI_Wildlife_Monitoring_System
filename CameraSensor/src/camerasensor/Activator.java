package camerasensor;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        CameraSensor sensor = new CameraSensor();
        registration = context.registerService(CameraService.class.getName(), sensor, null);
        System.out.println("🚀 Camera Sensor Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Camera Sensor Bundle Stopped.");
    }
}
