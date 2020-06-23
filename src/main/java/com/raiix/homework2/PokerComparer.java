package com.raiix.homework2;

import java.util.ArrayList;
import java.util.Comparator;

public class PokerComparer {
    final String BLACK_WINS = "Black wins";
    final String WHITE_WINS = "White wins";
    final String TIE = "Tie";

    Poker black;
    Poker white;

    public PokerComparer(Poker black, Poker white){
        this.black = black;
        this.white = white;
    }

    public String compareAsSanPai(){
        ArrayList<String> blackData = black.getSortedData();
        ArrayList<String> whiteData = white.getSortedData();
        for(int i=blackData.size()-1;i>=0;--i){
            if(black.getNumber(blackData.get(i)) > white.getNumber(whiteData.get(i)))
                return BLACK_WINS;
            if(black.getNumber(blackData.get(i)) < white.getNumber(whiteData.get(i)))
                return WHITE_WINS;
        }
        return TIE;
    }

    public String compareAsCouple(){
        int blackCoupleNumber = black.getCoupleNumber().get(0);
        int whiteCoupleNumber = white.getCoupleNumber().get(0);
        if(blackCoupleNumber > whiteCoupleNumber) return BLACK_WINS;
        if(blackCoupleNumber < whiteCoupleNumber) return WHITE_WINS;
        return compareAsSanPai();
    }

    public String compareAsDoubleCouple(){
        ArrayList<Integer> blackCoupleNumbers = black.getCoupleNumber();
        ArrayList<Integer> whiteCoupleNumbers = white.getCoupleNumber();
        blackCoupleNumbers.sort(Comparator.naturalOrder());
        whiteCoupleNumbers.sort(Comparator.naturalOrder());
        for(int i=blackCoupleNumbers.size()-1;i>=0;--i){
            if(blackCoupleNumbers.get(i) > whiteCoupleNumbers.get(i)) return BLACK_WINS;
            if(blackCoupleNumbers.get(i) < whiteCoupleNumbers.get(i)) return WHITE_WINS;
        }
        return compareAsSanPai();
    }

    public String compareAsTriple(){
        int blackTripleNumber = black.getTripleNumber();
        int whiteTripleNumber = white.getTripleNumber();
        if(blackTripleNumber > whiteTripleNumber) return BLACK_WINS;
        if(blackTripleNumber < whiteTripleNumber) return WHITE_WINS;
        return compareAsSanPai();
    }

    public String whoWins(){
        int blackType = black.getTypeLevel();
        int whiteType = white.getTypeLevel();
        if(blackType > whiteType) return BLACK_WINS;
        if(blackType < whiteType) return WHITE_WINS;

        switch (blackType){
            case 0:
            case 4:
            case 5:
            case 6:
                return compareAsSanPai();
            case 1:
                return compareAsCouple();
            case 2:
                return compareAsDoubleCouple();
            case 3:
                return compareAsTriple();
        }
        return TIE;
    }
}
