package com.pingan.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.pingan.eventbus.systemstatusbar.StatusBarCompat;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.txtContent);
        //修改状态栏颜色
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.cyan));
    }

    public void onRegister(View view) {

        EventBus.getDefault().register(this);
    }

    public void onJump(View view) {
        startActivity(new Intent(this, PublisherActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

//    /**
//     * 事件接收者
//     *
//     * @param message
//     */
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onGetMessage(EventMessage message) {
//        mTextView.setText(message.message);
//    }

    /**
     * 黏性事件:先发布事件 后订阅 订阅者依然能收到信息
     *
     * @param message
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onGetStickyMessage(EventMessage message) {
        mTextView.setText(message.message);
    }
}
