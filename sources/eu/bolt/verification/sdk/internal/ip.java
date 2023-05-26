package eu.bolt.verification.sdk.internal;

import android.net.Uri;
import androidx.core.net.UriKt;
import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.b7;
import eu.bolt.verification.sdk.internal.io;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.MultipartBody;

/* loaded from: classes5.dex */
public final class ip {

    /* renamed from: a  reason: collision with root package name */
    private final kn f43582a;

    /* renamed from: b  reason: collision with root package name */
    private final f0 f43583b;

    /* renamed from: c  reason: collision with root package name */
    private final vn f43584c;

    /* renamed from: d  reason: collision with root package name */
    private final oq f43585d;

    /* renamed from: e  reason: collision with root package name */
    private final on f43586e;

    /* renamed from: f  reason: collision with root package name */
    private final xg f43587f;

    /* renamed from: g  reason: collision with root package name */
    private final fe f43588g;

    /* renamed from: h  reason: collision with root package name */
    private final dl f43589h;

    /* renamed from: i  reason: collision with root package name */
    private final fo f43590i;

    /* renamed from: j  reason: collision with root package name */
    private final Lazy f43591j;

    /* renamed from: k  reason: collision with root package name */
    private final Lazy f43592k;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function0<im> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final im invoke() {
            return (im) ip.this.f43583b.a(im.class);
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<jo, qn> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43595g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f43595g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn invoke(jo it) {
            Intrinsics.f(it, "it");
            return ip.this.f43584c.a(this.f43595g, it);
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<ko, qn> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43597g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.f43597g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn invoke(ko it) {
            Intrinsics.f(it, "it");
            return ip.this.f43584c.a(this.f43597g, it.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class d extends Lambda implements Function0<np> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final np invoke() {
            return (np) ip.this.f43583b.a(np.class);
        }
    }

    /* loaded from: classes5.dex */
    static final class e extends Lambda implements Function1<nq, qn.b> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43600g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(1);
            this.f43600g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn.b invoke(nq it) {
            Intrinsics.f(it, "it");
            return ip.this.f43585d.a(this.f43600g, it);
        }
    }

    /* loaded from: classes5.dex */
    static final class f extends Lambda implements Function1<qq, qn.b> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43602g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(1);
            this.f43602g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn.b invoke(qq it) {
            Intrinsics.f(it, "it");
            return ip.this.f43585d.a(this.f43602g, it.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class g extends Lambda implements Function1<rk, VerificationFlowStatus> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final VerificationFlowStatus invoke(rk it) {
            Intrinsics.f(it, "it");
            return ip.this.f43590i.a(it.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class h extends Lambda implements Function1<rk, VerificationFlowStatus> {
        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final VerificationFlowStatus invoke(rk it) {
            Intrinsics.f(it, "it");
            return ip.this.f43590i.a(it.a());
        }
    }

    /* loaded from: classes5.dex */
    static final class i extends Lambda implements Function1<lq, String> {

        /* renamed from: f  reason: collision with root package name */
        public static final i f43605f = new i();

        i() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(lq it) {
            Intrinsics.f(it, "it");
            return it.a();
        }
    }

    /* loaded from: classes5.dex */
    static final class j extends Lambda implements Function1<mq, String> {

        /* renamed from: f  reason: collision with root package name */
        public static final j f43606f = new j();

        j() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(mq it) {
            Intrinsics.f(it, "it");
            return it.a().a();
        }
    }

    /* loaded from: classes5.dex */
    static final class k extends Lambda implements Function1<nq, qn.b> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43608g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(1);
            this.f43608g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn.b invoke(nq it) {
            Intrinsics.f(it, "it");
            return ip.this.f43585d.a(this.f43608g, it);
        }
    }

    /* loaded from: classes5.dex */
    static final class l extends Lambda implements Function1<qq, qn.b> {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43610g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(String str) {
            super(1);
            this.f43610g = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn.b invoke(qq it) {
            Intrinsics.f(it, "it");
            return ip.this.f43585d.a(this.f43610g, it.a());
        }
    }

    @Inject
    public ip(kn clientType, f0 apiCreator, vn flowDetailsMapper, oq uploadFileResponseMapper, on fileToMultiPartMapper, xg rxSchedulers, fe partCreator, dl targetingManager, fo statusMapper) {
        Lazy b8;
        Lazy b9;
        Intrinsics.f(clientType, "clientType");
        Intrinsics.f(apiCreator, "apiCreator");
        Intrinsics.f(flowDetailsMapper, "flowDetailsMapper");
        Intrinsics.f(uploadFileResponseMapper, "uploadFileResponseMapper");
        Intrinsics.f(fileToMultiPartMapper, "fileToMultiPartMapper");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Intrinsics.f(partCreator, "partCreator");
        Intrinsics.f(targetingManager, "targetingManager");
        Intrinsics.f(statusMapper, "statusMapper");
        this.f43582a = clientType;
        this.f43583b = apiCreator;
        this.f43584c = flowDetailsMapper;
        this.f43585d = uploadFileResponseMapper;
        this.f43586e = fileToMultiPartMapper;
        this.f43587f = rxSchedulers;
        this.f43588g = partCreator;
        this.f43589h = targetingManager;
        this.f43590i = statusMapper;
        b8 = LazyKt__LazyJVMKt.b(new a());
        this.f43591j = b8;
        b9 = LazyKt__LazyJVMKt.b(new d());
        this.f43592k = b9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn.b A(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn.b) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerificationFlowStatus B(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VerificationFlowStatus) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerificationFlowStatus C(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (VerificationFlowStatus) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String D(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String E(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn.b F(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn.b) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn.b G(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn.b) tmp0.invoke(obj);
    }

    private final im l() {
        return (im) this.f43591j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn) tmp0.invoke(obj);
    }

    private final np s() {
        return (np) this.f43592k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qn.b x(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (qn.b) tmp0.invoke(obj);
    }

    private final boolean y() {
        return ((Boolean) this.f43589h.a(b7.a.b.f42288b)).booleanValue();
    }

    public final Completable n(String event) {
        Completable g8;
        String str;
        Intrinsics.f(event, "event");
        if (y()) {
            g8 = (this.f43582a == kn.RIDER ? s().c(new lp(event)) : l().c(new lp(event))).v().I(this.f43587f.b());
            str = "{\n            if (client…)\n            }\n        }";
        } else {
            g8 = Completable.g();
            str = "{\n            Completable.complete()\n        }";
        }
        Intrinsics.e(g8, str);
        return g8;
    }

    public final Single<qn.b> o(String stepId, String flowRunUuid, Uri fileUri) {
        Single<qn.b> w7;
        String str;
        Single d8;
        Function function;
        Intrinsics.f(stepId, "stepId");
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(fileUri, "fileUri");
        if (y()) {
            File a8 = UriKt.a(fileUri);
            MultipartBody.Part a9 = this.f43588g.a("step_id", stepId);
            Intrinsics.e(a9, "partCreator.createPart(\"step_id\", stepId)");
            MultipartBody.Part a10 = this.f43588g.a("flow_run_uuid", flowRunUuid);
            Intrinsics.e(a10, "partCreator.createPart(\"…w_run_uuid\", flowRunUuid)");
            if (this.f43582a == kn.RIDER) {
                np s7 = s();
                MultipartBody.Part b8 = this.f43586e.b(a8);
                Intrinsics.e(b8, "fileToMultiPartMapper.map(file)");
                d8 = s7.d(a9, a10, b8);
                final k kVar = new k(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.mt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn.b F;
                        F = ip.F(Function1.this, obj);
                        return F;
                    }
                };
            } else {
                im l8 = l();
                MultipartBody.Part b9 = this.f43586e.b(a8);
                Intrinsics.e(b9, "fileToMultiPartMapper.map(file)");
                d8 = l8.d(a9, a10, b9);
                final l lVar = new l(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.nt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn.b G;
                        G = ip.G(Function1.this, obj);
                        return G;
                    }
                };
            }
            w7 = d8.x(function).K(this.f43587f.b());
            str = "fun uploadFile(\n        ….regularFlow())\n        }";
        } else {
            w7 = Single.w(wo.f45578a.a());
            str = "{\n            Single.jus….regularFlow())\n        }";
        }
        Intrinsics.e(w7, str);
        return w7;
    }

    public final Single<qn.b> p(String flowRunUuid, String path, Map<String, String> params) {
        Single<qn.b> w7;
        String str;
        Single b8;
        Function function;
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(path, "path");
        Intrinsics.f(params, "params");
        if (y()) {
            if (this.f43582a == kn.RIDER) {
                b8 = s().b(path, params);
                final e eVar = new e(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.ot
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn.b x7;
                        x7 = ip.x(Function1.this, obj);
                        return x7;
                    }
                };
            } else {
                b8 = l().b(path, params);
                final f fVar = new f(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.pt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn.b A;
                        A = ip.A(Function1.this, obj);
                        return A;
                    }
                };
            }
            w7 = b8.x(function).K(this.f43587f.b());
            str = "fun sendPostRequest(\n   ….regularFlow())\n        }";
        } else {
            w7 = Single.w(wo.f45578a.a());
            str = "{\n            Single.jus….regularFlow())\n        }";
        }
        Intrinsics.e(w7, str);
        return w7;
    }

    public final Single<VerificationFlowStatus> q(String flowRunUuid, List<io.a> userInputs, String stepId) {
        Single<VerificationFlowStatus> w7;
        String str;
        Single<rk> a8;
        Function function;
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        Intrinsics.f(userInputs, "userInputs");
        Intrinsics.f(stepId, "stepId");
        if (y()) {
            if (this.f43582a == kn.RIDER) {
                a8 = s().a(new bq(flowRunUuid, userInputs, stepId));
                final g gVar = new g();
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.ft
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        VerificationFlowStatus B;
                        B = ip.B(Function1.this, obj);
                        return B;
                    }
                };
            } else {
                a8 = l().a(new bq(flowRunUuid, userInputs, stepId));
                final h hVar = new h();
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.gt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        VerificationFlowStatus C;
                        C = ip.C(Function1.this, obj);
                        return C;
                    }
                };
            }
            w7 = a8.x(function).K(this.f43587f.b());
            str = "fun submitUserData(\n    …us.IN_PROGRESS)\n        }";
        } else {
            w7 = Single.w(VerificationFlowStatus.IN_PROGRESS);
            str = "{\n            Single.jus…us.IN_PROGRESS)\n        }";
        }
        Intrinsics.e(w7, str);
        return w7;
    }

    public final Single<qn> r(String flowRunUuid, List<io.a> list, boolean z7) {
        Single<qn> w7;
        String str;
        Single f8;
        Function function;
        Intrinsics.f(flowRunUuid, "flowRunUuid");
        if (y()) {
            if (this.f43582a == kn.RIDER) {
                f8 = s().f(new io(flowRunUuid, list, z7));
                final b bVar = new b(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.kt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn m8;
                        m8 = ip.m(Function1.this, obj);
                        return m8;
                    }
                };
            } else {
                f8 = l().f(new io(flowRunUuid, list, z7));
                final c cVar = new c(flowRunUuid);
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.lt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        qn t7;
                        t7 = ip.t(Function1.this, obj);
                        return t7;
                    }
                };
            }
            w7 = f8.x(function).K(this.f43587f.b());
            str = "fun getFlowDetails(\n    ….regularFlow())\n        }";
        } else {
            w7 = Single.w(wo.f45578a.a());
            str = "{\n            Single.jus….regularFlow())\n        }";
        }
        Intrinsics.e(w7, str);
        return w7;
    }

    public final Single<String> v(String flowUuid) {
        Single<String> w7;
        String str;
        Single e8;
        Function function;
        Intrinsics.f(flowUuid, "flowUuid");
        if (y()) {
            if (this.f43582a == kn.RIDER) {
                e8 = s().e(new kq(flowUuid));
                final i iVar = i.f43605f;
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.ht
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        String D;
                        D = ip.D(Function1.this, obj);
                        return D;
                    }
                };
            } else {
                e8 = l().e(new kq(flowUuid));
                final j jVar = j.f43606f;
                function = new Function() { // from class: eu.bolt.verification.sdk.internal.jt
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        String E;
                        E = ip.E(Function1.this, obj);
                        return E;
                    }
                };
            }
            w7 = e8.x(function).K(this.f43587f.b());
            str = "{\n            if (client…)\n            }\n        }";
        } else {
            w7 = Single.w(wo.f45578a.b());
            str = "{\n            Single.jus….triggerFlow())\n        }";
        }
        Intrinsics.e(w7, str);
        return w7;
    }
}
