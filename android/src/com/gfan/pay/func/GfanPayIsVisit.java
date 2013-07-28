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
public class GfanPayIsVisit implements FREFunction {
	private String TAG = "GfanPayIsVisit";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			isOnekeyUser();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayIsVisit faild");
			return null;
		}
		return null;
	}

	/**
	 * whether Tourists account
	 * @description：
	 * @author xinge21
	 * @time 2012-12-11 上午10:58:53 void:
	 */
	private void isOnekeyUser() {
		sendMsgBacktoAS((GfanUCenter.isOneKey(this._context.getActivity())?"yes":"no")+" Tourists account");
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
