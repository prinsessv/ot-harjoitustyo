# **Ohjelmistotekniikka** :books:

## Projekti: Asiakassovellus
Sovellus mahdollistaa asiakkaille kirjanpidon omista tuloista ja menoista.
Se tarjoaa asiakkaalle erilaisia raportteja hänen toiminnastaan.

### Dokumentaatio

[Työaikakirjanpito](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

### Java-versio
Asiakassovelluksen luomiseen on käytetty Javan versiota 11.

### Releaset

[Viikon 5 release](https://github.com/prinsessv/ot-harjoitustyo/releases/tag/viikko5)

### Komentorivitoiminnot

Komentorivitoiminnot täytyy suorittaa Asiakassovellus hakemiston sisällä.

### Suorittaminen

Jos et halua luoda uutta käyttäjää erikseen, voit antaa tämän komennon ennen ohjelman käynnistämistä:

```
rm -f users.txt && rm -f user_income.txt && rm -f user_expense.txt && echo "user;password" >> users.txt && touch user_income.txt && touch user_expense.txt
```

Ohjelman saa käyntiin komennolla

```
mvn compile exec:java -Dexec.mainClass=main.Main
```

Tämän jälkeen kirjautuminen sisään onnistuu tunnuksilla:

Username = _user_

Password = _password_

### Testaus

Ohjelmaa testatessa tiedostojen luonti ja niihin kirjoitus ei välttämättä ehdi tapahtua. Ohjelmaa normaalisti ajaessa luonnollisia taukoja vaikuttaa tulevan riittävästi siten, että tieto ehtii tallettua. Projektiin liittyviä tietokantatiedostoja ei saa pitää repositoriossa, joten ennen testin ajamista terminaalissa täytyy kirjoittaa komento:

```
rm -f users.txt && rm -f user_income.txt && rm -f user_expense.txt && echo "user;password" >> users.txt && touch user_income.txt && touch user_expense.txt
```

Testit suoritetaan komennolla

```
mvn test
```

Ja testikattavuusraportti suoritetaan komennolla

```
mvn jacoco:report
```

Testikattavuusraportin saa näkyviin myös selaimessa: avaa tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Samoin kun ennen testaamista, on aluksi annettava komento

```
rm -f users.txt && rm -f user_income.txt && rm -f user_expense.txt && echo "user;password" >> users.txt && touch user_income.txt && touch user_expense.txt
```

Tämän jälkeen komennolla

```
mvn package
```

saadaan generoitua suoritettava jar-tiedosto _Asiakassovellus-1.0-SNAPSHOT.jar_ hakemistoon target

### Checkstyle

Tiedoston checkstyle.xml määrittelemät tarkastukset suoritetaan komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```

Jos virheilmoituksia ilmenee, ne saadaan selvitettyä avaamalla selaimeen tiedosto _target/site/checkstyle.html_


