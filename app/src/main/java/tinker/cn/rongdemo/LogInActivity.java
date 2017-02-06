package tinker.cn.rongdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

/**
 * Created by tiankui on 11/11/16.
 */

public class LogInActivity extends Activity {
    /**
     * @param savedInstanceState
     */
    private final static String TOKEN_ONE="XBxXX8QzAnHhzafhOOeWk5TQlpWwJUqXRzEa1ImBE4YNpUChUyZoHCfvMRzaSMv2fo/VJMRSjxaiv0iTDWY1aQ==";
    private final static String TOKEN_TWO="MVbZqbrm1PCumu3NniMB4pTQlpWwJUqXRzEa1ImBE4YNpUChUyZoHOfSlzMwND0gHiOB8nX2WN7bhzWkUJL3Qg==";
    private Button mLogInButtonOne;
    private Button mLogInButtonTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        initView();
        initData();

    }

    private void initData() {
        mLogInButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.connect(TOKEN_ONE, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Intent intent=new Intent(LogInActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {

                    }
                });
            }
        });

        mLogInButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.connect(TOKEN_TWO, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Intent intent=new Intent(LogInActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {

                    }
                });
            }
        });
    }

    private void initView() {
        mLogInButtonOne =(Button) findViewById(R.id.ac_bt_log_in_one);
        mLogInButtonTwo=(Button)findViewById(R.id.ac_bt_log_in_two);


    }
}
