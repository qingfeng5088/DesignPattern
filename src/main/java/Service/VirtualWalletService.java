package Service;

import Domain.VirtualWalletBo;

import java.math.BigDecimal;

/**
 * 基于贫血模型的Service设计
 */
public class VirtualWalletService {

    public VirtualWalletBo getVirtualWallet(Long walletId) {
        return new VirtualWalletBo(1L, new BigDecimal(0));
    }

    public BigDecimal getBalance(Long walletId) {
        return new BigDecimal(1);
    }

    public void debit(Long walletId, BigDecimal amount) {

        // update DB
    }

    public void credit(Long walletId, BigDecimal amount) {
        // update DB
    }

    public  void transfer(Long fromWalletId, Long toWalletId, BigDecimal amout) {
       // new  VirtualWalletTransactionEntity
        // set property

        //  debit(fromID,amount)
        // credit(toId,amount)

        // updata status
    }

}
