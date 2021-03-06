package com.yc.spring.bank.action;

import com.yc.spring.bank.bean.Account;
import com.yc.spring.bank.biz.AccountBiz;
import com.yc.spring.bank.biz.RecordBiz;

/**
 * SpringMVC 控制器
 */
public class BankAction {

	private AccountBiz aBiz;

	private RecordBiz rBiz;

	/**
	 * 存款
	 * @param account
	 * @return
	 */
	public String deposit(Account account) {
		aBiz.deposit(account);
		return "details";
	}

	/**
	 * 取款
	 * @param account
	 * @return
	 */
	public String withdraw(Account account) {
		aBiz.withdraw(account);
		return "details";
	}

	/**
	 * 转账
	 * @param account1
	 * @param account2
	 * @return
	 */
	public String transfer(Account account1, Account account2) {
		aBiz.transfer(account1, account2);
		return "details";
	}

	/**
	 * 查询交易明细
	 * @param accountId
	 * @return
	 */
	public String details(int accountId) {
		rBiz.queryByAccountId(accountId);
		return "details";
	}

}
