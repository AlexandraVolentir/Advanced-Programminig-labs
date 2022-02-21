public class Main {
    static int performCalculations(int n, String binaryStr, String hexadecimalStr)
    {
//        String binaryStr = "10101";
//        String hexadecimalStr = "FF";
        int decimalOfBinary = Integer.parseInt(binaryStr,2);
        int decimalOfHexa = Integer.parseInt(hexadecimalStr,16);
        n *= 3;
        n += decimalOfBinary;
        n+= decimalOfHexa;
        n *= 6;
        return n;
    }
    static int calcSumOfDigits(int n)
    {
        int sum = 0;
        while((n/10) != 0) {
            sum = 0;
            while(n != 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Define an array of strings languages
        String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        // Generate a random integer
        int n = (int) (Math.random() * 1000000);
        System.out.println("n = " + n);

        /*
          Compute the result obtained after performing the following calculations:
          multiply n by 3;
          add the binary number 10101 to the result;
          add the hexadecimal number FF to the result;
          multiply the result by 6
        */
        n = performCalculations(n, "10101", "FF");
        System.out.println("After calculations n = " + n);

        // Compute the sum of the digits until the result has only one digit
        int result = n = calcSumOfDigits(n);
        System.out.println("Sum of all digits = " + n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
