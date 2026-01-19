1. Создать классы Собака и Кот с наследованием от класса Животное. 

Класс Животные:
public class Animal {
    protected String name;

    private static int totalAnimals = 0;
    private static int totalDogs = 0;
    private static int totalCats = 0;

    public Animal(String name) {
        this.name = name;
        System.out.println("Создано животное: " + name);
    }

    public void run(int distance) {
        System.out.println(name + " бежит " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " плывет " + distance + " м.");
    }

    public static int getTotalAnimals() {
        return totalAnimals;
    }

    public static int getTotalDogs() {
        return totalDogs;
    }

    public static int getTotalCats() {
        return totalCats;
    }

    protected static void incrementAnimals() {
        totalAnimals++;
    }

    protected static void incrementDogs() {
        totalDogs++;
    }

    protected static void incrementCats() {
        totalCats++;
    }

    public static void printStatistics() {
        System.out.println("=== СТАТИСТИКА ===");
        System.out.println("Собак: " + totalDogs);
        System.out.println("Котов: " + totalCats);
        System.out.println("Всего животных: " + totalAnimals);
        System.out.println("=================");
    }
}



Класс собак:

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
        incrementAnimals();
        incrementDogs();
         System.out.println("Это собака по имени " + name);
    }

    @Override  
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println(name + ": Дистанция должна быть больше 0!");
        } else if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м. (максимум для собак: 500 м)");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Собаки бегают максимум 500 м!");
        }
    }

     
    @Override
    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println(name + ": Дистанция должна быть больше 0!");
        } else if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м. (максимум для собак: 10 м)");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Собаки плавают максимум 10 м!");
        }
    }
}


класс кошек:

public class Cat extends Animal {
    private boolean isFull;
    private int appetite;
    public Cat(String name, int appetite) {
        super(name);
        incrementAnimals();
        incrementCats();
        this.isFull = false;
        this.appetite = appetite;
        System.out.println("Это кот по имени " + name + " с аппетитом " + appetite + " ед.");
    }
    public Cat(String name) {
        this(name, 15);
    }
    public void eat(Bowl bowl) {
            if (isFull) {
                System.out.println(name + " уже сыт и не хочет есть!");
                return;
            }

            System.out.print(name + " пытается поесть из миски '" + bowl.getName() + "'... ");

            if (bowl.decreaseFood(appetite)) {
                isFull = true;
                System.out.println(name + " поел и теперь сыт!");
            } else {
                System.out.println(name + " не стал есть, еды недостаточно!");
            }
    }
    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println(name + ": Дистанция должна быть больше 0!");
        } else if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м. (максимум для котов: 200 м)");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Коты бегают максимум 200 м!");
        }
    }


    @Override
    public void swim(int distance) {
        System.out.println(name + ": Я кот! Коты не плавают!");
    }
    public boolean isFull() {
        return isFull;
    }

    public int getAppetite() {
        return appetite;
    }

    public void displayInfo() {
        String fullness = isFull ? "сыт" : "голоден";
        System.out.println("Кот " + name + ": аппетит " + appetite + " ед., состояние: " + fullness);
    }


Класс миска (дополнительный):

public class Bowl {
    private int foodAmount;
    private String name;

     
    public Bowl(String name, int initialFood) {
        this.name = name;
        if (initialFood < 0) {
            System.out.println("Количество еды не может быть отрицательным! Установлено 0.");
            this.foodAmount = 0;
        } else {
            this.foodAmount = initialFood;
        }
        System.out.println("Создана миска '" + name + "' с " + foodAmount + " ед. еды");
    }


    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить " + amount + " ед. еды! Добавьте положительное количество.");
            return;
        }
        foodAmount += amount;
        System.out.println("В миску '" + name + "' добавлено " + amount + " ед. еды. Теперь в миске: " + foodAmount + " ед.");
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя взять " + amount + " ед. еды!");
            return false;
        }

        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.println("Из миски '" + name + "' взято " + amount + " ед. еды. Осталось: " + foodAmount + " ед.");
            return true;  // успешно взяли еду
        } else {
            System.out.println("В миске '" + name + "' недостаточно еды! Нужно: " + amount + ", есть: " + foodAmount);
            return false;  // не хватило еды
        }
    }
    public int getFoodAmount() {
        return foodAmount;
    }
    public String getName() {
        return name;
    }
    public void displayInfo() {
        System.out.println("Миска '" + name + "': " + foodAmount + " ед. еды");
    }
}



public class Main {
      public static void main(String[] args) {
        System.out.println("========== ПРОГРАММА 'ЖИВОТНЫЕ' ==========");
        System.out.println();

     
        System.out.println("--- Создаем животных ---");
        Dog bobik = new Dog("Бобик");
        System.out.println();  // Пустая строка
        Dog sharik = new Dog("Шарик");
        System.out.println();

        Cat murzik = new Cat("Мурзик");
        System.out.println();
        Cat barsik = new Cat("Барсик");
        System.out.println();

        
        System.out.println("--- Бег ---");
        bobik.run(150);
        sharik.run(600);  

        System.out.println();

        murzik.run(100);
        barsik.run(250);  

        System.out.println();

        
        System.out.println("--- Плавание ---");
        bobik.swim(5);
        sharik.swim(15);

        System.out.println();

        barsik.swim(1);   
        murzik.swim(100); 

        System.out.println();
        System.out.println("Итого :");
        System.out.println("Создано собак: " + Animal.getTotalDogs());
        System.out.println("Создано котов: " + Animal.getTotalCats());
        System.out.println("Всего животных: " + Animal.getTotalAnimals());
          System.out.println();

          System.out.println("\n\n КОРМЛЕНИЕ КОТОВ");
          System.out.println("=========================\n");


          System.out.println("1. МИСКА С ЕДОЙ");
          Bowl catBowl = new Bowl("Кошачья миска", 40);
          catBowl.displayInfo();
          System.out.println();

          System.out.println("2. СОЗДАЕМ МАССИВ КОТОВ");
          Cat[] cats = new Cat[2];
          cats[0] = murzik;
          cats[1] = barsik;

          System.out.println("\nВсего котов в массиве: " + cats.length);
          System.out.println("Всего создано котов в программе: " + Cat.getTotalCats());
          System.out.println();

          System.out.println("3. ИНФОРМАЦИЯ О КОТАХ ДО КОРМЛЕНИЯ:");
          for (int i = 0; i < cats.length; i++) {
              System.out.print("Кот " + (i+1) + ": ");
              cats[i].displayInfo();
          }
          System.out.println();

          System.out.println("4. ПЕРВОЕ КОРМЛЕНИЕ");
          System.out.println("В миске сейчас: " + catBowl.getFoodAmount() + " ед. еды");
          for (Cat cat : cats) {
              cat.eat(catBowl);
          }
          System.out.println();

        
          System.out.println("5. СОСТОЯНИЕ МИСКИ ПОСЛЕ ПЕРВОГО КОРМЛЕНИЯ:");
          catBowl.displayInfo();
          System.out.println();

          
          System.out.println("6. ИНФОРМАЦИЯ О КОТАХ ПОСЛЕ ПЕРВОГО КОРМЛЕНИЯ:");
          int fullCats = 0;
          int hungryCats = 0;

          for (int i = 0; i < cats.length; i++) {
              System.out.print("Кот " + (i+1) + ": ");
              cats[i].displayInfo();
              if (cats[i].isFull()) {
                  fullCats++;
              } else {
                  hungryCats++;
              }
          }

          System.out.println("\nСТАТИСТИКА:");
          System.out.println("Сытых котов: " + fullCats);
          System.out.println("Голодных котов: " + hungryCats);
          System.out.println();

         
          System.out.println("7. ДОБАВЛЯЕМ ЕДУ И КОРМИМ СНОВА:");
          catBowl.addFood(60);
          System.out.println();

          
          System.out.println("Пытаемся накормить голодных котов:");
          for (Cat cat : cats) {
              if (!cat.isFull()) {
                  cat.eat(catBowl);
              }
          }
          System.out.println();

         
          System.out.println("8. ФИНАЛЬНАЯ ПРОВЕРКА:");
          System.out.println("Состояние миски:");
          catBowl.displayInfo();

          System.out.println("\nСостояние всех котов:");
          fullCats = 0;
          for (Cat cat : cats) {
              cat.displayInfo();
              if (cat.isFull()) fullCats++;
          }

          System.out.println("\nИТОГО:");
          System.out.println("Сытых котов: " + fullCats + " из " + cats.length);
          System.out.println("Голодных котов: " + (cats.length - fullCats) + " из " + cats.length);
          
          System.out.println("\n\n======= ИТОГОВАЯ СТАТИСТИКА ПРОГРАММЫ =======");
          Animal.printStatistics();

        System.out.println("========== ПРОГРАММА ЗАВЕРШЕНА ==========");
    }
}
