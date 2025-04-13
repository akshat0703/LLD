package org.example;

import org.example.delivery.DeliveryMetaData;
import org.example.delivery.DeliveryMgr;
import org.example.notifications.NotificationMgr;
import org.example.notifications.SMSNotificationSender;

import java.util.HashMap;

public class OrderMgr {
    private OrderMgr() {
        deliveryMgr = DeliveryMgr.getDeliveryMgr();
        foodMgr = FoodMgr.getFoodMgr();
        orderMap = new HashMap<>();
    }

    private static OrderMgr orderMgrInstance = null;
    private HashMap<String, Order> orderMap;

    private DeliveryMgr deliveryMgr;
    private FoodMgr foodMgr;

    private void addUserForNotificationUpdates(String orderId, Order order) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        // we can add push or whatsapp notifications in the same way. Basically, we are keeping all notifications customisable
        notificationMgr.addNotificationSender(orderId, order.getUserId(), new SMSNotificationSender());
        // this configuration level should be in user class and not in order mgr
    }

    private void manageDelivery(String orderId, Order order) {
        DeliveryMetaData metaData = new DeliveryMetaData(orderId, order.getUserLocation(), order.getRestaurantLocation());
        deliveryMgr.manageDelivery(orderId, metaData);
    }

    private void manageFood(String orderId, Order order) {
        foodMgr.prepareFood(orderId, order.getRestaurantId(), order.getDishes());
    }

    public static OrderMgr getOrderMgr() {
        if(orderMgrInstance == null) {
            orderMgrInstance = new OrderMgr();
        }
        return orderMgrInstance;
    }

    public void createOrder(String orderId, Order order) { // ideally name should not be passed
        // id should be generated, using name as id here
        addUserForNotificationUpdates(orderId, order);
        manageFood(orderId, order);
        manageDelivery(orderId, order);
    }

    public Order getOrder(String orderId) {
        // this id should be returned while creating order and can be used to fetch order details
        return orderMap.get(orderId);
    }
}
