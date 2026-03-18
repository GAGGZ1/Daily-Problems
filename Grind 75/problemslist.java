import java.util.*;
import java.io.*;

public class problemslist {

    public static void main(String[] args) throws Exception {

        HashSet<Integer> set = new HashSet<>();
        File file = new File("numbers.txt");

        // 1️⃣ Read existing numbers from file
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextInt()) {
                set.add(sc.nextInt());
            }
            sc.close();
        }

        Random ran = new Random();
        int count = 0;
        int res[] = new int[3];

        // 2️⃣ Generate new unique numbers
        while (count < 3) {

            int num = ran.nextInt(75) + 1;

            if (!set.contains(num)) {
                res[count] = num;
                set.add(num);
                count++;
            }
        }

        // 3️⃣ Save new numbers to file
        FileWriter fw = new FileWriter(file, true);
        for (int i = 0; i < 3; i++) {
            fw.write(res[i] + "\n");
        }
        fw.close();

        // 4️⃣ Print result
        System.out.println("Generated numbers:");
        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}