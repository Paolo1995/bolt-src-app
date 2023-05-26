package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.ChatContactDetails;
import ee.mtakso.driver.network.client.contact.ChatData;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.ui.base.mvvm.LiveDataExtKt;
import ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.OutgoingCallInfo;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.VoipOptionsData;
import ee.mtakso.driver.utils.ObservableExtKt;
import ee.mtakso.driver.utils.Optional;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
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

/* compiled from: ContactOptionsViewModel.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final ChatAnalytics f27792f;

    /* renamed from: g  reason: collision with root package name */
    private final ContactOptionsInteractor f27793g;

    /* renamed from: h  reason: collision with root package name */
    private final CallToRiderInteractor f27794h;

    /* renamed from: i  reason: collision with root package name */
    private final MutableLiveData<VoipOptionsData> f27795i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<ChatOptionsData> f27796j;

    /* renamed from: k  reason: collision with root package name */
    private final MutableLiveData<PhoneOptionsData> f27797k;

    /* renamed from: l  reason: collision with root package name */
    private final MutableLiveData<ContactOptionsData> f27798l;

    /* renamed from: m  reason: collision with root package name */
    private Disposable f27799m;

    /* renamed from: n  reason: collision with root package name */
    private Disposable f27800n;

    /* renamed from: o  reason: collision with root package name */
    private Disposable f27801o;

    /* renamed from: p  reason: collision with root package name */
    private Disposable f27802p;

    /* renamed from: q  reason: collision with root package name */
    private final BehaviorSubject<ContactOptionsConfig> f27803q;

    @Inject
    public ContactOptionsViewModel(ChatAnalytics chatAnalytics, ContactOptionsInteractor interactor, CallToRiderInteractor callToRiderInteractor) {
        Intrinsics.f(chatAnalytics, "chatAnalytics");
        Intrinsics.f(interactor, "interactor");
        Intrinsics.f(callToRiderInteractor, "callToRiderInteractor");
        this.f27792f = chatAnalytics;
        this.f27793g = interactor;
        this.f27794h = callToRiderInteractor;
        this.f27795i = new MutableLiveData<>();
        this.f27796j = new MutableLiveData<>();
        this.f27797k = new MutableLiveData<>();
        this.f27798l = new MutableLiveData<>();
        BehaviorSubject<ContactOptionsConfig> f8 = BehaviorSubject.f(new ContactOptionsConfig(false, null, null, null, 15, null));
        Intrinsics.e(f8, "createDefault(ContactOptionsConfig())");
        this.f27803q = f8;
    }

    private final ChatOptionsData T() {
        ChatData c8;
        ContactOptionsData f8 = this.f27798l.f();
        if (f8 != null && (c8 = f8.c()) != null) {
            return new ChatOptionsData(new ChatContactDetails(c8.a(), c8.b(), c8.c()));
        }
        return null;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void i0() {
        Disposable disposable = this.f27802p;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<ContactOptionsConfig> distinctUntilChanged = this.f27803q.distinctUntilChanged();
        final ContactOptionsViewModel$subscribeToContactOptions$1 contactOptionsViewModel$subscribeToContactOptions$1 = new ContactOptionsViewModel$subscribeToContactOptions$1(this);
        ObservableSource flatMapSingle = distinctUntilChanged.flatMapSingle(new Function() { // from class: a3.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource j02;
                j02 = ContactOptionsViewModel.j0(Function1.this, obj);
                return j02;
            }
        });
        Intrinsics.e(flatMapSingle, "private fun subscribeToC…ontact options\") })\n    }");
        Observable f8 = ObservableExtKt.f(k(flatMapSingle));
        final Function1<ContactOptionsData, Unit> function1 = new Function1<ContactOptionsData, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$subscribeToContactOptions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ContactOptionsData contactOptionsData) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ContactOptionsViewModel.this.f27798l;
                mutableLiveData.o(contactOptionsData);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContactOptionsData contactOptionsData) {
                b(contactOptionsData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: a3.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.k0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$subscribeToContactOptions$3
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
                ContactOptionsViewModel contactOptionsViewModel = ContactOptionsViewModel.this;
                Intrinsics.e(it, "it");
                contactOptionsViewModel.z(it, "Cannot load available contact options");
            }
        };
        this.f27802p = f8.subscribe(consumer, new Consumer() { // from class: a3.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.l0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource j0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void R(ContactOptionsConfig contactOptionsConfig) {
        Intrinsics.f(contactOptionsConfig, "contactOptionsConfig");
        this.f27803q.onNext(contactOptionsConfig);
    }

    public final void S() {
        i0();
    }

    public final LiveData<ContactOptionsData> U() {
        return this.f27798l;
    }

    public final LiveData<ChatOptionsData> V() {
        return this.f27796j;
    }

    public final LiveData<PhoneOptionsData> W() {
        return this.f27797k;
    }

    public final LiveData<VoipOptionsData> X() {
        return this.f27795i;
    }

    public final void Y() {
        OrderHandle orderHandle;
        this.f27792f.U();
        ContactOptionsData f8 = this.f27798l.f();
        if (f8 != null) {
            orderHandle = f8.d();
        } else {
            orderHandle = null;
        }
        if (orderHandle == null) {
            z(new IllegalStateException("No order handle"), "Cannot obtain user phone, going to error screen");
            return;
        }
        Single c8 = SingleExtKt.c(this.f27793g.b(orderHandle, T()));
        final Function1<ChatDelegate.ChatInfo, Unit> function1 = new Function1<ChatDelegate.ChatInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestChatData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(ChatDelegate.ChatInfo chatInfo) {
                MutableLiveData mutableLiveData;
                mutableLiveData = ContactOptionsViewModel.this.f27796j;
                mutableLiveData.o(chatInfo.b());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatDelegate.ChatInfo chatInfo) {
                b(chatInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: a3.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.Z(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestChatData$2
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
                ContactOptionsViewModel contactOptionsViewModel = ContactOptionsViewModel.this;
                Intrinsics.e(it, "it");
                contactOptionsViewModel.z(it, "Cannot obtain user phone, going to error screen");
            }
        };
        this.f27800n = c8.I(consumer, new Consumer() { // from class: a3.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.a0(Function1.this, obj);
            }
        });
    }

    public final void b0() {
        Single c8 = SingleExtKt.c(this.f27793g.c(((ContactOptionsData) LiveDataExtKt.b(this.f27798l)).d()));
        final Function1<Optional<PhoneOptionsData>, Unit> function1 = new Function1<Optional<PhoneOptionsData>, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestPhoneData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(Optional<PhoneOptionsData> optional) {
                MutableLiveData mutableLiveData;
                if (!optional.d()) {
                    mutableLiveData = ContactOptionsViewModel.this.f27797k;
                    mutableLiveData.o(optional.b());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Optional<PhoneOptionsData> optional) {
                b(optional);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: a3.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.c0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestPhoneData$2
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
                ContactOptionsViewModel contactOptionsViewModel = ContactOptionsViewModel.this;
                Intrinsics.e(it, "it");
                contactOptionsViewModel.z(it, "Cannot obtain user phone, going to error screen");
            }
        };
        this.f27799m = c8.I(consumer, new Consumer() { // from class: a3.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.d0(Function1.this, obj);
            }
        });
    }

    public final void e0() {
        Single c8 = SingleExtKt.c(this.f27794h.a(((ContactOptionsData) LiveDataExtKt.b(this.f27798l)).d()));
        final Function1<OutgoingCallInfo, Unit> function1 = new Function1<OutgoingCallInfo, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestVoipData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(OutgoingCallInfo outgoingCallInfo) {
                MutableLiveData mutableLiveData;
                if (outgoingCallInfo.a() != null) {
                    mutableLiveData = ContactOptionsViewModel.this.f27795i;
                    mutableLiveData.o(outgoingCallInfo.a());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OutgoingCallInfo outgoingCallInfo) {
                b(outgoingCallInfo);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: a3.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.f0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$requestVoipData$2
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
                ContactOptionsViewModel contactOptionsViewModel = ContactOptionsViewModel.this;
                Intrinsics.e(it, "it");
                contactOptionsViewModel.z(it, "Cannot obtain user voip info, going to error screen");
            }
        };
        this.f27801o = c8.I(consumer, new Consumer() { // from class: a3.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsViewModel.g0(Function1.this, obj);
            }
        });
    }

    public final void h0() {
        i0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.f27799m;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f27799m = null;
        Disposable disposable2 = this.f27801o;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f27801o = null;
        Disposable disposable3 = this.f27802p;
        if (disposable3 != null) {
            disposable3.dispose();
        }
        this.f27802p = null;
    }
}
