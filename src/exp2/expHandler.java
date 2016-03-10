package exp2;

public class expHandler extends Exception{
	public static void cerr(int n)
	{
		switch(n)
		{
		case 0:
			System.out.println("Error input!\n For more info in readme.txt!");
			break;
		case 1:
			System.out.println("Nobody is in the list!\n");
			break;
		default:
			System.out.println("Error!\n For more info in readme.txt!");
			break;
		}
		System.exit(-1);
	}
}
