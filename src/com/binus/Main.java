package com.binus;

import com.binus.models.*;
import com.binus.utils.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Utils lambda = Utils.getInstance();
    private static final Person person = new Person();

    public static void main(String[] args) {
        lambda.print(lambda.APP_NAME);
        lambda.print("\nHello World\n");
        lambda.print(lambda.intToString(21));
        lambda.breakLine();
        lambda.print(lambda.stringToInt("asd").toString());
        lambda.breakLine();
        lambda.print(lambda.stringToInt("13").toString());
        lambda.breakLine();

        identityForm();

        lambda.print(getIdentityLists().toString());
        lambda.breakLine();

        Students s = registerStudent(person, "2301911136", "Binus University");
        lambda.print(s.toString());
    }

    public static void identityForm(){
        lambda.print("What is your name?");
        person.setName(lambda.scanString());
        lambda.print("What is your gender?");
        person.setGender(lambda.scanString());
        lambda.print("What is your age?");
        person.setAge(lambda.scanInt());
    }

    public static List<String> getIdentityLists(){
        List<String> users = new ArrayList<>();

        Person user1 = new Person("Alif", "Male", 19);
        Person user2 = new Person("Nia", "Female", 22);

        users.add(person.toString());
        users.add(user1.toString());
        users.add(user2.toString());

        return users;
    }

    public static Students registerStudent(Person person, String studentId, String school){
        return new Students(person.getName(), person.getGender(), person.getAge(), studentId, school);
    }

}
