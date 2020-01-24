public class Array{
    public static void main(String[]args){
        int [][]array = new int[10][10];
        for(int row = 0; row < 10; row++){
            for(int col = 0; col < 10; col++){
                System.out.print(array[row][col]);
            }
            System.out.println();
        }
    }
}