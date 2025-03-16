package airqualitycontrolsystem;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import airqualitysensor.AirQualityService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        AirQualityControlSystem controlSystem = new AirQualityControlSystem();
        
        System.out.println("🚀 Air Quality Control System Bundle Started.");
        registration = context.registerService(AirQualityControlService.class.getName(), controlSystem, null);

        ServiceReference<?> ref = context.getServiceReference(AirQualityService.class.getName());
        if (ref != null) {
            AirQualityService airQualityService = (AirQualityService) context.getService(ref);
            controlSystem.adjustVentilation(airQualityService.getAirQuality());
        }

       
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Air Quality Control System Bundle Stopped.");
    }
}
