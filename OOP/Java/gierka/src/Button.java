import javax.swing.*;

public class Button {
    static int diamonds=0; //na potrzeby zliczania
    // zmienne statyczne obowiązują w całej klasie, a nie w konkretnym obiekcie
    static int attempt=0;

    Button(JTextArea tekst, JLabel info, int b){ //konstruktor Button w celu ograniczenia ilości kodu
        // 2 przyciski na tym samym kodzie
        {
            int prob=19-attempt; //po pierwszym naciśnięciu pozostaje 19 prób
            if(b==1) //wylosowane 1, czyli pod przyciskiem diament
            {
                tekst.setText("Brawo diament \n" + "Pozostało " + prob +"prob");
                diamonds++; //dodanie diamentu do zmiennej statycznej
            }
            else //w przeciwnym przypadku(wylosowane 0) pod przyciskiem bomba
            {
                tekst.setText("Niestety bomba \n" + "Pozostało " + prob +"prob");
                diamonds=0; //zerowanie ilości diamentów przy wylosowaniu bomby
            }

            attempt++;
            if (attempt==20) //20 prób = koniec gry i reset statystyk
            {
                System.out.println("Twoj końcowy wynik to(diamenty na 20 prob): " + diamonds);
                info.setText("Twoj końcowy wynik to(diamenty na 20 prob): " + diamonds);
                attempt=0;
            }

            else info.setText("Próba: " + attempt + "     " + "Diamenty: " + diamonds);
        }


    }

}
