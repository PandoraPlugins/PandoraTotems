package dev.minecraftplugin.pandoratotems.totems;

public enum Rarity {
    COMMON("&8Common Totem");

    private final String formatted;

    Rarity(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public String toString() {
        return formatted;
    }
}
