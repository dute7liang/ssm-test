package com.dute.zl.model;

import java.util.Date;

/**
 * 数据实体     以班级人做对象
* @Description: 
* @author zl
* @date 2017年11月10日 上午9:58:26 
* @version V1.0
 */
public class TableEntity {
	
	private String name;
	
	private Integer age;
	
	private Date birthDay;
	
	private Double grade;
	
	private String clas;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}
	
	
	
	
	
	
}
