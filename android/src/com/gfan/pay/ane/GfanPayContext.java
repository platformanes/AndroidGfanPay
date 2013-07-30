package com.gfan.pay.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.gfan.pay.func.GfanPayExit;
import com.gfan.pay.func.GfanPayLogout;
import com.gfan.pay.func.GfanPayInit;
import com.gfan.pay.func.GfanPayIsVisit;
import com.gfan.pay.func.GfanPayLogGame;
import com.gfan.pay.func.GfanPayLogin;
import com.gfan.pay.func.GfanPayNewRole;
import com.gfan.pay.func.GfanPayPay;
import com.gfan.pay.func.GfanPayCharge;
import com.gfan.pay.func.GfanPayRegGame;
import com.gfan.pay.func.GfanPayRegist;
import com.gfan.pay.func.GfanPayUpdateUser;
/**
 * 映射
 * @author Rect 2013-5-5
 */
public class GfanPayContext extends FREContext {

	/**
	 * initKey
	 */
	public static final String GFAN_PAY_FUNCTION_INIT = "gfan_pay_function_init";
	/**
	 * 登录Key
	 */
	public static final String GFAN_PAY_FUNCTION_LOGIN = "gfan_pay_function_login";
	/**
	 * 注册
	 */
	public static final String GFAN_PAY_FUNCTION_REG = "gfan_pay_function_reg";
	/**
	 * 支付
	 */
	public static final String GFAN_PAY_FUNCTION_PAY = "gfan_pay_function_pay";
	/**
	 * 充值
	 */
	public static final String GFAN_PAY_FUNCTION_CHARGE = "gfan_pay_function_charge";
	/**
	 * 注销
	 */
	public static final String GFAN_PAY_FUNCTION_LOGOUT = "gfan_pay_function_logout";
	
	/**
	 * 登录游戏
	 */
	public static final String GFAN_PAY_FUNCTION_LOGGAME = "gfan_pay_function_loggame";
	/**
	 * 注册游戏
	 */
	public static final String GFAN_PAY_FUNCTION_REGGAME = "gfan_pay_function_reggame";
	/**
	 * 创建新角色
	 */
	public static final String GFAN_PAY_FUNCTION_NEWROLE = "gfan_pay_function_newrole";
	/**
	 * 完善帐号
	 */
	public static final String GFAN_PAY_FUNCTION_UPDATEUSER = "gfan_pay_function_updateuser";
	/**
	 * 是否游客帐号
	 */
	public static final String GFAN_PAY_FUNCTION_ISVISIT = "gfan_pay_function_isvisit";
	/**
	 * exit
	 */
	public static final String GFAN_PAY_FUNCTION_EXIT = "gfan_pay_function_exit";
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
	       //映射
		   map.put(GFAN_PAY_FUNCTION_INIT, new GfanPayInit());
	       map.put(GFAN_PAY_FUNCTION_LOGIN, new GfanPayLogin());
	       map.put(GFAN_PAY_FUNCTION_PAY, new GfanPayPay());
	       map.put(GFAN_PAY_FUNCTION_CHARGE, new GfanPayCharge());
	       map.put(GFAN_PAY_FUNCTION_LOGOUT, new GfanPayLogout());
	       map.put(GFAN_PAY_FUNCTION_REG, new GfanPayRegist());
	       map.put(GFAN_PAY_FUNCTION_LOGGAME, new GfanPayLogGame());
	       map.put(GFAN_PAY_FUNCTION_REGGAME, new GfanPayRegGame());
	       map.put(GFAN_PAY_FUNCTION_NEWROLE, new GfanPayNewRole());
	       map.put(GFAN_PAY_FUNCTION_UPDATEUSER, new GfanPayUpdateUser());
	       map.put(GFAN_PAY_FUNCTION_ISVISIT, new GfanPayIsVisit());
	       map.put(GFAN_PAY_FUNCTION_EXIT, new GfanPayExit());
	       return map;
	}

}
