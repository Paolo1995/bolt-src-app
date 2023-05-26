package ee.mtakso.driver.uikit.widgets.gridlayout;

import androidx.recyclerview.widget.GridLayoutManager;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanSizeProvider.kt */
/* loaded from: classes5.dex */
public final class SpanSizeProvider extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: e  reason: collision with root package name */
    private final int f36243e;

    /* renamed from: f  reason: collision with root package name */
    private final DiffAdapter f36244f;

    public SpanSizeProvider(int i8, DiffAdapter diffAdapter) {
        Intrinsics.f(diffAdapter, "diffAdapter");
        this.f36243e = i8;
        this.f36244f = diffAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public int f(int i8) {
        ListModel R = this.f36244f.R(i8);
        if (R instanceof SpanModel) {
            return ((SpanModel) R).g();
        }
        return this.f36243e;
    }
}
