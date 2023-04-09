// Пусть дан список сотрудников:
// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов

// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class task_2 {
    public static void main(String[] args) {
       
        TreeMap<String, Integer> sorting = new TreeMap<>();

        ArrayList<String> nameArrayList = new ArrayList<>();
        
        Map<String, String> officeList = new HashMap<String, String>();
        
        officeList.put("Иванов", "Иван");
        officeList.put("Петрова", "Светлана");
        officeList.put("Белова", "Кристина");
        officeList.put("Мусина", "Анна");
        officeList.put("Крутова", "Анна");
        officeList.put("Юрин", "Иван");
        officeList.put("Лыков", "Петр");
        officeList.put("Чернов", "Павел");
        officeList.put("Чернышов", "Петр");
        officeList.put("Федорова", "Мария");
        officeList.put("Светлова", "Марина");
        officeList.put("Савина", "Мария");
        officeList.put("Рыкова", "Мария");
        officeList.put("Лугова", "Марина");
        officeList.put("Владимирова", "Анна");
        officeList.put("Мечников", "Иван");
        officeList.put("Петин", "Петр");
        officeList.put("Ежов", "Иван");

        Iterator<Map.Entry<String, String>> officeMapIterator = officeList.entrySet().iterator();
        
        while (officeMapIterator.hasNext()) {

            Map.Entry<String, String> pair = officeMapIterator.next();
            nameArrayList.add(pair.getValue());  
    
        }

        nameArrayList.sort(Comparator.naturalOrder());

        int counter=1;

        for (int i = 1; i < nameArrayList.size(); i++) {

            if(nameArrayList.get(i) == nameArrayList.get(i-1)) counter++;
        
            else{
                if(counter > 1) sorting.put(nameArrayList.get(i-1), counter);
                counter = 1;
            }
           
        }

        while(sorting.isEmpty() == false){
            int maxValue = 0;
            String officeWorkerName = "";
            for(var item: sorting.entrySet()){
                
                if(item.getValue() > maxValue){ 
                
                    maxValue = item.getValue();
                    officeWorkerName = item.getKey();

                }
   
            }
            sorting.remove(officeWorkerName);
            
            System.out.println(("Имя " + officeWorkerName + " встретилось " + maxValue + " раза" ));
        }

    }
    
}
