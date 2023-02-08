# RandomDPTeamGenerator
For full disclosure, in spite of what my name says, this is NOT a modding tool.

It's more or less a simple JavaFX project made in Eclipse, which returns two randomly generated teams once the user specifies the DP Limit (maximum total score of the team) and the number of characters for both teams.

Special Thanks to [jagger1407](https://github.com/jagger1407) for providing feedback and much-needed suggestions.

## Usage/Preview
When the program is initially launched, the DP Limit & Number of Characters are set to 10 and 2 by default.

![preview1](https://github.com/ViveTheModder/RandomDPTeamGenerator/blob/main/images/preview1.png)
![preview2](https://github.com/ViveTheModder/RandomDPTeamGenerator/blob/main/images/preview2.png)

Upon clicking the _Generate_ button, various character names will display for both teams.

![preview3](https://github.com/ViveTheModder/RandomDPTeamGenerator/blob/main/images/preview3.png)

At that point, the user can hover over any of the names and check the corresponding character's DP score.

![preview4](https://github.com/ViveTheModder/RandomDPTeamGenerator/blob/main/images/preview4.png)

In case you couldn't tell, I got inspired by Opera GX for the GUI. A lot.

## Known Issues
* As of now, I cannot get a proper runnable JAR release of the program because of certain issues with Eclipse's export feature.
  Because of that, there are no download/build instructions provided. Guilty as charged.
* This program does NOT take into consideration which characters are repeatable or not, as well as Budokai Tenkaichi 3's transformation restriction system in general.
* For the sake of convenience, I chose to rely on string arrays rather than CSVs (comma-separated values), which I know a bit better in C.
