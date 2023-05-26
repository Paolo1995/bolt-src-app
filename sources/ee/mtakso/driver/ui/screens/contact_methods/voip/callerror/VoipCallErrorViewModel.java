package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.CallToRiderInteractor;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.OutgoingCallInfo;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOptionsData;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoipCallErrorViewModel.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final VoipCallErrorInteractor f27862f;

    /* renamed from: g  reason: collision with root package name */
    private final CallToRiderInteractor f27863g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<VoipOptionsData> f27864h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<PhoneOptionsData> f27865i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<ContactOptionsData> f27866j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f27867k;

    /* renamed from: l  reason: collision with root package name */
    private Disposable f27868l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f27869m;

    /* renamed from: n  reason: collision with root package name */
    private final BehaviorSubject<VoipCallErrorConfig> f27870n;

    @Inject
    public VoipCallErrorViewModel(VoipCallErrorInteractor interactorCall, CallToRiderInteractor callToRiderInteractor) {
        Intrinsics.f(interactorCall, "interactorCall");
        Intrinsics.f(callToRiderInteractor, "callToRiderInteractor");
        this.f27862f = interactorCall;
        this.f27863g = callToRiderInteractor;
        this.f27864h = new MutableLiveData<>();
        this.f27865i = new MutableLiveData<>();
        this.f27866j = new MutableLiveData<>();
        BehaviorSubject<VoipCallErrorConfig> e8 = BehaviorSubject.e();
        Intrinsics.e(e8, "create<VoipCallErrorConfig>()");
        this.f27870n = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource V(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        BehaviorSubject<VoipCallErrorConfig> behaviorSubject = this.f27870n;
        final Function1<VoipCallErrorConfig, SingleSource<? extends Optional<ContactOptionsData>>> function1 = new Function1<VoipCallErrorConfig, SingleSource<? extends Optional<ContactOptionsData>>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends Optional<ContactOptionsData>> invoke(VoipCallErrorConfig config) {
                VoipCallErrorInteractor voipCallErrorInteractor;
                Intrinsics.f(config, "config");
                voipCallErrorInteractor = VoipCallErrorViewModel.this.f27862f;
                return voipCallErrorInteractor.a(config.a());
            }
        };
        Observable<R> flatMapSingle = behaviorSubject.flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.i
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource V;
                V = VoipCallErrorViewModel.V(Function1.this, obj);
                return V;
            }
        });
        Intrinsics.e(flatMapSingle, "override fun onStart() {…}\n                )\n    }");
        Observable k8 = k(ObservableExtKt.f(flatMapSingle));
        final Function1<Optional<ContactOptionsData>, Unit> function12 = new Function1<Optional<ContactOptionsData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$onStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<ContactOptionsData> optional) {
                MutableLiveData mutableLiveData;
                ContactOptionsData c8 = optional.c();
                if (c8 != null) {
                    mutableLiveData = VoipCallErrorViewModel.this.f27866j;
                    mutableLiveData.o(c8);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<ContactOptionsData> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.W(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function13 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$onStart$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                VoipCallErrorViewModel voipCallErrorViewModel = VoipCallErrorViewModel.this;
                Intrinsics.e(it, "it");
                voipCallErrorViewModel.z(it, "Cannot load available contact options");
            }
        };
        this.f27869m = k8.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.X(Function1.this, obj);
            }
        });
    }

    public final void O(VoipCallErrorConfig config) {
        Intrinsics.f(config, "config");
        this.f27870n.onNext(config);
    }

    public final void P() {
        Single c8 = SingleExtKt.c(this.f27862f.b(((ContactOptionsData) LiveDataExtKt.b(this.f27866j)).d()));
        final Function1<Optional<PhoneOptionsData>, Unit> function1 = new Function1<Optional<PhoneOptionsData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$callByPhone$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<PhoneOptionsData> optional) {
                MutableLiveData mutableLiveData;
                if (!optional.d()) {
                    mutableLiveData = VoipCallErrorViewModel.this.f27865i;
                    mutableLiveData.o(optional.b());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<PhoneOptionsData> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.Q(Function1.this, obj);
            }
        };
        final VoipCallErrorViewModel$callByPhone$2 voipCallErrorViewModel$callByPhone$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$callByPhone$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.o(it).b("Cannot obtain phone info");
            }
        };
        this.f27867k = c8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.R(Function1.this, obj);
            }
        });
    }

    public final LiveData<ContactOptionsData> S() {
        return this.f27866j;
    }

    public final LiveData<PhoneOptionsData> T() {
        return this.f27865i;
    }

    public final LiveData<VoipOptionsData> U() {
        return this.f27864h;
    }

    public final void Y() {
        Single c8 = SingleExtKt.c(this.f27863g.a(((ContactOptionsData) LiveDataExtKt.b(this.f27866j)).d()));
        final Function1<OutgoingCallInfo, Unit> function1 = new Function1<OutgoingCallInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$onTryRedial$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OutgoingCallInfo outgoingCallInfo) {
                MutableLiveData mutableLiveData;
                if (outgoingCallInfo.a() != null) {
                    mutableLiveData = VoipCallErrorViewModel.this.f27864h;
                    mutableLiveData.o(outgoingCallInfo.a());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OutgoingCallInfo outgoingCallInfo) {
                b(outgoingCallInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.Z(Function1.this, obj);
            }
        };
        final VoipCallErrorViewModel$onTryRedial$2 voipCallErrorViewModel$onTryRedial$2 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorViewModel$onTryRedial$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.o(it).b("Cannot obtain voip info");
            }
        };
        this.f27868l = c8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                VoipCallErrorViewModel.a0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27868l;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f27868l = null;
        Disposable disposable2 = this.f27867k;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f27867k = null;
        Disposable disposable3 = this.f27869m;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.f27869m = null;
    }
}
