package com.revature.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinColumn {

	String columnName();
	
//	int mappedBy(); // This would point to the property of the object whose primary key is the foreign key is referring to
}
