import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static int findMinDiff(int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        Arrays.sort(array);
        for (int i=0; i<= N-M;i++)
            result = Math.min(result, array[i + M - 1] - array[i]);
        return result;
    }

    static int findelements(int res,int array[], int N, int M)
    {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<=N; i++)
        {
            result = Math.min(result, array[i + M - 1] - array[i]);
            if (res==result)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            
            System.setOut(new PrintStream(
                new FileOutputStream("output.txt")));

            
            read = new Scanner(new File("input.txt"));
        }
        
        catch (Exception e) {
        }

        
        int price[]={7980,22349,999,2799,229900,11101,9999,2195,9800,4999};
        String goodiesitems[]={ "MI Band: 999","Sandwich Toaster: 2195" ,"Cult Pass: 2799","Scale: 4999","Fitbit Plus: 7980","Microwave Oven: 9800"  ,"Alexa: 9999","Digital Camera: 11101", "IPods: 22349","Macbook Pro: 229900" };
        int N = price.length;
        System.out.println("Enter the number of employees");
        Scanner s = new Scanner(System.in);
        int M=s.nextInt();
        int result=findMinDiff(price, N, M);
        System.out.println("Number of the employees:"+M);
        int startindex=findelements(result,price,N,M);
        System.out.println("Here the goodies that are selected for distribution are:");
        for(int i=startindex;i<startindex+M;i++)
            System.out.println(goodiesitems[i]);
        System.out.println("\n");
        System.out.println("And the difference between the chosen goodies with highest price and the lowest price is:"+result);
    }
}