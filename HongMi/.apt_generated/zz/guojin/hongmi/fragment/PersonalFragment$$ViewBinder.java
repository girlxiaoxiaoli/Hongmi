// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class PersonalFragment$$ViewBinder<T extends zz.guojin.hongmi.fragment.PersonalFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034388, "field 'll_chang_login_pwd'");
    target.ll_chang_login_pwd = finder.castView(view, 2131034388, "field 'll_chang_login_pwd'");
    view = finder.findRequiredView(source, 2131034386, "field 'll_user_group'");
    target.ll_user_group = finder.castView(view, 2131034386, "field 'll_user_group'");
    view = finder.findRequiredView(source, 2131034387, "field 'll_tuijian_list'");
    target.ll_tuijian_list = finder.castView(view, 2131034387, "field 'll_tuijian_list'");
    view = finder.findRequiredView(source, 2131034385, "field 'll_personal_data'");
    target.ll_personal_data = finder.castView(view, 2131034385, "field 'll_personal_data'");
    view = finder.findRequiredView(source, 2131034389, "field 'll_chang_second_pwd'");
    target.ll_chang_second_pwd = finder.castView(view, 2131034389, "field 'll_chang_second_pwd'");
    view = finder.findRequiredView(source, 2131034390, "field 'll_reply'");
    target.ll_reply = finder.castView(view, 2131034390, "field 'll_reply'");
  }

  @Override public void unbind(T target) {
    target.ll_chang_login_pwd = null;
    target.ll_user_group = null;
    target.ll_tuijian_list = null;
    target.ll_personal_data = null;
    target.ll_chang_second_pwd = null;
    target.ll_reply = null;
  }
}
