package Flyweight;

/**
 * 1. 何时使用
 * 系统中有大量对象时
 * 这些对象消耗大量内存时
 * 这些对象的状态大部分可以外部化时
 * 　　2. 方法
 * 用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象，用HashMap/HashTable存储
 * 　　3. 优点
 * 大大减少了对象的创建，降低了程序内存的占用，提高效率
 * 　　4. 缺点
 * 提高了系统的复杂度。需要分离出内部状态和外部状态，而外部状态具有固化特性，不应该随着内部状态的改变而改变
 *  　　5. 使用场景
 * 系统中存在大量相似对象
 * 需要缓冲池的场景
 *  　　6. 应用实例
 * String常量池
 * 数据库连接池
 *  　　7. 注意事项
 * 注意划分内部状态和外部状态，否则可能会引起线程安全问题
 * 这些类必须有一个工厂类加以控制
 */
public abstract class Flyweight {

    //内部状态
    public String intrinsic;
    //外部状态
    protected final String extrinsic;

    //要求享元角色必须接受外部状态
    public Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    //定义业务操作
    public abstract void operate(int extrinsic);

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }

}