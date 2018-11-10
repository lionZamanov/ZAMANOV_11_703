package ru.itis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryObjectsImpl implements UsersRepository {
    private File file;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public UsersRepositoryObjectsImpl() {
        try {
            file = new File("Users.txt");
            //file.createNewFile();
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true));
            //objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        try {
            objectOutputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void deleteByLogin(String login) {
        try {
            objectOutputStream.close();
            File oldFile = new File("old.txt");
            if(file.renameTo(oldFile)){

                file = new File("old.txt");
            }
            File newFile = new File("Users.txt");
            newFile.createNewFile();
            User user;
            ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(file));
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(newFile));
            try {
                try {
                    user = (User)objInStr.readObject();
                    while(true){
                        if(!user.getLogin().equals(login)) {
                            objectOutputStream.writeObject(user);
                        }
                        user = (User) objInStr.readObject();
                    }
                }catch (EOFException k){
                    objInStr.close();
                    file.delete();
                    file = new File("Users.txt");
                }

            } catch (ClassNotFoundException e) {
                throw new ClassCastException("Class not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findByLogin(String login) throws IOException{
        try {
            file = new File("Users.txt");
            ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(file));
            try {
                try {
                    User user = (User) objInStr.readObject();
                    while (!user.getLogin().equals(login)) {
                        user = (User) objInStr.readObject();
                    }
                    objInStr.close();
                    return user;
                }catch (EOFException k){
                    throw new EOFException();
                }
            } catch (ClassNotFoundException e) {
                throw new ClassCastException();
            }
        } catch (IOException e) {
            throw new IOException();
        }
    }

    @Override
    public List<User> findAll(){
        ArrayList<User> list = new ArrayList<>();
        try {
            ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream(file));
            try {
                try {
                    User user = (User) objInStr.readObject();
                    while (true) {
                        list.add(user);
                        user = (User) objInStr.readObject();
                    }
                }catch (EOFException k){
                    objInStr.close();
                    return list;
                }
            } catch (ClassNotFoundException e) {
                throw new ClassCastException();
            }
        } catch (IOException e) {
            return list;
        }
    }
}
