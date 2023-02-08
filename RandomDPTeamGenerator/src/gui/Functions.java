package gui;

public class Functions 
{
	/** method that generates random DPs whose sum is the DP limit chosen by the user */
	public static void setRandomDPs(int[] DPArray, int charCNT, int DPLimit)
	{
		//increment random elements of the array by 1 (since they're set to 0 by default) until you reach the sum lol
		for (int i=0; i<DPLimit; i++)
			DPArray[(int)(Math.random()*charCNT)]++;
	}
	/** method that overwrites DPs higher than 10 with just 10 (unless the character count is greater than 2) */
	public static void fixWrongDPs(int[] DPArray, int charCNT)
	{
		for (int i=0; i<charCNT; i++)
		{
			if (DPArray[i]>10)
				DPArray[i]=10;
		}
		if (charCNT==2)
		{
			int randomIndex = (int) Math.random()*2; //generate integer from 0 to 1
			//if either the first or 2nd element is set to 10, overwrite it with 9
			if (DPArray[randomIndex]==10)
				DPArray[randomIndex]--;
		}
	}
	/** method that counts the number of DPs set to a specific DP amount (from 1 to 10) */
	public static int countFixedDPs(int[] DPArray, int charCNT, int val)
	{
		int cnt = 0;
		for (int i=0; i<charCNT; i++)
		{
			if (DPArray[i]==val)
				cnt++;
		}
		return cnt;
	}
	/** method that checks if there are any DPs set to zeroes (which normally shouldn't happen) */
	public static boolean hasZeroes(int[] DPArray, int charCNT)
	{
		for (int i=0; i<charCNT; i++)
		{
			if (DPArray[i]==0)
				return true;
		}
		return false;
	}
}
