package fun.youzz.service;

import fun.youzz.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有
     */
    List<Account> findAllAccount();

    /**
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * @param account
     */
    void saveAccount(Account account);

    /**
     * @param account
     */
    void updateAccount(Account account);

    /**
     * @param accountId
     */
    void deleteAccount(Integer accountId);

}
