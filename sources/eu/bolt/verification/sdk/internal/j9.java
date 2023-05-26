package eu.bolt.verification.sdk.internal;

import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j9 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f43673a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f43674a;

        /* renamed from: b  reason: collision with root package name */
        private final em f43675b;

        public a(String fieldId, em input) {
            Intrinsics.f(fieldId, "fieldId");
            Intrinsics.f(input, "input");
            this.f43674a = fieldId;
            this.f43675b = input;
        }

        public final String a() {
            return this.f43674a;
        }

        public final em b() {
            return this.f43675b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f43674a, aVar.f43674a) && Intrinsics.a(this.f43675b, aVar.f43675b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f43674a.hashCode() * 31) + this.f43675b.hashCode();
        }

        public String toString() {
            String str = this.f43674a;
            em emVar = this.f43675b;
            return "Args(fieldId=" + str + ", input=" + emVar + ")";
        }
    }

    @Inject
    public j9(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f43673a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(j9 this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        xn.j(this$0.f43673a, args.a(), args.b(), null, 4, null);
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.vt
            @Override // io.reactivex.functions.Action
            public final void run() {
                j9.c(j9.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …Id, args.input)\n        }");
        return u7;
    }
}
