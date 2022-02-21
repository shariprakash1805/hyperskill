package converter;


import java.math.BigInteger;

public class Main {
    static String fromdecimal(BigInteger Dint, int base) {
        StringBuilder result = new StringBuilder();
        int d = (int) (Math.log10( Dint.doubleValue() )  / Math.log10(base));
        //System.out.printf("base %d, Dint %s, d: %d", base, Dint, d);
        BigInteger a ;
        boolean leadingzero = true;
        BigInteger bigbase = BigInteger.valueOf(base);
        while (d >= 0) {
            a = Dint.divide(bigbase.pow(d));
            Dint =  Dint.mod(bigbase.pow(d));
            d -= 1;
            int a0 = a.intValue();
           // System.out.printf("a: %d, ", a0);
            if (!leadingzero || a0 > 0) {
                result.append(Integer.toString(a0)
                        .replaceAll("^[0-9]{2}$", Character.toString((char) (a0 + 87))));
                leadingzero = false;
               // System.out.printf("result: %s, ", result);
            }
        }
        if (leadingzero) {
            return("0");
        }
        return result.toString();
    }

    static BigInteger todecimal(String inputstr, int base) {
        BigInteger decimal = new BigInteger("0");
        for (int i = 0; i < inputstr.length(); i++) {
            decimal = decimal.add( BigInteger.valueOf(Integer.parseInt(
                    inputstr.substring(inputstr.length() - i - 1, inputstr.length() - i)
                            .replaceAll("[a-z]",
                                    Integer.toString(((int)inputstr.charAt(inputstr.length() - i - 1))-87))))
                    .multiply(BigInteger.valueOf(base).pow(i)));
            //System.out.print(decimal.toString());
        }
        return decimal;
    }

    static void convert(int sourcebase, int targetbase, String number){
        BigInteger decimal = todecimal(number, sourcebase);
        //System.out.printf("decimal: %s, ",decimal.toString());
        System.out.printf("Conversion result: %s\n", fromdecimal(decimal, targetbase));
    }

    static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        String input;
        int sourcebase;
        int targetbase;
        while (true) {
            System.out.print(
                    "Enter two numbers in format: {source base} {target base} (To quit type /exit) ");

            input = scanner.nextLine();
            if ("/exit".equals(input)) {
                break;
            } else {
                sourcebase=Integer.parseInt(input.split(" ")[0]);
                targetbase=Integer.parseInt(input.split(" ")[1]);
            }
            while (true) {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", sourcebase, targetbase);
                input = scanner.nextLine();
                if ("/back".equals(input)) {
                    System.out.println();
                    break;
                }
                convert(sourcebase, targetbase, input);
                System.out.println();
            }
        }

    }
}