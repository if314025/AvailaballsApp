package bolalob.develops.stud11314025.availaballs.Service;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.LapanganResponse;
import retrofit2.http.GET;

/**
 * Created by Voldarex on 7/4/2017.
 */

public interface LapanganService {

    @GET("bins/17wd0n/")
    rx.Observable<List<LapanganResponse>> getLapangan();

}
