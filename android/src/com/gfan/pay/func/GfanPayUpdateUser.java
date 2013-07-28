package com.gfan.pay.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.uc.GfanUCCallback;
import com.mappn.sdk.uc.GfanUCenter;
import com.mappn.sdk.uc.User;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class GfanPayUpdateUser implements FREFunction {
	private String TAG = "GfanPayUpdateUser";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			startModfiy();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayUpdateUser faild");
			return null;
		}
		return null;
	}

	/**
	 * modify userName,only onekeyName can modify one chance
	 * @description：
	 * @author xinge21
	 * @time 2012-11-14 下午2:56:22 void:
	 */
	private void startModfiy() {
		GfanUCenter.modfiy(this._context.getActivity(), new GfanUCCallback() {
			@Override
			public void onSuccess(User user, int returnType) {
				if (GfanUCenter.RETURN_TYPE_MODFIY == returnType) {
					//TODO  modify success
					sendMsgBacktoAS("function GfanPayUpdateUser modify success");
				}
			}

			@Override
			public void onError(int returnType) {
				if (GfanUCenter.RETURN_TYPE_MODFIY == returnType) {
					//TODO  modify failure
					sendMsgBacktoAS("function GfanPayUpdateUser modify failure");
				}
			}
		});
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
