/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
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
public class KassapaateTest {
    Kassapaate paate;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void alustusToimii() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty() + paate.edullisiaLounaitaMyyty());
    }
    @Test
    public void kateisostoToimiiTasarahalla() {
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());
        paate.syoMaukkaasti(400);
        assertEquals(100640, paate.kassassaRahaa());
    }
    @Test
    public void vaihtoRahatOikein() {
        assertEquals(60, paate.syoEdullisesti(300));
        assertEquals(600, paate.syoMaukkaasti(1000));
    }
    @Test
    public void josMaksuOnOikeinMyytyjenLounaidenMaaraKasvaa() {
        paate.syoEdullisesti(240);
        paate.syoEdullisesti(260);
        paate.syoMaukkaasti(400);
        paate.syoMaukkaasti(700);
        assertEquals(2, paate.edullisiaLounaitaMyyty());
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void josMaksuEiRiitaMyytyjenLounaidenMaaraEiKasva() {
        paate.syoEdullisesti(200);
        paate.syoEdullisesti(50);
        paate.syoMaukkaasti(390);
        paate.syoMaukkaasti(-5);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void josMaksuEiRiitaKassanRahamaaraEiMuutu() {
        paate.syoEdullisesti(200);
        paate.syoEdullisesti(50);
        paate.syoMaukkaasti(390);
        paate.syoMaukkaasti(-5);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Test
    public void josMaksuEiRiitaKaikkiRahatPalautetaanVaihtorahana() {
        assertEquals(200, paate.syoEdullisesti(200));
        assertEquals(50, paate.syoEdullisesti(50));
        assertEquals(390, paate.syoMaukkaasti(390));
        assertEquals(0, paate.syoMaukkaasti(0));
    }
    @Test
    public void korttiOstoToimiiEdullisellaLounaallaJosRahatRiittaa() {
        Maksukortti kortti = new Maksukortti(10000);
        assertEquals(true, paate.syoEdullisesti(kortti));
        Maksukortti kortti2 = new Maksukortti(240);
        assertEquals(true, paate.syoEdullisesti(kortti2));
    }
     @Test
    public void korttiOstoToimiiMaukkaallaLounaallaJosRahatRiittaa() {
        Maksukortti kortti = new Maksukortti(1000);
        assertEquals(true, paate.syoMaukkaasti(kortti));
        Maksukortti kortti2 = new Maksukortti(400);
        assertEquals(true, paate.syoMaukkaasti(kortti2));
    }
    @Test
    public void josKortillaOnTarpeeksiRahaaMyytyjenLounaidenMaaraKasvaa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void josKortillaEiOleTarpeeksiRahaaMyytyjenLounaidenMaaraEiKasva() {
        Maksukortti kortti = new Maksukortti(50);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(0, paate.edullisiaLounaitaMyyty() + paate.maukkaitaLounaitaMyyty());
    }
    @Test
    public void josKortillaEiOleTarpeeksiRahaaKortinRahamaaraEiMuutu() {
        Maksukortti kortti = new Maksukortti(20);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(20, kortti.saldo());
    }
    @Test
    public void josKortillaEiOleTarpeeksiRahaaPalautetaanFalse() {
        Maksukortti kortti = new Maksukortti(20);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false, kortti.otaRahaa(400));
    }
    @Test
    public void kassassaOlevaRahamaaraEiMuutuKortillaOstettaessa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    @Test
    public void kortilleRahaaLadattaessaKortinSaldoMuuttuu() {
        Maksukortti kortti = new Maksukortti(1000);
        kortti.lataaRahaa(1000);
        assertEquals(2000, kortti.saldo());
    }
    @Test
    public void kortilleRahaaLadattaessaKassanRahamaaraKasvaaLadatullaSummalla() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, paate.kassassaRahaa());
    }
    @Test
    public void negatiivinenLataussummaEiMuutaKortinSaldoa() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, -5);
        assertEquals(1000, kortti.saldo());
    }
    @Test
    public void negatiivinenLataussummaEiMuutaKassanRahoja() {
        Maksukortti kortti = new Maksukortti(1000);
        paate.lataaRahaaKortille(kortti, -5);
        assertEquals(100000, paate.kassassaRahaa());
    }
}
