package com.mujuezhike.daily.techword.entity.vo;

import com.mujuezhike.daily.techword.entity.ETechWord;
import com.mujuezhike.daily.techword.entity.ReTechTag;

public class ReTechTagWithWord extends ReTechTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6156023567357443274L;

	private ETechWord targetWordBean;
	
	private ETechWord tagWordBean;
	
	private ETechWord relatedWordBean;

	public ETechWord getTargetWordBean() {
		return targetWordBean;
	}

	public void setTargetWordBean(ETechWord targetWordBean) {
		this.targetWordBean = targetWordBean;
	}

	public ETechWord getTagWordBean() {
		return tagWordBean;
	}

	public void setTagWordBean(ETechWord tagWordBean) {
		this.tagWordBean = tagWordBean;
	}

	public ETechWord getRelatedWordBean() {
		return relatedWordBean;
	}

	public void setRelatedWordBean(ETechWord relatedWordBean) {
		this.relatedWordBean = relatedWordBean;
	}
	
}
