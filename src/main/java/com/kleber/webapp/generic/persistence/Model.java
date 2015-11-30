package com.kleber.webapp.generic.persistence;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class Model extends Object {

	public abstract Object getId();

	public String genUUID() {
		return UUID.randomUUID().toString();
	}

	public boolean equals(Model object) {
		return getId().equals(object.getId());
	}

	public abstract String toString();

	public List<?> getFields() {
		return Arrays.asList(this.getClass().getFields());
	}

	public List<?> getMethods() {
		return Arrays.asList(this.getClass().getMethods());
	}

	public Object getValue(String field) {
		String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1, field.length());
		try {
			Object value = this.getClass().getMethod(methodName).invoke(this);
			return value;
		} catch (Exception e) {
			return null;
		}
	}
}
