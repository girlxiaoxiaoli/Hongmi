// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ActivationCodeActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.ActivationCodeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
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
    view = finder.findRequiredView(source, 2131034180, "field 'btn_notes' and method 'getNotes'");
    target.btn_notes = finder.castView(view, 2131034180, "field 'btn_notes'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.getNotes(finder.<android.widget.Button>castParam(p0, "doClick", 0, "getNotes", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034179, "field 'btn_ok' and method 'btnConfirm'");
    target.btn_ok = finder.castView(view, 2131034179, "field 'btn_ok'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.btnConfirm(finder.<android.widget.Button>castParam(p0, "doClick", 0, "btnConfirm", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034176, "field 'account'");
    target.account = finder.castView(view, 2131034176, "field 'account'");
    view = finder.findRequiredView(source, 2131034175, "field 'tv_count'");
    target.tv_count = finder.castView(view, 2131034175, "field 'tv_count'");
    view = finder.findRequiredView(source, 2131034178, "field 'sdpwd'");
    target.sdpwd = finder.castView(view, 2131034178, "field 'sdpwd'");
    view = finder.findRequiredView(source, 2131034174, "field 'll_code_exchange'");
    target.ll_code_exchange = finder.castView(view, 2131034174, "field 'll_code_exchange'");
    view = finder.findRequiredView(source, 2131034177, "field 'user'");
    target.user = finder.castView(view, 2131034177, "field 'user'");
  }

  @Override public void unbind(T target) {
    target.goback = null;
    target.title = null;
    target.btn_notes = null;
    target.btn_ok = null;
    target.account = null;
    target.tv_count = null;
    target.sdpwd = null;
    target.ll_code_exchange = null;
    target.user = null;
  }
}
