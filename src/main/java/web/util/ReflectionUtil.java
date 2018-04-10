package web.util;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangchen
 * @date 2018/4/10 17:27
 */
public class ReflectionUtil {

    /**
     * 根据传入的属性名字符串，修改对应的属性值
     *
     * @param name
     *            属性名
     * @param obj
     *            要修改的实例对象
     * @param value
     *            修改后的新值
     */
    public static void setField(Object obj, String name,Object value)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(name);

        field.setAccessible(true);
        field.set(obj, value);
    }

    /**
     * 根据传入的方法名字符串，获取对应的方法
     *
     * @param clazz
     *            类的Class对象
     * @param name
     *            方法名
     * @param parameterTypes
     *            方法的形参对应的Class类型【可以不写】
     * @return 方法对象【Method类型】
     */
    public static Method getMethod(Class<?> clazz, String name, Class<?>... parameterTypes)
            throws NoSuchMethodException, SecurityException {
        return clazz.getDeclaredMethod(name, parameterTypes);
    }

    /**
     * 根据传入的方法对象，调用对应的方法
     *
     * @param method
     *            方法对象
     * @param obj
     *            要调用的实例对象【如果是调用静态方法，则可以传入null】
     * @param args
     *            传入方法的实参【可以不写】
     * @return 方法的返回值【没有返回值，则返回null】
     */
    public static Object invokeMethod(Method method, Object obj, Object... args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.setAccessible(true);
        return method.invoke(obj, args);
    }
}
