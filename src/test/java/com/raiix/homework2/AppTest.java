package com.raiix.homework2;

import static org.junit.Assert.*;
import org.junit.*;

public class AppTest {
    @Test
    public void givenSanPiAndPrint(){
        Poker p = new Poker(new String[]{"2H", "3D", "5S", "9C", "KD"});
        assertTrue(p.isChaos());
    }

    @Test
    public void givenDuiziAndPrint(){
        Poker p = new Poker(new String[]{"2H", "2D", "5S", "9C", "KD"});
        assertTrue(p.isCouple());
    }

    @Test
    public void givenDuiziAndPrint2(){
        Poker p = new Poker(new String[]{"TH", "TD", "5S", "9C", "KD"});
        assertTrue(p.isCouple());
    }

    @Test
    public void givenLiangDuiAndPrint(){
        Poker p = new Poker(new String[]{"2H", "2D", "5S", "5C", "KD"});
        assertTrue(p.isDoubleCouple());
    }

    @Test
    public void givenLiangDuiAndPrint2(){
        Poker p = new Poker(new String[]{"TH", "TD", "QS", "QC", "KD"});
        assertTrue(p.isDoubleCouple());
    }

    @Test
    public void givenSanTiaoAndPrintNotLiangDui(){
        Poker p = new Poker(new String[]{"2H", "2D", "2S", "5C", "KD"});
        assertFalse(p.isDoubleCouple());
    }

    @Test
    public void givenSanTiaoAndPrint(){
        Poker p = new Poker(new String[]{"2H", "2D", "2S", "2C", "KD"});
        assertTrue(p.isTripleType());
    }

    @Test
    public void givenDaShunZiAndPrint(){
        Poker p = new Poker(new String[]{"2H", "3D", "4S", "5C", "6D"});
        assertTrue(p.isOrderType());
    }

    @Test
    public void givenDaShunZiAndPrint2(){
        Poker p = new Poker(new String[]{"TH", "JD", "QS", "KC", "AD"});
        assertTrue(p.isOrderType());
    }

    @Test
    public void givenXiaoShunZiAndPrint(){
        Poker p = new Poker(new String[]{"6H", "5D", "4S", "3C", "2D"});
        assertTrue(p.isOrderType());
    }

    @Test
    public void givenXiaoShunZiAndPrint2(){
        Poker p = new Poker(new String[]{"7H", "8D", "9S", "TC", "JD"});
        assertTrue(p.isOrderType());
    }

    @Test
    public void givenTongHuaAndPrint(){
        Poker p = new Poker(new String[]{"7H", "3H", "9H", "TH", "JH"});
        assertTrue(p.isSameType());
    }

    @Test
    public void givenTongHuaShunAndPrint(){
        Poker p = new Poker(new String[]{"7H", "8H", "9H", "TH", "JH"});
        assertTrue(p.isSameOrderType());
    }

    @Test
    public void givenTongHuaAndSanPaiAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "5H", "9H", "TH", "JH"});
        Poker white = new Poker(new String[]{"7H", "8S", "9H", "TH", "4H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenSanPaiAndSanPaiAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "5S", "9H", "TH", "JH"});
        Poker white = new Poker(new String[]{"7H", "8S", "9H", "TH", "3H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenSanPaiAndSanPaiAndWhiteWin(){
        Poker black = new Poker(new String[]{"7H", "5S", "9H", "TH", "JH"});
        Poker white = new Poker(new String[]{"7H", "6S", "9H", "TH", "JH"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenSanPaiAndSanPaiAndTie(){
        Poker black = new Poker(new String[]{"7H", "6S", "9H", "TH", "JH"});
        Poker white = new Poker(new String[]{"7H", "6S", "9D", "TH", "JH"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

    @Test
    public void givenDuiZiAndDuiZiAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "7S", "3H", "5H", "JH"});
        Poker white = new Poker(new String[]{"7H", "8S", "5H", "5H", "3H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenDuiZiAndDuiZiAndWhiteWin(){
        Poker black = new Poker(new String[]{"7H", "7S", "3H", "5H", "JH"});
        Poker white = new Poker(new String[]{"7H", "8S", "8H", "TH", "3H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenDuiZiAndDuiZiAndTie(){
        Poker black = new Poker(new String[]{"8H", "8S", "3H", "5H", "JH"});
        Poker white = new Poker(new String[]{"5H", "8S", "8H", "JH", "3H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

    @Test
    public void givenLiangDuiAndLiangDuiAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "5H", "JH"});
        Poker white = new Poker(new String[]{"7H", "7S", "3H", "3H", "2H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenLiangDuiAndLiangDuiAndBlackWin1(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "5H", "JH"});
        Poker white = new Poker(new String[]{"4H", "7S", "5H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenLiangDuiAndLiangDuiAndWhiteWin(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "5H", "JH"});
        Poker white = new Poker(new String[]{"8H", "7S", "3H", "3H", "8H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenLiangDuiAndLiangDuiAndWhiteWin1(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "5H", "2H"});
        Poker white = new Poker(new String[]{"4H", "7S", "5H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenLiangDuiAndLiangDuiAndWhiteTie(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "5H", "JH"});
        Poker white = new Poker(new String[]{"JH", "7S", "5H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

    @Test
    public void givenSanTiaoAndSanTiaoAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "7S", "7H", "5H", "JH"});
        Poker white = new Poker(new String[]{"7H", "7S", "3H", "3H", "3H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenSanTiaoAndSanTiaoAndBlackWin1(){
        Poker black = new Poker(new String[]{"7H", "7S", "7H", "5H", "JH"});
        Poker white = new Poker(new String[]{"4H", "7S", "7H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenSanTiaoAndSanTiaoAndWhiteWin(){
        Poker black = new Poker(new String[]{"7H", "5S", "5H", "5H", "JH"});
        Poker white = new Poker(new String[]{"8H", "8S", "3H", "3H", "8H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenSanTiaoAndSanTiaoAndWhiteWin1(){
        Poker black = new Poker(new String[]{"7H", "7S", "5H", "7H", "2H"});
        Poker white = new Poker(new String[]{"4H", "7S", "7H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void givenSanTiaoAndSanTiaoAndWhiteTie(){
        Poker black = new Poker(new String[]{"7H", "7S", "7H", "5H", "JH"});
        Poker white = new Poker(new String[]{"JH", "7S", "7H", "7H", "5H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

    @Test
    public void givenShunZiAndShunZiAndBlackWin(){
        Poker black = new Poker(new String[]{"7H", "6S", "5H", "4H", "3H"});
        Poker white = new Poker(new String[]{"2H", "3S", "4H", "5H", "6H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void givenShunZiAndShunziAndTie(){
        Poker black = new Poker(new String[]{"7H", "6S", "5H", "4H", "3H"});
        Poker white = new Poker(new String[]{"7H", "6S", "5S", "4H", "3S"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

    @Test
    public void testDataGroup1(){
        Poker black = new Poker(new String[]{"2H", "3D", "5S", "9C", "KD"});
        Poker white = new Poker(new String[]{"2C", "3H", "4S", "8C", "AH"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void testDataGroup2(){
        Poker black = new Poker(new String[]{"2H", "4S", "4C", "2D", "4H"});
        Poker white = new Poker(new String[]{"2S", "8S", "AS", "QS", "3S"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("White wins", pc.whoWins());
    }

    @Test
    public void testDataGroup3(){
        Poker black = new Poker(new String[]{"2H", "3H", "5H", "9H", "KH"});
        Poker white = new Poker(new String[]{"2C", "3H", "4S", "5C", "6H"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Black wins", pc.whoWins());
    }

    @Test
    public void testDataGroup4(){
        Poker black = new Poker(new String[]{"2H", "3D", "5S", "9C", "KD"});
        Poker white = new Poker(new String[]{"2D", "3H", "5C", "9S", "KH"});
        PokerComparer pc = new PokerComparer(black, white);
        assertEquals("Tie", pc.whoWins());
    }

}
