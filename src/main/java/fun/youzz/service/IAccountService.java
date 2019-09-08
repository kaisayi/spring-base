package fun.youzz.service;

import fun.youzz.domain.Account;

/**
 * 账户层接口
 */
public interface IAccountService {

    Account findAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);

}
