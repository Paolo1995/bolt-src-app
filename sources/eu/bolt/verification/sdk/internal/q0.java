package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.ha;
import io.reactivex.Observable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public interface q0 extends c4 {

    /* loaded from: classes5.dex */
    public static abstract class a {

        /* renamed from: eu.bolt.verification.sdk.internal.q0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0083a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final ha.a.AbstractC0058a f44588a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0083a(ha.a.AbstractC0058a action) {
                super(null);
                Intrinsics.f(action, "action");
                this.f44588a = action;
            }

            public final ha.a.AbstractC0058a a() {
                return this.f44588a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0083a) && Intrinsics.a(this.f44588a, ((C0083a) obj).f44588a);
            }

            public int hashCode() {
                return this.f44588a.hashCode();
            }

            public String toString() {
                ha.a.AbstractC0058a abstractC0058a = this.f44588a;
                return "ButtonClicks(action=" + abstractC0058a + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    void a(ha haVar);

    Observable<a> h();
}
