package bolalob.develops.stud11314025.availaballs.Dependency;

import bolalob.develops.stud11314025.availaballs.Activity.MainActivity;
import dagger.Component;

/**
 * Created by Voldarex on 7/4/2017.
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);
}
