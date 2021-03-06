# Arkkitehtuurikuvaus

### Rakenne

Koodin pakkausrakenne on seuraava: 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.jpg" width="700">

Pakkaus ui sisältää JavaFX:llä luodun käyttöliittymän ja pakkaus logic sisältää sovelluslogiikan ja tietojen tallennuksesta vastaavan koodin.

### Sovelluslogiikka

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/userBankApplication.png" width="600">

### Käyttöliittymä

Käyttöliittymässä on useita eri näkymiä:

1. Kirjautuminen

2. Uuden käyttäjän luonti

3. Itse sovellus

4. Lomakkeita

5. Raportteja

Näkymät ovat yksi kerrallaan näkyvillä. Kaikki eri näkymät on toteutettu [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-olioina, jotka ovat yksi kerrallaan sijoitettu [Stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Käyttöliittymä on eristetty lähes kokonaan sovelluslogiikasta, se kutsuu sovelluslogiikan metodeja toimintoja tarvitsevissa kohdissa. 

### Tietojen tallennus

Tiedot asiakkaista ja heidän kirjanpidoista tallennetaan tiedostoon. Talletustapa on mahdollista vaihtaa tarvittaessa toiseen. 

Käyttäjätiedot tallennetaan muodossa

```
username;password

user;pw
```

Tulot tallennetaan siten, että vain uusin eli ylin merkitty meno on merkitsevä

```
2000

6000

9000
```

Siis esimerkiksi tässä tapauksessa raporteissa menoina käytettäisiin 2000.

Menot tallennetaan muodossa

```
purchase;category;price

food;groceries;600
```

Kentät ovat siis sekä käyttäjätiedoissa että menoissa eroteltu puolipisteillä.

## Luokkakaavio

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/Luokkakaavio.png" width="700">

## Päätoiminnallisuudet sekvenssikaavioina

### Käyttäjän kirjautuminen asiakassovellukseen

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kirjautumisSekvenssikaavio.png" width="500">

Seuraavat kaaviot sisältävät selvyyden vuoksi Javan oman FileWriter luokan kutsut:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/SekvenssikaavioTulot.png" width="600">

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/SekvenssikaavioMenot.png" width="600">

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymässä ei ole paljoa muita metodeja kuin start metodi, joten se sisältää paljon koodia.

### Sovelluslogiikka

Tiedot tallennetaan tiedostoon, eikä tietokantaan.
