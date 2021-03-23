package com.binus;

import com.binus.models.Pet;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.IntStream;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Vector<Pet> petList = new Vector<>();

    public static void main(String[] args) {
        int menu;

        do {
            mainMenu();
            menu = scanInt("Choice: ");
            switch (menu) {
                case 1:
                    petList.add(addPet());
                    break;
                case 2:
                    viewPetListMenu();
                    break;
                case 3:
                    updatePetMenu();
                    break;
                case 4:
                    treatPetMenu();
                    break;
            }
        } while (menu != 5);
    }

    private static void mainMenu() {
        print("+======================+");
        print("1. Add Sick Pet");
        print("2. View Sick Pet List");
        print("3. Update Sick Pet");
        print("4. Treat Sick Pet");
        print("5. Exit Program");
        print("+======================+");
    }

    private static Pet addPet() {
        Pet newPet = new Pet();

        do {
            newPet.setHealth(scanInt("Input pet Health [1 - 90]"));
        } while (!newPet.getHealthConstraint());

        do {
            newPet.setName(scanString("Input pet Name [5 - 15 characters]"));
        } while (!newPet.getNameConstraint());

        do {
            newPet.setType(scanString("Input pet Type [kit | puppy | kitten]"));
        } while (!newPet.getTypeConstraint());

        return newPet;
    }

    private static Pet updatePet(Pet pet) {
        int prevHealth = pet.getHealth();

        do {
            pet.setHealth(scanInt("Input pet Health [1 - 90]"));
        } while (!pet.getHealthConstraint());

        if (pet.getHealth() < 20) {
            pet.setHealth(25);
        } else if (pet.getHealth() < prevHealth) {
            pet.setHealth(prevHealth + pet.getHealth() / 2);
        }

        return pet;
    }

    private static void viewPetListMenu() {
        if (petList.size() != 0) {
            IntStream.range(0, petList.size())
                    .mapToObj(
                            i -> String.format("%d. %s", i + 1, petList.get(i).toString())
                    ).forEach(Main::print);
        } else {
            print("Empty List");
        }
    }

    private static void updatePetMenu() {
        viewPetListMenu();
        if (petList.size() != 0) {
            int selectedPet = selectPetIndex();
            petList.set(selectedPet - 1, updatePet(petList.get(selectedPet - 1)));
        }
    }

    private static void treatPetMenu() {
        viewPetListMenu();
        if (petList.size() != 0) {
            petList.remove(selectPetIndex() - 1);
        }
    }

    private static int selectPetIndex() {
        int selectedIndex;

        do {
            selectedIndex= scanInt(String.format("Choose pet number [1 - %d]", petList.size()));
        } while (selectedIndex < 1  || selectedIndex > petList.size());

        return selectedIndex;
    }

    private static void print(String args) { System.out.println(args); }

    private static String scanString(String msg) {
        String value;

        try {
            print(msg);
            value = scanner.nextLine();
        } catch (Exception x) {
            print(x.getMessage());
            value = null;
        }

        return value;
    }

    private static Integer scanInt(String msg) {
        int value;

        try {
            print(msg);
            value = Integer.parseInt(scanner.nextLine());
        } catch (Exception x) {
            print(x.getMessage());
            value = 0;
        }

        return value;
    }

}
