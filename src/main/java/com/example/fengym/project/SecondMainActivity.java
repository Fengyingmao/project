package com.example.fengym.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fengym on 2016/4/26.
 */
public class SecondMainActivity extends Activity {
    ImageButton imgBtn;
    View root;
    PopupWindow popupWindow;
    GridView gridView;
    List<Map<String, Object>> list;
    SimpleAdapter simpleAdapter;
    int[] ImgID = {R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        Init();
        simpleAdapter = new SimpleAdapter(this, recList(), R.layout.gridview_style_layout,
                new String[]{"img", "txt"}, new int[]{R.id.img, R.id.txt});
        gridView.setAdapter(simpleAdapter);
        setOnlcik();
    }

    private void Init() {
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        gridView = (GridView) findViewById(R.id.gridView);
        root = this.getLayoutInflater().inflate(R.layout.popuwindow_style, null);
        popupWindow = new PopupWindow(root, 300, ViewGroup.LayoutParams.WRAP_CONTENT);
        list = new ArrayList<>();
    }

    public List<Map<String, Object>> recList() {
        for (int i = 0; i < 9; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("img", ImgID[0]);
            map.put("txt", "" + i);
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
                popupWindow.showAsDropDown(v, 50, 0);
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
