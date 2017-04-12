// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class UserRegistActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.UserRegistActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034444, "field 'title'");
    target.title = finder.castView(view, 2131034444, "field 'title'");
    view = finder.findRequiredView(source, 2131034299, "field 'et_pwd2'");
    target.et_pwd2 = finder.castView(view, 2131034299, "field 'et_pwd2'");
    view = finder.findRequiredView(source, 2131034283, "field 'll_regist'");
    target.ll_regist = finder.castView(view, 2131034283, "field 'll_regist'");
    view = finder.findRequiredView(source, 2131034307, "field 'et_chat'");
    target.et_chat = finder.castView(view, 2131034307, "field 'et_chat'");
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
    view = finder.findRequiredView(source, 2131034294, "field 'tyl'");
    target.tyl = finder.castView(view, 2131034294, "field 'tyl'");
    view = finder.findRequiredView(source, 2131034306, "field 'et_bank_user'");
    target.et_bank_user = finder.castView(view, 2131034306, "field 'et_bank_user'");
    view = finder.findRequiredView(source, 2131034296, "field 'et_superior'");
    target.et_superior = finder.castView(view, 2131034296, "field 'et_superior'");
    view = finder.findRequiredView(source, 2131034287, "field 'et_sms_code'");
    target.et_sms_code = finder.castView(view, 2131034287, "field 'et_sms_code'");
    view = finder.findRequiredView(source, 2131034304, "field 'et_bank_account'");
    target.et_bank_account = finder.castView(view, 2131034304, "field 'et_bank_account'");
    view = finder.findRequiredView(source, 2131034303, "field 'et_qq'");
    target.et_qq = finder.castView(view, 2131034303, "field 'et_qq'");
    view = finder.findRequiredView(source, 2131034308, "field 'et_alipay'");
    target.et_alipay = finder.castView(view, 2131034308, "field 'et_alipay'");
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
    view = finder.findRequiredView(source, 2131034305, "field 'et_bank_name'");
    target.et_bank_name = finder.castView(view, 2131034305, "field 'et_bank_name'");
    view = finder.findRequiredView(source, 2131034298, "field 'et_true_name'");
    target.et_true_name = finder.castView(view, 2131034298, "field 'et_true_name'");
    view = finder.findRequiredView(source, 2131034297, "field 'et_login_phone'");
    target.et_login_phone = finder.castView(view, 2131034297, "field 'et_login_phone'");
    view = finder.findRequiredView(source, 2131034302, "field 'et_card'");
    target.et_card = finder.castView(view, 2131034302, "field 'et_card'");
    view = finder.findRequiredView(source, 2131034300, "field 'et_pwd_second'");
    target.et_pwd_second = finder.castView(view, 2131034300, "field 'et_pwd_second'");
    view = finder.findRequiredView(source, 2131034301, "field 'et_pwd_second2'");
    target.et_pwd_second2 = finder.castView(view, 2131034301, "field 'et_pwd_second2'");
    view = finder.findRequiredView(source, 2131034153, "field 'et_pwd'");
    target.et_pwd = finder.castView(view, 2131034153, "field 'et_pwd'");
  }

  @Override public void unbind(T target) {
    target.title = null;
    target.et_pwd2 = null;
    target.ll_regist = null;
    target.et_chat = null;
    target.goback = null;
    target.zhuce = null;
    target.tyl = null;
    target.et_bank_user = null;
    target.et_superior = null;
    target.et_sms_code = null;
    target.et_bank_account = null;
    target.et_qq = null;
    target.et_alipay = null;
    target.btn_sms = null;
    target.et_bank_name = null;
    target.et_true_name = null;
    target.et_login_phone = null;
    target.et_card = null;
    target.et_pwd_second = null;
    target.et_pwd_second2 = null;
    target.et_pwd = null;
  }
}
