package com.example.gthideheaderdemo.view;

import com.example.gthideheaderdemo.listener.OnSscrollChangedListener;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class GtScrollView extends ScrollView {

	private OnSscrollChangedListener scrollViewListener = null;

	public GtScrollView(Context context) {
		super(context);
	}

	public GtScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public GtScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setOnScrollChangedListener(OnSscrollChangedListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

}
