package ka.ApiTransparente.ApiTransparente.service;

import java.util.List;

import ka.ApiTransparente.ApiTransparente.models.RequestBod;
import ka.ApiTransparente.ApiTransparente.models.Response;

public interface ApiTransparente {
	
	public Response GetOneId(int id);
	public List<Response> GetAllId();
	public String ModifyOneId(RequestBod requestBod);
	public String GetOneName(String string);
}
