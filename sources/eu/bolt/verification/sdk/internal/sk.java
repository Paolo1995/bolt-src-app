package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import eu.bolt.verification.sdk.internal.eh;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class sk {

    /* renamed from: a  reason: collision with root package name */
    private final ip f44995a;

    /* renamed from: b  reason: collision with root package name */
    private final eh f44996b;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f44997a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44998b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f44999c;

        public a(String stepId, String flowRunUuid, Uri fileUri) {
            Intrinsics.f(stepId, "stepId");
            Intrinsics.f(flowRunUuid, "flowRunUuid");
            Intrinsics.f(fileUri, "fileUri");
            this.f44997a = stepId;
            this.f44998b = flowRunUuid;
            this.f44999c = fileUri;
        }

        public final Uri a() {
            return this.f44999c;
        }

        public final String b() {
            return this.f44998b;
        }

        public final String c() {
            return this.f44997a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44997a, aVar.f44997a) && Intrinsics.a(this.f44998b, aVar.f44998b) && Intrinsics.a(this.f44999c, aVar.f44999c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f44997a.hashCode() * 31) + this.f44998b.hashCode()) * 31) + this.f44999c.hashCode();
        }

        public String toString() {
            String str = this.f44997a;
            String str2 = this.f44998b;
            Uri uri = this.f44999c;
            return "Args(stepId=" + str + ", flowRunUuid=" + str2 + ", fileUri=" + uri + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<qn.b, CompletableSource> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final CompletableSource invoke(qn.b flow) {
            Intrinsics.f(flow, "flow");
            return sk.this.f44996b.b(new eh.a(flow));
        }
    }

    @Inject
    public sk(ip verificationNetworkRepository, eh setCurrentFlowInteractor) {
        Intrinsics.f(verificationNetworkRepository, "verificationNetworkRepository");
        Intrinsics.f(setCurrentFlowInteractor, "setCurrentFlowInteractor");
        this.f44995a = verificationNetworkRepository;
        this.f44996b = setCurrentFlowInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public Completable c(a args) {
        Intrinsics.f(args, "args");
        Single<qn.b> o8 = this.f44995a.o(args.c(), args.b(), args.a());
        final b bVar = new b();
        Completable s7 = o8.s(new Function() { // from class: eu.bolt.verification.sdk.internal.cw
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource d8;
                d8 = sk.d(Function1.this, obj);
                return d8;
            }
        });
        Intrinsics.e(s7, "override fun execute(arg…gs(flow))\n        }\n    }");
        return s7;
    }
}
