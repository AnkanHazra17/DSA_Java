

public class EvenNumberofDigits{

    // Calculates the number of elements in the array that have an even number of digits.
    static int numberOfEvenDigits(int[] arr){
        int n = arr.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            if(isEvenNumber(arr[i])){  // Check if the element has an even number of digits
                count++;
            }
        }
        return count;
    }


    // Method that Checks if a number has an even number of digits.
    static boolean isEvenNumber(int num){
        int numberOfDigits = digitNumber(num);  // Get the number of digits in the number

        // Check if the number of digits is divisible by 2
        if(numberOfDigits % 2 == 0){
            return true;  // The number has an even number of digits
        }
        return false;  // The number does not have an even number of digits
    }


    // Method that Calculates the number of digits in a given number.
    static int digitNumber(int num){

        int count = 0;

        if(num == 0){   // Special case for number 0 which has 1 digit
            return 1;
        }

        if(num < 0){
            num = num * -1;  // Convert negative number to positive
        }

        while(num > 0){
            count++;   // Increment the digit count
            num = num / 10;  // Divide the number by 10 to remove the rightmost digit
        }
        return count;
    }

    

    public static void main(String[] args){
        int[] arr = {12, 2, 345, 5292, 87, 3};
        System.out.println(numberOfEvenDigits(arr));
    }
}