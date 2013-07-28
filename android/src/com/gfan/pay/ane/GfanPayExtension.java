package com.gfan.pay.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.gfan.pay.ane.GfanPayContext;
/**
 * 
 * @author Rect 2013-5-5
 */
public class GfanPayExtension implements FREExtension {

	@Override
	public FREContext createContext(String arg0) {
		// TODO Auto-generated method stub
		return new GfanPayContext();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override 
	public void initialize() {
		// TODO Auto-generated method stub

	}

}
