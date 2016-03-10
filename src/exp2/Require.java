package exp2;

public class Require {
	protected int layer;
	protected String direction;
	protected double time;
	protected boolean kind; //for in or out require 
	public Require()
	{
		super();
	}
	public Require(boolean b,int n,String s ,double t)
	{
		kind = b;
		layer  = n;
		direction = s;
		time = t;
	}
}
