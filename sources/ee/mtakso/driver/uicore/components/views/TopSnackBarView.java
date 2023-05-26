package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.snackbar.ContentViewCallback;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopSnackBar.kt */
/* loaded from: classes5.dex */
public final class TopSnackBarView extends FrameLayout implements ContentViewCallback {

    /* renamed from: f  reason: collision with root package name */
    private final Function2<Integer, Integer, Unit> f35490f;

    /* renamed from: g  reason: collision with root package name */
    private final Function2<Integer, Integer, Unit> f35491g;

    /* renamed from: h  reason: collision with root package name */
    public Map<Integer, View> f35492h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopSnackBarView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f35492h = new LinkedHashMap();
        this.f35490f = new Function2<Integer, Integer, Unit>() { // from class: ee.mtakso.driver.uicore.components.views.TopSnackBarView$onAnimateIn$1
            public final void b(int i9, int i10) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Integer num, Integer num2) {
                b(num.intValue(), num2.intValue());
                return Unit.f50853a;
            }
        };
        this.f35491g = new Function2<Integer, Integer, Unit>() { // from class: ee.mtakso.driver.uicore.components.views.TopSnackBarView$onAnimateOut$1
            public final void b(int i9, int i10) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit s(Integer num, Integer num2) {
                b(num.intValue(), num2.intValue());
                return Unit.f50853a;
            }
        };
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void a(int i8, int i9) {
        this.f35490f.s(Integer.valueOf(i8), Integer.valueOf(i9));
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void b(int i8, int i9) {
        this.f35491g.s(Integer.valueOf(i8), Integer.valueOf(i9));
    }

    public final Function2<Integer, Integer, Unit> getOnAnimateIn() {
        return this.f35490f;
    }

    public final Function2<Integer, Integer, Unit> getOnAnimateOut() {
        return this.f35491g;
    }

    public /* synthetic */ TopSnackBarView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
