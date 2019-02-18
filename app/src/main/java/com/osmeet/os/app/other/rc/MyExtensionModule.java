package com.osmeet.os.app.other.rc;

import java.util.List;

import io.rong.imkit.DefaultExtensionModule;
import io.rong.imkit.plugin.IPluginModule;
import io.rong.imlib.model.Conversation;


/**
 * Created by yyj on 2019/02/18.
 *
 * @author wzmyyj email: 2209011667@qq.com
 */

public class MyExtensionModule extends DefaultExtensionModule {
    private InvitePlugin invitePlugin=new InvitePlugin();
    @Override
    public List<IPluginModule> getPluginModules(Conversation.ConversationType conversationType) {
        List<IPluginModule> pluginModules =  super.getPluginModules(conversationType);
        pluginModules.add(invitePlugin);
        return pluginModules;
    }
}
