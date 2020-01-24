import java.util.Scanner;

public class ListDiv_la
{
    public static void main(String[] args)
    {
        int nr;

        Scanner keybd = new Scanner(System.in);

        System.out.print("Enter a Number");
        nr=keybd.nextInt();
        System.out.print("\nThe divisors of " + nr + " are");

        for(int i = 1; i < nr; i++){
            if(nr%i == 0) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }
}