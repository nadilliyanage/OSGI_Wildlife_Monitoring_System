package animaltrackingsystem;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import animalmotionsensor.AnimalMotionService;
import camerasensor.CameraService;
import notificationservice.NotificationService;

public class Activator implements BundleActivator {
    private ServiceRegistration<?> registration;
    private MonitoringThread monitoringThread;
    private volatile boolean running;

    @Override
    public void start(BundleContext context) {
        AnimalTrackingSystem trackingSystem = new AnimalTrackingSystem();
        registration = context.registerService(AnimalTrackingService.class.getName(), trackingSystem, null);

        ServiceReference<?> motionRef = context.getServiceReference(AnimalMotionService.class.getName());
        ServiceReference<?> cameraRef = context.getServiceReference(CameraService.class.getName());
        ServiceReference<?> notificationRef = context.getServiceReference(NotificationService.class.getName());

        if (motionRef != null && cameraRef != null && notificationRef != null) {
            AnimalMotionService motionService = (AnimalMotionService) context.getService(motionRef);
            CameraService cameraService = (CameraService) context.getService(cameraRef);
            NotificationService notificationService = (NotificationService) context.getService(notificationRef);

            // Start the monitoring loop
            running = true;
            monitoringThread = new MonitoringThread(motionService, cameraService, notificationService, trackingSystem);
            monitoringThread.start();
        }

        System.out.println("🚀 Animal Tracking System Bundle Started.");
    }

    @Override
    public void stop(BundleContext context) {
        // Stop the monitoring loop
        running = false;
        if (monitoringThread != null) {
            monitoringThread.interrupt();
        }
        registration.unregister();
        System.out.println("🛑 Animal Tracking System Bundle Stopped.");
    }

    private class MonitoringThread extends Thread {
        private AnimalMotionService motionService;
        private CameraService cameraService;
        private NotificationService notificationService;
        private AnimalTrackingSystem trackingSystem;

        public MonitoringThread(AnimalMotionService motionService, CameraService cameraService, NotificationService notificationService, AnimalTrackingSystem trackingSystem) {
            this.motionService = motionService;
            this.cameraService = cameraService;
            this.notificationService = notificationService;
            this.trackingSystem = trackingSystem;
        }

        @Override
        public void run() {
            int detectionCount = 0;
            while (running) {
                boolean motionDetected = motionService.detectAnimalMotion();

                if (motionDetected) {
                    boolean imageCaptured = cameraService.captureImage();

                    if (imageCaptured) {
                        detectionCount++;
                        trackingSystem.trackAnimals(motionDetected, imageCaptured, detectionCount);
                        notificationService.sendNotification("Animal Detected and Image Captured! (Detection #" + detectionCount + ")\n");
                    } else {
                        System.out.println("📷 Motion Detected, but Image Capture Failed.\n");
                    }
                } else {
                    System.out.println("📝 No Animal Activity Detected.\n");
                }

                try {
                    // Check every 5 seconds
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // Gracefully exit if interrupted
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}