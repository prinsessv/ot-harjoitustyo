# Vaatimusmäärittely  :gem:

## Sovelluksen tarkoitus
Pankki tarjoaa asiakkailleen sovellusta, jossa asiakas voi pitää kirjaa tuloistaan ja menoistaan. Asiakkaan täytyy kirjata hänen tulot ja menot sovellukseen. Menot kirjataan eri kategorioihin. Sovelluksesta voi tulostaa erilaisia raportteja, kuten kertyneet menot, montako prosenttia tuloista on käytetty sekä monta prosenttia rahoista on kulunut mihinkin kategoriaan. 

## Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä.

## Käyttöliittymäluonnos

:heavy_check_mark: Sovelluksessa on kolme eri näkymää: kirjautumiselle, uuden käyttäjän luomiselle ja itse sovellukselle.

:heavy_check_mark: Kirjautumisnäkymässä käyttäjä voi joko kirjautua sisään kirjoittamalla tunnuksensa ja salasanansa sopiviin kohtiin ja painamalla sen jälkeen nappia LOGIN tai luoda käyttäjätunnuksen painamalla nappia CREATE NEW USER.

:heavy_check_mark: Kun käyttäjä päättää luoda käyttäjätunnuksen, aukeaa lomakenäkymä. Tässä näkymässä käyttäjä määrittelee nimensä sekä haluamansa käyttäjätunnuksen ja salasanan sopiviin kohtiin. Lopuksi käyttäjä painaa nappia CREATE.

:heavy_check_mark: Jos käyttäjätunnus ja salasana ovat oikein, näkymä vaihtuu itse sovellukseen. 

Tässä näkymässä käyttäjä näkee asettamansa tulot ja menot. 

Tulot ja menot voi nollata painamalla nappia RESET. 

:heavy_check_mark: Toimintonäppäimiä ovat: 

1. kirjaa meno

2. kirjaa tulo ja 
	           
3. tulosta raportti. 

:heavy_check_mark: Käyttäjä voi myös kirjautua ulos napista LOG OUT.

Erilaisia raportteja ovat esimerkiksi:

:heavy_check_mark: 1. Kerro tulot

:heavy_check_mark: 2. Kerro menot

:heavy_check_mark: 3. Prosenttimäärä tuloista, joka on käytetty menoihin

4. Prosenttimäärä tuloista, joka on käytetty eri kategorioihin

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

:heavy_check_mark: käyttäjä voi luoda tunnuksen, jos hänellä ei vielä ole
  - käyttäjätunnuksen on oltava uniikki

:heavy_check_mark: käyttäjä voi kirjautua järjestelmään, jos tunnukset ovat oikeat

### Kirjautumisen jälkeen

:heavy_check_mark: Käyttäjä voi kirjata menoja ja tulostaa siitä raportin

:heavy_check_mark: Käyttäjä voi kirjata tuloja ja tulostaa siitä raportin

- Käyttäjä voi kuukauden lopussa tai alussa nollata edellisen kuukauden tiedot

:heavy_check_mark: Käyttäjä voi kirjautua ulos

## Jatkokehitysideoita

- Käyttäjä voi määrittää säästötavoitteen kuukaudelle 
  - Käyttäjä voi laittaa rahaa säästöön haluamansa määrän
  - Raportti voi ilmoittaa montako prosenttia säästötavoitteesta uupuu

- Käyttäjä voi poistaa merkitsemiään menoja

- Käyttäjä voi lisätä tuloihin jonkin summan

- Yksi raportti voi kertoa paljonko rahaa on käytettäväksi

- Käyttäjä voisi tallentaa kuukauden tiedot ylös

