package com.learn.Test;


import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlFileParser {

	
	public static void readHtml(String fileName) throws IOException {
		//Document doc = Jsoup.connect("https://www.w3schools.com/").get();
		
		Document doc = Jsoup.parse(new File(fileName));
		Elements divtags = doc.select("div");

		for (Element div : divtags) {
			if(div.attr("class").contentEquals("footerlinks_1")) {
				
				if(div.select("a").attr("href").contentEquals("/plus/index.php")) {
					System.out.println(div.select("a").text());
				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		readHtml("w3schools.html");
	}
}
