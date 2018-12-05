import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
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
	private ImageIcon iconPlayer;
	private ImageIcon iconPlayer1;
	private ImageIcon iconPlayer2;
	private ImageIcon iconPlayer3;
	private ImageIcon iconPlayer4;
	private ImageIcon iconPlayer6;
	private ImageIcon iconPlayer7;
	private ImageIcon iconPlayer8;
	private ImageIcon iconPlayer9;

    /**
     * Konstruktor der Spielflaeche vom Typ JPanel
     * zuweisen des Hauptfensters, ruft die Methode addJLabels() auf
     * @param hauptfenster Instanz des Hauptfenster
     */
	Spielflaeche(Hauptfenster hauptfenster) {
		this.hauptfenster = hauptfenster;
		addJLabels();
		createIcons();
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
			if(pawns[i] instanceof Player) {
				Player tmp = (Player) pawns[i];
				int blickRichtung = tmp.getViewDirection();
            	if(blickRichtung == 1){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer1);
				}
            	else if(blickRichtung == 2){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer2);
				}
            	else if(blickRichtung == 3){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer3);
				}
            	else if(blickRichtung == 4){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer4);
				}
            	else if(blickRichtung == 6){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer6);
				}
            	else if(blickRichtung == 7){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer7);
				}
            	else if(blickRichtung == 8){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer8);
				}
            	else if(blickRichtung == 9){
            		label_flaeche[pawns[i].getY()][pawns[i].getX()].setIcon(iconPlayer9);
            	}
			}
			if(pawns[i] instanceof Obstacle) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("H");
				//invert color
			}
			if(pawns[i] instanceof Opponent) {
				label_flaeche[pawns[i].getY()][pawns[i].getX()].setText("G");
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

	public void clearSpielflaeche() {
		int zeilen = hauptfenster.getDionaRapModel().getGrid().getGridSizeY();
		int spalten = hauptfenster.getDionaRapModel().getGrid().getGridSizeX();

		for(int i = 0; i < zeilen; i++) {
			for(int k = 0; k < spalten; k++) {
				label_flaeche[i][k].setText(null);
				label_flaeche[i][k].setIcon(null);
			}
		}
	}

	public void repaintPawns() {
		this.clearSpielflaeche();
		this.paintAllPawns(this.hauptfenster.getPawns());
	}

	public void createIcons() {

		String base_dir = System.getProperty("user.dir") + "\\images\\dracula\\";

		iconPlayer1 = new ImageIcon(base_dir + "player1.gif");
		iconPlayer2 = new ImageIcon(base_dir + "player2.gif");
		iconPlayer3 = new ImageIcon(base_dir + "player3.gif");
		iconPlayer4 = new ImageIcon(base_dir + "player4.gif");
		iconPlayer6 = new ImageIcon(base_dir + "player6.gif");
		iconPlayer7 = new ImageIcon(base_dir + "player7.gif");
		iconPlayer8 = new ImageIcon(base_dir + "player8.gif");
		iconPlayer9 = new ImageIcon(base_dir + "player9.gif");
	}
}
