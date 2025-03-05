package watermanagementsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import waterqualitysensor.WaterQualityService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext context) {
        WaterManagementSystem waterSystem = new WaterManagementSystem();
        registration = context.registerService(WaterManagementService.class.getName(), waterSystem, null);

        ServiceReference<?> ref = context.getServiceReference(WaterQualityService.class.getName());
        if (ref != null) {
            WaterQualityService waterQualityService = (WaterQualityService) context.getService(ref);
            waterSystem.manageWater(waterQualityService.getPHLevel(), waterQualityService.getTurbidity());
        }

        System.out.println("🚀 Water Management System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        registration.unregister();
        System.out.println("🛑 Water Management System Bundle Stopped.");
    }
}
