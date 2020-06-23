package com.raiix.homework2;

import java.util.*;

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

    public ArrayList<String> getSortedData(){
        ArrayList<String> res = new ArrayList<String>(Arrays.asList(data.clone()));
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.compare(getNumber(s), getNumber(t1));
            }
        });
        return res;
    }

    public int getNumber(String p){
        return numberMap[p.charAt(0)];
    }

    public char getColor(String p){
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
        ArrayList<String> sortedData = getSortedData();
        for (int i=0;i<sortedData.size()-1;++i){
            if(!isInGreaterOrder(sortedData.get(i), sortedData.get(i + 1))) isGreater = false;
            if(!isInLesserOrder(sortedData.get(i), sortedData.get(i + 1))) isLesser = false;
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
        HashSet<Integer> used = new HashSet<>();
        int coupleCnt = 0;
        for(int i=0;i<data.length;++i){
            for(int j=0;j<data.length;++j){
                if(i == j) continue;
                if(used.contains(i) || used.contains(j)) continue;
                if(isSameNumber(data[i], data[j]))
                {
                    used.add(i);
                    used.add(j);
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

    public int getTypeLevel(){
        if (isSameOrderType()) return 6;
        if (isSameType()) return 5;
        if (isOrderType()) return 4;
        if (isTripleType()) return 3;
        if (isDoubleCouple()) return 2;
        if (isCouple()) return 1;
        return 0;
    }

    public ArrayList<Integer> getCoupleNumber(){
        ArrayList<String> sortedData = getSortedData();
        ArrayList<Integer> res = new ArrayList<>();

        HashSet<Integer> used = new HashSet<>();
        for(int i=0;i<data.length;++i){
            for(int j=0;j<data.length;++j){
                if(i == j) continue;
                if(used.contains(i) || used.contains(j)) continue;
                if(isSameNumber(data[i], data[j]))
                {
                    used.add(i);
                    used.add(j);
                    res.add(getNumber(data[i]));
                }
            }
        }

        return res;
    }

    public int getTripleNumber(){
        for(int i=0;i<data.length;++i){
            for(int j=0;j<data.length;++j){
                for(int k=0;k<data.length;++k){
                    if(i==j || j==k || i==k) continue;
                    if(isSameNumber(data[i], data[j]) && isSameNumber(data[j], data[k]) && isSameNumber(data[i], data[k])){
                        return getNumber(data[i]);
                    }
                }
            }
        }
        return -1;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<data.length;++i){
            sb.append(data[i]);
            if(i < data.length-1)
                sb.append(' ');
        }
        return sb.toString();
    }
}
