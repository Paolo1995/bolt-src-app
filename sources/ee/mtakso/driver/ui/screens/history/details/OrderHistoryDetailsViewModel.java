package ee.mtakso.driver.ui.screens.history.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.OrderState;
import ee.mtakso.driver.network.client.audio_recording.WebAppLaunchParams;
import ee.mtakso.driver.network.client.audio_recording.support.TripAudioSupportClient;
import ee.mtakso.driver.network.client.audio_recording.upload.UploadAudioRecordingManager;
import ee.mtakso.driver.network.client.contact.AvailableContactOptions;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactOption;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import ee.mtakso.driver.network.client.order.PreviousOrderDetails;
import ee.mtakso.driver.network.client.order.RideHistoryClient;
import ee.mtakso.driver.network.client.order.TripAudioRecordingData;
import ee.mtakso.driver.network.client.support.SupportClient;
import ee.mtakso.driver.network.client.support.SupportWebAppLinkResponse;
import ee.mtakso.driver.param.DriverProvider;
import ee.mtakso.driver.service.analytics.event.facade.AudioRecordingAnalytics;
import ee.mtakso.driver.service.analytics.event.facade.HistoryAnalytics;
import ee.mtakso.driver.service.time.TrueTimeProvider;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.screens.history.details.banner.InfoBannerState;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.helper.AudioRecordingMapper;
import ee.mtakso.driver.ui.screens.safety_toolkit.audio_recording.repository.AudioRecordingManager;
import ee.mtakso.driver.utils.DisposableExtKt;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.android.audio_recording_engine.engine.RecordingProperties;
import eu.bolt.android.audio_recording_engine.engine.UploadParams;
import eu.bolt.driver.core.util.DateTimeFormatter;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: OrderHistoryDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class OrderHistoryDetailsViewModel extends BaseViewModel {
    private Disposable A;
    private Disposable B;
    private Disposable C;
    private final MutableLiveData<Boolean> D;
    private final MutableLiveData<RecordingProperties> E;
    private final MutableLiveData<List<UploadParams>> F;
    private final LiveEvent<Result<WebAppLaunchParams>> G;

    /* renamed from: f  reason: collision with root package name */
    private final AudioRecordingManager f29461f;

    /* renamed from: g  reason: collision with root package name */
    private final AudioRecordingMapper f29462g;

    /* renamed from: h  reason: collision with root package name */
    private final DateTimeFormatter f29463h;

    /* renamed from: i  reason: collision with root package name */
    private final DriverProvider f29464i;

    /* renamed from: j  reason: collision with root package name */
    private final HistoryAnalytics f29465j;

    /* renamed from: k  reason: collision with root package name */
    private final ContactClient f29466k;

    /* renamed from: l  reason: collision with root package name */
    private final RideHistoryClient f29467l;

    /* renamed from: m  reason: collision with root package name */
    private final SupportClient f29468m;

    /* renamed from: n  reason: collision with root package name */
    private final TrueTimeProvider f29469n;

    /* renamed from: o  reason: collision with root package name */
    private final TripAudioSupportClient f29470o;

    /* renamed from: p  reason: collision with root package name */
    private final UploadAudioRecordingManager f29471p;

    /* renamed from: q  reason: collision with root package name */
    private final AudioRecordingAnalytics f29472q;

    /* renamed from: r  reason: collision with root package name */
    private Job f29473r;

    /* renamed from: s  reason: collision with root package name */
    private final MutableLiveData<OrderHistoryDetails> f29474s;

    /* renamed from: t  reason: collision with root package name */
    private final MutableLiveData<List<ContactOption>> f29475t;

    /* renamed from: u  reason: collision with root package name */
    private final LiveEvent<String> f29476u;

    /* renamed from: v  reason: collision with root package name */
    private final MutableLiveData<InfoBannerState> f29477v;

    /* renamed from: w  reason: collision with root package name */
    private final LiveEvent<String> f29478w;

    /* renamed from: x  reason: collision with root package name */
    private final LiveEvent<Unit> f29479x;

    /* renamed from: y  reason: collision with root package name */
    private final LiveEvent<Unit> f29480y;

    /* renamed from: z  reason: collision with root package name */
    private OrderHandle f29481z;

    @Inject
    public OrderHistoryDetailsViewModel(AudioRecordingManager audioRecordingManager, AudioRecordingMapper audioRecordingMapper, DateTimeFormatter dateTimeFormatter, DriverProvider driverProvider, HistoryAnalytics historyAnalytics, ContactClient contactClient, RideHistoryClient rideHistoryClient, SupportClient supportClient, TrueTimeProvider trueTimeProvider, TripAudioSupportClient tripAudioSupportClient, UploadAudioRecordingManager uploadAudioRecordingManager, AudioRecordingAnalytics audioRecordingAnalytics) {
        Intrinsics.f(audioRecordingManager, "audioRecordingManager");
        Intrinsics.f(audioRecordingMapper, "audioRecordingMapper");
        Intrinsics.f(dateTimeFormatter, "dateTimeFormatter");
        Intrinsics.f(driverProvider, "driverProvider");
        Intrinsics.f(historyAnalytics, "historyAnalytics");
        Intrinsics.f(contactClient, "contactClient");
        Intrinsics.f(rideHistoryClient, "rideHistoryClient");
        Intrinsics.f(supportClient, "supportClient");
        Intrinsics.f(trueTimeProvider, "trueTimeProvider");
        Intrinsics.f(tripAudioSupportClient, "tripAudioSupportClient");
        Intrinsics.f(uploadAudioRecordingManager, "uploadAudioRecordingManager");
        Intrinsics.f(audioRecordingAnalytics, "audioRecordingAnalytics");
        this.f29461f = audioRecordingManager;
        this.f29462g = audioRecordingMapper;
        this.f29463h = dateTimeFormatter;
        this.f29464i = driverProvider;
        this.f29465j = historyAnalytics;
        this.f29466k = contactClient;
        this.f29467l = rideHistoryClient;
        this.f29468m = supportClient;
        this.f29469n = trueTimeProvider;
        this.f29470o = tripAudioSupportClient;
        this.f29471p = uploadAudioRecordingManager;
        this.f29472q = audioRecordingAnalytics;
        this.f29474s = new MutableLiveData<>();
        this.f29475t = new MutableLiveData<>();
        this.f29476u = new LiveEvent<>();
        this.f29477v = new MutableLiveData<>();
        this.f29478w = new LiveEvent<>();
        this.f29479x = new LiveEvent<>();
        this.f29480y = new LiveEvent<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.G = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String L0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i0(long j8) {
        return this.f29463h.a(j8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k0(RecordingProperties recordingProperties) {
        if (recordingProperties == null) {
            return true;
        }
        if (TimeUnit.MILLISECONDS.toHours(this.f29469n.b() - recordingProperties.a()) >= 24) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        OrderHandle orderHandle = this.f29481z;
        if (orderHandle == null) {
            return;
        }
        Disposable disposable = this.B;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single<AvailableContactOptions> f8 = this.f29466k.f(ContactOptionsUseCase.HISTORY, orderHandle);
        final OrderHistoryDetailsViewModel$loadContacts$1 orderHistoryDetailsViewModel$loadContacts$1 = new Function1<AvailableContactOptions, List<? extends ContactOption>>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadContacts$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ContactOption> invoke(AvailableContactOptions it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<R> x7 = f8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.history.details.r
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List p02;
                p02 = OrderHistoryDetailsViewModel.p0(Function1.this, obj);
                return p02;
            }
        });
        Intrinsics.e(x7, "contactClient\n          …map { it.contactOptions }");
        Single d8 = SingleExtKt.d(x7);
        final Function1<List<? extends ContactOption>, Unit> function1 = new Function1<List<? extends ContactOption>, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadContacts$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends ContactOption> list) {
                MutableLiveData mutableLiveData;
                mutableLiveData = OrderHistoryDetailsViewModel.this.f29475t;
                mutableLiveData.o(list);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ContactOption> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.q0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadContacts$3
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
                OrderHistoryDetailsViewModel orderHistoryDetailsViewModel = OrderHistoryDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderHistoryDetailsViewModel, it, null, 2, null);
            }
        };
        this.B = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.t
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.r0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List p0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(OrderHandle orderHandle, TripAudioRecordingData tripAudioRecordingData) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new OrderHistoryDetailsViewModel$loadInfoBannerUIData$1(this, orderHandle, tripAudioRecordingData, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(OrderHandle orderHandle) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new OrderHistoryDetailsViewModel$loadRecordingProperties$1(this, orderHandle, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(OrderHandle orderHandle) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new OrderHistoryDetailsViewModel$loadUploadParams$1(this, orderHandle, null), 3, null);
    }

    public final LiveData<Boolean> A0() {
        return this.D;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final LiveEvent<Unit> B0() {
        return this.f29480y;
    }

    public final LiveData<OrderHistoryDetails> C0() {
        return this.f29474s;
    }

    public final LiveData<RecordingProperties> D0() {
        return this.E;
    }

    public final LiveData<String> E0() {
        return this.f29476u;
    }

    public final LiveEvent<String> F0() {
        return this.f29478w;
    }

    public final LiveEvent<Unit> G0() {
        return this.f29479x;
    }

    public final LiveData<List<UploadParams>> H0() {
        return this.F;
    }

    public final LiveEvent<Result<WebAppLaunchParams>> I0() {
        return this.G;
    }

    public final void J0(Long l8) {
        this.f29477v.o(new InfoBannerState.LoadingState(l8));
    }

    public final void K0() {
        OrderHandle orderHandle = this.f29481z;
        if (orderHandle == null || !DisposableExtKt.b(this.C)) {
            return;
        }
        Single<SupportWebAppLinkResponse> p8 = this.f29468m.p(orderHandle);
        final OrderHistoryDetailsViewModel$requestSupportWebAppLink$1 orderHistoryDetailsViewModel$requestSupportWebAppLink$1 = new Function1<SupportWebAppLinkResponse, String>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$requestSupportWebAppLink$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(SupportWebAppLinkResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<R> x7 = p8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.history.details.m
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String L0;
                L0 = OrderHistoryDetailsViewModel.L0(Function1.this, obj);
                return L0;
            }
        });
        Intrinsics.e(x7, "supportClient\n          …          .map { it.url }");
        Single l8 = l(SingleExtKt.d(x7));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$requestSupportWebAppLink$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                LiveEvent liveEvent;
                liveEvent = OrderHistoryDetailsViewModel.this.f29476u;
                liveEvent.o(str);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.M0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$requestSupportWebAppLink$3
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
                OrderHistoryDetailsViewModel orderHistoryDetailsViewModel = OrderHistoryDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderHistoryDetailsViewModel, it, null, 2, null);
            }
        };
        this.C = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.N0(Function1.this, obj);
            }
        });
    }

    public final void O0() {
        this.f29472q.g3();
    }

    public final void P0() {
        this.f29472q.M3();
    }

    public final void Q0() {
        this.f29472q.h4();
    }

    public final void R0() {
        this.f29472q.G0();
    }

    public final void S0() {
        this.f29472q.Y3();
    }

    public final void T0() {
        this.f29472q.S2();
    }

    public final void U0() {
        this.f29472q.c();
    }

    public final void V0() {
        this.f29472q.n3();
    }

    public final void W0(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        this.f29465j.s(orderHandle);
    }

    public final void X0(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new OrderHistoryDetailsViewModel$uploadAudioRecording$1(this, orderHandle, null), 3, null);
    }

    public final void Y0() {
        this.f29479x.m(Unit.f50853a);
    }

    public final void h0() {
        Job job = this.f29473r;
        if (job != null) {
            Job.DefaultImpls.a(job, null, 1, null);
        }
    }

    public final void j0() {
        this.f29480y.o(Unit.f50853a);
    }

    public final void l0(String supportURL) {
        Intrinsics.f(supportURL, "supportURL");
        Single d8 = SingleExtKt.d(this.f29470o.d(supportURL));
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$launchAudioRecordingSupportURL$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(String str) {
                LiveEvent liveEvent;
                liveEvent = OrderHistoryDetailsViewModel.this.f29478w;
                liveEvent.o(str.toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.n0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$launchAudioRecordingSupportURL$2
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
                OrderHistoryDetailsViewModel orderHistoryDetailsViewModel = OrderHistoryDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderHistoryDetailsViewModel, it, null, 2, null);
            }
        };
        Disposable I = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.m0(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "fun launchAudioRecording…t) }).autoDispose()\n    }");
        v(I);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.A;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Disposable disposable2 = this.B;
        if (disposable2 != null) {
            DisposableExtKt.a(disposable2);
        }
        Disposable disposable3 = this.C;
        if (disposable3 != null) {
            DisposableExtKt.a(disposable3);
        }
    }

    public final void t0(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        if (Intrinsics.a(this.f29481z, orderHandle) && !(this.f29477v.f() instanceof InfoBannerState.LoadingState) && !(this.f29477v.f() instanceof InfoBannerState.ShareWithCSState)) {
            return;
        }
        this.f29481z = orderHandle;
        Disposable disposable = this.A;
        if (disposable != null) {
            DisposableExtKt.a(disposable);
        }
        Single d8 = SingleExtKt.d(this.f29467l.b(orderHandle));
        final Function1<PreviousOrderDetails, Unit> function1 = new Function1<PreviousOrderDetails, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadOrderDetails$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PreviousOrderDetails order) {
                MutableLiveData mutableLiveData;
                DriverProvider driverProvider;
                Disposable disposable2;
                mutableLiveData = OrderHistoryDetailsViewModel.this.f29474s;
                Intrinsics.e(order, "order");
                driverProvider = OrderHistoryDetailsViewModel.this.f29464i;
                mutableLiveData.o(new OrderHistoryDetails(order, driverProvider.n().J()));
                disposable2 = OrderHistoryDetailsViewModel.this.B;
                if (disposable2 != null) {
                    DisposableExtKt.a(disposable2);
                }
                if (order.k() == OrderState.ORDER_STATE_FINISHED) {
                    OrderHistoryDetailsViewModel.this.o0();
                }
                OrderHistoryDetailsViewModel.this.w0(order.d());
                OrderHistoryDetailsViewModel.this.s0(order.d(), order.n());
                OrderHistoryDetailsViewModel.this.x0(order.d());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PreviousOrderDetails previousOrderDetails) {
                b(previousOrderDetails);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.u0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.history.details.OrderHistoryDetailsViewModel$loadOrderDetails$2
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
                OrderHistoryDetailsViewModel orderHistoryDetailsViewModel = OrderHistoryDetailsViewModel.this;
                Intrinsics.e(it, "it");
                BaseViewModel.A(orderHistoryDetailsViewModel, it, null, 2, null);
            }
        };
        this.A = d8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.history.details.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OrderHistoryDetailsViewModel.v0(Function1.this, obj);
            }
        });
    }

    public final LiveData<List<ContactOption>> y0() {
        return this.f29475t;
    }

    public final LiveData<InfoBannerState> z0() {
        MutableLiveData<InfoBannerState> mutableLiveData = this.f29477v;
        Intrinsics.d(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<ee.mtakso.driver.ui.screens.history.details.banner.InfoBannerState>");
        return mutableLiveData;
    }
}
