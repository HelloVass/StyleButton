package cn.lydia.pero.uiview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import cn.lydia.pero.uiview.library.utils.ColorGenerator;
import cn.lydia.pero.uiview.library.utils.GradientDrawableWrapper;
import cn.lydia.pero.uiview.library.utils.StateListDrawableGenerator;

/**
 * Created by hello on 2017/12/23.
 */

public class UIRelativeLayout extends RelativeLayout {

  private float mRadius;

  private int mStrokeColor;

  private int mStrokeWidth;

  private int mSolidColor;

  private int mPressedColor;

  private float mPressedAlpha;

  public UIRelativeLayout(Context context) {
    this(context, null);
  }

  public UIRelativeLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public UIRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {

    TypedArray typedArray =
        context.obtainStyledAttributes(attrs, R.styleable.UIRelativeLayout, defStyleAttr, 0);

    mPressedAlpha = typedArray.getFloat(R.styleable.UIRelativeLayout_uic_pressed_alpha, 0.46F);
    mRadius = typedArray.getLayoutDimension(R.styleable.UIRelativeLayout_uil_radius, 0);
    mStrokeColor =
        typedArray.getColor(R.styleable.UIRelativeLayout_uil_stroke_color, Color.TRANSPARENT);
    mStrokeWidth = typedArray.getLayoutDimension(R.styleable.UIRelativeLayout_uil_stroke_width, 0);
    mSolidColor =
        typedArray.getColor(R.styleable.UIRelativeLayout_uil_solid_color, Color.TRANSPARENT);
    mPressedColor =
        typedArray.getColor(R.styleable.UIRelativeLayout_uil_pressed_color, Color.TRANSPARENT);

    typedArray.recycle();
  }

  public void setPressedAlpha(@FloatRange(from = 0.0F, to = 1.0F) float pressedAlpha) {

    mPressedAlpha = pressedAlpha;
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  public void setRadius(float radius) {

    mRadius = radius;
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  public void setStrokeColor(@ColorInt int strokeColor) {

    mStrokeColor = strokeColor;
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  public void setStrokeWidth(int strokeWidth) {

    mStrokeWidth = strokeWidth;
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  public void setSolidColor(@ColorInt int solidColor) {

    mSolidColor = solidColor;
    setBackground(StateListDrawableGenerator.generate(generatePressed(), generateDisabled(),
        generateNormal()));
  }

  private GradientDrawableWrapper generatePressed() {

    return new GradientDrawableWrapper.Builder().setCornerRadius(mRadius)
        .setSolidColor(ColorGenerator.generate(mPressedColor, mPressedAlpha))
        .setStroke(mStrokeWidth, ColorGenerator.generate(mStrokeColor, mPressedAlpha))
        .build();
  }

  private GradientDrawableWrapper generateDisabled() {

    return new GradientDrawableWrapper.Builder().setCornerRadius(mRadius)
        .setSolidColor(ColorGenerator.generate(mPressedColor, mPressedAlpha))
        .setStroke(mStrokeWidth, ColorGenerator.generate(mStrokeColor, mPressedAlpha))
        .build();
  }

  private GradientDrawableWrapper generateNormal() {

    return new GradientDrawableWrapper.Builder().setCornerRadius(mRadius)
        .setSolidColor(mSolidColor)
        .setStroke(mStrokeWidth, mStrokeColor)
        .build();
  }
}
