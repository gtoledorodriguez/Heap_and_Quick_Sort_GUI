package heapandquick;

public class GUIRunner {

	public static void main(String[] args) {
		// New Session
		Session session = new Session();
		// New GUI
		SortGUI gui = new SortGUI(session);
		// Display
		gui.display();
	}

}
