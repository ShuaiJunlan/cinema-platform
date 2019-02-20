package cn.shuaijunlan.accountservices.service;

import cn.shuaijunlan.accountservices.model.UserAccountTable;
import cn.shuaijunlan.accountservices.repository.UserAccountRepository;
import cn.shuaijunlan.accountservices.repository.UserAccountSpendingRepository;
import cn.shuaijunlan.accountservicesapi.AccountServicesAPI;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Shuai Junlan[shuaijunlan@gmail.com].
 * @since Created in 11:47 AM 2/20/19.
 */
@Service
public class AccountServicesImpl implements AccountServicesAPI {
    private final UserAccountRepository userAccountRepository;
    private final UserAccountSpendingRepository userAccountSpendingRepository;

    public AccountServicesImpl(UserAccountRepository userAccountRepository, UserAccountSpendingRepository userAccountSpendingRepository) {
        this.userAccountRepository = userAccountRepository;
        this.userAccountSpendingRepository = userAccountSpendingRepository;
    }

    @Override
    public boolean deduct(int accountId, double amount) {
        Optional<UserAccountTable> userAccountTable = userAccountRepository.findById(accountId);
        if (userAccountTable.isPresent() && userAccountTable.get().getAmount() > amount){
            return userAccountRepository.updateAmount(accountId, userAccountTable.get().getAmount()-amount) > 0;
        }

        return false;
    }

    @Override
    public boolean add(int accountId, double amount) {
        return false;
    }

    private boolean hasEnough(int accountId, double amount){
        return userAccountRepository.getOne(accountId).getAmount() > amount;
    }
}
