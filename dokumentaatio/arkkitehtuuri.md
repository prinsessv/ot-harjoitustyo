# Arkkitehtuurikuvaus

### Rakenne

Koodin pakkausrakenne on seuraava: 

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkausrakenne.jpg" width="700">

Pakkaus ui sisältää JavaFX:llä luodun käyttöliittymän ja pakkaus logic sisältää sovelluslogiikan ja tietojen tallennuksesta vastaavan koodin.

### Käyttöliittymä

Käyttöliittymässä on useita eri näkymiä:

1. Kirjautuminen

2. Uuden käyttäjän luonti

3. Itse sovellus

4. Lomakkeita

5. Raportteja

Näkymät ovat yksi kerrallaan näkyvillä. Käyttöliittymä kutsuu joitakin sovelluslogiikan metodeja. 

### Sovelluslogiikka

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/createNewUser.png" width="700">

Seuraavat kaaviot sisältävät selvyyden vuoksi Javan oman FileWriter luokan kutsut:

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/SekvenssikaavioTulot.png" width="700">

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/SekvenssikaavioMenot.png" width="700">

### Tietojen tallennus

Tiedot asiakkaista ja heidän kirjanpidoista tallennetaan tiedostoon. 

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

## Ohjelman rakenteeseen jääneet heikkoudet

### Käyttöliittymä

Käyttöliittymässä ei ole muita metodeja kuin start metodi, joten se sisältää paljon koodia.

### Sovelluslogiikka

Tiedot tallennetaan tiedostoon, eikä tietokantaan.
