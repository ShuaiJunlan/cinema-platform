package cn.shuaijunlan.accountservices.service;

import cn.shuaijunlan.accountservices.model.UserAccountSpendingTable;
import cn.shuaijunlan.accountservices.model.UserAccountTable;
import cn.shuaijunlan.accountservices.repository.UserAccountRepository;
import cn.shuaijunlan.accountservices.repository.UserAccountSpendingRepository;
import cn.shuaijunlan.accountservicesapi.AccountServicesAPI;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:47 AM 2/20/19.
 */
@Component
@Service(interfaceClass = AccountServicesAPI.class, loadbalance = "roundrobin")
public class AccountServicesImpl implements AccountServicesAPI {
    private final UserAccountRepository userAccountRepository;
    private final UserAccountSpendingRepository userAccountSpendingRepository;

    public AccountServicesImpl(UserAccountRepository userAccountRepository, UserAccountSpendingRepository userAccountSpendingRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountSpendingRepository = userAccountSpendingRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deduct(int accountId, double amount) {
        Optional<UserAccountTable> userAccountTable = userAccountRepository.findById(accountId);
        if (userAccountTable.isPresent() && userAccountTable.get().getAmount() > amount){
            int re = userAccountRepository.updateAmount(accountId, userAccountTable.get().getAmount()-amount);
            if (re > 0){
                UserAccountSpendingTable userAccountSpendingTable = new UserAccountSpendingTable();
                userAccountSpendingTable.setAmount(amount);
                userAccountSpendingTable.setType(2);
                userAccountSpendingTable.setUserAccountId(accountId);

                userAccountSpendingRepository.save(userAccountSpendingTable);
            }
            return re > 0;
        }
        return false;
    }

    @Override
    public boolean add(int accountId, double amount) {
        Optional<UserAccountTable> userAccountTable = userAccountRepository.findById(accountId);
        if (userAccountTable.isPresent() && userAccountTable.get().getAmount() > amount){
            int re = userAccountRepository.updateAmount(accountId, userAccountTable.get().getAmount()+amount);
            if (re > 0){
                UserAccountSpendingTable userAccountSpendingTable = new UserAccountSpendingTable();
                userAccountSpendingTable.setAmount(amount);
                userAccountSpendingTable.setType(1);
                userAccountSpendingTable.setUserAccountId(accountId);

                userAccountSpendingRepository.save(userAccountSpendingTable);
            }
            return re > 0;
        }
        return false;
    }
}
