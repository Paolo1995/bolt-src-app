package eu.bolt.verification.sdk.internal;

import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class qf {

    /* renamed from: a  reason: collision with root package name */
    private final RxPermissions f44652a;

    /* renamed from: b  reason: collision with root package name */
    private final xg f44653b;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<Permission, vf> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f44654f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final vf invoke(Permission it) {
            Intrinsics.f(it, "it");
            return new vf(it.f19729b, true);
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function2<List<vf>, vf, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final b f44655f = new b();

        b() {
            super(2);
        }

        public final void b(List<vf> list, vf permission) {
            Intrinsics.e(permission, "permission");
            list.add(permission);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit s(List<vf> list, vf vfVar) {
            b(list, vfVar);
            return Unit.f50853a;
        }
    }

    @Inject
    public qf(RxPermissions rxPermissions, xg rxSchedulers) {
        Intrinsics.f(rxPermissions, "rxPermissions");
        Intrinsics.f(rxSchedulers, "rxSchedulers");
        this.f44652a = rxPermissions;
        this.f44653b = rxSchedulers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vf c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (vf) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.s(obj, obj2);
    }

    public final Single<Boolean> d(List<? extends je> permissions) {
        Intrinsics.f(permissions, "permissions");
        RxPermissions rxPermissions = this.f44652a;
        int size = permissions.size();
        String[] strArr = new String[size];
        int i8 = 0;
        for (Object obj : permissions) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            strArr[i8] = ((je) obj).c();
            i8 = i9;
        }
        Single<Boolean> K = rxPermissions.o((String[]) Arrays.copyOf(strArr, size)).firstOrError().K(this.f44653b.c());
        Intrinsics.e(K, "rxPermissions\n        .r…ribeOn(rxSchedulers.main)");
        return K;
    }

    public final Single<List<vf>> f(List<? extends je> permissions) {
        Intrinsics.f(permissions, "permissions");
        RxPermissions rxPermissions = this.f44652a;
        int size = permissions.size();
        String[] strArr = new String[size];
        int i8 = 0;
        for (Object obj : permissions) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                CollectionsKt__CollectionsKt.u();
            }
            strArr[i8] = ((je) obj).c();
            i8 = i9;
        }
        Observable<Permission> p8 = rxPermissions.p((String[]) Arrays.copyOf(strArr, size));
        final a aVar = a.f44654f;
        Observable<R> map = p8.map(new Function() { // from class: eu.bolt.verification.sdk.internal.nv
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                vf c8;
                c8 = qf.c(Function1.this, obj2);
                return c8;
            }
        });
        ArrayList arrayList = new ArrayList();
        final b bVar = b.f44655f;
        Single<List<vf>> K = map.collectInto(arrayList, new BiConsumer() { // from class: eu.bolt.verification.sdk.internal.ov
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj2, Object obj3) {
                qf.e(Function2.this, obj2, obj3);
            }
        }).K(this.f44653b.c());
        Intrinsics.e(K, "rxPermissions\n        .r…ribeOn(rxSchedulers.main)");
        return K;
    }
}
