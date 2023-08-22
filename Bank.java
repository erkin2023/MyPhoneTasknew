package Sheshoin_ln_15.MyPhone;

import java.util.Random;
import java.util.Scanner;

public class Bank {
    boolean b = false;
    public void EBank(){
        while (true){
        System.out.println("*---------------------------------------------*");
        System.out.println("| * Добро пожаловать в ЭБанк");
        System.out.println("| * Выберите свой вариант входа:\n| * 1: Войти в логин\n| * 2: Пройти регистрацию");

        Scanner scanner = new Scanner(System.in);
        int variant = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        String registeredLogin = "";
        String name = "";
        String iin = "";
        long account = 20021409;

        switch (variant) {
            case 1:
                System.out.println("| * Напишите свой логин");
                String login = scanner.nextLine();
                registeredLogin = login;
                System.out.println("| * Пожалуйста, пройдите регистрацию\n| * Такого логина не существует: " + login);
                break;
            case 2:
                System.out.println("| * Для того чтобы зарегистрироваться, напишите свое ФИО");
                String fullName = scanner.nextLine();
                name = fullName;
                break;
            default:
                System.out.println("| * Неправильный вариант входа.");
                scanner.close();
                return; // Завершаем программу, если выбран неправильный вариант
        }

        System.out.println("| * Напишите свой ИИН");
        String inn = scanner.nextLine();

        System.out.println("| * Напишите свой возраст");
        byte age = scanner.nextByte();
        while (age <= 0 || age > 127) {
            System.out.println("| * Неправильно введен возраст! Повторите попытку.");
            age = scanner.nextByte();
        }
        scanner.nextLine(); // Очистка буфера

        System.out.println("| * Напишите свой номер начиная с +996");
        String number = scanner.nextLine();
        while (!number.startsWith("+996") || number.length() != 13) {
            System.out.println("| * Это не кыргызский номер. Введите правильный номер, начинающийся с +996 и состоящий из 12 цифр");
            number = scanner.nextLine();
        }

        System.out.println("| * Напишите вашу почту");
        String email = scanner.nextLine();
        registeredLogin = email;

        while (!isValidEmail(email)) {
            System.out.println("| * Такой почты не существует! Введите правильно:");
            email = scanner.nextLine();
        }
        System.out.println("| * Ваша почта: " + email);

        System.out.println("| * Придумайте пароль из 8 символов");
        String password = scanner.nextLine();
        while (password.length() != 8) {
            System.out.println("| * Неправильная длина пароля. Пароль должен состоять из 8 символов.");
            password = scanner.nextLine();
        }

        System.out.println("| * Ваш пароль: " + password);
        System.out.println("| * Регистрация прошла успешно!");

        // Проверяем введенный логин с зарегистрированным

        System.out.println("| * Введите логин: ");
        String inputLogin = scanner.nextLine();

        // Проверяем введенный логин с зарегистрированным
        if (inputLogin.equals(registeredLogin)) {
            System.out.println("| * Логин верный. Введите пароль");
            String inputPassword = scanner.nextLine();

            // Проверяем введенный пароль с зарегистрированным
            if (inputPassword.equals(password)) {
                System.out.println("| * Вход выполнен!\nДобро пожаловать в ЭБанк, " + name);

                // Здесь вы можете добавить код для операций с банком
                Random random = new Random();
                int balance = random.nextInt(10000) + 9000;
                int variantoperasii;

                do {
                    System.out.println("Ваш баланс составляет : "+ balance);
                    System.out.println("\n| * 1 Проверка баланса\n| * 2 Вывод денег\n| * 3 Перевод денег\n| * 4 Депозит\n| * 5 Конвертация\n| * 6 Выйти");
                    variantoperasii = scanner.nextInt();
                    scanner.nextLine();

                    switch (variantoperasii) {
                        case 1:
                            System.out.println("| * Ваш баланс составляет: " + balance + " сом");
                            break;
                        case 2:
                            System.out.println("| * Вывод денег\n| * Напишите сумму, которую хотите вывести");
                            int vyvod = scanner.nextInt();
                            scanner.nextLine();
                            while (vyvod > balance || vyvod < 0) {
                                System.out.println("| * Вывод денег больше, чем ваш баланс ");
                                vyvod = scanner.nextInt();
                                scanner.nextLine();
                            }
                            balance -= vyvod;
                            System.out.println("| * Вы успешно вывели " + vyvod + " сом. Ваш новый баланс: " + balance + " сом");
                            break;
                        case 3:
                            System.out.println("| * Перевод денег\n| * Перевод по лицевому счету  " + account);
                            long persona = scanner.nextLong();
                            scanner.nextLine();

                            // Здесь добавлена проверка правильности лицевого счета
                            if (persona == account && balance > 0) {
                                System.out.println("| * Абонент найден\n| * Введите сумму перевода:");
                                int perevod = scanner.nextInt();
                                scanner.nextLine();
                                while (perevod > balance || perevod < 0) {
                                    System.out.println("| * Ваша сумма перевода больше, чем ваш баланс ");
                                    perevod = scanner.nextInt();
                                    scanner.nextLine(); // Очистка буфера
                                }

                                balance -= perevod;
                                System.out.print("| * Вы успешно перевели в на лицевой счет " + perevod + " сом");
                            } else {
                                System.out.println("| * Абонент не найден или у вас недостаточно средств для перевода.");
                            }
                            break;
                        case 4:
                            System.out.println("| * Внести деньги в депозит");
                            int depozit = scanner.nextInt();
                            scanner.nextLine();
                            while (depozit < 0) {
                                System.out.println("| * Сумма внесения в депозит должна быть не меньше суммы баланса");
                                depozit = scanner.nextInt();
                                scanner.nextLine();
                            }
                            balance += depozit;
                            System.out.println("| * Вы успешно внесли в депозит " + depozit + " сом. Ваш новый баланс: " + balance + " сом");
                            break;
                        case 5:
                            System.out.println("Конвертация валюты\nВыберите валюту, на которую хотите конвертировать ваши деньги");
                            System.out.println("\n| * 1 Конвертация в Рубль:\n| * 2 Рубля к Сому:\n| * 3 Конвертация Доллар:\n| * 4 Доллар к Сому:\n| * 5 Конвертация Евро : \n| * 6 Евро к Сому :");
                            int konvertasia = scanner.nextInt();
                            scanner.nextLine();
                            double convertedAmount = 0;
                            switch (konvertasia) {
                                case 1:
                                    convertedAmount = balance * 0.98;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " рублей");
                                    break;
                                case 2:
                                    convertedAmount = balance * 1.03;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " сомах");
                                    break;
                                case 3:
                                    convertedAmount = balance / 87.5;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " долларов");
                                    break;
                                case 4:
                                    convertedAmount = balance * 87.5;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " Сомах");
                                    break;
                                case 5:
                                    convertedAmount = balance / 98.15;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " евро");
                                    break;
                                case 6:
                                    convertedAmount = balance * 98.15;
                                    System.out.println("| * Ваш баланс после конвертации: " + convertedAmount + " Сомах");
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println("| * Выход в меню...");
                            break;
                        default:
                            System.out.println("| * Неправильный вариант операции.");
                            break;
                    }
                } while (variantoperasii != 6);
                System.out.println("Ваш перевод по личевому счет "+account );
            } else {
                System.out.println("| * Неверный пароль. Вход не выполнен.");
            }
        } else {
            System.out.println("| * Неверный логин. Вход не выполнен.");
        }

        scanner.close();
    }}

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(regex);
    }
}