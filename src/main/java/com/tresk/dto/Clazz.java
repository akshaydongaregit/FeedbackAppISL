package com.tresk.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


public class Clazz {

	private int classId;
	private String className ;
	private int isActive;
	
	public Clazz() {
		
	}
	
	
	public Clazz(int classId, String className, int isActive) {
		
		this.classId = classId;
		this.className = className;
		this.isActive = isActive;
		
	}


	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Clazz [classId=" + classId + ", className=" + className + ", isActive=" + isActive + "]";
	}
	
	
}
