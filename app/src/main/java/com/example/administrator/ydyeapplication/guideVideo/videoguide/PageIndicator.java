package com.example.administrator.ydyeapplication.guideVideo.videoguide;

import android.support.v4.view.ViewPager;

/**
 * A PageIndicator is responsible to show an visual indicator on the total views
 * number and the current visible view.
 */
public interface PageIndicator extends ViewPager.OnPageChangeListener {

	/**
	 * Notify the indicator that the fragment list has changed.
	 */
	public void notifyDataSetChanged();

	/**
	 * <p>
	 * Set the current page of both the ViewPager and indicator.
	 * </p>
	 * 
	 * <p>
	 * This <strong>must</strong> be used if you need to set the page before the
	 * views are drawn on screen (e.g., default start page).
	 * </p>
	 * 
	 * @param item
	 */
	public void setCurrentItem(int item);

	/**
	 * Set a page change listener which will receive forwarded events.
	 * 
	 * @param listener
	 */
	public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);

	public void setPagingEnabled(boolean allow_change);

	/**
	 * Bind the indicator to a ViewPager.
	 * 
	 * @param view
	 */
	public void setViewPager(ExtendedViewPager pager);

	/**
	 * Bind the indicator to a ViewPager.
	 * 
	 * @param view
	 * @param initialPosition
	 */
	public void setViewPager(ExtendedViewPager pager, int initialPosition);
}