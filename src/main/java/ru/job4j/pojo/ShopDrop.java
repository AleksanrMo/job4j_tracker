package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i == index) {
               products[i] = null;
               break;
            }
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[0] == null) {
               products[0] = products[i];
               products[i] = null;
               break;
            }
        }
        for (int i = 1; i < products.length; i++) {
            if (products[i] == null) {
                for (int j = i + 1; j < products.length; j++) {
                    if (products[j] != null) {
                        products[i] = products[j];
                        products[j] = null;
                        break;
                    }
                }
            }
        }
        return products;
    }
}
