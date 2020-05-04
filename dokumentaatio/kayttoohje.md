# Käyttöohje :books:

Lataa sovelluksen uusin versio linkin kautta: [Sovelluksen uusin versio](https://github.com/prinsessv/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään samassa hakemistossa johon se ladattiin, komennolla

```
java -jar Asiakassovellus-1.0-SNAPSHOT.jar
```

## Kirjautuminen

Sovelluksesta aukeaa ensimmäisenä kirjautumisnäkymä. Kirjautuminen onnistuu syöttämällä luotu käyttäjätunnus ja sen salasana syöttökenttiin ja painamalla nappia LOGIN. 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kirjautumisNakyma.png" width="370">               <img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kirjauduSisaan.png" width="365">

## Uuden käyttäjän luominen

Kirjautumisnäkymässä on mahdollista luoda myös uusi käyttäjä painamalla CREATE NEW USER nappia. 
Tällöin aukeaa allaoleva näkymä, johon syötetään halutut käyttäjätunnus ja salasana.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/uudenKayttajanLuonti.png" width="370">

Käyttäjätunnus ei saa sisältää erikoismerkkejä.
Ohjelma kertoo, jos käyttäjätunnus on varattu, vääränlainen, tai jos sen luonti onnistui. Takaisin kirjautumisnäkymään pääsee nuolinäppäimellä.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttajanimiVarattu.png" width="300">               <img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttajanimiErikoismerkit.png" width="305">

## Sovellusnäkymä

Kun kirjautuminen onnistuu, näkymä vaihtuu sovellusnäkymään:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sovellus.png" width="300">


## Menojen ja tulojen kirjaaminen

Tulojen kirjaaminen tapahtuu painamalla sovellusnäkymän nappia Book income. Tämän napin painamisen jälkeen avautuu uusi näkymä. Syötekenttään kirjataan haluttu muistiin kirjattava tulo. Kun BOOK nappia on painettu, etusivulle voi siirtyä nuolinäppäimen avulla. Syötekenttään voidaan kirjoittaa myös senttejä. Senttien erottelu onnistuu sekä desimaalipilkulla, että pisteellä. Tulo ei kuitenkaan saa olla nolla eikä negatiivinen. Huomaathan, että voit lisätä aiempaan merkkaamaasi tuloon uuden summan tätä kautta. Jos olet esimerkiksi merkannut tuloiksesi 1500, voit lisätä siihen 500 kirjaamalla sen tätä kautta. 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/incomeBooked.png" width="300">               <img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/incomeMiinus.png" width="300">

Menojen kirjaaminen tapahtuu painamalla nappia Book expense. Tämän napin painamisen jälkeen avautuu uusi näkymä. Syötekenttiin kirjataan ensin ostos, sitten ostoksen kategoria ja lopuksi ostoksen hinta.
Kun haluttu meno on kirjattu ja Book your purchase nappia on painettu, etusivulle pääsee takaisin nuolinäppäimen avulla. Ostoksen hinnan sentit voi jälleen erotella sekä desimaalipilkulla, että pisteellä. Ostoksen hinta ei saa olla negatiivinen, mutta ilmaiset saadut asiat on myös mahdollista kirjata sovellukseen.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/expenseBooked.png" width="300">               <img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/expenseMiinus.png" width="300">

## Raportit

Raportteja pääsee tulostamaan painamalla nappia Print report. Tällöin aukeaa uusi näkymä, jossa on eri raportti vaihtoehtoja. 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/raportit.png" width="370">

Haluttua raporttinappia klikkaamalla aukeaa ponnahdusikkuna, joka kertoo halutun raportin. Etusivulle pääsee painamalla nuolinäppäintä.

Alla ovat raporttivaihtoehtojen ponnahdusikkunat samassa järjestyksessä kuin napit ovat ylläolevassa raporttinäkymässä:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/incomeRaportti.png" width="370">

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/expenseRaportti.png" width="370">

Seuraavat prosenttimääriä kertovat raportit pyöristävät prosentin lähimpään kokonaislukuun. 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/percentRaportti.png" width="370">

Napin "Percents used of income for each category" painalluksen jälkeen täytyy määritellä minkä kategorian raportin haluaa nähdä:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/whichCategory.png" width="350">

Kategorian määrittelyn jälkeen raportti aukeaa uuteen ikkunaan, kuten muutkin raportit.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/categoryPercentRaportti.png" width="370">

## Reset

Sovellusnäkymän yläkulmassa on nappi Reset all, jota painamalla voi milloin tahansa nollata kirjatut tulot ja menot. Nollaus on tarkoitus kuitenkin tehdä joka kuukauden alussa, jotta käyttöön saadaan uudet päivitetyt raportit. Reset all nappi avaa ponnahdusikkunan, jossa varmistetaan, että resetointi halutaan varmasti tehdä.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/resetSuccess.png" width="295">

## Logout

Sovellusnäkymän yläkulmassa on nappi LOGOUT, joka kirjaa käyttäjän ulos. Nappia painamalla näkymä vaihtuu takaisin kirjautumisnäkymään, josta voi kirjautua uudelleen sisään tai luoda uuden käyttäjän.

