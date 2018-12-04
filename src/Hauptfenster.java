import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import de.fhwgt.dionarap.controller.DionaRapController;
import de.fhwgt.dionarap.model.data.DionaRapModel;
import de.fhwgt.dionarap.model.objects.AbstractPawn;

/**
 * Hauptfenster
 * Initialisierung des Hauptfensters, abgeleitet von JFrame
 * @author Simon Hülsing
 * @version 1.0
 */
public class Hauptfenster extends JFrame{
	private DionaRapModel dionaRapModel;
	private DionaRapController dionaRapController;
	private Spielflaeche spielflaeche;
	private int count_Gegner = 2;
	private int count_Hindernisse = 2;
	private int x = 10;
	private int y = 10;
	private AbstractPawn[] pawns;

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

		this.init_DionaRap();

		this.add(spielflaeche, BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null);

		Navigator navigator = new Navigator(this);
		this.addComponentListener(new ListenerFenster(navigator));
		this.addKeyListener(new ListenerKeyNum());

		this.setVisible(true);
	}

	/*
	 * Initialisiert DionaRapModel und den DionaRapController. Ebenfalls wird die Spielflaeche erzeugt
	 */
    private void init_DionaRap() {
		dionaRapModel = new DionaRapModel(y,x,count_Gegner, count_Hindernisse);
		dionaRapController = new DionaRapController(dionaRapModel);
		spielflaeche = new Spielflaeche(this);

		dionaRapModel.addModelChangedEventListener(new ListenerModel());

		pawns = this.dionaRapModel.getAllPawns();

		this.spielflaeche.paintAllPawns(pawns);
	}

	/**
     * Main-Methode erzeugt das Hauptfenster
     * @param args Kommandozeilenparameter (wird aber nicht gebraucht)
     */
	public static void main(String[] args) {
		new Hauptfenster("DionaRap");

	}

	public DionaRapModel getDionaRapModel() {
		return dionaRapModel;
	}

	public DionaRapController getDionaRapController() {
		// TODO Auto-generated method stub
		return dionaRapController;
	}
}
