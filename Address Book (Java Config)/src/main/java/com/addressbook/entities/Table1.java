package com.addressbook.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TABLE1")
public class Table1 extends AbstractEntity {
	
	private int column1;
	
	@OneToMany
	@JoinTable(name = "t1_t2", joinColumns = @JoinColumn(name = "t1_id"), inverseJoinColumns = @JoinColumn(name = "t2_id"))
	private Set<Table2> table2;
	
	public int getColumn1() {
		return column1;
	}
	
	public void setColumn1(int column1) {
		this.column1 = column1;
	}

	public Set<Table2> getTable2() {
		return table2;
	}

	public void setTable2(Set<Table2> table2) {
		this.table2 = table2;
	}
}
