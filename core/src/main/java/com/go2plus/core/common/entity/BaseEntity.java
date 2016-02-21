package com.go2plus.core.common.entity;

public abstract class BaseEntity extends AbstractEntity<Long> {

    protected Long id;
    
    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }
  }
