package ka.ApiTransparente.ApiTransparente.models;

public class Response {
	
	private int Id;
	private String Status;
	private String Name;
	private String Comments;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	
	
	public Response(int id, String status, String name, String comments) {
		super();
		Id = id;
		Status = status;
		Name = name;
		Comments = comments;
	}
	public Response() {
		super();
	}
	
	public Response(RequestBod requestBod) {
		Id = requestBod.getId();
		Status = requestBod.getStatus();
		Name = requestBod.getName();
		Comments = requestBod.getComments();
	}
	
	
	@Override
	public String toString() {
		return "Response [Id=" + Id + ", Status=" + Status + ", Name=" + Name + ", Comments=" + Comments + "]";
	}
	
	

}
