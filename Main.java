
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Main {

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4х4. Получено строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Массив должен быть размером 4х4. Строка " + i + " имеет " + array[i].length + " колонок");
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\nДемонстрация ArrayIndexOutOfBoundsException:");
        int[] array = new int[3];

        try {
            System.out.println("Попытка получить элемент с индексом 5:");
            int element = array[5]; 
            System.out.println("Элемент: " + element); // Эта строка не выполнится
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Индекс 5 выходит за границы массива длиной 3");
        }

      }

    public static void main(String[] args) {

        // Пример 1: Корректный массив
        System.out.println("Пример 1: Корректный массив 4х4");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример 2: Массив неправильного размера
        System.out.println("\nПример 2: Массив 3х3 (неправильный размер)");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = sumArrayElements(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано MyArrayDataException: " + e.getMessage());
        }

        // Пример 3: Массив с некорректными данными
        System.out.println("\nПример 3: Массив с текстом вместо числа");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "шесть", "7", "8"}, // Здесь ошибка - "шесть" вместо числа
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано MyArraySizeException: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано MyArrayDataException: " + e.getMessage());
        }
       ArrayIndexOutOfBoundsException
        demonstrateArrayIndexOutOfBounds();
    }
}