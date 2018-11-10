package ru.itis;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryWriter implements UsersRepository{

    private FileWriter fileWriter;
    private File file;


    public UsersRepositoryWriter() {
        try {
            file = new File("UsersByWriter.txt");
            fileWriter = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        try {
            fileWriter.write("#" + "\n");
            fileWriter.write(user.getLogin() + "\n");
            fileWriter.write(user.getPassword() + "\n");
            fileWriter.write(user.getFirstName() + "\n");
            fileWriter.write(user.getSecondName() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByLogin(String login) {
        int c;
        StringBuffer sb = new StringBuffer();
        try {
            fileWriter.close();
            File oldFile = new File("old.txt");
            if(file.renameTo(oldFile)){
                file = new File("old.txt");

            }
            FileReader fR = new FileReader(oldFile);
            File newFile = new  File("UsersByWriter.txt");
            newFile.createNewFile();
            fileWriter = new FileWriter(newFile);
            while((c = fR.read()) != -1){
                if((char)c == '#') {
                    fR.read();
                    while((char)(c = fR.read()) != '\n'){
                        sb.append((char)c);
                    }
                        User user = new User();
                        user.setLogin(sb.toString());
                        sb.setLength(0);
                        while((char)(c = fR.read()) != '\n'){
                            sb.append((char)c);
                        }
                        user.setPassword(sb.toString());
                        sb.setLength(0);

                        while((char)(c = fR.read()) != '\n'){
                            sb.append((char)c);
                        }
                        user.setFirstName(sb.toString());
                        sb.setLength(0);

                        while((char)(c = fR.read()) != '\n'){
                            sb.append((char)c);
                        }
                        user.setSecondName(sb.toString());
                    if(!user.getLogin().equals(login)) {
                        save(user);
                    }
                    sb.setLength(0);
                }
            }
            fR.close();
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByLogin(String login) throws IOException {
        int c;
        StringBuffer sb = new StringBuffer();
        FileReader fileReader = new FileReader(file);

        while((c = fileReader.read()) != -1){
            if((char)c == '#') {
                fileReader.read();
                while((char)(c = fileReader.read()) != '\n'){
                    sb.append((char)c);
                }
                if(sb.toString().equals(login)){
                    User user = new User();
                    user.setLogin(sb.toString());
                    sb.setLength(0);
                    while((char)(c = fileReader.read()) != '\n'){
                        sb.append((char)c);
                    }
                    user.setPassword(sb.toString());
                    sb.setLength(0);

                    while((char)(c = fileReader.read()) != '\n'){
                        sb.append((char)c);
                    }
                    user.setFirstName(sb.toString());
                    sb.setLength(0);

                    while((char)(c = fileReader.read()) != '\n'){
                        sb.append((char)c);
                    }
                    user.setSecondName(sb.toString());
                    fileReader.close();

                    return user;
                }
                sb.setLength(0);

            }
        }
        throw new IOException();
    }

    @Override
    public List<User> findAll() {
        /*ArrayList<User> list = new ArrayList<>();
        try {
            while(true){
                list.add();
            }
        }catch (IOException e){
            return list;
        }*/
        return new ArrayList<User>();
    }
}
