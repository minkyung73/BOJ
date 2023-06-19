import java.util.Scanner;

public class boj_28235 {
    public static void main(String[] args){
//        코드마스터 2023
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input){
            case "SONGDO":
                System.out.println("HIGHSCHOOL");
                break;
            case "CODE":
                System.out.println("MASTER");
                break;
            case "2023":
                System.out.println("0611");
                break;
            case "ALGORITHM":
                System.out.println("CONTEST");
                break;
        }
    }
}
