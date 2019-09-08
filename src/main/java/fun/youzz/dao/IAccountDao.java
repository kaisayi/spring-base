package fun.youzz.dao;

import fun.youzz.domain.Account;

public interface IAccountDao {

    Account findAccountById(Integer accountId);

    Account findAccountByName(String accountName);

    void updateAccount(Account account);
}
