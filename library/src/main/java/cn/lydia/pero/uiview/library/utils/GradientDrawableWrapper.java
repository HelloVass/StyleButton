package cn.lydia.pero.uiview.library.utils;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;

/**
 * Created by hello on 2017/12/23.
 */

public class GradientDrawableWrapper {

  private GradientDrawable mGradientDrawable;

  public GradientDrawableWrapper(Builder builder) {

    mGradientDrawable = new GradientDrawable();
    mGradientDrawable.setColor(builder.mSolidColor);
    mGradientDrawable.setCornerRadius(builder.mCornerRadius);
    mGradientDrawable.setStroke(builder.mStrokeWidth, builder.mStrokeColor);
  }

  public GradientDrawable getGradientDrawable() {
    return mGradientDrawable;
  }

  public static final class Builder {

    private float mCornerRadius;

    private int mStrokeWidth;

    private int mStrokeColor;

    private int mSolidColor;

    public Builder setSolidColor(@ColorInt int solidColor) {
      mSolidColor = solidColor;
      return this;
    }

    public Builder setCornerRadius(float cornerRadius) {
      mCornerRadius = cornerRadius;
      return this;
    }

    public Builder setStroke(int strokeWidth, @ColorInt int strokeColor) {
      mStrokeWidth = strokeWidth;
      mStrokeColor = strokeColor;
      return this;
    }

    public GradientDrawableWrapper build() {
      return new GradientDrawableWrapper(this);
    }
  }
}
