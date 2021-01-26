package com.chivalry.sf.repository.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyResultSet<T> extends AbstractResultSet {

    private final List<T> data;
    private final Class modelCls;
    private final Map<String, Method> methodMap = new HashMap();

    private final AtomicInteger currentIndex = new AtomicInteger(-1);

    public MyResultSet(List<T> data, Class<T> cls) {
        this.data = data;
        this.modelCls = cls;

        for (Method declaredMethod : cls.getDeclaredMethods()) {
            if (Modifier.isPublic(declaredMethod.getModifiers()) && declaredMethod.getName().startsWith("get") && declaredMethod.getParameterCount() == 0) {
                String name = declaredMethod.getName().substring(3, 4).toLowerCase() + declaredMethod.getName().substring(4);

                methodMap.put(name, declaredMethod);
            }
        }

    }

    @Override
    public boolean next() throws SQLException {
        return currentIndex.incrementAndGet() < data.size();
    }

    private T getCurrentData() {
        int index = currentIndex.get();
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        } else {
            return null;
        }
    }

    private Object get(String name) {
        T data = getCurrentData();
        if (data != null) {
            Method method = methodMap.get(name);
            if (method != null) {
                try {
                    return method.invoke(data);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public String getString(String columnLabel) throws SQLException {
        Object data = get(columnLabel);
        if (data != null) {
            return data.toString();
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        List<User> list = new ArrayList();
        User user = new User();
        user.setId(1);
        user.setName("提桶");
        list.add(user);
        user = new User();
        user.setId(2);
        user.setName("跑路");
        list.add(user);
        ResultSet resultSet = new MyResultSet(list, User.class);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
