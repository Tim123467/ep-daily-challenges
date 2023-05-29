/* Program used to translate Breakbar's txt file into wikitext. Note that I renamed his txt file to "EP Daily Challenges.txt"
 * Don't forget to update both currentYearAndMonth and lastDayWithDailyChallenges.
 */

import java.io.*;

public class EntryPointDailyChallenges {
	public static void main(String[] args) {
		RuntimeException re = new RuntimeException("Read the message in the previous line. Use ctrl+F or cmd+F and search the message to see where the error occurred.");
		BufferedReader readFile = null;
		
		try {
			readFile = new BufferedReader(new FileReader(new File("EP Daily Challenges.txt")));
			String line, date, mission, tactic, color1, mod1, color2, mod2, color3, mod3; //using an array instead would make my code take up less lines,
			                                                                              //but it would also make my code harder to understand
			final String currentYearAndMonth = "2023-05"; //must be in the format "YYYY-MM"
			final String year = "2025"; //change manually for the year you want the wikitext for (due to the console's limited number of lines)
			                            //currently, Breakbar's txt file covers the end of 2022 to most of 2025
			final String lastDayWithDailyChallenges = "2025-09-16"; //last day that Breakbar's txt file has a daily challenge for;
			                                                        //change this whenever that txt file gets updated
			
			do {
				line = readFile.readLine();
				date = line.substring(0, line.indexOf(','));
				
				if (date.substring(0, 4).equals(year)) { //checks if the year matches
					line = line.substring(line.indexOf(',')+1);
					mission = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					tactic = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					color1 = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					mod1 = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					color2 = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					mod2 = line.substring(0, line.indexOf(','));
					line = line.substring(line.indexOf(',')+1);
					color3 = line.substring(0, line.indexOf(','));
					mod3 = line.substring(line.indexOf(',')+1);
					
					if (mod1.equals("Takedown Limit")) {
						mod1 = "Takedown Limit (4)";
					}
					if (mod1.equals("Takedown Limit 6")) {
						mod1 = "Takedown Limit (6)";
					}
					if (mod2.equals("Takedown Limit")) {
						mod2 = "Takedown Limit (4)";
					}
					if (mod2.equals("Takedown Limit 6")) {
						mod2 = "Takedown Limit (6)";
					}
					if (mod3.equals("Takedown Limit")) {
						mod3 = "Takedown Limit (4)";
					}
					if (mod3.equals("Takedown Limit 6")) {
						mod3 = "Takedown Limit (6)";
					}
					
					if (date.substring(8, 10).equals("01")) { //first day of the month
						if (date.substring(5, 7).equals("01")) { //first month of the year
							System.out.print("===January");
						} else {
							System.out.print("|}\n===");
							switch (date.substring(5, 7)) {
							case "02": System.out.print("February"); break;
							case "03": System.out.print("March"); break;
							case "04": System.out.print("April"); break;
							case "05": System.out.print("May"); break;
							case "06": System.out.print("June"); break;
							case "07": System.out.print("July"); break;
							case "08": System.out.print("August"); break;
							case "09": System.out.print("September"); break;
							case "10": System.out.print("October"); break;
							case "11": System.out.print("November"); break;
							case "12": System.out.print("December"); break;
							default:
								System.out.println("\nThe part corresponding with the month was invalid.");
								throw re;
							}
						}
						
						System.out.print(" " + date.substring(0, 4) + "===\n{| class=\"fandom-table article-table mw-collapsible mw-collapsed\" ");
						
						if (date.substring(0, 7).equals(currentYearAndMonth)) {
							System.out.println("data-expandtext=\"Show Previous and Upcoming Challenges\" data-collapsetext=\"Hide Previous and Upcoming Challenges\"");
						} else if (Short.parseShort(date.substring(0, 4)) < Short.parseShort(currentYearAndMonth.substring(0, 4)) ||
								  (Short.parseShort(date.substring(0, 4)) == Short.parseShort(currentYearAndMonth.substring(0, 4)) && Short.parseShort(date.substring(5, 7)) < Short.parseShort(currentYearAndMonth.substring(5, 7)))) {
							System.out.println("data-expandtext=\"Show Previous Challenges\" data-collapsetext=\"Hide Previous Challenges\"");
						} else {
							System.out.println("data-expandtext=\"Show Upcoming Challenges\" data-collapsetext=\"Hide Upcoming Challenges\"");
						}
						
						System.out.println("!Date\n!Mission\n!Tactic\n!Modifiers");
					}
					
					System.out.print("|-\n!" + date + "\n|");
					switch (mission) {
					case "The Auction":
					case "The Gala":
					case "The Cache":
					case "The Setup":
					case "The Lockup":
					case "The Score": System.out.print("{{Robux}} "); break;
					}
					System.out.print(mission + "\n|" + tactic + "\n|<span class=challenge-");
					switch (color1) {
					case "G": System.out.print("green"); break;
					case "B": System.out.print("blue"); break;
					case "P": System.out.print("purple"); break;
					case "R": System.out.print("red"); break;
					default:
						System.out.println("\nThe part corresponding with the first modifier's color was invalid.");
						throw re;
					}
					System.out.print(">" + mod1 + "</span>, <span class=challenge-");
					switch (color2) {
					case "G": System.out.print("green"); break;
					case "B": System.out.print("blue"); break;
					case "P": System.out.print("purple"); break;
					case "R": System.out.print("red"); break;
					default:
						System.out.println("\nThe part corresponding with the second modifier's color was invalid.");
						throw re;
					}
					System.out.print(">" + mod2 + "</span>, <span class=challenge-");
					
					if (date.equals("2023-04-28")) { //April 28's daily challenge was changed
						System.out.println("purple>Hidden UI</span>");
					} else {
						switch (color3) {
						case "G": System.out.print("green"); break;
						case "B": System.out.print("blue"); break;
						case "P": System.out.print("purple"); break;
						case "R": System.out.print("red"); break;
						default:
							System.out.println("\nThe part corresponding with the third modifier's color was invalid.");
							throw re;
						}
						System.out.println(">" + mod3 + "</span>");
					}
				}
			} while (!date.equals(lastDayWithDailyChallenges));
			
			System.out.println("|}");
		} catch (FileNotFoundException e) {
			System.out.println("\nThe file does not exist or could not be found.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("\nThe file could not be read or closed.");
			System.err.println("IOException: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("\nThe do-while loop iterated too many times.");
			System.err.println("NullPointerException: " + e.getMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println("\nA substring(beginIndex, endIndex) method returned an error: beginIndex was negative, or endIndex was greater than the length of the String, or beginIndex was greater than endIndex.");
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("\nThe Short.parseShort(string) method returned an error.");
			System.err.println("NumberFormatException: " + e.getMessage());
		} catch (RuntimeException e) {
			System.err.println("RuntimeException: " + e.getMessage());
		} finally {
			try {
				if (readFile != null) {
					readFile.close();
				}
			} catch (IOException e) { //This catch block exists because Eclipse was being dumb and giving me a made-up syntax error if I didn't include it.
				System.out.println("\nThe file could not be closed.");
				System.err.println("IOException: " + e.getMessage());
			}
		}
	}
}
