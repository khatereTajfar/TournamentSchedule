package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Khatere Tajfar on 3/5/2017.
 */
public class Schedule {
    final int MAXROW = 64, MAXCOL = 64;
    int array[][]; //reference variable
    boolean isPowerOfTwo;
    int m;


    Schedule() {
        array = new int[MAXROW][MAXCOL];
        isPowerOfTwo = false;
        m = -1;
    }

    void schedule(int n) {
        if (n > 0) {
            schedule(n / 2);
            if (n == 1)
                array[0][0] = 1;
            else {
                for (int row = 0; row < n / 2; row++)
                    for (int column = 0; column < n / 2; column++) {
                        array[row][column + (n / 2)] = array[row][column] + (n / 2);
                        array[row + (n / 2)][column] = array[row][column] + (n / 2);
                        array[row + (n / 2)][column + (n / 2)] = array[row][column];
                    }
            }
        }
    }


    void printArray(int n) {

        System.out.println("<<TOURNAMENT SCHEDULE>>");
        System.out.printf("Days: ");
        for (int i = 1; i < n; i++)
            System.out.printf("%4d", i);
        System.out.println("\n\t\t--------------------------------------------------");
        if (isPowerOfTwo) {
            for (int i = 0; i < n; i++) {
                System.out.printf("\nTeam:" + (i + 1));
                for (int j = 1; j < n; j++)
                    System.out.printf("%4d", array[i][j]);
            }
        } else {
            int x = n;
            n = m;
            for (int i = 0; i < n; i++) {
                System.out.printf("\nTeam:" + (i + 1));
                for (int j = 1; j < x; j++) {
                    if (array[i][j] > m)
                        array[i][j] = 0;
                    System.out.printf("%4d", array[i][j]);

                }
            }
        }
    }
}

