package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class yl {

    /* renamed from: a  reason: collision with root package name */
    private final xn f45769a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final qn.b f45770a;

        public a(qn.b flow) {
            Intrinsics.f(flow, "flow");
            this.f45770a = flow;
        }

        public final qn.b a() {
            return this.f45770a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.a(this.f45770a, ((a) obj).f45770a);
        }

        public int hashCode() {
            return this.f45770a.hashCode();
        }

        public String toString() {
            qn.b bVar = this.f45770a;
            return "Args(flow=" + bVar + ")";
        }
    }

    @Inject
    public yl(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f45769a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(yl this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        this$0.f45769a.v();
        this$0.f45769a.i(args.a());
        this$0.f45769a.n(args.a().b());
        this$0.f45769a.f(args.a().e());
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.hy
            @Override // io.reactivex.functions.Action
            public final void run() {
                yl.c(yl.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …gs.flow.status)\n        }");
        return u7;
    }
}
