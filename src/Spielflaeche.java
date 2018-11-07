import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Spielflaeche
 * Initialisierung der Spielflaeche, abgeleitet von JPanel
 * @author Simon Hülsing
 * @version 1.0
 */
public class Spielflaeche extends JPanel {
	private Hauptfenster hauptfenster;
	private JLabel[][] label_flaeche = new JLabel[10][10];

    /**
     * Konstruktor der Spielflaeche vom Typ JPanel
     * zuweisen des Hauptfensters, ruft die Methode addJLabels() auf
     * @param hauptfenster Instanz des Hauptfenster
     */
	Spielflaeche(Hauptfenster hauptfenster) {
		this.hauptfenster = hauptfenster;
		addJLabels();
	}
    /**
     * Methode, erzeugt die Spielflaeche mit Schachbrettmuster
     */
	private void addJLabels() {
		this.setLayout(new GridLayout(10,10));
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 10; k++) {
				label_flaeche[i][k] = new JLabel();
				if ((i + k) % 2 == 0) { // Jedes zweites Feld wird weiss "angemalt"
					label_flaeche[i][k].setBackground(Color.BLACK);
				} else {
					label_flaeche[i][k].setBackground(Color.WHITE);
				}
				label_flaeche[i][k].setOpaque(true);

				label_flaeche[i][k].setPreferredSize(new Dimension(50, 50));
				this.add(label_flaeche[i][k]);
			}
		}
	}
}
