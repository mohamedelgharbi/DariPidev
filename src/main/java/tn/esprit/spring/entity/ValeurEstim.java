package tn.esprit.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Valeur")
public class ValeurEstim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private float result;

	public ValeurEstim() {
		super();
	}

	public ValeurEstim(int id, float result) {
		super();
		Id = id;
		this.result = result;
	}

	public ValeurEstim(float result) {
		super();
		this.result = result;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ValeurEstim [Id=" + Id + ", result=" + result + "]";
	}
	
	
	

}