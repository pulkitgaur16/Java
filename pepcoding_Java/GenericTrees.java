import java.util.*;
public class GenericTrees {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        String str= node.data+ "->";
        for(Node child: node.children){ // node child in node.children
            str+=child.data + ",";
        }
        str+= ".";
        System.out.println(str);

        for(Node child: node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int size=0;
        for(Node child: node.children){
            int cs = size(child); // here returned size will appear
            size = size+cs;
        }
        size=size+1;

        return size;
    }
    //Terminologies:-
    // Parent : node which contains other nodes
    // Child : node inside parent node
    // Ancestors : all parent nodes of child
    // Descendent : all the nodes that are followed by that node
    // Root : the topmost node 

    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90,-1,-1,40,100,-1,-1};

        Node root=null;
        Stack<Node> st= new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node t = new Node();
                t.data = arr[i];

                if(st.size()>0){
                    st.peek().children.add(t);
                }
                else{
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
        System.out.println(size(root));
    }
}
