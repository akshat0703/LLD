package org.example;

import java.util.HashMap;

public class UserMgr {
    private UserMgr() {
        usersMap = new HashMap<>();
    }

    private static UserMgr userMgrInstance;
    private HashMap<String, User> usersMap;

    public static UserMgr getUserMgr() {
        if(userMgrInstance == null) {
            userMgrInstance = new UserMgr();
        }
        return userMgrInstance;
    }

    public void addUser(String userName, User user) {
        usersMap.put(userName, user);
    }

    public User getUser(String userName) {
        return usersMap.get(userName);
    }
}
