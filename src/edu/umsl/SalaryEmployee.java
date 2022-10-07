/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;

/**
 *
 * @author 16366
 */
public class SalaryEmployee extends Employee {

    String salaryCategory;

    public SalaryEmployee() {
        super();
    }

    @Override
    public void menu() {
        super.menu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary category, Staff or Exective[SE or EE]: ");
        salaryCategory = sc.next();

    }

    @Override
    public void computeGross() {
        if (salaryCategory.equalsIgnoreCase("SE")) {
            this.gross = 50000;
        }
        if (salaryCategory.equalsIgnoreCase("EE")) {
            this.gross = 100000;
        }
    }
    
    

    @Override
    protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Salary category: " + salaryCategory);
    }

    public String getSalaryCategory() {
        return salaryCategory;
    }

    public void setSalaryCategory(String salaryCategory) {
        this.salaryCategory = salaryCategory;
    }

}
