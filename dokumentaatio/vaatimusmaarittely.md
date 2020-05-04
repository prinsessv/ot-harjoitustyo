# Vaatimusmäärittely  :gem:

## Sovelluksen tarkoitus
Pankki tarjoaa asiakkailleen sovelluksen, jossa asiakas voi pitää kirjaa tuloistaan ja menoistaan. Asiakkaan täytyy kirjata hänen tulot ja menot sovellukseen. Menot kirjataan eri kategorioihin. Sovelluksesta voi tulostaa erilaisia raportteja, kuten kertyneet menot, montako prosenttia tuloista on käytetty sekä monta prosenttia rahoista on kulunut mihinkin kategoriaan. 

## Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä.

## Käyttöliittymäluonnos :heavy_check_mark:

Sovelluksessa on kolme eri näkymää: kirjautumiselle, uuden käyttäjän luomiselle ja itse sovellukselle.

Kirjautumisnäkymässä käyttäjä voi joko kirjautua sisään kirjoittamalla tunnuksensa ja salasanansa sopiviin kohtiin ja painamalla sen jälkeen nappia LOGIN tai luoda käyttäjätunnuksen painamalla nappia CREATE NEW USER.

Kun käyttäjä päättää luoda käyttäjätunnuksen aukeaa lomakenäkymä. Tässä näkymässä käyttäjä määrittelee nimensä sekä haluamansa käyttäjätunnuksen ja salasanan sopiviin kohtiin. Lopuksi käyttäjä voi painaa nappia CREATE.

Jos käyttäjätunnus ja salasana ovat oikein, näkymä vaihtuu itse sovellukseen.  

Sovelluksen toimintonäppäimiä ovat: 

1. kirjaa meno

2. kirjaa tulo 
	           
3. tulosta raportti 

4. nollaa kuukauden tallennetut tiedot, ja

5. kirjaudu ulos.

## Perusversion tarjoama toiminnallisuus :heavy_check_mark:

### Ennen kirjautumista

- käyttäjä voi luoda tunnuksen, jos hänellä ei vielä ole
  - käyttäjätunnuksen on kuitenkin oltava uniikki ja se ei saa sisältää erikoismerkkejä
  - käyttäjätunnusta luotaessa salasana on myös varmistettava
  - jos käyttäjätunnus ei ole uniikki tai kirjoitetut salasanat eivät ole samat, sovellus ilmoittaa siitä

- käyttäjä voi kirjautua järjestelmään, jos tunnukset ovat oikeat
  - jos tunnukset eivät ole oikeat, sovellus ilmoittaa siitä

### Kirjautumisen jälkeen

- Käyttäjä voi kirjata tuloja ja tulostaa siitä raportin, tulot eivät voi olla negatiivisia eikä 0
  - Jo merkittyihin tuloihin voi lisätä milloin tahansa halutun summan
  - Kirjattava tulo voi sisältää senttejä, jotka voidaan erottaa joko desimaalipilkulla tai pisteellä
  - Raportissa kerrotaan myös kuinka paljon enemmän tai vähemmän käyttäjä on tienannut kuukaudessa kuin keskiverto amerikkalainen

- Käyttäjä voi kirjata menoja ja tulostaa siitä raportin, menot eivät voi olla negatiivisia
  - Kirjattava tulo voi sisältää senttejä, jotka voidaan erottaa joko desimaalipilkulla tai pisteellä
  - Jos menot ylittävät tulot, sovellus varoittaa tästä uusia menoja kirjattaessa sekä menot kertovassa raportissa: sovellus siis tarkastaa riittääkö tulot kirjattaviin menoihin
  - Raportti kertoo myös paljonko rahaa on jäljellä käytettäväksi

- Käyttäjä voi tulostaa raportin siitä, kuinka monta prosenttia hän on käyttänyt palkastaan tähän mennessä
  - Prosentti on pyöristetty lähimpään kokonaislukuun

- Käyttäjä voi tulostaa raportin siitä, kuinka monta prosenttia hän on käyttänyt palkastaan tähän mennessä johonkin tiettyyn kategoriaan
  - Prosentti on pyöristetty lähimpään kokonaislukuun
  - Raportti kertoo paljonko kulutettu prosenttimäärä on dollareina kuukauden tuloista

- Käyttäjä voi tarkastaa mihin kaikkiin kategorioihin hän on käyttänyt rahaa

- Käyttäjä voi kuukauden lopussa tai alussa nollata edellisen kuukauden tiedot

- Käyttäjä voi kirjautua ulos sovelluksesta

## Jatkokehitysideoita

Sovellusta voitaisiin täydentää seuraavilla toiminnoilla

- Tietojen tallennus tapahtuu tietokantaan

- Käyttäjä pystyy määrittelemään säästötavoitteen kuukaudelle 
  - Käyttäjä voi laittaa rahaa säästöön haluamansa määrän
  - Säästöistä kertova raportti ilmoittaa montako prosenttia säästötavoitteesta uupuu

- Käyttäjä voi poistaa merkitsemiään menoja

- Käyttäjä voi tallentaa kuukauden tiedot ylös
  - Kuukausien talletetuista tiedoista saadaan erilaisia raportteja, kuten kuinka paljon rahaa kuluu keskimäärin kuukaudessa

