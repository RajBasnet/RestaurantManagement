/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.rms;

import com.leapfrog.rms.util.Manager;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class rms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] items = {"\tMOMO", "Fried Rice", "Chowmein"};

        Manager manager = new Manager(items, input);
        manager.SetUp();

        while (true) {

            manager.menu();
            switch (input.nextInt()) {
                case 1:
                    manager.PrintItems();
                    break;
                case 2:
                    manager.TakeOrder();
                    break;
                case 3:
                    manager.salesReport();
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;

            }

        }
    }
}
