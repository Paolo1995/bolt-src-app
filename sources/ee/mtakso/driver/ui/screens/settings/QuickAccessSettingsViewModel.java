package ee.mtakso.driver.ui.screens.settings;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.QuickAccessStateAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QuickAccessSettingsViewModel.kt */
/* loaded from: classes5.dex */
public final class QuickAccessSettingsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final DriverProvider f33025f;

    /* renamed from: g  reason: collision with root package name */
    private final Features f33026g;

    /* renamed from: h  reason: collision with root package name */
    private final QuickAccessStateAnalytics f33027h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<Boolean> f33028i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<Boolean> f33029j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<Boolean> f33030k;

    @Inject
    public QuickAccessSettingsViewModel(DriverProvider driverProvider, Features features, QuickAccessStateAnalytics quickAccessStateAnalytics) {
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(features, "features");
        Intrinsics.f(quickAccessStateAnalytics, "quickAccessStateAnalytics");
        this.f33025f = driverProvider;
        this.f33026g = features;
        this.f33027h = quickAccessStateAnalytics;
        this.f33028i = new MutableLiveData<>();
        this.f33029j = new MutableLiveData<>();
        this.f33030k = new MutableLiveData<>();
    }

    public static /* synthetic */ void H(QuickAccessSettingsViewModel quickAccessSettingsViewModel, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z8 = true;
        }
        quickAccessSettingsViewModel.G(z7, z8);
    }

    public static /* synthetic */ void J(QuickAccessSettingsViewModel quickAccessSettingsViewModel, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z8 = true;
        }
        quickAccessSettingsViewModel.I(z7, z8);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f33030k.o(Boolean.TRUE);
        I(this.f33025f.t().E().a(), false);
        G(this.f33025f.t().F().a(), false);
    }

    public final LiveData<Boolean> D() {
        return this.f33029j;
    }

    public final LiveData<Boolean> E() {
        return this.f33028i;
    }

    public final LiveData<Boolean> F() {
        return this.f33030k;
    }

    public final void G(boolean z7, boolean z8) {
        if (z8) {
            if (z7) {
                this.f33027h.Z3();
            } else {
                this.f33027h.v0();
            }
        }
        this.f33025f.t().F().b(z7);
        this.f33029j.o(Boolean.valueOf(z7));
    }

    public final void I(boolean z7, boolean z8) {
        this.f33025f.t().E().b(z7);
        this.f33028i.o(Boolean.valueOf(z7));
        if (!z7) {
            if (z8) {
                this.f33027h.y();
            }
            G(false, z8);
        } else if (z8) {
            this.f33027h.n0();
        }
    }
}
