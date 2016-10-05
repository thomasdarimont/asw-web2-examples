package de.asw.java.training2016.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaExpressionEvolutionExampleTest {

    List<Shape> shapes;

    @Before
    public void setUp() {
        shapes = Arrays.asList(new Shape(Color.RED), new Shape(Color.GREEN), new Shape(Color.BLUE));
    }

    @Test
    public void iterateAndChangeColorUpToJava14() {

        LambdaExpressionEvolutionExample.iterateAndChangeColorUpToJava14(shapes, Color.ORANGE);

        assertThat(shapes).allMatch(s -> s.getColor() == Color.ORANGE);
    }

    @Test
    public void iterateAndChangeColorWithJava5() {

        LambdaExpressionEvolutionExample.iterateAndChangeColorUpToJava14(shapes, Color.YELLOW);

        assertThat(shapes).allMatch(s -> s.getColor() == Color.YELLOW);
    }

    @Test
    public void iterateAndChangeColorWithJava8() {

        LambdaExpressionEvolutionExample.iterateAndChangeColorUpToJava14(shapes, Color.WHITE);

        assertThat(shapes).allMatch(s -> s.getColor() == Color.WHITE);
    }

}