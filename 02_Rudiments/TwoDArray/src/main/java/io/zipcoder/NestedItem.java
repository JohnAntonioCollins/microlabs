package io.zipcoder;

import java.util.Arrays;
import java.util.Collections;


public class NestedItem {
    private Integer[] arrayOfInts;
    private int primeNumberCount = 0;
    private int indexOfFirstOdd;
    private int valueOfFirstOdd;

    public int getIndexOfFirstOdd() { return indexOfFirstOdd; }

    public int getValueOfFirstOdd() { return valueOfFirstOdd; }

    public Integer[] getArrayOfInts() {
        return arrayOfInts;
    }

    public int getPrimeNumberCount() {
        return primeNumberCount;
    }

    public NestedItem(Integer[] arrayOfInts){
        this.arrayOfInts = arrayOfInts;
        countPrimeNumber();
        sortArrayOfIntsDescending();
        setIndexOfFirstOdd();
        setValueOfFirstOdd();

    }

    private void countPrimeNumber(){
        for (int element : arrayOfInts){
            if (isPrime(element)){
                primeNumberCount ++;
            }
        }
    }

    private void sortArrayOfIntsDescending(){
        Arrays.sort(arrayOfInts, Collections.reverseOrder());
    }

    private boolean isPrime(int n) {
        if(n == 2) return true;
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    //make getFirstOdd private after it's master method is coded.
    //(n+2)%2 = 1 for odds, 0 for evens.
    public void setIndexOfFirstOdd(){
            for (int k = 0; k < this.getArrayOfInts().length-1; k++) {
                if ((this.getArrayOfInts()[k] +2)%2 == 1) {
                    //System.out.println("index "+(k));//index of first odd number
                    //System.out.println("odd number "+this.getArrayOfInts()[k]);//first odd number
                    this.indexOfFirstOdd = k;
                }
            }
    }// end setIndexOfFirstFirstOdd

    //make setValueOfFirstOdd private after it's master method is coded.
    //(n+2)%2 = 1 for odds, 0 for evens.
    public void setValueOfFirstOdd(){
        for (int k = 0; k < this.getArrayOfInts().length-1; k++) {
            if ((this.getArrayOfInts()[k] +2)%2 == 1) {
                //System.out.println("index "+(k));//index of first odd number
                //System.out.println("odd number "+this.getArrayOfInts()[k]);//first odd number
                this.valueOfFirstOdd = this.getArrayOfInts()[k];
            }
        }
    }// end setValueOfFirstOdd

}


