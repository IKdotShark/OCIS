import java.util.Random;

public class secondClass {
    public static void  PrintingDoubleArray(double mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf(mas[i]+"\t");
        }
        System.out.println();
    }

    public static void PrintingIntegerArray(int mas[]){
        for (int i = 0; i < mas.length; i++) {
            System.out.printf(mas[i]+"\t");
        }
        System.out.println();
    }

    public static int[] RandomIntegerArray(int b, int min, int max) {
        Random rnd = new Random();
        int A[] = new int[b];
        for (int i = 0; i < A.length; i++) {
            A[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return A;
    }
    public static int[][] RandomIntegerArrayExtended(int a,int b, int min, int max) {
        secondClass arr = new secondClass();
        Random rnd = new Random();
        int A[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            A[i] = arr.RandomIntegerArray(b, min, max);
        }
        return A;
    }
    public static int[] IntegerSortingShaker(int a[]) {
        int left = 0, right = a.length - 1;
        int flag = 1;
        int count = 0;
        while ((left < right) && flag > 0) {
            flag = 0;
            for (int i = left; i < right; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    flag = 1;
                    count++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (a[i - 1] > a[i]) {
                    int t = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = t;
                    flag = 1;
                    count++;
                }
            }
            left++;
        }
        return a;
    }
    public static int[] IntegerSortingBubble(int mass[]){
        int count = 0;
        for (int i = 0; i < mass.length; i++){
            for (int j = 0; j < mass.length; j++){
                if (mass[i] >= mass[j]) {
                    int x = mass[i];
                    mass[i] = mass[j];
                    mass[j] = x;
                    count++;
                }
            }
        }
        return mass;
    }
}
