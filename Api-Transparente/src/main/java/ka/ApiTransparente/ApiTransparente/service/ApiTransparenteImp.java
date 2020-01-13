package ka.ApiTransparente.ApiTransparente.service;

import java.util.List;

import ka.ApiTransparente.ApiTransparente.FakeJPA.FakeJPA;
import ka.ApiTransparente.ApiTransparente.FakeJPA.FakeJPAImp;
import ka.ApiTransparente.ApiTransparente.models.RequestBod;
import ka.ApiTransparente.ApiTransparente.models.Response;

public class ApiTransparenteImp implements ApiTransparente {
	
	FakeJPA fakeJPA = new FakeJPAImp();
	
	@Override
	public Response GetOneId(int id) {
		
		return fakeJPA.getOneIdJPA(id);
	}
	
	@Override
	public List<Response> GetAllId(){
		return fakeJPA.getAllJPA();
	}

	@Override
	public String ModifyOneId(RequestBod requestBod) {
		fakeJPA.modifyOne(requestBod);
		return "Done";
		
	}

	@Override
	public String GetOneName(String name) {
		return "se entro al servicio";
	}

}
