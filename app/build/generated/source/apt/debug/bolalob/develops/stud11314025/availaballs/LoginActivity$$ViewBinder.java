// Generated code from Butter Knife. Do not modify!
package bolalob.develops.stud11314025.availaballs;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends bolalob.develops.stud11314025.availaballs.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558526, "field 'etEmail'");
    target.etEmail = finder.castView(view, 2131558526, "field 'etEmail'");
    view = finder.findRequiredView(source, 2131558525, "field 'etPassword'");
    target.etPassword = finder.castView(view, 2131558525, "field 'etPassword'");
    view = finder.findRequiredView(source, 2131558524, "field 'btnLgn'");
    target.btnLgn = finder.castView(view, 2131558524, "field 'btnLgn'");
  }

  @Override public void unbind(T target) {
    target.etEmail = null;
    target.etPassword = null;
    target.btnLgn = null;
  }
}
