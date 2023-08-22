package Sheshoin_ln_15.MyPhone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank EBank = new Bank();
        Culculator culculator= new Culculator();
        MyPhone myPhone = new MyPhone();
        boolean b = false;
        while (true){
        System.out.println("Добро пожаловать I Phone e1");
        System.out.println("Выберите приложение :\n1 Evernote\n2 EBank\n3 Calculator");


        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("Добро пожаловать в Колькулятор ");
                myPhone.Evernote();
                break;
            case 2:
                EBank.EBank();
                break;
            case 3:
                culculator.Colculator();
                break;
        }}
    }
}
