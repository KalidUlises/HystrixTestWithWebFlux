package ka.ApiTransparente.ApiTransparente.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Request {
	
	@NotNull(message="{javax.validation.custom.notnull.message}")
	private int id;
	@NotNull(message="{javax.validation.custom.notnull.message}")
	@Size(min=3, max=10,message = "{javax.validation.custom.size.message}")
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Request(@NotNull(message = "{javax.validation.custom.notnull.message}") int id,
			@NotNull(message = "{javax.validation.custom.notnull.message}") @Size(min = 3, max = 10, message = "{javax.validation.custom.size.message}") String name) {
		this.id = id;
		this.name = name;
	}
	public Request() {
	}
	@Override
	public String toString() {
		return "Request [id=" + id + ", name=" + name + "]";
	}

}
