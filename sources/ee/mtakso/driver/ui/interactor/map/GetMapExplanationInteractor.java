package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.network.client.driver.DriverClient;
import ee.mtakso.driver.network.client.driver.DriverMapsConfigsExplanation;
import eu.bolt.driver.core.theme.ThemeManager;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMapExplanationInteractor.kt */
/* loaded from: classes3.dex */
public final class GetMapExplanationInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final DriverClient f26625a;

    /* renamed from: b  reason: collision with root package name */
    private final ThemeManager f26626b;

    @Inject
    public GetMapExplanationInteractor(DriverClient driverClient, ThemeManager themeManager) {
        Intrinsics.f(driverClient, "driverClient");
        Intrinsics.f(themeManager, "themeManager");
        this.f26625a = driverClient;
        this.f26626b = themeManager;
    }

    public final Single<DriverMapsConfigsExplanation> a() {
        return this.f26625a.q(this.f26626b.a());
    }
}
