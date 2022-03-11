package com.revature.inspection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ClassInspector {

public static void inspectClass(Class<?> clazz) { // we need to use clazz instead of class because that's a keyword
		
		listPublicFields(clazz);
		listNonPublicFields(clazz);
	}
	
	public static void listPublicFields(Class<?> clazz) {
		
		System.out.println("Printing out the public fields of the class " + clazz.getSimpleName());
		
		// capture an array of fields that belong to the class // Field comes from java.lang.reflect
		Field[] fields = clazz.getFields();
		
		if (fields.length == 0) {
			System.out.println("\nThere are no public fields in " + clazz.getSimpleName());
		}
		
		// iterate over them and check if they're public, then print them out with their type
		for (Field field : fields) {
			System.out.println("\tField name: " + field.getName());
			System.out.println("\tField type: " + field.getType());
			System.out.println("\tIs the field primitive?: " + field.getType().isPrimitive());
			System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
		}
	}
	
	// listpublicMethods
	
	// listNonPublicFields
public static void listNonPublicFields(Class<?> clazz) {
		
		System.out.println("Printing out the non-public fields of the class " + clazz.getSimpleName());
		
		// capture an array of fields that belong to the class // Field comes from java.lang.reflect
		Field[] fields = clazz.getDeclaredFields();
		
		if (fields.length == 0) {
			System.out.println("\nThere are no non-public fields in " + clazz.getSimpleName());
		}
		
		// iterate over them and check if they're non-public, then print them out with their type
		for (Field field : fields) {
			
			if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) { // && stops evaluating if the first op
				continue;
			}
				System.out.println("\tField name: " + field.getName());
				System.out.println("\tField type: " + field.getType());
				System.out.println("\tIs the field primitive?: " + field.getType().isPrimitive());
				System.out.println("\tModifiers bit value: " + Integer.toBinaryString(field.getModifiers()));
			
			
		}
	}
}
