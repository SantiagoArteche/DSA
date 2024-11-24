package patterns;

public class Patterns {
    public static void main(String[] args){
        diamondMiddleEmpty(5);
    }

    static void normalPattern(int n){
        for(int i = 1; i <= n; i++){ //Start in 1 bcs if I use 0 print an empty line at the start (Same in all patterns)
            for(int j = 1; j <= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void invertPattern(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n; j >= i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void addingNumbers(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void completePattern(int n){
        for(int row = 1; row <= 2 * n; row++){
            int totalCol = row > n ? 2 * n - row : row;
            for(int col = 1; col <= totalCol; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void diamond(int n){
        for(int row = 1; row <= 2 * n; row++){
            int totalCol = row > n ? 2 * n - row : row;
            int noSpaces = n - totalCol; // row > n ? row - n : n - row - totalCols is the same
            for(int j = 0; j < noSpaces ; j++){
                System.out.print(" ");
            }
            for(int col = 1; col <= totalCol; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void diamondMiddleEmpty(int n){
        for(int row = 1; row <= 2 * n; row++){
            int totalCol = row > n ? 2 * n - row : row;
            int noSpaces = n - totalCol; // row > n ? row - n : n - row - totalCols is the same
            for(int j = 0; j < noSpaces ; j++){
                System.out.print(" ");
            }

            for(int col = 1; col <= totalCol; col++){
                if(col == 1 || col == totalCol){
                    System.out.print(" *");
                }else{
                    for (int s = 0; s < 2; s++) {
                        System.out.print(" ");
                    }

                }

            }
            System.out.println();
        }
    }
}
