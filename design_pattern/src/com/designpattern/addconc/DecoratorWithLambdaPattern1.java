package com.designpattern.addconc;



import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorWithLambdaPattern1 {

    public static void print(Camera camera) {
	System.out.println(camera.snap(new Color(125,125,125)));
    }
    public static void main(String[] args) {
	
	print(new Camera());
	print(new Camera(Color::brighter));
	//print(new Camera(Color::brighter,Color::darker));
    }
}

class Camera{
    private Function<Color, Color> filter;
    
    public Camera(Function<Color, Color>...filters) {
	//filter = input->input;
	filter = Stream.of(filters)
		 .reduce(Function.identity(), Function::andThen);
    }
    
    public Color snap(Color color) {
	return filter.apply(color);
    }
    
}

class Color{
    private int r=12;
    private int g=12;
    private int b=12;
    
   public Color(){}
   
   public Color(int r, int g, int b) {
     this.r = r;
     this.g = g;
     this.b = b;
   }
   
    public Color  brighter() {
	return new Color(130, 130, 130);
	
    }
    
    public Color  darker() {
   	return new Color(150, 150, 150);
   	
       }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getG() {
        return g;
    }
    public void setG(int g) {
        this.g = g;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
	return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
    }
    
    
    
}
