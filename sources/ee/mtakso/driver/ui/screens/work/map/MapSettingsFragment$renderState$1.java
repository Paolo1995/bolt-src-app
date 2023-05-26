package ee.mtakso.driver.ui.screens.work.map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.interactor.map.MapSettingsHeatmap;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsState;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class MapSettingsFragment$renderState$1 extends Lambda implements Function2<MapSettingsFragment.HeatmapViewHolder, Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MapSettingsState f34156f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ MapSettingsFragment f34157g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSettingsFragment$renderState$1(MapSettingsState mapSettingsState, MapSettingsFragment mapSettingsFragment) {
        super(2);
        this.f34156f = mapSettingsState;
        this.f34157g = mapSettingsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MapSettingsFragment this$0, MapSettingsHeatmap heatmap, View view) {
        MapSettingsViewModel b02;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(heatmap, "$heatmap");
        b02 = this$0.b0();
        b02.Q(heatmap.c());
    }

    public final void c(MapSettingsFragment.HeatmapViewHolder vh, int i8) {
        Unit unit;
        Intrinsics.f(vh, "vh");
        final MapSettingsHeatmap mapSettingsHeatmap = ((MapSettingsState.Ready) this.f34156f).c().get(i8);
        ImageView b8 = vh.b();
        final MapSettingsFragment mapSettingsFragment = this.f34157g;
        b8.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.map.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapSettingsFragment$renderState$1.d(MapSettingsFragment.this, mapSettingsHeatmap, view);
            }
        });
        vh.b().setActivated(mapSettingsHeatmap.e());
        Context requireContext = this.f34157g.requireContext();
        Intrinsics.e(requireContext, "requireContext()");
        Drawable drawable = ContextCompat.getDrawable(this.f34157g.requireContext(), ContextUtilsKt.d(requireContext, R.attr.mapPreviewIcon));
        Image d8 = mapSettingsHeatmap.d();
        if (d8 != null) {
            ImageKt.a(d8, vh.c(), drawable);
            unit = Unit.f50853a;
        } else {
            unit = null;
        }
        if (unit == null) {
            vh.c().setImageDrawable(null);
        }
        vh.d().setText(mapSettingsHeatmap.f());
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit s(MapSettingsFragment.HeatmapViewHolder heatmapViewHolder, Integer num) {
        c(heatmapViewHolder, num.intValue());
        return Unit.f50853a;
    }
}
