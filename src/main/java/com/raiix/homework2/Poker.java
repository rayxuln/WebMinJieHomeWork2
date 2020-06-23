package com.raiix.homework2;

import java.util.HashSet;
import java.util.Set;

public class Poker {
    int[] numberMap;
    String[] data;

    public Poker(String[] ps){
        data = ps;
        numberMap = new int[256];
        numberMap['2'] = 1;
        numberMap['3'] = 2;
        numberMap['4'] = 3;
        numberMap['5'] = 4;
        numberMap['6'] = 5;
        numberMap['7'] = 6;
        numberMap['8'] = 7;
        numberMap['9'] = 8;
        numberMap['T'] = 9;
        numberMap['J'] = 10;
        numberMap['Q'] = 11;
        numberMap['K'] = 12;
        numberMap['A'] = 13;
    }

    int getNumber(String p){
        return numberMap[p.charAt(0)];
    }

    char getColor(String p){
        return p.charAt(1);
    }

    boolean isSameNumber(String p1, String p2){
        return getNumber(p1) == getNumber(p2);
    }

    boolean isInGreaterOrder(String p1, String p2){
        return getNumber(p1) - getNumber(p2) == -1;
    }
    boolean isInLesserOrder(String p1, String p2){
        return getNumber(p1) - getNumber(p2) == 1;
    }

    public boolean isSameType(){
        char color = getColor(data[0]);
        for (int i=1;i<data.length;++i){
            if(color != getColor(data[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isOrderType(){
        boolean isGreater = true;
        boolean isLesser = true;
        for (int i=0;i<data.length-1;++i){
            if(!isInGreaterOrder(data[i], data[i+1])) isGreater = false;
            if(!isInLesserOrder(data[i], data[i+1])) isLesser = false;
        }
        return isGreater || isLesser;
    }

    public boolean isTripleType(){
        for(int i=0;i<data.length;++i){
            for(int j=0;j<data.length;++j){
                for(int k=0;k<data.length;++k){
                    if(i==j || j==k || i==k) continue;
                    if(isSameNumber(data[i], data[j]) && isSameNumber(data[j], data[k]) && isSameNumber(data[i], data[k])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int countCoupleNum(){
        HashSet<String> used = new HashSet<>();
        int coupleCnt = 0;
        for(int i=0;i<data.length;++i){
            for(int j=0;j<data.length;++j){
                if(i == j) continue;
                if(used.contains(data[i]) || used.contains(data[j])) continue;
                if(isSameNumber(data[i], data[j]))
                {
                    used.add(data[i]);
                    used.add(data[j]);
                    coupleCnt += 1;
                }
            }
        }
        return coupleCnt;
    }

    public boolean isCouple(){
        return countCoupleNum() == 1;
    }
    public boolean isDoubleCouple(){
        return countCoupleNum() == 2;
    }
    public boolean isChaos(){
        return !(isSameType() || isOrderType() || isTripleType() || isCouple() || isDoubleCouple());
    }

    public boolean isSameOrderType(){
        return isSameType() && isOrderType();
    }

    public String typeString(){
        if(isSameType()) return "same";
        if(isOrderType()) return "order";
        if(isTripleType()) return "triple";

        int coupleNum = countCoupleNum();
        if(coupleNum == 1) return "couple";
        if(coupleNum == 2) return "double couple";
        return "chaos";
    }
}
