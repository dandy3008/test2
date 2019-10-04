package id.dans.test2;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Test2Application {

	@Value("${url.server}")
	String httpsUrl;
	
	@Value("${login.user}")
	String loginUser;
	
	@Value("${login.pass}")
	String loginPass;	
	
	InvokerHttps invoker = null;

	
	@GetMapping("/login/{userid}/{pass}")
	public boolean login(@PathVariable String userid, @PathVariable String pass) {
		/**
		 * Hanya applikasi tes ini login user melihat data properties.
		 * Untuk aplikasi real login bisa query ke database atau integrasi ke system lain misal LDAP
		 * dengan password yang dikirim sudah terenkripsi
		 */
		if(userid.equals(loginUser) && pass.equals(loginPass)){
			//Untuk keperluan trace di prod, sebaiknya menggunakan misal log4j daripada sysout
			System.out.println("Login berhasil");
			return true;
		}else {
			System.out.println("Login gagal");
			return false;
		}
	}
	
	@RequestMapping("/employee")
	public String allDataEmployee() {
		if (null==invoker) {
			invoker = new InvokerHttps(httpsUrl);
		}
		return invoker.getAllDataEmployee();
	}

	@GetMapping("/employee/{id}")
	public String dataEmployeeById(@PathVariable String id) {
		if (null==invoker) {
			invoker = new InvokerHttps(httpsUrl);
		}
		return invoker.getDataEmployeeById(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Test2Application.class, args);
	}

}
