// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MemberreRegistActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.MemberreRegistActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034289, "field 'qrpswd'");
    target.qrpswd = finder.castView(view, 2131034289, "field 'qrpswd'");
    view = finder.findRequiredView(source, 2131034290, "field 'erpswd'");
    target.erpswd = finder.castView(view, 2131034290, "field 'erpswd'");
    view = finder.findRequiredView(source, 2131034283, "field 'll_regist'");
    target.ll_regist = finder.castView(view, 2131034283, "field 'll_regist'");
    view = finder.findRequiredView(source, 2131034287, "field 'et_sms_code'");
    target.et_sms_code = finder.castView(view, 2131034287, "field 'et_sms_code'");
    view = finder.findRequiredView(source, 2131034285, "field 'shouj'");
    target.shouj = finder.castView(view, 2131034285, "field 'shouj'");
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
    view = finder.findRequiredView(source, 2131034293, "field 'jies_sj'");
    target.jies_sj = finder.castView(view, 2131034293, "field 'jies_sj'");
    view = finder.findRequiredView(source, 2131034292, "field 'jies_elim'");
    target.jies_elim = finder.castView(view, 2131034292, "field 'jies_elim'");
    view = finder.findRequiredView(source, 2131034444, "field 'titleTextView'");
    target.titleTextView = finder.castView(view, 2131034444, "field 'titleTextView'");
    view = finder.findRequiredView(source, 2131034294, "field 'tyl'");
    target.tyl = finder.castView(view, 2131034294, "field 'tyl'");
    view = finder.findRequiredView(source, 2131034295, "field 'zhuce' and method 'onClick'");
    target.zhuce = finder.castView(view, 2131034295, "field 'zhuce'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034288, "field 'pswd'");
    target.pswd = finder.castView(view, 2131034288, "field 'pswd'");
    view = finder.findRequiredView(source, 2131034291, "field 'qrerpswd'");
    target.qrerpswd = finder.castView(view, 2131034291, "field 'qrerpswd'");
    view = finder.findRequiredView(source, 2131034284, "field 'name1'");
    target.name1 = finder.castView(view, 2131034284, "field 'name1'");
    view = finder.findRequiredView(source, 2131034286, "field 'btn_sms' and method 'smsConfig'");
    target.btn_sms = finder.castView(view, 2131034286, "field 'btn_sms'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.smsConfig(finder.<android.widget.Button>castParam(p0, "doClick", 0, "smsConfig", 0));
        }
      });
  }

  @Override public void unbind(T target) {
    target.qrpswd = null;
    target.erpswd = null;
    target.ll_regist = null;
    target.et_sms_code = null;
    target.shouj = null;
    target.goback = null;
    target.jies_sj = null;
    target.jies_elim = null;
    target.titleTextView = null;
    target.tyl = null;
    target.zhuce = null;
    target.pswd = null;
    target.qrerpswd = null;
    target.name1 = null;
    target.btn_sms = null;
  }
}
