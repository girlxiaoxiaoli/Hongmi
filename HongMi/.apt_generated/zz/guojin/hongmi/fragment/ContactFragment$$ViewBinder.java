// Generated code from Butter Knife. Do not modify!
package zz.guojin.hongmi.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ContactFragment$$ViewBinder<T extends zz.guojin.hongmi.fragment.ContactFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034339, "field 'll_my_contact'");
    target.ll_my_contact = finder.castView(view, 2131034339, "field 'll_my_contact'");
    view = finder.findRequiredView(source, 2131034343, "field 'but_tij'");
    target.but_tij = finder.castView(view, 2131034343, "field 'but_tij'");
    view = finder.findRequiredView(source, 2131034341, "field 'lybt1'");
    target.lybt1 = finder.castView(view, 2131034341, "field 'lybt1'");
    view = finder.findRequiredView(source, 2131034340, "field 'spinnerCardNumber'");
    target.spinnerCardNumber = finder.castView(view, 2131034340, "field 'spinnerCardNumber'");
    view = finder.findRequiredView(source, 2131034342, "field 'lynr1'");
    target.lynr1 = finder.castView(view, 2131034342, "field 'lynr1'");
  }

  @Override public void unbind(T target) {
    target.ll_my_contact = null;
    target.but_tij = null;
    target.lybt1 = null;
    target.spinnerCardNumber = null;
    target.lynr1 = null;
  }
}