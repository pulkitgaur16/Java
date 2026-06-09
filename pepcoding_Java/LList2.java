import java.util.LinkedList;

// LinkedList<String> list = new LinkedList<>();
// Creates a LinkedList object that stores String elements.

// list.addFirst("value");
// Inserts the element at the beginning (head) of the list.

// list.addLast("value");
// Inserts the element at the end (tail) of the list.

// list.add("value");
// Adds the element at the end (tail) of the list.

// System.out.println(list);
// Prints the entire LinkedList in [element1, element2, ...] format.

// list.size();
// Returns the total number of elements present in the list.

// list.get(index);
// Returns the element present at the specified index (0-based indexing).

// for(int i = 0; i < list.size(); i++)
// Loop used to traverse the LinkedList using index-based access.

// list.remove(index);
// Removes the element at the specified index and shifts remaining elements left.


public class LList2 {
    
    public static class LLToStack{
        LinkedList<Integer> list;

        public LLToStack(){
            list = new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        void push(int val){
            list.add(val);
        }

        int pop(){
            if (size()==0) {
                return -1;
            }
            else{
                int poped = list.removeLast();
                return poped;
            }
        }

        int top(){
            if (size()==0) {
                return -1;
            }
            else{
                return list.getLast();
            }
        }
    }

    
}
