package lesson_07.reflection;

//@NotBlank
public class Human {
	@NotBlank(message = "Human.class cannot be empty or blank")
	private String privateField;
	String defaultField;
	@NotBlank
	protected String protectedField;
	public String publicField;

//	@NotBlank
	public Human() {
	}

//	@NotBlank
	public Human(String privateField, String defaultField, String protectedField, String publicField) {
		this.privateField = privateField;
		this.defaultField = defaultField;
		this.protectedField = protectedField;
		this.publicField = publicField;
	}

	public void publicGo() {
		System.out.println("GO!-public");
	}

	private void privateGo() {
		System.out.println("GO!-private");
	}

	@Override
	public String toString() {
		return "Human{" +
				"privateField='" + privateField + '\'' +
				", defaultField='" + defaultField + '\'' +
				", protectedField='" + protectedField + '\'' +
				", publicField='" + publicField + '\'' +
				'}';
	}
}
