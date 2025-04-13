package org.example.notifications;

import org.example.utils.Pair;

import java.util.*;

public class NotificationMgr {
    private NotificationMgr() {
        notificationSendersMap = new HashMap<>();
    }

    private static NotificationMgr notificationMgrInstance;
    private HashMap<String, List<Pair<String, INotificationSender>>> notificationSendersMap;

    public static NotificationMgr getNotificationMgr() {
        if(notificationMgrInstance == null) {
            notificationMgrInstance = new NotificationMgr();
        }
        return notificationMgrInstance;
    }

    // register observer
    public void addNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        Pair<String, INotificationSender> matchingPair = new Pair<>(userId, notificationSender);
        if(notificationSendersMap.get(orderId) == null) {
            notificationSendersMap.put(orderId, new ArrayList<>(List.of(matchingPair)));
        } else {
            Optional<Pair<String, INotificationSender>> sender = notificationSendersMap.get(orderId).stream()
                    .filter(entry -> Objects.equals(entry, matchingPair)).findFirst();
            if (sender.isEmpty()) {
                // making sure the sender is already not there in List
                // If this check is not put, then multiple notifications will be sent by the same sender
                notificationSendersMap.get(orderId).add(matchingPair);
            }
        }
    }

    // unregister observer
    public void removeNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        Pair<String, INotificationSender> matchingPair = new Pair<>(userId, notificationSender);
        Optional<Pair<String, INotificationSender>> sender = notificationSendersMap.get(orderId).stream()
                .filter(entry -> Objects.equals(entry, matchingPair)).findFirst();

        if(sender.isPresent()) {
            notificationSendersMap.get(orderId).remove(sender.get());
        }
    }

    // notify observers
    public void notify(String orderId, String mssg) {
        notificationSendersMap.get(orderId)
                .forEach(sender -> sender.second().sendNotification(sender.first(), mssg));
    }

    // notify particular user by a particular method
    public void notifyParticularUser(String userId, String mssg, INotificationSender notificationSender) {
        notificationSender.sendNotification(userId, mssg);
    }
}
