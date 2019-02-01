package com.example.gthideheaderdemo;

import com.example.gthideheaderdemo.listener.OnSscrollChangedListener;
import com.example.gthideheaderdemo.view.AddPopWindow;
import com.example.gthideheaderdemo.view.GtScrollView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity implements OnClickListener{

	private ImageView back,add;
	private ImageView imgHead;
	private RelativeLayout header;
	private int height = 0;
	private GtScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews();
        setListener();
    }


    private void setListener() {
		// TODO 自动生成的方法存根
		back.setOnClickListener(this);
		add.setOnClickListener(this);
	}


	private void initViews() {
		// TODO 自动生成的方法存根
    	scroll = (GtScrollView) findViewById(R.id.scrollview);
		back = (ImageView) findViewById(R.id.back);
		add = (ImageView) findViewById(R.id.add);
		imgHead = (ImageView) findViewById(R.id.head_img);
		header = (RelativeLayout) findViewById(R.id.header);
		header.setBackgroundColor(Color.argb(0, 0xfd, 0x91, 0x5b));
		ViewTreeObserver vto = imgHead.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onGlobalLayout() {
				imgHead.getViewTreeObserver().removeGlobalOnLayoutListener(
						this);
				height = imgHead.getHeight();
				imgHead.getWidth();

				scroll.setOnScrollChangedListener(new OnSscrollChangedListener() {
					
					@Override
					public void onScrollChanged(GtScrollView scrollView, int x, int y,
							int oldx, int oldy) {
						// TODO 自动生成的方法存根
						if (y <= height) {
							float scale = (float) y / height;
							float alpha = (255 * scale);
							header.setBackgroundColor(Color.argb((int) alpha, 0xfd, 0x91,
									0x5b));
						}
					}
				});
			}
		});
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View view) {
		// TODO 自动生成的方法存根
		switch (view.getId()) {
		case R.id.back:
			finish();
			break;
		case R.id.add:
			popWindow();
			break;

		default:
			break;
		}
	}


	private void popWindow() {
		// TODO 自动生成的方法存根
		AddPopWindow pop = new AddPopWindow(MainActivity.this, new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		pop.showAtLocation(add, Gravity.TOP|Gravity.RIGHT, 10, 230);
	}
}
