// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PersonalDataActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.PersonalDataActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034277, "field 'bank_account'");
    target.bank_account = finder.castView(view, 2131034277, "field 'bank_account'");
    view = finder.findRequiredView(source, 2131034279, "field 'bank'");
    target.bank = finder.castView(view, 2131034279, "field 'bank'");
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
    view = finder.findRequiredView(source, 2131034275, "field 'weixin'");
    target.weixin = finder.castView(view, 2131034275, "field 'weixin'");
    view = finder.findRequiredView(source, 2131034274, "field 'tv_qq'");
    target.tv_qq = finder.castView(view, 2131034274, "field 'tv_qq'");
    view = finder.findRequiredView(source, 2131034272, "field 'name'");
    target.name = finder.castView(view, 2131034272, "field 'name'");
    view = finder.findRequiredView(source, 2131034276, "field 'zhifu'");
    target.zhifu = finder.castView(view, 2131034276, "field 'zhifu'");
    view = finder.findRequiredView(source, 2131034270, "field 'll_my_personal_data'");
    target.ll_my_personal_data = finder.castView(view, 2131034270, "field 'll_my_personal_data'");
    view = finder.findRequiredView(source, 2131034273, "field 'tv_supper_user'");
    target.tv_supper_user = finder.castView(view, 2131034273, "field 'tv_supper_user'");
    view = finder.findRequiredView(source, 2131034278, "field 'tv_bank_user'");
    target.tv_bank_user = finder.castView(view, 2131034278, "field 'tv_bank_user'");
    view = finder.findRequiredView(source, 2131034271, "field 'phone'");
    target.phone = finder.castView(view, 2131034271, "field 'phone'");
    view = finder.findRequiredView(source, 2131034461, "field 'title'");
    target.title = finder.castView(view, 2131034461, "field 'title'");
  }

  @Override public void unbind(T target) {
    target.bank_account = null;
    target.bank = null;
    target.goback = null;
    target.weixin = null;
    target.tv_qq = null;
    target.name = null;
    target.zhifu = null;
    target.ll_my_personal_data = null;
    target.tv_supper_user = null;
    target.tv_bank_user = null;
    target.phone = null;
    target.title = null;
  }
}
