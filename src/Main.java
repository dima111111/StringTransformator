import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        makeTests();
        Scanner input = new Scanner(System.in);
        System.out.println("If you want to end program please enter \"end\"");
        System.out.println("Please enter your input string to parse:");
        StringBuffer inputString = new StringBuffer(input.next());
        while (!inputString.toString().equals("end")) {
            System.out.println("Input: " + inputString);
            String outputString = transformString(inputString.toString());
            System.out.println("Output: " + outputString);
            inputString = new StringBuffer(input.next());
        }
    }

    public static void makeTests() {
        System.out.println("There are some test examples:");

        String testString1 = "3[xyz]4[xy]z";
        System.out.println("Input: " + testString1);
        String outputString1 = transformString(testString1);
        System.out.println("Output: " + outputString1);

        String testString2 = "2[3[x]y]";
        System.out.println("Input: " + testString2);
        String outputString2 = transformString(testString2);
        System.out.println("Output: " + outputString2);

        String testString3 = "2[c]3[z3[x]2[y4[w]]]";
        System.out.println("Input: " + testString3);
        String outputString3 = transformString(testString3);
        System.out.println("Output: " + outputString3);
    }

    public static String transformString(String str) {
        StringBuilder transformString = new StringBuilder(str);
        Pattern pattern = Pattern.compile("\\d+\\[[a-zA-Z]+]");
        Pattern patternDigit = Pattern.compile("\\d+");
        Pattern patternStringExpr = Pattern.compile("[a-zA-Z]+");

        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            String foundString = matcher.group();
            StringBuilder newReplaceString = new StringBuilder();

            Matcher matcherDigit = patternDigit.matcher(foundString);
            Matcher matcherStringExpr = patternStringExpr.matcher(foundString);
            if (matcherDigit.find() && matcherStringExpr.find()) {
                int repeatNumber = Integer.parseInt(foundString.substring(matcherDigit.start(), matcherDigit.end()));
                String foundStringExpression = foundString.substring(matcherStringExpr.start(), matcherStringExpr.end());
                for (int i = 0; i < repeatNumber; i++) {
                    newReplaceString.append(foundStringExpression);
                }
                transformString.replace(matcher.start(), matcher.end(), newReplaceString.toString());
                matcher = pattern.matcher(transformString.toString());
            }
        }

        return transformString.toString();
    }
}