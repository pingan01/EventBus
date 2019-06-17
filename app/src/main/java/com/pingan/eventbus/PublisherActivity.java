package com.pingan.eventbus;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import com.pingan.eventbus.systemstatusbar.StatusBarCompat;

import org.greenrobot.eventbus.EventBus;

public class PublisherActivity extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_publisher);
        mEditText = findViewById(R.id.edtContent);

        //修改状态栏颜色
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.cyan));
    }

    /**
     * 事件发布者
     *
     * @param view
     */
    public void onPublisher(View view) {

        //EventBus.getDefault().post(EventMessage.getInstance(mEditText.getText().toString()));
        EventBus.getDefault().postSticky(EventMessage.getInstance(mEditText.getText().toString()));//黏性事件
    }
}
