package com.example.application.views.wikipediasearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WikipediaSearch {

	public static ArrayList<String> filePaths;
	public static ArrayList[] mostLikely;
	public static ArrayList<String> reducedNames = new ArrayList<>();
	public static HashSet<String> spellCheck = new HashSet<>(500000); // List of words is ~400,000
	public static int[] index;

	public static void main(String[] args) throws IOException {
		// 1. Calls the GUI, which then calls the run method below
		// This is only run if you're using the jar executable
		GUI gui = new GUI();
		gui.setSize(650, 350);
		gui.setVisible(true);

	}

	public static int[] run(String phrase) throws IOException {
		// Size can be changed to affect how many documents we scan, this has the
		// biggest impact on performance.
		int size = 100;
		phrase = phrase.toLowerCase();
		// This contains the file paths for the top search results in order
		index = findTopPaths(phrase, size);
		mostLikely = new ArrayList[index.length];

		for (int i = 0; i < index.length; i++) {
			// Fill ArrayList with the top choices after cleaning and tokenize
			mostLikely[i] = HTMLToken.cleanRecord(filePaths.get(index[i]));
		}

		// This loop will further attempt to clean out records by removing all non
		// English words. spellCheck was loaded in FileSearch.java
		for (int i = 0; i < index.length; i++) {
			for (int j = 0; j < mostLikely[i].size(); j++) {
				if (!spellCheck.contains(mostLikely[i].get(j))) {
					mostLikely[i].remove(j);
				}
			}
		}

		// Finally, we search our hard cleaned data for the closest match
		index = deapSearch(index, phrase);

		return index;
	}

	// Searches the HTML content for the closest match
	// ------------------------------------------------------------------------------
	public static int[] deapSearch(int[] index, String phrase) {
		@SuppressWarnings("rawtypes")
		HashMap[] list = new HashMap[index.length];
		double[] result = new double[index.length];
		int[] words = new int[index.length];
		int[] documents = new int[index.length];
		int totalWords = 0;
		double probability = 1;

		Tf_Idf(index);

		for (int i = 0; i < index.length; i++) {
			words[i] = mostLikely[i].size();
			documents[i] = words[i];
		}

		for (int i = 0; i < index.length; i++) {
			totalWords += words[i];
		}

		for (int i = 0; i < index.length; i++) {
			HashMap<String, Integer> frequency = new HashMap<>();

			// Build Frequency -----------------------------------------
			for (int j = 0; j < mostLikely[i].size(); j++) {
				if (frequency.containsKey(mostLikely[i].get(j))) {
					int temp = frequency.get(mostLikely[i].get(j)) + 1;
					frequency.put((String) mostLikely[i].get(j), temp);
				} else {
					frequency.put((String) mostLikely[i].get(j), 1);
				}
			}

			list[i] = frequency;
		}

		for (int i = 0; i < index.length; i++) {

			String[] split = phrase.split(" ");
			// This was left out intentionally as we don't care about the length.
			// double ClassProb = Math.log(words[i] / totalWords);
			double WordProb = 0; // ^P(w_i|c) occurrences of w_i + 1 \ words in c + totalWords

			for (int j = 0; j < split.length; j++) {
				if (list[i].containsKey(split[j])) {
					WordProb += Math.log((int) list[i].get(split[j]) + 1 / (words[i] + totalWords));
				}
			}

			// System.out.println(i + ": " + WordProb);

			probability = WordProb;
			for (int k = 0; k < index.length; k++) {
				if (probability > result[k]) {
					/*
					 * for(int r = 0; r < index.length; r++) {
					 * System.out.print(result[r] + " hi");
					 * System.out.println();
					 * }
					 */
					double temp = result[k];
					result[k] = probability;
					result[k + 1] = temp;

					int temp2 = index[i];
					index[i] = index[k];
					index[k] = temp2;

					k = Integer.MAX_VALUE - 1;
				}
			}
		}

		return index;

	}

	// Standard TF-IDF algorithm used in machine learning and text mining, the
	// numder of times a word appears in a document increases the weight, but is
	// offset by the number of times it appears in the dataset, helping remove
	// common words like "the" "and" "or"

	// TF * IDF
	// TF = Term Frequency - How many times a term appears in a document
	// IDF = Inverse Document Frequency - Log( N / M )
	// N = Total number of documents
	// M = Number of documents that contain a term
	public static void Tf_Idf(int[] index) {
		HashMap[] list = new HashMap[index.length];
		int[] words = new int[index.length];
		int totalWords = 0;

		for (int i = 0; i < index.length; i++)
			words[i] = mostLikely[i].size();

		for (int i = 0; i < index.length; i++)
			totalWords += words[i];

		for (int i = 0; i < index.length; i++) {
			HashMap<String, Double> frequency = new HashMap<>();

			// Build initial Frequency
			for (int j = 0; j < mostLikely[i].size(); j++) {
				if (frequency.containsKey(mostLikely[i].get(j))) {
					double temp = frequency.get(mostLikely[i].get(j)) + 1;
					frequency.put((String) mostLikely[i].get(j), temp);
				} else {
					frequency.put((String) mostLikely[i].get(j), 1.0);
				}
			}

			list[i] = frequency;
		}

		double average = 0;

		for (int i = 0; i < index.length; i++) {
			double tf = 0;
			double idf = 0;
			double tfidf = 0;
			for (Object word : list[i].keySet()) {
				tf = ((double) list[i].get(word.toString()) + 0.0) / (words[i] + 0.0);
				for (int j = 0; j < index.length; j++) {
					if (list[j].get(word.toString()) != null) {
						idf++;
					}
				}
				idf = idf / index.length;
				tfidf = tf * idf;
				average += tfidf;

				list[i].put(word.toString(), tfidf);
				// System.out.println(word.toString() + "\t" +
				// (double)list[i].get(word.toString()) + "\t\t" + tfidf);
			}
		}

		average = (average / totalWords) * 50;
		// System.out.println(average);

		for (int i = 0; i < index.length; i++) {
			for (Object word : list[i].keySet()) {
				if ((double) list[i].get(word.toString()) > average) {
					mostLikely[i].remove(word.toString());
					// System.out.println(word.toString() + "\t" + " Removed");
				}
			}
		}
	}

	// Finds most likely pages and returns the top 10
	// ------------------------------------------------------------------------------
	public static int[] findTopPaths(String phrase, int size) {
		String[] split = phrase.split(" ");
		// Holds the number of occurrences in a title and the index of that title
		int[][] prob = new int[reducedNames.size()][2];
		// Range of highest to lowest match, we can assume it will be no more than the
		// length
		int k = split.length + 1;

		// finds the title with the most word matches and stores it's index
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < reducedNames.size(); j++) {
				String[] parse = reducedNames.get(j).split(" ");
				for (String word : parse) {
					if (word.contains(split[i])) {
						prob[j][0]++;
						prob[j][1] = j;
					}
				}
			}
		}

		int[] result = new int[size];
		// We have a 2d array that contains the index of a document and the
		// corresponding
		// number of times a phrase word was in the title. TopPath will clean this up to
		// a 1d array
		return TopPath(prob, result, size, k, 0);
	}

	// Lets say we had a phrase with 3 key words. TopPath will add each document
	// that had 3 matching words in the title to the result array, then all with 2
	// matches, then all with 1, etc. Recursivl calling itself for each step down in
	// the number of matching documents
	public static int[] TopPath(int[][] prob, int[] result, int total, int max, int index) {
		for (int i = 0; i < reducedNames.size(); i++) {
			if (total != 0) {
				if (prob[i][0] == max) {
					if (max == 0) {
						// This is hit when there are no more documents with titles that match any key
						// words. Becuase all remaining documents will hit a probablity of 0, we can
						// choose a few documents at random to scan. There will be minimal performance
						// lost, and a chance that we find a related document that didn't match based on
						// title
						int rand = (int) (Math.random() * reducedNames.size());
						result[index] = rand;
						index++;
						total--;
					} else {
						result[index] = prob[i][1];
						index++;
						total--;
					}
				}
				if (i == reducedNames.size() - 1) {
					max--;
					TopPath(prob, result, total, max, index);
				}
			} else {
				return result;
			}
		}

		return result;
	}

	// Shortens down the file path to just the name of the file
	// ------------------------------------------------------------------------------
	public static void loadReducer(ArrayList<String> filePaths) {
		for (String record : filePaths) {
			String[] split = record.split("/");

			String line = split[split.length - 1].toLowerCase();
			line = line.substring(0, line.length() - 5);
			String add = "";

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '-' || line.charAt(i) == '_') {
					add += " ";
				} else {
					add += line.charAt(i);
				}
			}
			reducedNames.add(add);
		}
	}

	// Creates a HashSet of ~400,000 words to check against, this helps clean up
	// our tokens. Called via FileSearch.java
	// ------------------------------------------------------------------------------
	public static void loadSpellChecker() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("src/main/java/com/example/application/views/wikipediasearch/words_alpha.txt"));
		String line;

		while ((line = reader.readLine()) != null) {
			spellCheck.add(line);
		}

		reader.close();
	}

	public static int[] getIndex() {
		return index;
	}

}
