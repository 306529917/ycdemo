package com.yc.teach;

import java.util.*;

public class TeachInfo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Set<String>> clsMap = new LinkedHashMap<>();
	private Map<String,String> appMap = new LinkedHashMap<>();

	public Map<String,String> getAppMap() {
		return appMap;
	}

	public Map<String, Set<String>> getClsMap() {
		return clsMap;
	}
}
