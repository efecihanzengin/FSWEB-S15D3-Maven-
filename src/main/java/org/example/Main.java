package org.example;


import org.example.entity.Employee;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        LinkedList<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(101, "efe","zengin"));
        employeeList.add( new Employee(201, "inci","zengin"));
        employeeList.add( new Employee(301, "elif","zengin"));
        employeeList.add( new Employee(401, "burhan","zengin"));
        employeeList.add( new Employee(101, "efe","zengin"));

        List<Employee> duplicates = findDuplicates(employeeList);
        System.out.println("Tekrar eden calisanlar" + duplicates);
    }

    public static List<Employee> findDuplicates(List<Employee> employeeList) {
        Set<Employee> duplicateEmployees = new HashSet<>();
        Set<Employee> seenEmployees = new HashSet<>();
        for(Employee employee : employeeList) {

            if(seenEmployees.contains(employee)) {
                duplicateEmployees.add(employee);
            } else {
                seenEmployees.add(employee);
            }
        }
        return new ArrayList<>(duplicateEmployees);

    }

    public static Map<Employee, Integer> findUniques(List<Employee> employeeList) {
        Map<Employee, Integer> employeeSayilari = new HashMap<>();

        for(Employee employee : employeeList) {
            if(employeeSayilari.containsKey(employee)){
                int mevcutSayi = employeeSayilari.get(employee);
                employeeSayilari.put(employee, mevcutSayi + 1);
            }
            else {
                employeeSayilari.put(employee, 1);
            }
        }
        return employeeSayilari;

    }

    public static List<Employee> removeDuplicates (List<Employee> employeeList) {
        Map<Employee,Integer> employeeCounts = findUniques(employeeList);
        List<Employee> uniqueEmployees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employeeCounts.get(employee) == 1) {
                uniqueEmployees.add(employee);
            }
        }

        return uniqueEmployees;
    }



}
