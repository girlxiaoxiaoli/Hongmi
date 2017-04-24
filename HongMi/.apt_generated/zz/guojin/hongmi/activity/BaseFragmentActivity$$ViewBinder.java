// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;


public class BaseFragmentActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.BaseFragmentActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034152, "field 'radio3' and method 'onClick'");
    target.radio3 = finder.castView(view, 2131034152, "field 'radio3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034149, "field 'radioGroup'");
    target.radioGroup = finder.castView(view, 2131034149, "field 'radioGroup'");
    view = finder.findRequiredView(source, 2131034150, "field 'radio1' and method 'onClick'");
    target.radio1 = finder.castView(view, 2131034150, "field 'radio1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034153, "field 'frameLayout'");
    target.frameLayout = finder.castView(view, 2131034153, "field 'frameLayout'");
    view = finder.findRequiredView(source, 2131034151, "field 'radio2' and method 'onClick'");
    target.radio2 = finder.castView(view, 2131034151, "field 'radio2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034464, "field 'goback' and method 'goBack'");
    target.goback = finder.castView(view, 2131034464, "field 'goback'");
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
    target.radio3 = null;
    target.title = null;
    target.radioGroup = null;
    target.radio1 = null;
    target.frameLayout = null;
    target.radio2 = null;
    target.goback = null;
  }
}
