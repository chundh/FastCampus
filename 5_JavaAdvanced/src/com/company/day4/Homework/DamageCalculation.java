package com.company.day4.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 *
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 *   1-1. BARE_HANDS - 공격력 5
 *   1-2. DAGGER - 공격력 40
 *   1-3. LONG_SWORD - 공격력 100
 *   1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 *   2-1. BLACK_POTION - 공격력 10% 증가
 *   2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 *   2-3. MUSHROOM - 무기 공격력 + 20
 *
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);
    // 무기 구현
    double attack=0;

    Weapon(int attack) {
        this.attack = attack;
    }
}

enum Item {
    BLACK_POTION("%", 10), WHITE_POTION("+", 200), MUSHROOM("+", 20);
    // 소비 아이템 구현
    String pos;
    int num;

    Item(String pos, int num) {
        this.pos = pos;
        this.num = num;
    }
}

class Player {
    Weapon currentWeapon;
    List<Item> items;
    UnaryOperator<Double> setAttack = s->s;
    // TODO: Player에 필요한 메소드 구현
    // 무기 교체, 아이템 사용, 아이템 효과 종료 메소드 구현
    void changeWeapon(Weapon weapon){
        this.currentWeapon = weapon;
        System.out.println("change Weapon : " + weapon);
        double ans = setAttack.apply(this.currentWeapon.attack);
        System.out.println("현재 공격력 : " + ans);
        this.items.sort((o1, o2) -> o1.name().charAt(1) < o2.name().charAt(1) ? 1 : -1);
        for(Item i : this.items){
            System.out.print("적용 물약 : " + i.name() + " -> Attack : ");
            if(i.pos.equals("%")){
                ans += ans*((double)i.num/100);
            }else{
                ans += i.num;
            }
            System.out.println(ans);
        }
        this.currentWeapon.attack = ans;
    }

    void useItem(Item item){
        this.items.add(item);
        double ans = this.currentWeapon.attack;
        System.out.print("적용 물약 : " + item.name() + " -> Attack : ");
        if(item.pos.equals("%")){
            ans += ans*((double)item.num/100);
        }else{
            ans += item.num;
        }
        System.out.println(ans);
        this.currentWeapon.attack = setAttack.apply(ans);
    }

    void removeItem(Item item){
        this.items.remove(item);
        double ans = setAttack.apply(this.currentWeapon.attack);
        System.out.print("효과 제거 물약 : " + item.name() + " -> Attack : ");
        if(item.pos.equals("%")){
            ans -= ans*((double)item.num/100);
        }else{
            ans -= item.num;
        }
        this.currentWeapon.attack = setAttack.apply(ans);
        System.out.println("현재 공격력 : " + ans);
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        // 무기 및 아이템 장착/사용 시나리오 및 플레이어 공격력 출력
        Player p = new Player();
        p.items = new ArrayList<>();
        UnaryOperator<Weapon> weapon = s -> s;
        UnaryOperator<Item> item = i -> i;
        p.changeWeapon(weapon.apply(Weapon.BARE_HANDS));
        p.useItem(item.apply(Item.BLACK_POTION));
        p.useItem(item.apply(Item.WHITE_POTION));
        p.useItem(item.apply(Item.MUSHROOM));
        p.useItem(item.apply(Item.MUSHROOM));
        p.removeItem(item.apply(Item.MUSHROOM));
        p.changeWeapon(weapon.apply(Weapon.DRAGON_SLAYER));
    }
}