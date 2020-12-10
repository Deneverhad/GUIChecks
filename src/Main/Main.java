package Main;

import javax.swing.*;
import java.awt.*;

public class Main {
	
	public static void main(String[] args){
		EventQueue.invokeLater(() ->
		{
			JFrame frame = new Ramka();
			frame.setVisible(true);
		});
	}
}
