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
public class HourlyEmployee extends Employee {

    private float rate = 30.0f;
    private int hours = 45;

    public HourlyEmployee(float rate, int hours) {
        super();
        this.rate = rate;
        this.hours = hours;
    }
    public HourlyEmployee() {
        super();
    }

    @Override
    public void menu() {
        super.menu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rate: ");
        rate = sc.nextFloat();
        System.out.print("Enter hours: ");
        hours = sc.nextInt();
    }

    @Override
    public void computeGross() {
        if (hours >= 0 && hours <= 40) {
            this.gross = this.hours * this.rate;
        }
        if (hours > 40) {
            this.gross = 40 * this.rate + (float) ((this.hours - 40) * this.rate * 1.5);
        }
    }

    @Override
    protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
        
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

}
