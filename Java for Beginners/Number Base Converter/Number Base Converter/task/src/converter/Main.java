package converter;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String DIGITS = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            final var params = scanner.nextLine().split(" ");
            if ("/exit".equalsIgnoreCase(params[0])) {
                return;
            }
            final var base = Arrays.stream(params).mapToInt(Integer::parseInt).toArray();
            while (true) {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", base[0], base[1]);
                final var number = scanner.nextLine();
                if ("/back".equalsIgnoreCase(number)) {
                    break;
                }
                System.out.println("Conversion result: " + fromToRadix(number, base[0], base[1]));
            }
        }
    }

    public static String fromToRadix(String number, int sourceBase, int targetBase) {
        final var dotIndex = number.indexOf('.');
        if (dotIndex == -1) {
            return new BigInteger(number, sourceBase).toString(targetBase);
        }
        final var sourceWhole = number.substring(0, dotIndex);
        final var sourceFraction = number.substring(1 + dotIndex);
        final var targetWhole = new BigInteger(sourceWhole, sourceBase).toString(targetBase);
        var decimalFraction = 0.0;
        var divider = (double) sourceBase;

        for (final var digit : sourceFraction.toCharArray()) {
            decimalFraction += DIGITS.indexOf(digit) / divider;
            divider *= sourceBase;
        }
        final var targetFraction = new StringBuilder();
        for (int i = 5; i > 0; --i) {
            decimalFraction *= targetBase;
            final var index = (int) decimalFraction;
            targetFraction.append(DIGITS.charAt(index));
            decimalFraction -= index;
        }

        return targetWhole + "." + targetFraction;
    }
}