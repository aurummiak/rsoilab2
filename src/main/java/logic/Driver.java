package logic;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;


import java.util.Scanner;

@Component("Drivers")
public class Driver {

    private int id;
    private String name;
    private int age;
    private int experience;
    private LocalDate dateOffence;
    private int priceDriving;
    private LocalDate dateDrive;
    private ArrayList<Driver> driversList = new ArrayList<>();

    public Driver(int id, String name, int age, int experience, LocalDate dateOffence, int priceDriving, LocalDate dateDrive, ArrayList driversList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.dateOffence = dateOffence;
        this.priceDriving = priceDriving; // цена поездки
        this.dateDrive = dateDrive;
        this.driversList = driversList;

    }

    public Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Driver() {

    }

    public int countId() {
        return id++;
    }

    public ArrayList<Driver> getDriversList() {
        return driversList;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateOffence() {
        return dateOffence;
    }

    public LocalDate getDateDrive() {
        return dateDrive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", dateOffence=" + dateOffence +
                ", priceDriving=" + priceDriving +
                ", dateDrive=" + dateDrive +
                '}';
    }

    public int getPriceDriving() {
        return priceDriving;
    }

    public void addNewDriverMethod() {
        boolean flagAge = false;
        boolean flagExp = false;
        boolean flagPrice = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--------INFORMATION--------");


        System.out.println("ENTER NAME: ");
        name = scanner.nextLine();
        while (!name.matches("[a-zA-Z]+")) {
            System.out.println("Please enter a valid name!");
            name = scanner.nextLine();
        }


        System.out.print("ID: ");
        id = scanner.nextInt();

        while (!flagAge) {
            System.out.print("ENTER AGE (18 and older): ");
            try {
                age = scanner.nextInt();
                if (age >= 18) {
                    flagAge = true;
                } else {
                    System.out.println("The driver should be older than 18!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number.");
                scanner.next();
            }
        }

        while (!flagExp) {
            System.out.print("ENTER EXPERIENCE (should be under age): ");
            try {
                experience = scanner.nextInt();
                if (experience < age) {
                    flagExp = true;
                } else {
                    System.out.println("Impossible exp from age:)");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number.");
                scanner.next();
            }
        }

        while (!flagPrice) {
            System.out.print("ENTER PRICE (cant be free -_-): ");
            try {
                priceDriving = scanner.nextInt();
                if (priceDriving > 0) {
                    flagPrice = true;
                } else {
                    System.out.println("Carsharing is not free.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number.");
                scanner.next();
            }
        }


        System.out.print("DATE OF DRIVING (YEAR, MONTH, DAY): ");
        dateDrive = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        System.out.print("DATE OF OFFENCE (YEAR, MONTH, DAY): ");
        dateOffence = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        System.out.println("----------------");
    }
}