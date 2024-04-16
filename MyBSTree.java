public class MyBSTree<T extends Comparable <T>> implements ITree<T> {
    private int size = 0;
    private Node root;
    
     public void insert(T item){
       root.insert(item);
     }
     
     public boolean containsItem(T item){
        return true;
     }
     
     public int getSize(){
        return this.size;
     }
     
     public void printInOrder(){
        
     }
     
     public String toString(){
        return " ";
     }
     
     class Node{
        public T data;
        public Node left;
        public Node right;
        
        public Node(T data){
           this.data = data;
        }
        
        public void insert(T item){
           if(this.data == null){
             this.data = item;
             return;
           }
           if(this.data.compareTo(item) > 0){
             left.insert(item);
           }
           else {
              right.insert(item);  
           }
        }
     }
 }