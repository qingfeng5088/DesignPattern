package theory.Service;

import theory.Domain.VirtualWallet;

import java.math.BigDecimal;

/**
 * 基于充血模型的Service设计
 *
 * 负责一些功能性及三方系统及三方系统交互的工作，比如幂等，事务，发邮件，发消息，记录日志
 * 调用其他系统的RPC接口等，都可以放到Service类中
 */
public class VirtualWalletServiceDDD {
    public VirtualWallet getVirtualWallet(Long walletId) {
        // get walletEntity from DB
        return new VirtualWallet(1L);
    }

    public BigDecimal getBalance(Long walletId) {
        // getBalance from DB
        return new BigDecimal(1);
    }

    public void debit(Long walletId, BigDecimal amount) {
        //1: get walletEntity from DB
        //2: convert to VirtualWallet
        //3: wallet.debit(amount);
        //4: update DB  walletRepo.updateBalance(walletId,wallet.balance());
    }

    public void credit(Long walletId, BigDecimal amount) {
        //1: get walletEntity from DB
        //2: convert to VirtualWallet
        //3: wallet.credit(amount);
        // update DB walletRepo.updateBalance(walletId,wallet.balance());
    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amout) {
        // same with Anemia model

        // new  VirtualWalletTransactionEntity
        // set property

        //  debit(fromID,amount)
        // credit(toId,amount)

        // updata status
    }

}
