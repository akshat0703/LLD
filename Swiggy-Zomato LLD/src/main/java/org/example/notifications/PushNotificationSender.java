package org.example.notifications;

public class PushNotificationSender implements INotificationSender {

    @Override
    public void sendNotification(String userId, String mssg) {
        System.out.println("Push Notification for: " + userId + " is: " + mssg);
    }
}
