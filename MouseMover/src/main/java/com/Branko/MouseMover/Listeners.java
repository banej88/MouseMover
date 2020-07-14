package com.Branko.MouseMover;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Listeners implements ActionListener {
			
				
				private JButton start;
				private JTextField seconds;
				private JCheckBox cb;
				private int sec;
				
				Thread pocetak;
	
				public Listeners(JButton start,JCheckBox cb,JTextField seconds) {
					
					this.start=start;
					this.cb=cb;
					this.seconds=seconds;
					
					
					
				}
	
	
				public void actionPerformed(ActionEvent ae) {
						
					
					
					
						if(ae.getSource()==start) {
								
								
						    if(pocetak!=null && pocetak.isAlive()){
						    	
							pocetak.stop();
							start.setBackground(Color.GRAY);
							
						    }else {
						    	
						    	start();
						    }
							
						}
								
					
					
				}
				
				public void start() {
					
					
				pocetak = new Thread(new Runnable() {
					
					public void run() {
						
						try {
							
							while(true) {
							
							start.setBackground(Color.red);
							sec = Integer.parseInt(seconds.getText());	
							sec=sec*1000;
							Robot branko = new Robot();
							
							if(cb.isSelected()) {		
								branko.mouseMove(MouseInfo.getPointerInfo().getLocation().x+100, MouseInfo.getPointerInfo().getLocation().y+100);	
								branko.mousePress(InputEvent.BUTTON1_MASK);
								try{pocetak.sleep(250);}catch(InterruptedException e){}
								branko.mouseRelease(InputEvent.BUTTON1_MASK);
								
							}else {
								
								branko.mouseMove(MouseInfo.getPointerInfo().getLocation().x+1, MouseInfo.getPointerInfo().getLocation().y+1);	
								
							}	
								
								try {
									
								pocetak.sleep(sec);
								
								}catch(Exception e) {
									
									e.printStackTrace();
								}
								
								
							}
								
						}
						catch (AWTException e) {
							
							e.printStackTrace();
						}
							
						
					}
					
				});	
				pocetak.start();	
					
				}

}
