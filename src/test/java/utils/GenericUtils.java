package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}


	public void scrollIntoViewByPartialText(String partialText) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		String script = "var elements = document.getElementsByTagName('*');"
				+ "for (var i = 0; i < elements.length; i++) {"
				+ "  if (elements[i].textContent.includes('" + partialText + "')) {"
				+ "    elements[i].scrollIntoView(true);"
				+ "    break;"
				+ "  }"
				+ "}";
		jsExecutor.executeScript(script);
	}

	public void scrollUpTo(WebElement webElement){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	static String filePath="C:\\Users\\naratreddy\\Documents\\CucumberPractise\\src\\test\\resources\\products.csv";

	public void writeCsv(List<String> data) {
		try (FileWriter writer = new FileWriter(filePath, true)) {
			StringBuilder csvLine = new StringBuilder();
			for (String value : data) {
				csvLine.append(value).append(",");
			}
			// Remove the trailing comma
			if (csvLine.length() > 0) {
				csvLine.deleteCharAt(csvLine.length() - 1);
			}
			writer.append(csvLine.toString());
			writer.append("\n");
			System.out.println("Data written successfully.");
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	public static void deleteData(){
		try {
			File csvFile = new File(filePath);
			PrintWriter writer = new PrintWriter(csvFile);
			writer.print("");
			writer.close();
			System.out.println("Data deleted successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static ArrayList<ArrayList<String>> readCSVToList() {
		ArrayList<ArrayList<String>> dataArrayList = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				ArrayList<String> row = new ArrayList<>();

				for (String part : parts) {
					row.add(part);
				}

				dataArrayList.add(row);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}

		return dataArrayList;
	}


	
}
