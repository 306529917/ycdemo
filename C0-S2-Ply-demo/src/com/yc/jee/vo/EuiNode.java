package com.yc.jee.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EuiNode {

	private String id;
	private String text;
	private String iconCls;
	private String state;
	private List<EuiNode> children;
	private Map<String, Object> attributes;

	public EuiNode() {
	}

	public EuiNode(String text) {
		this.id = text;
		this.text = text;
	}

	public EuiNode(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public EuiNode(String id, String text, String state) {
		this.id = id;
		this.text = text;
		this.state = state;
	}

	public static EuiNode create(String... nameAndValues) {
		EuiNode ret = new EuiNode();
		for (int i = 0; i < nameAndValues.length / 2; i += 2) {
			if (nameAndValues[i] != null) {
				switch (nameAndValues[i]) {
				case "id":
					ret.id = nameAndValues[i + 1];
					break;
				case "text":
					ret.text = nameAndValues[i + 1];
					break;
				case "iconCls":
					ret.iconCls = nameAndValues[i + 1];
					break;
				case "state":
					ret.state = nameAndValues[i + 1];
					break;
				default:
					ret.setAttribute(nameAndValues[i], nameAndValues[i + 1]);
				}
			}
		}
		return ret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<EuiNode> getChildren() {
		return children == null ? (children = new ArrayList<>()) : children;
	}

	public void setChildren(List<EuiNode> children) {
		this.children = children;
	}

	public EuiNode pushChild(EuiNode en) {
		getChildren().add(en);
		return this;
	}

	public EuiNode appendChild(EuiNode en) {
		getChildren().add(en);
		return en;
	}

	public void setAttribute(String key, Object value) {
		if (attributes == null) {
			attributes = new HashMap<String, Object>();
		}
		;
	}

}
