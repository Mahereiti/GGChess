package windows;

public class InCheckWindow extends BaseFrame {

	public InCheckWindow() {
		super("Echec", 600, 120);
		this.setContent();
	}

	@Override
	public void setContent() {
		contentPanel.setVisible(false);
	}
}
