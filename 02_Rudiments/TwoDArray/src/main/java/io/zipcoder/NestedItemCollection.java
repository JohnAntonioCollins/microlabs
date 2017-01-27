package io.zipcoder;


public class NestedItemCollection {

    private NestedItem[] nestedItems;

    public NestedItemCollection(Integer[][] integerArrays){
        nestedItems = new NestedItem[0];
        parseAndPopulateNestedItemsArray(integerArrays);
        sortByPrimeCount();
        sortByIndexOfFirstOdd();//make this conditional tiebreaker
        sortByValueOfFirstOdd();//make this conditional secondary tiebreaker
    }

    private void parseAndPopulateNestedItemsArray(Integer[][]integerArrays){
        for(Integer[] integerArray: integerArrays){
            NestedItem nestedItem = new NestedItem(integerArray);
            add(nestedItem);
        }
    }

    private void add(NestedItem item){
        int tempArrayLength = nestedItems.length +1;
        NestedItem[] tempArray = new NestedItem[tempArrayLength];
        System.arraycopy(nestedItems,0,tempArray,0,nestedItems.length);
        tempArray[tempArrayLength-1] = item;
        nestedItems = tempArray;
    }

    public NestedItem[] getNestedItems() {
        return nestedItems;
    }

    public NestedItem getAtIndex(int index){
        NestedItem response =  null;
        if ((index >= nestedItems.length) || (index < 0)) {
            response = null;
        } else {
            response = nestedItems[index];
        }
        return response;
    }

    public void sortByPrimeCount(){
        NestedItem[] temp = new NestedItem[2];
        for(int k = 0; k < length()-1; k++){
            for(int i = 0; i < length()-1; i++) {
                    if (this.getAtIndex(i).getPrimeNumberCount() > this.getAtIndex(i + 1).getPrimeNumberCount()) {
                        temp[0] = this.getAtIndex(i);
                        temp[1] = this.getAtIndex(i + 1);
                        nestedItems[i] = temp[1];
                        nestedItems[i + 1] = temp[0];

                        if (this.getAtIndex(i).getPrimeNumberCount() == this.getAtIndex(i + 1).getPrimeNumberCount()) {
                            //nestedItems.breakTie(i);
                        }
                    }
            }
       }
    }//end sortByPrimeCount

    public int length(){
        return nestedItems.length;
    }

    public void sortByIndexOfFirstOdd(){
            NestedItem[] temp = new NestedItem[2];
            for(int k = 0; k < length()-1; k++){
                for(int i = 0; i < length()-1; i++) {
                    if (this.getAtIndex(i).getIndexOfFirstOdd() > this.getAtIndex(i + 1).getIndexOfFirstOdd()) {
                        temp[0] = this.getAtIndex(i);
                        temp[1] = this.getAtIndex(i + 1);
                        nestedItems[i] = temp[1];
                        nestedItems[i + 1] = temp[0];
                        }
                    }
                }
            }//end sortByPrimeCount

    public void sortByValueOfFirstOdd(){
        NestedItem[] temp = new NestedItem[2];
        for(int k = 0; k < length()-1; k++){
            for(int i = 0; i < length()-1; i++){
                if (this.getAtIndex(i).getValueOfFirstOdd() < this.getAtIndex(i+1).getValueOfFirstOdd()){
                    temp[0] = this.getAtIndex(i);
                    temp[1] = this.getAtIndex(i+1);
                    nestedItems[i] = temp[1];
                    nestedItems[i+1]= temp[0];
                }
            }
        }

    }// end sortByValueOfFirstOdd
    /*
    public int breakTie(int j){
        //how to get sub arrays to iterate over?
                NestedItem tempArray01 = this.getAtIndex(j);
                NestedItem tempArray02 = this.getAtIndex(j+1);
                NestedItem[] temp = new NestedItem[2];
        for (int i = 0; i < -1; i++) {
            if(tempArray01.getArrayOfInts()[i]%2 == 0){
                temp[0] = this.getAtIndex(i);
                temp[1] = this.getAtIndex(i + 1);
                nestedItems[i] = temp[1];
                nestedItems[i + 1] = temp[0];
            }
        }
    }//end of breakTie
    */



}