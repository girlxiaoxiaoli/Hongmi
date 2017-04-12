// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class OutActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.OutActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034340, "field 'spinnerst'");
    target.spinnerst = finder.castView(view, 2131034340, "field 'spinnerst'");
    view = finder.findRequiredView(source, 2131034342, "field 'ed'");
    target.ed = finder.castView(view, 2131034342, "field 'ed'");
  }

  @Override public void unbind(T target) {
    target.spinnerst = null;
    target.ed = null;
  }
}
