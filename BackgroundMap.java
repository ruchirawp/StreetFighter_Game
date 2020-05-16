import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BackgroundMap extends JPanel

{

    //Image background, health, kick, punch



    Image chosenBackground;
    Image background = Toolkit.getDefaultToolkit ().getImage ("background.gif");
    Image background2 = Toolkit.getDefaultToolkit ().getImage ("background3.gif");

    Image health = Toolkit.getDefaultToolkit ().getImage ("HealthBar.png");

    //minus damage
    Image ten = Toolkit.getDefaultToolkit ().getImage ("Damage10.jpg");
    Image six = Toolkit.getDefaultToolkit ().getImage ("Damage6.png");
    Image eight = Toolkit.getDefaultToolkit ().getImage ("Damage8.png");
    Image twenty = Toolkit.getDefaultToolkit ().getImage ("Damage20.png");

    //p1 actions
    Image stand = Toolkit.getDefaultToolkit ().getImage ("Stance.gif");
    Image punch = Toolkit.getDefaultToolkit ().getImage ("Punch.png");
    Image duck = Toolkit.getDefaultToolkit ().getImage ("Duck.png");
    Image kick = Toolkit.getDefaultToolkit ().getImage ("Kick.png");
    Image block = Toolkit.getDefaultToolkit ().getImage ("Block.png");
    Image special = Toolkit.getDefaultToolkit ().getImage ("Special.png");

    //p2 actions
    Image stand2 = Toolkit.getDefaultToolkit ().getImage ("Stance2.gif");
    Image punch2 = Toolkit.getDefaultToolkit ().getImage ("Punch2.png");
    Image duck2 = Toolkit.getDefaultToolkit ().getImage ("Duck2.png");
    Image kick2 = Toolkit.getDefaultToolkit ().getImage ("Kick2.png");
    Image block2 = Toolkit.getDefaultToolkit ().getImage ("Block2.png");
    Image special2 = Toolkit.getDefaultToolkit ().getImage ("Super2.png");

    //ending
    Image ko = Toolkit.getDefaultToolkit ().getImage ("K.O.png");
    Image SuperText = Toolkit.getDefaultToolkit ().getImage ("SuperText.png");

    String p1Name = "Player 1";
    String p2Name = "Player 2";
    Font font = new Font ("Rockwell", Font.PLAIN, 20);
    Font font2 = new Font ("Curlz MT Regular", Font.BOLD, 30);


    //Image[] backgrounds = new Image [4];
    //backgrounds [1] = background;

    int random = (int) (Math.random () * 2) + 1;


    String p1Status, p2Status;
    int p1Health, p2Health;

    int x1, y1, x2, y2, x3, y3, x4, y4, height;
    int width1, width2, width3, width4, totalWidth;

    boolean p1Win, p2Win;

    int tempHealth1 = 100;
    int tempHealth2 = 100;

    int p1SuperCounter = 0;
    int p2SuperCounter = 0;

    int superBarInterval = 93;

    boolean test;

    boolean restart = false;

    int tempP1Health = 100;
    int tempP2Health = 100;

    boolean p1Damage = false;
    boolean p2Damage = false;


    public BackgroundMap (String p1Status, String p2Status)
    {

	this.p1Status = p1Status;
	this.p2Status = p2Status;

	//player 1 image position
	x1 = 450;
	y1 = 200;

	//player 2 image position
	x2 = 920;
	y2 = 200;

	//position of p1 Health bar
	x3 = 0;
	y3 = 0;

	//position of p2 Health bar
	x4 = 0;
	y4 = 0;

	if (random == 1)
	{

	    chosenBackground = background;
	}
	else if (random == 2)
	{

	    chosenBackground = background2;

	}


    }


    public void status (String p1Status, String p2Status, int p1Health, int p2Health, boolean p1Win, boolean p2Win, int p1SuperCounter, int p2SuperCounter, String player1Name, String player2Name, boolean p1Damage, boolean p2Damage)
    {
	this.p1Status = p1Status;
	this.p2Status = p2Status;
	this.p1Health = p1Health;
	this.p2Health = p2Health;
	this.p1Win = p1Win;
	this.p2Win = p2Win;
	this.p1SuperCounter = p1SuperCounter;
	this.p2SuperCounter = p2SuperCounter;
	this.p1Damage = p1Damage;
	this.p2Damage = p2Damage;

	//gets names
	p1Name = player1Name;
	p2Name = player2Name;

	//dimensions of health bar
	height = 20;
	//MAKE WIDTH 500 SO WE CAN USE INTEGER IN ARGUMENTS FOR G.DRAW
	totalWidth = 500;

	width1 = totalWidth - (5 * (100 - p1Health));



	width2 = totalWidth - (5 * (100 - p2Health));

    }


    public void paintComponent (Graphics g)

    {

	super.paintComponent (g);



	g.drawImage (chosenBackground, 0, 0, this);
	g.drawImage (health, 90, 0, this);

	//adds player name to screen
	g.setFont (font);
	g.setColor (Color.white);
	g.drawString (p1Name, 320, 50);
	if (p2Name.length () <= 8)
	    g.drawString (p2Name, 1280, 50);
	else
	    g.drawString (p2Name, 1250, 50);

	g.setColor (Color.black);
	g.setFont (font2);
	g.drawString ("v.s", 815, 40);

	//fills behind health bar yellow
	g.setColor (Color.black);
	g.fillRect (281, 65, totalWidth, height);
	g.fillRect (900, 65, totalWidth, height);


	//p1 Health Bar
	//g.drawRect (5, 10, 200, 50); //draws a rectangle
	g.setColor (Color.red);
	g.fillRect (281, 65, width1, height); // fills it with the colour red


	//p2 Health Bar
	g.setColor (Color.blue);
	g.fillRect (900 + (totalWidth - width2), 65, (width2 + 2), height); // fills it with the colour blue


	if (p1Win != true && p2Win != true)
	{
	    //Player 1 actions


	    if (p1Status.equals ("Default"))
	    {
		g.drawImage (stand, x1, y1 + 100, this);

	    }
	    else if (p1Status.equals ("Punch"))
	    {

		g.drawImage (punch, x1 + 50, y1 + 100, this);
		if (p2Damage == true)
		    g.drawImage (eight, x2 + 70, y2, this);

	    }
	    else if (p1Status.equals ("Duck"))
	    {
		g.drawImage (duck, x1, y1 + 100, this);
		if (p2Damage == true)
		    g.drawImage (six, x2 + 100, y2, this);

	    }
	    else if (p1Status.equals ("Kick"))
	    {
		g.drawImage (kick, x1 + 50, y1 + 100, this);
		if (p2Damage == true)
		    g.drawImage (ten, x2 + 100, y2, this);

	    }

	    else if (p1Status.equals ("Super"))
	    {
		g.drawImage (special, x1 - 50, y1 + 140, this);

		if (p1Status.equals ("Super") && p2Status.equals ("Block") && p2Damage == true)
		{
		    g.drawImage (ten, x2 + 100, y2, this);
		    p1SuperCounter = 0;

		}
		else if (p2Damage == true && p2Status != "Block")
		{
		    g.drawImage (twenty, x2 + 100, y2, this);
		    p1SuperCounter = 0;
		}

	    }
	    else if (p1Status.equals ("Block"))
	    {
		g.drawImage (block, x1 + 50, y1 + 100, this);
		if (p1Damage == true)
		    g.drawImage (ten, x1 + 100, y1, this);

	    }
	    //Player 2 Actions
	    //
	    if (p2Status.equals ("Default"))
	    {
		g.drawImage (stand2, x2 + 70, y2 + 100, this);

	    }
	    else if (p2Status.equals ("Punch"))
	    {

		g.drawImage (punch2, x2 - 100, y2 + 98, this);
		if (p1Damage == true)
		    g.drawImage (eight, x1 + 100, y1, this);


	    }
	    else if (p2Status.equals ("Duck"))
	    {
		g.drawImage (duck2, x2 - 50, y2 + 100, this);
		if (p1Damage == true)
		    g.drawImage (six, x1 + 110, y1, this);

	    }
	    else if (p2Status.equals ("Kick"))
	    {
		g.drawImage (kick2, x2 - 10, y2 + 75, this);
		if (p1Damage == true)
		    g.drawImage (ten, x1 + 100, y1, this);

	    }

	    else if (p2Status.equals ("Super"))
	    {

		g.drawImage (special2, x2 - 50, y2 + 105, this);
		
		if (p2Status.equals ("Super") && p1Status.equals ("Block") && p1Damage == true)
		{
		    g.drawImage (ten, x1 + 100, y1, this);
		    p2SuperCounter = 0;

		}
		else if (p1Damage == true && p1Status != "Block")
		{
		    g.drawImage (twenty, x1 + 100, y1, this);
		    p2SuperCounter = 0;
		}

	    }

	    else if (p2Status.equals ("Block"))
	    {

		g.drawImage (block2, x2, y2 + 100, this);
		if (p1Damage == true)
		    g.drawImage (ten, x2 + 100, y2, this);

	    }
	    //SUPER BAR PLAYER 1
	    g.setColor (Color.white);
	    g.fillRect (498, 108, 278, 8); // fills it with the colour red


	    g.setColor (Color.green);
	    if (p1SuperCounter < 3)
	    {
		g.fillRect (498, 108, p1SuperCounter * superBarInterval, 8); // fills it with the colour red
	    }


	    else if (p1SuperCounter >= 3)
	    {
		g.fillRect (498, 108, 278, 8); // fills it with the colour red
		g.drawImage (SuperText, 150, 80, this);
	    }

	    g.setColor (Color.black);
	    g.fillRect (590, 108, 2, 8);
	    g.fillRect (682, 108, 2, 8);


	    //super bar2
	    g.setColor (Color.white);
	    g.fillRect (904, 108, 278, 8); // fills it with the colour red

	    g.setColor (Color.yellow);
	    if (p2SuperCounter < 3)
	    {
		g.fillRect (904, 108, p2SuperCounter * superBarInterval, 8); // fills it with the colour red
	    }


	    else if (p2SuperCounter >= 3)
	    {
		g.fillRect (904, 108, 278, 8); // fills it with the colour red
		g.drawImage (SuperText, 1200, 80, this);
	    }


	    g.setColor (Color.black);
	    g.fillRect (996, 108, 2, 8);
	    g.fillRect (1088, 108, 2, 8);

	}


	if (p1Win == true && p2Win == true)
	{

	    g.drawImage (ko, 300, 100, this);
	    g.setColor (Color.white);
	    g.fillRect (498, 108, 278, 8); // fills it with the colour red
	    g.setColor (Color.white);
	    g.fillRect (904, 108, 278, 8); // fills it with the colour red



	}


	else if (p1Win == true)
	{
	    g.drawImage (ko, 700, 100, this);
	    g.drawImage (stand, x1, y1 + 100, this);
	    g.setColor (Color.white);
	    g.fillRect (498, 108, 278, 8); // fills it with the colour red
	    g.setColor (Color.white);
	    g.fillRect (904, 108, 278, 8); // fills it with the colour red


	}


	else if (p2Win == true)
	{
	    g.drawImage (ko, 50, 100, this);
	    g.drawImage (stand2, x2 + 70, y2 + 100, this);
	    g.setColor (Color.white);
	    g.fillRect (498, 108, 278, 8); // fills it with the colour red
	    g.setColor (Color.white);
	    g.fillRect (904, 108, 278, 8); // fills it with the colour red


	}
    }
} // end Gamecanvas


