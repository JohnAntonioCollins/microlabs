# TwoDArray
Instructions

Write a method that takes a two dimensional array of integers as an argument. Sort the array 
    according to these rules:

-Each nested array should be sorted in descending order

-The array of arrays should be sorted in ascending order according to the number of prime numbers 
    in each nested array
    
-Ties should be broken based on the position and value of the first odd number, ascending.

-Two arrays tied based on all of the criteria above should be sorted according to the value of the 
    first element that differs.

Sorted Example:

[
    [6,4,2,1,0],
    [5,4,3,2,1],
    [17,14,9,7,7],
    [14,9,7,7,5],
    [3,3,2,2]
]


//make getFirstOdd private after it's master method is coded.
    public int getIndexOfFirstOdd(){
            for (int k = 0; k < this.getArrayOfInts().length; k++) {
                //(n+2)%2 = 1 for odds, 0 for evens.
                if ((this.getArrayOfInts()[k] +2)%2 == 1) {
                    System.out.println(k+1);//index of first odd number
                    System.out.println(this.getArrayOfInts()[k]);//first odd number
                    return k+1;
                }
            }
       return -1;
    }// end getIndexOfFirstFirstOdd