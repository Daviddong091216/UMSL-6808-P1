/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author 16366
 */
public class Employee implements Serializable{

    /**
     * *******************
     * Attributes *******************
     */
    private int ID;
    private String Fname;
    private String Lname;
    private float taxrate = 0.2f;
    protected float gross = 0.0f;
    protected float tax = 0.0f;
    protected float net = 0.0f;
    protected float net_percent = 0.0f;

    //End Attributes
    /**
     * ******************
     * Constructors ******************
     */
    public Employee(int ID, String Fname, String Lname, float taxtrate) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.taxrate = taxrate;
    }

    public Employee(int ID, String Fname, String Lname) {
        this(ID, Fname, Lname, 0.2f);
    }

    public Employee() {
        ID++;
    }

    /**
     * ******************
     * Methods ******************
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        ID = sc.nextInt();
        System.out.print("Enter first name: ");
        Fname = sc.next();
        System.out.print("Enter last name: ");
        Lname = sc.next();
        System.out.print("Enter tax rate: ");
        taxrate = sc.nextFloat();
    }

    public void computeGross() {
        //gross = gross;//???
    }

    protected void computeTax() {
        tax = gross * taxrate;
    }

    protected void computeNet() {
        net = gross - tax;
    }

    protected void computeNetperc() {
        net_percent = (net / gross) * 100;
    }

    protected void displayEmployee() {
        System.out.println("ID: " + ID);
        System.out.println("First Name: " + Fname);
        System.out.println("Last Name: " + Lname);
        System.out.println("Tax rate: " + net);
//        System.out.println("Gross: " + gross);
//        System.out.println("Net: " + net);
//        System.out.println("Net%: " + net_percent + "%");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(float taxrate) {
        this.taxrate = taxrate;
    }

}
