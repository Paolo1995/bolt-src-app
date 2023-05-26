package ee.mtakso.driver.ui.screens.login.v3.common;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;

/* compiled from: SharedLoginV3ViewModel.kt */
/* loaded from: classes3.dex */
public final class SharedLoginV3ViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<LoginEvent> f30653f = new MutableLiveData<>();

    /* compiled from: SharedLoginV3ViewModel.kt */
    /* loaded from: classes3.dex */
    public enum LoginEvent {
        NONE,
        CLEAR_USERNAME
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void D() {
        this.f30653f.o(LoginEvent.NONE);
    }

    public final LiveData<LoginEvent> E() {
        return this.f30653f;
    }
}
