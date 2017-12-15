package junitteststat;

/**
 * Library of statistical functions using Generics for different statistical
 * calculations.
 *
 * @author Joey Programmer
 */
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pratap
 */
public final class jblink_stats {

    /**
     *
     * @param numberList array List
     * @param includeNegative false if list include negative values
     * @return average of the list values
     * @throws exception if all the values are less than 0
     */
    public static <T extends Number> double average(ArrayList<T> numberList, boolean includeNegative) {
        //gets the sum of the list
        double s = sum(numberList, includeNegative);
        int c = 0;
        //count the number of values in the list
        for (int i = 0; i < numberList.size(); i++) {
            if (includeNegative || numberList.get(i).doubleValue() >= 0) {
                c++;
            }
        }
        // throws an exception if there is no values greater than 0
        if (c == 0) {
            throw new IllegalArgumentException("no values are > 0");
        }
        return s / c;
    }

    /**
     *
     * @param <T>
     * @param numberList array list
     * @param includeNegative false if list include negative values
     * @return sum of the values in array list
     * @throws exception if the list is empty
     */
    public static <T extends Number> double sum(ArrayList<T> numberList, boolean includeNegative) {
        //checks for empty list
        if (numberList.size() < 0) {
            throw new IllegalArgumentException("x cannot be empty");
        }
        
        // calculate the sum of the values of the list
        double sum = 0.0;
        for (T val : numberList) {
            double value = val.doubleValue();
            if (includeNegative || value >= 0) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     *
     * @param <T>
     * @param numberList array list
     * @return median of the values
     */
    public static <T extends Number> double median(ArrayList<T> numberList) {
        double median;
        // finding the pivot value of the list 
        if (numberList.size()%2==0) {
            int halfLength = numberList.size()/2-1;
            median = (findNextValue(numberList, halfLength) + findNextValue(numberList,halfLength+1))/2;
        }
        else
            median = findNextValue(numberList, numberList.size()/2);
        return median;
    }
    
    /**
     *
     * @param <T>
     * @param numberList
     * @param p the place to start counting
     * @return the median (pivot of the list)
     */
    private static <T extends Number> double findNextValue(ArrayList<T> numberList, int p) 
    {
        ArrayList<T> lessThan = new ArrayList<>();
        ArrayList<T> greaterThan = new ArrayList<>();
        
        int pivot = numberList.size()/2;
        // re-arraging arrounf the pivot
        double pivot_value = numberList.get(pivot).doubleValue();
        for (T v : numberList) {
            if (v.doubleValue() < pivot_value)
                lessThan.add(v);
            else if (v.doubleValue() > pivot_value)
                greaterThan.add(v);
        }
        // re-arraging arrounf the pivot
        if(p < lessThan.size()) 
            return findNextValue(lessThan, p);
        
        else if(p >= (numberList.size() - greaterThan.size())) 
            return findNextValue(greaterThan,p - (numberList.size() - greaterThan.size()));

        return pivot_value;
    }

    /**
     *
     * @param <T>
     * @param dataList array list
     * @return standard deviation
     */
    public static <T extends Number> double standardDeviation(ArrayList<T> dataList) {
        if (dataList.size() <= 1) {
            throw new IllegalArgumentException("Size of array must be greater than 1");
        }

        int n = dataList.size();
        double sum = 0;
        //find the average
        double average = average(dataList,true);
        
        // get the sum of squares of the values of the list
        for (int i = 0; i < n; i++) {
            double value = dataList.get(i).doubleValue();
            sum += Math.pow(value - average,2);
        }
        //find the standard deviation
        double standardDeviation = Math.sqrt(sum / (n-1));
        return standardDeviation;
    }

    // Simple set of tests that confirm that functions operate correctly

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        ArrayList<Integer> testDataIntegers = new ArrayList<>(Arrays.asList(9,2,7,4,5,6,3,8,1,10));
        ArrayList<Double> testDataDoubles = new ArrayList<>(Arrays.asList(2.2, 100.0, 17.5, 30.2, 31.1));

        System.out.printf("The sum of the Integer array = %.0f\n", sum(testDataIntegers, true));
        System.out.printf("The sum of the Double array = %.0f\n", sum(testDataDoubles, true));

        System.out.printf("The average of the Integer test set = %.2f\n", average(testDataIntegers, true));
        System.out.printf("The average of the Double test set = %.2f\n", average(testDataDoubles, true));

        System.out.printf("The median value of the Integer data set = %.2f\n", median(testDataIntegers));
        
        System.out.printf("The median value of the Double data set = %.2f\n", median(testDataDoubles));
        
        System.out.printf("The sample standard deviation of the Integer test set = %.2f\n", standardDeviation(testDataIntegers));
        System.out.printf("The sample standard deviation of the Double test set = %.2f\n", standardDeviation(testDataDoubles));
    }
}
