package exp2;

import java.util.Queue;
import java.util.Scanner;

public class Order {
	private static Require r;
	private static RequireQueue q = new RequireQueue();
	private static Lift l = new Lift();
	public static void main(String[]args)
	{
		String input,direction = "UP";
		int layer = 1;
		double timeout = 0,timein = 0;
		try
		{
			Scanner read  = new Scanner(System.in);
			while(read.hasNextLine())
			{
				input = read.nextLine();
				if(input.equals("run"))
				{
					System.out.println("Starts!");
					System.out.println("First must be outside require!");
					break;
				}
				else
				{
					input = input.replace("\\s+", "");
					if(input.charAt(0)=='(' && input.charAt(input.length()-1)==')' )
					{
						input = input.substring(1,input.length()-1);
						String[]data = input.split(",");
						switch(data.length)
						{
						case 4:
							try
							{
								layer = Integer.parseInt(data[1]);
								direction = data[2];
								double temp =  Double.parseDouble(data[3]);
								if(temp<timeout|| (temp-(int)temp)!=0)
								{
									System.out.println("Format error!\n");
									continue;
								}
								else
									timeout = temp;
							}
							catch(Exception ef)
							{
								System.out.println("Format error!\n");
								continue;
							}
							if(layer>10 ||layer < 1)
							{
								System.out.println("Format error!\n");
								continue;
							}
							if((layer==1 && direction.equals("DOWN"))||(layer==10 && direction.equals("UP")))
							{
								System.out.println("Format error!\n");
								continue;
							}
							if(direction.equals("UP")||direction.equals("DOWN"))
							{
								r = new Require(true,layer,direction,timeout);
								q.add(r);
							}
							else
							{
								System.out.println("Format error!\n");
								continue;
							}
							break;
						case 3:
							try
							{
								layer = Integer.parseInt(data[1]);
								double temp =  Double.parseDouble(data[2]);
								if(temp<timein || (temp-(int)temp)!=0)
								{
									System.out.println("Format error!\n");
									continue;
								}
								else
									timein = temp;
								
							}
							catch(Exception ed)
							{
								System.out.println("Format error!\n");
								continue;
							}
							if(layer>10 || layer < 1)
							{
								System.out.println("Format error!\n");
								continue;
							}
							r = new Require(false,layer," ",timein);
							q.add(r);
							break;
						default:
							System.out.println("Format error!\n");
							continue;
						}
					}
					else
					{
						System.out.println("Format error!\n");
						continue;
					}
				}
			}
		}
		catch(Exception e)
		{
			expHandler.cerr(0);
		}
		try
		{
			if(!q.isempty())
			{
				r = q.pop();
				if(r.kind == false)
					expHandler.cerr(1);
				else
				{
					l.run(r);
					l.print();
				}
			}
			else
				l.print();
			while(!q.isempty())
			{
				r = q.pop();
				l.run(r);
				l.print();
			}
		}
		catch(Exception e)
		{
			expHandler.cerr(3);
		}
	}
}
