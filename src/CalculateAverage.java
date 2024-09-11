import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateAverage {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int n = 0;
        List<Integer> num = new ArrayList<>();
        boolean isValid = true;

        while (isValid){
            System.out.println("enter a number (enter \'q\' to end and get the average): ");
            String ans = myScan.nextLine();
            if (ans.equals("q")) break;
            num.add(Integer.parseInt(ans));
            }

        double average = num.stream().mapToInt((e) -> e).sum();
        System.out.println("average is " + average/num.size()*1.0);


        }
        }



