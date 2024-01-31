import java.util.*;

public class SomeObjects {
    public static void main(String[] args){
        ArrayList list = new ArrayList<>();
        list.add("ab");
        list.add("cd");
        list.add("ef");
        list.add(4);
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
}
