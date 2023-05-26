package ee.mtakso.driver.ui.screens.earnings.v2.payout.details;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.earnings.PayoutResponce;
import ee.mtakso.driver.network.client.earnings.PayoutState;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.payouts.PayoutDetailsInteractor;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import ee.mtakso.driver.utils.SingleExtKt;
import eu.bolt.kalev.Kalev;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutDetailsViewModel.kt */
/* loaded from: classes3.dex */
public final class PayoutDetailsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PayoutDetailsInteractor f28683f;

    /* renamed from: g  reason: collision with root package name */
    private final CompositeUrlLauncher f28684g;

    /* renamed from: h  reason: collision with root package name */
    private final PayoutAnalytics f28685h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f28686i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<ScreenState> f28687j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveEvent<Object> f28688k;

    @Inject
    public PayoutDetailsViewModel(PayoutDetailsInteractor payoutDetailsInteractor, CompositeUrlLauncher urlLauncher, PayoutAnalytics payoutAnalytics) {
        Intrinsics.f(payoutDetailsInteractor, "payoutDetailsInteractor");
        Intrinsics.f(urlLauncher, "urlLauncher");
        Intrinsics.f(payoutAnalytics, "payoutAnalytics");
        this.f28683f = payoutDetailsInteractor;
        this.f28684g = urlLauncher;
        this.f28685h = payoutAnalytics;
        this.f28687j = new MutableLiveData<>();
        this.f28688k = new LiveEvent<>();
    }

    private final void M() {
        y().o(Boolean.TRUE);
        Single l8 = l(SingleExtKt.d(this.f28683f.a(((ScreenState) LiveDataExtKt.b(this.f28687j)).c().b())));
        final Function1<PayoutResponce, Unit> function1 = new Function1<PayoutResponce, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel$refreshScreenData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PayoutResponce payoutResponce) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = PayoutDetailsViewModel.this.f28687j;
                mutableLiveData2 = PayoutDetailsViewModel.this.f28687j;
                Object b8 = LiveDataExtKt.b(mutableLiveData2);
                Intrinsics.e(b8, "screenStateLiveData.requireValue()");
                mutableLiveData.o(PayoutDetailsViewModel.ScreenState.b((PayoutDetailsViewModel.ScreenState) b8, null, payoutResponce, 1, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayoutResponce payoutResponce) {
                b(payoutResponce);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutDetailsViewModel.N(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.PayoutDetailsViewModel$refreshScreenData$2
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
                LiveEvent liveEvent;
                ApiException apiException = it instanceof ApiException ? (ApiException) it : null;
                boolean z7 = true;
                if ((apiException == null || !apiException.f()) ? false : false) {
                    liveEvent = PayoutDetailsViewModel.this.f28688k;
                    liveEvent.o(new Object());
                    Intrinsics.e(it, "it");
                    Kalev.e(it, "Payout data is not found!");
                    return;
                }
                PayoutDetailsViewModel payoutDetailsViewModel = PayoutDetailsViewModel.this;
                Intrinsics.e(it, "it");
                payoutDetailsViewModel.z(it, "Failed to refresh screen data!");
            }
        };
        this.f28686i = l8.I(consumer, new Consumer() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.details.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutDetailsViewModel.O(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        this.f28685h.k0();
    }

    public final LiveEvent<Object> H() {
        return this.f28688k;
    }

    public final LiveData<ScreenState> I() {
        return this.f28687j;
    }

    public final void J() {
        PayoutResponce d8;
        String f8;
        ScreenState f9 = this.f28687j.f();
        if (f9 != null && (d8 = f9.d()) != null && (f8 = d8.f()) != null) {
            this.f28684g.a(f8);
        }
    }

    public final void K() {
        PayoutResponce d8;
        String e8;
        ScreenState f8 = this.f28687j.f();
        if (f8 != null && (d8 = f8.d()) != null && (e8 = d8.e()) != null) {
            this.f28685h.P2();
            this.f28684g.a(e8);
        }
    }

    public final void L() {
        PayoutResponce d8;
        String g8;
        ScreenState f8 = this.f28687j.f();
        if (f8 != null && (d8 = f8.d()) != null && (g8 = d8.g()) != null) {
            this.f28685h.V2();
            this.f28684g.a(g8);
        }
    }

    public final void P(Config info) {
        Intrinsics.f(info, "info");
        this.f28687j.o(new ScreenState(info, null, 2, null));
        M();
    }

    public final void Q() {
        this.f28685h.D1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28686i;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    /* compiled from: PayoutDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class ScreenState {

        /* renamed from: a  reason: collision with root package name */
        private final Config f28694a;

        /* renamed from: b  reason: collision with root package name */
        private final PayoutResponce f28695b;

        public ScreenState(Config config, PayoutResponce payoutResponce) {
            Intrinsics.f(config, "config");
            this.f28694a = config;
            this.f28695b = payoutResponce;
        }

        public static /* synthetic */ ScreenState b(ScreenState screenState, Config config, PayoutResponce payoutResponce, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                config = screenState.f28694a;
            }
            if ((i8 & 2) != 0) {
                payoutResponce = screenState.f28695b;
            }
            return screenState.a(config, payoutResponce);
        }

        public final ScreenState a(Config config, PayoutResponce payoutResponce) {
            Intrinsics.f(config, "config");
            return new ScreenState(config, payoutResponce);
        }

        public final Config c() {
            return this.f28694a;
        }

        public final PayoutResponce d() {
            return this.f28695b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ScreenState) {
                ScreenState screenState = (ScreenState) obj;
                return Intrinsics.a(this.f28694a, screenState.f28694a) && Intrinsics.a(this.f28695b, screenState.f28695b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f28694a.hashCode() * 31;
            PayoutResponce payoutResponce = this.f28695b;
            return hashCode + (payoutResponce == null ? 0 : payoutResponce.hashCode());
        }

        public String toString() {
            Config config = this.f28694a;
            PayoutResponce payoutResponce = this.f28695b;
            return "ScreenState(config=" + config + ", details=" + payoutResponce + ")";
        }

        public /* synthetic */ ScreenState(Config config, PayoutResponce payoutResponce, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(config, (i8 & 2) != 0 ? null : payoutResponce);
        }
    }

    /* compiled from: PayoutDetailsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final long f28689f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28690g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28691h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28692i;

        /* renamed from: j  reason: collision with root package name */
        private final PayoutState f28693j;

        /* compiled from: PayoutDetailsViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Config(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PayoutState.valueOf(parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Config[] newArray(int i8) {
                return new Config[i8];
            }
        }

        public Config(long j8, String str, String str2, String str3, PayoutState payoutState) {
            this.f28689f = j8;
            this.f28690g = str;
            this.f28691h = str2;
            this.f28692i = str3;
            this.f28693j = payoutState;
        }

        public final String a() {
            return this.f28692i;
        }

        public final long b() {
            return this.f28689f;
        }

        public final PayoutState c() {
            return this.f28693j;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Config) {
                Config config = (Config) obj;
                return this.f28689f == config.f28689f && Intrinsics.a(this.f28690g, config.f28690g) && Intrinsics.a(this.f28691h, config.f28691h) && Intrinsics.a(this.f28692i, config.f28692i) && this.f28693j == config.f28693j;
            }
            return false;
        }

        public int hashCode() {
            int a8 = i0.a.a(this.f28689f) * 31;
            String str = this.f28690g;
            int hashCode = (a8 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f28691h;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f28692i;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            PayoutState payoutState = this.f28693j;
            return hashCode3 + (payoutState != null ? payoutState.hashCode() : 0);
        }

        public String toString() {
            long j8 = this.f28689f;
            String str = this.f28690g;
            String str2 = this.f28691h;
            String str3 = this.f28692i;
            PayoutState payoutState = this.f28693j;
            return "Config(id=" + j8 + ", label=" + str + ", date=" + str2 + ", amount=" + str3 + ", state=" + payoutState + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            out.writeLong(this.f28689f);
            out.writeString(this.f28690g);
            out.writeString(this.f28691h);
            out.writeString(this.f28692i);
            PayoutState payoutState = this.f28693j;
            if (payoutState == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            out.writeString(payoutState.name());
        }

        public /* synthetic */ Config(long j8, String str, String str2, String str3, PayoutState payoutState, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(j8, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2, (i8 & 8) != 0 ? null : str3, (i8 & 16) != 0 ? null : payoutState);
        }
    }
}
