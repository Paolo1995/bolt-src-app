package ee.mtakso.driver.service.earnings;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EarningsManager.kt */
/* loaded from: classes3.dex */
public final class EarningsManager$observeEarnings$1 extends Lambda implements Function1<Observable<Object>, ObservableSource<?>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ EarningsManager f24362f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarningsManager$observeEarnings$1(EarningsManager earningsManager) {
        super(1);
        this.f24362f = earningsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource d(EarningsManager this$0, Object it) {
        PublishSubject publishSubject;
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(it, "it");
        publishSubject = this$0.f24361c;
        return publishSubject;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final ObservableSource<?> invoke(Observable<Object> it) {
        Intrinsics.f(it, "it");
        final EarningsManager earningsManager = this.f24362f;
        return it.switchMap(new Function() { // from class: ee.mtakso.driver.service.earnings.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource d8;
                d8 = EarningsManager$observeEarnings$1.d(EarningsManager.this, obj);
                return d8;
            }
        });
    }
}
