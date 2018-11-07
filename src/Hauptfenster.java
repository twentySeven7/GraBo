import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * Hauptfenster
 * Initialisierung des Hauptfensters, abgeleitet von JFrame
 * @author Simon Hülsing
 * @version 1.0
 */
public class Hauptfenster extends JFrame{
	/**
     * Standard Konstruktor der Klasse Hauptfenster
     *
     * setzt die Fenstereingenschaften: Titel, Hauptfenster erscheint in der Mitte des Bildschirmes, Sichtbarkeit, erzeugen des Spielfeldes(JPanel)
     * @param titel String aus der public Methode
     */
	Hauptfenster(String titel){
		// Frame Eigenschaften
		super(titel);
		Container darstellungsflaeche = this.getContentPane();
		darstellungsflaeche.setLayout(new BorderLayout());

		Spielflaeche spielflaeche = new Spielflaeche(this);
		this.add(spielflaeche, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);

		Navigator navigator = new Navigator(this);


		this.setVisible(true);
	}

    /**
     * Main-Methode erzeugt das Hauptfenster
     * @param args Kommandozeilenparameter (wird aber nicht gebraucht)
     */
	public static void main(String[] args) {
		new Hauptfenster("DionaRap");

	}
}
