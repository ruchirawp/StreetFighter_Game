// The "Fight" class.
public class Fight
{
    private String player1;
    private String player2;
    private int p1Health;
    private int p2Health;
    private Fighter fighter1 = new Fighter ();
    private Fighter fighter2 = new Fighter ();

    private BackgroundMap situations;

    int p1SuperCounter;
    int p2SuperCounter;


    public Fight (String player1, String player2, int p1Health, int p2Health, int p1SuperCounter, int p2SuperCounter)
    {
	this.player1 = player1;
	this.player2 = player2;
	this.p1Health = p1Health;
	this.p2Health = p2Health;
	this.p1SuperCounter = p1SuperCounter;
	this.p2SuperCounter = p2SuperCounter;

    } // main method


    public void begin ()
    {
	//Player 1 Punch ----------------------------------------------------------------

	if (player1.equals ("Punch") && player2.equals ("Punch"))
	{
	    fighter1.punch (p1Health);
	    fighter2.punch (p2Health);

	    p1SuperCounter++;
	    p2SuperCounter++;


	}

	if (player1.equals ("Punch") && player2.equals ("Block"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);
	}
	if (player1.equals ("Punch") && player2.equals ("Duck"))
	{
	    fighter1.duck (p1Health);
	    fighter2.setHealth (p2Health);

	    p2SuperCounter++;

	}

	if (player1.equals ("Punch") && player2.equals ("Kick"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.punch (p2Health);

	    p1SuperCounter++;


	}


	//Player 1 Blcok -----------------------------------------------------------------

	if (player1.equals ("Block") && player2.equals ("Punch"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);

	}
	if (player1.equals ("Block") && player2.equals ("Block"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);
	}
	if (player1.equals ("Block") && player2.equals ("Duck"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);
	}
	if (player1.equals ("Block") && player2.equals ("Kick"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);
	}

	//Player 1 Duck -----------------------------------------------------------------

	if (player1.equals ("Duck") && player2.equals ("Punch"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.duck (p2Health);

	    p1SuperCounter++;

	}
	if (player1.equals ("Duck") && player2.equals ("Block"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);

	}
	if (player1.equals ("Duck") && player2.equals ("Duck"))
	{
	    fighter1.duck (p1Health);
	    fighter2.duck (p2Health);

	    p1SuperCounter++;
	    p2SuperCounter++;

	}
	if (player1.equals ("Duck") && player2.equals ("Kick"))
	{
	    fighter1.kick (p1Health);
	    fighter2.setHealth (p2Health);

	    p2SuperCounter++;

	}

	//Player 1 kick -----------------------------------------------------------------

	if (player1.equals ("Kick") && player2.equals ("Punch"))
	{
	    fighter1.punch (p1Health);
	    fighter2.setHealth (p2Health);

	    p2SuperCounter++;

	}
	if (player1.equals ("Kick") && player2.equals ("Block"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.setHealth (p2Health);
	}
	if (player1.equals ("Kick") && player2.equals ("Duck"))
	{
	    fighter1.setHealth (p1Health);
	    fighter2.kick (p2Health);

	    p1SuperCounter++;

	}
	if (player1.equals ("Kick") && player2.equals ("Kick"))
	{
	    fighter1.kick (p1Health);
	    fighter2.kick (p2Health);

	    p1SuperCounter++;
	    p2SuperCounter++;

	}

	// Super ------------------------------------------------------------------------
	if (player1.equals ("Super") && player2.equals ("Super"))
	{
	    fighter1.Super (p1Health);
	    fighter2.Super (p2Health);

	}

	else if (player1.equals ("Super") && player2.equals ("Block"))
	{
	    fighter2.Super (p2Health + 10);
	    fighter1.setHealth (p1Health);

	}

	else if (player2.equals ("Super") && player1.equals ("Block"))
	{
	    fighter1.Super (p1Health + 10);
	    fighter2.setHealth (p2Health);
	}

	else if (player1.equals ("Super"))
	{
	    fighter2.Super (p2Health);
	    fighter1.setHealth (p1Health);

	}

	else if (player2.equals ("Super"))
	{
	    fighter1.Super (p1Health);
	    fighter2.setHealth (p2Health);
	}



    }


    public int getp1SuperCounter ()
    {

	return p1SuperCounter;
    }


    public int getp2SuperCounter ()
    {

	return p2SuperCounter;
    }


    public int getPlayerOneHealth ()
    {
	return fighter1.getHealth ();
    }


    public int getPlayerTwoHealth ()
    {
	return fighter2.getHealth ();
    }
} // Fight class
