package Builder;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * 与工厂模式的不同：
 * 工厂模式是用来创建不同但是相关类型的对象
 * 建造者模式是用来创建一种类型的复杂对象，
 * 通过设置不同的可选参数，“定制化”地创建不同的对象。
 *
 * 建造者模式来构建对象，代码实际上是有点重复的，主类中的成员变量，要在Builder类中重新再定义一遍。
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
        this.maxTotal = builder.maxTotal;
    }

    public static class Builder {
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIM_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIM_IDLE;

        public ResourcePoolConfig build() {
            //校验逻辑放到这里来做，包括必填项校验，依赖关系校验，约束条件校验等
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("名称不能为空");
            }

            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("不能大于总值");
            }

            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("不能大于最大值或总值");
            }

            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("总值不能小于0");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("最小Idle不能小于0");
            }
            this.minIdle = minIdle;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("最大Idle不能小于0");
            }
            this.maxIdle = maxIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(9)
                .build();
    }
}
