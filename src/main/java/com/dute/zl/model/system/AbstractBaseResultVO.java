package com.dute.zl.model.system;

import java.io.Serializable;

public class AbstractBaseResultVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2839726002797642917L;
	
	private Object tableConfig;
	
	private Object delegateInfo;

	public Object getTableConfig() {
		return tableConfig;
	}

	public void setTableConfig(Object tableConfig) {
		this.tableConfig = tableConfig;
	}

	public Object getDelegateInfo() {
		return delegateInfo;
	}

	public void setDelegateInfo(Object delegateInfo) {
		this.delegateInfo = delegateInfo;
	}
	
}
