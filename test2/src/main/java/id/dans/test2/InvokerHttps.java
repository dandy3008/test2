package id.dans.test2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.Gson;


public class InvokerHttps {
	
	String httpsURL = "";
    URL myUrl = null; 
    HttpsURLConnection conn = null; 
    
	public InvokerHttps(String httpsURL) {
		this.httpsURL = httpsURL;
	}
	
	
	
	
	public String getAllDataEmployee() {
		String output = null;
		InputStreamReader isr = null;
        BufferedReader br = null;
        InputStream is = null;
		try {
			String api = httpsURL+"/positions.json";
			System.out.println(api);
	        myUrl = new URL(api);//"https://jobs.github.com/positions.json");
	        System.out.println("2");
	        conn = (HttpsURLConnection)myUrl.openConnection();
	        System.out.println("3");
	        is = conn.getInputStream();
	        isr = new InputStreamReader(is);
	        br = new BufferedReader(isr);
	
	        String inputLine;
	
	        while ((inputLine = br.readLine()) != null) {
	            System.out.println(inputLine);
	            output = inputLine;
	            
	            /**jika ingin di konversi ke Java object... buka comment dibawah*/
//	            Gson gson = new Gson();
//	            EmployeeModel[] em = gson.fromJson(output, EmployeeModel[].class);
	            /** return value method diganti juga dari string ke array object class */
//	            return em[];
	            
	        }	       	      	        
		}catch(Exception e) {
			System.out.println("GetAllDataEmployee Exeption :"+e.toString());					
		}finally {
			try {is.close();}catch (Exception e) {};
			try {isr.close();}catch (Exception e) {};
			try {br.close();}catch (Exception e) {}
		}
		return output;
	}

	

	public String getDataEmployeeById(String id) {
		String output = null;
		InputStreamReader isr = null;
        BufferedReader br = null;
        InputStream is = null;
		try {
			String api = httpsURL + "/positions/"+id+".json";
			System.out.println(api);
	        myUrl = new URL(api);
	        conn = (HttpsURLConnection)myUrl.openConnection();
	        System.out.println("1");
	        is = conn.getInputStream();
	        isr = new InputStreamReader(is);
	        br = new BufferedReader(isr);
	        System.out.println("2");
	        String inputLine;
	        System.out.println("3");
	        while ((inputLine = br.readLine()) != null) {
	            System.out.println(inputLine);	            
	            output = inputLine;
	            
	            /** jika ingin dikonversi ke Java Object .... buka comment dibawah */
//	            Gson gson = new Gson();
//	            EmployeeModel em = gson.fromJson(inputLine, EmployeeModel.class);
	            /** return value method diganti juga dari string ke object class */
//	            return em;
	            
	        }	
	        	        
		}catch(Exception e) {
			System.out.println("GetDataEmployeeById Exception : "+e.toString());
		}finally {
			try {is.close();}catch (Exception e) {};
			try {isr.close();}catch (Exception e) {};
			try {br.close();}catch (Exception e) {}
		}
		
		return output;
		
	  }
}
