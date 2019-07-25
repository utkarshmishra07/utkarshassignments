package com.mphasis.cart.beans;

import java.util.ListResourceBundle;
import java.util.Objects;

public class message extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		// TODO Auto-generated method stub
		return contents;
	}
		
	static final Object[][] contents= {
			{"snacks.pani","panipuri"},
			{"snacks.bhel","bhelpuri"},
			{"snacks.masala","masalapuri"}
	};
}
