package ee.mtakso.driver.ui.interactor.modaldialog;

import ee.mtakso.driver.network.client.modal.ModalDialogResponse;
import ee.mtakso.driver.service.modules.fifo.FifoQueueManager;
import ee.mtakso.driver.service.modules.fifo.FifoQueueState;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FifoModalInteractor.kt */
/* loaded from: classes3.dex */
public final class FifoModalInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final FifoQueueManager f26659a;

    /* renamed from: b  reason: collision with root package name */
    private final SingleModalDialogInteractor f26660b;

    @Inject
    public FifoModalInteractor(FifoQueueManager fifoQueueManager, SingleModalDialogInteractor modalDialogInteractor) {
        Intrinsics.f(fifoQueueManager, "fifoQueueManager");
        Intrinsics.f(modalDialogInteractor, "modalDialogInteractor");
        this.f26659a = fifoQueueManager;
        this.f26660b = modalDialogInteractor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.s(obj, obj2)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FifoModal j(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (FifoModal) tmp0.invoke(obj);
    }

    public final Observable<FifoModal> f() {
        Observable<FifoQueueState> q8 = this.f26659a.q();
        final FifoModalInteractor$observeFifoModal$1 fifoModalInteractor$observeFifoModal$1 = new Function2<FifoQueueState, FifoQueueState, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor$observeFifoModal$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b */
            public final Boolean s(FifoQueueState old, FifoQueueState fifoQueueState) {
                boolean z7;
                Intrinsics.f(old, "old");
                Intrinsics.f(fifoQueueState, "new");
                if ((old instanceof FifoQueueState.InQueue) && (fifoQueueState instanceof FifoQueueState.InQueue)) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                return Boolean.valueOf(z7);
            }
        };
        Observable<FifoQueueState> distinctUntilChanged = q8.distinctUntilChanged(new BiPredicate() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.a
            @Override // io.reactivex.functions.BiPredicate
            public final boolean test(Object obj, Object obj2) {
                boolean g8;
                g8 = FifoModalInteractor.g(Function2.this, obj, obj2);
                return g8;
            }
        });
        final FifoModalInteractor$observeFifoModal$2 fifoModalInteractor$observeFifoModal$2 = new Function1<FifoQueueState, Boolean>() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor$observeFifoModal$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Boolean invoke(FifoQueueState state) {
                Intrinsics.f(state, "state");
                return Boolean.valueOf(state instanceof FifoQueueState.InQueue);
            }
        };
        Observable<FifoQueueState> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.b
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean h8;
                h8 = FifoModalInteractor.h(Function1.this, obj);
                return h8;
            }
        });
        final Function1<FifoQueueState, SingleSource<? extends Optional<ModalDialogResponse>>> function1 = new Function1<FifoQueueState, SingleSource<? extends Optional<ModalDialogResponse>>>() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor$observeFifoModal$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Optional<ModalDialogResponse>> invoke(FifoQueueState it) {
                SingleModalDialogInteractor singleModalDialogInteractor;
                Intrinsics.f(it, "it");
                singleModalDialogInteractor = FifoModalInteractor.this.f26660b;
                return SingleExtKt.d(singleModalDialogInteractor.a(PromoDialogEvent.DRIVER_IN_WAITING_AREA.c()));
            }
        };
        Observable<R> flatMapSingle = filter.flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource i8;
                i8 = FifoModalInteractor.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(flatMapSingle, "fun observeFifoModal(): …p { FifoModal(it) }\n    }");
        Observable h8 = ObservableExtKt.h(flatMapSingle);
        final FifoModalInteractor$observeFifoModal$4 fifoModalInteractor$observeFifoModal$4 = new Function1<ModalDialogResponse, FifoModal>() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.FifoModalInteractor$observeFifoModal$4
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final FifoModal invoke(ModalDialogResponse it) {
                Intrinsics.f(it, "it");
                return new FifoModal(it);
            }
        };
        Observable<FifoModal> map = h8.map(new Function() { // from class: ee.mtakso.driver.ui.interactor.modaldialog.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                FifoModal j8;
                j8 = FifoModalInteractor.j(Function1.this, obj);
                return j8;
            }
        });
        Intrinsics.e(map, "fun observeFifoModal(): …p { FifoModal(it) }\n    }");
        return map;
    }
}
