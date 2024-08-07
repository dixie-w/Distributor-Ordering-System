package org.example.distributororderingsystem;

import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Creates a set of products and provides methods to interact with said set.
 * @author Bethany Lee
 */
public class ProductManagement {
    private static HashMap<Integer, Product> productHashMap = new HashMap<>();

    /**
     * Fills the hashmap with products
     * @param filename A string representing the name of the file containing tab-separated variables in name, status, id, supplier, brand, size, class, available, sales, date last received order
     */
    // filename for initial 300 items is "Products.txt"
    public void addData(String filename) {
        try {
            File input = new File(filename);
            Scanner read = new Scanner(input);

            String name, supplier, brand, size;
            boolean status;
            char productClass;
            int id, available, sales, lastReceived;

            while (read.hasNextLine()) {
                String line = read.nextLine();
                String[] values = line.split("\t");

                name = values[2];
                status = values[0].equals("Active");
                id = Integer.parseInt(values[1]);
                supplier = values[3];
                brand = values[4];
                size = values[5];
                productClass = values[6].charAt(0);
                available = Integer.parseInt(values[7]);
                sales = Integer.parseInt(values[8]);
                lastReceived = Integer.parseInt(values[9]);

                Product temp = new Product(name, status, id, supplier, brand, size, productClass, available, sales, lastReceived);
                productHashMap.put(id, temp);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    /**
     * Adds a new product to the product hashmap.
     * @param name The product's name, typically includes sub-brand and size.
     * @param status The product's status, either active (true) or restricted (false).
     * @param id The product's ID, 6 numbers.
     * @param supplier The product's supplier.
     * @param brand The product's brand.
     * @param size The product's size, in barrels, suitcases, or number/size format.
     * @param productClass The product's class, that being beer, wine, spirits, or non-alcoholic.
     * @param available The number of the product currently available.
     * @param sales The total number of the product sold so far.
     * @param lastReceived The date the product was last received in YYYYMMDD format.
     */
    public static void addProduct(String name, boolean status, int id, String supplier, String brand, String size, char productClass, int available, int sales, int lastReceived) {
        Product temp = new Product(name, status, id, supplier, brand, size, productClass, available, sales, lastReceived);
        productHashMap.put(id, temp);
    }

    /**
     * Adds a new product to the product hashmap.
     * @param product A Product object representing the product to be added to the hashmap.
     */
    public static void addProduct(Product product) {
        productHashMap.put(product.getId(), product);
    }

    /**
     * Removes a product from the product hashmap.
     * @param id An int representing the id of the product to be removed from the hashmap.
     */
    public static void removeProduct(int id) {
        productHashMap.remove(id);
    }

    /**
     * Retrieves a product from the product hashmap.
     * @param id An int representing the id of the product to be retrieved from the hashmap.
     */
    public static Product getProduct(int id) {
        return productHashMap.get(id);
    }

    /**
     * Retrieves all product IDs from the product hashmap.
     * @return An int array representing the ids of the products.
     */
    public static int[] getIDs() {
        Object[] temp = productHashMap.keySet().toArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = (Integer)temp[i];
        }
        return result;
    }

    /**
     * Retrieves a number of product IDs from the product hashmap and puts them in a String for display.
     * @param num An int representing how many ids to fetch.
     * @return A string representing the IDs of the products separated by new lines.
     */
    public static String getIDList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(ids[i] + "\n");
        }
        return result;
    }

    /**
     * Retrieves a number of product names from the product hashmap and puts them in a String for display.
     * @param num An int representing how many names to fetch.
     * @return A string representing the names of the products separated by new lines.
     */
    public static String getNameList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(productHashMap.get(ids[i]).getName() + "\n");
        }
        return result;
    }

    /**
     * Retrieves a number of product brands from the product hashmap and puts them in a String for display.
     * @param num An int representing how many brands to fetch.
     * @return A string representing the brands of the products separated by new lines.
     */
    public static String getBrandList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(productHashMap.get(ids[i]).getBrand() + "\n");
        }
        return result;
    }

    /**
     * Retrieves a number of product sizes from the product hashmap and puts them in a String for display.
     * @param num An int representing how many sizes to fetch.
     * @return A string representing the sizes of the products separated by new lines.
     */
    public static String getSizeList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(productHashMap.get(ids[i]).getSize() + "\n");
        }
        return result;
    }

    /**
     * Retrieves a number of product classes from the product hashmap and puts them in a String for display.
     * @param num An int representing how many classes to fetch.
     * @return A string representing the classes of the products separated by new lines.
     */
    public static String getClassList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(productHashMap.get(ids[i]).getProductClass() + "\n");
        }
        return result;
    }

    /**
     * Retrieves a number of product amounts from the product hashmap and puts them in a String for display.
     * @param num An int representing how many amounts to fetch.
     * @return A string representing the available amounts of the products separated by new lines.
     */
    public static String getAvailableList(int num) {
        int[] ids = getIDs();
        String result = "";
        for (int i = 0; i < num && i < ids.length; i++) {
            result = result.concat(productHashMap.get(ids[i]).getAvailable() + "\n");
        }
        return result;
    }
}
