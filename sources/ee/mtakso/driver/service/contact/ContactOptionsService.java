package ee.mtakso.driver.service.contact;

import ee.mtakso.driver.features.Features;
import ee.mtakso.driver.network.client.contact.ChatConfiguration;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactConfiguration;
import ee.mtakso.driver.network.client.contact.VoipConfiguration;
import ee.mtakso.driver.platform.core.PlatformManager;
import ee.mtakso.driver.platform.core.PlatformType;
import ee.mtakso.driver.platform.push.TokenProvider;
import ee.mtakso.driver.service.BaseService;
import ee.mtakso.driver.service.chat.ChatService;
import ee.mtakso.driver.service.voip.VoipService;
import eu.bolt.kalev.Kalev;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsService.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsService implements BaseService {

    /* renamed from: a  reason: collision with root package name */
    private final ContactClient f24114a;

    /* renamed from: b  reason: collision with root package name */
    private final Features f24115b;

    /* renamed from: c  reason: collision with root package name */
    private final VoipService f24116c;

    /* renamed from: d  reason: collision with root package name */
    private final PlatformManager f24117d;

    /* renamed from: e  reason: collision with root package name */
    private final ChatService f24118e;

    /* renamed from: f  reason: collision with root package name */
    private final TokenProvider f24119f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<ContactConfiguration.Type, ContactConfiguration> f24120g;

    /* renamed from: h  reason: collision with root package name */
    private Disposable f24121h;

    /* renamed from: i  reason: collision with root package name */
    private Disposable f24122i;

    /* renamed from: j  reason: collision with root package name */
    private final PublishSubject<Unit> f24123j;

    @Inject
    public ContactOptionsService(ContactClient contactClient, Features features, VoipService voipService, PlatformManager platformManager, ChatService chatService, TokenProvider tokenProvider) {
        Intrinsics.f(contactClient, "contactClient");
        Intrinsics.f(features, "features");
        Intrinsics.f(voipService, "voipService");
        Intrinsics.f(platformManager, "platformManager");
        Intrinsics.f(chatService, "chatService");
        Intrinsics.f(tokenProvider, "tokenProvider");
        this.f24114a = contactClient;
        this.f24115b = features;
        this.f24116c = voipService;
        this.f24117d = platformManager;
        this.f24118e = chatService;
        this.f24119f = tokenProvider;
        this.f24120g = new LinkedHashMap();
        PublishSubject<Unit> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<Unit>()");
        this.f24123j = e8;
    }

    private final Observable<Unit> p() {
        return this.f24123j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource r(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(List<? extends ContactConfiguration> list) {
        synchronized (this) {
            this.f24120g.clear();
            for (ContactConfiguration contactConfiguration : list) {
                this.f24120g.put(contactConfiguration.a(), contactConfiguration);
            }
            Unit unit = Unit.f50853a;
        }
        this.f24123j.onNext(Unit.f50853a);
    }

    public final void o() {
        this.f24120g.clear();
        Disposable disposable = this.f24121h;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f24121h = null;
        Disposable disposable2 = this.f24122i;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f24122i = null;
    }

    public final <T extends ContactConfiguration> T q(ContactConfiguration.Type type) {
        T t7;
        Intrinsics.f(type, "type");
        synchronized (this) {
            ContactConfiguration contactConfiguration = this.f24120g.get(type);
            if (contactConfiguration instanceof ContactConfiguration) {
                t7 = (T) contactConfiguration;
            } else {
                t7 = null;
            }
        }
        return t7;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public boolean start() {
        Observable<Unit> p8 = p();
        final Function1<Unit, SingleSource<? extends TokenProvider.PushTokenData>> function1 = new Function1<Unit, SingleSource<? extends TokenProvider.PushTokenData>>() { // from class: ee.mtakso.driver.service.contact.ContactOptionsService$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends TokenProvider.PushTokenData> invoke(Unit it) {
                TokenProvider tokenProvider;
                Intrinsics.f(it, "it");
                tokenProvider = ContactOptionsService.this.f24119f;
                return tokenProvider.a();
            }
        };
        Observable observeOn = p8.flatMapSingle(new Function() { // from class: ee.mtakso.driver.service.contact.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource r7;
                r7 = ContactOptionsService.r(Function1.this, obj);
                return r7;
            }
        }).observeOn(AndroidSchedulers.a());
        final Function1<TokenProvider.PushTokenData, Unit> function12 = new Function1<TokenProvider.PushTokenData, Unit>() { // from class: ee.mtakso.driver.service.contact.ContactOptionsService$start$2

            /* compiled from: ContactOptionsService.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f24126a;

                static {
                    int[] iArr = new int[PlatformType.values().length];
                    try {
                        iArr[PlatformType.GMS.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PlatformType.HMS.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f24126a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(TokenProvider.PushTokenData tokenData) {
                PlatformManager platformManager;
                ChatService chatService;
                ChatService chatService2;
                ChatService chatService3;
                VoipService voipService;
                PlatformManager platformManager2;
                Intrinsics.f(tokenData, "tokenData");
                VoipConfiguration voipConfiguration = (VoipConfiguration) ContactOptionsService.this.q(ContactConfiguration.Type.VOIP);
                if (voipConfiguration != null) {
                    ContactOptionsService contactOptionsService = ContactOptionsService.this;
                    voipService = contactOptionsService.f24116c;
                    platformManager2 = contactOptionsService.f24117d;
                    voipService.y(voipConfiguration, platformManager2.getType(), tokenData);
                }
                platformManager = ContactOptionsService.this.f24117d;
                int i8 = WhenMappings.f24126a[platformManager.getType().ordinal()];
                if (i8 == 1) {
                    chatService = ContactOptionsService.this.f24118e;
                    chatService.k0();
                    ChatConfiguration chatConfiguration = (ChatConfiguration) ContactOptionsService.this.q(ContactConfiguration.Type.CHAT);
                    if (chatConfiguration != null) {
                        chatService2 = ContactOptionsService.this.f24118e;
                        chatService2.l0(chatConfiguration);
                    }
                } else if (i8 == 2) {
                    chatService3 = ContactOptionsService.this.f24118e;
                    chatService3.l0(new ChatConfiguration(true, null, 2, null));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TokenProvider.PushTokenData pushTokenData) {
                b(pushTokenData);
                return Unit.f50853a;
            }
        };
        Consumer consumer = new Consumer() { // from class: ee.mtakso.driver.service.contact.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsService.s(Function1.this, obj);
            }
        };
        final ContactOptionsService$start$3 contactOptionsService$start$3 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.contact.ContactOptionsService$start$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.c(th);
                Kalev.e(th, "Cannot load contact configs");
            }
        };
        this.f24122i = observeOn.subscribe(consumer, new Consumer() { // from class: ee.mtakso.driver.service.contact.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsService.t(Function1.this, obj);
            }
        });
        Single<List<ContactConfiguration>> K = this.f24114a.d().K(Schedulers.a());
        final Function1<List<? extends ContactConfiguration>, Unit> function13 = new Function1<List<? extends ContactConfiguration>, Unit>() { // from class: ee.mtakso.driver.service.contact.ContactOptionsService$start$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void b(List<? extends ContactConfiguration> configurations) {
                ContactOptionsService contactOptionsService = ContactOptionsService.this;
                Intrinsics.e(configurations, "configurations");
                contactOptionsService.w(configurations);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ContactConfiguration> list) {
                b(list);
                return Unit.f50853a;
            }
        };
        Consumer<? super List<ContactConfiguration>> consumer2 = new Consumer() { // from class: ee.mtakso.driver.service.contact.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsService.u(Function1.this, obj);
            }
        };
        final ContactOptionsService$start$5 contactOptionsService$start$5 = new Function1<Throwable, Unit>() { // from class: ee.mtakso.driver.service.contact.ContactOptionsService$start$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Intrinsics.e(it, "it");
                Kalev.e(it, "Cannot load contact options config");
            }
        };
        this.f24121h = K.I(consumer2, new Consumer() { // from class: ee.mtakso.driver.service.contact.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactOptionsService.v(Function1.this, obj);
            }
        });
        return true;
    }

    @Override // ee.mtakso.driver.service.BaseService
    public void stop() {
        o();
    }
}
