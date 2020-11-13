package dev.minecraftplugin.pandoratotems.totems;

public enum TotemTier {
    COMMON("&e", "COMMON"),
    UNCOMMON("&b", "UNCOMMON"),
    RARE("&d", "RARE"),
    UNKNOWN("&c", "???");

    private final String color;
    private final String name;

    TotemTier(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
