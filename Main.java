import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args){
        SortedIntegerList sl1 = new SortedIntegerList(true);
        sl1.add(5);
        sl1.add(2);
        sl1.add(5);
        sl1.add(7);
        sl1.add(4);
        sl1.add(5);
        sl1.add(8);
        System.out.println("First list:\n" + sl1);
        SortedIntegerList sl2 = new SortedIntegerList(true);
        sl2.add(9);
        sl2.add(8);
        sl2.add(1);
        sl2.add(5);
        sl2.add(5);
        sl2.add(2);
        System.out.println("Second list:\n" + sl2);
        System.out.println("Result list without intersections:\n" + sl1.withoutIntersections(sl2));
    }

}
