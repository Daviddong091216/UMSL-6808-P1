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
        System.out.print("Enter salary category, Staff or Exective[S or E]: ");
        salaryCategory = sc.next();

    }

    @Override
    public void computeGross() {
        if (salaryCategory.equalsIgnoreCase("S")) {
            this.gross = 50000;
        }
        if (salaryCategory.equalsIgnoreCase("E")) {
            this.gross = 100000;
        }
    }

//    @Override
//    protected void displayEmployee() {
//        super.displayEmployee();
//        System.out.println("Salary category: " + salaryCategory);
//    }

}
