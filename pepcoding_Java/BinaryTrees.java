import java.util.*;

import javax.swing.tree.TreeNode;
public class BinaryTrees {
    // In binary trees there can be 0,1, or 2 childs are possible of each node
    // 2 childs are max

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }

    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node=node;
            this.state=state;
        }
    }

    public static void display(Node node){
        if(node==null){
            return;
        }
        String str= "";
        
        str+=node.left==null?".": node.left.data+"";
        str+= " <- " + node.data + " -> ";
        str+= node.right==null? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node){
        if(node==null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right); 
        int ts= ls+rs+1;
        return ts;
    }

    public static int sum(Node node){
        if(node==null){
            return 0;
        }
        int lsm= sum(node.left);
        int rsm= sum(node.right);
        int tsm= lsm+rsm+ node.data;

        return tsm;
    }

    public static int max(Node node){ // never compare value/data of node without checking null pointer exception
        // M1
        // if(node==null){
        //     return 0;
        // }
        // int max= node.data;

        // if(node.left!=null && node.left.data>max){
        //     max= node.left.data;
        // }
        // if(node.right!=null && node.right.data>max){
        //     max= node.right.data;
        // }

        // if(max(node.left)>max){
        //     max= max(node.left);
        // }
        // if(max(node.right)>max){
        //     max= max(node.right);
        // }
        // return max;

        // M2
        if(node==null){
            return Integer.MIN_VALUE; // -infinity is the identity for finding max
        }
        int lm= max(node.left);
        int rm = max(node.right);

        return Math.max(node.data, Math.max(lm,rm));
    }

    public static int min(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        int lm= min(node.left);
        int rm= min(node.right);

        return Math.min(node.data, Math.min(lm, rm)) ;
    }

    public static int height(Node node){
        if(node==null){
            return -1; // -1 for edges, 0 for nodes
            // think of this by finding height of a single node
        }
        int lh= height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh,rh)+1;

        return th;
    }
    // Note: in generic trees we don't need base case because there we
    // traverse through loop but in binary we need base case.

    public static void traversal(Node n){
        if(n==null){
            return;
        }
        System.out.println(n.data + " in Preorder");
        traversal(n.left);
        System.out.println(n.data+ " in Inorder");
        traversal(n.right);
        System.out.println(n.data+ " in Postorder");
    }
    //Note: Preorder (Root -> Left -> Right)
    // Inorder (Left -> Root -> Right)
    // Postorder (Left -> Right -> Root)

    public static void LevelOrderTraversal(Node n){
        Queue<Node> mq= new ArrayDeque<>();
        mq.add(n);

        while(mq.size()>0){
            int count= mq.size();
            for(int i=0; i<count;i++){
                n= mq.remove();
                System.out.print(n.data+ " ");

                if(n.left!=null){
                    mq.add(n.left);
                }
                if(n.right!=null){
                    mq.add(n.right);
                }
            }
            System.out.println();
        }
    }

    static ArrayList<Node> path;
    public static boolean NodeToRoot(Node node, Node data){
        if(node==null){
            return false;
        }
        if(node == data){
            path.add(node);
            return true;
        }

        boolean filc= NodeToRoot(node.left, data);
        if(filc){
            path.add(node);
            return true;
        }
        boolean firc= NodeToRoot(node.right, data);
        if(firc){
            path.add(node);
            return true;
        }

        return false;
    }

    public static void KthNodes(Node node, int k, Node blocker){
        //M1 (using BFS)
        // if(node!=null){
        //     Queue<Node> mq= new ArrayDeque<>();
        //     mq.add(node);
        //     int level=0;

        //     while(mq.size()>0){
        //         int count=mq.size();
        //         for(int i=0;i<count;i++){
        //             node=mq.remove();
        //             if(level==k){
        //                 System.out.print(node.data + " ");
        //             }

        //             if(node.left!=null){
        //                 mq.add(node.left);
        //             }
        //             if(node.right!=null){
        //                 mq.add(node.right);
        //             }
        //         }
        //         level++;
        //     }
        // }

        // M2 (using recursion)
        if(node==null|| k<0 || node== blocker){  // blocker node is added for below question
            return;
        }
        if(k==0){
            System.out.print(node.data + " ");
        }
        KthNodes(node.left, k-1, blocker);
        KthNodes(node.right, k-1, blocker);
    }

    public static void KthFar(Node node, Node data, int k){
        path= new ArrayList<>();
        NodeToRoot(node, data);

        for (int i=0; i<path.size();i++) {
            KthNodes(path.get(i), k-i, i==0? null: path.get(i-1));
        }
    }
    
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            sum+=node.data;
            if(sum >= lo && sum <=hi){
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path+node.data+" ", sum+node.data, lo, hi);
        pathToLeafFromRoot(node.right, path+node.data+" ", sum+node.data, lo, hi);
    }

    public static void leftCloned(Node node){
        if(node==null){
            return;
        }
        Node temp= new Node(node.data, node.left, null);
        Node left= node.left;
        Node right= node.right;
        node.left= temp;

        leftCloned(left);
        leftCloned(right);
    }

    public static Node transBackFromLeftClonedTree(Node node){
        // here we have used postorder traversal but in above we have used preorder tarversal
        if(node==null){
            return null;
        }
        Node lnn= transBackFromLeftClonedTree(node.left.left);
        Node rnn= transBackFromLeftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;

        return node;
    }

    public static void SingleChildNodes(Node node){
        if(node==null){
            return;
        }
        if(node.left==null || node.right==null){
            if(node.left== null && node.right==null){
                return;
            }
            else if(node.left==null){
                System.out.println(node.right.data);
            }
            else if(node.right==null){
                System.out.println(node.left.data);
            }
        }

        SingleChildNodes(node.left);
        SingleChildNodes(node.right);
    }

    public static Node removeLeaves(Node node){
        if(node== null){
            return null;
        }
        if(node.left!=null && node.left.left==null && node.left.right==null){
            node.left=null;
        }
        if(node.right!=null && node.right.left==null && node.right.right==null){
            node.right=null;
        }

        removeLeaves(node.left);
        removeLeaves(node.right);

        return node;
    }

    // Largest BST subtree
    public static class BSTPair{
        boolean isBST;
        long max;
        long min;
        Node root;
        int size;
    }
    public static BSTPair isBST(Node node){
        if(node==null){
            BSTPair bp= new BSTPair();
            bp.min = Long.MAX_VALUE;
            bp.max= Long.MIN_VALUE;
            bp.isBST = true;
            bp.root=null;
            bp.size=0;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();

        mp.isBST = lp.isBST && rp.isBST && 
                   (node.data > lp.max && node.data < rp.min);

        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        if(mp.isBST){
            mp.root=node;
            mp.size= lp.size+rp.size+1;
        }
        else if(lp.size>rp.size){
            mp.root= lp.root;
            mp.size= lp.size;
        }
        else{
            mp.root= rp.root;
            mp.size= rp.size;
        }

        return mp;
    }

    public static void backfromLeftCloned(Node node){
        if(node==null){
            return;
        }
        node.left= node.left.left;

        backfromLeftCloned(node.left);
        backfromLeftCloned(node.right);
    }
    
    public static boolean RemoveLeaves(Node node){
        if(node==null){
            return false;
        }

        if(node.left==null && node.right==null){
            return true;
        }

        boolean ll = RemoveLeaves(node.left);
        if(ll){
            node.left=null;
        }

        boolean rl = RemoveLeaves(node.right);
        if(rl){
            node.right=null;
        }

        return false;
    }
    
    // Inefficient approach
    public static int diameter1(Node node){ // not always the diameter will include the root node
        if(node==null){
            return 0;
        }

        int ld= diameter1(node.left); // max distance b/w two nodes of lhs
        int rd= diameter1(node.right); // max distance b/w two nodes of rhs

        int f= height(node.left) + height(node.right) +2; // n^2 time complexity

        int dia= Math.max(f, Math.max(ld,rd));

        return dia;
    }
    
    //efficient approach (O(n))
    static class DiaPair{
        int ht;
        int dia;
    }

    public static DiaPair diameter2(Node node){
        if(node==null){
            DiaPair bp= new DiaPair();
            bp.ht=-1;
            bp.dia= 0;
            return bp;
        }
        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht= Math.max(lp.ht, rp.ht)+1;

        int fes= lp.ht+rp.ht+2;
        mp.dia= Math.max(fes, Math.max(lp.dia, rp.dia));

        return mp;
    }

    static int tilt=0;
    public static int tilt(Node node){
        if(node==null){
            return 0;
        }

        int ld= tilt(node.left);
        int rd= tilt(node.right);

        tilt += Math.abs(ld-rd);

        return node.data+ld+rd;
    }

    public static boolean BST(Node node){
        if(node==null){
            return true;
        }

        boolean left= BST(node.left);
        boolean right= BST(node.right);

        if(node.data>max(node.left) && node.data<min(node.right) && left && right){
            return true;
        }

        return false;
    }

    public static class BalPair{
        int ht;
        boolean isBal;
    }
    public static BalPair isBal(Node node){
        if(node==null){
            BalPair bp = new BalPair();
            bp.ht= 0;
            bp.isBal= true;
            return bp;
        }
        
        BalPair lp= isBal(node.left);
        BalPair rp= isBal(node.right);

        BalPair mp = new BalPair();
        mp.isBal = lp.isBal && rp.isBal && Math.abs(lp.ht-rp.ht)<=1;
        mp.ht= Math.max(lp.ht, rp.ht)+1;

        return mp;
    }

    public static Node constructFromInorder(int[] inorder, int si, int ei){
        if(si>ei) return null;

        int mid = (si+ei)/2;
        Node node = new Node(inorder[mid],null,null);

        node.left = constructFromInorder(inorder, si, mid-1);
        node.right = constructFromInorder(inorder, mid+1, ei);

        return node;
    }
    public static Node constructFromInorder(int[] inorder){
        int n= inorder.length;
        return constructFromInorder(inorder, 0, n-1);
    }
    
    // approach for constructor:-
    // *pre-order traversal with null markers: 
    // 1)Read values top → bottom.

    // 2) A number = create a node.

    // 3) n (null) = no child at that position.

    // 4) Order is always:
    // Node → Left subtree → Right subtree


    public static void main(String[] args){
        Integer[] arr = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        
        Node root= new Node(arr[0],null,null);
        Pair rtp = new Pair(root,1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx=0;
        while(st.size()>0){
            Pair top= st.peek();
            if(top.state==1){

                idx++;
                if(arr[idx] != null){
                    Node ln = new Node(arr[idx],null,null);
                    top.node.left=ln;
                    
                    Pair lp = new Pair(ln,1);
                    st.push(lp);
                }
                else{
                    top.node.left=null;
                }
                top.state++;
            }
            else if(top.state==2){
                idx++;
                if(arr[idx] != null){
                    Node rn = new Node(arr[idx],null,null);
                    top.node.right=rn;
                    
                    Pair rp = new Pair(rn,1);
                    st.push(rp);
                }
                else{
                    top.node.right=null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }

        // display(root);
        // System.out.println(max(root));
        //traversal(root);

        // path= new ArrayList<>();
        // NodeToRoot(root, 70);
        // System.out.println(path);

        //KthNodes(root, 2);

        // leftCloned(root);
        // display(root);

        // SingleChildNodes(root);

        // removeLeaves(root);
        // display(root);

        //KthFar(root, root.right.right, 4);

        //pathToLeafFromRoot(root, "", 0, 50, 300);

        // System.out.println(diameter1(root));

        // DiaPair p= diameter2(root);
        // System.out.println(p.dia);

        // tilt(root);
        // System.out.println(tilt);

        boolean ifBST= BST(root);
        System.out.println(ifBST);
    }
}
