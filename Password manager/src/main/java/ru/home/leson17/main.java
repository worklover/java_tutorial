package ru.home.leson17;

import java.util.ArrayList;
import java.util.Random;

public class main {
    private static ArrayList<Mobile>  mobiles= new ArrayList<Mobile>();
    private static Random r = new Random();

    public static void main(String[] args) {
        for (int i=0; i<300;i++){
            mobiles.add(new Mobile(r.nextInt(99999999),"dkfjskjdksf" ));
        }
            for (Mobile m: mobiles) {
            System.out.println(m.getNumber()+ " "+ m.getName());
        }
    }


}
