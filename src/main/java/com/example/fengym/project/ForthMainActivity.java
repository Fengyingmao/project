package com.example.fengym.project;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by fengym on 2016/4/26.
 */
public class ForthMainActivity extends Activity {
    View root;
    ImageButton imgBtn;
    PopupWindow popupWindow;
    RadioGroup radioGroup;
    RadioButton radio_A, radio_B, radio_C, radio_D;
    Button btn_Pre, btn_Submit, btn_Next;
    TextView txt_Question, txt_Time;
    MyOnclick myOnclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_main);
        Init();
        setOnclick();
    }

    private void Init() {
        root = this.getLayoutInflater().inflate(R.layout.popuwindow_style, null);
        popupWindow = new PopupWindow(root, 300, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        txt_Question = (TextView) findViewById(R.id.txt_Question);
        txt_Time = (TextView) findViewById(R.id.txt_Time);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radio_A = (RadioButton) findViewById(R.id.radio_A);
        radio_B = (RadioButton) findViewById(R.id.radio_B);
        radio_C = (RadioButton) findViewById(R.id.radio_C);
        radio_D = (RadioButton) findViewById(R.id.radio_D);
        btn_Pre = (Button) findViewById(R.id.btn_Pre);
        btn_Submit = (Button) findViewById(R.id.btn_Submit);
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
        radioGroup.setOnCheckedChangeListener(myOnclick);
        btn_Pre.setOnClickListener(myOnclick);
        btn_Submit.setOnClickListener(myOnclick);
        btn_Next.setOnClickListener(myOnclick);
    }

    public class MyOnclick implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

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
                case R.id.btn_Submit:
                    break;
                case R.id.btn_Next:
                    break;
            }
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (group.getId() == R.id.radioGroup) {

            }
        }
    }
}

