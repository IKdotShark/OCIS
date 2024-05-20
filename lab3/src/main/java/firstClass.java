import static java.lang.Math.*;

public class firstClass {
    public static boolean FirstFigure(double x, double y) {
        if (4 >= pow(x+1,2) + pow(y-1,2) && x <= -1) {
            return true;
        }
        return false;
    }
    public static boolean SecondFigure(double x, double y) {
        if (y <= -3/2 * x  + 3.5 && y >= -2 * x  -1  &&
                x >= -1 && y >= 3*x -1) {
            return true;
        }
        return false;
    }
    public static boolean ThirdFigure(double x, double y) {
        if (y >= abs(x-3) & y <= 1)  {
            return true;
        }
        return false;
    }
    public static boolean FourFigure(double x, double y) {
        if (4 >= pow(x-4,2) + pow(y+1,2) && y <= x-3 && y >= x -7){
            return true;
        }
        return false;
    }
    public static int All_Square(double x, double y) {
        if (FirstFigure(x,y) || SecondFigure(x,y)) {
            System.out.println("Попадание в левую фигуру");
            return 1;
        } else if(ThirdFigure(x,y) || FourFigure(x,y)){
            System.out.println("Попадание в правую фигуру");
            return 2;
        } else {
            System.out.println("Не попала");
            return 0;
        }
    }
}