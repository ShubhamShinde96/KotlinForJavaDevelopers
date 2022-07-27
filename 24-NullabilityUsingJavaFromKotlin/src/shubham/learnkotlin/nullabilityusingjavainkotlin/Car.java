package shubham.learnkotlin.nullabilityusingjavainkotlin;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;

public class Car {

    public static int x = 5;

    private String color;
    private String model;
    private int year;

    private Object anObject;


    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString(){

        return "This is x: " + x++;
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }

    public String getColor() {
        return color;
    }

    public void setColor(@NotNull String color) { //@Nullable
        this.color = color;
    }

    public @Nullable String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void variableMethod(int num, String... strings) {

        for(String string: strings) {
            System.out.println(string);
        }
    }

    public void wantsIntArray(int[] array) {

        for(int i = 0; i < array.length; i++) {
            System.out.println("Here is the int: " + i);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
