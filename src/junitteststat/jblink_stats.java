package junitteststat;

/**
 * Library of statistical functions using Generics for different statistical
 * calculations.
 *
 * @author Joey Programmer
 */
import java.util.ArrayList;
import java.util.Arrays;

public final class jblink_stats {

    public static <T extends Number> double avg(ArrayList<T> x, boolean incneg) {
        double s = sum(x, incneg);
        int c = 0;
        for (int i = 0; i < x.size(); i++) {
            if (incneg || x.get(i).doubleValue() >= 0) {
                c++;
            }
        }
        if (c == 0) {
            throw new IllegalArgumentException("no values are > 0");
        }
        return s / c;
    }

    public static <T extends Number> double sum(ArrayList<T> x, boolean incneg) {
        if (x.size() < 0) {
            throw new IllegalArgumentException("x cannot be empty");
        }

        double sum = 0.0;
        for (T val : x) {
            double value = val.doubleValue();
            if (incneg || value >= 0) {
                sum += value;
            }
        }
        return sum;
    }

    public static <T extends Number> double med(ArrayList<T> x) {
        double med;
        if (x.size()%2==0) {
            int m = x.size()/2-1;
            med = (fnv(x, m) + fnv(x,m+1))/2;
        }
        else
            med = fnv(x, x.size()/2);
        return med;
    }
    
    private static <T extends Number> double fnv(ArrayList<T> x, int p) 
    {
        ArrayList<T> lt = new ArrayList<>();
        ArrayList<T> gt = new ArrayList<>();
        
        int pv = x.size()/2;
        
        double pv_val = x.get(pv).doubleValue();
        for (T v : x) {
            if (v.doubleValue() < pv_val)
                lt.add(v);
            else if (v.doubleValue() > pv_val)
                gt.add(v);
        }
        
        if(p < lt.size()) 
            return fnv(lt, p);
        
        else if(p >= (x.size() - gt.size())) 
            return fnv(gt,p - (x.size() - gt.size()));

        return pv_val;
    }

    public static <T extends Number> double sd(ArrayList<T> data) {
        if (data.size() <= 1) {
            throw new IllegalArgumentException("Size of array must be greater than 1");
        }

        int n = data.size();
        double s = 0;
        double a = avg(data,true);
        
        for (int i = 0; i < n; i++) {
            double v = data.get(i).doubleValue();
            s += Math.pow(v - a,2);
        }
        double stdev = Math.sqrt(s / (n-1));
        return stdev;
    }

    // Simple set of tests that confirm that functions operate correctly
    public static void main(String[] args) {

        ArrayList<Integer> testDataI = new ArrayList<>(Arrays.asList(9,2,7,4,5,6,3,8,1,10));
        ArrayList<Double> testDataD = new ArrayList<>(Arrays.asList(2.2, 100.0, 17.5, 30.2, 31.1));

        System.out.printf("The sum of the Integer array = %.0f\n", sum(testDataI, true));
        System.out.printf("The sum of the Double array = %.0f\n", sum(testDataD, true));

        System.out.printf("The average of the Integer test set = %.2f\n", avg(testDataI, true));
        System.out.printf("The average of the Double test set = %.2f\n", avg(testDataD, true));

        System.out.printf("The median value of the Integer data set = %.2f\n", med(testDataI));
        
        System.out.printf("The median value of the Double data set = %.2f\n", med(testDataD));
        
        System.out.printf("The sample standard deviation of the Integer test set = %.2f\n", sd(testDataI));
        System.out.printf("The sample standard deviation of the Double test set = %.2f\n", sd(testDataD));
    }
}
