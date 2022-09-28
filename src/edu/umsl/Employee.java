/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

/**
 *
 * @author 16366
 */
public class Employee {

    /**
     * *******************
     * Attributes *******************
     */
    private int ID;
    private String Fname;
    private String Lname;
    private float rate = 30.0f;
    private float taxrate = 0.2f;
    private int hours = 45;
    private float gross = 0.0f;
    private float tax = 0.0f;
    private float net = 0.0f;
    private float net_percent = 0.0f;
    //End Attributes

    /**
     * ******************
     * Constructors ******************
     */
    public Employee() {
    }

    /**
     * ******************
     * Methods ******************
     */
    public void menu() {
    }

    public void computeGross() {
        gross = rate * hours;
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
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
        System.out.println("Gross: " + gross);
        System.out.println("Net: " + net);
        System.out.println("Net%: " + net_percent + "%");
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

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(float taxrate) {
        this.taxrate = taxrate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
