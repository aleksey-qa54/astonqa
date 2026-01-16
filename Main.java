1. Создать класс "Товар" с полями: название, дата производства, производитель, страна происхождения, цена, состояние бронирования покупателем. 

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate production_date;
    private String manufacturer;
    private String country;
    private int price;
    private String reservation_status;

    public Product(String name, LocalDate production_date, String manufacturer,
                   String country, int price, String reservation_status) {
        this.name = name;
        this.production_date = production_date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.reservation_status = reservation_status;
    }
    public void info() {
        System.out.println("=== Информация о товаре ===");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + production_date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + " руб.");

        if (reservation_status == null || reservation_status.isEmpty()) {
            System.out.println("Состояние бронирования: Свободен");
        } else {
            System.out.println("Забронирован: " + reservation_status);
        }
    }
    public static void main(String[] args) {
        System.out.println();
        Product product1 = new Product(
                "Смартфон Samsung Galaxy S24",
                LocalDate.of(2024, 1, 15),
                "Samsung",
                "Южная Корея",
                85000,
                "Резерв"
        );
        product1.info();
    }
}


2.массив из 5 товаров,Product[] productsArray = new Product[5]:

public class Product {
    private String name;
    private String production_date;
    private String manufacturer;
    private String country;
    private int price;
    private boolean availability;

    public Product(String name, String production_date, String manufacturer,
                   String country, int price, boolean availability) {
        this.name = name;
        this.production_date = production_date;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.availability = availability;
    }
    public void info() {
        System.out.println("=== Информация о товаре ===");
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + production_date);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("В наличии: " + (availability ? "Да" : "Нет"));
    }
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", " 01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 16 Pro", "15.09.2024",
                "Apple Inc.", "USA", 4999, true);
        productsArray[2] = new Product("Xiaomi 14 Pro", "10.01.2024",
                "Xiaomi Corporation", "China", 3299, false);
        productsArray[3] = new Product("Google Pixel 8", "01.10.2023",
                "Google LLC", "USA", 3999, true);
        productsArray[4] = new Product("OnePlus 12", "05.12.2023",
                "OnePlus Technology", "China", 2799, true);

        System.out.println("=== ИНФОРМАЦИЯ О ВСЕХ ТОВАРАХ ===");

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("Товар №" + (i + 1) + ":");
            productsArray[i].info();
        }
    }
}


3.Класс Park с внутренним классом:


public class Park {
     class Attraction {
         String name;
         String workTime;
         String price;
    Attraction(String name, String workTime, String price){
        this.name = name;
        this.workTime = workTime;
        this.price = price;
    }
    void Info() {
        System.out.println("Аттракцион: " + name);
        System.out.println("Время работы: " + workTime);
        System.out.println("Стоимость: " + price + " руб.");
        System.out.println("----------------------");
    }
}
    public static void main(String[] args) {
        Park park = new Park();

        Attraction attraction1 = park.new Attraction("Американские горки", "10:00-20:00", "300");
        Attraction attraction2 = park.new Attraction("Колесо обозрения", "11:00-22:00", "200");
        Attraction attraction3 = park.new Attraction("Карусель", "09:00-19:00", "150");

        System.out.println("=== ИНФОРМАЦИЯ ОБ АТТРАКЦИОНАХ ПАРКА ===");
        attraction1.Info();
        attraction2.Info();
        attraction3.Info();
    }
}
