package windows;

public class InCheckmateWindow extends BaseFrame {
	public InCheckmateWindow() {
		super("Checkmate", 600, 120);
		this.setContent();
	}

	@Override
	public void setContent() {
		contentPanel.setVisible(false);
	}
}
