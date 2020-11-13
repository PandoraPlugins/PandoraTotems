package dev.minecraftplugin.pandoratotems.translation;

public enum Messages {
    PREFIX("&aTotems> ", "prefix"),
    NO_PERMISSION("&cYou do not have permission to use this command!", "no_permission");


    private final String message;
    private final String key;

    public String getMessage() {
        return message;
    }

    public String getKey() {
        return key;
    }

    Messages(String message, String key) {
        this.message = message;
        this.key = key;
    }
}
