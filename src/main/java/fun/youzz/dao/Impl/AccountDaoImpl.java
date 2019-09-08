package fun.youzz.dao.Impl;

import fun.youzz.dao.IAccountDao;
import fun.youzz.domain.Account;
import fun.youzz.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<>(Account.class), accountName);
            if (Objects.isNull(accounts) || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}