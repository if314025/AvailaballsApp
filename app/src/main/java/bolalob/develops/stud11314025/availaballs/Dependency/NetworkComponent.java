package bolalob.develops.stud11314025.availaballs.Dependency;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Voldarex on 7/4/2017.
 */
@Singleton
@Component(modules = NetworkModules.class)
public interface NetworkComponent {

    Retrofit retrofit();
}
