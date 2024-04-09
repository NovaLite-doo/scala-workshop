package examples.part2expressions;

public class MainJava {
    public static void main(String[] args) {
        int x = 1 + 2;
        boolean isEven = x % 2 == 0;
        boolean isOdd = !isEven;

        boolean condition = true;

        int conditionedResult = condition ? 42 : 0;

        int doNotWrite = condition ? 42 : 0; // variables can't be void

        int codeBlock;
        {
            // boolean condition = true; => ERROR: Variable already defined in the scope
            boolean innerCondition = true;
            codeBlock = innerCondition ? 42 : 0;
        }

        // println returns void
        System.out.println(1);
    }
}
