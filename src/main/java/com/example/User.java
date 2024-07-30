package com.example;

import java.util.regex.Pattern;

public class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Simple email validation using regex
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    // Method to change password
    public void changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect");
        }
        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("New password must be at least 6 characters long");
        }
        this.password = newPassword;
    }

    // Method to update email
    public void updateEmail(String newEmail) {
        if (newEmail == null || !isValidEmail(newEmail)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = newEmail;
    }

    // Method to simulate a potential vulnerability
    public void doSomethingDangerous(String input) {
        if (input.contains("danger")) {
            throw new IllegalArgumentException("Dangerous input detected!");
        }
        // Simulated logic here
    }

    // Getters and other methods omitted for brevity
}
