//emplyee.java

public class Employee
{
    private String name;
    private int ID;
    private int nrHours;
    private double paidHour;
    private double salary;
    public Date hiringDate;

    public Employee()
    {
    }

    public void setName(String name1) {
        name = name1;
    }
    public String getname() {
        return name;
    }

    public void setID(int ID1) {
        ID = ID1;
    }
    public int getID() {
        return ID;
    }

    public void setNRHours(int nrHours1){
        nrHours = nrHours1;
    }
    public int getNRHours() {
        return nrHours;
    }

    public double getPaidHour(){
        return paidHour;
    }

    public void computeSalary(){
        salary = nrHours*paidHour;
    }

    public Date setHiringDate(Date hiringDate1){
        hiringDate = hiringDate1;
    }
    public Date getHiringDate(){
        return hiringDate;
    }

    public void print(){
        System.out.println("The employee's name is: "+name);
        System.out.println("The employee's ID is: "+ID);
        System.out.println("The employee's salary is: "+salary);
        System.out.println("The employee's hiring date is: "+hiringDate);
    }
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