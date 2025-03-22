/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeedata;

/**
 *
 * @author Rae Bern Wangdali
 */
import java.util.ArrayList;
import java.util.List;

class Employee {
    int employeeNumber;
    String lastName;
    String firstName;
    String birthday;

    public Employee(int employeeNumber, String lastName, String firstName, String birthday) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee #" + employeeNumber + ": " + lastName + ", " + firstName + " (" + birthday + ")";
    }
}

public class EmployeeData {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10001, "Garcia", "Manuel III", "10/11/1983"));
        employees.add(new Employee(10002, "Lim", "Antonio", "06/19/1988"));
        employees.add(new Employee(10003, "Aquino", "Bianca Sofia", "08/04/1989"));
	employees.add(new Employee(10004, "Reyes", "Isabella", "06/16/1994"));
	employees.add(new Employee(10005, "Hernandez", "Eduard", "09/23/1989"));
	employees.add(new Employee(10006, "Villanueva", "Andrea Mae", "02/14/1988"));
	employees.add(new Employee(10007, "San Jose", "Brad", "03/15/1996"));
	employees.add(new Employee(10008, "Romualdez", "Alice", "05/14/1992"));
	employees.add(new Employee(10009, "Atienza", "Rosie", "09/24/1948"));
	employees.add(new Employee(10010, "Alvaro", "Roderick", "03/30/1988"));
	employees.add(new Employee(10011, "Salcedo", "Anthony", "09/14/1993"));
	employees.add(new Employee(10012, "Lopez", "Josie", "01/14/1987"));
	employees.add(new Employee(10013, "Farala", "Martha", "01/11/1942"));
	employees.add(new Employee(10014, "Martinez", "Leila", "07/11/1970"));
	employees.add(new Employee(10015, "Romualdez", "Fredrick", "03/10/1985"));
	employees.add(new Employee(10016, "Mata", "Christian", "10/21/1987"));
	employees.add(new Employee(10017, "De Leon", "Selena", "02/20/1975"));
	employees.add(new Employee(10018, "San Jose", "Allison", "06/24/1986"));
	employees.add(new Employee(10019, "Rosario", "Cydney", "10/06/1996"));
	employees.add(new Employee(10020, "Bautista", "Mark", "02/12/1991"));
	employees.add(new Employee(10021, "Lazaro", "Darlene", "11/25/1985"));
	employees.add(new Employee(10022, "Delos Santos", "Kolby", "02/26/1980"));
	employees.add(new Employee(10023, "Santos", "Vella", "12/31/1983"));
	employees.add(new Employee(10024, "Del Rosario", "Tomas", "12/18/1978"));
	employees.add(new Employee(10025, "Tolentino", "Jacklyn", "05/19/1984"));
	employees.add(new Employee(10026, "Gutierrez", "Percival", "12/18/1970"));
	employees.add(new Employee(10027, "Manalaysay", "Garfield", "08/28/1986"));
	employees.add(new Employee(10028, "Villegas", "Lizeth", "12/12/1981"));
	employees.add(new Employee(10029, "Ramos", "Carol", "08/20/1978"));
	employees.add(new Employee(10030, "Maceda", "Emelia", "04/14/1973"));
	employees.add(new Employee(10031, "Aguilar", "Delia", "01/27/1989"));
	employees.add(new Employee(10032, "Castro", "John Rafael", "02/09/1992"));
	employees.add(new Employee(10033, "Martinez", "Carlos Ian", "11/16/1990"));
	employees.add(new Employee(10034, "Santos", "Beatriz", "08/07/1990"));


        // Display employee information in the console
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
