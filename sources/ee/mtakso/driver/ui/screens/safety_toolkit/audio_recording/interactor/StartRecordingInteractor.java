package ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.audio_recording.AudioRecordingClient;
import ee.mtakso.driver.service.modules.order.v2.OrderProviderUtils;
import ee.mtakso.driver.service.order.details.ActiveOrderDetails;
import ee.mtakso.driver.service.order.details.OrderDetails;
import ee.mtakso.driver.service.order.details.OrderProvider;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import eu.bolt.driver.core.util.Optional;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StartRecordingInteractor.kt */
/* loaded from: classes3.dex */
public final class StartRecordingInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final OrderProvider f32581a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioRecordingClient f32582b;

    /* renamed from: c  reason: collision with root package name */
    private final AudioRecordingManager f32583c;

    @Inject
    public StartRecordingInteractor(OrderProvider orderProvider, AudioRecordingClient audioRecordingClient, AudioRecordingManager audioRecordingManager) {
        Intrinsics.f(orderProvider, "orderProvider");
        Intrinsics.f(audioRecordingClient, "audioRecordingClient");
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        this.f32581a = orderProvider;
        this.f32582b = audioRecordingClient;
        this.f32583c = audioRecordingManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompletableSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (CompletableSource) tmp0.invoke(obj);
    }

    public final Completable g() {
        Observable<List<OrderDetails>> a8 = this.f32581a.a();
        final StartRecordingInteractor$call$1 startRecordingInteractor$call$1 = new Function1<List<? extends OrderDetails>, Optional<ActiveOrderDetails>>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor$call$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ActiveOrderDetails> invoke(List<? extends OrderDetails> it) {
                Intrinsics.f(it, "it");
                return Optional.f41306b.b(OrderProviderUtils.i(it));
            }
        };
        Observable<R> map = a8.map(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional h8;
                h8 = StartRecordingInteractor.h(Function1.this, obj);
                return h8;
            }
        });
        final StartRecordingInteractor$call$2 startRecordingInteractor$call$2 = new Function1<Optional<ActiveOrderDetails>, Boolean>() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.StartRecordingInteractor$call$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(Optional<ActiveOrderDetails> it) {
                OrderHandle orderHandle;
                boolean z7;
                Intrinsics.f(it, "it");
                ActiveOrderDetails b8 = it.b();
                if (b8 != null) {
                    orderHandle = b8.a();
                } else {
                    orderHandle = null;
                }
                if (orderHandle != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Single firstOrError = map.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean i8;
                i8 = StartRecordingInteractor.i(Function1.this, obj);
                return i8;
            }
        }).firstOrError();
        final StartRecordingInteractor$call$3 startRecordingInteractor$call$3 = new StartRecordingInteractor$call$3(this);
        Single r7 = firstOrError.r(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource j8;
                j8 = StartRecordingInteractor.j(Function1.this, obj);
                return j8;
            }
        });
        final StartRecordingInteractor$call$4 startRecordingInteractor$call$4 = new StartRecordingInteractor$call$4(this);
        Completable s7 = r7.s(new Function() { // from class: ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.interactor.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CompletableSource k8;
                k8 = StartRecordingInteractor.k(Function1.this, obj);
                return k8;
            }
        });
        Intrinsics.e(s7, "fun call(): Completable …    }\n            }\n    }");
        return s7;
    }
}
