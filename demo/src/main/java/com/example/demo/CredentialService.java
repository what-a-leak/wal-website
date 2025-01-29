package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;



public class CredentialService {

    private static final String CREDENTIALS_FILE = "/home/wal/wal-website/demo/src/main/resources/credentials.json";

    public static List<User> loadUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(CREDENTIALS_FILE), objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
    }

    public static boolean isValidUser(String username, String password) {
        try {
            List<User> users = loadUsers();
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
