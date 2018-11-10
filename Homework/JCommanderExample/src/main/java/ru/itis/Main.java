package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 03.05.2018
 * ru.itis.Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void run() {
        File dir = new File("src/main/java/ru/itis");
        File[] arrFiles = dir.listFiles();
        showClass(arrFiles);
        createObject(arrFiles);
    }

    public void showClass(File[] arrFiles){
        for (int j = 0; j < arrFiles.length - 1; j++) {
            String nameOfClass = arrFiles[j].getName().split("\\.")[0];
            Class aClass = null;
            try {
                aClass = Class.forName("ru.itis."+nameOfClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("*** " + aClass.getName() + " ***");

            Field fields[] = aClass.getDeclaredFields();
            System.out.println("FIELDS");
            for (Field field : fields) {
                System.out.println(field.getType() + " " + field.getName());
            }

            Method methods[] = aClass.getDeclaredMethods();
            System.out.println("METHODS");
            for (Method method : methods) {
                System.out.println(method.getName() + Arrays.asList(method.getParameterTypes()));
            }

            Constructor constructors[] = aClass.getConstructors();

            System.out.println("CONSTRUCTORS");
            for (Constructor constructor : constructors) {
                System.out.println(Arrays.asList(constructor.getParameterTypes()));
            }
        }
    }

    public void createObject(File[] arrFiles){
        System.out.println("Введите имя класса для создания его экземпляра");
        Scanner scanner = new Scanner(System.in);
        Class aClass = null;

        try {
            aClass = Class.forName("ru.itis." + scanner.nextLine());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Constructor constructors[] = aClass.getConstructors();
        Field fields[] = aClass.getFields();
        System.out.println("Каким констурктором воспользоваться?");
        for (Constructor constructor : constructors) {
            System.out.println(Arrays.asList(constructor.getParameterTypes()));
        }

        int nOfConstructor = scanner.nextInt();
        String s = "";
        for (int i = 0; i < constructors[nOfConstructor].getParameterTypes().length; i++) {
            System.out.println("Enter " + fields[i] + " field type " + constructors[nOfConstructor].getParameterTypes()[i]);
            if(constructors[nOfConstructor].getParameterTypes()[i].getName().equals("java.lang.String")){
                s = scanner.nextLine();
            }
        }
        try {
            Object o = constructors[nOfConstructor].newInstance(s);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
