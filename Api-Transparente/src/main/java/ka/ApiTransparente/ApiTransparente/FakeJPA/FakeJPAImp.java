package ka.ApiTransparente.ApiTransparente.FakeJPA;

import java.util.List;
import java.util.stream.Collectors;

import ka.ApiTransparente.ApiTransparente.models.RequestBod;
import ka.ApiTransparente.ApiTransparente.models.Response;

public class FakeJPAImp implements FakeJPA {

	@Override
	public Response getOneIdJPA (int id) {
		return  JPAList.stream()
				.filter(n -> n.getId()==id )
				.collect(Collectors.toList())
				.get(0);
	}
	
	@Override
	public List<Response> getAllJPA (){
		return JPAList;
	}

	@Override
	public String modifyOne(RequestBod requestBod) {
		Response temprequestBod = getOneIdJPA(requestBod.getId());
		JPAList.set(JPAList.indexOf(temprequestBod), new Response(requestBod) );
		
		return null;
	}
	
	
}
