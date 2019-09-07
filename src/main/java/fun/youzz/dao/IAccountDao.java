package fun.youzz.dao;

import fun.youzz.domain.Account;

import java.util.List;

public interface IAccountDao {

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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一结果返回，没有结果返回null
     */
    Account findAccountByName(String accountName);
}
