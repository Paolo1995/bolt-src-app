package eu.bolt.verification.sdk.internal;

import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.verification.core.domain.model.VerificationFlowStatus;
import eu.bolt.verification.sdk.internal.d;
import eu.bolt.verification.sdk.internal.qn;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class xn {

    /* renamed from: a  reason: collision with root package name */
    private final f6<Map<a, em>> f45673a;

    /* renamed from: b  reason: collision with root package name */
    private final f6<Deque<vd<qn.b>>> f45674b;

    /* renamed from: c  reason: collision with root package name */
    private final f6<Boolean> f45675c;

    /* renamed from: d  reason: collision with root package name */
    private final f6<Deque<vd<String>>> f45676d;

    /* renamed from: e  reason: collision with root package name */
    private final f6<VerificationFlowStatus> f45677e;

    /* renamed from: f  reason: collision with root package name */
    private final f6<vd<kp>> f45678f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishRelay<Unit> f45679g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishRelay<Unit> f45680h;

    /* renamed from: i  reason: collision with root package name */
    private final PublishRelay<d.C0042d> f45681i;

    /* renamed from: j  reason: collision with root package name */
    private final PublishRelay<d.e> f45682j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45683a;

        /* renamed from: b  reason: collision with root package name */
        private final String f45684b;

        public a(String stepId, String fieldId) {
            Intrinsics.f(stepId, "stepId");
            Intrinsics.f(fieldId, "fieldId");
            this.f45683a = stepId;
            this.f45684b = fieldId;
        }

        public final String a() {
            return this.f45684b;
        }

        public final String b() {
            return this.f45683a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f45683a, aVar.f45683a) && Intrinsics.a(this.f45684b, aVar.f45684b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f45683a.hashCode() * 31) + this.f45684b.hashCode();
        }

        public String toString() {
            String str = this.f45683a;
            String str2 = this.f45684b;
            return "UserInputHolder(stepId=" + str + ", fieldId=" + str2 + ")";
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<Deque<vd<qn.b>>, qn.b> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f45685f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final qn.b invoke(Deque<vd<qn.b>> it) {
            Intrinsics.f(it, "it");
            vd<qn.b> peek = it.peek();
            if (peek != null) {
                return peek.g();
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    static final class c extends Lambda implements Function1<Deque<vd<String>>, String> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f45686f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final String invoke(Deque<vd<String>> it) {
            Intrinsics.f(it, "it");
            vd<String> peek = it.peek();
            if (peek != null) {
                return peek.g();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function1<Map<a, ? extends em>, Map<String, ? extends em>> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f45687f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(1);
            this.f45687f = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Map<String, em> invoke(Map<a, ? extends em> userInput) {
            int b8;
            Intrinsics.f(userInput, "userInput");
            String str = this.f45687f;
            if (str != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<a, ? extends em> entry : userInput.entrySet()) {
                    if (Intrinsics.a(entry.getKey().b(), str)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                userInput = linkedHashMap;
            }
            b8 = MapsKt__MapsJVMKt.b(userInput.size());
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(b8);
            Iterator<T> it = userInput.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it.next();
                linkedHashMap2.put(((a) entry2.getKey()).a(), entry2.getValue());
            }
            return linkedHashMap2;
        }
    }

    public xn(xg rxSchedulers) {
        Map f8;
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        Scheduler d8 = rxSchedulers.d();
        f8 = MapsKt__MapsKt.f();
        this.f45673a = new f6<>(d8, f8);
        this.f45674b = new f6<>(rxSchedulers.d(), new LinkedList());
        this.f45675c = new f6<>(rxSchedulers.d(), Boolean.TRUE);
        this.f45676d = new f6<>(rxSchedulers.d(), new LinkedList());
        this.f45677e = new f6<>(rxSchedulers.d(), VerificationFlowStatus.UNKNOWN);
        this.f45678f = new f6<>(rxSchedulers.d(), vd.b(null));
        PublishRelay<Unit> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f45679g = e8;
        PublishRelay<Unit> e9 = PublishRelay.e();
        Intrinsics.e(e9, "create<Unit>()");
        this.f45680h = e9;
        PublishRelay<d.C0042d> e10 = PublishRelay.e();
        Intrinsics.e(e10, "create<Action.OpenBottomSheet>()");
        this.f45681i = e10;
        PublishRelay<d.e> e11 = PublishRelay.e();
        Intrinsics.e(e11, "create<Action.OpenWebView>()");
        this.f45682j = e11;
    }

    public static /* synthetic */ Observable c(xn xnVar, String str, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        return xnVar.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Map) tmp0.invoke(obj);
    }

    public static /* synthetic */ void j(xn xnVar, String str, em emVar, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        xnVar.k(str, emVar, str2);
    }

    public final Observable<Unit> b() {
        return this.f45680h;
    }

    public final Observable<Map<String, em>> d(String str) {
        Observable<Map<a, em>> c8 = this.f45673a.c();
        final d dVar = new d(str);
        Observable map = c8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.yx
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Map e8;
                e8 = xn.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(map, "withStepId: String? = nu…y.fieldId }\n            }");
        return map;
    }

    public final synchronized void f(VerificationFlowStatus newStatus) {
        Intrinsics.f(newStatus, "newStatus");
        this.f45677e.b(newStatus);
    }

    public final void g(d.C0042d action) {
        Intrinsics.f(action, "action");
        this.f45681i.accept(action);
    }

    public final void h(d.e action) {
        Intrinsics.f(action, "action");
        this.f45682j.accept(action);
        f6<vd<kp>> f6Var = this.f45678f;
        vd<kp> b8 = vd.b(action.b());
        Intrinsics.e(b8, "fromNullable(action.model)");
        f6Var.b(b8);
    }

    public final synchronized void i(qn.b flow) {
        Intrinsics.f(flow, "flow");
        Deque<vd<qn.b>> a8 = this.f45674b.a();
        if (a8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Deque<vd<qn.b>> deque = a8;
        deque.push(vd.c(flow));
        this.f45674b.b(deque);
    }

    public final synchronized void k(String fieldId, em emVar, String str) {
        Map<a, em> u7;
        vd<String> peek;
        Intrinsics.f(fieldId, "fieldId");
        Map<a, em> a8 = this.f45673a.a();
        if (a8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        u7 = MapsKt__MapsKt.u(a8);
        if (str == null) {
            Deque<vd<String>> a9 = this.f45676d.a();
            str = (a9 == null || (peek = a9.peek()) == null) ? null : peek.g();
            if (str == null) {
                throw new IllegalStateException("Steps stack is empty");
            }
        }
        a aVar = new a(str, fieldId);
        if (emVar != null) {
            u7.put(aVar, emVar);
        } else {
            u7.remove(aVar);
        }
        this.f45673a.b(u7);
    }

    public final synchronized void l(boolean z7) {
        this.f45675c.b(Boolean.valueOf(z7));
    }

    public final Observable<d.C0042d> m() {
        return this.f45681i;
    }

    public final synchronized void n(String stepId) {
        Intrinsics.f(stepId, "stepId");
        Deque<vd<String>> a8 = this.f45676d.a();
        if (a8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Deque<vd<String>> deque = a8;
        deque.push(vd.c(stepId));
        this.f45676d.b(deque);
    }

    public final Observable<Unit> o() {
        return this.f45679g;
    }

    public final Observable<qn.b> p() {
        return ug.n(this.f45674b.c(), b.f45685f);
    }

    public final Observable<String> q() {
        return ug.n(this.f45676d.c(), c.f45686f);
    }

    public final Observable<VerificationFlowStatus> r() {
        return this.f45677e.c();
    }

    public final Observable<Boolean> s() {
        return this.f45675c.c();
    }

    public final Observable<d.e> t() {
        return this.f45682j;
    }

    public final Observable<vd<kp>> u() {
        return this.f45678f.c();
    }

    public final synchronized void v() {
        Deque<vd<qn.b>> a8 = this.f45674b.a();
        if (a8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Deque<vd<qn.b>> deque = a8;
        deque.pop();
        this.f45674b.b(deque);
    }

    public final synchronized void w() {
        Deque<vd<String>> a8 = this.f45676d.a();
        if (a8 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Deque<vd<String>> deque = a8;
        deque.pop();
        this.f45676d.b(deque);
    }

    public final void x() {
        this.f45680h.accept(Unit.f50853a);
    }

    public final void y() {
        this.f45679g.accept(Unit.f50853a);
    }
}
