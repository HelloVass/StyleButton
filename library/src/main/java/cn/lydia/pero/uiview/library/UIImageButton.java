package cn.lydia.pero.uiview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import cn.lydia.pero.uiview.library.utils.ColorStateListGenerator;
import cn.lydia.pero.uiview.library.utils.TintDrawableGenerator;

/**
 * Created by hello on 2017/11/30.
 */

public class UIImageButton extends android.support.v7.widget.AppCompatImageView {

  private int mColor;

  private Drawable mSrc;

  private float mPressedAlpha;

  public UIImageButton(Context context) {
    this(context, null);
  }

  public UIImageButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public UIImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
    setSrc(mSrc);
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {

    TypedArray typedArray =
        context.obtainStyledAttributes(attrs, R.styleable.UIImageButton, defStyleAttr, 0);

    mColor = typedArray.getColor(R.styleable.UIImageButton_uiib_src_color, Color.TRANSPARENT);
    mSrc = typedArray.getDrawable(R.styleable.UIImageButton_android_src);
    mPressedAlpha = typedArray.getFloat(R.styleable.UIImageButton_uic_pressed_alpha, 0.46F);

    typedArray.recycle();
  }

  /**
   * 更新图片
   */
  public void setSrc(Drawable src) {

    if (src == null) {
      throw new IllegalArgumentException("you must set image src！！！");
    }

    mSrc = src;
    setImageDrawable(
        TintDrawableGenerator.tintDrawable(mSrc.mutate(), ColorStateListGenerator.generate(mColor, mPressedAlpha)));
  }

  /**
   * 更新图片颜色
   */
  public void setColor(@ColorInt int color) {

    mColor = color;
    setImageDrawable(
        TintDrawableGenerator.tintDrawable(mSrc.mutate(), ColorStateListGenerator.generate(mColor, mPressedAlpha)));
  }

  /**
   * 更新按下去的透明度
   */
  public void setPressedAlpha(float pressedAlpha) {

    mPressedAlpha = pressedAlpha;
    setImageDrawable(
        TintDrawableGenerator.tintDrawable(mSrc.mutate(), ColorStateListGenerator.generate(mColor, mPressedAlpha)));
  }
}
