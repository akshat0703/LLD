package org.example.notifications;

public interface INotificationSender {
    void sendNotification(String orderId, String mssg);
}
