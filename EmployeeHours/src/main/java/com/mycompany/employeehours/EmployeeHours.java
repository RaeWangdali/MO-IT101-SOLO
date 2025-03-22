/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeehours;

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
    String date;
    LocalTime logIn;
    LocalTime logOut;
    Duration hoursWorked;

    public Employee(int employeeNumber, String lastName, String firstName, String date, String logIn, String logOut) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date = date;
        this.logIn = parseTime(logIn);
        this.logOut = parseTime(logOut);
        this.hoursWorked = calculateHoursWorked();
    }

    private LocalTime parseTime(String timeString) {
        try {
            return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format for employee " + employeeNumber + ": " + timeString);
            return null; // Or handle the error differently
        }
    }

    private Duration calculateHoursWorked() {
        if (logIn == null || logOut == null) {
            return Duration.ZERO; // Handle cases with invalid times
        }
        return Duration.between(logIn, logOut);
    }

    @Override
    public String toString() {
        long hours = hoursWorked.toHours();
        long minutes = hoursWorked.toMinutesPart();
        return String.format("Employee #%d: %s, %s (%s) - Hours Worked: %dh %dm",
                employeeNumber, lastName, firstName, date, hours, minutes);
    }
}
public class EmployeeHours {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10001, "Garcia", "Manuel III", "06/03/2024", "8:59", "18:31"));
        employees.add(new Employee(10002, "Lim", "Antonio", "06/03/2024", "10:35", "19:44"));
        employees.add(new Employee(10003, "Aquino", "Bianca Sofia", "06/03/2024", "10:23", "18:32"));
        employees.add(new Employee(10004, "Reyes", "Isabella", "06/03/2024", "10:57", "18:14"));
        employees.add(new Employee(10005, "Hernandez", "Eduard", "06/03/2024", "9:48", "17:13"));
        employees.add(new Employee(10006, "Villanueva", "Andrea Mae", "06/03/2024", "9:31", "19:29"));
        employees.add(new Employee(10007, "San Jose", "Brad", "06/03/2024", "9:09", "16:30"));
        employees.add(new Employee(10008, "Romualdez", "Alice", "06/03/2024", "9:02", "18:06"));
        employees.add(new Employee(10009, "Atienza", "Rosie", "06/03/2024", "8:18", "17:40"));
        employees.add(new Employee(10010, "Alvaro", "Roderick", "06/03/2024", "8:10", "15:13"));
        employees.add(new Employee(10011, "Salcedo", "Anthony", "06/03/2024", "9:08", "19:36"));
        employees.add(new Employee(10012, "Lopez", "Josie", "06/03/2024", "9:47", "18:43"));
        employees.add(new Employee(10013, "Farala", "Martha", "06/03/2024", "9:48", "19:21"));
        employees.add(new Employee(10014, "Martinez", "Leila", "06/03/2024", "9:23", "18:09"));
        employees.add(new Employee(10015, "Romualdez", "Fredrick", "06/03/2024", "8:41", "19:27"));
        employees.add(new Employee(10016, "Mata", "Christian", "06/03/2024", "8:41", "16:45"));
        employees.add(new Employee(10017, "De Leon", "Selena", "06/03/2024", "9:40", "17:24"));
        employees.add(new Employee(10018, "San Jose", "Allison", "06/03/2024", "8:22", "16:46"));
        employees.add(new Employee(10019, "Rosario", "Cydney", "06/03/2024", "9:53", "17:24"));
        employees.add(new Employee(10020, "Bautista", "Mark", "06/03/2024", "8:47", "16:27"));
        employees.add(new Employee(10021, "Lazaro", "Darlene", "06/03/2024", "9:37", "18:45"));
        employees.add(new Employee(10022, "Delos Santos", "Kolby", "06/03/2024", "10:54", "20:10"));
        employees.add(new Employee(10023, "Santos", "Vella", "06/03/2024", "10:27", "20:10"));
        employees.add(new Employee(10024, "Del Rosario", "Tomas", "06/03/2024", "9:16", "17:57"));
        employees.add(new Employee(10025, "Tolentino", "Jacklyn", "06/03/2024", "10:18", "18:07"));
        employees.add(new Employee(10026, "Gutierrez", "Percival", "06/03/2024", "8:17", "18:31"));
        employees.add(new Employee(10027, "Manalaysay", "Garfield", "06/03/2024", "9:05", "19:14"));
        employees.add(new Employee(10028, "Villegas", "Lizeth", "06/03/2024", "8:52", "17:23"));
        employees.add(new Employee(10029, "Ramos", "Carol", "06/03/2024", "10:57", "21:44"));
        employees.add(new Employee(10030, "Maceda", "Emelia", "06/03/2024", "9:04", "16:39"));
        employees.add(new Employee(10031, "Aguilar", "Delia", "06/03/2024", "10:07", "20:51"));
        employees.add(new Employee(10032, "Castro", "John Rafael", "06/03/2024", "8:29", "16:46"));
        employees.add(new Employee(10033, "Martinez", "Carlos Ian", "06/03/2024", "10:02", "19:39"));
        employees.add(new Employee(10034, "Santos", "Beatriz", "06/03/2024", "10:05", "18:12"));


        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
