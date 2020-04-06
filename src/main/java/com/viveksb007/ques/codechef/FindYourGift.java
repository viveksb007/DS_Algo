package com.viveksb007.ques.codechef;

import java.io.PrintWriter;

public class FindYourGift {

    public static void main(String[] args) {
        FindYourGift findYourGift = new FindYourGift();
        findYourGift.solve();
    }

    private void solve() {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        PrintWriter pw = new PrintWriter(System.out);
        while (t-- > 0) {
            int n = reader.nextInt();
            String str = reader.nextLine();
            char prev = '1';
            int x = 0, y = 0;
            for (char c : str.toCharArray()) {
                switch (c) {
                    case 'L':
                        if (prev == 'L' || prev == 'R')
                            continue;
                        x--;
                        break;
                    case 'R':
                        if (prev == 'L' || prev == 'R')
                            continue;
                        x++;
                        break;
                    case 'U':
                        if (prev == 'U' || prev == 'D')
                            continue;
                        y++;
                        break;
                    case 'D':
                        if (prev == 'U' || prev == 'D')
                            continue;
                        y--;
                }
                prev = c;
            }
            pw.println(x + " " + y);
        }
        pw.close();
    }

}
