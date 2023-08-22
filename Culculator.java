package Sheshoin_ln_15.MyPhone;

import java.util.Scanner;

public class Culculator {


    public void Colculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1| Войти в конкулятор \n2| Выйти из конкулятора ");
        int a=scanner.nextInt();
        switch (a) {
            case 1:
                System.out.println("Добро пожаловать в Конкулятор ");


                System.out.print("Напишите первую цифру: ");
                double num1 = scanner.nextDouble();


                System.out.print("Напишите вторую цифру: ");
                double num2 = scanner.nextDouble();

                System.out.print("Условия  (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Error! Invalid operator.");
                        return;
                }

                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            case 2:
                break;
        }}
}

