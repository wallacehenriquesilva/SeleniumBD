package navegador;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriver {
	
	private WebDriver browser;
	private WebDriverWait wait;
	
	public BrowserDriver() {
		this.createBrowser();
		this.setWait(wait);
	}
	
	public BrowserDriver(WebDriver browser, WebDriverWait wait) {
		super();
		this.browser = browser;
		this.wait = wait;
	}

	public WebDriver getBrowser() {
		return browser;
	}
	
	private void createBrowser() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		FirefoxProfile fp = new FirefoxProfile();
		fp.setAcceptUntrustedCertificates(true);
		/*fp.setPreference("network.proxy.type", 1);
		fp.setPreference("network.proxy.http", "192.168.0.3");
		fp.setPreference("network.proxy.http_port", 8080);
		fp.setPreference("network.proxy.share_proxy_settings", true);
		fp.setPreference("security.enable_java", true);
		fp.setPreference("plugin.state.java", 2);*/

		this.browser = new FirefoxDriver(fp);
	}
	
	public void setBrowser(WebDriver browser) {
		
		this.browser = browser;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	private void setWait(WebDriverWait wait) {
		this.wait = new WebDriverWait(this.browser, 30);
	}
	
}