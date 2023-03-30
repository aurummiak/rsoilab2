package com.example.rsoilab2;

import logic.Driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Rsoilab2Application {
    static ArrayList<Driver> driverMethods = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(Rsoilab2Application.class, args);

       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       context.getBean("Drivers", Driver.class);

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewDriver();
                    break;
                case 2:
                    viewListOfDrivers();
                    break;
                case 3:
                    findDriverByExp();
                    break;
                case 4:
                    getPriceOfDrivingFromDriverList();
                    break;
                case 5:
                    viewTotalSum();

                    break;
                case 6:
                    return;
                default:
                    System.out.println("WARNING: Incorrect data. Try again.");
            }
        }


    }

    public static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1) Add driver to the database ");
        System.out.println("2) Show all drivers from database ");
        System.out.println("3) Find driver by experience ");
        System.out.println("4) Find price of driving of current driver ");
        System.out.println("5) Find total carsharing budget from 1 year  ");
        System.out.println("6) Exit of the program ");
        System.out.print("Your choice: ");
    }


    public static void viewListOfDrivers() {
        for (Driver driver : Rsoilab2Application.driverMethods) {
            System.out.println(driver);
        }
    }


    public static void addNewDriver() {

        viewListOfDrivers();
        Driver driver = new Driver();
        driver.addNewDriverMethod();
        Rsoilab2Application.driverMethods.add(driver);

    }

    public static void viewTotalSum() {
        viewListOfDrivers();
        int sum = 0;

        for (int i = 0; i < driverMethods.size(); i++) {
            if (driverMethods.get(i).getDateDrive().isAfter(LocalDate.now().minusYears(1))) {
                sum += driverMethods.get(i).getPriceDriving();

            }

        }
        System.out.print("TOTAL PRICE FROM ALL DRIVES [budget]: " + sum);
    }

    public static void findDriverByExp() {
        System.out.println("Enter the number of driver's exp: ");
        Scanner scanner = new Scanner(System.in);
        int findExp = scanner.nextInt();
        for (Driver driver : Rsoilab2Application.driverMethods) {
            if (findExp == driver.getExperience()) {
                System.out.println("RESULT: ");
                System.out.println(driver);
            } else {
                System.out.println("There is no driver for ur parameter.");
            }


        }

    }

    public static void getPriceOfDrivingFromDriverList() {
        System.out.println("Enter the number ID of driver to see amount: ");
        Scanner scanner = new Scanner(System.in);
        int findIdToAmount = scanner.nextInt();
        for (Driver driver : Rsoilab2Application.driverMethods) {
            if (findIdToAmount != driver.getId()) {
                System.out.println("Smb from drivers are not in order.");
            } else {
                System.out.println("\nYOUR RESULT: ");
                System.out.println("Amount of money: " + driver.getPriceDriving());
            }
        }
    }


//    public static void main(String[] args) {
//        SpringApplication.run(Rsoilab2Application.class, args);
//    }

}
