package testpackage;
import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;    // Using Swing's components and containers
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.Box;
//import testpackage.ResizeRectangle.ShapeResizeHandler;

//import testpackage.ResizeRectangle.ShapeResizeHandler;

@SuppressWarnings("serial")
public class Testclass extends JFrame {
	 private int SIZE = 10;
	  private Rectangle2D[] points = { new Rectangle2D.Double(50, 50,SIZE, SIZE), new Rectangle2D.Double(150, 200,SIZE, SIZE) };
	  String[] shapeItems = new String[] {"Rectangle", "Oval","RoundedRectangle"};
	  String[] fontstyleItems = new String[] {"Plain","Italic", "Bold","Bold&Italic"};
	  //private Ellipse2D[] circle= {new Ellipse2D.Double(50, 50,SIZE, SIZE), new Ellipse2D.Double(150, 100,SIZE, SIZE) };
	  Rectangle2D rect = new Rectangle2D.Double();	
	  Ellipse2D ell = new Ellipse2D.Double();
	  RoundRectangle2D roundrect=new RoundRectangle2D.Double();

	  ShapeResizeHandler ada = new ShapeResizeHandler();
	  

 
   public static final int CANVAS_WIDTH = 300;
   public static final int CANVAS_HEIGHT = 300;
 
   
   private JTextField t;
   private Font f;
   private int fontstyle = Font.PLAIN;
   private DrawCanvas canvas; 
   private String Message ="Hello World";
   private JButton Foregroundcolor, Backgroundcolor,bold,italic,plain,bolditalic;
   private JLabel lMessage,lFontStyle,lShape,lTextSize;
   private JButton Rectangle,Oval,RoundedRectangle;
   private Color c = Color.BLACK;
   private Color c1 = Color.RED;
   private int size = 10,X1= 100,Y1 = 100;
   private String shape = "RECT";
   public Testclass() {
      
      JPanel Panel = new JPanel(new GridBagLayout());
      GridBagConstraints z = new GridBagConstraints();
      //BoxLayout boxlayout = new BoxLayout(Panel, BoxLayout.Y_AXIS);
     Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
     //JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JPanel Panel1 = new JPanel(new FlowLayout());
      DocumentListener dl = new DocumentListener() {
  	    
	    
		@Override	
		public void insertUpdate(DocumentEvent e) {
			//System.out.println("I was here");
			// TODO Auto-generated method stub
			Message = t.getText();
			//t.getText().length()>
			canvas.repaint();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			Message = t.getText();
			canvas.repaint();
		
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			Message = t.getText();
			canvas.repaint();
			
		}
		
      };
      
      lMessage=new JLabel("Message :");
      Panel.add(lMessage);
      Panel.add(Box.createRigidArea(new Dimension(0,5)));
      
      t =new JTextField(10);
      t.setAlignmentX(Component.LEFT_ALIGNMENT);
     // t.setBounds(128, 28, 50, 20);
      //t.setColumns(6);
      t.setMaximumSize( t.getPreferredSize() );
     Panel.add(t);
     t.getDocument().addDocumentListener(dl); 	
     Panel.add(Box.createRigidArea(new Dimension(0,5)));
      lFontStyle=new JLabel("Font Style:");
      Panel.add(lFontStyle);
      Panel.add(Box.createRigidArea(new Dimension(0,5)));
      JComboBox<String> fontstyleList = new JComboBox<>(fontstyleItems);
      fontstyleList.setAlignmentX(Component.LEFT_ALIGNMENT);
      Panel.add(fontstyleList);
      fontstyleList.setMaximumSize( fontstyleList.getPreferredSize() );
      //shapeList.setSelectedItem("R");
      
      fontstyleList.addActionListener(new ActionListener() {
    	  
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        JComboBox<String> combo = (JComboBox<String>) event.getSource();
    	        String selectedfontstyle = (String) combo.getSelectedItem();
    	 
    	        if (selectedfontstyle.equals("Plain")) {
    	        	fontstyle =Font.PLAIN; canvas.repaint();
    	        } else if (selectedfontstyle.equals("Italic")) {
    	            //System.out.println("Nice pick, too!");
    	        	fontstyle =Font.ITALIC; canvas.repaint();
    	        }
    	        else if(selectedfontstyle.equals("Bold"))
    	        {fontstyle =Font.BOLD; canvas.repaint(); }
    	        else if(selectedfontstyle.equals("Bold&Italic"))
    	        {fontstyle =Font.BOLD+Font.ITALIC; canvas.repaint(); }
    	    }
    	});
    
      
//      plain = new JButton("Plain");
//      Panel.add(plain);
//      plain.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//            fontstyle =Font.PLAIN; canvas.repaint(); }
//      });
//      
//      italic = new JButton("Italic");
//      Panel.add(italic);
//      italic.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//            fontstyle =Font.ITALIC; canvas.repaint(); }
//      });
//      
//      bold = new JButton("Bold");
//      Panel.add(bold);
//      bold.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//            fontstyle =Font.BOLD; canvas.repaint(); }
//      });
//      
//      bolditalic = new JButton("Bold&Italic");
//      Panel.add(bolditalic);
//      bolditalic.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//            fontstyle =Font.BOLD+Font.ITALIC; canvas.repaint(); }
//      });
      Panel.add(Box.createRigidArea(new Dimension(0,10)));
      lTextSize=new JLabel("Text Size:");
      Panel.add(lTextSize);
      Panel.add(Box.createRigidArea(new Dimension(0,10)));
//      
      SpinnerModel spinnerModel = new SpinnerNumberModel(size,10,30,1);
    	      JSpinner spinner = new JSpinner(spinnerModel);
    	      spinner.setAlignmentX(Component.LEFT_ALIGNMENT);
    	      spinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					size = (int) spinnerModel.getValue();
					canvas.repaint();
				}
    	      }); 
    	      spinner.setMaximumSize( spinner.getPreferredSize() );
    	      Panel.add(spinner);
    	      Panel.add(Box.createRigidArea(new Dimension(0,10)));
    	      
    	      Foregroundcolor = new JButton("Foregroundcolor");
    	      Foregroundcolor.setAlignmentX(Component.LEFT_ALIGNMENT);
    	      Foregroundcolor.setMaximumSize( Foregroundcolor.getPreferredSize() );
    	      Panel.add(Foregroundcolor);
    	      Foregroundcolor.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            c = JColorChooser.showDialog(Testclass.this,"Please choose a color",c);
    	             if(c == null)
    	             {
    	            	 c = c.BLACK;
    	             }
    	             canvas.repaint();
    	          }
    	      });
    	      Panel.add(Box.createRigidArea(new Dimension(0,10)));
    	      Backgroundcolor = new JButton("Backgroundcolor");
    	      Backgroundcolor.setAlignmentX(Component.LEFT_ALIGNMENT);
    	      Backgroundcolor.setMaximumSize( Backgroundcolor.getPreferredSize() );
    	      Panel.add(Backgroundcolor);
    	      Backgroundcolor.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            c1 = JColorChooser.showDialog(Testclass.this,"Please choose a color",c1);
    	             if(c1 == null)
    	             {
    	            	 c1 = c.RED;
    	             }
    	             canvas.repaint();
    	          }
    	      });
    	      Panel.add(Box.createRigidArea(new Dimension(0,10)));
    	      lShape=new JLabel("Shape:");
    	      Panel.add(lShape);
    	      Panel.add(Box.createRigidArea(new Dimension(0,10)));
    	      JComboBox<String> shapeList = new JComboBox<>(shapeItems);
    	      shapeList.setAlignmentX(Component.LEFT_ALIGNMENT);
    	      shapeList.setMaximumSize( shapeList.getPreferredSize() );
    	      Panel.add(shapeList);
    	      //shapeList.setSelectedItem("R");
    	      
    	      shapeList.addActionListener(new ActionListener() {
    	    	  
    	    	    @Override
    	    	    public void actionPerformed(ActionEvent event) {
    	    	        JComboBox<String> combo = (JComboBox<String>) event.getSource();
    	    	        String selectedshape = (String) combo.getSelectedItem();
    	    	 
    	    	        if (selectedshape.equals("Rectangle")) {
    	    	        	 shape ="RECT"; canvas.repaint();
    	    	        } else if (selectedshape.equals("Oval")) {
    	    	            //System.out.println("Nice pick, too!");
    	    	        	 shape ="OVAL"; canvas.repaint();
    	    	        }
    	    	        else if(selectedshape.equals("RoundedRectangle"))
    	    	        {shape = "ROUNDRECT"; canvas.repaint(); }
    	    	    }
    	    	});
    	      
    	      
//    	      Rectangle = new JButton("Rectangle");
//    	      Panel1.add(Rectangle);
//    	      Rectangle.addActionListener(new ActionListener() {
//    	            public void actionPerformed(ActionEvent evt) {
//    	            shape ="RECT"; canvas.repaint(); }
//    	      });
//    	      
//    	      Oval = new JButton("Oval");
//    	      Panel1.add(Oval);
//    	      Oval.addActionListener(new ActionListener() {
//    	            public void actionPerformed(ActionEvent evt) {
//    	            shape ="OVAL"; canvas.repaint(); }
//    	      });
//    	      
//    	      RoundedRectangle = new JButton("RoundedRectangle");
//    	      Panel1.add(RoundedRectangle);
//    	      RoundedRectangle.addActionListener(new ActionListener() {
//    	            public void actionPerformed(ActionEvent evt) {
//    	            shape = "ROUNDRECT"; canvas.repaint(); }
//    	      });
      
//    	      SpinnerModel spinnerModel1 = new SpinnerNumberModel(100,50,300,1);
//    	      JSpinner spinner1 = new JSpinner(spinnerModel1);
//    	      spinner1.addChangeListener(new ChangeListener() {
//				@Override
//				public void stateChanged(ChangeEvent e) {
//					// TODO Auto-generated method stub
//					X1 = (int) spinnerModel1.getValue();
//					canvas.repaint();
//				}
//    	      }); 
    	      
//    	      Panel1.add(spinner1);
    	      
//    	      SpinnerModel spinnerModel2 = new SpinnerNumberModel(100,50,300,1);
//    	      JSpinner spinner2 = new JSpinner(spinnerModel2);
//    	      spinner2.addChangeListener(new ChangeListener() {
//				@Override
//				public void stateChanged(ChangeEvent e) {
//					// TODO Auto-generated method stub
//					Y1 = (int) spinnerModel2.getValue();
//					canvas.repaint();
//				}
//    	      }); 
//    	      Panel1.add(spinner2);
//    	      
      // Set up a custom drawing JPanel
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      // Add both panels to this JFrame's content-pane
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.EAST);
      cp.add(Panel, BorderLayout.WEST);
      //cp.add(Panel1, BorderLayout.SOUTH);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
      setTitle("ShowShape");
      pack();           // pack all the components in the JFrame
      setVisible(true); // show it
      requestFocus();   // set the focus to JFrame to receive KeyEvent
   } 
   
      
   class DrawCanvas extends JPanel {
	  
		  public DrawCanvas() {
		    addMouseListener(ada);
		    addMouseMotionListener(ada);
		  }

	   
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         f = new Font("TimesRoman",fontstyle,size);
         setFont(f);
         setBackground(c1);
         g.setColor(c);
         FontMetrics fm = g.getFontMetrics();
		    int x = (getWidth() - fm.stringWidth(Message))/2;
		    int y = (getHeight()/2)+ fm.getDescent();
		    Graphics2D g2 = (Graphics2D) g;

		    for (int i = 0; i < points.length; i++) {
		      g2.fill(points[i]);
		    }
		    
         
         if(shape.equals("OVAL"))
			{
        	 ell.setFrame(points[0].getX(), points[0].getY(),
//        			    s.setRect(points[0].getCenterX(), points[0].getCenterY(),
        			        (points[1].getX()-points[0].getX()),
        			        Math.abs(points[1].getY()- points[0].getY()));

        			    g2.draw(ell);
        			    int testx = (int)(points[0].getX() + (Math.abs(points[1].getX()-points[0].getX()) - fm.stringWidth(Message)) / 2);
        			    int testy = (int)(points[0].getY() + ((Math.abs(points[1].getY()- points[0].getY()) - fm.getHeight()) / 2) + fm.getAscent());
				
        			    g.drawString(Message,testx,testy);
				
				//g.drawString(Message,(int)Math.round((points[1].getCenterX()+points[0].getCenterX())/2),(int)Math.round((points[1].getCenterY()+points[0].getCenterY())/2));
			}
			else if(shape.equals("RECT"))
			{
				 rect.setRect(points[0].getX(), points[0].getY(),
//	        			    s.setRect(points[0].getCenterX(), points[0].getCenterY(),
	        			        Math.abs(points[1].getX()-points[0].getX()),
	        			        Math.abs(points[1].getY()- points[0].getY()));

	        			    g2.draw(rect);
	        			    int testx = (int)(points[0].getX() + (Math.abs(points[1].getX()-points[0].getX()) - fm.stringWidth(Message)) / 2);
	        			    int testy = (int)(points[0].getY() + ((Math.abs(points[1].getY()- points[0].getY()) - fm.getHeight()) / 2) + fm.getAscent());
				
	        			    g.drawString(Message,testx,testy);
	        			    //g.drawString(Message,(int)Math.round((points[1].getCenterX()+points[0].getCenterX())/2),(int)Math.round((points[1].getCenterY()+points[0].getCenterY())/2));
			}
			else if(shape.equals("ROUNDRECT"))
			{
				 roundrect.setRoundRect(points[0].getX(), points[0].getY(),
//	        			    s.setRect(points[0].getCenterX(), points[0].getCenterY(),
	        			        Math.abs(points[1].getX()-points[0].getY()),
	        			        Math.abs(points[1].getY()- points[0].getY()),40,40);

	        			    g2.draw(roundrect);
	        			    int testx = (int)(points[0].getX() + (Math.abs(points[1].getX()-points[0].getX()) - fm.stringWidth(Message)) / 2);
	        			    int testy = (int)(points[0].getY() + ((Math.abs(points[1].getY()- points[0].getY()) - fm.getHeight()) / 2) + fm.getAscent());
	        			    //g.drawString(Message,(int)Math.round((points[1].getCenterX())+points[0].getCenterX())/2,(int)Math.round((points[1].getCenterY()+points[0].getCenterY())/2));
	        			    g.drawString(Message,testx,testy);
				
				
	        			   // g.drawString(Message,(int)Math.round((points[1].getCenterX()+points[0].getCenterX())/2),(int)Math.round((points[1].getCenterY()+points[0].getCenterY())/2));
	        			    
			}
			else
			{
				 rect.setRect(points[0].getX(), points[0].getY(),
//	        			    s.setRect(points[0].getCenterX(), points[0].getCenterY(),
	        			        Math.abs(points[1].getX()-points[0].getX()),
	        			        Math.abs(points[1].getY()- points[0].getY()));
				 			//int X1centre=Math.sqrt(a)
	        			    g2.draw(rect);
	        			    int testx = (int)(points[0].getX() + (Math.abs(points[1].getX()-points[0].getX()) - fm.stringWidth(Message)) / 2);
	        			    int testy = (int)(points[0].getY() + ((Math.abs(points[1].getY()- points[0].getY()) - fm.getHeight()) / 2) + fm.getAscent());
	        			    //g.drawString(Message,(int)Math.round((points[1].getCenterX())+points[0].getCenterX())/2,(int)Math.round((points[1].getCenterY()+points[0].getCenterY())/2));
	        			    g.drawString(Message,testx,testy);
			}
         
         //System.out.println("W"+points[1].getCenterX()-points[0].getCenterX());
         //System.out.println("H"+points[1].getCenterY()-points[0].getCenterY());
      if(fm.stringWidth(Message) > (int)Math.round((points[1].getMaxX())))
      {
    	  
    	  System.out.println("Hello");
    	  size = 10;
    	  f = new Font("TimesRoman",fontstyle,size);
          setFont(f);
      }
      
      }
   }
   public class ShapeResizeHandler extends MouseAdapter {
	   //public ShapeResizeHandler()
//	    Rectangle2D r = new Rectangle2D.Double(0,0,SIZE,SIZE);
	    private int pos = -1;
	    public void mousePressed(MouseEvent event) {
	      Point p = event.getPoint();
	      System.out.println(points.length);
	      for (int i = 0; i < points.length; i++) {
	        if (points[i].contains(p)) {
	          pos = i;
	          return;
	        }
	      }
	    }

	    public void mouseReleased(MouseEvent event) {
	      pos = -1;
	    }

	    public void mouseDragged(MouseEvent event) {
//	    	/System.out
	      if (pos == -1)
	      {
	    	  //System.out.println("I was here");
	        return;
	      }

	      points[pos].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),
	          points[pos].getHeight());
	      repaint();
	    }
	  }
  

 
   // The entry main() method
   public static void main(String[] args) {
      // Run GUI codes on the Event-Dispatcher Thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Testclass();
            }
      });
   }
}
