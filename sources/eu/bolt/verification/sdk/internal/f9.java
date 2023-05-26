package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.em;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f9 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f42973a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f42974a;

        /* renamed from: b  reason: collision with root package name */
        private final h2 f42975b;

        public a(String fieldId, h2 selectedCountry) {
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(selectedCountry, "selectedCountry");
            this.f42974a = fieldId;
            this.f42975b = selectedCountry;
        }

        public final String a() {
            return this.f42974a;
        }

        public final h2 b() {
            return this.f42975b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f42974a, aVar.f42974a) && this.f42975b == aVar.f42975b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f42974a.hashCode() * 31) + this.f42975b.hashCode();
        }

        public String toString() {
            String str = this.f42974a;
            h2 h2Var = this.f42975b;
            return "Args(fieldId=" + str + ", selectedCountry=" + h2Var + ")";
        }
    }

    @Inject
    public f9(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f42973a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(f9 this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        xn.j(this$0.f42973a, args.a(), new em.b(args.b().c()), null, 4, null);
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.os
            @Override // io.reactivex.functions.Action
            public final void run() {
                f9.c(f9.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …y.countryCode))\n        }");
        return u7;
    }
}
