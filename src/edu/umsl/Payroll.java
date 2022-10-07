/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 16366
 */
public class Payroll {

//    ArrayList<Employee> earray = new ArrayList<>();
    Employee[] earray = new Employee[3];

    public static void main(String[] args) {
        Payroll pr = new Payroll();
        pr.topMenu();

    }

    /*
    Main method
Menu method
Populate Employees method
Select Employee method
Save Employee method
Load Employee method
    
     */
    public void topMenu() {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("0) load employee data from file");
            System.out.println("1) populate employees");
            System.out.println("2) lookup employee by id");
            System.out.println("3) save employee data to file[as a serialized object]");
            System.out.println("4) save employee data to file[as a text file]");
            System.out.println("5) show all employees data ");
            System.out.println("6) edit employee data ");
            System.out.println("7) exit");
            input = sc.nextInt();

            if (input == 0) {
                loadEmployeeData();
            } else if (input == 1) {
                populateEmployees();
            } else if (input == 2) {
                lookupEmployees();
            } else if (input == 3) {
                saveEmployeeAsSeObj();
            } else if (input == 4) {
                saveEmployeeAsTextFile();
            } else if (input == 5) {
                showAll();
            } else if (input == 6) {
                editEmployee();
            } else if (input == 7) {
                System.out.println("Goodbye! Thanks to Brian Lawton! You are the best!!");
            } else {
                System.out.println("Invalid input, please try again!");
            }

        } while (input != 7);
    }

    public void showEmployeesBrief() {
        for (int i = 0; i < earray.length; i++) {
            System.out.println(earray[i].getID() + " " + earray[i].getFname());
        }
    }

    /*
    public void checkUniqueID(int tempID) {
        boolean isUniqueID = false;
//        do {
        for (int i = 0; i < earray.length; i++) {
            if (earray[i].getID() == tempID) {
                isUniqueID = false;
                System.out.println("The employee ID isn't unique, please reenter it.");
                System.out.println("The suggestion of employee ID is : " + (theMaxID() + 1));
            }
        }
//        } while (isUniqueID == false);

    }

    public int theMaxID() {
        int maxID = earray[0].getID();
        for (int i = 0; i < earray.length; i++) {
            if (earray[i].getID() > maxID) {
                maxID = earray[i].getID();
            }
        }
        return maxID;
    }
     */
 /*
Load Employee
You will load back in the serialized objects from the saved file
You should use a boolean variable that is set to true if you have loaded employees
This in turn would inform users and prevent them from populating employees if they select that option
     */
    public void loadEmployeeData() {
        System.out.println("loadEmployeeData works");

        try {
            FileInputStream fis = new FileInputStream("SerEmployees6808P1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            earray = (Employee[]) ois.readObject();
            fis.close();
            System.out.println("Congratulates. Loading a file is success. Here is the data brief...");
            showEmployeesBrief();
        } catch (IOException e) {
            System.err.println("An error was encounter please try again.");
            topMenu();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("File to load accounts was not found.");
            topMenu();
        }
    }

    /*
    Populate Employees
You should populate an array of employees in your program:
Hourly Employee
Prompt for Hours Worked
Prompt for Pay Rate
Make sure to calculate for overtime at time and a half
     */
    public void populateEmployees() {
        int id, hours, items;
        String Fname, Lname;
        float rate, taxrate, itemPrice;

        String id_holdinput;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < earray.length; i++) {

            System.out.println("Please enter if you are a Hourly Employee or Salary Employee or Commission Employee [HE or SE or CE], enter Q to quit!");

            String input = sc.next();

            if (input.equalsIgnoreCase("HE")) {
                earray[i] = new HourlyEmployee();
                earray[i].menu();
//                earray[i].displayEmployee();
            } else if (input.equalsIgnoreCase("SE")) {
                earray[i] = new SalaryEmployee();
                earray[i].menu();
//                earray[i].displayEmployee();
            } else if (input.equalsIgnoreCase("CE")) {
                earray[i] = new CommissionEmployee();
                earray[i].menu();
//                earray[i].displayEmployee();
            } else if (input.equalsIgnoreCase("Q")) {
                System.out.println("You quit the input.");
                break;
            } else {
                System.out.println("Invalid input, please try again... ");
            }
        }

        showEmployeesBrief();
    }

    /*
    Select Employee
Loop through your array and select the employee
Once the employee is selected you will get a menu inside of each Employee that allows you to select the following
Calculate Gross Pay
Calculate Tax
Calculate Net Pay
Calculate Net Percent
Display Employee (You can make this method calculate all before displaying)
Go Back or Exit
     */
    public void lookupEmployees() {
        System.out.println("lookupEmployees works");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your ID so we can look you up:");
        int searchID = sc.nextInt();
        int index = -1;
        for (int i = 0; i < earray.length; i++) {
            if (earray[i].getID() == searchID) {
                index = i;
                System.out.println("You selected ID is: " + i);
                break;
            }
        }

        if (index == -1) {
            System.out.println("We didn't find your record, please contact system administrator");
        } else {
            System.out.println("We found your record. What do you want to look up:");
            int selectedID;
            do {
                System.out.println("1) Caculate Gross pay");
                System.out.println("2) Caculate Tax");
                System.out.println("3) Caculate Net Pay");
                System.out.println("4) Caculate Net Percent");
                System.out.println("5) Display Employee ");
                System.out.println("6) exit and return to the main menu");
                selectedID = sc.nextInt();
                if (selectedID == 1) {
                    earray[index].computeGross();
                    System.out.println("Employee gross: " + earray[index].gross);
                } else if (selectedID == 2) {
                    earray[index].computeGross();
                    earray[index].computeTax();
                    System.out.println("Employee tax: " + earray[index].tax);
                } else if (selectedID == 3) {
                    earray[index].computeGross();
                    earray[index].computeTax();
                    earray[index].computeNet();
                    System.out.println("Employee net: " + earray[index].net);
                } else if (selectedID == 4) {
                    earray[index].computeGross();
                    earray[index].computeTax();
                    earray[index].computeNet();
                    earray[index].computeNetperc();
                    System.out.println("Employee net percent: " + earray[index].net_percent);
                } else if (selectedID == 5) {
                    earray[index].displayEmployee();
                } else if (selectedID == 6) {
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Invalid input, please try again!");
                }
            } while (selectedID != 6);

        }
    }

    /*
   Save Employees
Save the array or collection of Employees as a serialized object
Additionally you will save a file/report of each employee as a text file 
     */
    public void saveEmployeeAsSeObj() {
        System.out.println(" saveEmployeeAsSeObj works");
        try {
            FileOutputStream fos = new FileOutputStream("SerEmployees6808P1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(earray);
            oos.flush();
            fos.close();
            System.out.println("Saving array object as a serialized object is done");
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public void saveEmployeeAsTextFile() {
        System.out.println("saveEmployeeAsTextFile  works");

        try {
            File file = new File("TextEmployees.txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < earray.length; i++) {
                String tempID = Integer.toString(earray[i].getID());
                String tempFname = earray[i].getFname();
                String tempLname = earray[i].getLname();
                String temptaxrate = Float.toString(earray[i].getTaxrate());

//                String temprate = Float.toString(earray[i].getRate());
//                String temphours = Integer.toString(earray[i].getHours());
//                String tempgross = Float.toString(earray[i].computeGross());
//                String temptax = Float.toString(earray[i].computeTax());
//                String tempnet = Float.toString(earray[i].computeNet());
//                String tempnetperc = Float.toString(earray[i].computeNetperc());
                bw.write(tempID);
                bw.write("|");
                bw.write(tempFname);
                bw.write("|");
                bw.write(tempLname);
                bw.write("|");
                bw.write(temptaxrate);
                bw.write("|");

//                bw.write(temprate);
//                bw.write("|");
//                bw.write(temphours);
//                bw.write("|");
//                bw.write(tempgross);
//                bw.write("|");
//                bw.write(temptax);
//                bw.write("|");
//                bw.write(tempnet);
//                bw.write("|");
//                bw.write(tempnetperc);
//                bw.newLine();
            }
            System.out.println("Saving array object as a txt file is done");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAll() {
        System.out.println(" showAllEmployee works");
//        if (earray[0].getID() == 0) {
        if (earray == null) {
            System.out.println("You don't have any employees' data");
        } else {
            for (int i = 0; i < earray.length; i++) {
                earray[i].displayEmployee();
            }
        }
    }

    public void editEmployee() {
        System.out.println(" editEmployee works");
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the employee ID so we can edit it:");
        int searchID = sc.nextInt();
        int index = -1;
        for (int i = 0; i < earray.length; i++) {
            if (earray[i].getID() == searchID) {
                index = i;
                System.out.println("We found your record.");
                break;
            }
        }

        if (index == -1) {
            System.out.println("We didn't find your record, please contact system administrator");
        } else {
            if (earray[index] instanceof HourlyEmployee) {
                HourlyEmployee hm = (HourlyEmployee) earray[index];
                System.out.println("The employee is an hourly employee. ");
                System.out.println("Please enter which do you want to edit[ID,Fname,Lname,rate,taxrate,hours]: ");
                String editItem = sc.next();
                if (editItem.equalsIgnoreCase("ID")) {
                    System.out.println("Employee old ID: " + earray[index].getID());
                    System.out.println("Please enter employee new ID: ");
                    earray[index].setID(sc.nextInt());
                } else if (editItem.equalsIgnoreCase("Fname")) {
                    System.out.println("Employee old First Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new First Name: ");
                    earray[index].setFname(sc.next());
                } else if (editItem.equalsIgnoreCase("Lname")) {
                    System.out.println("Employee old Last Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new Last Name: ");
                    earray[index].setLname(sc.next());
                } else if (editItem.equalsIgnoreCase("taxrate")) {
                    System.out.println("Employee old tax rate: " + earray[index].getTaxrate());
                    System.out.println("Please enter employee new tax rate: ");
                    earray[index].setTaxrate(sc.nextFloat());
                } else if (editItem.equalsIgnoreCase("rate")) {
//                System.out.println("Employee old rate: " + earray[index].getRate());
                    System.out.println("Employee old rate: " + hm.getRate());
                    System.out.println("Please enter employee new rate: ");
//                earray[index].setRate(sc.nextFloat());
                    hm.setRate(sc.nextFloat());

                } else if (editItem.equalsIgnoreCase("hours")) {
//                System.out.println("Employee old hours: " + earray[index].getHours());
                    System.out.println("Employee old hours: " + hm.getHours());
                    System.out.println("Please enter employee new hours: ");
//                earray[index].setHours(sc.nextInt());
                    hm.setHours(sc.nextInt());
                } else {
                    System.out.println("Sorry you put the wrong item to edit. ");
                }
                System.out.println("The Employee data is: ");
                earray[index].displayEmployee();
            } else if (earray[index] instanceof SalaryEmployee) {
                SalaryEmployee sm = (SalaryEmployee) earray[index];
                System.out.println("The employee is a salary employee. ");
                System.out.println("Please enter which do you want to edit[ID,Fname,Lname,Taxrate, Salary Category{SC}]: ");
                String editItem = sc.next();
                if (editItem.equalsIgnoreCase("ID")) {
                    System.out.println("Employee old ID: " + earray[index].getID());
                    System.out.println("Please enter employee new ID: ");
                    earray[index].setID(sc.nextInt());
                } else if (editItem.equalsIgnoreCase("Fname")) {
                    System.out.println("Employee old First Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new First Name: ");
                    earray[index].setFname(sc.next());
                } else if (editItem.equalsIgnoreCase("Lname")) {
                    System.out.println("Employee old Last Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new Last Name: ");
                    earray[index].setLname(sc.next());
                } else if (editItem.equalsIgnoreCase("taxrate")) {
                    System.out.println("Employee old tax rate: " + earray[index].getTaxrate());
                    System.out.println("Please enter employee new tax rate: ");
                    earray[index].setTaxrate(sc.nextFloat());
                } else if (editItem.equalsIgnoreCase("sc")) {
                    System.out.println("Employee old Salary Category: " + sm.getSalaryCategory());
                    System.out.println("Please enter employee new Salary Category[se or ee]: ");
                    sm.setSalaryCategory(sc.next());
                } else {
                    System.out.println("Sorry you put the wrong item to edit. ");
                }
                System.out.println("The Employee data is: ");
                earray[index].displayEmployee();
            } else {
                CommissionEmployee cm = (CommissionEmployee) earray[index];
                System.out.println("The employee is a Commission employee. ");
                System.out.println("Please enter which do you want to edit[ID,Fname,Lname,Taxrate, Items, Item Price[IP]]: ");
                String editItem = sc.next();
                if (editItem.equalsIgnoreCase("ID")) {
                    System.out.println("Employee old ID: " + earray[index].getID());
                    System.out.println("Please enter employee new ID: ");
                    earray[index].setID(sc.nextInt());
                } else if (editItem.equalsIgnoreCase("Fname")) {
                    System.out.println("Employee old First Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new First Name: ");
                    earray[index].setFname(sc.next());
                } else if (editItem.equalsIgnoreCase("Lname")) {
                    System.out.println("Employee old Last Name: " + earray[index].getFname());
                    System.out.println("Please enter employee new Last Name: ");
                    earray[index].setLname(sc.next());
                } else if (editItem.equalsIgnoreCase("taxrate")) {
                    System.out.println("Employee old tax rate: " + earray[index].getTaxrate());
                    System.out.println("Please enter employee new tax rate: ");
                    earray[index].setTaxrate(sc.nextFloat());
                } else if (editItem.equalsIgnoreCase("items")) {
                    System.out.println("Employee old Salary Category: " + cm.getItems());
                    System.out.println("Please enter employee new Salary Category: ");
                    cm.setItems(sc.nextInt());
                } else if (editItem.equalsIgnoreCase("IP")) {
                    System.out.println("Employee old Salary Category: " + cm.getItemPrice());
                    System.out.println("Please enter employee new Salary Category: ");
                    cm.setItemPrice(sc.nextFloat());
                } else {
                    System.out.println("Sorry you put the wrong item to edit. ");
                }
                System.out.println("The Employee data is: ");
                earray[index].displayEmployee();
            }
        }
    }

}
