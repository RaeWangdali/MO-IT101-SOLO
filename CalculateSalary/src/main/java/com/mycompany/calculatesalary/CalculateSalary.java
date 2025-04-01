/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatesalary;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CalculateSalary {

    public static void main(String[] args) {
         try (BufferedReader br1 = new BufferedReader(new FileReader("Employee Details.csv.csv"));
             BufferedReader br2 = new BufferedReader(new FileReader("MotorPH Employee Data - Employee Details.csv"))) {
            String line1, line2;
            br1.readLine(); // Skip header row in attendance file
            br2.readLine(); // Skip header row in employee details file

            // Store employee details in a map for faster lookup
            Map<Integer, String[]> employeeDetails = new HashMap<>();
            while ((line2 = br2.readLine()) != null) {
                String[] employeeData = line2.split(",");
                int employeeNumber = Integer.parseInt(employeeData[0].trim());
                employeeDetails.put(employeeNumber, employeeData);
            }

            // Reset the employee details file reader to the beginning
            br2 = new BufferedReader(new FileReader("Employee Details.csv"));
            br2.readLine(); // Skip header row

            while ((line1 = br1.readLine()) != null) {
                String[] attendanceData = line1.split(",");
                int employeeNumber = Integer.parseInt(attendanceData[0].trim());
                String lastName = attendanceData[1].trim();
                String firstName = attendanceData[2].trim();
                String date = attendanceData[3].trim();
                LocalTime logIn = LocalTime.parse(attendanceData[4].trim(), DateTimeFormatter.ofPattern("H:mm"));
                LocalTime logOut = LocalTime.parse(attendanceData[5].trim(), DateTimeFormatter.ofPattern("H:mm"));
                long hoursWorked = logOut.toSecondOfDay() - logIn.toSecondOfDay();
                hoursWorked /= 3600; // Convert seconds to hours

                // Lookup employee details from the map
                String[] employeeData = employeeDetails.get(employeeNumber);
                if (employeeData != null) {
                    // Assuming the hourly rate is in the 14th column of the employee details file
                    double hourlyRate = Double.parseDouble(employeeData[13].trim().replace(",", ""));
                    double weeklySalary = hoursWorked * hourlyRate * 5; // Assuming a 5-day work week
                    System.out.println("Employee: " + lastName + ", " + firstName + " - Weekly Salary: " + weeklySalary);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}