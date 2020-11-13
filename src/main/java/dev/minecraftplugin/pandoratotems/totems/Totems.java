package dev.minecraftplugin.pandoratotems.totems;

import dev.minecraftplugin.pandoratotems.totems.items.FireResistanceTotem;

public enum Totems {
    FIRE_RESISTANCE_TOTEM(new FireResistanceTotem(), "FIRE_RES");


    private final Totem totem;
    private final String key;

    @Override
    public String toString() {
        return key;
    }

    public String getKey() {
        return key;
    }

    Totems(Totem totem, String key) {
        this.totem = totem;
        this.key = key;
    }

    public Totem getTotem() {
        return totem;
    }

    public static Totems fromKey(String key) {
        for (Totems value : values()) {
            if (value.toString().equals(key)) return value;
        }
        return null;
    }
}
