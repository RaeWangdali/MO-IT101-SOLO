/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeesalarycalculator;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.io.*;
import java.nio.file.*;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class EmployeeSalaryCalculator {
    public static void main(String[] args) {
        String employeeDetailsPath = "C:\\Users\\Rae Bern Wangdali\\Desktop\\MAPUA\\MotorPH\\Employee Details.csv.csv";
        String employeeDataPath = "C:\\Users\\Rae Bern Wangdali\\Desktop\\MAPUA\\MotorPH\\MotorPH Employee Data - Employee Details.csv";
        
        Map<Integer, Double> hourlyRates = loadHourlyRates(employeeDataPath);
        calculateWeeklySalaries(employeeDetailsPath, hourlyRates);
    }
    
    private static Map<Integer, Double> loadHourlyRates(String filePath) {
        Map<Integer, Double> hourlyRates = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int employeeId = Integer.parseInt(data[0].trim());
                double hourlyRate = Double.parseDouble(data[data.length - 1].trim());
                hourlyRates.put(employeeId, hourlyRate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hourlyRates;
    }
    
    private static void calculateWeeklySalaries(String filePath, Map<Integer, Double> hourlyRates) {
        Map<Integer, Double> totalHoursWorked = new HashMap<>();
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int employeeId = Integer.parseInt(data[0].trim());
                LocalTime login = LocalTime.parse(data[4].trim());
                LocalTime logout = LocalTime.parse(data[5].trim());
                double hoursWorked = Duration.between(login, logout).toMinutes() / 60.0;
                totalHoursWorked.put(employeeId, totalHoursWorked.getOrDefault(employeeId, 0.0) + hoursWorked);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (Map.Entry<Integer, Double> entry : totalHoursWorked.entrySet()) {
            int employeeId = entry.getKey();
            double totalHours = entry.getValue();
            double hourlyRate = hourlyRates.getOrDefault(employeeId, 0.0);
            double weeklySalary = totalHours * hourlyRate;
            System.out.println("Employee ID: " + employeeId + ", Hours Worked: " + totalHours + ", Weekly Salary: " + weeklySalary);
        }
    }
}
