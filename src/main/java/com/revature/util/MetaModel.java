package com.revature.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.revature.annotation.Column;
import com.revature.annotation.Entity;
import com.revature.annotation.Id;
import com.revature.annotation.JoinColumn;

public class MetaModel<T> {

	private Class<?> clazz;
	private PrimaryKeyField primaryKeyField;
	private List<ColumnField> columnFields;
	private List<ForeignKeyField> foreignKeyFields;
	
	// create a method in which we pass a class through and generate a meta model OF the class
	public static MetaModel<Class<?>> of(Class<?> clazz) {
		// check that the class we're trying to transpose is annotated with @Entity
		if (clazz.getAnnotation(Entity.class) == null) {
			throw new IllegalStateException("Cannot create MetaModel object from this class! Provided class " + clazz.getName() + " is not annotated with @Entity");
		}
		// If it IS annotated with @Entity, generate a MetaModel object of it
		return new MetaModel<Class<?>>(clazz);
	}
	
	// constructor to build a metamodel
	
	public MetaModel(Class<?> clazz) {
		this.clazz = clazz; // Since we've set the class as equal to the original class, we still have intel on its fields
		this.columnFields = new LinkedList<ColumnField>();
		this.foreignKeyFields = new LinkedList<ForeignKeyField>();
	}
	
	// getColumn() - returns a list of ColumnField
	public List<ColumnField> getColumns() {
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
			Column column = field.getAnnotation(Column.class);
			
			if ( column != null) {
				columnFields.add(new ColumnField(field));
			}
		}
		if (columnFields.isEmpty()) {
			throw new RuntimeException("No columns found in: " + clazz.getName());
		}
		
		return columnFields;
	}
	
	public PrimaryKeyField getPrimaryKey() {

		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
			Id primaryKey = field.getAnnotation(Id.class);
			
			if ( primaryKey != null) { 
				this.primaryKeyField = new  PrimaryKeyField(field);
				return new PrimaryKeyField(field); 
			}
		}
		throw new RuntimeException("Did not find a field annotated with @Id in: " + clazz.getName());
	}
	
	public List<ForeignKeyField> getForeignKey() {
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			
			JoinColumn foreignKey = field.getAnnotation(JoinColumn.class);
			
			if ( foreignKey != null) { 
				foreignKeyFields.add(new ForeignKeyField(field));
			}
		}
		if (foreignKeyFields.isEmpty()) {
			throw new RuntimeException("No foreign keys found in: " + clazz.getName());
		}
		return foreignKeyFields;
	}
	
	public String getSimpleClassName() {
		return clazz.getSimpleName();
	}
	
	public String getClassName() {
		return clazz.getName();
	}
}
