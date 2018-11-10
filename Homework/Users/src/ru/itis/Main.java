package ru.itis;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = new User("Arslan", "123", "Arslan", "Zamanov");
        User user1 = new User("Max", "456", "Maxim", "Pozdeev");
       // User user2 = new User("Kek", "1227", "Ak", "Dak");

        UsersRepositoryObjectsImpl usersRepositoryObjectsImpl = new UsersRepositoryObjectsImpl();

//        usersRepositoryObjectsImpl.save(user);
//        usersRepositoryObjectsImpl.save(user1);
        //usersRepositoryObjectsImpl.deleteByLogin("Arslan");


        //usersRepositoryObjectsImpl.save(user2);
//        try {
//            User user4 = usersRepositoryObjectsImpl.findByLogin("Arslan");
//            int i = 1;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            usersRepositoryObjectsImpl.findByLogin("Arslan");
        } catch (IOException e) {
            e.printStackTrace();
        }
        usersRepositoryObjectsImpl.deleteByLogin("Arslan");
        List list = usersRepositoryObjectsImpl.findAll();
        //ArrayList<User> ar = (ArrayList<User>) usersRepositoryObjectsImpl.findAll("Max");
        int i = 1;



/*
        UsersRepositoryWriter usersRepositoryWriter = new UsersRepositoryWriter();
        usersRepositoryWriter.save(user);
        usersRepositoryWriter.save(user1);
        try {
            User user2 = usersRepositoryWriter.findByLogin("Max");
            int i = 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        usersRepositoryWriter.deleteByLogin("Max");
        usersRepositoryWriter.save(user);
        //ArrayList<User> list = (ArrayList)usersRepositoryWriter.findAll("Max");
        int i = 1;*/
    }
}
