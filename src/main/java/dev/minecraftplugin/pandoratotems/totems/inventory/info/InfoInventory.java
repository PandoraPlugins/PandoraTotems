package dev.minecraftplugin.pandoratotems.totems.inventory.info;

import com.azortis.azortislib.experimental.inventory.GUI;
import com.azortis.azortislib.experimental.inventory.Page;
import com.azortis.azortislib.experimental.inventory.impl.base.BaseGUI;
import com.azortis.azortislib.experimental.inventory.impl.base.BasePage;
import com.azortis.azortislib.experimental.inventory.item.Button;
import com.azortis.azortislib.experimental.inventory.item.Item;
import com.azortis.azortislib.xseries.XMaterial;
import dev.minecraftplugin.pandoratotems.Heads;
import dev.minecraftplugin.pandoratotems.totems.Totems;

// todo: test this inventory.
public class InfoInventory {
    private final GUI gui;

    public InfoInventory() {
        gui = new BaseGUI("InfoGUI");

        int pages = ((Totems.values().length - 1) / 30) + 1;
        int start = 0;
        for (int pI = 1; pI <= pages; pI++) {
            Page page = new BasePage(gui, 54, pI);
            page.setGlobal(true);
            page.setInventoryName("&bTotem Info : Page " + pI);

            // Make a filler
            Button filler = getFiller();
            // Add the filler to the top row.
            for (int i = 1; i <= 9; i++)
                page.addButton(i, filler);
            // Add the filler to the left and right sides.
            addToSides(page, filler);
            // Fill in the bottom row with filler
            for (int i = 46; i <= 54; i++)
                page.addButton(i, filler);
            // Set the forward and back buttons
            Item forward = new Item(XMaterial.PLAYER_HEAD);
            Item backward = new Item(XMaterial.PLAYER_HEAD);
            forward.skull(Heads.NEXT_PAGE);
            backward.skull(Heads.LAST_PAGE);
            Button forwardButton = new Button(forward);
            Button backButton = new Button(backward);
            forwardButton.addClickAction(itemClickEvent -> {
                itemClickEvent.getEvent().setCancelled(true);
                int i = itemClickEvent.getPage().getGuiInt() + 1;
                if (itemClickEvent.getPage().getGUI().size() > i)
                    itemClickEvent.whoClicked().openInventory(itemClickEvent.getPage().getGUI().getPage(i).getInventory());

            });
            backButton.addClickAction(itemClickEvent -> {
                itemClickEvent.getEvent().setCancelled(true);
                int i = itemClickEvent.getPage().getGuiInt() - 1;
                if (i > 0)
                    itemClickEvent.whoClicked().openInventory(itemClickEvent.getPage().getGUI().getPage(i).getInventory());

            });
            for (int i = 11; i < 36; i++) {
                if (i == 18 || i == 19 || i == 27 || i == 28) continue;
                Button totem = new Button(Totems.values()[start].getTotem().getShopItem());
                totem.addClickAction(itemClickEvent -> itemClickEvent.getEvent().setCancelled(true));
                page.addButton(start, totem);
                start++;
            }
        }
    }


    private Button getFiller() {
        Item filler = new Item(XMaterial.BLACK_STAINED_GLASS_PANE);
        filler.name("");
        Button button = new Button(filler);
        button.addClickAction(itemClickEvent -> itemClickEvent.getEvent().setCancelled(true));
        return button;
    }

    private void addToSides(Page page, Button button) {
        page.addButton(10, button);
        page.addButton(18, button);
        page.addButton(19, button);
        page.addButton(27, button);
        page.addButton(28, button);
        page.addButton(36, button);
    }

    public GUI getGui() {
        return gui;
    }
}
