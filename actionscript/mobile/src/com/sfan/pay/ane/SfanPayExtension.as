package com.sfan.pay.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-7-27 
	 * 
	 */
	public class SfanPayExtension extends EventDispatcher 
	{ 
		/**
		 * initKey
		 */
		public static const  GFAN_PAY_FUNCTION_INIT:String  = "gfan_pay_function_init";
		/**
		 * 登录Key
		 */
		public static const  GFAN_PAY_FUNCTION_LOGIN:String  = "gfan_pay_function_login";
		/**
		 * 注册
		 */
		public static const  GFAN_PAY_FUNCTION_REG:String  = "gfan_pay_function_reg";
		/**
		 * 支付
		 */
		public static const  GFAN_PAY_FUNCTION_PAY:String  = "gfan_pay_function_pay";
		/**
		 * 充值
		 */
		public static const  GFAN_PAY_FUNCTION_CHARGE:String  = "gfan_pay_function_charge";
		/**
		 * 注销
		 */
		public static const  GFAN_PAY_FUNCTION_LOGOUT:String  = "gfan_pay_function_logout";
		
		/**
		 * 登录游戏
		 */
		public static const  GFAN_PAY_FUNCTION_LOGGAME:String  = "gfan_pay_function_loggame";
		/**
		 * 注册游戏
		 */
		public static const  GFAN_PAY_FUNCTION_REGGAME:String  = "gfan_pay_function_reggame";
		/**
		 * 创建新角色
		 */
		public static const  GFAN_PAY_FUNCTION_NEWROLE:String  = "gfan_pay_function_newrole";
		/**
		 * 完善帐号
		 */
		public static const  GFAN_PAY_FUNCTION_UPDATEUSER:String  = "gfan_pay_function_updateuser";
		/**
		 * 是否游客帐号
		 */
		public static const  GFAN_PAY_FUNCTION_ISVISIT:String  = "gfan_pay_function_isvisit"; 
		/**
		 * exit
		 */
		public static const  GFAN_PAY_FUNCTION_EXIT:String  = "gfan_pay_function_exit";    
		
		
		public static const EXTENSION_ID:String = "com.sfan.pay.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext = null; 
		private static var _instance:SfanPayExtension;   
		
		public function SfanPayExtension(target:IEventDispatcher=null)
		{
			super(target); 
			
			if(extContext == null) {  
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID,""); 
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);             
			}  
		} 
		
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():SfanPayExtension
		{
			if(_instance == null)   
				_instance = new SfanPayExtension(); 
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event); 
		}
		
		/**
		 * init发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function SfanPayInit(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_INIT,key) as String;
			}
			return "call SfanPayInit failed";
		} 
		
		public function SfanPayLogin(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_LOGIN,key) as String;
			}
			return "call SfanPayLogin failed";
		} 
		
		/**
		 * 充值 
		 * @param orderId  自定义订单ID
		 * @param payStr  充值数额
		 * @return 
		 * 
		 */		
		public function SfanPayPay(orderId:String,payStr:String):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_PAY,orderId,payStr) as String;
			}
			return "call SfanPayExit failed";
		} 
		
		public function SfanPayReg(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_REG,key) as String;
			}
			return "call SfanPayReg failed";
		} 
		
		public function SfanPayChage(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_CHARGE,key) as String;
			}
			return "call SfanPayChage failed";
		}
		
		public function SfanPayLogout(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_LOGOUT,key) as String;
			}
			return "call SfanPayLogout failed";
		} 
		
		public function SfanPayLogGame(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_LOGGAME,key) as String;
			}
			return "call SfanPayLogGame failed";
		} 
		
		public function SfanPayRegGame(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_REGGAME,key) as String;
			}
			return "call SfanPayRegGame failed";
		} 
		
		public function SfanPayNewRole(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_NEWROLE,key) as String;
			}
			return "call SfanPayNewRole failed";
		} 
		
		public function SfanPayUpdateUser(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_UPDATEUSER,key) as String;
			}
			return "call SfanPayUpdateUser failed";
		} 
		
		public function SfanPayIsVisit(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_ISVISIT,key) as String;
			}
			return "call SfanPayIsVisit failed";
		} 
		
		public function SfanPayExit(key:int = 0):String{
			if(extContext ){
				return extContext.call(GFAN_PAY_FUNCTION_EXIT,key) as String;
			}
			return "call SfanPayExit failed";
		} 
	} 
}