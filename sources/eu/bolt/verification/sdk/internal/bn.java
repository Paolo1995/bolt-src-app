package eu.bolt.verification.sdk.internal;

import android.graphics.Rect;
import eu.bolt.android.rib.BaseViewRibPresenter;
import eu.bolt.verification.sdk.internal.k7;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface bn extends BaseViewRibPresenter<b>, kf {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Flow<b> a(bn bnVar) {
            return BaseViewRibPresenter.DefaultImpls.b(bnVar);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* loaded from: classes5.dex */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f42376a = new a();

            private a() {
                super(null);
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.bn$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0038b extends b {

            /* renamed from: a  reason: collision with root package name */
            private final int f42377a;

            /* renamed from: b  reason: collision with root package name */
            private final int f42378b;

            /* renamed from: c  reason: collision with root package name */
            private final Rect f42379c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0038b(int i8, int i9, Rect cutoffRect) {
                super(null);
                Intrinsics.f(cutoffRect, "cutoffRect");
                this.f42377a = i8;
                this.f42378b = i9;
                this.f42379c = cutoffRect;
            }

            public final Rect a() {
                return this.f42379c;
            }

            public final int b() {
                return this.f42378b;
            }

            public final int c() {
                return this.f42377a;
            }
        }

        /* loaded from: classes5.dex */
        public static final class c extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f42380a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void c(String str);

    void f(boolean z7);

    void i(String str);

    void j(p9 p9Var);

    void l(l1 l1Var, wl wlVar);

    void t(k7.a aVar);

    void x(ff ffVar);
}
