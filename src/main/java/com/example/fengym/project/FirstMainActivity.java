package com.example.fengym.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FirstMainActivity extends Activity {
    View root;
    PopupWindow popupWindow;
    ListView listView;
    ImageButton imgBtn;
    SimpleAdapter simpleAdapter;
    List<Map<String, Object>> list;
    int[] ImgID = {R.color.orange, R.color.tomato, R.color.salmon,
            R.color.sandybrown, R.color.burlywood, R.color.goldenrod,
            R.color.silver, R.color.lightblue, R.color.sienna,
            R.color.cornflowerblue};
    String[] txt = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);
        Init();
        simpleAdapter = new SimpleAdapter(this, recList(), R.layout.listvew_style_layout,
                new String[]{"img", "img_txt", "txt"}, new int[]{R.id.img, R.id.img_txt, R.id.txt});
        listView.setAdapter(simpleAdapter);
        setOnlcik();
    }

    public void Init() {
        root = this.getLayoutInflater().inflate(R.layout.popuwindow_style, null);
        popupWindow = new PopupWindow(root, 300, ViewGroup.LayoutParams.WRAP_CONTENT);
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
    }

    /*
        根据数据库的长度决定listview的长度
     */
    public List<Map<String, Object>> recList() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", ImgID[i%ImgID.length]);
            map.put("img_txt", Integer.toString(i + 1));
            map.put("txt", "item " + (i + 1));
            list.add(map);
        }
        return list;
    }

    public void setOnlcik() {
        imgBtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Drawable drawable = getDrawable(R.color.gray);
                popupWindow.setBackgroundDrawable(drawable);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(v,50,0);
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
