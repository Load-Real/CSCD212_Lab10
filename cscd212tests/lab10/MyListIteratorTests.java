package cscd212tests.lab10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import cscd212classes.lab10.*;

public class MyListIteratorTests
{

   @Test
   public void testIteratorOnEmptyMyList()
   {
      try
      {
         MyList list = new MyList();
         String actual = "";
         String expected = "";

         for (String s : list)
            actual += s + "\r\n";
         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testIteratorOnEmptyMyList: " + e.getMessage());
      }

   }

   @Test
   public void testManualIteratorOnEmptyMyList()
   {
      try
      {
         MyList list = new MyList();
         String actual = "";
         String expected = "";

         Iterator<String> it = list.iterator();
         while (it.hasNext())
            actual += it.next() + "\r\n";

         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testManualIteratorOnEmptyMyList: " + e.getMessage());
      }

   }

   @Test
   public void testIteratorOnOneItemMyList()
   {
      try
      {
         MyList list = new MyList();
         list.addLast("one");
         String actual = "";
         String expected = "one\r\n";

         for (String s : list)
            actual += s + "\r\n";
         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testIteratorOnOneItemMyList: " + e.getMessage());
      }

   }

   @Test
   public void testManualIteratorOnOneItemMyList()
   {
      try
      {
         MyList list = new MyList();
         list.addLast("one");
         String actual = "";
         String expected = "one\r\n";

         Iterator<String> it = list.iterator();
         while (it.hasNext())
            actual += it.next() + "\r\n";
         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testManualIteratorOnOneItemMyList: " + e.getMessage());
      }

   }

   @Test
   public void testIteratorOnFiveItemMyList()
   {
      try
      {
         MyList list = new MyList();
         list.addLast("one");
         list.addLast("two");
         list.addLast("three");
         list.addLast("four");
         list.addLast("five");

         String actual = "";
         String expected = "one\r\ntwo\r\nthree\r\nfour\r\nfive\r\n";

         for (String s : list)
            actual += s + "\r\n";
         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testIteratorOnFiveItemMyList: " + e.getMessage());
      }

   }

   @Test
   public void testManualIteratorOnFiveItemMyList()
   {
      try
      {
         MyList list = new MyList();
         list.addLast("one");
         list.addLast("two");
         list.addLast("three");
         list.addLast("four");
         list.addLast("five");

         String actual = "";
         String expected = "one\r\ntwo\r\nthree\r\nfour\r\nfive\r\n";

         Iterator<String> it = list.iterator();
         while (it.hasNext())
            actual += it.next() + "\r\n";
         assertEquals(expected, actual);
      } catch (Exception e)
      {
         fail("Exception occurred in testManualIteratorOnFiveItemMyList: " + e.getMessage());
      }

   }

   @Test
   public void testRemoveThrowsException()
   {
      MyList list = new MyList();
      list.addLast("one");
      Iterator<String> it = list.iterator();
      assertThrows(UnsupportedOperationException.class, () -> it.remove());
   }

   @Test
   public void hasNextworksOnEmpty()
   {
      MyList list = new MyList();
      Iterator<String> it = list.iterator();
      assertFalse(it.hasNext());
   }

   @Test
   public void hasNextWorksAtEndOfList()
   {
      MyList list = new MyList();
      list.addLast("one");
      Iterator<String> it = list.iterator();
      it.next();
      assertFalse(it.hasNext());
   }

   @Test
   public void nextWorks()
   {
      MyList list = new MyList();
      list.addLast("one");
      Iterator<String> it = list.iterator();
      assertEquals("one", it.next());
   }
   
   @Test
   public void nextNoElementWorks() {
      MyList list = new MyList();
      Iterator<String> it = list.iterator();
      assertThrows(NoSuchElementException.class, () -> it.next());
   }

}
