package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public interface IHome {

	void mouseClicked(MouseEvent e);
	void mousePressed(MouseEvent e);
	void mouseReleased(MouseEvent e);
	void mouseEntered(MouseEvent e);
	void mouseExited(MouseEvent e);
	void actionPerformed(ActionEvent e);
}
