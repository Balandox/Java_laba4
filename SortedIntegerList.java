import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SortedIntegerList {

    private LinkedList<Integer> data;
    private final boolean duplicate;

    public SortedIntegerList(boolean duplicate){
        this.duplicate = duplicate;
        this.data = new LinkedList<Integer>();
    }


        public void add(Integer element){
            ListIterator<Integer> it = this.data.listIterator();
            while(it.hasNext()){
            int tmpNum = (Integer)it.next();

            if(this.duplicate & element == tmpNum) {
                it.add(element);
                return;
            }
            else if(!this.duplicate & element == tmpNum)
                return;

            if(tmpNum > element) {
                it.previous();
                it.add(element);
                return;
            }
        }
        this.data.add(element);
    }


    public void remove(Integer num){

        ListIterator<Integer> it = this.data.listIterator();

        while(it.hasNext()){
            if(num.equals((Integer)it.next())) {
                it.remove();
                return;
            }
        }
    }

    public Integer size(){return this.data.size();}

    //public void remove(Integer num){this.data.remove(num);}

   @Override
   public String toString(){
       StringBuilder sb = new StringBuilder();
     for(Integer elem : this.data)
        sb.append(elem).append("\t");
     return sb.toString();
  }


    public boolean equals(Object o) {
        if(this == o)
            return true;

      if (o instanceof SortedIntegerList) {
          SortedIntegerList sl = (SortedIntegerList) o;
          if(sl.data.size() != this.data.size() | this.duplicate != sl.duplicate)
              return false;
          ListIterator<Integer> it1 = this.data.listIterator();
          ListIterator<Integer> it2 = sl.data.listIterator();;
          while(it1.hasNext()){
              if((Integer)it1.next() != (Integer)it2.next())
                  return false;
          }
          return true;
      }
      else
          return false;
  }

    public SortedIntegerList( SortedIntegerList list){

        duplicate = list.duplicate;
        this.data = new LinkedList<Integer>(list.data);
    }

 public SortedIntegerList intersection (SortedIntegerList list) {
     SortedIntegerList res = new SortedIntegerList(true);
     SortedIntegerList listCopy = new SortedIntegerList(list);
     ListIterator<Integer> it1 = this.data.listIterator();

     while(it1.hasNext()) {
         int tmp = it1.next();
         ListIterator<Integer> it2 = listCopy.data.listIterator();
         while(it2.hasNext()){
             int tmp2 = it2.next();
             if (tmp2 == tmp) {
                 res.add(tmp);
                 listCopy.remove(tmp);
                 break;
             }
         }
     }

     return res;
 }
  public SortedIntegerList withoutIntersections(SortedIntegerList sl){
        SortedIntegerList res = new SortedIntegerList(this.duplicate);
        SortedIntegerList intersection = this.intersection(sl);
        SortedIntegerList listCopy = new SortedIntegerList(intersection);
        ListIterator<Integer> itThis = this.data.listIterator();
        ListIterator<Integer> itArg = sl.data.listIterator();

     while(itThis.hasNext()){
          Integer tmp = (Integer) itThis.next();
          if(!listCopy.data.contains(tmp)) {
              res.add(tmp);
          }
          else listCopy.remove(tmp);
        }
      while (itArg.hasNext()){
          Integer tmp = (Integer) itArg.next();
          if(!intersection.data.contains(tmp)) {
              res.add(tmp);
          }
          else intersection.remove(tmp);
      }
        return res;
  }


}