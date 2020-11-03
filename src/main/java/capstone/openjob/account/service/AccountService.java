package capstone.openjob.account.service;

import capstone.openjob.dao.IAccountRepository;
import capstone.openjob.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAccountRepository IAccountRepository;

    @Override
    public AccountEntity createAccount(AccountEntity accountEntity) {
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        return IAccountRepository.save(accountEntity);
    }

    @Override
    public AccountEntity updateAccount(AccountEntity accountEntity) {
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        return IAccountRepository.save(accountEntity);
    }

    @Override
    public List<AccountEntity> getAllAccount() {
        return IAccountRepository.findAll();
    }

    @Override
    public AccountEntity findAccountByEmail(String email) {
        if (IAccountRepository.findAccountEntitiesByEmailEquals(email).isPresent()) {
            return IAccountRepository.findAccountEntitiesByEmailEquals(email).get();
        } else return null;
    }

    @Override
    public AccountEntity findAccountEntityById(int id) {
        if (IAccountRepository.findById(id).isPresent()) {
            return IAccountRepository.findById(id).get();
        } else return null;
    }
}
