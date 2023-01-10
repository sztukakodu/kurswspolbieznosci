# kurswspolbieznosci

## Tydzień 4
https://edu.sztukakodu.pl/kurs-wspolbieznosci/tydzien-4-pule-watkow/lekcja-11/

### Zadanie 1 - BoundedThreadPool
1. Stwórz pulę wątków, utrzymującą od 1 do 4 wątków.
2. Żywotność oczekujących wątków to 30 sekund.
3. Na wykonanie może czekać maksymalnie 10 zadań.
4. Mechanizm sprawdzający ile zadań nie udało się przyjąć.
5. Gdy ta liczba osiągnie wartość 10 odrzuconych zadań, kolejka powinna zakończyć swoje działanie.

### Zadanie 2
1. Użyj ForkJoinPool oraz RecursiveTask.
2. Program przyjmuje na wejście długą liczbę w formie stringa.
3. W sposób rekurencyjny program liczy sumę cyfr tej liczb.
4. Np. dla "103908" wynik to 1+0+3+9+0+8 = 21.
