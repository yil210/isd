//Yixiao Li(Yil210)'s Assignment 2, 09/11/2018
import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class ShowShape extends JApplet
{ 
    private String theMsg = "Default";
    private String theShape = "RECT";
    private String theColor = "red";
    private String theBGColor = "black";
    private int theX = 200;
    private int theY = 200;
    private String theFTStyle = "BOLD";
    private int theFTSize = 12;   

    public void init()
    {
        // try to read in the parameters from the HTML file
        String tempMsg = this.getParameter("MESSAGE"); 
        String tempShape = this.getParameter("SHAPE");
        String tempColor = this.getParameter("COLOR");
        String tempBGColor = this.getParameter("BGCOLOR");
        String tempX = this.getParameter("X");
        String tempY = this.getParameter("Y");
        String tempFTStyle = this.getParameter("FTSTYLE");
        String tempFTSize = this.getParameter("FTSIZE");
        
        if ((tempMsg!=null)&&(tempShape!=null)&&(tempColor!=null)&&
            (tempBGColor!=null)&&(tempFTStyle!=null)
        )
        {
            // None of the parameters are blank
            this.theMsg = tempMsg;
            this.theShape = tempShape;
            this.theColor = tempColor;
            this.theBGColor = tempBGColor;
            this.theX = (new Integer(tempX)).intValue();
            this.theY = (new Integer(tempY)).intValue();
            this.theFTStyle = tempFTStyle;
            this.theFTSize = (new Integer(tempFTSize)).intValue();
        }
    }

    public void paint(Graphics g)
    {
        int fontStyle = 0;
        Color c,bgc;
        int wrongType1=0, wrongType2=0, wrongType3=0, wrongType4=0, wrongType5=0, wrongType6=0;
        switch(this.theFTStyle){
            case "REGULAR":
                fontStyle = Font.PLAIN;
                break;
            case "BOLD":
                fontStyle = Font.BOLD;
                break;
            case "ITALIC":
                fontStyle = Font.ITALIC;
                break;
            case "BOLD ITALIC":
                fontStyle = Font.BOLD+Font.ITALIC;
                break;
            default:
                wrongType1 = 1;
                fontStyle = Font.BOLD;
                break;
        }
        switch(this.theBGColor){
            case "black":
                bgc = Color.black;
                break;
            case "blue":
                bgc = Color.blue;
                break;
            case "cyan":
                bgc = Color.cyan;
                break;
            case "darkGray":
                bgc = Color.darkGray;
                break;
            case "gray":
                bgc = Color.gray;
                break;
            case "green":
                bgc = Color.green;
                break;
            case "lightGray":
                bgc = Color.lightGray;
                break;
            case "magenta":
                bgc = Color.magenta;
                break;
            case "orange":
                bgc = Color.orange;
                break;
            case "pink":
                bgc = Color.pink;
                break;
            case "red":
                bgc = Color.red;
                break;
            case "white":
                bgc = Color.white;
                break;
            case "yellow":
                bgc = Color.yellow;
                break;
            default:
                wrongType2 = 1;
                bgc = Color.black;
                break;
        }
        switch(this.theColor){
            case "black":
                c = Color.black;
                break;
            case "blue":
                c = Color.blue;
                break;
            case "cyan":
                c = Color.cyan;
                break;
            case "darkGray":
                c = Color.darkGray;
                break;
            case "gray":
                c = Color.gray;
                break;
            case "green":
                c = Color.green;
                break;
            case "lightGray":
                c = Color.lightGray;
                break;
            case "magenta":
                c = Color.magenta;
                break;
            case "orange":
                c = Color.orange;
                break;
            case "pink":
                c = Color.pink;
                break;
            case "red":
                c = Color.red;
                break;
            case "white":
                c = Color.white;
                break;
            case "yellow":
                c = Color.yellow;
                break;
            default:
                wrongType3 = 1;
                c = Color.red;
                break;
        }
        if((this.theX > 300)||(this.theX == 300)){
            wrongType4 = 1;
            this.theX = 200;

        }
        if((this.theY > 150)||(this.theY == 150)){
            wrongType5 = 1;
            this.theY = 100;
        }

        if(this.theFTSize > (this.theX / 8)){
            wrongType6 = 1;
            this.theFTSize = (int)(this.theX / 8);
        }

        g.setColor(bgc);
        g.drawRect(0, 0, 300, 150);
        g.fillRect(0, 0, 300, 150);

        int x1 = (300 - this.theX) / 2;
        int y1 = (150 - this.theY) / 2;

        Font font = new Font("Serif", fontStyle, this.theFTSize);
        FontMetrics fm = g.getFontMetrics(font);
        int FHeight = fm.getHeight();    
        int FWidth = fm.stringWidth(this.theMsg);
        int x = x1 + (this.theX - FWidth) / 2;
        int y = y1 + ((this.theY - FHeight)/ 2) + fm.getAscent();
        g.setFont(font);
        g.setColor(c);
        g.drawString(this.theMsg,x,y);

        if(this.theShape.equals("OVAL")){
            g.drawOval(x1, y1, this.theX, this.theY);
        }
        else if(this.theShape.equals("RECT")){
            g.drawRect(x1, y1, this.theX, this.theY);
        }
        else if(this.theShape.equals("ROUNDRECT")){
            g.drawRoundRect(x1, y1, this.theX, this.theY, 10,10);
        }
        else{
            g.setFont(new Font("Serif", Font.BOLD, 12));
            g.drawString("Wrong Shape. Adjusted",10,95);
            g.drawRect(x1, y1, this.theX, this.theY);
        }

        g.setFont(new Font("Serif", Font.BOLD, 12));
        if(wrongType1 == 1){
            g.drawString("Wrong font style. Adjusted",10,40);
        }
        if(wrongType2 == 1){
            g.drawString("Wrong BG Color. Adjusted",10,110);
        }
        if(wrongType3 == 1){
            g.drawString("Wrong FS Color. Adjusted",10,125); 
        }
        if(wrongType4 == 1){
            g.drawString("Invalid X. Adjusted to Default 200",10,10);
        }
        if(wrongType5 == 1){
            g.drawString("Invalid Y. Adjusted to Default 100",10,25);
        }
        if(wrongType6 == 1){
            g.drawString("Text size too large. Adjusted to Default",10,140);
        }

    }
}