package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import rx.Observable;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Okta on 05/07/2017.
 */

public interface API {
    @GET("bins/162lqf")
    Call<List<Lapangan>> getAllLapangan();
}
