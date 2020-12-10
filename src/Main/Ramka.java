package Main;

import javax.swing.*;
import java.awt.*;

public class Ramka extends JFrame {
	int Height;
	int Width;
	public Ramka()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		this.Height = screenSize.height;
		this.Width = screenSize.width;
		setSize((Width /2 ), (Height /2));
		
		Draw_space panel = new Draw_space((Width /2 ),(Height /2));
		
		setLocationByPlatform(true);
		setResizable(true);
		setTitle("Plansza");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.WHITE);
		add(panel,BorderLayout.CENTER);
	}
}
