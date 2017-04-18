// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChangeLoginPwdActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.ChangeLoginPwdActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034160, "field 'btn' and method 'changLoginPwd'");
    target.btn = finder.castView(view, 2131034160, "field 'btn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.changLoginPwd(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034155, "field 'll_my_login_pwd'");
    target.ll_my_login_pwd = finder.castView(view, 2131034155, "field 'll_my_login_pwd'");
    view = finder.findRequiredView(source, 2131034159, "field 'et_confirm_new_pwd'");
    target.et_confirm_new_pwd = finder.castView(view, 2131034159, "field 'et_confirm_new_pwd'");
    view = finder.findRequiredView(source, 2131034157, "field 'et_pwd'");
    target.et_pwd = finder.castView(view, 2131034157, "field 'et_pwd'");
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
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
    view = finder.findRequiredView(source, 2131034158, "field 'et_new_pwd'");
    target.et_new_pwd = finder.castView(view, 2131034158, "field 'et_new_pwd'");
  }

  @Override public void unbind(T target) {
    target.btn = null;
    target.ll_my_login_pwd = null;
    target.et_confirm_new_pwd = null;
    target.et_pwd = null;
    target.goback = null;
    target.title = null;
    target.et_new_pwd = null;
  }
}
