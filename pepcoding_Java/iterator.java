import java.util.*;
import java.util.Iterator;
public interface iterator {
    public abstract boolean hasNext(); // check if the list has more
    Object next(); // return the next element
    void remove(); // optional throws exception
}
// public class iterator{
//     public class Shape{
        
//     }
//     public static void main(String str[]){
//         Collection<Shape> myShapes = getSomeCollectionOfShapes();
//         Iterator iter= myShapes.iterator();
//     }
// }
