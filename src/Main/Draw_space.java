package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Draw_space extends JPanel {
	private Pole[][] shapes = new Pole[17][13];
	
	
	private final int[] domek = {0, 1, 2, 3};
	
	
	public Draw_space(int width, int height) {
		
		add();
	}
	
	/*
	 * W funkcji paintComponent wywoluje funkcje drawing
	 * ktora sluzy do narysowania figury wybranej przez uzytkownika
	 * zapisania jej i pokazania jej na panelu
	 */
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawing(g);
	}
	
	private Pole dodaj_punkt(float x, float y, float x1, float y1) {
		return new punkt(x, y, x1, y1);
	}
	
	private void drawing(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2));
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));
		
		for (int i = 0; i < 13; i++) {
			for (int j = 6; j <= 6 + Math.round((float) i / 2); j++) {
				{
					if(i<4) shapes[i][j].set_color(Color.BLUE);
					if(i%2 ==0 && j>9  && i>8 ) shapes[i][j].set_color(Color.YELLOW);
					if(i%2!=0 && j>9  && i>9 ) shapes[i][j].set_color(Color.YELLOW);
					if(i==12 && j==9)  shapes[i][j].set_color(Color.YELLOW);
					else if(i==9 && j==11) shapes[i][j].set_color(Color.YELLOW);
					
					g2.setPaint(shapes[i][j].getcolor());
					g2.fill(shapes[i][j]);
					g2.setPaint(Color.BLACK);
					g2.draw(shapes[i][j]);
				}
			}
			for (int y = 5; y > 5 - Math.floor((float) i / 2); y--) {
				if(i<4) shapes[i][y].set_color(Color.BLUE);
				if(i%2 ==0 && y<3  && i>=10 ) shapes[i][y].set_color(Color.CYAN);
				if(i%2!=0 && y<4 && i>=10 ) shapes[i][y].set_color(Color.CYAN);
				if(i==12 && y==3)  shapes[i][y].set_color(Color.CYAN);
				else if(i==9 && y==2) shapes[i][y].set_color(Color.CYAN);
				g2.setPaint(shapes[i][y].getcolor());
				g2.fill(shapes[i][y]);
				g2.setPaint(Color.BLACK);
				g2.draw(shapes[i][y]);
			}
		}
		
		for (int i = 4; i < 8; i++) {
			for (int j = 0; j < 8 - i; j++) {
				if (i <= 4) {
					shapes[i][j].set_color(Color.RED);
					g2.setPaint(shapes[i][j].getcolor());
					g2.fill(shapes[i][j]);
					g2.setPaint(Color.RED);
					g2.draw(shapes[i][j]);
				} else if (i == 7) {
					shapes[i][j + 2].set_color(Color.RED);
					g2.setPaint(shapes[i][j + 2].getcolor());
					g2.fill(shapes[i][j + 2]);
					g2.setPaint(Color.RED);
					g2.draw(shapes[i][j + 2]);
				} else {
					shapes[i][j + 1].set_color(Color.RED);
					g2.setPaint(shapes[i][j + 1].getcolor());
					g2.fill(shapes[i][j + 1]);
					g2.setPaint(Color.RED);
					g2.draw(shapes[i][j + 1]);
				}
			}
			
			for (int h = 9; h < 17 - i; h++) {
				if (i <= 4) {
					shapes[i][h].set_color(Color.BLACK);
					g2.setPaint(shapes[i][h].getcolor());
					g2.fill(shapes[i][h]);
					g2.setPaint(Color.BLACK);
					g2.draw(shapes[i][h]);
				} else if (i == 7) {
					shapes[i][h + 2].set_color(Color.BLACK);
					g2.setPaint(shapes[i][h + 2].getcolor());
					g2.fill(shapes[i][h + 2]);
					g2.setPaint(Color.BLACK);
					g2.draw(shapes[i][h + 2]);
				} else {
					shapes[i][h + 1].set_color(Color.BLACK);
					g2.setPaint(shapes[i][h + 1].getcolor());
					g2.fill(shapes[i][h + 1]);
					g2.setPaint(Color.BLACK);
					g2.draw(shapes[i][h + 1]);
				}
			}
			
		}
		
		for (int j = 5; j < 9; j++) {
			for( int i=13; i<=21-j;i++) {
				if (i< 15) {
				shapes[i][j].set_color(Color.GREEN);
				g2.setPaint(shapes[i][j].getcolor());
				g2.fill(shapes[i][j]);
				g2.setPaint(Color.GREEN);
				g2.draw(shapes[i][j]);
				}
				else {
					shapes[i][j+1].set_color(Color.GREEN);
					g2.setPaint(shapes[i][j+1].getcolor());
					g2.fill(shapes[i][j+1]);
					g2.setPaint(Color.GREEN);
					g2.draw(shapes[i][j+1]);
				}
			}
	}
		
		/*for(int i=0;i<shapes.length;i++)
		{
			for(int j=0; j<shapes[i].length;j++){
				g2.setPaint(shapes[i][j].getcolor());
				g2.fill(shapes[i][j]);
				g2.setPaint(Color.PINK);
				g2.draw(shapes[i][j]);
			}
			
			}*/
	
	//if (startDrag != null && endDrag != null)
	//{
	//g2.setPaint(Color.LIGHT_GRAY);
	//}
	
	}
		
	private void add(){
		for(int i=0;i<shapes.length;i++)
		{
			for(int j=0; j<shapes[i].length;j++){
				
				 if((i+1)%2==0)shapes [i][j] = dodaj_punkt( 10+ j*40, 20+ i*30, (float) 20, (float) 20);
				 else shapes[i][j] = dodaj_punkt( 30+ j*40, 20+ i*30, (float) 20, (float) 20);
			}
		}
	}
	
}
