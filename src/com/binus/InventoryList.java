package com.binus;

import com.binus.models.Inventory;
import com.binus.utils.Utils;

import java.util.Vector;
import java.util.stream.IntStream;

public class InventoryList extends Utils{

    private final Vector<Inventory> inventoryList = new Vector<>();

    public void startInventory() {
        int menu;

        do {
            mainMenu();
            menu = scanInt("Choice: ");
            switch (menu) {
                case 1:
                    viewInventoryList();
                    break;
                case 2:
                    addNewItem();
                    break;
                case 3:
                    checkoutItem();
                    break;
            }
        } while (menu != 4);
    }

    private void mainMenu() {
        print("+======================+");
        print("1. View Item in Inventory");
        print("2. Add New Item to Inventory");
        print("3. Checkout Item from Inventory");
        print("4. Exit Program");
        print("+======================+");
    }

    private Inventory addInventory(String id) {
        Inventory inventory = new Inventory();

        inventory.setId(id);

        do {
            inventory.setName(scanString("NAME"));
        } while (!inventory.getNameConstraint());

        do {
            inventory.setPrice(scanInt("PRICE"));
        } while (!inventory.getPriceConstraint());

        do {
            inventory.setStock(scanInt("STOCK"));
        } while (!inventory.getStockConstraint());

        return inventory;
    }

    private Inventory updateInventory(Inventory inventory, boolean isUpdate) {
        if (isUpdate) {
            inventory.setStock(inventory.getStock() + scanInt("STOCK"));
        } else {
            inventory.setStock(inventory.getStock() - scanInt("STOCK"));
        }

        return inventory;
    }

    private void viewInventoryList() {
        if (inventoryList.size() != 0) {
            IntStream.range(0, inventoryList.size())
                    .mapToObj(
                            i -> String.format("%d. %s", i + 1, inventoryList.get(i).toString())
                    ).forEach(Utils::print);
        } else {
            print("Empty List");
        }
    }

    private Integer findInventory(String id) {
        int index = -1;
        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getId().equals(id)) {
                index = i;
            }
        }
        return index;
    }

    private String scanId() {
        String id;

        do {
            id = scanString("ID");
        } while (id.length() != 5);

        return id;
    }

    private void addNewItem() {
        String id = scanId();
        int selectedInventoryIndex = findInventory(id);

        if (selectedInventoryIndex != -1) {
            inventoryList.set(selectedInventoryIndex, updateInventory(inventoryList.get(selectedInventoryIndex), true));
        } else {
            inventoryList.add(addInventory(id));
        }

    }

    private void checkoutItem() {
        viewInventoryList();
        if (inventoryList.size() != 0) {
            String id = scanId();
            int selectedInventoryIndex = -1;

            do {
                if (selectedInventoryIndex != -1){
                    if (inventoryList.get(selectedInventoryIndex).getStock() > 0) {
                        Inventory inventory = inventoryList.get(selectedInventoryIndex);

                        print(inventory.toString());

                        int prevStock = inventory.getStock();

                        updateInventory(inventory, false);

                        print("revenue " + (prevStock - inventory.getStock()) * inventory.getPrice() );
                        break;
                    } else {
                        print("canot");
                        selectedInventoryIndex = -1;
                    }
                }else {
                    selectedInventoryIndex = findInventory(id);
                }
            } while (selectedInventoryIndex != -1);
        }
    }

}
