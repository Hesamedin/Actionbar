package com.kamalan.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kamalan.actionbar.R;

public class ActionBar extends RelativeLayout {

	private Context context;
	private ActionbarClickedListener actionbarClickedListener;
	
	private LayoutInflater mInflater;
	private TextView mTitleView;
	private ProgressBar mProgress;
	private ImageView mImageView;
	private ImageButton ibStage;
	
	public ActionBar(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public ActionBar(final Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public ActionBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();
	}
	
	public void init() {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		RelativeLayout barView = (RelativeLayout) mInflater.inflate(R.layout.actionbar, null);
		addView(barView);

		mProgress  = (ProgressBar) barView.findViewById(R.id.actionbar_progress);
		mTitleView = (TextView) barView.findViewById(R.id.actionbar_title);
		mImageView = (ImageView) barView.findViewById(R.id.actionbar_menu);
		mImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				actionbarClickedListener.eventOccured(v.getId());
			}
		});
		
		ibStage = (ImageButton) barView.findViewById(R.id.actionbar_stage);
		ibStage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				actionbarClickedListener.eventOccured(v.getId());
			}
		});
	}
	
	
	public void setOnItemClickedListener(ActionbarClickedListener actionbarClickedListener) {
		this.actionbarClickedListener = actionbarClickedListener;
	}
	
	public interface ActionbarClickedListener {
		public void eventOccured(int id);
	}
	
	
	
		
	public void setTitle(int resId) {
		mTitleView.setText(resId);
	}
	
	public void setTitle(String title) {
		mTitleView.setText(title);
	}
	
	public void showProgressBar() {
		mProgress.setVisibility(View.VISIBLE);
	}
	
	public void hideProgressBar() {
		mProgress.setVisibility(View.INVISIBLE);
	}
	
	public boolean isProgressBarVisible() {
		return mProgress.isShown();
	}
	
	public void hideMenu() {
		mImageView.setVisibility(View.INVISIBLE);
	}
	
	public void showMenu() {
		mImageView.setVisibility(View.VISIBLE);
	}
	
	public void showStage() {
		ibStage.setVisibility(View.VISIBLE);
	}
	
	public void hideStage() {
		ibStage.setVisibility(View.INVISIBLE);
	}

}
