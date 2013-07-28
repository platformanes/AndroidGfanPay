package com.gfan.pay.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.uc.GfanUCenter;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class GfanPayLogout implements FREFunction {
	private String TAG = "GfanPayLogout";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			startGfanLogout();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayLogout faild");
			return null;
		}
		
		return null;
	}

	/**
	 * logout
	 */
	
	private void startGfanLogout() {
		GfanUCenter.logout(this._context.getActivity());
		sendMsgBacktoAS("GfanPayLogout success");
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
