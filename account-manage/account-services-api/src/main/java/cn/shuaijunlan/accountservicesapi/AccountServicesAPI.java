package cn.shuaijunlan.accountservicesapi;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:42 AM 2/20/19.
 */
public interface AccountServicesAPI {
    /**
     *
     * @param accountId 账户id
     * @param amount 金额
     * @return 返回是否扣钱成功
     */
    boolean deduct(int accountId, double amount);

    /**
     *
     * @param accountId 账户id
     * @param amount 金额
     * @return 返回是否充值成功
     */
    boolean add(int accountId, double amount);

}
