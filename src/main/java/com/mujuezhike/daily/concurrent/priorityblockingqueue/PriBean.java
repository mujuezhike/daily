package com.mujuezhike.daily.concurrent.priorityblockingqueue;

public class PriBean implements Comparable<PriBean>{

	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public int compareTo(PriBean o) {
		Long s1 = 0l;
		Long s2 = 0l;
		if(this.getId()!=null){
			s1 = this.getId();
		}
		if(o.getId()!=null){
			s2 = o.getId();
		}
		
		return (int) (s1 - s2);
	}

	@Override
	public String toString() {
		return "PriBean [id=" + id + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
