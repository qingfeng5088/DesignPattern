package annotation;

/**
 * 注解使用：
 * @<注解名>(<成员名1>=<成员值1>, <成员名2>=<成员值2>, ...)
 * @author H__D
 * @date 2019-07-09 22:49:32
 *
 */
@Description(desc="I am class annotation", author="qiuyutong", age = 5)
public class TestDescription {

    @Description(desc="I am method annotation", author="qingfeng", age = 38)
    public String test(){

        return "red";
    }


}