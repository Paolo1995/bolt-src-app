package ee.mtakso.driver.utils.bottomsheet;

import android.view.View;
import ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheetAnimationRequest.kt */
/* loaded from: classes5.dex */
public final class BottomSheetAnimationRequest<T extends View> {

    /* renamed from: a  reason: collision with root package name */
    private final ControllableBottomSheetBehavior<T> f36341a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36342b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36343c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f36344d;

    /* renamed from: e  reason: collision with root package name */
    private final BottomSheetAnimationRequest$callback$1 f36345e;

    /* JADX WARN: Type inference failed for: r2v2, types: [ee.mtakso.driver.utils.bottomsheet.BottomSheetAnimationRequest$callback$1] */
    public BottomSheetAnimationRequest(ControllableBottomSheetBehavior<T> bottomSheetBehavior, int i8) {
        Intrinsics.f(bottomSheetBehavior, "bottomSheetBehavior");
        this.f36341a = bottomSheetBehavior;
        this.f36342b = i8;
        this.f36344d = bottomSheetBehavior.f0();
        this.f36345e = new ComponentBottomSheetBehavior.BottomSheetCallback(this) { // from class: ee.mtakso.driver.utils.bottomsheet.BottomSheetAnimationRequest$callback$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BottomSheetAnimationRequest<T> f36346a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f36346a = this;
            }

            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void a(View p02, float f8) {
                Intrinsics.f(p02, "p0");
            }

            @Override // ee.mtakso.driver.utils.bottomsheet.ComponentBottomSheetBehavior.BottomSheetCallback
            public void b(View p02, int i9) {
                Intrinsics.f(p02, "p0");
                this.f36346a.d(i9);
            }
        };
    }

    private final void b() {
        this.f36341a.g0(this.f36345e);
        this.f36341a.h0(this.f36344d);
        this.f36343c = false;
    }

    public final void a() {
        b();
    }

    public final boolean c() {
        return this.f36343c;
    }

    public final void d(int i8) {
        if (i8 == 5) {
            this.f36341a.f36358l = this.f36342b;
        } else if (i8 == this.f36342b) {
            b();
        }
    }

    public final void e() {
        this.f36343c = true;
        this.f36341a.h0(false);
        this.f36341a.d0(this.f36345e);
        this.f36341a.f36358l = 5;
    }
}
