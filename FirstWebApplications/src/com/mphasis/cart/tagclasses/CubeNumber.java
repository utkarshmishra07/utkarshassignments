package com.mphasis.cart.tagclasses;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CubeNumber extends TagSupport{
	private static final long serialVersionUID = 1L;
	private int number;
	public void setNumber(int number)
	{
		this.number=number;
	}
	public int doStartTag() throws JspException{
		JspWriter writer=pageContext.getOut();
		try
		{
			writer.print(number*number*number);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
