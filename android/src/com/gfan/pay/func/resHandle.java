package com.gfan.pay.func;

import com.adobe.fre.FREContext;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class resHandle {
	public static void setResourctID(FREContext _context,String TAG)
	{
		if(com.mappn.sdk.R.id.account_check == _context.getResourceId("id.account_check") &&
				com.mappn.sdk.R.color.text_gray == _context.getResourceId("color.text_gray"))
			return;
	}
}
