package cn.lydia.pero.uiview.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import cn.lydia.pero.uiview.library.utils.ColorStateListGenerator;

/**
 * Created by hello on 2017/12/22.
 */

public class UITextButton extends android.support.v7.widget.AppCompatTextView {

  private int mTextColor;

  private float mPressedAlpha;

  public UITextButton(Context context) {
    this(context, null);
  }

  public UITextButton(Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public UITextButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context, attrs, defStyleAttr);
    setTextColor(ColorStateListGenerator.generate(mTextColor, mPressedAlpha));
  }

  private void init(Context context, AttributeSet attrs, int defStyleAttr) {

    TypedArray typedArray =
        context.obtainStyledAttributes(attrs, R.styleable.UITextButton, defStyleAttr, 0);

    mTextColor = typedArray.getColor(R.styleable.UITextButton_android_textColor, Color.TRANSPARENT);
    mPressedAlpha = typedArray.getFloat(R.styleable.UIImageButton_uic_pressed_alpha, 0.46F);

    typedArray.recycle();
  }

  @Override public void setTextColor(int textColor) {

    mTextColor = textColor;
    setTextColor(ColorStateListGenerator.generate(mTextColor, mPressedAlpha));
  }

  public void setPressedAlpha(float pressedAlpha) {

    mPressedAlpha = pressedAlpha;
    setTextColor(ColorStateListGenerator.generate(mTextColor, mPressedAlpha));
  }
}
