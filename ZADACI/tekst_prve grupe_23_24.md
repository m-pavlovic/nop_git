
# ZADATAK 1 - 1 ![simple](https://img.shields.io/badge/complexity-***-orange)

U prvom zadatku trebate napraviti GUI koji će predstavljati jednostavni kalkulator. Izgled GUI - a pikazan je na slici 1:

<p align = "center">
  <img width=55% height = auto
       src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167736&authkey=%21ALAz9cIPjrdV6SQ&width=564&height=361">
 
</p>
<p align = "center"> <strong>Slika 1:</strong> Izgled sučelja uz jednostavni kalkulator </p>

Primjenom prdloška strategije trebate osigurati sljedeće operacije:

1. `AdditionCalculation` &rarr; operacija zbrajanja
2. `SubtractionCalculation` &rarr; operacija oduzimanja
3. `MultiplicationCalculation` &rarr; operacija množenja
4. `DivisionCalculation` &rarr; opracija dijeljenja (dijeljenje s nulom nije dozvoljeno)
5. `PowerToCalculation` &rarr; opreracija potenciranja (second number treba svesti na int)

Dodatni zahtjevi su sljedeći:

- `First number` i `Second number` su očekivano double (jedino se za PowerTo drugi svodi na int vrijednost) &rarr; ta polja ne mogu biti prazna niti pogrešnog unosa
- Za oba polja u slučaju nedostajuće vrijednosti ili krivog unosa treba obavijestiti korisnika (`JOptionPane`)
- Rezultat pojedine operacije se prikazuje u pripadnom polju `Calculation` panela, a u view panelu se prikazuju svi podaci (slika 2)
- Podaci s forme `Calculation` se enkapsuliraju u razredu (klasi) `CalcData` &rarr; String reprezentacija te klase se prikazuje u view panelu

<p align = center>
<img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167737&authkey=%21AHtjz1LSyd5zprg&width=564&height=361">
</p>
<p align = "center"> <strong>Slika 2:</strong> Prikaz podataka enkapsuliranih u klasi CalcData </p>

U izborniku `File` spremanje i čitanje podataka treba također realizirati primjenom predloška strategija na način da se omogući spremanje u **bin** i **txt formatu**, te čitanje istih.

**VAŽNO:** Kada se podaci pročitaju iz txt datoteke potrebno je rekonstruirati strukuru podataka koja "pamti" sve CalcData.

> Poseban zahtjev uz realizaciju ovog dijela zadatka je da sve strategije za spremanje i čitanje podataka budu u zasebnom pakeu `data_save_load`!


# ZADATAK 1 - 2 ![simple](https://img.shields.io/badge/complexity-***-orange)

Drugi zadatak rješavate temeljem GUI-a koji smo realizirali uz zadatak za `BMI`, a pripadni kod možete preuzeti sa sustava Merlin pod sekcijom Dodatni materijali &rarr; [aplikacija_BMI](https://moodle.srce.hr/2023-2024/mod/resource/view.php?id=3599221). Refakoringom preimenujte paket u traženi naziv za ovaj zadatak. Vaš zadataka se sastoji od dorade sučelja na način da imate:

- `View panel` &rarr; već postoji
- `Table panel` &rarr; potrebno realizirati
- `Progress panel` &rarr; potrebno realizirati

Slika 3 prikazuje pripadni izgled takvog sučelja:

<p align = center>
<img width=70% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167738&authkey=%21AEp82IdilLuzrqc&width=884&height=611">
</p>
<p align = "center"> <strong>Slika 3:</strong> Prikaz sučelja za BMI aplikaciju s tri panela </p>

Prikaz podataka na sva tri panela treba biti realiziran korištenjem predloška promatrač (eng Observer) &rarr; paneli implementiraju pripadno sučelje. Vodite računa kako se stanja panela (promatrača) mijenjaju u ovisnosti o aktivnosti na form panelu, potom aktivnosti uz `clear` na alatnoj traci i aktivnosti uz `load` na alatnoj traci. U ovom slučaju `Main frame` je neka vrsta posrednika koji prenosi komunikaciju između subjekata koji se promatraju (na predavanjima smo govorili o Observable) pa se podrazumijeva da će obavještavanje upravo biti realizano u toj klasi (`notify` mehanizam). Na slikama 4, 5 i 6 redom su prikazana stanja sučelja nakon aktivnosti na formi za proračun BMI, potom uz clear i napokon load. 

<p align = center>
<img width=70% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167739&authkey=%21AAtWyujdeUJ380A&width=884&height=611">
</p>
<p align = "center"> <strong>Slika 4:</strong> BMI aplikacija nakon "promatranja" promjene na formi </p>

<p align = center>
<img width=70% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167741&authkey=%21AHsyiMyXLKjGKrI&width=884&height=611">
</p>
<p align = "center"> <strong>Slika 5:</strong> BMI aplikacija nakon promatranja promjene na alatnoj traci - clear </p>

<p align = center>
<img width=70% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167742&authkey=%21AKTvdRGnH66T3-c&width=884&height=611">
</p>
<p align = "center"> <strong>Slika 6:</strong> BMI aplikacija nakon promatranja promjene na alatnoj traci - load </p>

Zbog jednostavnosi treba postaviti da korisnik ne može unijeti više od pet podataka - slika 7, pa o tome treba voditi računa kada se podaci učitavaju, a stanje progres trake je time potpuno određeno. 

<p align = center>
<img width=70% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2167740&authkey=%21ACz7DCc13C7vahc&width=883&height=641">
</p>
<p align = "center"> <strong>Slika 6:</strong> BMI aplikacija nakon unosa preko dozvoljene kvote </p>

Dodatni zahtjev je da spremanje i čitanje podataka treba relizirati primjenom predloška strategija što ne bi trebalo predstavljati problem nakon što riješite prvi zadatak. Isto tako struktura podataka nakon učitavanja podataka iz txt datoteke treba biti rekonstrurirana &rarr; sve vam je već pripremljeno u klasi `ReadWriteClass` gdje samo trebate napraviti minorne promjene za primjenu tražnog predloška strategije. Realizacija strategija treba biti u zasebnom paketu `data_save_load_bmi` uz napomenu da trebate koristiti parametrizaciju u tom dijelu (za sučelja i konkretne klase), a ne odmah konkretnu klasu `Person`. 

Nakon što rješite sve navedeno potrebno je:

1. Izraditi dijagram klasa uz primjenu predloška Observer i objasniti kako funkcionira u vašem rješenju &rarr; PDF file naziva `observer.pdf` spremiti u mapu `doc`
2. Izraditi dijagram klasa uz primjenu predloška Strategy i objasniti kako funkcionira u vašem rješenju &rarr; PDF file naziva `stratgy.pdf` spremiti u mapu `doc`



