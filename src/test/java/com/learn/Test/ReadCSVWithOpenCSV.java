package com.learn.Test;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadCSVWithOpenCSV {
	public static void main(String[] args) throws CsvValidationException {
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
