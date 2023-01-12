# Kurs Współbieżności - Zadania Domowe

Referencyjne rozwiązania do [Kursu Współbieżności](https://kurswspolbieznosci.pl).

## Tydzień 1 - Plan Gry

Dołącz do naszej społeczności na Slacku.
Szczegóły i hasło [znajdziesz tutaj](https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-1/lekcja-7-praca-domowa/).

## Tydzień 2 - Wątki

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-2/lekcja-12-praca-domowa/

1. Napisz prostą aplikację, która korzysta z kilku wątków.
2. W aplikacji jest jedna współdzielona liczba.
3. Stwórz wątek T1, który generuje losową wartość od 1 do 50 i zapisuje ją do współdzielonej liczby.
4. Wątek T2, generujący wartość od 100 do 500 i też zapisujący ją do współdzielonej liczby.
5. Uwaga - do liczby można pisać, tylko gdy ta jest null-em. Gdy ta jest wypełniona, wątki muszą czekać.
6. Wątek T3, który czyta tę liczbę i liczy sumę kolejnych liczb od 1 do tej liczby.
   1. Np. dla liczby 5 liczy sumę 1+2+3+4+5.
   2. Gdy odczyta tę liczbę, ma ją wyzerować (ustawić na `null`).
7. Wątek T4 monitorujący pozostałe wątki. Co 1 sekundę wypisuje na konsolę, w jakim stanie są te wątki.
8. Po 30 sekundach program powinien zakończyć swoje działanie.

## Tydzień 3 - Synchronizacja

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-3/lekcja-16-praca-domowa/

1. Przejrzyj materiał z całego tygodnia.
2. Spróbuj pobawić się ze strukturami i klasami, które poznałeś w tym tygodniu.

## Tydzień 4 - Pule Wątków

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-4-pule-watkow/lekcja-11/

### Zadanie 1 - BoundedThreadPool

1. Stwórz pulę wątków, utrzymującą od 1 do 4 wątków.
2. Żywotność oczekujących wątków to 30 sekund.
3. Na wykonanie może czekać maksymalnie 10 zadań.
4. Mechanizm sprawdzający ile zadań nie udało się przyjąć.
5. Gdy ta liczba osiągnie wartość 10 odrzuconych zadań, kolejka powinna zakończyć swoje działanie.

### Zadanie 2 - DigitsSumTask

1. Użyj ForkJoinPool oraz RecursiveTask.
2. Program przyjmuje na wejście długą liczbę w formie Stringa.
3. W sposób rekurencyjny program liczy sumę cyfr tej liczb.
4. Np. dla "103908" wynik to 1+0+3+9+0+8 = 21.

## Tydzień 5 - Operacje Asynchroniczne

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-5-operacje-asynchroniczne/lekcja-13-praca-domowa/

1. Zmodyfikuj kod z lekcji 11 dotyczący pracy z CompletableFuture.
2. Niech operacje, z których składamy zamówienie, czasami się nie udają.
3. W odpowiedni sposób obsłuż błąd lub sukces całego zamówienia.

## Tydzień 6 - Kolekcje

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-6-kolekcje/lekcja-10-praca-domowa/

### Zadanie 1 - Cache

1. Napisz własną implementację Cache-a.
2. Cache usuwa wszystkie elementy, które nie były używane przez min. 10 sekund.
3. Napisz fragment kodu sprawdzający poprawność implementacji.

### Zadanie 2 - Producent i konsument

1. Napisz rozwiązanie problemu producenta i konsumenta.
2. Producenci produkują jakieś informacje, a konsumenci konsumują.
3. Liczba producentów i konsumentów powinna być konfigurowalna.
4. Spraw, by zachowywały się one poprawnie pod kątem współbieżności.
5. Napisz kod sprawdzający poprawność Twojego rozwiązania.

## Tydzień 7 - Utrzymanie

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-7-utrzymanie/lekcja-11/

1. Przejdź przez lekcje dotyczące testowania i utrzymania aplikacji.
2. Jeśli coś jest niejasne, zadaj pytania w naszej społeczności na Slacku.

## Tydzień 8 - Najlepsze Praktyki

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-8-najlepsze-praktyki/lekcja-12/

1. Przejdź przez lekcje dotyczące najlepszych praktyk dotyczących współbieżności.
2. Jeśli coś jest niejasne, zadaj pytania w naszej społeczności na Slacku.

## Tydzień 9 - Pożegnanie

https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-9-pozegnanie/lekcja-7-praca-domowa/

1. Umieść swoją opinię o programie w naszej społeczności na Slacku.
