package fun.youzz.service;

public interface IAccountService {

    /**
     * 无参无返回值
     */
    void saveAccount();

    /**
     * 有参无返回值
     * @param i
     */
    void updateAccount(int i);

    /**
     * 无参有返回值
     * @return
     */
    int deleteAccount();

}
