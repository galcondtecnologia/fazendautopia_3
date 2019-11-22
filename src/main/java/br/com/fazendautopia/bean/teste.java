package br.com.fazendautopia.bean;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/fazendautopia/pages/confirmacao-pedidos.xhtml");
		
		//Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
		//System.out.println("Tamanho do Cookie: " + cookies.toString());
		
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver);
		LocalStorage localStorage = webStorage.getLocalStorage();
		
		System.out.println(localStorage.getItem("Pedidos"));

	}

}
