import java.util.*;

public class CSE230_LAB2 {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(4,8,-13,8,-13,-13,0,8,4,0));
        int size = 10;
        int i, j, k;
        i = 0;

        while (i < size){
            j = i + 1;
            while (j < size){
                if (array.get(i) == array.get(j)){
                    for (k = j; k < size - 1; k++){
                        array.set(k, array.get(k + 1));
                    }
                    size = size - 1;
                }
                else{
                    j++;
                }
            }
            i++;
        }

        
        for (int l = 0; l < size; l++){
            System.out.println(array.get(l));
        }
        System.out.println(size);
    }
}
