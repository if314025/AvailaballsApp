package bolalob.develops.stud11314025.availaballs.Application;

import android.app.Application;

import bolalob.develops.stud11314025.availaballs.Dependency.ApiComponent;
import bolalob.develops.stud11314025.availaballs.Dependency.DaggerApiComponent;
import bolalob.develops.stud11314025.availaballs.Dependency.DaggerNetworkComponent;
import bolalob.develops.stud11314025.availaballs.Dependency.NetworkComponent;
import bolalob.develops.stud11314025.availaballs.Dependency.NetworkModules;
import bolalob.develops.stud11314025.availaballs.Model.Constant;

/**
 * Created by Voldarex on 7/4/2017.
 */

public class LapanganApplication extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModules(new NetworkModules(Constant.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }
}
