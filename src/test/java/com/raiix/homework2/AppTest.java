package com.raiix.homework2;

import static org.junit.Assert.*;
import org.junit.*;

public class AppTest {
    @Test
    public void givenSanPiAndPrintSanPi(){
        Poker p = new Poker(new String[]{"2H", "3D", "5S", "9C", "KD"});
        assertEquals("chaos", p.typeString());
    }
}
