import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private List<Integer> list = new ArrayList<>();

    public void insertNumbers() {
        boolean finishLoop = false;
        do {
            try {
                System.out.println("Insert nonnegative number and divisible by 5");
                int inputNumber = sc.nextInt();

                if (rightNumber(inputNumber))
                    list.add(inputNumber);
                else if (list.isEmpty())
                    System.err.println("Wrong input number, try again");
                else
                    finishLoop = true;

            } catch (NullPointerException | InputMismatchException e) {
                if (list.isEmpty())
                    System.err.println("Wrong input number, try again");
                else
                    finishLoop = true;
            } finally {
                sc.nextLine();
            }
        } while (!finishLoop);
        sc.close();
    }


    private boolean rightNumber(int number) {
        if (number >= 0 && (number % 5 == 0) && (number != 0)) {
            return true;
        }
        return false;
    }

    private int addListNumbers(){
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private int averageListNumber(){
        return addListNumbers() / list.size();
    }

    void printList(){
        int sum = addListNumbers();
        System.out.println("Corrects number amount: " + list.size());
        System.out.println("Summation of correct numbers: " + sum);
        System.out.println("Average correct number: " + averageListNumber());
    }
}
