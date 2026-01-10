package weeklytask3;

public class InstanceUsingMethodReference {

	private String name;
	
	public InstanceUsingMethodReference() {
		
		this.name = "Default Name";
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

interface PersonFactory{
	InstanceUsingMethodReference create();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonFactory factory = InstanceUsingMethodReference::new;
		InstanceUsingMethodReference person = factory.create();
		System.out.println("created Person: " + person.getName());
		

	}

}
