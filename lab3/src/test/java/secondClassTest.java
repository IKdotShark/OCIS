import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class secondClassTest {

    @Test(groups = "print")
    public void testPntIntMas() {
        // Сохраните оригинальный PrintStream
        PrintStream originalOut = System.out;
        // Создайте новый поток вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // Вызовите метод, который печатает в консоль
        int[] mas = {4, 2, 7, 1, 5};
        secondClass.PrintingIntegerArray(mas);
        // Восстановите оригинальный PrintStream
        System.setOut(originalOut);
        String out = outContent.toString().replaceAll("\\s","");
        // Проверьте вывод
        String StMas = "";
        for (int i = 0; i < mas.length; i++) StMas += mas[i];
        Assert.assertEquals(out, StMas);
    }

    @Test(groups = "randomInt")
    public void testRandIntMas() {
        int len = 10;
        int min = 1;
        int max = 100;
        int[] RandIntMas = secondClass.RandomIntegerArray(len, min, max);
        // Проврека длинны массива
        Assert.assertEquals(RandIntMas.length, len);
        // Проверка вхождения в диапазон
        for (int i = 0; i < RandIntMas.length; i++) {
            Assert.assertTrue(RandIntMas[i] <= max && RandIntMas[i] >= min);
        }
    }

    @Test(groups = "randomInt")
    public void testRandIntMas_x2() {
        int len1 = 2;
        int len2 = 10;
        int min = 1;
        int max = 100;
        int[][] RandIntMas_x2 = secondClass.RandomIntegerArrayExtended(len1, len2, min, max);
        // Проврека длинны массива
        Assert.assertEquals(RandIntMas_x2.length, len1);
        Assert.assertEquals(RandIntMas_x2[1].length, len2);
        // Проверка вхождения в диапазон
        for (int i = 0; i < RandIntMas_x2.length; i++) {
            for (int j = 0; j < RandIntMas_x2[1].length; j++) {
                Assert.assertTrue(RandIntMas_x2[i][j] <= max && RandIntMas_x2[i][j] >= min);
            }
        }
    }

    @Test(groups = "sort")
    public void testIntSheker() {
        int[] testArray = {4, 2, 7, 1, 5}; // Тестовый массив
        int[] sortedArray = secondClass.IntegerSortingShaker(testArray); // Вызов метода сортировки
        // Проверка, что массив отсортирован
        for (int i = 0; i < sortedArray.length - 1; i++) {
            Assert.assertTrue(sortedArray[i] <= sortedArray[i + 1]);
        }
    }

    @Test(groups = "sort")
    public void testIntBubble() {
        int[] testArray = {4, 2, 7, 1, 5}; // Тестовый массив
        int[] sortedArray = secondClass.IntegerSortingBubble(testArray); // Вызов метода сортировки
        // Проверка, что массив отсортирован
        for (int i = 0; i < sortedArray.length - 1; i++) {
            Assert.assertTrue(sortedArray[i] >= sortedArray[i + 1]);
        }
    }
}