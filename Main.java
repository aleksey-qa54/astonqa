 1.Mетод printThreeWords

public class Main {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    
    public static void main(String[] args) {
        printThreeWords();
    }
}


2.Создайте метод checkSumSign()

public class Main {

    public static void checkSumSign() {
        int a = 5;
        int b = -10;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void main(String[] args) {
        checkSumSign();
    }
}


3.Создайте метод printColor()

public class Main {
    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void main(String[] args) {
        printColor();
    }
}

4. Создайте метод compareNumbers()

public class Main {
    public static void main(String[] args) {
        compareNumbers();
    }
    public static void compareNumbers() {
        int a = 15;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}

5. Напишите метод, принимающий на вход два целых числа

public class Main {
    public static void main(String[] args) {
        System.out.println(isSumInRange(1, 19));
    }
    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        if (sum < 10) {
            return false;
        } else if (sum > 20) {
            return false;
        } else {
            return true;
        }
    }
}

6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль

public class Main {
    public static void main(String[] args) {
        int myNumber = -7;
        System.out.println("Проверяем число: " + myNumber);
        if (myNumber >= 0) {
            System.out.println("Это положительное число!");
        } else {
            System.out.println("Это отрицательное число!");
        }
    }
}


7.Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

public class Main {
    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        int Number1 = -5;
        int Number2 = 0;
        int Number3 = 10;
        System.out.println(Number1 + " отрицательное? " + isNegative(Number1));
        System.out.println(Number2 + " отрицательное? " + isNegative(Number2));
        System.out.println(Number3 + " отрицательное? " + isNegative(Number3));
    }
}

8.Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;

public class Main {
    public static void main(String[] args) {
        String text = "Hello";  
        int count = 5;          
        
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
        
        System.out.println("end");
    }
}

9.Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

public class Main {
    public static void main(String[] args) {
        int god = 2025;
        boolean statement;
        if (god % 400 == 0) {
            statement = true;
        } else if (god % 100 == 0) {
            statement = false;
        } else if (god % 4 == 0) {
            statement = true;
        } else {
            statement = false;
        }
        System.out.println(statement);
    }
}

10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 - arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


11.  Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
            System.out.print("arr[" + i + "] = " + arr [i]);
        }
    }
}

12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

public class Main {
    public static void main(String[] args) {
             int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("Было: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\nСтало: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i] + " ");
        }
    }
}

14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.

public class Main {
    public static void main(String[] args) {
        int len = 4;
        int value = 9;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = value;
                    System.out.print(arr[i] + " ");
        }
    }
}

