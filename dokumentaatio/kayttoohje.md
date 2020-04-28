# Käyttöohje

Lataa sovelluksen uusin versio linkin kautta: [Sovelluksen uusin versio](https://github.com/prinsessv/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään samassa hakemistossa johon se ladattiin, komennolla

```
java -jar Asiakassovellus-1.0-SNAPSHOT.jar
```

## Kirjautuminen

Sovelluksesta aukeaa ensimmäisenä kirjautumisnäkymä:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Kirjautuminen.png" width="400">

Kirjautuminen onnistuu syöttämällä luotu käyttäjätunnus ja sen salasana syöttökenttiin ja painamalla nappia LOGIN. 

## Uuden käyttäjän luominen

Kirjautumisnäkymässä on mahdollista luoda myös uusi käyttäjä painamalla CREATE NEW USER nappia. 
Tällöin aukeaa allaoleva näkymä, johon syötetään halutut käyttäjätunnus ja salasana.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/createNewUser.png" width="400">

Ohjelma kertoo, jos käyttäjätunnus oli väärin tai jos sen luonti onnistui. Takaisin kirjautumisnäkymään pääsee nuolinäppäimellä.

## Menojen ja tulojen kirjaaminen

Tulojen kirjaaminen tapahtuu painamalla nappia BOOK INCOME. Tämän napin painamisen jälkeen avautuu uusi näkymä. Syötekenttään kirjataan haluttu muistiin kirjattava summa. Kun BOOK nappia on painettu, etusivulle voi siirtyä nuolinäppäimen avulla.

Menojen kirjaaminen tapahtuu painamalla nappia BOOK EXPENSE. Tämän napin painamisen jälkeen avautuu uusi näkymä. Syötekenttiin kirjataan ensin ostos, sitten ostoksen kategoria ja lopuksi ostoksen hinta.
Kun haluttu meno on kirjattu ja BOOK nappia on painettu, etusivulle pääsee takaisin nuolinäppäimen avulla.

## Raportit

Raportteja pääsee tulostamaan painamalla nappia REPORTS. Tällöin aukeaa uusi sivu, jossa on eri raportti vaihtoehtoja. Haluttua raporttinappia klikkaamalla aukeaa ponnahdusikkuna, joka kertoo halutun raportin. Etusivulle pääsee painamalla nuolinäppäintä.

## Logout

Etusivulla on nappi LOGOUT, joka kirjaa käyttäjän ulos. Nappia painamalla näkymä vaihtuu kirjautumisnäkymään.

