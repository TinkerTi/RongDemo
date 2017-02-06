package tinker.cn.rongdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {

    private Button mPrivateChatButtonOne;
    private Button mPrivateChatButtonTwo;

    private Button mConversationListFrgmentButton;

    private Button mAudioRecordButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mPrivateChatButtonOne =(Button)findViewById(R.id.ac_bt_start_private_chat_one);
        mPrivateChatButtonTwo=(Button)findViewById(R.id.ac_bt_start_private_chat_two);
        mConversationListFrgmentButton=(Button)findViewById(R.id.ac_bt_start_conversation_list);
        mAudioRecordButton=(Button)findViewById(R.id.ac_bt_audio_record);

        mPrivateChatButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(MainActivity.this,"201602","私聊");
            }
        });

        mPrivateChatButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(MainActivity.this,"201601","私聊");
            }
        });

        mConversationListFrgmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ConversationListActivity.class);
                startActivity(intent);
            }
        });

        mAudioRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().joinChatRoom("101", -1, new RongIMClient.OperationCallback() {
                    @Override
                    public void onSuccess() {
                        Log.e("MainActivity","joinSuccess");
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
                        Log.e("MainActivity","joinFailed");
                    }
                });
//                startActivity(new Intent(MainActivity.this,AudioRecordActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        RongIM.getInstance().disconnect();
        super.onDestroy();
    }
}
