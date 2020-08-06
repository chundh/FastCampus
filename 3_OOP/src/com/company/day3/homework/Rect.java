package com.company.day3.homework;


import java.util.Arrays;

/**
 * 아래 테스트 코드가 정상 동작하도록 클래스들을 완성하시오.
 *
 * getArea(): 사각형의 넓이를 반환한다.
 * getCenterOfMass(): 사각형의 질량중심을 반환한다.
 * GetAllPoints(): 사각형의 네 점을 배열로 반환한다.
 * rot90(): Pivot을 기준으로 사각형을 90도 회전시킨다.
 */

class Vector2D {
    public float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        String ans = "(";
        ans += x + " , " + y + ")";
        return ans;
    }
}

class RectCore {
    protected Vector2D pos;
    protected float w, h;
    public RectCore(float x, float y, float w, float h) {
        this.pos = new Vector2D(x, y);
        this.w = w;
        this.h = h;
    }

    public String toString() {
        // write codes here
        return "RECTCORE";
    }
}

public class Rect extends RectCore {
    public Rect(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public float getArea() {
        return this.w * this.h;
    }

    public Vector2D getCenterOfMass() {
        return new Vector2D(super.pos.x, super.pos.y);
    }

    public Vector2D [] getAllPoints() {
        float x = super.pos.x;
        float y = super.pos.y;
        Vector2D a = new Vector2D(x-(w/2), y-(h/2));
        Vector2D b = new Vector2D(x-(w/2), y+(h/2));
        Vector2D c = new Vector2D(x+(w/2), y-(h/2));
        Vector2D d = new Vector2D(x+(w/2), y+(h/2));
        Vector2D[] arr = new Vector2D[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        return arr;
    }

    public void rot90(Vector2D pivot) {
        float x = super.pos.x;
        float y = super.pos.y;
        x-=pivot.x;
        y-=pivot.y;
        super.pos.x = -y+pivot.x;
        super.pos.y = x+pivot.y;

        float temp = w;
        w = h;
        h = temp;
        return;
    }
    public String toString() {
        String ans = "[";
        Vector2D[] arr = this.getAllPoints();
        for(int i=0; i<arr.length; i++){
            Vector2D temp = arr[i];
            ans += "(" + temp.x + " , " + temp.y + ") , ";
        }
        ans = ans.substring(0, ans.length()-3);
        ans += "]";
        return ans;
    }
}
class RectTest {
    public static void main(String[] args) {
        Rect rect = new Rect(0.5f, 0.7f, 1.5f, 2.3f);
        System.out.println("Area: " + rect.getArea());
        System.out.println("CoM: " + rect.getCenterOfMass());
        System.out.println("All Points: " + Arrays.toString(rect.getAllPoints()));

        rect.rot90(new Vector2D(0.4f, 0.2f));
        System.out.println("Rotated rect: " + rect);
        System.out.println("CoM: " + rect.getCenterOfMass());
    }
}