package ee.mtakso.driver.ui.screens.earnings.v2.payout.request;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.earnings.CreatePayoutResponse;
import ee.mtakso.driver.network.client.earnings.PayoutConfirmationResponce;
import ee.mtakso.driver.network.client.generic.GenericSection;
import ee.mtakso.driver.network.exception.ApiException;
import ee.mtakso.driver.service.analytics.event.facade.PayoutAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.base.mvvm.LiveEvent;
import ee.mtakso.driver.ui.interactor.payouts.ConfirmPayoutInteractor;
import ee.mtakso.driver.ui.interactor.payouts.PayoutInfoInteractor;
import ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PayoutRequestViewModel.kt */
/* loaded from: classes3.dex */
public final class PayoutRequestViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final PayoutInfoInteractor f28743f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfirmPayoutInteractor f28744g;

    /* renamed from: h  reason: collision with root package name */
    private final PayoutAnalytics f28745h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<Config> f28746i;

    /* renamed from: j  reason: collision with root package name */
    private final LiveEvent<EventResult> f28747j;

    /* renamed from: k  reason: collision with root package name */
    private Disposable f28748k;

    /* compiled from: PayoutRequestViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final List<GenericSection> f28749f;

        /* renamed from: g  reason: collision with root package name */
        private final String f28750g;

        /* renamed from: h  reason: collision with root package name */
        private final String f28751h;

        /* renamed from: i  reason: collision with root package name */
        private final String f28752i;

        /* compiled from: PayoutRequestViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i8 = 0; i8 != readInt; i8++) {
                    arrayList.add(GenericSection.CREATOR.createFromParcel(parcel));
                }
                return new Config(arrayList, parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Config[] newArray(int i8) {
                return new Config[i8];
            }
        }

        public Config(List<GenericSection> sections, String str, String str2, String confirmationId) {
            Intrinsics.f(sections, "sections");
            Intrinsics.f(confirmationId, "confirmationId");
            this.f28749f = sections;
            this.f28750g = str;
            this.f28751h = str2;
            this.f28752i = confirmationId;
        }

        public final String a() {
            return this.f28750g;
        }

        public final String b() {
            return this.f28752i;
        }

        public final String c() {
            return this.f28751h;
        }

        public final List<GenericSection> d() {
            return this.f28749f;
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
                return Intrinsics.a(this.f28749f, config.f28749f) && Intrinsics.a(this.f28750g, config.f28750g) && Intrinsics.a(this.f28751h, config.f28751h) && Intrinsics.a(this.f28752i, config.f28752i);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f28749f.hashCode() * 31;
            String str = this.f28750g;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f28751h;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f28752i.hashCode();
        }

        public String toString() {
            List<GenericSection> list = this.f28749f;
            String str = this.f28750g;
            String str2 = this.f28751h;
            String str3 = this.f28752i;
            return "Config(sections=" + list + ", comment=" + str + ", info=" + str2 + ", confirmationId=" + str3 + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            List<GenericSection> list = this.f28749f;
            out.writeInt(list.size());
            for (GenericSection genericSection : list) {
                genericSection.writeToParcel(out, i8);
            }
            out.writeString(this.f28750g);
            out.writeString(this.f28751h);
            out.writeString(this.f28752i);
        }
    }

    /* compiled from: PayoutRequestViewModel.kt */
    /* loaded from: classes3.dex */
    public static abstract class EventResult {

        /* compiled from: PayoutRequestViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Error extends EventResult {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f28753a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(Throwable throwable) {
                super(null);
                Intrinsics.f(throwable, "throwable");
                this.f28753a = throwable;
            }

            public final Throwable a() {
                return this.f28753a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.a(this.f28753a, ((Error) obj).f28753a);
            }

            public int hashCode() {
                return this.f28753a.hashCode();
            }

            public String toString() {
                Throwable th = this.f28753a;
                return "Error(throwable=" + th + ")";
            }
        }

        /* compiled from: PayoutRequestViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Success extends EventResult {

            /* renamed from: a  reason: collision with root package name */
            private final String f28754a;

            /* renamed from: b  reason: collision with root package name */
            private final String f28755b;

            public Success(String str, String str2) {
                super(null);
                this.f28754a = str;
                this.f28755b = str2;
            }

            public final String a() {
                return this.f28755b;
            }

            public final String b() {
                return this.f28754a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return Intrinsics.a(this.f28754a, success.f28754a) && Intrinsics.a(this.f28755b, success.f28755b);
                }
                return false;
            }

            public int hashCode() {
                String str = this.f28754a;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f28755b;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                String str = this.f28754a;
                String str2 = this.f28755b;
                return "Success(text=" + str + ", comment=" + str2 + ")";
            }
        }

        private EventResult() {
        }

        public /* synthetic */ EventResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public PayoutRequestViewModel(PayoutInfoInteractor payoutInfoInteractor, ConfirmPayoutInteractor confirmPayoutInteractor, PayoutAnalytics payoutAnalytics) {
        Intrinsics.f(payoutInfoInteractor, "payoutInfoInteractor");
        Intrinsics.f(confirmPayoutInteractor, "confirmPayoutInteractor");
        Intrinsics.f(payoutAnalytics, "payoutAnalytics");
        this.f28743f = payoutInfoInteractor;
        this.f28744g = confirmPayoutInteractor;
        this.f28745h = payoutAnalytics;
        this.f28746i = new MutableLiveData<>();
        this.f28747j = new LiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
        Single l8 = l(SingleExtKt.d(this.f28743f.a()));
        final Function1<PayoutConfirmationResponce, Unit> function1 = new Function1<PayoutConfirmationResponce, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel$onStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(PayoutConfirmationResponce payoutConfirmationResponce) {
                MutableLiveData mutableLiveData;
                mutableLiveData = PayoutRequestViewModel.this.f28746i;
                mutableLiveData.o(new PayoutRequestViewModel.Config(payoutConfirmationResponce.d(), payoutConfirmationResponce.a(), payoutConfirmationResponce.c(), payoutConfirmationResponce.b()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PayoutConfirmationResponce payoutConfirmationResponce) {
                b(payoutConfirmationResponce);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: r3.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutRequestViewModel.Q(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel$onStart$2
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
                PayoutRequestViewModel payoutRequestViewModel = PayoutRequestViewModel.this;
                Intrinsics.e(it, "it");
                payoutRequestViewModel.K(it);
            }
        };
        Disposable I = l8.I(consumer, new Consumer() { // from class: r3.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutRequestViewModel.R(Function1.this, obj);
            }
        });
        Intrinsics.e(I, "override fun onStart() {…     .autoDispose()\n    }");
        v(I);
    }

    public final void K(Throwable error) {
        Intrinsics.f(error, "error");
        if (error instanceof ApiException) {
            this.f28747j.o(new EventResult.Error(error));
        } else {
            BaseViewModel.A(this, error, null, 2, null);
        }
    }

    public final void L() {
        String b8 = ((Config) LiveDataExtKt.b(this.f28746i)).b();
        this.f28745h.q();
        Single d8 = SingleExtKt.d(l(this.f28744g.a(b8)));
        final Function1<CreatePayoutResponse, Unit> function1 = new Function1<CreatePayoutResponse, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel$confirmPayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(CreatePayoutResponse createPayoutResponse) {
                PayoutAnalytics payoutAnalytics;
                LiveEvent liveEvent;
                payoutAnalytics = PayoutRequestViewModel.this.f28745h;
                payoutAnalytics.T1();
                liveEvent = PayoutRequestViewModel.this.f28747j;
                liveEvent.o(new PayoutRequestViewModel.EventResult.Success(createPayoutResponse.b(), createPayoutResponse.a()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CreatePayoutResponse createPayoutResponse) {
                b(createPayoutResponse);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: r3.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutRequestViewModel.M(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.earnings.v2.payout.request.PayoutRequestViewModel$confirmPayout$2
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
            public final void invoke2(Throwable err) {
                PayoutAnalytics payoutAnalytics;
                payoutAnalytics = PayoutRequestViewModel.this.f28745h;
                payoutAnalytics.y0();
                PayoutRequestViewModel payoutRequestViewModel = PayoutRequestViewModel.this;
                Intrinsics.e(err, "err");
                payoutRequestViewModel.K(err);
            }
        };
        this.f28748k = d8.I(consumer, new Consumer() { // from class: r3.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PayoutRequestViewModel.N(Function1.this, obj);
            }
        });
    }

    public final LiveData<Config> O() {
        return this.f28746i;
    }

    public final LiveData<EventResult> P() {
        return this.f28747j;
    }

    public final void S() {
        this.f28745h.c3();
    }

    public final void T() {
        this.f28745h.C0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f28748k;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
