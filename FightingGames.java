// The "FightingGame" class.
//RUCHIRA AND SHAHAB
//25/01/2016
//GRADE 12 MS.LIVINGSTION
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for actionlistener
import java.awt.BorderLayout;
import java.applet.*;
import java.awt.Color;
import java.awt.Font;
import java.io.*;


public class FightingGames extends JApplet implements ActionListener
{


    private Container cp; //where everything will be on

    private ImageIcon Ibackground, Ihealth, Istanding, Ipunch, Ikick, Ititle, IstartGame, IBottomTitle;

    private JPanel p1, p2, p3, p4, p5, p6, p7, p8, colorChange1, colorChange2;

    private JButton start, exit, newGame;

    private JLabel p1Controls, p2Controls, title, bottomTitle, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, vs;

    private Fighter player1, player2;

    private int random = (int) (Math.random () * 2) + 1;
    private int currentClickHere;

    private Image background, health, stand, stand2, punch, kick;


    private BackgroundMap BG;

    private BackgroundMap actions;

    private Fight healthBarPlayer1;
    private Fight healthBarPlayer2;


    boolean s = false;

    private JTextField enterPlayer1Name, enterPlayer2Name;

    private String player1Name = "Player 1";
    private String player2Name = "Player 2";

    private String instructions = "\t\t\tInstructions\n----------------------------------------------------\n\nBoth Players Make Their Selection Then Press Spacebar to Proceed\nThen press spacebar again to enter next round\nKick = 10 damage\nPunch = 8 damage \nDuck = 6 damage\nSuper = 20 damage (10 against block)\nBlock: Blocks all damage (halves super damage)\nPunch beats Kick\nKick beats Duck\nDuck beats Punch\nSuper Beats all";

    private String status, status2;

    private String tempStatus = "Default";

    private String tempStatus2 = "Default";

    private String space = "                                                                                                                                                                                    ";

    private JLabel p1Name, p2Name;

    private int p1Health = 100, p2Health = 100;

    boolean p1Win = false;

    boolean p2Win = false;

    int p1SuperCounter = 0;
    int p2SuperCounter = 0;

    boolean super1Activated = false;
    boolean super2Activated = false;

    boolean p1Damage = false;
    boolean p2Damage = false;

    int tempP1Health = 100;
    int tempP2Health = 100;

    public void init ()
    {


	cp = getContentPane ();
	//cp.setLayout (new FlowLayout ()); CANVAS DOES NOT WORK WITH FLOWLAYOUT

	BG = new BackgroundMap (tempStatus, tempStatus2);

	KeyListener keyViewer = new KeyboardViewer ();
	addKeyListener (keyViewer);

	player1 = new Fighter ();
	player2 = new Fighter ();

	enterPlayer1Name = new JTextField (25);
	enterPlayer2Name = new JTextField (25);

	player1Name = enterPlayer1Name.getText ();
	player2Name = enterPlayer2Name.getText ();


	p1 = new JPanel ();
	p2 = new JPanel ();
	p3 = new JPanel ();
	p4 = new JPanel ();
	p5 = new JPanel ();
	p6 = new JPanel ();
	p7 = new JPanel ();
	p8 = new JPanel ();


	vs = new JLabel ("                                                                              vs");

	if (random == 1)
	{
	    IstartGame = new ImageIcon ("clickHere1.jpg");
	}
	else if (random == 2)
	{
	    IstartGame = new ImageIcon ("clickHere2.jpg");

	}


	Ititle = new ImageIcon ("title4.png");
	IBottomTitle = new ImageIcon ("bottom.jpg");

	start = new JButton (IstartGame);
	exit = new JButton ("EXIT");
	newGame = new JButton ("NEW GAME");

	bottomTitle = new JLabel (IBottomTitle);
	title = new JLabel (Ititle);
	p1Controls = new JLabel ("Player 1 controlzz: 1. PUNCH  2.DUCK  3.KICK  4.BLOCK 5.SUPER!");
	p2Controls = new JLabel ("Player 2 controlzz: Q. PUNCH  W.DUCK  E.KICK  R.BLOCK T.SUPER!");

	p1Name = new JLabel ("Player 1 Name Your Fighter!");
	p2Name = new JLabel ("Player 2 Name Your Fighter!");

	//sets layout to specified borders
	p1.setLayout (new BorderLayout ());
	p2.setLayout (new BorderLayout ());
	p3.setLayout (new BorderLayout ());
	p5.setLayout (new BorderLayout ());
	p6.setLayout (new BorderLayout ());
	p7.setLayout (new BorderLayout ());

	//add title at the top
	p1.add (title);

	//adds background and titles in the middle
	//p2.add (BG);

	p2.add ("Center", start);

	p7.add ("West", p1Name);
	p7.add ("East", p2Name);

	p2.add ("South", p7);


	//get p1 name
	p5.add ("West", enterPlayer1Name);
	//get p2 name
	p5.add ("East", enterPlayer2Name);



	//Bottom part of applet; names on top, p1 controls middle, p2 controls bottom
	p6.add ("North", p5);
	//p6.add ("Center", p3);
	p6.add ("South", p3);


	//adds title, background and control to cp in that order
	cp.add ("North", p1);
	cp.add ("Center", p2);
	cp.add ("South", p6);



	enterPlayer1Name.addActionListener (this);
	enterPlayer2Name.addActionListener (this);
	start.addActionListener (this);
	exit.addActionListener (this);
	newGame.addActionListener (this);




    } // init method


    private class KeyboardViewer implements KeyListener

    {

	public void keyPressed (KeyEvent e)

	{

	}

	public void keyReleased (KeyEvent e)

	{

	    //ends program
	    if (e.getKeyChar () == e.VK_ESCAPE)
		System.exit (0);

	    //prints instructions
	    if (e.getKeyChar () == 'i' || e.getKeyChar () == 'i')
		System.out.println (instructions);

	    if (e.getKeyChar () == 'n' || e.getKeyChar () == 'N')
		newGame ();


	    if (e.getKeyChar () == 'd' || e.getKeyChar () == 'D' && s == false)
	    {
		tempStatus = "Punch";
		System.out.println ("Player 1:  " + tempStatus);


	    }
	    else if (e.getKeyChar () == 's' || e.getKeyChar () == 'S' && s == false)
	    {
		tempStatus = "Duck";
		System.out.println ("Player 1:  " + tempStatus);

	    }
	    else if (e.getKeyChar () == 'a' || e.getKeyChar () == 'A' && s == false)
	    {
		tempStatus = "Kick";
		System.out.println ("Player 1:  " + tempStatus);


	    }
	    else if (e.getKeyChar () == 'w' || e.getKeyChar () == 'W' && s == false)
	    {
		tempStatus = "Block";
		System.out.println ("Player 1:  " + tempStatus);


	    }
	    else if (e.getKeyChar () == 'q' || e.getKeyChar () == 'Q' && s == false)
	    {

		if (super1Activated == true)
		{
		    tempStatus = "Super";
		    System.out.println ("Player 1:  " + tempStatus);
		    p1SuperCounter = 0;
		    super1Activated = false;


		}
	    }
	    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

	    if (e.getKeyChar () == '4' && s == false)
	    {
		tempStatus2 = "Punch";
		System.out.println ("Player 2:  " + tempStatus2);

	    }
	    else if (e.getKeyChar () == '5' && s == false)
	    {
		tempStatus2 = "Duck";
		System.out.println ("Player 2:  " + tempStatus2);

	    }
	    else if (e.getKeyChar () == '6' && s == false)
	    {
		tempStatus2 = "Kick";
		System.out.println ("Player 2:  " + tempStatus2);

	    }
	    else if (e.getKeyChar () == '8' && s == false)
	    {
		tempStatus2 = "Block";
		System.out.println ("Player 2:  " + tempStatus2);

	    }
	    else if (e.getKeyChar () == '9' && s == false)
	    {

		if (super2Activated == true)
		{
		    tempStatus2 = "Super";
		    System.out.println ("Player 2:  " + tempStatus2);
		    p2SuperCounter = 0;
		    super2Activated = false;
		}

	    }
	    // -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

	    if (e.getKeyCode () == e.VK_SPACE && tempStatus != "Default" && tempStatus2 != "Default" && s == false)
	    {

		s = true;
		status = tempStatus;
		status2 = tempStatus2;


		Fight fight = new Fight (status, status2, p1Health, p2Health, p1SuperCounter, p2SuperCounter);
		//actions = new BackgroundMap (status, status2);

		fight.begin ();

		p1Health = fight.getPlayerOneHealth ();
		p2Health = fight.getPlayerTwoHealth ();


		if (p1Health < tempP1Health && p2Health < tempP2Health)
		{

		    p1Damage = true;
		    p2Damage = true;


		}
		else if (p1Health < tempP1Health)
		{
		    p1Damage = true;

		}

		else if (p2Health < tempP2Health)
		{
		    p2Damage = true;

		}



		tempP1Health = p1Health;
		tempP2Health = p2Health;

		p1SuperCounter = fight.getp1SuperCounter ();
		p2SuperCounter = fight.getp2SuperCounter ();



		if (p1SuperCounter >= 3)
		    super1Activated = true;

		if (p2SuperCounter >= 3)
		    super2Activated = true;

		if (p2Health <= 0 && p1Health <= 0)
		{
		    p2Win = true;
		    p1Win = true;
		    System.out.println ("DOUBLE K.O. TIE");


		}

		else if (p1Health <= 0)
		{
		    p2Win = true;
		    System.out.println ("Player 2 Wins");


		}
		else if (p2Health <= 0)
		{

		    p1Win = true;
		    System.out.println ("Player 1 Wins");


		}


		System.out.println ("Player 1 Health: " + p1Health);
		System.out.println ("Player 2 Health: " + p2Health);

		BG.status (status, status2, p1Health, p2Health, p1Win, p2Win, p1SuperCounter, p2SuperCounter, player1Name, player2Name, p1Damage, p2Damage);
		p2.add (BG);



		tempStatus = "Default";
		tempStatus2 = "Default";



	    }
	    else if (e.getKeyCode () == e.VK_SPACE && s == true)
	    {

		s = false;

		tempStatus = "Default";
		tempStatus2 = "Default";
		p1Damage = false;
		p2Damage = false;
		BG.status (tempStatus, tempStatus2, p1Health, p2Health, p1Win, p2Win, p1SuperCounter, p2SuperCounter, player1Name, player2Name, p1Damage, p2Damage);
		p2.add (BG);
	    }



	}
	public void keyTyped (KeyEvent e)

	{

	}

    } // end KeyboardViewer


    public void actionPerformed (ActionEvent ae)
    {

	Object source = ae.getSource ();

	if (source == enterPlayer1Name)
	{
	    player1Name = enterPlayer1Name.getText ();

	    p5.remove (enterPlayer1Name);

	}
	if (source == enterPlayer2Name) // else if (source == enterPlayer2Name)
	{

	    player2Name = enterPlayer2Name.getText ();
	    p5.remove (enterPlayer2Name);


	}

	//for this to work change size of screen idk why
	else if (source == start)
	{

	    p7.remove (p1Name);
	    p7.remove (p2Name);

	    p7.add (bottomTitle);

	    p2.remove (start);
	    BG.status (tempStatus, tempStatus2, p1Health, p2Health, p1Win, p2Win, p1SuperCounter, p1SuperCounter, player1Name, player2Name, p1Damage, p2Damage);
	    p2.add (BG);

	    //music ();

	    //removalFix ();
	}

    }


    public void newGame ()
    {

	tempStatus = "Default";
	tempStatus2 = "Default";
	status = "Default";
	status2 = "Default";

	p1Health = 100;
	p2Health = 100;

	p1Damage = false;
	p2Damage = false;

	p1Win = false;
	p2Win = false;

	p1SuperCounter = 0;
	p2SuperCounter = 0;

	BG.status (status, status2, p1Health, p2Health, p1Win, p2Win, p1SuperCounter, p2SuperCounter, player1Name, player2Name, p1Damage, p2Damage);
	p2.add (BG);

    }
} // FightingGame class


