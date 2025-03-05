package notificationservice;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        NotificationService notificationService = new NotificationSystem();
        registration = context.registerService(NotificationService.class.getName(), notificationService, null);
        System.out.println("🚀 Notification Service Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Notification Service Bundle Stopped.");
    }
}
