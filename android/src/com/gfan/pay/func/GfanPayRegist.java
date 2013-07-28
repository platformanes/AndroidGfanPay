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
public class GfanPayRegist implements FREFunction {
	private String TAG = "GfanPayRegist";
	private FREContext _context;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			startGfanRegister();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayRegist faild");
			return null;
		}
		return null;
	}

	/**
	 * register account
	 */
	private void startGfanRegister() {
		GfanUCenter.regist(this._context.getActivity(), new GfanUCCallback() {

			private static final long serialVersionUID = 6967267290737180773L;

			@Override
			public void onSuccess(User user, int loginType) {
				if (GfanUCenter.RETURN_TYPE_LOGIN == loginType) {
					// login success from oneKeyLogin
				} else {
					// register success
				}
				String msg = "userName:"+user.getUserName();
				msg += ":userID:"+user.getUid();
				sendMsgBacktoAS(msg);
			}

			@Override
			public void onError(int loginType) {
				sendMsgBacktoAS("GfanPayRegist reg error");
			}
		});
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
