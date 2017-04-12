// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class FindLoginPwdActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.FindLoginPwdActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034443, "field 'ivGoback' and method 'myClick'");
    target.ivGoback = finder.castView(view, 2131034443, "field 'ivGoback'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034218, "field 'btnNumberCode' and method 'myClick'");
    target.btnNumberCode = finder.castView(view, 2131034218, "field 'btnNumberCode'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034444, "field 'titleTextView'");
    target.titleTextView = finder.castView(view, 2131034444, "field 'titleTextView'");
    view = finder.findRequiredView(source, 2131034216, "field 'etPhone'");
    target.etPhone = finder.castView(view, 2131034216, "field 'etPhone'");
    view = finder.findRequiredView(source, 2131034217, "field 'etPhoneCode'");
    target.etPhoneCode = finder.castView(view, 2131034217, "field 'etPhoneCode'");
    view = finder.findRequiredView(source, 2131034219, "field 'etPhonePwd'");
    target.etPhonePwd = finder.castView(view, 2131034219, "field 'etPhonePwd'");
    view = finder.findRequiredView(source, 2131034220, "field 'btnConfirm' and method 'myClick'");
    target.btnConfirm = finder.castView(view, 2131034220, "field 'btnConfirm'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.myClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.ivGoback = null;
    target.btnNumberCode = null;
    target.titleTextView = null;
    target.etPhone = null;
    target.etPhoneCode = null;
    target.etPhonePwd = null;
    target.btnConfirm = null;
  }
}
