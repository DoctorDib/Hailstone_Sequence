import java.util.Scanner;
import java.util.Arrays;

public class run {
    /**
     * The 'start' function is the first function call to start the program
     */
    public static void start(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter any number:");
        System.out.print("  - ");

        // Grabbing input from user
        int input = scan.nextInt();
        // Initial array
        int[] arr = new int[0];

        // The initial call
        mainProcess(input, arr);
    }

    /**
     * The 'exit' function is the last function to be called which gives the user the opportunity to run the program
     * again
     */
    public static void exit() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to try again?");
        System.out.print("  - ");
        // Grabbing input from user
        String input = scan.nextLine();

        switch(input.toLowerCase()){
            case "y":
                start(); // Restarting from the beginning
            case "n":
                // Exiting program
                System.exit(0);
            default:
                // User is required to enter either 'y' or 'n'
                System.out.println("Enter either y or n (not case sensitive)");
                exit(); // Recursive call
        }
    }

    /**
     * The concat function adds 'num' onto the 'array'
     *
     * @param num the next number added
     * @param seq is the array of ints that have been collected.
     * @return an int[] array with num concatenated
     */
    public static int[] concat(int num, int[] seq){
        int[] concatArray = new int[seq.length + 1];

        // adding each value from 'seq' over to 'concatArray'
        for (int i=0; i < seq.length; i++){
            concatArray[i] = seq[i];
        }

        // Adding new int to array
        concatArray[seq.length] = num;

        return concatArray;
    }

    /**
     * One time run where it loops through 'array', adding onto the 'reversed' array.
     *
     * @param seq is the array of int that will be reversed.
     * @return 'reversed' array of seq
     */
    public static int[] reverse (int[] seq) {
        // Initialising a reversed array
        int[] reversed = new int[seq.length];

        // Looping through 'array' reversing and adding to 'reversed'
        for (int i=1; i < seq.length +1; i++) {
            reversed[i-1] = seq[seq.length - i];
        }

        return reversed;
    }

    /**
     * The main function which determine if 'num' equals to one, or is even or odd.
     *
     * @param num is the sequenced determined if the value is an even or odd number
     * @param seq is an array of ints collected
     */
    public static void mainProcess (int num, int[] seq){
        int[] arr = concat(num, seq);

        if (num == 1) {
            System.out.println("Forwards: " + Arrays.toString(arr));
            System.out.println("Backwards: " + Arrays.toString(reverse(arr)));
            exit();
        } else if ((num % 2) == 0) {
            // Number is Even
            mainProcess(num / 2, arr);
        } else {
            // Number is Odd
            mainProcess((3 * num) + 1, arr);
        }
    }

    public static void main(String []args){
        start();
    }
}