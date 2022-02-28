package mypack;

public class Compulsory {
    // perform calculations
    public static int performCalculations(int n, String binaryStr, String hexadecimalStr) {
        int decimalOfBinary = Integer.parseInt(binaryStr,2);
        int decimalOfHexa = Integer.parseInt(hexadecimalStr,16);
        n *= 3;
        n += decimalOfBinary;
        n+= decimalOfHexa;
        n *= 6;
        return n;
    }

    // returns total sum of digits
    static int calcSumOfDigits(int n) {
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

    public static void rouletteWheelGame(){

        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        System.out.println("n = " + n);
        String str1 = "10101", str2 = "FF";
        n = performCalculations(n, str1, str2);
        System.out.println("After calculations n = " + n);

        // Compute the sum of the digits until the result has only one digit
        int result = n = calcSumOfDigits(n);
        System.out.println("Sum of all digits = " + n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + "\n\n");

    }

    public static void main(String[] args) {
        rouletteWheelGame();
    }
}
