package com.go2plus.core.common.web.form;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.support.BindStatus;

import com.go2plus.core.common.web.form.bind.SearchBindStatus;

/**
 * 取值时
 * 1、先取parameter
 * 2、如果找不到再找attribute (page--->request--->session--->application)
 * <p>User: mtwu
 * <p>Date: 13-3-28 下午3:11
 * <p>Version: 1.0
 */
public class CheckboxTag extends org.springframework.web.servlet.tags.form.CheckboxTag {


    private BindStatus bindStatus = null;

    @Override
    protected BindStatus getBindStatus() throws JspException {
        if (this.bindStatus == null) {
            this.bindStatus = SearchBindStatus.create(pageContext, getName(), getRequestContext(), false);
        }
        return this.bindStatus;
    }

    @Override
    protected String getPropertyPath() throws JspException {
        return getPath();
    }


    @Override
    public void doFinally() {
        super.doFinally();
        this.bindStatus = null;
    }
}
