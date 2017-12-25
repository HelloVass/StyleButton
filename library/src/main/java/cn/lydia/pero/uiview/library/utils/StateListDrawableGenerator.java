package cn.lydia.pero.uiview.library.utils;

import android.graphics.drawable.StateListDrawable;

/**
 * Created by hello on 2017/12/23.
 */

public final class StateListDrawableGenerator {

  private final static int[] STATE_NORMAL = new int[] {};

  private final static int[] STATE_PRESSED = new int[] { android.R.attr.state_pressed };

  private final static int[] STATE_DISABLED = new int[] { -android.R.attr.state_enabled };

  private StateListDrawableGenerator() {
    throw new AssertionError();
  }

  public static StateListDrawable generate(GradientDrawableWrapper pressed,
      GradientDrawableWrapper disabled, GradientDrawableWrapper normal) {

    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(STATE_PRESSED, pressed.getGradientDrawable());
    stateListDrawable.addState(STATE_DISABLED, disabled.getGradientDrawable());
    stateListDrawable.addState(STATE_NORMAL, normal.getGradientDrawable());
    return stateListDrawable;
  }
}
