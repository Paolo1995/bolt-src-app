package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.sdk.internal.em;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import java.util.Date;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h9 {

    /* renamed from: a  reason: collision with root package name */
    private final xn f43347a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f43348a;

        /* renamed from: b  reason: collision with root package name */
        private final Date f43349b;

        public a(String fieldId, Date date) {
            Intrinsics.f(fieldId, "fieldId");
            this.f43348a = fieldId;
            this.f43349b = date;
        }

        public final Date a() {
            return this.f43349b;
        }

        public final String b() {
            return this.f43348a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f43348a, aVar.f43348a) && Intrinsics.a(this.f43349b, aVar.f43349b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f43348a.hashCode() * 31;
            Date date = this.f43349b;
            return hashCode + (date == null ? 0 : date.hashCode());
        }

        public String toString() {
            String str = this.f43348a;
            Date date = this.f43349b;
            return "Args(fieldId=" + str + ", date=" + date + ")";
        }
    }

    @Inject
    public h9(xn verificationFlowRepository) {
        Intrinsics.f(verificationFlowRepository, "verificationFlowRepository");
        this.f43347a = verificationFlowRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(h9 this$0, a args) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(args, "$args");
        xn xnVar = this$0.f43347a;
        String b8 = args.b();
        Date a8 = args.a();
        xn.j(xnVar, b8, a8 != null ? new em.c(a8.getTime()) : null, null, 4, null);
    }

    public Completable b(final a args) {
        Intrinsics.f(args, "args");
        Completable u7 = Completable.u(new Action() { // from class: eu.bolt.verification.sdk.internal.ws
            @Override // io.reactivex.functions.Action
            public final void run() {
                h9.c(h9.this, args);
            }
        });
        Intrinsics.e(u7, "fromAction {\n           …ate(it.time) })\n        }");
        return u7;
    }
}
