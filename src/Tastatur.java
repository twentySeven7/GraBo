import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Tastatur Initialisierung der Tastatur, abgeleitet von JPanel
 *
 * @author Simon Hülsing
 * @version 1.0
 */

public class Tastatur extends JPanel {
	/**
	 * Konstruktor der Steuerflaeche vom Typ JPanel
	 * Legt den Layout-Manager fest und ruft die Methode addJButtons() auf und setzt einen roten Rand
	 */
	public Tastatur() {
		this.setLayout(new GridLayout(3, 3));
		addJButtons();
		this.setVisible(true);
		this.setBorder(BorderFactory.createLineBorder(Color.RED));
	}
/**
 * Methode, fuegt alle JButtons ein
 */
	private void addJButtons() {
		JButton[] buttons = new JButton[9];
		for (int i = 1; i < 10; i++) {
			buttons[i - 1] = new JButton(Integer.toString(i));
			buttons[i - 1].setPreferredSize(new Dimension(50, 50));
			this.add(buttons[i - 1]);
		}
	}
}
