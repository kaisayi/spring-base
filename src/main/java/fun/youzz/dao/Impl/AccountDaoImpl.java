package fun.youzz.dao.Impl;

import fun.youzz.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("save account");
    }
}
