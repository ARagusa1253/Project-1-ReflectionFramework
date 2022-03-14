package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotation.Entity;

public class EntityField {

	private Field field;
	
	public EntityField(Field field) {
		
		if(field.getAnnotation(Entity.class) == null) {
			throw new IllegalStateException("Cannot create ColumnField object! Provided field " + getName() + " is not Annotated with @Entity!");
		}
		this.field = field;
	}
	
	public String getName() {
		return field.getName();
	}
	
	public Class<?> getType() {
		return field.getType();
	}
	
	public String getEntityName() {
		return field.getAnnotation(Entity.class).tableName();
	}
	
}
