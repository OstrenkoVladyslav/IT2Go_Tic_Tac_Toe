package Java1;


public class Lesson1 {
    public static void main(String[] args) {
        byte b = -128;
        short sh = 512;
        int i = 1024;
        long l = 65536;
        float f = -0.223f;
        double d = 44.4321;
        boolean bl = true;
        char c = 'C';
        String s = "Vladislav!";
        System.out.println(calculate(1.0, 2,3,4));
        System.out.println(isInRange(19, -9));
        isPositive(256);
        System.out.println(isNegative(-100));
        printName("Vladislav");
        lapYear(2018);
    }

    public static double calculate(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    public static boolean isInRange(int a, int b) {
        int sum = a + b;
        return (sum >= 10 && sum <= 20);
    }

    public static void isPositive(int a) {
        if (a < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is positive");
        }
    }

    public static boolean isNegative(int a) {
        return (a < 0);
    }

    public static void printName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void lapYear(int year){
        if ((year % 4!=0) || ((year%100==0) && (year%400!=0))){
            System.out.println("Year is not leap");
        } else {
            System.out.println("Year is leap");
        }
    }
}