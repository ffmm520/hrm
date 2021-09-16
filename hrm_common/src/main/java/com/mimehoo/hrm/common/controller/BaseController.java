package com.mimehoo.hrm.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request  = request;
        this.response  = response;
        this.companyId = "1437710064201887744";
        this.companyName = "吃嘛嘛香";
    }
}
