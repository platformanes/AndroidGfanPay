package com.sfan.pay.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-7-27 
	 * 
	 */
	public class SfanpayEvents 
	{ 
		public function SfanpayEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 * initKey
		 */
		public static const  GFAN_PAY_INIT:String = "GfanPayInit";
		/**
		 * 登录Key
		 */
		public static const  GFAN_PAY_LOGIN:String = "GfanPayLogin";
		/**
		 * 注册
		 */
		public static const  GFAN_PAY_REG:String = "GfanPayRegist";
		/**
		 * 支付
		 */
		public static const  GFAN_PAY_PAY:String = "GfanPayPay";
		/**
		 * 充值
		 */
		public static const  GFAN_PAY_CHARGE:String = "GfanPayCharge";
		/**
		 * 注销
		 */
		public static const  GFAN_PAY_LOGOUT:String = "GfanPayLogout";
		
		/**
		 * 登录游戏
		 */
		public static const  GFAN_PAY_LOGGAME:String = "GfanPayLogGame";
		/**
		 * 注册游戏
		 */
		public static const  GFAN_PAY_REGGAME:String = "GfanPayRegGame";
		/**
		 * 创建新角色
		 */
		public static const  GFAN_PAY_NEWROLE:String = "GfanPayNewRole";
		/**
		 * 完善帐号
		 */
		public static const  GFAN_PAY_UPDATEUSER:String = "GfanPayUpdateUser";
		/**
		 * 是否游客帐号
		 */
		public static const  GFAN_PAY_ISVISIT:String = "GfanPayIsVisit";
		/**
		 * exit
		 */
		public static const  GFAN_PAY_EXIT:String = "GfanPayExit";
	} 
}