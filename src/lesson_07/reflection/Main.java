package lesson_07.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws Exception {
//		doDemoReflectionClass();
//		doDemoReflectionField();
//		doDemoReflectionFieldAccess();
//		doDemoReflectionMethod();
//		doDemoReflectionMethodAccess();
//		doDemoReflectionObjectCreating();
//		doDemoReflectionAnnotationFields();
//		doDemoReflectionAnnotationMethods();
		checkObjectValidate();
	}

	private static void checkObjectValidate() throws Exception {
		Human human = new Human("a", "b", "", "d");
//		Human human = new Human();
		Field privateField = human.getClass().getDeclaredField("privateField");
		Field protectedField = human.getClass().getDeclaredField("protectedField");

		privateField.setAccessible(true);
		String nameValue = (String) privateField.get(human);
		privateField.setAccessible(false);

		protectedField.setAccessible(true);
		String nameValueProtected = (String) protectedField.get(human);
		protectedField.setAccessible(false);

		if (nameValue == null || "".equals(nameValue)) {
			NotBlank declaredAnnotation = privateField.getDeclaredAnnotation(NotBlank.class);
			throw new IllegalArgumentException(declaredAnnotation.message());
		}

		if (nameValueProtected == null || "".equals(nameValueProtected)) {
			NotBlank declaredAnnotation = protectedField.getDeclaredAnnotation(NotBlank.class);
			throw new IllegalArgumentException(declaredAnnotation.message());
		}

		System.out.println(human);
	}

	private static void doDemoReflectionAnnotationMethods() throws Exception {
		Object human = new Human();
		Class<?> object = human.getClass();

		Method[] declaredMethods = object.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			Annotation[] declaredAnnotationsField = declaredMethods[i].getDeclaredAnnotations();
			for (int j = 0; j < declaredAnnotationsField.length; j++) {
				System.out.println(declaredAnnotationsField[j]);
				System.out.println("Type: " + declaredAnnotationsField[i].annotationType());
				System.out.println("--------");
			}
		}
	}

	private static void doDemoReflectionAnnotationFields() throws Exception {
		Object human = new Human();
		Class<?> object = human.getClass();

		Annotation[] declaredAnnotations = object.getDeclaredAnnotations();
		for (int i = 0; i < declaredAnnotations.length; i++) {
			System.out.println(declaredAnnotations[i]);
			System.out.println("Type: " + declaredAnnotations[i].annotationType());
		}

		Field[] declaredFields = object.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			Annotation[] declaredAnnotationsField = declaredFields[i].getDeclaredAnnotations();
			for (int j = 0; j < declaredAnnotationsField.length; j++) {
				System.out.println(declaredAnnotationsField[j]);
				System.out.println("Type: " + declaredAnnotationsField[i].annotationType());
				System.out.println("--------");
			}
		}
	}

	private static void doDemoReflectionObjectCreating() throws Exception {
		Class humanClass = Human.class;
		Constructor humanConstructorWithoutArgs = humanClass.getConstructor();
		Constructor humanConstructorWithArgs = humanClass.getConstructor(
				String.class, String.class, String.class, String.class
		);

		Human human1 = (Human) humanConstructorWithoutArgs.newInstance();
		Human human2 = (Human) humanConstructorWithArgs.newInstance("arg1", "arg2", "arg3", "arg4");

		System.out.println(human1);
		System.out.println(human2);
	}

	private static void doDemoReflectionMethodAccess() throws Exception {
		Object human = new Human();
		Class<?> object = human.getClass();

		Method privateGoMethod = object.getDeclaredMethod("privateGo");
		privateGoMethod.setAccessible(true);
		privateGoMethod.invoke(human);
		privateGoMethod.setAccessible(false);
	}

	private static void doDemoReflectionMethod() throws Exception {
		Object human = new Human();
		Class<?> object = human.getClass();

		Method[] methods = object.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
			System.out.println("Modifier: " + methods[i].getModifiers());
			System.out.println("R-Type: " + methods[i].getReturnType());
			System.out.println("Name: " + methods[i].getName());
			System.out.println("--------");
		}
	}

	private static void doDemoReflectionFieldAccess() throws Exception {
		Object human = new Human();
		Class<?> object = human.getClass();

		Field fieldName = object.getDeclaredField("privateField");
		fieldName.setAccessible(true);
		fieldName.set(human, "test private string");
		fieldName.setAccessible(false);
		System.out.println(human);
	}

	private static void doDemoReflectionField() {
		Object human = new Human();
		Class<?> object = human.getClass();

		Field[] fields = object.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}

		System.out.println("---------------------");

		Field[] declaredFields = object.getDeclaredFields();
		for (int i = 0; i < declaredFields.length; i++) {
			System.out.println(declaredFields[i]);
			System.out.println("Modifier: " + declaredFields[i].getModifiers());
			System.out.println("Type: " + declaredFields[i].getType());
			System.out.println("Name: " + declaredFields[i].getName());
			System.out.println("--------");
		}

		System.out.println("---------------------");

		try {
			Field protectedField = object.getField("protectedField");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	private static void doDemoReflectionClass() {
		Object human = new Human();

		System.out.println(human.getClass());
		System.out.println(human.getClass().getName());
		System.out.println(human.getClass().getSimpleName());

		Class<?> object = human.getClass();
		int modifiers = object.getModifiers();
		System.out.println(modifiers);
		System.out.println("PUBLIC: " + Modifier.isPublic(modifiers));
		System.out.println("ABSTRACT: " + Modifier.isAbstract(modifiers));

	}
}
