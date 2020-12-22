package dev.minecraftplugin.pandoratotems.translation;

import com.google.gson.annotations.SerializedName;

public enum Messages {
    @SerializedName("No Permission")
    NO_PERMISSION("&cYou do not have permission to use this command!"),
    @SerializedName("Prefix")
    PREFIX("&aTotems>");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
