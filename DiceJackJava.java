import java.util.Scanner;
public class DiceJackJava {
    public static void main(String[] args) {

        // Scanner tasks to gather user input

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the game, please enter 3 numbers between 1-6 to begin \n");
        System.out.println("Please enter the first number");
        
        int one = scan.nextInt();
        System.out.println("Please enter the second number");
        int two = scan.nextInt();
        System.out.println("Finally, enter the third number number");
        int three = scan.nextInt();
        
        scan.close();

        int sumforUser = (one + two + three);

        System.out.println("This is the sum of the users choices " + sumforUser);

  

        int userRollOne = DiceRoll();
        int userRollTwo = DiceRoll();
        int userRollThree = DiceRoll();

        int sumforDiceRoll = (userRollOne + userRollTwo + userRollThree);

        System.out.println("this is the sum for the automated diceroll " + sumforDiceRoll+"\n");
        
       
        boolean numberComparisionResult = numberComparision(sumforUser, sumforDiceRoll);
        boolean numberThresholdResult = numberThreshold(sumforUser, sumforDiceRoll);

        System.out.println(numberComparisionResult);
        System.out.println(numberThresholdResult);

        System.out.println(isUserAWinner(numberComparisionResult, numberThresholdResult)); 
        
    }

    // function to roll the dice three times 

    /**
     * Function Name: DiceRoll
     * Inside The Function:
     * 1. Randomly Generates a number from 1 - 6
     */

     public static int DiceRoll(){
         //typecasting double into int
         int roll = (int) Math.round(Math.random() * 6) ;
         return roll;
     };

    // function to check if the user input is larger than the sum of the numbers to chose

    /**
     * Function Name: numberComparision
     * Parameters: userSum = the sum for the dice roll 
     * generatedSum = the sum for the machine generated sum
     * Inside The Function:
     * 1. Returns True if sumforDiceroll < sumforUser
     */

    public static boolean numberComparision(int userSum, int generatedSum){
        if (userSum > generatedSum ){
            return true;
        } else {
            return false;
        }
        
    };

    // function to check if the difference between two sums is < 3

    /**
     * Function Name: numberThreshold
     * Inside The Function: userSum = the sum for the dice roll (int)
     * generatedSum = the sum for the machine generated sum (int)
     * 1. Returns True if (sumforDiceroll - sumforUser) < 3
     */

    public static boolean numberThreshold(int userSum, int generatedSum){
        int difference = userSum - generatedSum;
        if (difference < 3){
            return true;
        } else {
            return false;
        }
        
    };

        // function to determine if user wins

    /**
     * Function Name: isUserAWinner
     * Inside The Function:
     * userResult = boolean result returned from the UserResult function
     * generatedResult = boolean result returned from the generatedResult function
     * 1. Returns True if (numberThreshold & numberComparison is True) 
     */

    public static String isUserAWinner(boolean userResult, boolean generatedResult){

        if (userResult && generatedResult){
            return "You're a winner";
        } else {
            return "Sorry, you  lost";
        }
        
    };
    
}
