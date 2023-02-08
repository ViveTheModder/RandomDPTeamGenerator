# RandomDPTeamGenerator
For full disclosure, in spite of what my name says, this is NOT a modding tool.

It's more or less a simple JavaFX project made in Eclipse, which returns two randomly generated teams once the user specifies the DP Limit (maximum total score of the team) and the number of characters for both teams.

Special Thanks to [jagger1407](https://github.com/jagger1407) for providing feedback and much-needed suggestions.

## Known Issues
* As of now, I cannot get a proper runnable JAR release of the program because of certain issues with Eclipse's export feature.
  Because of that, there are no download/build instructions provided. Guilty as charged.
* This program does NOT take into consideration which characters are repeatable or not, as well as Budokai Tenkaichi 3's transformation restriction system in general.
* For the sake of convenience, I chose to rely on string arrays rather than CSVs (comma-separated values), which I know a bit better in C.
