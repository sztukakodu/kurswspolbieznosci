# Kurs Współbieżności - Zadania Domowe

Referencyjne rozwiązania do [Kursu Współbieżności](https://kurswspolbieznosci.pl).

## Tydzień 1

Dołącz do naszej społeczności na Slacku.
Szczegóły i hasło [znajdziesz tutaj](https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-1/lekcja-7-praca-domowa/).

## Tydzień 2

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

## Tydzień 4

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
