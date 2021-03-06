package verkkopankki.gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import verkkopankki.logiikka.Asiakas;
import verkkopankki.logiikka.Jarjestelma;

/**
 *
 * @author Oskari
 */
public class Kirjautumisikkuna extends Ikkuna {

    private final JFrame frame;
    private final Jarjestelma jarjestelma;
    private final JPanel ikkuna;
    private final JTextField kayttisField;
    private final JPasswordField salasanaField;

    public Kirjautumisikkuna(JFrame frame, Jarjestelma jarjestelma) {
        super(frame, jarjestelma);
        this.jarjestelma = jarjestelma;
        this.frame = frame;
        this.ikkuna = new JPanel();
        this.kayttisField = new JTextField();
        this.salasanaField = new JPasswordField();
    }

    @Override
    public void luoKomponentit() {
        ikkuna.setLayout(null);

        JLabel tervetuloaLabel = new JLabel("Tervetuloa Javapankkiin!");
        tervetuloaLabel.setBounds(480, 200, 300, 30);
        tervetuloaLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

        JPanel tietoIkkuna = new JPanel();
        tietoIkkuna.setBounds(500, 250, 240, 50);
        tietoIkkuna.setLayout(new GridLayout(2, 2, 0, 5));

        JLabel kayttisLabel = new JLabel("Käyttäjätunnus:");
        JLabel salasanaLabel = new JLabel("Salasana:");

        tietoIkkuna.add(kayttisLabel);
        tietoIkkuna.add(kayttisField);
        tietoIkkuna.add(salasanaLabel);
        tietoIkkuna.add(salasanaField);

        JButton kirjauduButton = new JButton("Kirjaudu");
        kirjauduButton.addMouseListener(new Kirjautuja());
        kirjauduButton.setBounds(500, 310, 240, 25);

        salasanaField.addKeyListener(new ToinenKirjautuja());

        ikkuna.add(tervetuloaLabel);
        ikkuna.add(tietoIkkuna);
        ikkuna.add(kirjauduButton);

        frame.getContentPane().add(ikkuna);
    }

    private class Kirjautuja implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Asiakas asiakas = jarjestelma.haeAsiakas(kayttisField.getText());
            if (asiakas == null) {
                JOptionPane.showMessageDialog(null, "Tarkista käyttäjätunnus");
                return;
            }

            if (asiakas.tasmaakoSalasana(salasanaField.getText())) {
                frame.getContentPane().removeAll();
                Etusivu etusivu = new Etusivu(frame, jarjestelma, asiakas);
                etusivu.luoKomponentit();
                frame.getContentPane().revalidate();
            } else {
                JOptionPane.showMessageDialog(null, "Tarkista käyttäjätunnus ja salasana");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class ToinenKirjautuja implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Asiakas asiakas = jarjestelma.haeAsiakas(kayttisField.getText());
                if (asiakas == null) {
                    JOptionPane.showMessageDialog(null, "Tarkista käyttäjätunnus");
                    return;
                }

                if (asiakas.tasmaakoSalasana(salasanaField.getText())) {
                    frame.getContentPane().removeAll();
                    Etusivu etusivu = new Etusivu(frame, jarjestelma, asiakas);
                    etusivu.luoKomponentit();
                    frame.getContentPane().revalidate();
                } else {
                    JOptionPane.showMessageDialog(null, "Tarkista käyttäjätunnus ja salasana");
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }
}
