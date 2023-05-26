package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.service.modules.map.HeatmapSettingManager;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsHeatmapInteractor;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetMapSettingsHeatmapInteractor.kt */
/* loaded from: classes3.dex */
public final class SetMapSettingsHeatmapInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapSettingManager f26654a;

    @Inject
    public SetMapSettingsHeatmapInteractor(HeatmapSettingManager heatmapSettingManager) {
        Intrinsics.f(heatmapSettingManager, "heatmapSettingManager");
        this.f26654a = heatmapSettingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SetMapSettingsHeatmapInteractor this$0, String heatmapId) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(heatmapId, "$heatmapId");
        this$0.f26654a.i(heatmapId);
    }

    public final Completable b(final String heatmapId) {
        Intrinsics.f(heatmapId, "heatmapId");
        Completable u7 = Completable.u(new Action() { // from class: s2.f
            @Override // io.reactivex.functions.Action
            public final void run() {
                SetMapSettingsHeatmapInteractor.c(SetMapSettingsHeatmapInteractor.this, heatmapId);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …apId(heatmapId)\n        }");
        return u7;
    }
}
