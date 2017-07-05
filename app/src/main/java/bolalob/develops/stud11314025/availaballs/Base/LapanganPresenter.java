package bolalob.develops.stud11314025.availaballs.Base;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.LapanganResponse;
import bolalob.develops.stud11314025.availaballs.Service.LapanganViewInterface;

/**
 * Created by Voldarex on 7/4/2017.
 */

public class LapanganPresenter extends BasePresenter implements rx.Observer<List<LapanganResponse>> {

    private LapanganViewInterface mViewInterface;

    public LapanganPresenter(LapanganViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }


    @Override
    public void onCompleted() {
        mViewInterface.completed();
    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<LapanganResponse> lapanganResponseList) {
        mViewInterface.onLapangan(lapanganResponseList);
    }

    public void fetchLapangan() {
        unScubscribeAll();
        subscribe(mViewInterface.getLapangan(), LapanganPresenter.this);
    }
}
