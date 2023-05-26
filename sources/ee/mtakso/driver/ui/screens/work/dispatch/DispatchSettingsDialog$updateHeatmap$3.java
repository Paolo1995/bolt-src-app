package ee.mtakso.driver.ui.screens.work.dispatch;

import android.view.View;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchHeatmapSettings;
import ee.mtakso.driver.ui.screens.work.dispatch.DispatchSettingsDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DispatchSettingsDialog.kt */
/* loaded from: classes5.dex */
public final class DispatchSettingsDialog$updateHeatmap$3 extends Lambda implements Function2<DispatchSettingsDialog.ChipViewHolder, Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DispatchSettingsState f33995f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ DispatchSettingsDialog f33996g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DispatchSettingsDialog$updateHeatmap$3(DispatchSettingsState dispatchSettingsState, DispatchSettingsDialog dispatchSettingsDialog) {
        super(2);
        this.f33995f = dispatchSettingsState;
        this.f33996g = dispatchSettingsDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DispatchSettingsDialog this$0, DispatchHeatmapSettings.Item heatmapSettingItem, View view) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(heatmapSettingItem, "$heatmapSettingItem");
        this$0.P().f0(heatmapSettingItem.a());
    }

    public final void c(DispatchSettingsDialog.ChipViewHolder vh, int i8) {
        Intrinsics.f(vh, "vh");
        final DispatchHeatmapSettings.Item item = this.f33995f.d().b().get(i8);
        vh.b().setText(item.c());
        vh.b().setChecked(item.b());
        Chip b8 = vh.b();
        final DispatchSettingsDialog dispatchSettingsDialog = this.f33996g;
        b8.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.dispatch.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DispatchSettingsDialog$updateHeatmap$3.d(DispatchSettingsDialog.this, item, view);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit s(DispatchSettingsDialog.ChipViewHolder chipViewHolder, Integer num) {
        c(chipViewHolder, num.intValue());
        return Unit.f50853a;
    }
}
