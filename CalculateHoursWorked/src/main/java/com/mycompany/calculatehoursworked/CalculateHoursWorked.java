/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatehoursworked;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalculateHoursWorked {

    public static void main(String[] args) {
         try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Rae Bern Wangdali\\Desktop\\MAPUA\\MotorPH\\Employee Details.csv.csv"))) {
            String line;
            br.readLine(); // Skip the header row
            while ((line = br.readLine()) != null) {
                String[] attendanceData = line.split(",");
                // Assuming the CSV columns are in the order: Employee #, Last Name, First Name, Date, Log In, Log Out
                int employeeNumber = Integer.parseInt(attendanceData[0].trim());
                String lastName = attendanceData[1].trim();
                String firstName = attendanceData[2].trim();
                String date = attendanceData[3].trim();
                LocalTime logIn = LocalTime.parse(attendanceData[4].trim(), DateTimeFormatter.ofPattern("H:mm"));
                LocalTime logOut = LocalTime.parse(attendanceData[5].trim(), DateTimeFormatter.ofPattern("H:mm"));
                long hoursWorked = logOut.toSecondOfDay() - logIn.toSecondOfDay();
                hoursWorked /= 3600; // Convert seconds to hours
                System.out.println("Employee: " + lastName + ", " + firstName + " - Hours Worked: " + hoursWorked);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}