package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.Channel;
import ee.mtakso.driver.network.client.contact.ChatContactDetails;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactOptionsDetails;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import ee.mtakso.driver.network.client.contact.PhoneContactDetails;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsDelegate.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ContactClient f27910a;

    /* renamed from: b  reason: collision with root package name */
    private final VoipOrderInformationDelegate f27911b;

    @Inject
    public ContactOptionsDelegate(ContactClient contactClient, VoipOrderInformationDelegate voipOrderInformationDelegate) {
        Intrinsics.f(contactClient, "contactClient");
        Intrinsics.f(voipOrderInformationDelegate, "voipOrderInformationDelegate");
        this.f27910a = contactClient;
        this.f27911b = voipOrderInformationDelegate;
    }

    private final Observable<OrderHandle> g(OrderHandle orderHandle) {
        if (orderHandle == null) {
            Observable<Optional<OrderHandle>> distinctUntilChanged = this.f27911b.t().distinctUntilChanged();
            final ContactOptionsDelegate$ensureOrderHandle$1 contactOptionsDelegate$ensureOrderHandle$1 = new Function1<Optional<OrderHandle>, Boolean>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate$ensureOrderHandle$1
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final Boolean invoke(Optional<OrderHandle> it) {
                    Intrinsics.f(it, "it");
                    return Boolean.valueOf(!it.d());
                }
            };
            Observable<Optional<OrderHandle>> filter = distinctUntilChanged.filter(new Predicate() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.f
                @Override // io.reactivex.functions.Predicate
                public final boolean test(Object obj) {
                    boolean h8;
                    h8 = ContactOptionsDelegate.h(Function1.this, obj);
                    return h8;
                }
            });
            final ContactOptionsDelegate$ensureOrderHandle$2 contactOptionsDelegate$ensureOrderHandle$2 = new Function1<Optional<OrderHandle>, ObservableSource<? extends OrderHandle>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate$ensureOrderHandle$2
                @Override // kotlin.jvm.functions.Function1
                /* renamed from: b */
                public final ObservableSource<? extends OrderHandle> invoke(Optional<OrderHandle> it) {
                    Intrinsics.f(it, "it");
                    return Observable.just(it.b());
                }
            };
            Observable flatMap = filter.flatMap(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.g
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource i8;
                    i8 = ContactOptionsDelegate.i(Function1.this, obj);
                    return i8;
                }
            });
            Intrinsics.e(flatMap, "voipOrderInformationDele…servable.just(it.value) }");
            return flatMap;
        }
        Observable<OrderHandle> just = Observable.just(orderHandle);
        Intrinsics.e(just, "just(optionalOrderHandle)");
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ObservableSource i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ObservableSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource k(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional m(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional o(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Single<ContactOptionsData> j(ContactOptionsUseCase useCase, OrderHandle orderHandle) {
        Intrinsics.f(useCase, "useCase");
        Observable<OrderHandle> g8 = g(orderHandle);
        final ContactOptionsDelegate$requestAvailableContactOptions$1 contactOptionsDelegate$requestAvailableContactOptions$1 = new ContactOptionsDelegate$requestAvailableContactOptions$1(this, useCase);
        Single<ContactOptionsData> firstOrError = g8.flatMapSingle(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource k8;
                k8 = ContactOptionsDelegate.k(Function1.this, obj);
                return k8;
            }
        }).firstOrError();
        Intrinsics.e(firstOrError, "fun requestAvailableCont…    .firstOrError()\n    }");
        return firstOrError;
    }

    public final Single<Optional<ChatOptionsData>> l(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ContactOptionsDetails> h8 = this.f27910a.h(Channel.CHAT, orderHandle);
        final ContactOptionsDelegate$requestChatInfo$1 contactOptionsDelegate$requestChatInfo$1 = new Function1<ContactOptionsDetails, Optional<ChatOptionsData>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate$requestChatInfo$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ChatOptionsData> invoke(ContactOptionsDetails it) {
                Intrinsics.f(it, "it");
                if (it instanceof ChatContactDetails) {
                    return Optional.f(new ChatOptionsData((ChatContactDetails) it));
                }
                return Optional.a();
            }
        };
        Single x7 = h8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional m8;
                m8 = ContactOptionsDelegate.m(Function1.this, obj);
                return m8;
            }
        });
        Intrinsics.e(x7, "contactClient\n          …nal.empty()\n            }");
        return x7;
    }

    public final Single<Optional<PhoneOptionsData>> n(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<ContactOptionsDetails> h8 = this.f27910a.h(Channel.PHONE_CALL, orderHandle);
        final ContactOptionsDelegate$requestUserPhone$1 contactOptionsDelegate$requestUserPhone$1 = new Function1<ContactOptionsDetails, Optional<PhoneOptionsData>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate$requestUserPhone$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<PhoneOptionsData> invoke(ContactOptionsDetails it) {
                Intrinsics.f(it, "it");
                if (it instanceof PhoneContactDetails) {
                    return Optional.f(new PhoneOptionsData(((PhoneContactDetails) it).a()));
                }
                return Optional.a();
            }
        };
        Single x7 = h8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional o8;
                o8 = ContactOptionsDelegate.o(Function1.this, obj);
                return o8;
            }
        });
        Intrinsics.e(x7, "contactClient.getContact…empty()\n                }");
        return x7;
    }
}
