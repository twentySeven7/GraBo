import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ListenerFenster implements ComponentListener{

	private Navigator navigator;

	public ListenerFenster(Navigator nav) {
		navigator = nav;
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		this.navigator.setNavLocation();

	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub

	}

}
