package ka.ApiTransparente.ApiTransparente.FakeJPA;

import java.util.ArrayList;
import java.util.List;

import ka.ApiTransparente.ApiTransparente.models.RequestBod;
import ka.ApiTransparente.ApiTransparente.models.Response;

public interface FakeJPA {
	
	public static List<Response> JPAList = new ArrayList<Response>();
	
	public static void createdTheList() {
		JPAList.add(new Response(1,"IBM", "Giovani", "no llego temprano"));
		JPAList.add(new Response(2,"IBM Master", "Carlos", "no llego temprano"));
		JPAList.add(new Response(3,"Java Developer", "Oswin", "Trabaja aburrido sin Arthur"));
		JPAList.add(new Response(4,"Java Developer", "Arthur", "Se fue a Sante Fe"));
		JPAList.add(new Response(5,"Java developer Master", "Manu", "Se tiene que ir a Santa Fe"));
		JPAList.add(new Response(6,"Java Developer Master", "JLO", "No se donde este"));
		JPAList.add(new Response(7,"Java Developer Master", "Gus", "Se perdio al tomar el camion"));
		JPAList.add(new Response(8,"SCRUM Master", "David", "Ya esta en Sante Fe"));
		JPAList.add(new Response(9,"Bussines Owner", "Carlos II", "Quiere desayunar dulces"));		
	}
	
	public Response getOneIdJPA (int id);
	public List<Response> getAllJPA ();
	public String modifyOne(RequestBod requestbod);

}
