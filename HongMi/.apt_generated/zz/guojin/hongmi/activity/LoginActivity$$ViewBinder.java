// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034464, "field 'goback' and method 'onClick'");
    target.goback = finder.castView(view, 2131034464, "field 'goback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034243, "field 'forget' and method 'onClick'");
    target.forget = finder.castView(view, 2131034243, "field 'forget'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034244, "field 'zc' and method 'onClick'");
    target.zc = finder.castView(view, 2131034244, "field 'zc'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034177, "field 'et_user'");
    target.et_user = finder.castView(view, 2131034177, "field 'et_user'");
    view = finder.findRequiredView(source, 2131034242, "field 'login' and method 'onClick'");
    target.login = finder.castView(view, 2131034242, "field 'login'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034157, "field 'et_pwd'");
    target.et_pwd = finder.castView(view, 2131034157, "field 'et_pwd'");
  }

  @Override public void unbind(T target) {
    target.title = null;
    target.goback = null;
    target.forget = null;
    target.zc = null;
    target.et_user = null;
    target.login = null;
    target.et_pwd = null;
  }
}
