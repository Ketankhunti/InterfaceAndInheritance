import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

class RectanglePlus implements Relatable {
    public int width = 0;
    public int height = 0;
   // public Point origin;

    public void setHeightWidth(int height,int width){
        this.width = width;
        this.height = height;
    }

    // four constructors
//    public RectanglePlus() {
//        origin = new Point(0, 0);
//    }
//    public RectanglePlus(Point p) {
//        origin = p;
//    }
//    public RectanglePlus(int w, int h) {
//        origin = new Point(0, 0);
//        width = w;
//        height = h;
//    }
//    public RectanglePlus(Point p, int w, int h) {
//        origin = p;
//        width = w;
//        height = h;
//    }
//
//    // a method for moving the rectangle
//    public void move(int x, int y) {
//        origin.x = x;
//        origin.y = y;
//    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    // a method required to implement
    // the Relatable interface
    public int isLargerThan(Relatable other) {
        RectanglePlus otherRect = (RectanglePlus)other;
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }

    public static Object findLargest(Object obj1, Object obj2) {
         Relatable readable1 = (RectanglePlus) obj1;
         Relatable readable2 = (RectanglePlus) obj2;
         if (readable1.isLargerThan(readable2) > 0){
             return obj1;
         }else{
             return obj2;
         }
    }
    public static Object findSmallest(Object obj1, Object obj2) {
        Relatable readable1 = (RectanglePlus) obj1;
        Relatable readable2 = (RectanglePlus) obj2;
        if (readable1.isLargerThan(readable2) < 0){
            return obj1;
        }else{
            return obj2;
        }
    }
    public static Boolean isEqual(Object obj1, Object obj2) {
        Relatable readable1 = (RectanglePlus) obj1;
        Relatable readable2 = (RectanglePlus) obj2;
        if (readable1.isLargerThan(readable2) == 0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public static void main(String[] args) {
        RectanglePlus rectangle = new RectanglePlus();
        RectanglePlus rectangle2 = new RectanglePlus();
        String[] s1 = {"ketan"};

        rectangle.setHeightWidth(10,11);
        rectangle2.setHeightWidth(10,10);

        System.out.println(rectangle.isLargerThan(rectangle2));

        System.out.println(findLargest(rectangle,rectangle2).getClass());
    }



}

interface Relatable {

    // this (object calling isLargerThan)
    // and other must be instances of
    // the same class returns 1, 0, -1
    // if this is greater than,
    // equal to, or less than other
    int isLargerThan(Relatable other);

    default boolean isEverythingOk(boolean b){
        return b;
    }
}