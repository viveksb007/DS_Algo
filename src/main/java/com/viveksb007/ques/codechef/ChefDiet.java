package com.viveksb007.ques.codechef;

import java.util.Scanner;

public class ChefDiet {

    public static void main(String[] args) {
        ChefDiet chefDiet = new ChefDiet();
        chefDiet.solve();
    }

    private void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfDays = scanner.nextInt();
            int dailyProtein = scanner.nextInt();
            int storedProtein = 0;
            boolean insufficientProtein = false;
            boolean first = true;
            for (int i = 0; i < numberOfDays; i++) {
                int proteinBought = scanner.nextInt();
                storedProtein = proteinBought - dailyProtein + storedProtein;
                if (first && storedProtein < 0) {
                    insufficientProtein = true;
                    first = false;
                    System.out.println("NO " + (i + 1));
                }
            }
            if (!insufficientProtein) {
                System.out.println("YES");
            }
        }
    }

}
