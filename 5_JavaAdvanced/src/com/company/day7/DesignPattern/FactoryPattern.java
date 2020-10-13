package com.company.day7.DesignPattern;

// 2. 팩토리 메소드 패턴 : 구상 클래스 객체(추상 클래스를 구현한 것)를 전담하여 생성하는 클래스를 구현하는 패턴
// 기능을 사용하는 클래스의 독립성을 강화할 수 있다. -> 의존성을 줄인다.
interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
// 팩토리클래스가 다른 클래스에서 가지게 될 의존성을 모두 가져옴
class ShapeFactory{
    Shape getShape(String shapeType){
        Shape shape = null;
        if(shapeType.equals("Circle")){
            shape = new Circle();
        }else if(shapeType.equals("Rectangle")){
            shape = new Rectangle();
        }else if(shapeType.equals("Square")){
            shape = new Square();
        }else{
            shape = null;
        }
        return shape;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        String shapeType = "Circle";
        Shape shape;
        // 이런 방식으로 객체를 매번 생성하면 새로운 구상 클래스가 만들어졌을 때 코드 수정이 불가피해진다.
        // 그리고 클래스가 구상클래스에 의존하게 된다. -> 코드의 독립성이 저하된다. -> 이를 개선하기 위한 것이 팩토리 패턴
        // 클래스는 추상클래스 or 인터페이스에 의존하는 것이 더 바람직하다.
        if(shapeType.equals("Circle")){
            shape = new Circle();
        }else if(shapeType.equals("Rectangle")){
            shape = new Rectangle();
        }else if(shapeType.equals("Square")){
            shape = new Square();
        }else{
            shape = null;
        }

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("Circle");

        // 직접 조상 클래스를 사용하지않아도 된다.
        Shape roundedShape = FactoryProducer.getFactory(true).getShape("Rectangle");
        roundedShape.draw();
    }
}

// 추상 팩토리 패턴
// 구상클래스를 팩토리 메소드로 의존성을 빼주었듯이, 팩토리 메소드를 추상클래스에 의존하게 만드는 것
abstract class AbstractFactory{
    abstract Shape getShape(String shapeType);
}

class RoundedShapeFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if(shapeType.equals("Circle")){
            shape = new Circle();
        }else if(shapeType.equals("Rectangle")){
            shape = new RoundedRectangle();
        }else if(shapeType.equals("Square")){
            shape = new RoundedSquare();
        }else{
            shape = null;
        }
        return shape;
    }
}

class NormalShapeFactory extends AbstractFactory{
    @Override
    Shape getShape(String shapeType) {
        Shape shape = null;
        if(shapeType.equals("Circle")){
            shape = new Circle();
        }else if(shapeType.equals("Rectangle")){
            shape = new Rectangle();
        }else if(shapeType.equals("Square")){
            shape = new Square();
        }else{
            shape = null;
        }
        return shape;
    }
}
class RoundedRectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("RoundedRectangle");
    }
}

class RoundedSquare implements Shape{
    @Override
    public void draw() {
        System.out.println("RoundedSquare");
    }
}
class FactoryProducer{
    public static AbstractFactory getFactory(boolean rounded){
        if(rounded)
            return new RoundedShapeFactory();
        else
            return new NormalShapeFactory();
    }
}