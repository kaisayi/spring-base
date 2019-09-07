package fun.youzz.dao.Impl;

import fun.youzz.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    public void saveAccount() {
        System.out.println("save account 222222222");
    }
}
