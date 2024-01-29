/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import common.Library;
import java.util.ArrayList;
import model.Contact;
import view.Menu;

/**
 *
 * @author LAPTOP ACER
 */
public class ContactManagement extends Menu<String>{

    private static String[] mc = {"Add a Contact","Display all Contact","Delete a Contact","Exit"};
    private static ArrayList<Contact> cList = new ArrayList<>();
    private Library lib = new Library();
    public ContactManagement() {
        super("Contact Program",mc);
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                doAddContact();
                break;
            case 2:
                doDisplayAll();
                break;
            case 3:
                int id = lib.getInt("Enter ID");
                Contact delCont = searchContact(id);
                if (delCont != null){
                    cList.remove(delCont);
                    System.out.println("Remove successfully!!!");
                } else System.out.println("Not found");
                break;
            case 4:
                System.out.println("Exitting...");
                System.exit(0);
        }
    }

    public void doAddContact() {
        System.out.println("-------- Add a Contact --------");
        String name = lib.getString("Enter name");
        String group = lib.getString("Enter group");
        String address = lib.getString("Enter address");
        String phone = lib.getPhone();
        cList.add(new Contact(name, group, address, phone));
        System.out.println("Add new contact successfully!!!");
    }

    public void doDisplayAll() {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.println(String.format("%-4s %-20s %-12s %-12s %-10s %-10s %-10s",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone"));
        for (Contact c : cList){
            System.out.println(c.toString());
        }
    }
    public Contact searchContact(int id){
        for (Contact c:cList){
            if (id == c.getId()) return c;
        }
        return null;
    }
    
}
