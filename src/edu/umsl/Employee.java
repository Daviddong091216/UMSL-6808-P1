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
    protected float gross = 0.0f;
    private float tax = 0.0f;
    private float net = 0.0f;
    private float net_percent = 0.0f;
    //End Attributes

    /**
     * ******************
     * Constructors ******************
     */
    public Employee(int ID, String Fname, String Lname, float rate, float taxtrate, int hours) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.rate = rate;
        this.taxrate = taxrate;
        this.hours = hours;
    }

    public Employee(int ID, String Fname, String Lname) {
        this(ID, Fname, Lname, 30f, 0.2f, 40);
    }

    public Employee() {
        ID++;
    }

    /**
     * ******************
     * Methods ******************
     */
    public void menu() {
    }

    public float computeGross() {
        if (hours >= 0 && hours <= 40) {
            this.gross = this.hours * this.rate;
        }
        if (hours > 40) {
            this.gross = 40 * this.rate + (float) ((this.hours - 40) * this.rate * 1.5);
        }
        return gross;
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
