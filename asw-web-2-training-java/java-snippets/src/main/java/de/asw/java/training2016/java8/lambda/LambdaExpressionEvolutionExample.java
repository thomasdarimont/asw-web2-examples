package de.asw.java.training2016.java8.lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tom on 05.10.16.
 */
public class LambdaExpressionEvolutionExample {

    public static void main(String[] args) {

        List<Shape> shapes = Arrays.asList(new Shape(Color.RED), new Shape(Color.GREEN), new Shape(Color.BLUE));

        iterateAndChangeColorUpToJava14(shapes, Color.YELLOW);
        System.out.println(shapes);

        iterateAndChangeColorWithJava5(shapes, Color.ORANGE);
        System.out.println(shapes);

        iterateAndChangeColorWithJava8(shapes, Color.WHITE);
        System.out.println(shapes);
    }

    // <= Java 1.4: Hier musste man noch manuell über die Liste iterieren.
    static void iterateAndChangeColorUpToJava14(List shapes, Color newColor) {
        for (Iterator itr = shapes.iterator(); itr.hasNext();) {
            Shape s = (Shape)itr.next();
            s.setColor(newColor);
        }
    }

    // >= Java 5: Mit der Advanced For-Loop ging das schon einfacher.
    static void iterateAndChangeColorWithJava5(List<Shape> shapes, Color newColor) {
        for(Shape s : shapes){
            s.setColor(newColor);
        }
    }

    // >= Java 8: Mit Lambda-Expression: Das WAS statt WIE steht im Vordergrund!
    static void iterateAndChangeColorWithJava8(List<Shape> shapes, Color newColor) {
        shapes.forEach(s -> s.setColor(newColor));
    }
}

enum Color {
    RED, GREEN, BLUE, WHITE, YELLOW, ORANGE
}

class Shape {

    Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color=" + color +
                '}';
    }
}
