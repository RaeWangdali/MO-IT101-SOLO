/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.applydeductions;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ApplyDeductions {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Rae Bern Wangdali\\Desktop\\MAPUA\\MotorPH\\Witholding Tax.csv"))) {
            String line;
            br.readLine(); // Skip the header row
            while ((line = br.readLine()) != null) {
                String[] deductionData = line.split(",");
                // Assuming the CSV columns are in the order: Monthly Salary, SSS Deduction, Philhealth Deduction, Pag-ibig Deduction, ...
                double monthlySalary = Double.parseDouble(deductionData[0].trim());
                double sssDeduction = Double.parseDouble(deductionData[1].trim());
                double philhealthDeduction = Double.parseDouble(deductionData[2].trim());
                double pagibigDeduction = Double.parseDouble(deductionData[3].trim());
                // ... other deductions can be parsed similarly
                
                // Read gross salary from "MotorPH Employee Data - Employee Details.csv" 
                // (You'll need to implement logic to match the employee number)
                double grossSalary = 0.0; // Replace with actual gross salary
                
                double totalDeductions = sssDeduction + philhealthDeduction + pagibigDeduction; // Add other deductions
                double taxableIncome = grossSalary - totalDeductions;
                // Calculate withholding tax based on taxable income (refer to the "Witholding Tax" file)
                double withholdingTax = 0.0; // Calculate based on the provided tax table
                
                double netWage = grossSalary - totalDeductions - withholdingTax;
                System.out.println("Gross Salary: " + grossSalary);
                System.out.println("Total Deductions: " + totalDeductions);
                System.out.println("Withholding Tax: " + withholdingTax);
                System.out.println("Net Wage: " + netWage);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}