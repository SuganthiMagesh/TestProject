package org.project.sample;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Cucumber_BaseClass {
	public static WebDriver driver;
	public static String title;

	public static void browser_launch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

	}

	public static void get(String url) {
		try {
			driver.get(url);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void sendKeys(WebElement element, String value) {
		try {
		element.sendKeys(value);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void click(WebElement element) {
		try {
		element.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		    throw new RuntimeException();
		}
	}

	public static void dropDown(WebElement element, String type, String value) {
		try {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (type.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(value);

		} else if (type.equalsIgnoreCase("index")) {
			int a = Integer.parseInt(value);
			s.selectByIndex(a);
		}

	}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
		public static void getoptions(WebElement Options) {							
			Select s=new Select(Options);
			List<WebElement> opt=s.getOptions();
			for(int i=0;i<opt.size();i++) {
				System.out.println(opt.get(i).getText());
			}
		}
		
		public static void getAllselectedoptions(WebElement element) {			
			Select s=new Select(element);
			List<WebElement> allselect=s.getAllSelectedOptions();
			for(WebElement a:allselect) {
				System.out.println(a.getText());
			}
		}
		
		public static void getfirstselect(WebElement element) {					
			Select s=new Select(element);
			WebElement first=s.getFirstSelectedOption();
			System.out.println(first.getText());
		}
		
		public static void title() {											
			try{
				title = driver.getTitle();
			}
			catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

	public static void navigateto(String url) {
		try {
			driver.navigate().to(url);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void back() {
		try {
		driver.navigate().back();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void forward() {
		try {
		driver.navigate().forward();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void refresh() {
		try {
		driver.navigate().refresh();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void action(WebElement element, String type1, String value) {
		try {
		Actions ac = new Actions(driver);
		if (type1.equalsIgnoreCase("contextclick")) {
			ac.contextClick(element).build().perform();
			
		} else if (type1.equalsIgnoreCase("doubleclick")) {
			ac.doubleClick(element).build().perform();
			
		} else if (type1.equalsIgnoreCase("moveto")) {
			ac.moveToElement(element).build().perform();
			
		} else if (type1.equalsIgnoreCase("movetoelement")) {
			int b = Integer.parseInt(value);
			ac.moveToElement(element, 0, 0).build().perform();
			
		} else if (type1.equalsIgnoreCase("clickandhold")) {
			ac.clickAndHold(element).build().perform();

		} else if (type1.equalsIgnoreCase("draganddrop")) {
			ac.dragAndDrop(element, element).build().perform();	
		}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void alert(String type2, String value) {
		try {
		if (type2.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (type2.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (type2.equalsIgnoreCase("gettext")) {
			String text = driver.switchTo().alert().getText();
			System.out.println(text);
		} else if (type2.equalsIgnoreCase("sendkeys")) {
			driver.switchTo().alert().sendKeys(value);
		}
	    }
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void close() {
		try {
		driver.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	public static void quit() {
		try {
		driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
