package tinker.cn.rongdemo;

import android.app.Application;
import android.net.Uri;

import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.IExtensionModule;
import io.rong.imkit.RongExtensionManager;
import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

/**
 * Created by tiankui on 11/11/16.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        RongIM.init(this);

        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String s) {
                return new UserInfo(s,RongGenerate.generateRandomCharacter(), Uri.parse(RongGenerate.generateDefaultAvatar(RongGenerate.generateRandomCharacter(),s)));
            }
        },true);


        List<IExtensionModule> moduleList = RongExtensionManager.getInstance().getExtensionModules();
        IExtensionModule defaultModule = null;
        if (moduleList != null) {
            for (IExtensionModule module : moduleList) {
                if (module instanceof DefaultExtensionModule) {
                    defaultModule = module;
                    break;
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule);
                RongExtensionManager.getInstance().registerExtensionModule(new DemoExtensionModule());
            }
        }



    }
}
