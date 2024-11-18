package E2Edata;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader 
{
	public List<HashMap<String,String>> getDataToMap() throws IOException
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//sr//test//java//E2Edata//purchaseOrder.json"), StandardCharsets.UTF_8);
		
		//convert string to map using jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		return data;
	}
	
}
