import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class RulesWindow extends BaseFrame {
	public RulesWindow() {
		super("Règles du jeu", 800, 600);
	}

	@Override
	public void setContent() {
		// Load html rules from a file
		String rules="";
		try (BufferedReader reader = new BufferedReader(new FileReader("texts/rules_html"))) {
			rules = reader.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TextPane which contains the rules (html)
		JTextPane rulesTextPane = new JTextPane();
		rulesTextPane.setContentType("text/html"); 	// to interpret content as html and not text
		rulesTextPane.setEditable(false);	// Not editable (read only)
		rulesTextPane.setText(rules);		// Load html String
		rulesTextPane.setOpaque(false);		// Transparent
		rulesTextPane.setCaretPosition(0);	// Force scroll to top
		
		// ScrollPane to be able to "scroll"
		JScrollPane scrollPane = new JScrollPane(rulesTextPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(false); 		// Transparent
		scrollPane.getViewport().setOpaque(false); // Area that shows textPane transparent 
		scrollPane.setBorder(null);			// No borders
		scrollPane.getVerticalScrollBar().setUnitIncrement(5); // set scroll speed (unit increment)

		// Layout for rulesPanel
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(scrollPane);
	}
}
