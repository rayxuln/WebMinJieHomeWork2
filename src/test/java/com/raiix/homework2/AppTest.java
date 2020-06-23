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

}
