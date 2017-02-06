package tinker.cn.rongdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

/**
 * Created by tiankui on 11/11/16.
 */

public class ConversationListActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation_list);
        enterFragment();
    }

    private void enterFragment() {
        ConversationListFragment listFragment = new ConversationListFragment();
//        listFragment.setAdapter(new ConversationListAdapter(RongContext.getInstance()));
        Uri uri;
        uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话是否聚合显示
                .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//群组
                .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")//公共服务号
                .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")//订阅号
                .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")//系统
                .build();
        listFragment.setUri(uri);
        getSupportFragmentManager().beginTransaction().add(R.id.ac_fl_conversation_list,listFragment,null).commit();
    }
}
