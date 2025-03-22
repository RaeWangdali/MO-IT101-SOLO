/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeesalary;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class Employee {
    int employeeNumber;
    String lastName;
    String firstName;
    String birthday;
    String date;
    LocalTime logIn;
    LocalTime logOut;
    double hourlyRate;
    double weeklySalary;

    public Employee(int employeeNumber, String lastName, String firstName, String birthday, String date, String logIn, String logOut, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.date = date;
        this.logIn = parseTime(logIn);
        this.logOut = parseTime(logOut);
        this.hourlyRate = hourlyRate;
        this.weeklySalary = calculateWeeklySalary();
    }

    private LocalTime parseTime(String timeString) {
        try {
            return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format for employee " + employeeNumber + ": " + timeString);
            return null; // Or handle the error differently
        }
    }

    private double calculateWeeklySalary() {
        if (logIn == null || logOut == null) {
            return 0; // Handle cases with invalid times
        }
        Duration duration = Duration.between(logIn, logOut);
        double totalHours = duration.toHours() + duration.toMinutesPart() / 60.0;
        return totalHours * hourlyRate;
    }

    @Override
    public String toString() {
        return String.format("Employee #%d: %s, %s (Birthday: %s, Date: %s) - Hours Worked: %.2f, Weekly Salary: %.2f",
                employeeNumber, lastName, firstName, birthday, date, calculateHoursWorked(), weeklySalary);
    }

    public double calculateHoursWorked(){
        if (logIn == null || logOut == null) {
            return 0; // Handle cases with invalid times
        }
        Duration duration = Duration.between(logIn, logOut);
        return duration.toHours() + duration.toMinutesPart() / 60.0;
    }
}
public class EmployeeSalary {

    public static void main(String[] args) {
         List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10001, "Garcia", "Manuel III", "10/11/1983", "06/03/2024", "8:59", "18:31", 535.71));
        employees.add(new Employee(10002, "Lim", "Antonio", "06/19/1988", "06/03/2024", "10:35", "19:44", 357.14));
        employees.add(new Employee(10003, "Aquino", "Bianca Sofia", "08/04/1989", "06/03/2024", "10:23", "18:32", 357.14));
        employees.add(new Employee(10004, "Reyes", "Isabella", "06/16/1994", "06/03/2024", "10:57", "18:14", 357.14));
        employees.add(new Employee(10005, "Hernandez", "Eduard", "09/23/1989", "06/03/2024", "9:48", "17:13", 313.51));
        employees.add(new Employee(10006, "Villanueva", "Andrea Mae", "02/14/1988", "06/03/2024", "9:31", "19:29", 313.51));
        employees.add(new Employee(10007, "San Jose", "Brad", "03/15/1996", "06/03/2024", "9:09", "16:30", 255.8));
        employees.add(new Employee(10008, "Romualdez", "Alice", "05/14/1992", "06/03/2024", "9:02", "18:06", 133.93));
        employees.add(new Employee(10009, "Atienza", "Rosie", "09/24/1948", "06/03/2024", "8:18", "17:40", 133.93));
        employees.add(new Employee(10010, "Alvaro", "Roderick", "03/30/1988", "06/03/2024", "8:10", "15:13", 313.51));
        employees.add(new Employee(10011, "Salcedo", "Anthony", "09/14/1993", "06/03/2024", "9:08", "19:36", 302.53));
        employees.add(new Employee(10012, "Lopez", "Josie", "01/14/1987", "06/03/2024", "9:47", "18:43", 229.02));
        employees.add(new Employee(10013, "Farala", "Martha", "01/11/1942", "06/03/2024", "9:48", "19:21", 142.86));
        employees.add(new Employee(10014, "Martinez", "Leila", "07/11/1970", "06/03/2024", "9:23", "18:09", 142.86));
        employees.add(new Employee(10015, "Romualdez", "Fredrick", "03/10/1985", "06/03/2024", "8:41", "19:27", 318.45));
        employees.add(new Employee(10016, "Mata", "Christian", "10/21/1987", "06/03/2024", "8:41", "16:45", 255.8));
        employees.add(new Employee(10017, "De Leon", "Selena", "02/20/1975", "06/03/2024", "9:40", "17:24", 249.11));
        employees.add(new Employee(10018, "San Jose", "Allison", "06/24/1986", "06/03/2024", "8:22", "16:46", 133.93));
        employees.add(new Employee(10019, "Rosario", "Cydney", "10/06/1996", "06/03/2024", "9:53", "17:24", 133.93));
        employees.add(new Employee(10020, "Bautista", "Mark", "02/12/1991", "06/03/2024", "8:47", "16:27", 138.39));
        employees.add(new Employee(10021, "Lazaro", "Darlene", "11/25/1985", "06/03/2024", "9:37", "18:45", 138.39));
        employees.add(new Employee(10022, "Delos Santos", "Kolby", "02/26/1980", "06/03/2024", "10:54", "20:10", 142.86));
        employees.add(new Employee(10023, "Santos", "Vella", "12/31/1983", "06/03/2024", "10:27", "20:10", 133.93));
        employees.add(new Employee(10024, "Del Rosario", "Tomas", "12/18/1978", "06/03/2024", "9:16", "17:57", 133.93));
        employees.add(new Employee(10025, "Tolentino", "Jacklyn", "05/19/1984", "06/03/2024", "10:18", "18:07", 142.86));
        employees.add(new Employee(10026, "Gutierrez", "Percival", "12/18/1970", "06/03/2024", "8:17", "18:31", 147.32));
        employees.add(new Employee(10027, "Manalaysay", "Garfield", "08/28/1986", "06/03/2024", "9:05", "19:14", 147.32));
        employees.add(new Employee(10028, "Villegas", "Lizeth", "12/12/1981", "06/03/2024", "8:52", "17:23", 142.86));
        employees.add(new Employee(10029, "Ramos", "Carol", "08/20/1978", "06/03/2024", "10:57", "21:44", 133.93));
        employees.add(new Employee(10030, "Maceda", "Emelia", "04/14/1973", "06/03/2024", "9:04", "16:39", 133.93));
        employees.add(new Employee(10031, "Aguilar", "Delia", "01/27/1989", "06/03/2024", "10:07", "20:51", 133.93));
        employees.add(new Employee(10032, "Castro", "John Rafael", "02/09/1992", "06/03/2024", "8:29", "16:46", 313.51));
        employees.add(new Employee(10033, "Martinez", "Carlos Ian", "11/16/1990", "06/03/2024", "10:02", "19:39", 313.51));
        employees.add(new Employee(10034, "Santos", "Beatriz", "08/07/1990", "06/03/2024", "10:05", "18:12", 313.51));

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
