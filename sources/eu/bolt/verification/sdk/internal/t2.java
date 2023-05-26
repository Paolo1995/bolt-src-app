package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseViewRibPresenter;
import io.reactivex.Observable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes5.dex */
public interface t2 extends BaseViewRibPresenter<b> {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Observable<b> a(t2 t2Var) {
            return BaseViewRibPresenter.DefaultImpls.a(t2Var);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {

        /* loaded from: classes5.dex */
        public static final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f45109a = new a();

            private a() {
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.t2$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0091b implements b {

            /* renamed from: a  reason: collision with root package name */
            private final h2 f45110a;

            public C0091b(h2 country) {
                Intrinsics.f(country, "country");
                this.f45110a = country;
            }

            public final h2 a() {
                return this.f45110a;
            }
        }
    }

    Flow<CharSequence> g();

    void k(List<? extends sb> list);
}
