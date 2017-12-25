package cn.lydia.pero.uiview.library.utils;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;

/**
 * Created by hellovass on 2017/10/16.
 *
 * 颜色生成器
 */

public final class ColorGenerator {

  private ColorGenerator() {

  }

  public static int generate(@ColorInt int originalColor, @FloatRange(from = 0.0F, to = 1.0F) float alpha) {

    int red = (originalColor >> 16) & 0xFF;
    int green = (originalColor >> 8) & 0xFF;
    int blue = originalColor & 0xFF;
    return Color.argb(alpha2Int(alpha), red, green, blue);
  }

  private static int alpha2Int(@FloatRange(from = 0.0F, to = 1.0F) float alpha) {

    return (int) (alpha * 255);
  }
}
