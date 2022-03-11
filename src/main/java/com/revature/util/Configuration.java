package com.revature.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Configuration {


	private List<MetaModel<Class<?>>> metaModelList; // for example, this is a placeholder for metamodels of SuperVillain, SuperPrison, and Crime
	
	// Constructor - addAnnotatedClass
	public Configuration addAnnotatedClasses(List<Class<?>> annotatedClasses) {
		
		// if the metaModelList is null, generate a new LinkedList
		if(metaModelList == null) {
			this.metaModelList = new LinkedList<MetaModel<Class<?>>>();
		}
		
		// iterate through the lists of classes passed through
		for (Class clazz : annotatedClasses ) {
			
			// call the of() method from the MetaModel class in order to generate a MetaModel obj of each class in the list
			this.metaModelList.add(MetaModel.of(clazz)); // this method produces a metamodel object because it calls the constuctor
		}
		// generate a metamodel instance for each one
		
		// add it to the metamodel list
		
		
		return this;
	}
	
	// How do we get all the meta models to process and build tables from ?
	public List<MetaModel<Class<?>>> getMetaModels() {
		// if this list is empty, return emptyList(), otherwise return the list
		return (List<MetaModel<Class<?>>>) ((metaModelList == null) ? Collections.emptyList() : this.metaModelList);
	}
	
	//return a connection object
//	public Connection getConnection(String dbUrl, String dbUsername, String dbPassword) {
//		this.dbUrl = dbUrl;
//		this.dbUsername = dbUsername;
//		this.dbPassword = dbPassword;
//	}
	
	// maybe build an ORM helper class that you would delegate this functionality to
	// SRP - Single Responsibility Principle (SOLID)
	// In OOP, every class has 1 unique purpose, so technically we're currently violating this principle
	
	// In YOUR ORM's make a separate class responsible for connecting to the DB (like the HibernateUtil.java helper class)
	
	
}
