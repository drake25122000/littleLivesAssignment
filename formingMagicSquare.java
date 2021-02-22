import java.util.Scanner;

public class FormingMagicSquare
{
    
    /**
     * Forming A Magic Square
     * Since all the numbers in the 3x3 array must be different
     * There are only 8 array combinations that satisfy the Magic Square property
     */
    
    //These are the 8 array combinations
    public static int[][] magicSquare = {
        {4,9,2,3,5,7,8,1,6},
        {4,3,8,9,5,1,2,7,6},
        {2,9,4,7,5,3,6,1,8},
        {2,7,6,9,5,1,4,3,8},
        {8,1,6,3,5,7,4,9,2},
        {8,3,4,1,5,9,6,7,2},
        {6,7,2,1,5,9,8,3,4},
        {6,1,8,7,5,3,2,9,4},
    };
    
    /**
     * To calculate the cost to form magicSquare array
     * @param flattenArray 
     * */
    public static int formMagicSquareCost(int[] flattenArray) {
        int cost = Integer.MAX_VALUE;       //Keep track of the minimum cost
        
        //Loop through every combinations
        for (int i = 0; i < 8 ; i++) {
            int tempCost = 0;
            for (int j = 0 ; j < 9 ; j++) {
                int different = Math.abs(flattenArray[j] - magicSquare[i][j]);
                tempCost = tempCost + different;
            }
            
            cost = tempCost < cost ? tempCost : cost;
        }
        
        return cost;
    }
    
    /**
     * To convert 2D array to 1D array
     * @param arr
     * */
    public static int[] flattenArray(int[][] arr) {
        int[] out = new int[9];
        int pointer = 0;
        
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                out[pointer] = arr[i][j];
                pointer++;
            }
        }
        
        return out;
    }
     
	public static void main(String[] args) {
	    
	    Scanner scan = new Scanner(System.in);
	    System.out.println("Enter array elements : ");    
        
            int inputArr[][] = new int[3][3];
        
          
            for (int i = 0 ; i < 3 ; i++) {            
                for (int j = 0 ; j < 3 ; j++) {
                    inputArr[i][j] = scan.nextInt();
                }
            }
            System.out.println("Minimum cost to form Magic Square: " + (formMagicSquareCost(flattenArray(inputArr))));
        
	    
	}
}
