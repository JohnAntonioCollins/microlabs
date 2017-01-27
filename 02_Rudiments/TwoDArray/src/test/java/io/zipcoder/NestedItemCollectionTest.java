package io.zipcoder;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//import java.util.Arrays;


public class NestedItemCollectionTest {

    Integer[][] integerArray = {{1,2,5,3,4,5}, {4,3,2,1}, {3,3}};
    NestedItemCollection collection;

    @Before
    public void setup(){
        collection = new NestedItemCollection(integerArray);
    }

    @Test
    public void intializeNestedItemsArraySizeTest(){
        int expected = 2;
        int actual = collection.length();
        assertEquals("The value of the initialized array should be 2",expected, actual);
    }

    @Test
    public void initializedNestedItemsArrayElementTest(){
        NestedItem itemExpected = new NestedItem(integerArray[0]);
        NestedItem itemActual = collection.getAtIndex(0);
        Integer expected = itemExpected.getPrimeNumberCount();
        Integer actual = itemActual.getPrimeNumberCount();
        assertEquals(expected, actual);
    }

    @Test//this test is not pure enough, get rid of excess methods
    public void sortByPrimeCountTest(){
        Integer[] testInput = {3,3};
        NestedItem testItem = new NestedItem(testInput);
        Integer[] expected = testItem.getArrayOfInts();
        //collection.sortByPrimeCount();
        Integer[] actual = collection.getAtIndex(0).getArrayOfInts();
    //overload toString to compare string of arrays rather than object IDs.
        assertEquals("should sort Collection by item's prime count ascending", Arrays.toString(expected), Arrays.toString(actual));
    }// end sortByPrimeCountTest

    @Test
    public void setANDgetIndexOfFirstOddTest(){
        Integer[] testInput = {6,6,20,44,17,6};
        NestedItem testItem = new NestedItem(testInput);
        System.out.println(Arrays.toString(testItem.getArrayOfInts()));
        int expected = 2;
        int actual = testItem.getIndexOfFirstOdd();
        assertEquals("should return 2, third index.", expected, actual);

        }

    @Test
    public void setANDgetValueOfFirstOddTest(){
        Integer[] testInput = {6,6,20,44,17,6};
        NestedItem testItem = new NestedItem(testInput);
        //System.out.println(Arrays.toString(testItem.getArrayOfInts()));
        int expected = 17;
        int actual = testItem.getValueOfFirstOdd();
        assertEquals("should return 17, highest odd in lowest index.", expected, actual);
    }

    @Test // unfinished test
    public void sortByIndexOfFirstOddTest(){
            //collection.sortByIndexOfFirstOdd();
        System.out.println(Arrays.toString(collection.getAtIndex(0).getArrayOfInts()));
        System.out.println(Arrays.toString(collection.getAtIndex(1).getArrayOfInts()));
        System.out.println(Arrays.toString(collection.getAtIndex(2).getArrayOfInts()));
        int expected = 0;
        int actual = 1;
        assertEquals("should result in sorted by index, ascending, of first odd", expected, actual);
    }

    @Test // unfinished test
    public void sortByValueOfFirstOddTest(){
        //collection.sortByValueOfFirstOdd();
        System.out.println(Arrays.toString(collection.getAtIndex(0).getArrayOfInts()));
        System.out.println(Arrays.toString(collection.getAtIndex(1).getArrayOfInts()));
        System.out.println(Arrays.toString(collection.getAtIndex(2).getArrayOfInts()));
        int expected = 0;
        int actual = 1;
        assertEquals("should result in sorted by  value, ascending, of first odd ", expected, actual);
    }
}
