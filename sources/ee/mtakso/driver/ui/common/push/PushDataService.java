package ee.mtakso.driver.ui.common.push;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.push.PushMessage;
import ee.mtakso.driver.service.push.PushNotificationManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushDataService.kt */
/* loaded from: classes3.dex */
public final class PushDataService {

    /* renamed from: a  reason: collision with root package name */
    private final PushNotificationManager f26391a;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<PushMessage> f26392b;

    /* renamed from: c  reason: collision with root package name */
    private Disposable f26393c;

    @Inject
    public PushDataService(PushNotificationManager pushNotificationManager) {
        Intrinsics.f(pushNotificationManager, "pushNotificationManager");
        this.f26391a = pushNotificationManager;
        this.f26392b = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final LiveData<PushMessage> d() {
        return this.f26392b;
    }

    public final void e() {
        if (DisposableExtKt.b(this.f26393c)) {
            Observable<PushMessage> observeOn = this.f26391a.i().observeOn(AndroidSchedulers.a());
            final Function1<PushMessage, Unit> function1 = new Function1<PushMessage, Unit>() { // from class: ee.mtakso.driver.ui.common.push.PushDataService$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(PushMessage pushMessage) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PushDataService.this.f26392b;
                    mutableLiveData.o(pushMessage);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PushMessage pushMessage) {
                    b(pushMessage);
                    return Unit.f50853a;
                }
            };
            Consumer<? super PushMessage> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.common.push.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PushDataService.f(Function1.this, obj);
                }
            };
            final PushDataService$start$2 pushDataService$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.common.push.PushDataService$start$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to observe push notifications!");
                }
            };
            this.f26393c = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.common.push.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PushDataService.g(Function1.this, obj);
                }
            });
        }
    }
}
