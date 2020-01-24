//EmplDate_mpGUI_1a.java

import java.util.Scanner;

public class Employee_1a
{
    public static Date date1;
    public static Employee e1;

    public static void main(String[] args)
    {
        String name1;
        int ID1, nrHours1, month1, day1, year1, choice1;
        double paidHour1;

        Scanner keyb = new Scanner(System.in);

        choice1 = Menu();
        while((choice1>=1) && (choice1<=3))
        {
            if(choice1 == 1)
            {
                System.out.print("enter name: " );
                name1 = keyb.nextInt();

                System.out.print("Enter ID: ");
                ID1 = keyb.nextInt();

                System.out.print("Enter nr hours: ");
                nrHours1 = keyb.nextInt();

                System.out.print("Enter paidHour: ");
                paidHour1 = keyb.nextDouble();

                System.out.print("Enter month: ");
                month1 = keyb.nextInt();

                System.out.print("Enter day: ");
                day1 = keyb.nextInt();

                System.out.print("Enter year: ");
                year1 = keyb.nextInt();
            }
            else if (choice1 == 2)
            {
                e1.print();
            }
            else if (choice1 == 3)
            {
                break;
            }

            choice1 = Menu();
        }//end of while
    }//end main

    public static int Menu()
    {
        int choice1;

        System.out.print("\n\n1. Enter Employee's data. \n");
        System.out.print("\n\n2. Print employee \n");
        System.out.print("\n\n3. Exit the program \n");

        Systen.out.print("\n\n What would you like to do? Enter your choice: \n");

        Scanner keyb = new Scanner(System.in);
        choice1 = keyb.nextInt();

        return choice1;
    }
}


