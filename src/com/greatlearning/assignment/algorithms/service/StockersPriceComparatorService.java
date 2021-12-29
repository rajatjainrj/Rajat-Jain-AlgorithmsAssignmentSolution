package com.greatlearning.assignment.algorithms.service;

import com.greatlearning.assignment.algorithms.utils.MergeSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rajatjain on - 28-12-2021
 * @project AlgorithmsAssignment
 */
public class StockersPriceComparatorService {

    private final Scanner scanner;
    private final MergeSort mergeSort;

    private int noOfCompanies;
    private double[] companyStockPrices;
    private boolean[] companyStockPricesGreaterThanYesterday;

    public StockersPriceComparatorService() {
        scanner = new Scanner(System.in);
        mergeSort = new MergeSort();
    }

    public void inputNoOfCompaniesAndTheirStockPrices() {
        System.out.println("Enter the number of companies -");
        noOfCompanies = scanner.nextInt();

        companyStockPrices = new double[noOfCompanies];
        companyStockPricesGreaterThanYesterday = new boolean[noOfCompanies];

        for (int i = 0; i < noOfCompanies; i++) {
            System.out.println("Enter current stock price of company " + (i + 1) + " -");
            companyStockPrices[i] = scanner.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            companyStockPricesGreaterThanYesterday[i] = scanner.nextBoolean();
        }
    }

    public int showMenuOptionsAndReturnSelection() {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Enter the operation that you want to perform");
        System.out.println("1. Display the companies stock prices in ascending order");
        System.out.println("2. Display the companies stock prices in descending order");
        System.out.println("3. Display the total no of companies for which stock prices rose today");
        System.out.println("4. Display the total no of companies for which stock prices declined today");
        System.out.println("5. Search a specific stock price");
        System.out.println("6. press 0 to exit");
        System.out.println("-----------------------------------------------");
        return scanner.nextInt();
    }

    public void performActions(int action) {
        switch (action) {
            case 1:
                displayCompanyStocksInOrder(true);
                break;
            case 2:
                displayCompanyStocksInOrder(false);
                break;
            case 3:
                displayNoOfCompaniesForWhichStockPricesRose();
                break;
            case 4:
                displayNoOfCompaniesForWhichStockPricesDeclined();
                break;
            case 5:
                searchASpecificStockPrice();
                break;
            case 0:
                System.out.println("Exited Successfully");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    private void searchASpecificStockPrice() {
        System.out.println("Enter the key value - ");
        double key = scanner.nextDouble();
        for (double stockPrice : companyStockPrices) {
            if (stockPrice == key) {
                System.out.println("Stock of value " + key + " is present");
                return;
            }
        }
        System.out.println("Value not found");
    }

    private void displayNoOfCompaniesForWhichStockPricesDeclined() {
        int counter = 0;
        for (boolean stockRose : companyStockPricesGreaterThanYesterday) {
            if (!stockRose) {
                counter++;
            }
        }
        System.out.println("Total no of companies whose stock price declined today : " + counter);
    }

    private void displayNoOfCompaniesForWhichStockPricesRose() {
        int counter = 0;
        for (boolean stockRose : companyStockPricesGreaterThanYesterday) {
            if (stockRose) {
                counter++;
            }
        }
        System.out.println("Total no of companies whose stock price rose today : " + counter);
    }

    private void displayCompanyStocksInOrder(boolean ascending) {
        double[] sortedArray = Arrays.copyOf(companyStockPrices, companyStockPrices.length);
        mergeSort.mergeSort(sortedArray, ascending);
        printValues(sortedArray);
    }

    private void printValues(double[] companyStockPrices) {
        for (double stock : companyStockPrices) {
            System.out.print(stock + " ");
        }
        System.out.println();
    }
}
