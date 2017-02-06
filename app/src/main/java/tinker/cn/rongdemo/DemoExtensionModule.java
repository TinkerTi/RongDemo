package tinker.cn.rongdemo;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.manager.InternalModuleManager;
import io.rong.imkit.plugin.CombineLocationPlugin;
import io.rong.imkit.plugin.DefaultLocationPlugin;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imkit.plugin.ImagePlugin;
import io.rong.imkit.widget.provider.FilePlugin;
import io.rong.imlib.model.Conversation;

/**
 * Created by tiankui on 11/23/16.
 */

public class DemoExtensionModule extends DefaultExtensionModule{

    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {

        ArrayList pluginModuleList = new ArrayList();
        ImagePlugin image = new ImagePlugin();
        FilePlugin file = new FilePlugin();
        pluginModuleList.add(image);

        try {
            String e = "com.amap.api.netlocation.AMapNetworkLocationClient";
            Class locationCls = Class.forName(e);
            if(locationCls != null) {
                CombineLocationPlugin combineLocation = new CombineLocationPlugin();
                DefaultLocationPlugin locationPlugin = new DefaultLocationPlugin();
                if(conversationType.equals(Conversation.ConversationType.PRIVATE)) {
                    pluginModuleList.add(combineLocation);
                } else {
                    pluginModuleList.add(locationPlugin);
                }
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        if(conversationType.equals(Conversation.ConversationType.GROUP) || conversationType.equals(Conversation.ConversationType.DISCUSSION) || conversationType.equals(Conversation.ConversationType.PRIVATE)) {
            pluginModuleList.addAll(InternalModuleManager.getInstance().getExternalPlugins(conversationType));
        }

        return pluginModuleList;
    }
}
