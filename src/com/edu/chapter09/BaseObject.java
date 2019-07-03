package com.edu.chapter09;

import java.io.Serializable;

public abstract class BaseObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private DirtyState dirtyState;
	private Long objectId;
	
	public DirtyState getDirtyState() {
		return dirtyState;
	}
	
	public void setDirtyState(DirtyState dirtyState) {
		this.dirtyState = dirtyState;
	}
}
