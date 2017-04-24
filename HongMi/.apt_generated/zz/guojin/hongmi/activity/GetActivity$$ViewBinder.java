// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GetActivity$$ViewBinder<T extends zz.guojin.hongmi.activity.GetActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034137, "field 'tv_hongmi_purse'");
    target.tv_hongmi_purse = finder.castView(view, 2131034137, "field 'tv_hongmi_purse'");
    view = finder.findRequiredView(source, 2131034139, "field 'tv_tuijian_purse'");
    target.tv_tuijian_purse = finder.castView(view, 2131034139, "field 'tv_tuijian_purse'");
    view = finder.findRequiredView(source, 2131034135, "field 'tuijian_purse_get'");
    target.tuijian_purse_get = finder.castView(view, 2131034135, "field 'tuijian_purse_get'");
    view = finder.findRequiredView(source, 2131034134, "field 'jingli_purse_get'");
    target.jingli_purse_get = finder.castView(view, 2131034134, "field 'jingli_purse_get'");
    view = finder.findRequiredView(source, 2131034131, "field 'll_accept_help'");
    target.ll_accept_help = finder.castView(view, 2131034131, "field 'll_accept_help'");
    view = finder.findRequiredView(source, 2131034132, "field 'purse'");
    target.purse = finder.castView(view, 2131034132, "field 'purse'");
    view = finder.findRequiredView(source, 2131034464, "field 'iv_goback' and method 'goBack'");
    target.iv_goback = finder.castView(view, 2131034464, "field 'iv_goback'");
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
    view = finder.findRequiredView(source, 2131034133, "field 'hongmi_purse_get'");
    target.hongmi_purse_get = finder.castView(view, 2131034133, "field 'hongmi_purse_get'");
    view = finder.findRequiredView(source, 2131034138, "field 'tv_jingli_purse'");
    target.tv_jingli_purse = finder.castView(view, 2131034138, "field 'tv_jingli_purse'");
    view = finder.findRequiredView(source, 2131034144, "field 'jsbz' and method 'onClick'");
    target.jsbz = finder.castView(view, 2131034144, "field 'jsbz'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131034143, "field 'et_pwd_get'");
    target.et_pwd_get = finder.castView(view, 2131034143, "field 'et_pwd_get'");
    view = finder.findRequiredView(source, 2131034141, "field 'et_money_get'");
    target.et_money_get = finder.castView(view, 2131034141, "field 'et_money_get'");
  }

  @Override public void unbind(T target) {
    target.tv_hongmi_purse = null;
    target.tv_tuijian_purse = null;
    target.tuijian_purse_get = null;
    target.jingli_purse_get = null;
    target.ll_accept_help = null;
    target.purse = null;
    target.iv_goback = null;
    target.title = null;
    target.hongmi_purse_get = null;
    target.tv_jingli_purse = null;
    target.jsbz = null;
    target.et_pwd_get = null;
    target.et_money_get = null;
  }
}
