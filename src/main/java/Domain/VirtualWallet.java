package Domain;

import javax.naming.InsufficientResourcesException;
import java.math.BigDecimal;

/**
 * 基于充血模型的Domain设计
 *
 * 不让领域模型VirtualWallet 与Repository打交道，是因为我们想保持领域模型的
 * 独立性，不与任何其他层的代码（Repository层的代码）或开发框架(比如Spring，MyBatis)耦合在一起，
 * 将流程性的代码（比如DB中取数据，映射数据）与领域模型的业务逻辑解耦，让领域模型更加可复用。
 */
public class VirtualWallet {
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public void debit(BigDecimal amount) throws InsufficientResourcesException {
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientResourcesException();
        }

        this.balance.subtract(amount);
    }

    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw  new Exception();
        }

        this.balance.add(amount);
    }

}
