package fun.youzz.proxy;

/**
 * 对生产厂家要求
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    void saleProduct(float money);
    /**
     * 售后
     * @param money
     */
    void afterService(float money);

}
