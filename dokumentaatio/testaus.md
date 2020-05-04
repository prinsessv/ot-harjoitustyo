# Testausdokumentti :mag:

Ohjelmaa on testattu JUnit-yksikkötesteillä sekä manuaalisesti.

## Sovelluslogiikka

Testit testaavat ohjelman sovelluslogiikkaa eli paketissa logic olevia luokkia BankApplication, User ja Users. Pakkauksessa main oleva luokka Main ja pakkauksessa ui oleva käyttöliittymäluokka BankApplicationUi on jätetty testien ulkopuolelle.

# Testauskattavuus

Jacoco-raportista nähdään, että sovelluksen testauksen rivikattavuus on 78% ja haarautumakattavuus hieman pienempi 67%.

<img src="https://github.com/prinsessv/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/jacocoReport.png" width="800">

# Järjestelmätestaus

Sovelluksen järjestelmätestausta on suoritettu manuaalisesti. Testaaminen vaatii tiedostojen users.txt, user_income.txt, user_expense.txt luonnin, sillä tiedon tallentuminen tiedostoon vie niin pitkän ajan ettei se kerkeä tapahtumaan ohjelmaa testattaessa. Lisäksi users.txt tiedostossa täytyy olla kirjattuna käyttäjänimi user ja salasana password puolipisteellä erotettuna seuraavasti: user;password

Sovellusta on testattu käyttöhjeen mukaisesti Linux-ympäristössä syöttämällä myös vääränlaisia syötteitä (tyhjää, välimerkkejä, desimaalipilkkua, ja merkkijonoja kokonaislukuja vaadittaessa) syöttökenttiin. 

Testeissä ei ole ilmennyt virheitä. 

Kaikki vaatimusmäärittelyssä ilmoitetut toiminnot on testattu.



