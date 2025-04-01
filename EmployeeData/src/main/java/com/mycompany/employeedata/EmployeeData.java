/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeedata;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeData {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Rae Bern Wangdali\\Desktop\\MAPUA\\MotorPH\\MotorPH Employee Data - Employee Details.csv"))) {
            String line;
            br.readLine(); // Skip the header row
            while ((line = br.readLine()) != null) {
                String[] employeeData = line.split(",");
                // Assuming the CSV columns are in the order: Employee #, Last Name, First Name, ...
                int employeeNumber = Integer.parseInt(employeeData[0].trim());
                String lastName = employeeData[1].trim();
                String firstName = employeeData[2].trim();
                // ... other data types can be parsed similarly
                System.out.println("Employee Number: " + employeeNumber);
                System.out.println("Last Name: " + lastName);
                System.out.println("First Name: " + firstName);
                // ... display other employee information
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
