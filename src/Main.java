import java.util.*;
import java.util.stream.Collectors;

public class Main {
//Co to jest ConcurrentModificationException i dlaczego wystapil?
//Co to jest iterator i jak sie odnosi do for-each?
//Dlaczego nie zawsze tak prosty algorytm usuwa wszystkie parzyste liczby?
//jak przerobic metode w taki sposob aby dzialal dla kazdej listy (modyfikowalnej i nie)
//jak zrobic zeby metoda byla "bulletproof" tj: dzialala jesli są na niej nulle, lub jesli sama lista jest nullem.

    public static void main(String[] args) {

        /*
        1. Co to jest ConcurrentModificationException i dlaczego wystąpił?
        ConcurrentModificationException występuje,gdy struktura kolekcji jest
        zmieniana podczas iteracji nad nią, co jest niezgodne z oczekiwaniami iteratora
        (tak interator jest wykorzystywany przez for-each). Usuwanie elementów z listy w
        trakcie iteracji za pomocą pętli for-each prowadzi do tego wyjątku,ponieważ iterator
        nie jest świadomy zmiany struktury listy.

        2. Co to jest iterator i jak się odnosi do for-each?
        Iterator to narzędzie służące do przeglądania kolekcji.W Javie, pętla for-each
        wykorzystuje iterator wewnętrznie do iteracji po elementach kolekcji. Nie widać
        bezpośrednio użycia iteratora, ale pętla for-each korzysta z niego, aby przechodzić
        przez kolekcję.

        3. Dlaczego algorytm nie usuwa wszystkich parzystych liczb?
        Problem wynika z faktu, że usuwanie elementów w trakcie iteracji
        zmienia indeksy pozostałych elementów, co prowadzi do pominięcia niektórych z nich przez iterator.

        4. Jak zmodyfikować metodę, aby działała dla każdej listy?
        Najprostszym sposobem usunięcia parzystych liczb z listy w Javie,
        zachowującym zgodność z różnymi typami list (zarówno modyfikowalnymi,
        jak i niemodyfikowalnymi), jest użycie strumieni (Stream API).
        Oczywiście ja o tym nie pomyślałem próbując odpowiedzieć na pytanie,bo nie
        przyszło mi do głowy,że przecież można użyć innego podejścia,
        często się jeszcze łapie na tym rozwiązując zadania.
        Wracając do Stream API które działają na koncepcji "niezmienności" danych.
        Oznacza to, że operacje wykonane na strumieniu nie modyfikują oryginalnej kolekcji,
        z której strumień został utworzony. Dzięki temu unikam ryzyka ConcurrentModificationException,
        które może wystąpić podczas modyfikacji kolekcji w trakcie jej iteracji.Takie podejście jest
        eleganckie i wydajne.*/

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 50, 4, 10, 5, 6, 20, 10));
        System.out.println(bezpieczneFiltrowanieParzystychLiczb(numbers));
    }

    public static List<Integer> bezpieczneFiltrowanieParzystychLiczb(List<Integer> numbers) {
        if (numbers == null) {
            return new ArrayList<>(); // Zwracamy pustą listę, jeśli wejściowa lista jest null
        }
        return numbers.stream()
                .filter(Objects::nonNull) // Filtrujemy null
                .filter(n -> n % 2 != 0) // Zachowujemy tylko liczby nieparzyste
                .collect(Collectors.toList());
    }
}

        /* 5.jak zrobic zeby metoda byla "bulletproof" tj: dzialala jesli są na niej nulle, lub jesli sama lista jest nullem.
        Od razu rozwiązujemy tutaj problem z "bulletproof" ponieważ sprawdzamy czy lista nie jest
         null,jak i to czy poszczególne elementy na liście nie są nullami.
         */