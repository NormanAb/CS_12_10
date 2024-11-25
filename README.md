# CS_12_10
JavaFX + file reading and writing


HL užduotis
Pavadinimas:

JavaFX Programa Rūšiavimo Algoritmų Analizei
 
Užduoties Aprašymas:

Sukurkite JavaFX programą, kuri leidžia vartotojui testuoti pasirinktą rūšiavimo algoritmą naudojant duomenis iš CSV failo. Programa turi pateikti vizualią sąsają, kurioje vartotojas galės įkelti duomenis, pasirinkti algoritmą ir matyti surūšiuotus rezultatus. Be to, programa turi pateikti informaciją apie pasirinktų algoritmų efektyvumą (laiko ir atminties sąnaudas).
Reikalavimai:
Funkciniai reikalavimai:
Duomenų įkėlimas:
Vartotojas turi galėti įkelti duomenis iš CSV failo.
CSV faile gali būti skaičių sąrašas arba tekstiniai duomenys (vienoje eilutėje ar keliuose stulpeliuose).
Algoritmų pasirinkimas:
Programa turi leisti pasirinkti vieną iš šių algoritmų:
Bubble Sort
Merge Sort
Quick Sort
Insertion Sort
Papildomai galite pridėti kitus algoritmus, pavyzdžiui, Selection Sort arba Heap Sort (pasirinktinai).
Rūšiavimas:
Vartotojas paspaudžia mygtuką „Rūšiuoti“, o pasirinktas algoritmas surūšiuoja įkeltus duomenis.
Rezultato atvaizdavimas:
Surūšiuoti duomenys pateikiami vartotojui grafinėje sąsajoje.
Programa rodo informaciją apie:
Rūšiavimui skirtą laiką (milisekundėmis).
Algoritmo atminties sąnaudas (kilobaitais arba megabaitais).
Techniniai reikalavimai:
Programavimo aplinka:
Naudoti Java su JavaFX biblioteka vartotojo sąsajai kurti.
Duomenų apdorojimas:
Naudoti tinkamas kolekcijų klases ir metodus rūšiavimui (pvz., ArrayList arba masyvus).
Rezultato analizė:
Naudoti System.nanoTime() laiko matavimui.
Atminties sąnaudas apskaičiuoti pagal veikiančios programos sunaudotą atmintį (pvz., su Runtime.getRuntime()).
Grafinės sąsajos reikalavimai:
Programa turi turėti aiškų ir paprastą dizainą:
Mygtukas CSV failo įkėlimui.
Išskleidžiamasis meniu algoritmo pasirinkimui.
Mygtukas „Rūšiuoti“.
Teksto arba lentelės laukelis rezultatams pateikti.
Vietos atminties ir laiko rezultatų rodymui.
Naudoti JavaFX valdiklius, tokius kaip:
TableView duomenų rodymui.
ChoiceBox arba ComboBox algoritmo pasirinkimui.
Button veiksmų inicijavimui.
Pavyzdys: Vartotojo sąsaja
Ekrano struktūra:
Viršuje: Mygtukas CSV failo įkėlimui.
Viduryje:
Algoritmo pasirinkimo meniu.
Lentelė su pradine (nerūšiuota) ir surūšiuota duomenų versija.
Apačioje: Rezultatų sritis:
Rūšiavimo laikas.
Atminties sąnaudos.
Vertinimo kriterijai:
Pagrindinių funkcijų įgyvendinimas (60%):
Duomenų įkėlimas iš CSV failo.
Rūšiavimo algoritmo pasirinkimas.
Teisingai surūšiuoti duomenys.
Efektyvumo analizė (20%):
Teisingai apskaičiuotas rūšiavimo laikas.
Atminties sąnaudų pateikimas.
Grafinė sąsaja ir vartotojo patirtis (10%):
Paprastas ir patogus naudoti dizainas.
Aiškus rezultatų atvaizdavimas.
Kūrybiniai sprendimai ir papildomos funkcijos (10%):
Papildomi algoritmai ar funkcionalumai (pvz., pasirinkimo galimybė rūšiuoti didėjimo arba mažėjimo tvarka).
Papildomos gairės:
Įsitikinkite, kad jūsų programa gali apdoroti tiek mažus, tiek didelius duomenų rinkinius.
Galite pridėti klaidų valdymą, jei vartotojas įkelia netinkamą failą ar nepasirenka algoritmo.
Sėkmės programuojant!
 
 CS IV
 
