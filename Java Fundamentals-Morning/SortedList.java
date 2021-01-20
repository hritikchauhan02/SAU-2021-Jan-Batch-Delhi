import java.util.*;

public class SortedList {
    public static void main(String [] args) {
    	
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(10);
        arr.add(4);
        arr.add(12);
        arr.add(100);
        arr.add(15);
        arr.add(145);
        arr.add(81);
        arr.add(2);

        Collections.sort(arr);

        System.out.println("Sorted List is : ");

        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i) + " ");
        }
    }

}