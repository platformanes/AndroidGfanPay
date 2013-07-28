package com.gfan.pay.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.common.utils.BaseUtils;
import com.mappn.sdk.pay.GfanPay;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class GfanPayExit implements FREFunction {
	private String TAG = "GfanPayExit";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			BaseUtils.D(TAG, "Actitivy destroy");
			GfanPay.getInstance(this._context.getActivity().getApplicationContext()).onDestroy();
			sendMsgBacktoAS("function GfanPayExit success");
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayExit faild");
			return null;
		}
		return null;
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
