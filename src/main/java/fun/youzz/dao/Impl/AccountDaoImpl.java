package fun.youzz.dao.Impl;

import fun.youzz.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("save account111111111111");
    }
}
