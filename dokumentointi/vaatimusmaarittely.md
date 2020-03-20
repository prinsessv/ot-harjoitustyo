# Vaatimusmäärittely

## Sovelluksen tarkoitus
Pankki tarjoaa asiakkailleen sovellusta, jossa asiakas voi pitää kirjaa tuloistaan ja menoistaan. Asiakkaan täytyy kirjata hänen tulot ja menot sovellukseen. Menot kirjataan eri kategorioihin. Sovelluksesta voi tulostaa erilaisia raportteja, kuten kertyneet menot, montako prosenttia tuloista on käytetty sekä monta prosenttia rahoista on kulunut mihinkin kategoriaan. 

## Käyttäjät
Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä.

## Käyttöliittymäluonnos

Sovelluksessa on kolme eri näkymää: kirjautumiselle, uuden käyttäjän luomiselle ja itse sovellukselle.

Kirjautumisnäkymässä käyttäjä voi joko kirjautua sisään kirjoittamalla tunnuksensa ja salasanansa sopiviin kohtiin ja painamalla sen jälkeen nappia LOGIN tai luoda käyttäjätunnuksen painamalla nappia CREATE NEW USER.

Kun käyttäjä päättää luoda käyttäjätunnuksen, aukeaa lomakenäkymä. Tässä näkymässä käyttäjä määrittelee nimensä sekä haluamansa käyttäjätunnuksen ja salasanan sopiviin kohtiin. Lopuksi käyttäjä painaa nappia CREATE.

Jos käyttäjätunnus ja salasana ovat oikein, näkymä vaihtuu itse sovellukseen. Tässä näkymässä käyttäjä näkee asettamansa tulot ja menot. Tulot ja menot voi nollata painamalla nappia RESET. Toimintonäppäimiä ovat: kirjaa meno, kirjaa tulo ja tulosta raportti. Käyttäjä voi myös kirjautua ulos napista LOG OUT.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

- käyttäjä voi luoda tunnuksen, jos hänellä ei vielä ole
  - käyttäjätunnuksen on oltava uniikki

- käyttäjä voi kirjautua järjestelmään, jos tunnukset ovat oikeat

### Kirjautumisen jälkeen

- Käyttäjä voi kirjata menoja, tuloja tai tulostaa raportteja
  - Käyttäjä myös näkee ne

- Käyttäjä voi kuukauden lopussa tai alussa nollata edellisen kuukauden tiedot

- Käyttäjä voi kirjautua ulos

## Jatkokehitysideoita

- Käyttäjä voi määrittää säästötavoitteen kuukaudelle 
  - Käyttäjä voi laittaa rahaa säästöön haluamansa määrän
  - Raportti voi ilmoittaa montako prosenttia säästötavoitteesta uupuu

- Käyttäjä voi poistaa merkitsemiään menoja

- Käyttäjä voi lisätä tuloihin jonkin summan

- Yksi raportti voi kertoa paljonko rahaa on käytettäväksi

- Käyttäjä voisi tallentaa kuukauden tiedot ylös

