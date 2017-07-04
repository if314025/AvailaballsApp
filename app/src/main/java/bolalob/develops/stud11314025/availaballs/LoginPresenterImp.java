package bolalob.develops.stud11314025.availaballs;

import android.text.TextUtils;
import android.view.View;

/**
 * Created by Okta on 03/07/2017.
 */

public class LoginPresenterImp implements LoginPresenter {

    private  LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            loginView.showValidationError();
        }else{
            if (username.equals("test@gmail.com")&& password.equals("test")){
                loginView.loginSucess();
            }
            else {
                loginView.loginError();
            }

        }
    }
}
