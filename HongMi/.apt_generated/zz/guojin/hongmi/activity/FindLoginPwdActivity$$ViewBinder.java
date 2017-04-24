// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FindLoginPwdActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.FindLoginPwdActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034464, "field 'ivGoback' and method 'myClick'");
    target.ivGoback = finder.castView(view, 2131034464, "field 'ivGoback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034222, "field 'btnNumberCode' and method 'myClick'");
    target.btnNumberCode = finder.castView(view, 2131034222, "field 'btnNumberCode'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034224, "field 'btnConfirm' and method 'myClick'");
    target.btnConfirm = finder.castView(view, 2131034224, "field 'btnConfirm'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034220, "field 'etPhone'");
    target.etPhone = finder.castView(view, 2131034220, "field 'etPhone'");
    view = finder.findRequiredView(source, 2131034465, "field 'titleTextView'");
    target.titleTextView = finder.castView(view, 2131034465, "field 'titleTextView'");
    view = finder.findRequiredView(source, 2131034221, "field 'etPhoneCode'");
    target.etPhoneCode = finder.castView(view, 2131034221, "field 'etPhoneCode'");
    view = finder.findRequiredView(source, 2131034223, "field 'etPhonePwd'");
    target.etPhonePwd = finder.castView(view, 2131034223, "field 'etPhonePwd'");
  }

  @Override public void unbind(T target) {
    target.ivGoback = null;
    target.btnNumberCode = null;
    target.btnConfirm = null;
    target.etPhone = null;
    target.titleTextView = null;
    target.etPhoneCode = null;
    target.etPhonePwd = null;
  }
}
