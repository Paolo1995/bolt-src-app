package ee.mtakso.driver.ui.common.internet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.service.connectivity.NetworkConnectionStatus;
import ee.mtakso.driver.service.connectivity.NetworkService;
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

/* compiled from: InternetDataDelegate.kt */
/* loaded from: classes3.dex */
public final class InternetDataDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkService f26365a;

    /* renamed from: b  reason: collision with root package name */
    private final MutableLiveData<NetworkConnectionStatus> f26366b;

    /* renamed from: c  reason: collision with root package name */
    private Disposable f26367c;

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<NetworkConnectionStatus> f26368d;

    @Inject
    public InternetDataDelegate(NetworkService networkService) {
        Intrinsics.f(networkService, "networkService");
        this.f26365a = networkService;
        MutableLiveData<NetworkConnectionStatus> mutableLiveData = new MutableLiveData<>();
        this.f26366b = mutableLiveData;
        this.f26368d = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void d() {
        Disposable disposable = this.f26367c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public LiveData<NetworkConnectionStatus> e() {
        return this.f26368d;
    }

    public final void f() {
        if (DisposableExtKt.b(this.f26367c)) {
            Observable<NetworkConnectionStatus> observeOn = this.f26365a.d().observeOn(AndroidSchedulers.a());
            final Function1<NetworkConnectionStatus, Unit> function1 = new Function1<NetworkConnectionStatus, Unit>() { // from class: ee.mtakso.driver.ui.common.internet.InternetDataDelegate$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public final void b(NetworkConnectionStatus networkConnectionStatus) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = InternetDataDelegate.this.f26366b;
                    mutableLiveData.o(networkConnectionStatus);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(NetworkConnectionStatus networkConnectionStatus) {
                    b(networkConnectionStatus);
                    return Unit.f50853a;
                }
            };
            Consumer<? super NetworkConnectionStatus> consumer = new Consumer() { // from class: ee.mtakso.driver.ui.common.internet.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    InternetDataDelegate.g(Function1.this, obj);
                }
            };
            final InternetDataDelegate$start$2 internetDataDelegate$start$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.common.internet.InternetDataDelegate$start$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.f50853a;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Failed to observe internet status!");
                }
            };
            this.f26367c = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.common.internet.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    InternetDataDelegate.h(Function1.this, obj);
                }
            });
        }
    }
}
