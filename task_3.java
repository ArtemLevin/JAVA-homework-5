// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8
// 0x000000
// 0000x000
// 00x00000
import java.util.*;

public class task_3 {


    public static Map<Integer, Integer> n_queens(Integer num_of_queens){

        while(true){

            ArrayList<Integer> x_axis = new ArrayList<>();

            for (int i = 1; i < num_of_queens+1; i++) x_axis.add(i);

            ArrayList<Integer> y_axis = new ArrayList<>();

            for (int i = 1; i < num_of_queens+1; i++) y_axis.add(i);

            ArrayList<Integer> positive_b = new ArrayList<>();

            for (int i = -num_of_queens + 1; i < num_of_queens+1; i++) positive_b.add(i);

            ArrayList<Integer> negative_b = new ArrayList<>();

            for (int i = 1; i < 2*num_of_queens; i++) negative_b.add(i);

            Map<Integer, Integer> queens = new HashMap<Integer, Integer>();

            int i=1;

            Random rnd = new Random();

            while (i<= num_of_queens){

                int x=x_axis.get(rnd.nextInt(x_axis.size()));
                int y=y_axis.get(rnd.nextInt(y_axis.size()));
                int pos_b = y - x;
                int neg_b = y + x;

                if(positive_b.contains(pos_b) == false | negative_b.contains(neg_b) == false ){

                    x_axis.clear();
                    y_axis.clear();
                    positive_b.clear();
                    negative_b.clear();
                    break;
                }

                if(positive_b.contains(pos_b) == true & negative_b.contains(neg_b) == true & x_axis.contains(x) & y_axis.contains(y)){

                    queens.put(x, y);
                    x_axis.remove(x_axis.indexOf(x));
                    y_axis.remove(y_axis.indexOf(y));
                    positive_b.remove(positive_b.indexOf(pos_b));
                    negative_b.remove(negative_b.indexOf(neg_b));

                    i++;
                }

            }
            if(i == num_of_queens + 1) return queens;
        }
    }

    public static void board(Map<Integer, Integer>queens){


        for (int i = 1; i < queens.size() +1; i++) {

            for (int j = 1; j < queens.size() + 1; j++) {

                for(var item: queens.entrySet()) if(i == item.getKey() & j == item.getValue()) System.out.print(" Q ");
                
                if(i == 0) System.out.print("");

                else if(j == queens.size()) System.out.print( "");

                else System.out.print(" 0 ");

            }

            System.out.println();
        }
    }
    public static void main(String[] args) {

        Map<Integer, Integer> queens = new HashMap<>();

        queens = n_queens(8);
        board(queens);
    }
    
}
