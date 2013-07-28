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
public class GfanPayLogin implements FREFunction {
	private String TAG = "GfanPayLogin";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			startGfanLogin();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayLogin faild");
			return null;
		}
		return null;
	}

	/**
	 * login
	 */
	private void startGfanLogin() {
		
		GfanUCenter.login(this._context.getActivity(), new GfanUCCallback() {

			private static final long serialVersionUID = 8082863654145655537L;

			@Override
			public void onSuccess(User user, int loginType) {
				// TODO login success
				String msg = "userName:"+user.getUserName();
				msg += ":userID:"+user.getUid();
				sendMsgBacktoAS(msg);
			}

			@Override
			public void onError(int loginType) {
				sendMsgBacktoAS("GfanPayLogin login error");
			}
		});
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}

}
