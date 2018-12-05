import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * Navigator
 * Initialisierung des Kindfensters, abgeleitet von JWindow
 * @author Simon Hülsing
 * @version 1.0
 */
public class Navigator extends JWindow{
	public static final int ABSTAND = 50;

	private Hauptfenster hauptfenster;

    /**
     * Konstruktor der Steuerflaeche vom Typ JWindow
     * Erzeugt das Kindfenster, welches relativ zum Hauptfenster plaziert wird mit 50 Pixel Abstand
     * @param parent Instanz des Hauptfenster
     */
	public Navigator(JFrame parent) {
		super(parent);
		this.setSize(250,250);
		hauptfenster = (Hauptfenster) parent;
		//Rectangle navigatorPostion = parent.getBounds();

		Polygon achteck = newPolygon();
		this.setShape(achteck);

		JPanel rahmen = new JPanel();
		rahmen.setLayout(new BorderLayout());
		rahmen.add(new Tastatur());
		this.getContentPane().add(rahmen);

		rahmen.setVisible(true);
		this.setNavLocation();

		//Tastatur tastatur = new Tastatur();
		//this.add(tastatur);
		//this.pack();
		this.setVisible(true);

	}

	private Polygon newPolygon() {
		Polygon achteck = new Polygon();
		achteck.addPoint(85, 0);
		achteck.addPoint(170, 0);
		achteck.addPoint(255, 85);
		achteck.addPoint(255, 170);
		achteck.addPoint(170, 255);
		achteck.addPoint(85, 255);
		achteck.addPoint(0, 170);
		achteck.addPoint(0, 85);

		return achteck;
	}

	public void setNavLocation() {
		this.setLocation(getParent().getLocation().x + getParent().getWidth() + ABSTAND, getParent().getLocation().y);
	}
}
