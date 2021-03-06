package cc.fotoplace.camera.animation;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;

public class CaptureAnimation extends Animation implements AnimationListener {

	private View mView;

	public CaptureAnimation(View view) {
		mView = view;
		setDuration(400);
		setAnimationListener(this);
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		float alpha;
		if (interpolatedTime < 0.125) {
			alpha = interpolatedTime / 0.125f;
		} else if (interpolatedTime >= 0.125 && interpolatedTime < 0.5) {
			alpha = 1.0f;
		} else {
			alpha = 0.8f * (1 - interpolatedTime) / 0.5f;
		}
		mView.setBackgroundColor(Color.argb((int) (alpha * 255 * 0.8), 0, 0, 0));
	}

	@Override
	public void onAnimationStart(Animation animation) {
		mView.setBackgroundColor(Color.TRANSPARENT);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
	}

	@Override
	public void onAnimationEnd(Animation animation) {
	}

}
