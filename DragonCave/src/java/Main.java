import java.util.Scanner;

public class Main {
    public static int answer = 1;
    public static void main(String[] args) {
        System.out.println("""
                You are in a land full of dragons. In front of you,
                you see two caves. In one cave, the dragon is friendly
                and will share his treasure with you. The other dragon
                is greedy and hungry and will eat you on sight.
                Which cave will you go into? (1 or 2)""");
        Scanner sc = new Scanner(System.in);

        int number = 1;
        try {
            number = sc.nextInt();

            if(number < 1 || number > 2)  {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("""
                    You were indecisive...
                    """);
        }

        System.out.println("""
                    You approach the cave...
                    It is dark and spooky...
                    A large dragon jumps out in front of you! He opens his jaws and...""");

        if(rightCave(number)) {
            System.out.println("""
                    Gobbles you down in one bite!""");
        } else {
            System.out.println("""
                    Shares all of his treasure with you!
                    """);
        }
    }

    public static boolean rightCave(int number) {
        return number == answer;
    }
}
