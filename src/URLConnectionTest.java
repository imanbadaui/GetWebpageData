import java.io.IOException;
import java.net.*;
import java.util.*;

public class URLConnectionTest {

	public static void main(String[] args) {
		System.out.println("Copy URL from browser and paste it here!");
		
		Scanner sc = new Scanner(System.in);
		
		String urlString = new String(sc.nextLine());
		
		URL url = null;
		URLConnection urlConnection = null;
		try {
			url = new URL(urlString);
			urlConnection = url.openConnection();
			urlConnection.connect();
			Map<String, List<String>> headers = urlConnection.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
				String fieldKey = entry.getKey();
				for (String value : entry.getValue()) {
					System.out.println(fieldKey + ": " + value);
				}
			}
			System.in.read();
			System.out.println("---------------");
			System.out.println("getContentType: " + urlConnection.getContentType());
			System.out.println("getContentlength: " + urlConnection.getContentLength());
			System.out.println("getContentEncoding: " + urlConnection.getContentEncoding());
			System.out.println("getContentType: " + urlConnection.getDate());
			System.out.println("getContentType: " + urlConnection.getExpiration());
			System.out.println("getContentType: " + urlConnection.getLastModified());
			System.out.println("---------------");

			String encoding = urlConnection.getContentEncoding();
			if (encoding == null) {
				encoding = "UTF-8";
			}
			System.in.read();
			Scanner scanner = new Scanner(urlConnection.getInputStream(), encoding);
			for (int n = 1; scanner.hasNextLine() && n <= 10; ++n) {
				System.out.println(scanner.nextLine());
				if (scanner.hasNextLine()) {
					System.out.println(". . .");
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
