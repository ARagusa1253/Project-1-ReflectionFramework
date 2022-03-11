package com.revature.util;

import java.lang.reflect.Field;

import com.revature.annotation.JoinColumn;

public class ForeignKeyField {

	private Field field; 
	
	public ForeignKeyField(Field field) {
		
		if(field.getAnnotation(JoinColumn.class) == null) { 
			throw new IllegalStateException("Cannot create ColumnField object! Provided field " + getName() + " is not Annotated with @JoinColumn!");
		}
		this.field = field;
	}
	
	public String getName() {
		return field.getName();
	}
	
	public Class<?> getType() {
		return field.getType(); 
	}
	
		public String getColumnName() {
		return field.getAnnotation(JoinColumn.class).columnName(); 
	}
}
