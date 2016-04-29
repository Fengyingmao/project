package com.example.fengym.project;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by fengym on 2016/4/27.
 */
public class SixthMainActivity extends Activity {
    View root;
    ImageButton imgBtn;
    PopupWindow popupWindow;
    TextView txt_Question, txt_Anwser;
    CheckBox checkBox_A, checkBox_B, checkBox_C, checkBox_D;
    Button btn_Pre, btn_Delete, btn_Next;
    MyOnclick myOnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_main);
        Init();
        setOnclick();
    }

    private void Init() {
        root = this.getLayoutInflater().inflate(R.layout.popuwindow_style, null);
        popupWindow = new PopupWindow(root, 300, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        txt_Question = (TextView) findViewById(R.id.txt_Question);
        txt_Anwser = (TextView) findViewById(R.id.txt_Anwser);
        checkBox_A = (CheckBox) findViewById(R.id.checkbox_A);
        checkBox_B = (CheckBox) findViewById(R.id.checkbox_B);
        checkBox_C = (CheckBox) findViewById(R.id.checkbox_C);
        checkBox_D = (CheckBox) findViewById(R.id.checkbox_D);
        btn_Pre = (Button) findViewById(R.id.btn_Pre);
        btn_Delete = (Button) findViewById(R.id.btn_Delete);
        btn_Next = (Button) findViewById(R.id.btn_Next);
        myOnclick = new MyOnclick();
    }

    public void setOnclick() {
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        imgBtn.setOnClickListener(myOnclick);
        checkBox_A.setOnCheckedChangeListener(myOnclick);
        checkBox_B.setOnCheckedChangeListener(myOnclick);
        checkBox_C.setOnCheckedChangeListener(myOnclick);
        checkBox_D.setOnCheckedChangeListener(myOnclick);
        btn_Pre.setOnClickListener(myOnclick);
        btn_Delete.setOnClickListener(myOnclick);
        btn_Next.setOnClickListener(myOnclick);
    }

    public class MyOnclick implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

        /*
    实现button的点击事件
     */

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imgBtn:
                    Drawable drawable = getDrawable(R.color.gray);
                    popupWindow.setBackgroundDrawable(drawable);
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);
                    popupWindow.showAsDropDown(v, 50, 0);
                    break;
                case R.id.btn_Pre:
                    break;
                case R.id.btn_Delete:
                    break;
                case R.id.btn_Next:
                    break;
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkbox_A:
                    break;
                case R.id.checkbox_B:
                    break;
                case R.id.checkbox_C:
                    break;
                case R.id.checkbox_D:
                    break;
            }
        }
    }
}
