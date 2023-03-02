package cscd212classes.lab10;

/*
   Implement the Iterator interface for the nested MyListIterator class
   which occurs at the bottom of the source code.
   
   Check the Java IPI documentation on Iterator for the three methods
   you must write.  Those methods are hasNext, next, and remove.
   Note that the third method, remove, is optional.
   For your implementation of remove, throw an UnsupportedOperationException.
   Include in your thrown exception the message
   'remove not implemented for MyListIterator'
   
   Look carefully at the iterator method of MyList to see what information
   is passed to the MyListIterator constructor to help you with writing
   your methods.  Also look at the fields provided in the MyListIterator
   class.  You will need those fields to properly implement your methods.
   
   NOTE: The Iterator interface allows you to use an enhanced for loop
   (sometimes called the foreach loop) on any class that implements
   the interface.  Iterator is typically attached to classes that contain
   some form of collection of data (array, ArrayList, etc.) as one of 
   its primary fields.
   
   The Iterator is used to keep track of the current location in a collection
   and move through the collection one step at a time.  What 'one step at a
   time means' can vary from collection to collection.  With something like an
   array or ArrayList, one step at at time just means advance to the next item
   in the array/ArrayList.
   
   NOTE: When you implement Iterator you must ensure the code when it compiles
   does not give the following warning:
   Note: MyList.java uses unchecked or unsafe operations.
   Note: Recompile with -Xlint:unchecked for details.
   
   Think <> and something in the <> other than Object
*/
import java.util.*;

@SuppressWarnings("unchecked")
public class MyList implements Iterable<String>
{
   private ArrayList<String> list;
   
   public MyList()
   {
      this.list = new ArrayList<String>();
   
   }//end default constructor
   
   public void addLast(String str)
   {
      this.list.add(str);
   }//end addLast
   
   public int size()
   {
      return this.list.size();
   
   }//end size method
   
   public String toString()
   {
      String result = "";
      
      for (Object o: this)
         result += o + "\r\n";
         
      return result;
   
   }//end toString
   
   @SuppressWarnings({ "unchecked", "rawtypes" })
public Iterator iterator()
   {
      return new MyListIterator(0, this.list);
   }//end iterator -- required by Iterable interface

//***************************************************************************   
   /**
    * Nested class to provide a means of iterating across the MyList collection
    * Implement* the Iterator interface and provide the methods required by that
    * interface based on discussion from the Java API documentation.
    * NOTE: When you implement Iterator you must ensure the code when it compiles
    * does not give the following warning:
    * Note: MyList.java uses unchecked or unsafe operations.
    * Note: Recompile with -Xlint:unchecked for details.
    * Think <> and something in the <> other than Object
    */
   
   /*Note:
    * -Compile the program in JGrasp to make sure that you don't get warning described on line 84-85
    * -The unsafe operations warning will occur when the compiler cannot guarantee the two objects it is comparing are of the same type,
    * meaning they are generic (Make sure the <> aren't empty in the Comparable, this way it asks for a specific object).
    */
    
   public class MyListIterator<T> implements Iterator<String>
   {  
      private int cur;
      private ArrayList<String> listRef;
      
      public MyListIterator(int start, ArrayList<String> list)
      {
         this.cur = start;
         this.listRef = list;
      
      }
      
      @Override
      public boolean hasNext()
      {
        return cur < this.listRef.size();
      }//end hasNext
      
      //What if there is NOT a next element?
      @Override
      public String next()
      {
    	if (hasNext() == false) throw new NoSuchElementException();
    	return this.listRef.get(cur++);
      }//end next
      
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   
   }//end nested class MyListIterator

   
}//end class MyList