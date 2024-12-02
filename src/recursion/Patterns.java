package recursion;

public class Patterns {
    public static void main(String[] args){
        notRecTriangle(5);
    }

    public static void triangle(int row, int col){
        if(row == 0) return;

        if(col < row){
            System.out.print("*");
            triangle(row, col + 1);
        }else{
            System.out.println();
            triangle(row - 1, 0);
        }
    }

    public static void notRecTriangle(int l){
        for(int row = 0; row < l; row++){

            for(int col = 0; col <= row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void triangle2(int row, int col){
        if(row == 0) return;

        if(col < row){
            triangle2(row, col + 1);
            System.out.print("*");
        }else{
            triangle2(row - 1, 0);
            System.out.println();
        }
    }

    public static void notRecTriangle2(int l){
        for(int row = 1; row <= l; row++){
            for(int col = l; col >= row; col--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
