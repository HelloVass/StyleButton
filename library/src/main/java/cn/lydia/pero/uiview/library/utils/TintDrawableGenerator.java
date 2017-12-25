package cn.lydia.pero.uiview.library.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * Created by hello on 2017/12/23.
 *
 * 将 Drawable 进行 tint 的工具类
 */

public final class TintDrawableGenerator {

  private TintDrawableGenerator() {
    throw new AssertionError();
  }


  public static Drawable tintDrawable(@NonNull Drawable source,
      @NonNull ColorStateList colorStateList) {

    Drawable wrappedDrawable = DrawableCompat.wrap(source);
    DrawableCompat.setTintList(wrappedDrawable, colorStateList);
    return wrappedDrawable;
  }
}
