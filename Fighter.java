// The "Players" class.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for actionlistener

public class Fighter extends JApplet
{

    String name;
    
    int health2;
    
    int health;
    
    int punchDam;
    
    int kickDam;
    
    int duckDam;
    
    int specialDam;
    
    //ImageIcon p;

    public Fighter ()
    {

	//this.name = name;

    }

//100 each cant hear u 


    public void punch (int health)
    {
	health -= 8;
	health2 = health;
    }


    public void duck (int health)
    {
	health -= 6;
	health2 = health;
    }


    public void kick (int health)
    {
	health -= 10;
	health2 = health;
    }


    public void Super (int health)
    {
	health -= 20;
	health2 = health;
    }


    public void setHealth (int health)
    {
	health2 = health;
    }


    public int getHealth ()
    {
	return health2;
    }






} // Players class
