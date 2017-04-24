// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class QiangCodeActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.QiangCodeActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034185, "field 'sdpwd'");
    target.sdpwd = finder.castView(view, 2131034185, "field 'sdpwd'");
    view = finder.findRequiredView(source, 2131034186, "field 'btn_ok' and method 'btnConfirm'");
    target.btn_ok = finder.castView(view, 2131034186, "field 'btn_ok'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.btnConfirm(finder.<android.widget.Button>castParam(p0, "doClick", 0, "btnConfirm", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034184, "field 'user'");
    target.user = finder.castView(view, 2131034184, "field 'user'");
    view = finder.findRequiredView(source, 2131034183, "field 'account'");
    target.account = finder.castView(view, 2131034183, "field 'account'");
    view = finder.findRequiredView(source, 2131034181, "field 'tv_count'");
    target.tv_count = finder.castView(view, 2131034181, "field 'tv_count'");
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
    view = finder.findRequiredView(source, 2131034187, "field 'btn_notes' and method 'getNotes'");
    target.btn_notes = finder.castView(view, 2131034187, "field 'btn_notes'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.getNotes(finder.<android.widget.Button>castParam(p0, "doClick", 0, "getNotes", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034465, "field 'title'");
    target.title = finder.castView(view, 2131034465, "field 'title'");
  }

  @Override public void unbind(T target) {
    target.sdpwd = null;
    target.btn_ok = null;
    target.user = null;
    target.account = null;
    target.tv_count = null;
    target.goback = null;
    target.btn_notes = null;
    target.title = null;
  }
}
