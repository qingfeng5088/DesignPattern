package theory.Domain;

import java.math.BigDecimal;

public class VirtualWalletBo {
    private Long id;
    private Long createTime;
    private BigDecimal balance;

    public VirtualWalletBo(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;

        createTime = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
