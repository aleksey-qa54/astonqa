2.Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник:

interface Figure {

    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    default void showInfo() {
        System.out.println("Фигура: " + getFigureName());
        System.out.printf("Периметр: %.2f\n", getPerimeter());
        System.out.printf("Площадь: %.2f\n", getArea());
        System.out.println("Цвет фона: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
        System.out.println("----------------------------------------");
    }

    String getFigureName();
}
 

class Circle implements Figure {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public double getArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFigureName() {
        return "Круг";
    }
}


class Rectangle implements Figure {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFigureName() {
        return "Прямоугольник";
    }
}


class Triangle implements Figure {
    private double base;    
    private double height;  
    private double side1;   
    private double side2;   
    private String fillColor;
    private String borderColor;

    
    public Triangle(double base, double height, double side1, double side2,
                    String fillColor, String borderColor) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getPerimeter() {
        return base + side1 + side2;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public String getFigureName() {
        return "Треугольник";
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("ПРОГРАММА ДЛЯ РАСЧЕТА ФИГУР");
        System.out.println("============================\n");

        Figure circle = new Circle(5, "Красный", "Черный");
        Figure rectangle = new Rectangle(4, 6, "Синий", "Черный");
        Figure triangle = new Triangle(10, 5, 7, 8,"Зеленый", "Черный");

        circle.showInfo();
        rectangle.showInfo();
        triangle.showInfo();
    }
}
