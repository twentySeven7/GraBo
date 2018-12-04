import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.fhwgt.dionarap.controller.DionaRapController;

public class ListenerBewegung implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		Hauptfenster hauptfenster = (Hauptfenster) button.getTopLevelAncestor().getParent();
		DionaRapController dionaRapController = (DionaRapController) hauptfenster.getDionaRapController();

		dionaRapController.movePlayer(Integer.parseInt(button.getActionCommand()));
		System.out.println("Move" + button.getActionCommand());
	}

}
