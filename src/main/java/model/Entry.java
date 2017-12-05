package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the entry database table.
 * 
 */
@Entity
@NamedQuery(name="Entry.findAll", query="SELECT e FROM Entry e")
public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;

	public Entry() {
	}

}