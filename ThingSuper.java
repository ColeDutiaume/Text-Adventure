package txt_adventure;

public abstract class ThingSuper {
	
	private String name;
	private String description;
	
	public ThingSuper(String aName, String aDesc) {
		
		this.name = aName;
		this.description = aDesc;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
