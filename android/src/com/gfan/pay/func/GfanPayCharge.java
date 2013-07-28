package com.gfan.pay.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.pay.GfanChargeCallback;
import com.mappn.sdk.pay.GfanPay;
import com.mappn.sdk.uc.User;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class GfanPayCharge implements FREFunction {
	private String TAG = "GfanPayCharge";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			startGfanCharge();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayPaySample faild");
			return null;
		}
		return null;
	}

	/**
	 * charge
	 */
	private void startGfanCharge() {

		GfanPay.getInstance(this._context.getActivity().getApplicationContext()).charge(
				new GfanChargeCallback() {

					@Override
					public void onSuccess(User user) {
						if (user==null) {
							return;
						}
						sendMsgBacktoAS("charge success user：" + user.getUserName());
					}

					@Override
					public void onError(User user) {
						if (user != null) {
							sendMsgBacktoAS("charge failure user：" + user.getUserName());
						} else {
							sendMsgBacktoAS("failed login");
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
