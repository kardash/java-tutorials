package com.addressbook.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TABLE2")
public class Table2 extends AbstractEntity {
	
	private int column1;
	
	//@ManyToOne
	//private Table1 table1;
	
	public int getColumn1() {
		return column1;
	}
	
	public void setColumn1(int column1) {
		this.column1 = column1;
	}
	
	//public Table1 getTable1() {
	//	return table1;
	//}
	
	//public void setTable1(Table1 table1) {
	//	this.table1 = table1;
	//}
}
