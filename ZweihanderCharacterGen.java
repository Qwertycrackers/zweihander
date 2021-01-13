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

		//Get stat that it needs to be above
		System.out.print("Preferred stat(First 3 letters) - ");
		preferStat = input.next();
		//Get number it needs to be above
		System.out.print("What is the min value for this? - ");
		preferStatMin = input.nextInt();

		//Create Proper stats

		for(int i=0;i<length;i++)
		{
			skills[i]=STARTSTAT+Roll3D10();
		}
		for(int g=0;g<length;g++)
		{
			//System.out.println("I made it this far");
			if(preferStat.equals(skillNames[g]))
			{
				System.out.println("I found the right skill");
				while(goodStats==false)
				{
					if(skills[g]>= preferStatMin)
					{
						goodStats=true;
					}
					else
					{
						skills[g]+=5;
						System.out.println("I added 5");
					}
				}
			}
		}

		//Tell them to user
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