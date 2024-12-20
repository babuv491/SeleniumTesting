package com.learn.Test;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvFileReader {

	public static void main(String[] args) throws CsvValidationException {
		
		/*
		 * try { List<String> allLines = Files.readAllLines(Paths.get("Book1.csv"));
		 * 
		 * for(String line: allLines) {
		 * 
		 * String[] eachWord = line.split(",");
		 * 
		 * for(int i=0;i<eachWord.length;i++) { System.out.print(eachWord[i]+"\t"); }
		 * System.out.println();
		 * 
		 * }
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
			try (CSVReader reader = new CSVReader(new FileReader("Book1.csv"))) {
				String[] nextLine;
				while ((nextLine = reader.readNext()) != null) {
					for (String token : nextLine) {
						System.out.print(token + " ");
					}
					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

