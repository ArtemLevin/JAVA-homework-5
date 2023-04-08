// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
// Пример:
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 1242353
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я ввожу: 1
// К: Введите фамилию
// Я: Иванов
// К: Введите номер
// Я: 547568
// К: Введите 1) Добавление номера
// 2) Вывод всего
// Я: 2
// Иванов: 1242353, 547568

import java.util.*;


public class task_1 {

    public static void phoneMenu(){
        System.out.println("Введите 1) Добвавление номера");
        System.out.println("        2) Вывод всего");
    }

    public static ArrayList<Integer> cloneArray(ArrayList<Integer> myList){

        ArrayList<Integer> tempArrayList = new ArrayList<>();
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()) {
            tempArrayList.add(iterator.next());
        }
        return tempArrayList;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<String,ArrayList<Integer>>();
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> tempNumList = new ArrayList<>();



        while(true){

            System.out.println();
            phoneMenu();
            System.out.println();
            System.out.print("Я ввожу ---> ");
            Integer choice = input.nextInt();
            System.out.println();
            if(choice == 1){
                
                System.out.print("Введите фамилию ---> ");
                String surname = input.next();
                System.out.println();
                System.out.print("Введите номер ---> ");
                Integer number = input.nextInt();
                System.out.println();
                numList.add(number);

                if(phoneBook.containsKey(surname) != true){

                    phoneBook.putIfAbsent(surname, cloneArray(numList));
                    numList.clear();

                 }

                else{
                    
                    numList = phoneBook.get(surname);
                    numList.add(number);
                    phoneBook.put(surname, cloneArray(numList));
                    numList.clear();
                }
                
            }

            if(choice==2){
                for(var item: phoneBook.entrySet()){

                    String key = item.getKey();
                    ArrayList<Integer> numbers = item.getValue();
                    String stringNumbers = numbers.toString(); 
                    stringNumbers = stringNumbers.replace("[", "");
                    stringNumbers = stringNumbers.replace("]", "");
                    System.out.printf(key + ": " + stringNumbers );
                    System.out.println();

                }
                
            }

        }
        // input.close();

    }
    
}