import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Souris extends MouseAdapter {
	Cliquable c;
	
	Souris(Cliquable c) {
		this.c = c;
	}
	
	/*
	// Pour les clics en dehors des Cliquables
	Souris(Jeu jeu) {
        this(null, jeu);
    }
    */

    public void mouseClicked(MouseEvent m) {  	
		System.out.println("clic "+m);
    }
}
