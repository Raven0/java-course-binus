package com.binus;

import com.binus.models.Pet;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Pet> petList;

    public static void main(String[] args) {
        int menu;

        do {
            mainMenu();
            menu = scanInt("Choice: ");
            switch (menu) {
                case 1:
                    addPetMenu();
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

    private static void addPetMenu() {
        Pet newPet = new Pet();

        do {
            newPet.setHealth(scanInt("Input pet Health [1 - 90]"));
        } while (newPet.getHealth() >= 1 && newPet.getHealth() <= 90);

        print(newPet.getHealth().toString());

        do {
            newPet.setName(scanString("Input pet Name [5 - 15 characters]"));
        } while (newPet.getName().length() >= 5 && newPet.getName().length() <= 15);

        do {
            newPet.setType(scanString("Input pet Type [kit | puppy | kitten]"));
        } while (newPet.getType().equals("kit") || newPet.getType().equals("puppy") || newPet.getType().equals("kitten"));

        newPet.setType(scanString("Input pet Type [kit | puppy | kitten]"));

        petList.add(newPet);
    }

    private static void viewPetListMenu() {
        if (petList.size() != 0) {
            for (Pet pet : petList) {
                print(pet.toString());
            }
        } else {
            print("Empty List");
        }
    }

    private static void updatePetMenu() {

    }

    private static void treatPetMenu() {

    }

    private static void print(String args) { System.out.println(args); }

    public static String scanString(String msg) {
        String value;

        try {
            print(msg);
            value = scanner.nextLine();
        } catch (Exception x) {
            print(msg);
            value = scanner.nextLine();
        }

        return value;
    }

    @SuppressWarnings("SameParameterValue")
    public static Integer scanInt(String msg) {
        int value;

        try {
            print(msg);
            value = scanner.nextInt();
        } catch (Exception x) {
            print(msg);
            value = scanner.nextInt();
        }

        return value;
    }

}
