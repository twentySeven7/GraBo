import de.fhwgt.dionarap.model.events.DionaRapChangedEvent;
import de.fhwgt.dionarap.model.events.GameStatusEvent;
import de.fhwgt.dionarap.model.listener.DionaRapListener;

public class ListenerModel implements DionaRapListener{

	private Hauptfenster hauptfenster;
	private Spielflaeche spielflaeche;

	public ListenerModel(Hauptfenster _hauptfenster, Spielflaeche _spielflaeche) {
		hauptfenster = _hauptfenster;
		spielflaeche = _spielflaeche;
	}

	@Override
	public void modelChanged(DionaRapChangedEvent arg0) {
		hauptfenster.repaintGame();

	}

	@Override
	public void statusChanged(GameStatusEvent arg0) {
		// TODO Auto-generated method stub

	}

}
