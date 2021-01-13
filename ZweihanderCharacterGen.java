//ZweihanderCharacterGen
//Gerardot

import java.util.Scanner;

public class ZweihanderCharacterGen
{
	public static void main(String[] args)
	{

		String preferStat;
		int preferStatMin;
		boolean goodStats=false;
		final int STARTSTAT=25;
		int[] skills = {0,0,0,0,0,0,0};
		String[] skillNames = {"com","bra","agi","per","wil","int","fel"};
		int length = skills.length;
		Scanner input = new Scanner(System.in);
		int timesRerolled=0;

		//Get stat that it needs to be above
		System.out.print("Preferred stat(First 3 letters) - ");
		preferStat = input.next();
		//Get number it needs to be above
		System.out.print("What is the min value for this? - ");
		preferStatMin = input.nextInt();
		if(preferStatMin>55)
			System.out.println("You're an idiot and need to type a smaller number");

		//Create Proper stats
		if(preferStatMin<=55)
		{
		for(int i=0;i<length;i++)
		{
			skills[i]=STARTSTAT+Roll3D10();
			if(preferStat.equals(skillNames[i]))
			{
				System.out.println("I found the right skill");
				while(goodStats==false)
				{
					if(skills[i]>= preferStatMin)
					{
						goodStats=true;
					}
					else
					{
					timesRerolled++;
					skills[i]=STARTSTAT+Roll3D10();
					}
				}
			}
		}
		}

		//Tell them to user
		System.out.println("I rerolled the skill "+timesRerolled+" times.");
		for(int i=0;i<length;i++)
		{
			System.out.println(skillNames[i]+" "+ skills[i]);
		}
	}

	private static int Roll3D10()
	{
		int sum=0;
		for(int i=0; i<3;i++)
		{
			int die = (int)((Math.random() * 10)+1);
			sum+=die;
		}
		return sum;
	}
}