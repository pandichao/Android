package yunle.com.core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by Administrator on 2017/11/14.
 * 初始化程序
 */
public final class core {
    public static Config init(Context context){
        getConfig().put(Config_Type.APPLICATION_CONTEXT.name(),context);
        return Config.getInstance();
    }

    /**
     * 获取配置
     * @return
     */
    public static WeakHashMap<String,Object> getConfig(){
        return Config.getInstance().getMallConfigs();
    }

}
