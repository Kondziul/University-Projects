import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class Window extends JFrame
{

    public Window(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Jak masz na imię?");
        String name = scan.nextLine();
        System.out.println("Witaj " + name);
        setTitle("Bomba czy Diament Gracz: " + name); //nazwa okna
        //wygląd okna
        setLayout(new GridLayout(2, 2,10,10));
        setSize(800,800);
        //przyciski
        JButton przycisk1 = new JButton("Diament?");
        JButton przycisk2 = new JButton("Diament?");
        JLabel info = new JLabel("Wybierz jeden z powyższych");
        JTextArea tekst = new JTextArea("Wpisz co chcesz");
        add(przycisk1);
        add(przycisk2);
        add(info);
        add(tekst);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        przycisk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Button(tekst, info, losuj()); //nowy obiekt Button przy naciśnięciu

            }
        });
        przycisk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Button(tekst, info, 1-losuj());

            }
        });

    }

    public int losuj() { //funkcja losująca 0/1
        Random rand = new Random();
        return rand.nextInt(2);

    }

}
