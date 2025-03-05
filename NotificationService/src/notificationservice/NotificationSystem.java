package notificationservice;


public class NotificationSystem implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("🔔 Notification: " + message);
    }
}