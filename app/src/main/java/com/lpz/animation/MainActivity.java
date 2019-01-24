package com.lpz.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.jaredrummler.android.widget.AnimatedSvgView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.animated_svg_view)
    AnimatedSvgView svgView;
    @BindView(R.id.main_rl)
    RelativeLayout mainRl;

    private int index = 0;

    String[] svgs = {"adlhb.svg", "adlhb2.svg", "mote.scg", "mote_2.svg", "mote_3.svg", "mote_4.svg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏


        setSvg(svgs[index]);


        svgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svgView.start();
            }
        });
    }

    public void toNext(View view) {
        if (index < svgs.length - 1) {
            mainRl.setBackgroundColor(Color.parseColor("#000000"));
            index++;
            setSvg(svgs[index]);
        } else {
            mainRl.setBackgroundColor(Color.parseColor("#000000"));
            setSvg(svgs[0]);
            index = 0;
        }
    }

    public void setSvg(String asstes_name) {
        svgView.startSvgDataResource(asstes_name);
        svgView.setViewportSize(600, 700);
        svgView.setTraceResidueColor(0x22000000);
        svgView.rebuildGlyphData();
        svgView.start();
    }
}
