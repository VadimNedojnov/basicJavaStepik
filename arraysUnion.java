import java.util.Arrays;
import java.util.Random;


public class arraysUnion {
    /**
     * Program entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int[] a1 = {6};
        int[] a2 = {1,3,5};
        int[] generalList = new int[a1.length + a2.length];
        if (a1.length > 0 && a2.length > 0) {
            int list_1_i = 0;
            int list_2_i = 0;
            outer:
            for (int generalList_i = 0; generalList_i < generalList.length; generalList_i++) {
                if (list_1_i < a1.length && a1[list_1_i] <= a2[list_2_i]) {
                    generalList[generalList_i] = a1[list_1_i];
                    list_1_i++;
                } else {
                    if (list_2_i < a2.length) {
                        generalList[generalList_i] = a2[list_2_i];
                        list_2_i++;
                    }
                    if (list_2_i == a2.length) {
                        System.arraycopy(a1, list_1_i, generalList, generalList_i + 1, (generalList.length - generalList_i - 1));
                        break outer;
                    }
                }
            }
            System.out.println(Arrays.toString(generalList));
        } else {
            System.out.println(a1.length > 0 ? Arrays.toString(a1) : Arrays.toString(a2));
        }
    }
}
