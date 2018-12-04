import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.fhwgt.dionarap.controller.DionaRapController;

public class ListenerWaffe implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		Hauptfenster hauptfenster = (Hauptfenster) button.getTopLevelAncestor().getParent();
		DionaRapController dionaRapController = (DionaRapController) hauptfenster.getDionaRapController();

		dionaRapController.shoot();

		System.out.println("Shoot");

	}

}
