package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.em;
import eu.bolt.verification.sdk.internal.l9;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes5.dex */
public final class l9 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f44019a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f44020a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44021b;

        public a(String fieldId, String input) {
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(input, "input");
            this.f44020a = fieldId;
            this.f44021b = input;
        }

        public final String a() {
            return this.f44020a;
        }

        public final String b() {
            return this.f44021b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44020a, aVar.f44020a) && Intrinsics.a(this.f44021b, aVar.f44021b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f44020a.hashCode() * 31) + this.f44021b.hashCode();
        }

        public String toString() {
            String str = this.f44020a;
            String str2 = this.f44021b;
            return "Args(fieldId=" + str + ", input=" + str2 + ")";
        }
    }

    @Inject
    public l9(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f44019a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a args, l9 this$0) {
        boolean y7;
        Intrinsics.f(args, "$args");
        Intrinsics.f(this$0, "this$0");
        y7 = StringsKt__StringsJVMKt.y(args.b());
        xn.j(this$0.f44019a, args.a(), y7 ? null : new em.f(args.b()), null, 4, null);
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.ju
            @Override // io.reactivex.functions.Action
            public final void run() {
                l9.c(l9.a.this, this);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           … modifiedValue)\n        }");
        return u7;
    }
}
