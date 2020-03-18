/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anni
 */
public class MaksukorttiTest {
    Maksukortti kortti;
    
    public MaksukorttiTest() {
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    @Before
    public void setUp() throws Exception {
        kortti = new Maksukortti(10);
    }
    @After
    public void tearDown() throws Exception {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        String vastaus = kortti.toString();
        
        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
    }
    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }
    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }
    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();
        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
    @Test
    public void negatiivisenSummanLataaminenEiMuutaKortinSaldoa() {
        kortti.lataaRahaa(-10);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    @Test
    public void edullisenLounaanOstaminenOnnistuuTasarahalla() {
        Maksukortti kortti2 = new Maksukortti(2.5);
        kortti2.syoEdullisesti();
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti2.toString());
    }
    @Test
    public void maukkaanLounaanOstaminenOnnistuuTasarahalla() {
        Maksukortti kortti3 = new Maksukortti(4.0);
        kortti3.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti3.toString());
    }
}
