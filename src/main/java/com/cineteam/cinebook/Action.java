package com.cineteam.cinebook;
import javax.servlet.http.HttpServletRequest;

public interface Action {

    public String execute(HttpServletRequest request);

}

