package com.example.my.cammertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button goCameraBtn;
    private ImageView showCameraIv;
    private static final int CAMERA_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goCameraBtn = (Button) this.findViewById(R.id.id_go_camera_btn);
        goCameraBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                processGoCamera();
            }

        });

        showCameraIv = (ImageView) this.findViewById(R.id.id_show_camera_iv);
        showCameraIv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                processShowCamera(v);
            }

        });
    }

    /**
     * 处理进入camera事件
     */
    private void processGoCamera() {
        Intent intent = new Intent();
        intent.setClass(this, CameraActivity.class);
        startActivityForResult(intent, CAMERA_CODE);
    }

    /**
     * 处理图片跳转进入预览界面
     */
    private void processShowCamera(View v) {
        Intent intent = new Intent();
        intent.setClass(this, PreviewActivity.class);
        /**
         * 将图片url传给PreviewActivity
         */
        intent.putExtra("cameraUrl", v.getContentDescription().toString());
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (RESULT_OK == resultCode) {
            if (CAMERA_CODE == requestCode) {
                /**
                 * 获取activity返回的url
                 */
                Uri uri = data.getData();
                String url = uri.toString().substring(uri.toString().indexOf("///") + 2);
                if (url != null && !TextUtils.isEmpty(url)) {
                    showCameraIv.setContentDescription(url);
                    showCameraIv.setImageBitmap(HelpUtil.getBitmapByUrl(url));
                }
            }
        }

    }

}
