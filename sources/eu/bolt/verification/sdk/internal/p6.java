package eu.bolt.verification.sdk.internal;

import eu.bolt.android.rib.BaseViewRibPresenter;
import eu.bolt.verification.sdk.internal.s6;
import io.reactivex.Observable;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface p6 extends BaseViewRibPresenter<b> {

    /* loaded from: classes5.dex */
    public static final class a {
        public static Observable<b> a(p6 p6Var) {
            return BaseViewRibPresenter.DefaultImpls.a(p6Var);
        }
    }

    /* loaded from: classes5.dex */
    public interface b {

        /* loaded from: classes5.dex */
        public static final class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final a f44504a = new a();

            private a() {
            }
        }

        /* renamed from: eu.bolt.verification.sdk.internal.p6$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0082b implements b {

            /* renamed from: a  reason: collision with root package name */
            private final Serializable f44505a;

            public C0082b(Serializable payload) {
                Intrinsics.f(payload, "payload");
                this.f44505a = payload;
            }

            public final Serializable a() {
                return this.f44505a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0082b) && Intrinsics.a(this.f44505a, ((C0082b) obj).f44505a);
            }

            public int hashCode() {
                return this.f44505a.hashCode();
            }

            public String toString() {
                Serializable serializable = this.f44505a;
                return "CustomActionWithPayload(payload=" + serializable + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class c implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final c f44506a = new c();

            private c() {
            }
        }

        /* loaded from: classes5.dex */
        public static final class d implements b {

            /* renamed from: a  reason: collision with root package name */
            private final String f44507a;

            public d(String storyId) {
                Intrinsics.f(storyId, "storyId");
                this.f44507a = storyId;
            }

            public final String a() {
                return this.f44507a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && Intrinsics.a(this.f44507a, ((d) obj).f44507a);
            }

            public int hashCode() {
                return this.f44507a.hashCode();
            }

            public String toString() {
                String str = this.f44507a;
                return "OpenStoryBtnClick(storyId=" + str + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class e implements b {

            /* renamed from: a  reason: collision with root package name */
            private final String f44508a;

            public e(String url) {
                Intrinsics.f(url, "url");
                this.f44508a = url;
            }

            public final String a() {
                return this.f44508a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && Intrinsics.a(this.f44508a, ((e) obj).f44508a);
            }

            public int hashCode() {
                return this.f44508a.hashCode();
            }

            public String toString() {
                String str = this.f44508a;
                return "OpenUrlBtnClick(url=" + str + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class f implements b {

            /* renamed from: a  reason: collision with root package name */
            public static final f f44509a = new f();

            private f() {
            }
        }
    }

    void m(k6 k6Var);

    void n(s6.b bVar);

    void o(k6 k6Var);

    void y(x6 x6Var);
}
