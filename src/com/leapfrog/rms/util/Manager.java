/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.rms.util;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Manager {

    private String[] items;
    private int[] price, quantity, order;
    private Scanner input;

    public Manager(String[] items, Scanner input) {
        this.items = items;
        this.input = input;
        price = new int[items.length];
        quantity = new int[items.length];
        order = new int[items.length];

    }

    /**
     *
     */
    public void SetUp() {
        for (int i = 0; i < items.length; i++) {
            System.out.println("Enter the price of " + items[i]);
            price[i] = input.nextInt();
            System.out.println("Enter the quantity of " + items[i]);
            quantity[i] = input.nextInt();

        }

    }

    public void menu() {

        System.out.println("1. Print Items");
        System.out.println("2. Take order");
        System.out.println("3. Show sales report");
        System.out.println("4. Show available quantities");
        System.out.println("5. Exit");
        System.out.println("Enter your choice[1-5]");

    }

    public void PrintItems() {
        System.out.println("--------------------------");
        System.out.println("Items\t\t Price\t Available Quantity");
        for (int i = 0; i < items.length; i++) {

            System.out.println((i + 1) + "\t" + items[i] + "\t" + price[i] + "\t" + quantity[i]);
        }
    }

    public void TakeOrder() {

        PrintItems();
        int ch = 0;
        String params = "";
        String qtyparams = "";

        while (true) {
            while (true) {
                System.out.println("What would you like to order Sir(1,2,3)?");
                ch = input.nextInt();
                if (params.equals("")) {
                    params = ch + "";
                } else {
                    params = params + "," + ch + "";
                }

                if (ch > (items.length) || ch < 1) {
                    System.out.println("Inavlid Choice");
                } else {
                    break;
                }
            }

            int a = ch - 1;

            System.out.println(
                    "Order for" + items[a]);
            System.out.println(
                    "Price :" + price[a]);

            while (true) {

                System.out.println("What quantity do you want?");
                int qty = input.nextInt();
                if (qtyparams.equals("")) {
                    qtyparams = qty + "";
                } else {
                    qtyparams = qty + "," + qty + "";
                }
                int Available = quantity[a] - order[a];
                if (qty > Available) {
                    System.out.println("Not enough Quantity");
                    System.out.println("We have only " + Available);
                } else {
                    order[a] += qty;
                    break;
                }

            }

            System.out.println("Do you want to order more[Y/N]");
            if (input.next().equalsIgnoreCase("n")) {

                break;
            }
        }

        String[] itemsTokens = params.split(",");
        String[] qtyTokens = qtyparams.split(",");
        System.out.println("Your orders are:");
        int grandTotal = 0;
        for (int i = 0; i < itemsTokens.length; i++) {
            int x = Integer.parseInt(itemsTokens[i]) - 1;
            int q = Integer.parseInt(qtyTokens[i]);
            System.out.println(items[x]);
            System.out.println("Quantity :" + q);
            int total = price[x] * q;
            System.out.println("Price :" + total);
            grandTotal += total;
        }
        System.out.println("------------------");
        System.out.println("Total : " + grandTotal);

    }

    public void salesReport() {
        System.out.println("Sales Report");
        System.out.println("---------------------");
        System.out.println("Item \tPrice\tsales\t Total");
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + "\t" + price[i] + "\t" + order[i] + "\t" + (price[i] * order[i]));

        }

    }

}
