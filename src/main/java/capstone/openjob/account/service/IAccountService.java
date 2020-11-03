package capstone.openjob.account.service;

import capstone.openjob.entity.AccountEntity;

import java.util.List;

public interface IAccountService {
    AccountEntity createAccount(AccountEntity accountEntity);
    AccountEntity updateAccount(AccountEntity accountEntity);
    List<AccountEntity> getAllAccount();
    AccountEntity findAccountByEmail(String email);
    AccountEntity findAccountEntityById(int id);
}
