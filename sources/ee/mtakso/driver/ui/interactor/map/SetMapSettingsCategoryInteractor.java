package ee.mtakso.driver.ui.interactor.map;

import ee.mtakso.driver.service.modules.map.HeatmapSettingManager;
import ee.mtakso.driver.ui.interactor.map.SetMapSettingsCategoryInteractor;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetMapSettingsCategoryInteractor.kt */
/* loaded from: classes3.dex */
public final class SetMapSettingsCategoryInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final HeatmapSettingManager f26652a;

    @Inject
    public SetMapSettingsCategoryInteractor(HeatmapSettingManager heatmapSettingManager) {
        Intrinsics.f(heatmapSettingManager, "heatmapSettingManager");
        this.f26652a = heatmapSettingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(SetMapSettingsCategoryInteractor this$0, String heatmapId, String str) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(heatmapId, "$heatmapId");
        this$0.f26652a.h(heatmapId, str);
    }

    public final Completable b(final String heatmapId, final String str) {
        Intrinsics.f(heatmapId, "heatmapId");
        Completable u7 = Completable.u(new Action() { // from class: s2.e
            @Override // io.reactivex.functions.Action
            public final void run() {
                SetMapSettingsCategoryInteractor.c(SetMapSettingsCategoryInteractor.this, heatmapId, str);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …Id, categoryId)\n        }");
        return u7;
    }
}
