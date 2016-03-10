package exp2;

import java.util.Vector;

public class RequireQueue {
	private Vector<Require> queue;
	public RequireQueue()
	{
		super();
		queue = new Vector<Require>(1000);
	}
	public void add(Require r)
	{
		queue.add(r);
	}
	boolean isempty()
	{
		return queue.isEmpty();
	}
	public Require pop()
	{
		Require temp = queue.elementAt(0);
		queue.remove(0);
		return temp;
		
	}
}
