package ee.mtakso.driver.ui.screens.work;

import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import ee.mtakso.driver.ui.interactor.map.HeatmapStatus;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapSettingsStatusController.kt */
/* loaded from: classes5.dex */
public final class MapSettingsStatusController {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f33650a;

    /* renamed from: b  reason: collision with root package name */
    private final RoundButton f33651b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f33652c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f33653d;

    public MapSettingsStatusController(ViewGroup mapSettingsContainer, RoundButton mapSettingsButton, ImageView mapSettingsButtonBadge, Function0<Unit> onClickListener) {
        Intrinsics.f(mapSettingsContainer, "mapSettingsContainer");
        Intrinsics.f(mapSettingsButton, "mapSettingsButton");
        Intrinsics.f(mapSettingsButtonBadge, "mapSettingsButtonBadge");
        Intrinsics.f(onClickListener, "onClickListener");
        this.f33650a = mapSettingsContainer;
        this.f33651b = mapSettingsButton;
        this.f33652c = mapSettingsButtonBadge;
        this.f33653d = onClickListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MapSettingsStatusController this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        this$0.f33653d.invoke();
    }

    public final void b(HeatmapStatus heatmapStatus) {
        Intrinsics.f(heatmapStatus, "heatmapStatus");
        TransitionManager.beginDelayedTransition(this.f33650a, new AutoTransition().addTarget((View) this.f33652c));
        boolean z7 = true;
        ViewExtKt.e(this.f33651b, !(heatmapStatus instanceof HeatmapStatus.Unavailable), 0, 2, null);
        if (heatmapStatus instanceof HeatmapStatus.Available) {
            ImageView imageView = this.f33652c;
            HeatmapStatus.Available available = (HeatmapStatus.Available) heatmapStatus;
            if (available.d() == null) {
                z7 = false;
            }
            ViewExtKt.e(imageView, z7, 0, 2, null);
            Image d8 = available.d();
            if (d8 != null) {
                ImageKt.a(d8, this.f33652c, null);
            }
        } else {
            ViewExtKt.e(this.f33652c, false, 0, 2, null);
        }
        this.f33651b.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapSettingsStatusController.c(MapSettingsStatusController.this, view);
            }
        });
    }
}
