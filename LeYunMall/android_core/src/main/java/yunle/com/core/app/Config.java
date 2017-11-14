package yunle.com.core.app;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/11/14.
 */

public class Config {
    private static final WeakHashMap<String,Object> MALL_CONFIGS = new WeakHashMap<>();
    /**
     * 私有化构造，单例(构造的时候还没完全执行结束)
     */
    private Config(){
        MALL_CONFIGS.put(Config_Type.CONFIG_READY.name(),false);
    }
    /**
     * 单例优化写法，静态内部类
     */
    private static class Holder{
        private static final Config INSTANCE = new Config();
    }

    /**
     * 当前执行结束以后，改状态
     */
    public final void config(){
        MALL_CONFIGS.put(Config_Type.CONFIG_READY.name(),true);
    }

    /**
     * 返回当前单例实例的方法
     */
    public static Config getInstance(){
        return Holder.INSTANCE;
    }
    /**
     * 返回当前单例的weekHashMap
     */
    public final WeakHashMap<String,Object> getMallConfigs(){
        return MALL_CONFIGS;
    }

    /**
     * 设置apiHost地址
     */
    public final Config withApiHost(String url){
        MALL_CONFIGS.put(Config_Type.API_HPST.name(),url);
        return this;
    }

    /**
     * 检查配置项（如果当前操作的时候还未初始化完成直接抛出异常）
     */
    private void checkConfig(){
        final boolean isReady = (Boolean)MALL_CONFIGS.get(Config_Type.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("config配置类还未初始化完成");
        }
    }

    final <T> T getConfig(Enum<Config_Type> type){
        checkConfig();
        return (T)MALL_CONFIGS.get(type.name());
    }
}
