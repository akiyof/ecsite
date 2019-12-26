package com.internousdev.template.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

/**セッションからgetしてきたID、ログインID、値段、在庫、支払い方法を取得*/
public class BuyItemConfirmAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){
			BuyItemCompleteDAO buyItemCompleteDAO=new BuyItemCompleteDAO();
			buyItemCompleteDAO.buyItemInfo(session.get("id").toString(),
					session.get("login_user_id").toString(),
					session.get("buyItem_price").toString(),
					session.get("stock").toString(),
					session.get("pay").toString());

			String result=SUCCESS;
			return result;
		}
		@Override
		public void setSession(Map<String,Object>session){
			this.session=session;
		}

}
