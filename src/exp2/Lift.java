package exp2;

public class Lift extends Require{
	private int peopleNum;
	public Lift()
	{
		layer = 1;
		direction = "STAY";
		time = 0;
		peopleNum = 0;
	}
	public void run(Require r)
	{
		if(r.time > time)
			time = r.time + 1.0;
		else
			time += (Math.abs(r.layer-layer))*ConstData.speed+ConstData.stay;
		//if(r.kind == false)
		//{
			if(r.layer < layer)
				direction = "DOWN";
			else if(r.layer == layer)
				direction  = "STAY";
			else
				direction = "UP";
				
		//}
		layer = r.layer;
	}
	public void print()
	{
		System.out.println("The result is:");
		System.out.println("("+layer+","+direction+","+time+")");
	}
}
