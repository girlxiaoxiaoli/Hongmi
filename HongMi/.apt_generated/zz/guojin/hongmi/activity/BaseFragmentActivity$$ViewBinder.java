// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BaseFragmentActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.BaseFragmentActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034146, "field 'radio1' and method 'onClick'");
    target.radio1 = finder.castView(view, 2131034146, "field 'radio1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034148, "field 'radio3' and method 'onClick'");
    target.radio3 = finder.castView(view, 2131034148, "field 'radio3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034147, "field 'radio2' and method 'onClick'");
    target.radio2 = finder.castView(view, 2131034147, "field 'radio2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
    view = finder.findRequiredView(source, 2131034149, "field 'frameLayout'");
    target.frameLayout = finder.castView(view, 2131034149, "field 'frameLayout'");
    view = finder.findRequiredView(source, 2131034145, "field 'radioGroup'");
    target.radioGroup = finder.castView(view, 2131034145, "field 'radioGroup'");
    view = finder.findRequiredView(source, 2131034443, "field 'goback' and method 'goBack'");
    target.goback = finder.castView(view, 2131034443, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.goBack();
        }
      });
  }

  @Override public void unbind(T target) {
    target.radio1 = null;
    target.radio3 = null;
    target.radio2 = null;
    target.title = null;
    target.frameLayout = null;
    target.radioGroup = null;
    target.goback = null;
  }
}
