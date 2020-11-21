package com.yc.teach;

import java.util.*;

public class TeachInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Set<String>> classMap = new LinkedHashMap<>();
	private Set<String> appSet = new LinkedHashSet<>();

	public Set<String> getAppSet() {
		return appSet;
	}

	public Map<String, Set<String>> getClassMap() {
		return classMap;
	}
}
