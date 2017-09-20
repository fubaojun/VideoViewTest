package com.iothouse.videoviewtest;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mVideoView= (VideoView) findViewById(R.id.videoView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //得到sdcard下面aa.mp4的視頻文件
                //两种调用方式
//                File videofile =new File("/mut/extSdCard/DCIM/Camera/20150915_160202.mp4");
//                mVideoView.setVideoPath(videofile.getAbsolutePath());
                String fpath = Environment.getExternalStorageDirectory()+"/SVID_20170918_002811.mp4";
//                String fpath = Environment.getExternalStorageDirectory()+"/11.mp4";
//                String fpath = "/storage/sdcard1"+"/11.mp4";
                File fd = new File(fpath);
                Log.e("mVideoView", ""+fd.toString()+fd.canRead()+fd.exists());
//                Log.e("mVideoView", Environment.getExternalStorageDirectory()+"/SVID_20170918_002811.mp4");
//                mVideoView.setVideoPath(fpath);
                //大熊兔（VOD）：rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov
                String url="rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov"; // 可用 低分辨率
//                String url="http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8"; // 可用 高清
                mVideoView.setVideoPath(url);
                mVideoView.setMediaController(new MediaController(MainActivity.this));
                mVideoView.start();
                Snackbar.make(view, "Playing Video!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
