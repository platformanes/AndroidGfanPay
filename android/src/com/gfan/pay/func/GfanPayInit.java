package com.gfan.pay.func;


import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.common.utils.BaseUtils;
import com.mappn.sdk.pay.GfanConfirmOrderCallback;
import com.mappn.sdk.pay.GfanPay;
import com.mappn.sdk.pay.model.Order;
import com.mappn.sdk.uc.util.UserUtil;

/**
 * @author Rect
 * @version  Time：2013-7-27
 */
public class GfanPayInit implements FREFunction {
	private String TAG = "GfanPayInit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		
		try
		{
			BaseUtils.D(TAG, "onCreate");
			BaseUtils.D(TAG, "Tourists account :"+UserUtil.getOnekeyName(this._context.getActivity()));
			GfanPay.getInstance(this._context.getActivity().getApplicationContext()).init();

			/**
			 * confirm orderId 
			 */
			GfanPay.getInstance(this._context.getActivity().getApplicationContext()).confirmPay(new GfanConfirmOrderCallback() {

				@Override
				public void onExist(Order order) {
					if (order != null) {
						/**
						 * The oreder which you miss will be here if order isn't null
						 */
						BaseUtils.D(TAG, "OrderId is：" + order.getOrderID());
					}
				}

				@Override
				public void onNotExist() {

				}

			});
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("init GFSDK faild");
			return null;
		}
		
		sendMsgBacktoAS("init GFSDK success");
		return null;
	}

	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
