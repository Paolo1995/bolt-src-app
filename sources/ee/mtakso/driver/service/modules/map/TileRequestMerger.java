package ee.mtakso.driver.service.modules.map;

import android.annotation.SuppressLint;
import ee.mtakso.driver.network.client.tile.TileClient;
import ee.mtakso.driver.network.client.tile.TileVariant;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TileRequestMerger.kt */
/* loaded from: classes3.dex */
public final class TileRequestMerger {

    /* renamed from: a  reason: collision with root package name */
    private final TileClient f24868a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<TileIndex, List<SingleEmitter<TileVariant>>> f24869b;

    @Inject
    public TileRequestMerger(TileClient tileClient) {
        Intrinsics.f(tileClient, "tileClient");
        this.f24868a = tileClient;
        this.f24869b = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(TileIndex tileIndex, Throwable th) {
        synchronized (this.f24869b) {
            List<SingleEmitter<TileVariant>> remove = this.f24869b.remove(tileIndex);
            if (remove == null) {
                return;
            }
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                ((SingleEmitter) it.next()).a(th);
            }
            Unit unit = Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(TileIndex tileIndex, TileVariant tileVariant) {
        synchronized (this.f24869b) {
            List<SingleEmitter<TileVariant>> remove = this.f24869b.remove(tileIndex);
            if (remove == null) {
                return;
            }
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                ((SingleEmitter) it.next()).onSuccess(tileVariant);
            }
            Unit unit = Unit.f50853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TileRequestMerger this$0, TileIndex tileIndex, SingleEmitter emitter) {
        List<SingleEmitter<TileVariant>> q8;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(tileIndex, "$tileIndex");
        Intrinsics.f(emitter, "emitter");
        if (emitter.isDisposed()) {
            return;
        }
        synchronized (this$0.f24869b) {
            List<SingleEmitter<TileVariant>> list = this$0.f24869b.get(tileIndex);
            if (list == null) {
                Map<TileIndex, List<SingleEmitter<TileVariant>>> map = this$0.f24869b;
                q8 = CollectionsKt__CollectionsKt.q(emitter);
                map.put(tileIndex, q8);
                this$0.j(tileIndex);
            } else {
                list.add(emitter);
            }
            Unit unit = Unit.f50853a;
        }
    }

    @SuppressLint({"CheckResult"})
    private final void j(final TileIndex tileIndex) {
        Single<TileVariant> K = this.f24868a.c(tileIndex.b(), TileIndexKt.a(tileIndex), TileIndexKt.b(tileIndex), TileIndexKt.c(tileIndex)).K(Schedulers.c());
        final Function1<TileVariant, Unit> function1 = new Function1<TileVariant, Unit>() { // from class: ee.mtakso.driver.service.modules.map.TileRequestMerger$loadTile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(TileVariant it) {
                TileRequestMerger tileRequestMerger = TileRequestMerger.this;
                TileIndex tileIndex2 = tileIndex;
                Intrinsics.e(it, "it");
                tileRequestMerger.g(tileIndex2, it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TileVariant tileVariant) {
                b(tileVariant);
                return Unit.f50853a;
            }
        };
        Consumer<? super TileVariant> consumer = new Consumer() { // from class: ee.mtakso.driver.service.modules.map.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TileRequestMerger.k(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.modules.map.TileRequestMerger$loadTile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                TileRequestMerger tileRequestMerger = TileRequestMerger.this;
                TileIndex tileIndex2 = tileIndex;
                Intrinsics.e(it, "it");
                tileRequestMerger.f(tileIndex2, it);
            }
        };
        K.I(consumer, new Consumer() { // from class: ee.mtakso.driver.service.modules.map.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TileRequestMerger.l(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final Single<TileVariant> h(final TileIndex tileIndex) {
        Intrinsics.f(tileIndex, "tileIndex");
        Single<TileVariant> f8 = Single.f(new SingleOnSubscribe() { // from class: ee.mtakso.driver.service.modules.map.m
            @Override // io.reactivex.SingleOnSubscribe
            public final void a(SingleEmitter singleEmitter) {
                TileRequestMerger.i(TileRequestMerger.this, tileIndex, singleEmitter);
            }
        });
        Intrinsics.e(f8, "create { emitter ->\n    …}\n            }\n        }");
        return f8;
    }
}
