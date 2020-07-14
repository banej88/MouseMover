package com.Branko.MouseMover;

import javax.swing.*;
import java.awt.*;

public class Gui implements Runnable{
	
					private JFrame frame;
					private JButton start;
					private JCheckBox cb;
					private JTextField seconds;
					private JLabel tekst;
					
					public void run() {
							
								
								frame = new JFrame("Mouse Mover");
								
								ImageIcon ic = new ImageIcon("Resources/frog.png");
								frame.setIconImage(ic.getImage());
								
								frame.setPreferredSize(new Dimension(300,150));
								
								frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
								
								createComponent(frame.getContentPane());
								
								frame.setLocationRelativeTo(null);
								
								frame.pack();
								
								frame.setVisible(true);
								
								frame.setResizable(false);

								
					}
					
					
					public void createComponent(Container container) {
							
							
						GridLayout b = new GridLayout(2,2);
						container.setLayout(b);
						start = new JButton("Start/Stop");
						start.setBackground(Color.GRAY);
						cb = new JCheckBox("Click included");
						tekst = new JLabel("Seconds Interval");
						seconds = new JTextField("10");
						container.add(tekst);
						container.add(cb);
						container.add(seconds);
						container.add(start);
						
						Listeners l = new Listeners(start,cb,seconds,tekst);
						start.addActionListener(l);
						
						
					}
					
					
					
		

}
