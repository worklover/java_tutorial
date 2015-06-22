package ru.home.leson18;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Profile> profiles = new ArrayList<Profile>();

    public static  void main(String[] args) {
         profiles = (ArrayList<Profile>)deserData("profiles");
        //System.out.println(profiles.size());
        Profile profile = new Profile();
        profile.setName(JOptionPane.showInputDialog(null, " Inter your name "));
        profile.setSurname(JOptionPane.showInputDialog(null, " Inter your name "));
        profiles.add(profile);
        for (Profile p: profiles ) {
            System.out.println(p.getName()+" "+ p.getSurname());

        }
        //System.out.println(profiles.size());
        serData("profiles", profiles);
        

    }

    private static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file_name + "ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            fileOut.close();
            out.close();

        }catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(" Errror");
            System.exit(2);
        }
    }

    private static Object deserData(String file_name) {
        Object retObject = null;

        try {
            FileInputStream fileIn = new FileInputStream(file_name + "ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            fileIn.close();
            in.close();


        }catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(" Errror");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Class epsend ");
            System.exit(3);
        }
        return retObject;
    }
}
