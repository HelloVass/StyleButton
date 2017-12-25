package cn.lydia.pero.uiview.library.utils;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;

/**
 * Created by hello on 2017/12/23.
 */

public final class ColorStateListGenerator {

  /**
   * 默认支持的状态
   */
  private static final int[][] SUPPORT_STATES = new int[][] {
      new int[] { android.R.attr.state_pressed }, new int[] { -android.R.attr.state_enabled },
      new int[] {}
  };

  private ColorStateListGenerator() {
    throw new IllegalStateException();
  }

  public static ColorStateList generate(@ColorInt int normal,
      @FloatRange(from = 0.0F, to = 1.0F) float alpha) {

    return new ColorStateList(SUPPORT_STATES, new int[] {
        ColorGenerator.generate(normal, alpha), ColorGenerator.generate(normal, alpha), normal
    });
  }
}
