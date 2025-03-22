/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeedeductions;

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
    double grossPay;
    double sss;
    double philhealth;
    double pagibig;
    double incomeTax;
    double netPay;


    public Employee(int employeeNumber, String lastName, String firstName, String birthday, String date, String logIn, String logOut, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.date = date;
        this.logIn = parseTime(logIn);
        this.logOut = parseTime(logOut);
        this.hourlyRate = hourlyRate;
        this.grossPay = calculateGrossPay();
        this.sss = calculateSSS();
        this.philhealth = calculatePhilHealth();
        this.pagibig = calculatePagIBIG();
        this.incomeTax = calculateIncomeTax();
        this.netPay = calculateNetPay();

    }

    private LocalTime parseTime(String timeString) {
        try {
            return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            System.err.println("Invalid time format for employee " + employeeNumber + ": " + timeString);
            return null; // Or handle the error differently
        }
    }

    private double calculateGrossPay() {
        if (logIn == null || logOut == null) {
            return 0; // Handle cases with invalid times
        }
        Duration duration = Duration.between(logIn, logOut);
        double totalHours = duration.toHours() + duration.toMinutesPart() / 60.0;
        return totalHours * hourlyRate;
    }

    private double calculateSSS() {
        if (grossPay <= 3250) return 135.00;
        if (grossPay <= 3750) return 157.50;
        if (grossPay <= 4250) return 180.00;
        if (grossPay <= 4750) return 202.50;
        if (grossPay <= 5250) return 225.00;
        if (grossPay <= 5750) return 247.50;
        if (grossPay <= 6250) return 270.00;
        if (grossPay <= 6750) return 292.50;
        if (grossPay <= 7250) return 315.00;
        if (grossPay <= 7750) return 337.50;
        if (grossPay <= 8250) return 360.00;
        if (grossPay <= 8750) return 382.50;
        if (grossPay <= 9250) return 405.00;
        if (grossPay <= 9750) return 427.50;
        if (grossPay <= 10250) return 450.00;
        if (grossPay <= 10750) return 472.50;
        if (grossPay <= 11250) return 495.00;
        if (grossPay <= 11750) return 517.50;
        if (grossPay <= 12250) return 540.00;
        if (grossPay <= 12750) return 562.50;
        if (grossPay <= 13250) return 585.00;
        if (grossPay <= 13750) return 607.50;
        if (grossPay <= 14250) return 630.00;
        if (grossPay <= 14750) return 652.50;
        if (grossPay <= 15250) return 675.00;
        if (grossPay <= 15750) return 697.50;
        if (grossPay <= 16250) return 720.00;
        if (grossPay <= 16750) return 742.50;
        if (grossPay <= 17250) return 765.00;
        if (grossPay <= 17750) return 787.50;
        if (grossPay <= 18250) return 810.00;
        if (grossPay <= 18750) return 832.50;
        if (grossPay <= 19250) return 855.00;
        if (grossPay <= 19750) return 877.50;
        if (grossPay <= 20250) return 900.00;
        if (grossPay <= 20750) return 922.50;
        if (grossPay <= 21250) return 945.00;
        if (grossPay <= 21750) return 967.50;
        if (grossPay <= 22250) return 990.00;
        if (grossPay <= 22750) return 1012.50;
        if (grossPay <= 23250) return 1035.00;
        if (grossPay <= 23750) return 1057.50;
        if (grossPay <= 24250) return 1080.00;
        if (grossPay <= 24750) return 1102.50;
        return 1125.00;
    }

    private double calculatePhilHealth() {
        if (grossPay <= 10000) return 150; //Employee's share only
        if (grossPay <= 59999.99) return 150; //Assuming max 300, employee's share only
        return 900; //Employee's share only

    }

    private double calculatePagIBIG() {
        if (grossPay <= 1500) return grossPay * 0.01;
        return Math.min(grossPay * 0.02, 100);
    }

    private double calculateIncomeTax() {
        double taxableIncome = grossPay - sss - philhealth - pagibig;
        if (taxableIncome <= 20832) return 0;
        if (taxableIncome <= 33333) return (taxableIncome - 20833) * 0.20;
        if (taxableIncome <= 66667) return 2500 + (taxableIncome - 33333) * 0.25;
        if (taxableIncome <= 166667) return 10833 + (taxableIncome - 66667) * 0.30;
        if (taxableIncome <= 666667) return 40833.33 + (taxableIncome - 166667) * 0.32;
        return 200833.33 + (taxableIncome - 666667) * 0.35;
    }

    private double calculateNetPay() {
        return grossPay - sss - philhealth - pagibig - incomeTax;
    }


    @Override
    public String toString() {
        return String.format("Employee #%d: %s, %s\nBirthday: %s, Date: %s\nGross Pay: %.2f\nSSS: %.2f\nPhilHealth: %.2f\nPag-IBIG: %.2f\nIncome Tax: %.2f\nNet Pay: %.2f",
                employeeNumber, lastName, firstName, birthday, date, grossPay, sss, philhealth, pagibig, incomeTax, netPay);
    }
    public double calculateHoursWorked(){
        if (logIn == null || logOut == null) {
            return 0; // Handle cases with invalid times
        }
        Duration duration = Duration.between(logIn, logOut);
        return duration.toHours() + duration.toMinutesPart() / 60.0;
    }
}

public class EmployeeDeductions {
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
            System.out.println("--------------------");
        }
    }
}
