package com.gfan.pay.func;

import android.text.TextUtils;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.mappn.sdk.pay.GfanPay;
import com.mappn.sdk.pay.GfanPayCallback;
import com.mappn.sdk.pay.model.Order;
import com.mappn.sdk.uc.User;

/**
 * @author Rect
 * @version  Time：2013-7-27 
 */
public class GfanPayPay implements FREFunction {
	private String TAG = "GfanPayPay";
	private FREContext _context;
	private String orderId;
	private String payStr;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		try
		{
			orderId = arg1[0].getAsString();
			payStr = arg1[0].getAsString();
			startGfanPay();
		}
		catch(Exception e)
		{
			sendMsgBacktoAS("function GfanPayPay faild");
			return null;
		}
		return null;
	}

	/**
	 * pay
	 */
	private void startGfanPay() {
		
		if (!checkPayMoney(payStr)) {
			return;
		}

		int payValue = Integer.valueOf(payStr);
		Order order = new Order("product name", "product description", payValue, orderId);
		GfanPay.getInstance(this._context.getActivity().getApplicationContext()).pay(order,
				new GfanPayCallback() {

					@Override
					public void onSuccess(User user, Order order) {
						String msg = "userName:"+user.getUserName();
						msg += ":userID:"+user.getUid();
						msg += ":getNumber:"+order.getNumber();
						msg += ":getOrderID:"+order.getOrderID();
						sendMsgBacktoAS(msg);
						
					}

					@Override
					public void onError(User user) {
						if (user != null) {
							sendMsgBacktoAS("pay failure, user：" + user.getUserName());
						} else {
							sendMsgBacktoAS("failed login");
						}
					}
				});

	}
	
	private boolean checkPayMoney(String text) {
		if (TextUtils.isEmpty(text)) {
			sendMsgBacktoAS("you should input the number!");
			return false;
		} else {
			try {
				int payValue = Integer.valueOf(text);

				if (payValue == 0) {
					sendMsgBacktoAS("the number must greater than 1 !");
					return false;
				}
			} catch (NumberFormatException e) {
				sendMsgBacktoAS("there is error number!");
				return false;
			}
		}
		return true;
	}
	
	private void sendMsgBacktoAS(String msg)
	{
		Log.d(TAG, msg);
		_context.dispatchStatusEventAsync(TAG, msg);
	}
}
