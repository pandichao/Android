package yunle.com.yunlemall;

import android.app.Application;

import yunle.com.core.app.Config;
import yunle.com.core.app.core;

/**
 * Created by Administrator on 2017/11/14.
 */
public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        core.init(this)
                .withApiHost("http://192.168.1.12/")
                .config();
    }
}
