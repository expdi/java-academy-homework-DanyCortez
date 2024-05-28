package org.adoption.dao;

import org.adoption.dao.InMemory.InMemoryAdopter;
import org.adoption.dao.JPA.JPAAdopter;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class DAOFactory {
    private static Map<String, Object> objects = new ConcurrentHashMap<>();
    public static void clear() {
        objects.clear();
    }

    public static int getObjectCount() {
        return objects.size();
    }

    public static AdopterDAO getAdopterDAO() {
        String enviroment = ResourceBundle.getBundle("AppConfig").getString("AppConfig.environment");

        return switch (enviroment) {
            case "dev" -> (AdopterDAO) objects.computeIfAbsent("adopterDAO", k -> new InMemoryAdopter());
            case "prod" -> (AdopterDAO) objects.computeIfAbsent("adopterDAO", k -> new JPAAdopter());
            default -> throw new RuntimeException("Unkhown profile:" + enviroment);
        };
    }
}
