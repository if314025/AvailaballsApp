package bolalob.develops.stud11314025.availaballs.Dependency;

import bolalob.develops.stud11314025.availaballs.Service.LapanganService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Voldarex on 7/4/2017.
 */
@Module
public class ApiModule {
    @Provides
    @CustomScope
    LapanganService provideLapanganService(Retrofit retrofit) {
        return retrofit.create(LapanganService.class);
    }
}
