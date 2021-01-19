package theory.Controller;

import theory.Service.VirtualWalletService;

import java.math.BigDecimal;

public class VirtualWalletController {
    private VirtualWalletService virtualWalletService;

    public BigDecimal getBalance(Long walletId) {
        return virtualWalletService.getBalance(walletId);
    }

    public void debit(Long walletId,BigDecimal amount){
        virtualWalletService.debit(walletId,amount);
    }

    public void  credit(Long walletId, BigDecimal amount){
        virtualWalletService.credit(walletId,amount);
    }

    public void transfer(Long fromId,Long toId,BigDecimal amount){
        virtualWalletService.transfer(fromId,toId,amount);
    }

}
