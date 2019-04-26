package com.wyx.components.cptextviewmain;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;

import com.wyx.components.cptextview.CpTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CpTextView cpTextView = findViewById(R.id.cp_text_view);

        cpTextView.setTitle("账号：")
                .setTitleTextSize(16)
                .setTitleTextColor(Color.parseColor("#333333"))
                .setTitleLeftIco(0)
                .setTitleIcoPadding(0)
                .setTitleMargin(45);
        cpTextView.getTitleTextView().setGravity(Gravity.TOP);
        cpTextView.getTitleTextView().setPadding(0, 30, 0, 30);

        cpTextView.setContent("思考对方就开始了的解放路")
                .setContentTextSize(16)
                .setContentTextColor(Color.parseColor("#999999"))
                .setContentRightIco(0)
                .setContentIcoPadding(0)
                .setContentMargin(45);
        cpTextView.getContentTextView().setBackgroundResource(android.R.color.transparent);
        cpTextView.getContentTextView().setPadding(0, 30, 0, 30);
        cpTextView.getContentTextView().setGravity(Gravity.TOP|Gravity.RIGHT);

        cpTextView.setLineColor(Color.parseColor("#CCCCCC"))
                .setLineMargin(45);
//                .setLineSize(1);
    }
}
