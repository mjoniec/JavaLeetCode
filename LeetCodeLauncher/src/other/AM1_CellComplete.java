package other;

import java.util.Arrays;

//game of life
public class AM1_CellComplete {
    public int[] cellComplete(int[]states, int days){
        int[] tab = new int[states.length];

        while(days-->=0){
            for(int i = 0; i<states.length; i++) {
                if(i == 0) tab[i] = isAlive(0, states[i+1]);
                else if(i == states.length-1) tab[i] = isAlive(states[i-1], 0);
                else tab[i] = isAlive(states[i-1], states[i+1]);
            }
            for(int i = 0; i<states.length; i++) states[i] = tab[i];
        }

        return tab;
    }

    private int isAlive(int a, int b){
        if(a == 1 && b == 0) return 1;
        if(a == 0 && b == 1) return 1;
        return 0;
    }

    public void run() {
        System.out.println("AM1_CellComplete: ");
        System.out.println("Expected: 0101 0101  Actual:" + Arrays.toString(cellComplete(new int[]{0,0,0,1,0,1,0,0}, 1)));
        //0001 0100 - day 0
        //0010 0010 - after day 1
        //0101 0101 - after day 2
    }
}
