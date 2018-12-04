import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.fhwgt.dionarap.controller.DionaRapController;

public class ListenerKeyNum implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		Hauptfenster hauptfenster = (Hauptfenster) e.getSource();
		DionaRapController dioanaRapController = hauptfenster.getDionaRapController();
		if(e.getKeyChar() == '5') {
			dioanaRapController.shoot();
			System.out.println("Shoot");
		}else if(e.getKeyChar() >= '1' && e.getKeyChar() <= '9') {
			dioanaRapController.movePlayer(Character.getNumericValue(e.getKeyChar()));
			System.out.println("Move" + e.getKeyChar());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
