import java.awt.Rectangle;

import javax.swing.JFrame;
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
		hauptfenster = (Hauptfenster) parent;
		Rectangle navigatorPostion = parent.getBounds();
		this.setLocation((int) (navigatorPostion.getX() + parent.getWidth() + ABSTAND), (int) navigatorPostion.getY());

		Tastatur tastatur = new Tastatur();
		this.add(tastatur);
		this.pack();
		this.setVisible(true);

	}
}
