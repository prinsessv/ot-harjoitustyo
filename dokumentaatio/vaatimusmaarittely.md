# Vaatimusmäärittely  :gem:

## Sovelluksen tarkoitus
Pankki tarjoaa asiakkailleen sovelluksen, jossa asiakas voi pitää kirjaa tuloistaan ja menoistaan. Asiakkaan täytyy kirjata hänen tulot ja menot sovellukseen. Menot kirjataan eri kategorioihin. Sovelluksesta voi tulostaa erilaisia raportteja, kuten kertyneet menot, montako prosenttia tuloista on käytetty sekä monta prosenttia rahoista on kulunut mihinkin kategoriaan. 

## Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä.

## Käyttöliittymäluonnos

:heavy_check_mark: Sovelluksessa on kolme eri näkymää: kirjautumiselle, uuden käyttäjän luomiselle ja itse sovellukselle.

:heavy_check_mark: Kirjautumisnäkymässä käyttäjä voi joko kirjautua sisään kirjoittamalla tunnuksensa ja salasanansa sopiviin kohtiin ja painamalla sen jälkeen nappia LOGIN tai luoda käyttäjätunnuksen painamalla nappia CREATE NEW USER.

:heavy_check_mark: Kun käyttäjä päättää luoda käyttäjätunnuksen, aukeaa lomakenäkymä. Tässä näkymässä käyttäjä määrittelee nimensä sekä haluamansa käyttäjätunnuksen ja salasanan sopiviin kohtiin. Lopuksi käyttäjä voi painaa nappia CREATE.

:heavy_check_mark: Jos käyttäjätunnus ja salasana ovat oikein, näkymä vaihtuu itse sovellukseen.  

:heavy_check_mark: Sovelluksen toimintonäppäimiä ovat: 

:heavy_check_mark: 1. kirjaa meno

:heavy_check_mark: 2. kirjaa tulo 
	           
:heavy_check_mark: 3. tulosta raportti 

:heavy_check_mark: 4. nollaa kuukauden tallennetut tiedot, ja

:heavy_check_mark: 5. kirjaudu ulos.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

:heavy_check_mark: käyttäjä voi luoda tunnuksen, jos hänellä ei vielä ole

:heavy_check_mark: käyttäjätunnuksen on kuitenkin oltava uniikki

:heavy_check_mark: käyttäjä voi kirjautua järjestelmään, jos tunnukset ovat oikeat

### Kirjautumisen jälkeen

:heavy_check_mark: Käyttäjä voi kirjata menoja ja tulostaa siitä raportin, menot eivät voi olla negatiivisia

:heavy_check_mark: Käyttäjä voi kirjata tuloja ja tulostaa siitä raportin, tulot eivät voi olla negatiivisia eikä 0

:heavy_check_mark: Käyttäjä voi tulostaa raportin siitä, kuinka monta prosenttia hän on käyttänyt palkastaan tähän mennessä

:heavy_check_mark: Käyttäjä voi tulostaa raportin siitä, kuinka monta prosenttia hän on käyttänyt palkastaan tähän mennessä johonkin tiettyyn kategoriaan

:heavy_check_mark: Käyttäjä voi kuukauden lopussa tai alussa nollata edellisen kuukauden tiedot

:heavy_check_mark: Käyttäjä voi kirjautua ulos

## Jatkokehitysideoita

- Käyttäjä voi määrittää säästötavoitteen kuukaudelle 
  - Käyttäjä voi laittaa rahaa säästöön haluamansa määrän
  - Raportti voi ilmoittaa montako prosenttia säästötavoitteesta uupuu

- Käyttäjä voi poistaa merkitsemiään menoja

- Käyttäjä voi lisätä tuloihinsa jonkin summan

- Käyttäjä voi tarkistaa millaisia kategorioita hän on määritellyt

- Ohjelma voisi tarkastaa riittääkö tulot menoihin, joita asiakas haluaa kirjata

- Käyttäjä voi lisätä tuloihin jonkin summan

- Yksi raportti voisi kertoa paljonko rahaa on vielä käytettäväksi

- Käyttäjä voisi tallentaa kuukauden tiedot ylös ja tarkastella niitä

