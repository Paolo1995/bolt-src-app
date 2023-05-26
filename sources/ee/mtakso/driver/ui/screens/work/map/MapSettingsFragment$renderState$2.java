package ee.mtakso.driver.ui.screens.work.map;

import android.view.View;
import com.google.android.material.chip.Chip;
import ee.mtakso.driver.ui.interactor.map.MapSettingsCategory;
import ee.mtakso.driver.ui.screens.work.map.MapSettingsFragment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapSettingsFragment.kt */
/* loaded from: classes5.dex */
public final class MapSettingsFragment$renderState$2 extends Lambda implements Function2<MapSettingsFragment.CategoryViewHolder, Integer, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ List<MapSettingsCategory> f34158f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ MapSettingsFragment f34159g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MapSettingsFragment$renderState$2(List<MapSettingsCategory> list, MapSettingsFragment mapSettingsFragment) {
        super(2);
        this.f34158f = list;
        this.f34159g = mapSettingsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MapSettingsFragment this$0, MapSettingsCategory category, View view) {
        MapSettingsViewModel b02;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(category, "$category");
        b02 = this$0.b0();
        b02.N(category.a());
    }

    public final void c(MapSettingsFragment.CategoryViewHolder vh, int i8) {
        Intrinsics.f(vh, "vh");
        final MapSettingsCategory mapSettingsCategory = this.f34158f.get(i8);
        vh.b().setText(mapSettingsCategory.c());
        vh.b().setChecked(mapSettingsCategory.b());
        vh.b().setCheckable(false);
        Chip b8 = vh.b();
        final MapSettingsFragment mapSettingsFragment = this.f34159g;
        b8.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.work.map.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MapSettingsFragment$renderState$2.d(MapSettingsFragment.this, mapSettingsCategory, view);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit s(MapSettingsFragment.CategoryViewHolder categoryViewHolder, Integer num) {
        c(categoryViewHolder, num.intValue());
        return Unit.f50853a;
    }
}
