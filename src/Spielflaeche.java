import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import de.fhwgt.dionarap.model.objects.*;

/**
 * Spielflaeche
 * Initialisierung der Spielflaeche, abgeleitet von JPanel
 * @author Simon Hülsing
 * @version 1.0
 */
public class Spielflaeche extends JPanel {
	private Hauptfenster hauptfenster;
	private JLabel[][] label_flaeche;

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
		int sizeY = hauptfenster.getDionaRapModel().getGrid().getGridSizeY();
		int sizeX = hauptfenster.getDionaRapModel().getGrid().getGridSizeX();
		label_flaeche = new JLabel[sizeY][sizeX];

		this.setLayout(new GridLayout(sizeY,sizeX));
		for (int i = 0; i < sizeY; i++) {
			for (int k = 0; k < sizeX; k++) {
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

	/*
	 * Zeichnet alle Spielfiguren/Hindernisse
	 */
	public void paintAllPawns(AbstractPawn[] pawns) {
		for(int i = 0; i < pawns.length; i++) {
			if(pawns[i] instanceof Obstacle) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("H");
				//invert color
			}
			if(pawns[i] instanceof Opponent) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("G");
			}
			if(pawns[i] instanceof Player) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("S");
			}
			if(pawns[i] instanceof Destruction) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("*");
			}
			if(pawns[i] instanceof Vortex) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setBackground(Color.BLUE);
			}
			if(pawns[i] instanceof Ammo) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("A");
			}

		}

	}
}
