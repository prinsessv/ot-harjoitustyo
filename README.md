# **Ohjelmistotekniikka** :books:

## Projekti: Asiakassovellus
Sovellus mahdollistaa asiakkaille kirjanpidon omista tuloista ja menoista.
Se tarjoaa asiakkaalle erilaisia raportteja hänen toiminnastaan.

### Dokumentaatio

[Työaikakirjanpito](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

### Komentorivitoiminnot

Komentorivitoiminnot täytyy suorittaa Asiakassovellus hakemiston sisällä.

### Suorittaminen

Ohjelman saa käyntiin komennolla

```
mvn compile exec:java -Dexec.mainClass=main.Main
```

### Testaus

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

Komennolla

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

### JavaDoc

JavaDoc voidaan generoida antamalla komento

```
mvn javadoc:javadoc
```

JavaDocia voidaan tutkia avaamalla selaimeen tiedosto _target/site/apidocs/index.html_

