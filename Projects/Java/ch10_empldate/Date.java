//emplyee.java

public class Employee
{
    private int month;
    private int day;
    private int year;

    public Date()
    {
    }

    public void setMonth(int month1) {
        month = month1;
    }
    public String getMonth() {
        return month;
    }

    public void setDay(int day1) {
        day = day1;
    }
    public int getDay() {
        return day;
    }

    public void setYear(int year1){
        year = year1;
    }
    public int getYear() {
        return year;
    }

    public void printDate(){
        System.out.println(month+ "/" + day + "/" + year);
    }

    public void setHiringDate(Date hiringDate1){
        hiringDate = hiringDate1;
    }
    public Date getHiringDate(){
        return hiringDate;
    }
}