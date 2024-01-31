import java.util.*;

public class Example{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println(list.size());
        list.remove(1);

        System.out.println(list.get(3));
        list.add(3, "F");
        
        System.out.println(list.get(1));
        System.out.println(list.get(4));

        list.set(0,"G");
        System.out.println(list.get(2));
        System.out.println(list.size());

        list.add("H");

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

}