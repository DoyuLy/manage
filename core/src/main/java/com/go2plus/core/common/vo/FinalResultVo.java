package com.go2plus.core.common.vo;

public class FinalResultVo {
  private Boolean status;
  private Object resultVo;
  private String error;
  
  public FinalResultVo (Boolean status, Object resultVo, String error) {
    this.status = status;
    this.resultVo = resultVo;
    this.error = error;
  }
  
  public Boolean getStatus() {
    return status;
  }
  public void setStatus(Boolean status) {
    this.status = status;
  }
  public Object getResultVo() {
    return resultVo;
  }
  public void setResultVo(Object resultVo) {
    this.resultVo = resultVo;
  }
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }
}
