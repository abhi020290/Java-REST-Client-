import java.io.IOException;
import java.util.Arrays;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



public class ServiceRestClient {

	public static final String REST_SERVICE_URI = "https://url";
	

	/**
	 * GET
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	private static void callGETService(int location) throws JsonGenerationException, JsonMappingException, IOException {
		
		String locationNumber = String.valueOf(location);
		ObjectMapper mapper = new ObjectMapper();
		String REST_SERVICE = REST_SERVICE_URI + "/getMethodCompleteURLwithdata?"
				+ "userId=" + User + "&locationNumber=" + locationNumber;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);
		
		ResponseEntity<ResponseListJSON> response = restTemplate.exchange(
				REST_SERVICE,HttpMethod.GET,entity, ResponseListJSON.class);
		
		System.out.println("Response Status Code "+response.getStatusCode());
		ResponseObject response = response.getBody().getModule();
		
	}

	/**
	 * Get 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	private static void callAnotherGetService(String data ,  int locationid) throws JsonGenerationException, JsonMappingException, IOException {
		
		String REST_SERVICE = REST_SERVICE_URI
				+ "getActualURLWithData?id=" + id
				+ "&userid=" + User + "&location=" + location;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> reqEntity = new HttpEntity<String>("parameters",
				headers);
		
		ResponseEntity<ObjectJSON> response = restTemplate.exchange(
				REST_SERVICE, HttpMethod.GET, reqEntity,
				ObjectJSON.class);
		System.out.println("Response Status Code "+response.getStatusCode());
		ResponseObject cont = response.getBody().getData();
		
		System.out.println(mapper.writeValueAsString(cont));
		System.out.println();
	}

	/**
	 * Post Create Container for Trade In Containers exchange() Method
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public static String callPOSTService(ModelObject req) throws JsonGenerationException, JsonMappingException, IOException  {

		
		String url = REST_SERVICE_URI + "createData";
		
		String containerId = null;
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String request = mapper.writeValueAsString(req);
		HttpEntity<String> reqEntity = new HttpEntity<String>(request, headers);

		ResponseEntity<ObjectJSON> response = restTemplate.exchange(
				url, HttpMethod.POST, reqEntity, ObjectJSON.class);
		
		System.out.println("Response Status Code "+response.getStatusCode());
		ResponseObject cont = response.getBody().getData();
		
		
		return Id;
	}
	

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		
		

	}

}
