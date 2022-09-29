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
public class CommissionEmployee extends Employee {

    private int items;
    private float itemPrice;
    
    public CommissionEmployee(int items, float itemPrice) {
        super();
        this.items = items;
        this.itemPrice = itemPrice;
    }
    public CommissionEmployee() {
        super();
    } 
    
    @Override
    public void menu() {
        super.menu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter items: ");
        items = sc.nextInt();
        System.out.print("Enter item price: ");
        itemPrice = sc.nextFloat();
    }

    @Override
    public void computeGross() {
        gross = items * itemPrice / 2;
    }

    @Override
    protected void displayEmployee() {
        super.displayEmployee();
        System.out.println("Items: " + items);
        System.out.println("Item price: " + itemPrice);
        
    }
    
    
    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

}
