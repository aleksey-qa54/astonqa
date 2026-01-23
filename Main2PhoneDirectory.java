import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }
    public void add(String surname, String phoneNumber) {
        
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>());
        }

               directory.get(surname).add(phoneNumber);

        System.out.println("Запись добавлена: " + surname + " - " + phoneNumber);
    }
    public List<String> get(String surname) {
        return directory.get(surname);
    }
    public void findAndPrint(String surname) {
        List<String> phones = get(surname);

        if (phones == null || phones.isEmpty()) {
            System.out.println("Фамилия '" + surname + "' не найдена в справочнике.");
        } else {
            System.out.println("Найдены телефоны для фамилии '" + surname + "':");
            for (int i = 0; i < phones.size(); i++) {
                System.out.println((i + 1) + ". " + phones.get(i));
            }
        }
    }
    public void printAll() {
        if (directory.isEmpty()) {
            System.out.println("Справочник пуст.");
            return;
        }

        System.out.println("=== ВЕСЬ ТЕЛЕФОННЫЙ СПРАВОЧНИК ===");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println("Фамилия: " + entry.getKey());
            List<String> phones = entry.getValue();
            for (int i = 0; i < phones.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + phones.get(i));
            }
            System.out.println();
        }
    }

       public static void main(String[] args) {
        
        PhoneDirectory myDirectory = new PhoneDirectory();

       
        myDirectory.add("Иванов", "8-900-123-45-67");
        myDirectory.add("Петров", "8-901-234-56-78");
        myDirectory.add("Иванов", "8-902-345-67-89"); // У Иванова будет 2 номера
        myDirectory.add("Сидоров", "8-903-456-78-90");

        System.out.println(); // Пустая строка для красоты

       
        myDirectory.findAndPrint("Иванов");

        System.out.println();  

        myDirectory.findAndPrint("Петров");

        System.out.println();

       
        myDirectory.findAndPrint("Кузнецов");

        System.out.println(); 

        
        myDirectory.printAll();
    }
}