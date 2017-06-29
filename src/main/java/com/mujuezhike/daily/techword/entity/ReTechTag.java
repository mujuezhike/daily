package com.mujuezhike.daily.techword.entity;

import java.io.Serializable;
import java.util.Date;

public class ReTechTag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -376602091954145438L;

	private Long id;
	
	private String name;

	private Integer status;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String describe;
	
	private Double weight;
	
	private Long targetWord;
	
	private Long tagWord;
	
	private Long relatedWord;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Long getTargetWord() {
		return targetWord;
	}

	public void setTargetWord(Long targetWord) {
		this.targetWord = targetWord;
	}

	public Long getTagWord() {
		return tagWord;
	}

	public void setTagWord(Long tagWord) {
		this.tagWord = tagWord;
	}

	public Long getRelatedWord() {
		return relatedWord;
	}

	public void setRelatedWord(Long relatedWord) {
		this.relatedWord = relatedWord;
	}

}
