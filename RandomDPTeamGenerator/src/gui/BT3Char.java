package gui;

public class BT3Char 
{
	//data fields
	int DP = 0;
	String name;
	//fuckton of arrays (I really hate myself for this; next version might use CSV files instead)
	String[] charNamesDP2 = 
	{
		"Videl", "Great Saiyaman 2", "Yajirobe", "Master Roshi", "Master Roshi - MAX Power", "Grandpa Gohan", "Nam", "Android #8", "Saibamen",
		"Appule", "Frieza Soldier", "General Blue", "Devilman", "Pilaf Machine", "Pilaf Machine - Fusion", "Chi-Chi", "Spopovitch"
	};
	String[] charNamesDP3 =
	{
		"Raditz", "Great Ape Raditz", "Cui", "Guldo", "Android #19", "Cell Jr.", "General Tao", "Cyborg Tao", "Tambourine"
	};
	String[] charNamesDP4 =
	{
		"Kid Goku", "Great Ape", "Kid Gohan", "Great Saiyaman", "Piccolo (Early)", "Krillin", "Yamcha", "Tien", "Supreme Kai", "Kibito Kai",
		"Tapion", "Pan", "Fasha", "Great Ape Fasha", "Nappa", "Great Ape Nappa", "Zarbon", "Zarbon - Post-Transformation", "Dodoria", "Cui",
		"Captain Ginyu", "Recoome", "Burter", "Jeice", "Dr. Gero", "Babidi", "Garlic Jr.", "Super Garlic Jr.", "Dr. Wheelo", "Broly", "Zangya",
		"Demon King Piccolo"
	};
	String[] charNamesDP5 =
	{
		"Goku (Early)", "Teen Gohan", "Adult Gohan", "Piccolo (End)", "Nail", "Vegeta (Scouter)", "Vegeta", "Vegeta (2nd form)", "Trunks (Sword)",
		"Trunks", "Kid Trunks", "Goten", "Uub", "King Vegeta", "Great Ape King Vegeta", "Bardock", "Great Ape Bardock", "King Cold", "Android #16",
		"Android #17", "Android #18", "Turles", "Great Ape Turles", "Slug", "Salza", "Android #13", "Bojack", "Janemba", "Arale", "Future Gohan"
	};
	String[] charNamesDP6 =
	{
		"Goku (Mid)", "Goku (End)", "Goku (GT)", "Frieza - 1st Form", "Frieza - 2nd Form", "Frieza - 3rd Form", "Cell - 1st Form", "Cell - 2nd Form",
		"Baby Vegeta"
	};
	String[] charNamesDP7 =
	{
		"Goku (Mid) - Super Saiyan", "Goku (End) - Super Saiyan", "Goku (GT) - Super Saiyan", "Teen Gohan - Super Saiyan", "Adult Gohan - Super Saiyan",
		"Vegeta - Super Saiyan", "Super Vegeta", "Vegeta (2nd form) - Super Saiyan", "Trunks (Sword) - Super Saiyan", "Super Trunks", "Kid Trunks - Super Saiyan",
		"Goten - Super Saiyan", "Gotenks", "Pikkon", "Majuub", "Frieza - Final Form", "Mecha Frieza", "Cell - Perfect Form", "Demon King Dabura", "Majin Buu",
		"Majin Buu (Pure Evil)", "Super Buu", "Slug - Giant", "Cooler", "Broly - Super Saiyan", "Hirudegarn", "Super Baby 1", "Future Gohan - Super Saiyan"
	};
	String[] charNamesDP8 =
	{
		"Goku (End) - Super Saiyan 2", "Goku (End) - Super Saiyan 3", "Goku (GT) - Super Saiyan 3", "Teen Gohan - Super Saiyan 2", "Adult Gohan - Super Saiyan 2",
		"Ultimate Gohan", "Vegeta (2nd form) - Super Saiyan 2", "Vegeta (End) - Majin", "Gotenks - Super Saiyan", "Vegito", "Frieza - Full Power", "Cell - Perfect",
		"Super Buu - Gotenks Absorbed", "Super Buu - Gohan Absorbed", "Kid Buu", "Cooler - Final Form", "Meta-Cooler", "Android #13 - Fusion", "Bojack - Full Power",
		"Super Janemba", "Super Baby 2", "Great Ape Baby", "Nuova Shenron"
	};
	String[] charNamesDP9 =
	{
		"Goku (GT) - Super Saiyan 4", "Vegeta (2nd form) - Super Saiyan 4", "Gotenks - Super Saiyan 3", "Super Vegito", "Super Gogeta", "Broly - Legendary Super Saiyan",
		"Super 17", "Nuova Shenron", "Syn Shenron", "Omega Shenron"
	};
	//constructor that takes DP amount as a parameter
	public BT3Char(int DP) 
	{
		this.DP = DP;
	}
	//overridden string method that generates a random character name based on the DP amount, unless it's set to 1 or 10 (in which case it's obvious)
	public String toString()
	{
		switch (DP)
		{
			case 1: name = "Hercule"; break;
			case 2: name = charNamesDP2[(int) (Math.random()*charNamesDP2.length)]; break;
			case 3: name = charNamesDP3[(int) (Math.random()*charNamesDP3.length)]; break;
			case 4: name = charNamesDP4[(int) (Math.random()*charNamesDP4.length)]; break;
			case 5: name = charNamesDP5[(int) (Math.random()*charNamesDP5.length)]; break;
			case 6: name = charNamesDP6[(int) (Math.random()*charNamesDP6.length)]; break;
			case 7: name = charNamesDP7[(int) (Math.random()*charNamesDP7.length)]; break;
			case 8: name = charNamesDP8[(int) (Math.random()*charNamesDP8.length)]; break;
			case 9: name = charNamesDP9[(int) (Math.random()*charNamesDP9.length)]; break;
			case 10: name = "Gogeta - Super Saiyan 4"; break;
			default: name = "";
		}
		return name;
	}
}