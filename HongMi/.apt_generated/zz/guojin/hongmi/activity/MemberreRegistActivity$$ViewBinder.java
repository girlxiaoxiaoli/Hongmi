// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MemberreRegistActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.MemberreRegistActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034299, "field 'name1'");
    target.name1 = finder.castView(view, 2131034299, "field 'name1'");
    view = finder.findRequiredView(source, 2131034304, "field 'qrpswd'");
    target.qrpswd = finder.castView(view, 2131034304, "field 'qrpswd'");
    view = finder.findRequiredView(source, 2131034307, "field 'jies_elim'");
    target.jies_elim = finder.castView(view, 2131034307, "field 'jies_elim'");
    view = finder.findRequiredView(source, 2131034303, "field 'pswd'");
    target.pswd = finder.castView(view, 2131034303, "field 'pswd'");
    view = finder.findRequiredView(source, 2131034309, "field 'tyl'");
    target.tyl = finder.castView(view, 2131034309, "field 'tyl'");
    view = finder.findRequiredView(source, 2131034308, "field 'jies_sj'");
    target.jies_sj = finder.castView(view, 2131034308, "field 'jies_sj'");
    view = finder.findRequiredView(source, 2131034302, "field 'et_sms_code'");
    target.et_sms_code = finder.castView(view, 2131034302, "field 'et_sms_code'");
    view = finder.findRequiredView(source, 2131034461, "field 'titleTextView'");
    target.titleTextView = finder.castView(view, 2131034461, "field 'titleTextView'");
    view = finder.findRequiredView(source, 2131034300, "field 'shouj'");
    target.shouj = finder.castView(view, 2131034300, "field 'shouj'");
    view = finder.findRequiredView(source, 2131034310, "field 'zhuce' and method 'onClick'");
    target.zhuce = finder.castView(view, 2131034310, "field 'zhuce'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034298, "field 'll_regist'");
    target.ll_regist = finder.castView(view, 2131034298, "field 'll_regist'");
    view = finder.findRequiredView(source, 2131034306, "field 'qrerpswd'");
    target.qrerpswd = finder.castView(view, 2131034306, "field 'qrerpswd'");
    view = finder.findRequiredView(source, 2131034305, "field 'erpswd'");
    target.erpswd = finder.castView(view, 2131034305, "field 'erpswd'");
    view = finder.findRequiredView(source, 2131034301, "field 'btn_sms' and method 'smsConfig'");
    target.btn_sms = finder.castView(view, 2131034301, "field 'btn_sms'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.smsConfig(finder.<android.widget.Button>castParam(p0, "doClick", 0, "smsConfig", 0));
        }
      });
    view = finder.findRequiredView(source, 2131034460, "field 'goback' and method 'goBack'");
    target.goback = finder.castView(view, 2131034460, "field 'goback'");
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
    target.name1 = null;
    target.qrpswd = null;
    target.jies_elim = null;
    target.pswd = null;
    target.tyl = null;
    target.jies_sj = null;
    target.et_sms_code = null;
    target.titleTextView = null;
    target.shouj = null;
    target.zhuce = null;
    target.ll_regist = null;
    target.qrerpswd = null;
    target.erpswd = null;
    target.btn_sms = null;
    target.goback = null;
  }
}
