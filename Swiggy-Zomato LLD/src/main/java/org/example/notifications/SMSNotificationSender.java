package org.example.notifications;

public class SMSNotificationSender implements INotificationSender {

    @Override
    public void sendNotification(String userId, String mssg) {
        System.out.println("SMS Notification for: " + userId + " is: " + mssg);
    }
}
