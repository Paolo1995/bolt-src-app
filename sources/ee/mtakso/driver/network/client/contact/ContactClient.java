package ee.mtakso.driver.network.client.contact;

import dagger.Lazy;
import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.response.CompositeResponseTransformer;
import ee.mtakso.driver.utils.SingleExtKt;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactClient.kt */
/* loaded from: classes3.dex */
public final class ContactClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<ContactApi> f21773a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeResponseTransformer f21774b;

    @Inject
    public ContactClient(Lazy<ContactApi> contactApi, CompositeResponseTransformer transformer) {
        Intrinsics.f(contactApi, "contactApi");
        Intrinsics.f(transformer, "transformer");
        this.f21773a = contactApi;
        this.f21774b = transformer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (List) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AvailableContactOptions g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (AvailableContactOptions) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactOptionsDetails i(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ContactOptionsDetails) tmp0.invoke(obj);
    }

    public final Single<List<ContactConfiguration>> d() {
        Single g8 = SingleExtKt.g(this.f21773a.get().a(), this.f21774b);
        final ContactClient$getAllContactsConfigurations$1 contactClient$getAllContactsConfigurations$1 = new Function1<ContactConfigurationsResponse, List<? extends ContactConfiguration>>() { // from class: ee.mtakso.driver.network.client.contact.ContactClient$getAllContactsConfigurations$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final List<ContactConfiguration> invoke(ContactConfigurationsResponse it) {
                Intrinsics.f(it, "it");
                return ContactConfiguration.f21780a.c(it.a());
            }
        };
        Single<List<ContactConfiguration>> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.contact.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List e8;
                e8 = ContactClient.e(Function1.this, obj);
                return e8;
            }
        });
        Intrinsics.e(x7, "contactApi.get().getAllC…ions(it.configurations) }");
        return x7;
    }

    public final Single<AvailableContactOptions> f(ContactOptionsUseCase useCase, OrderHandle orderHandle) {
        Intrinsics.f(useCase, "useCase");
        Intrinsics.f(orderHandle, "orderHandle");
        Single g8 = SingleExtKt.g(this.f21773a.get().c(new AvailableContactOptionsRequest(useCase, orderHandle)), this.f21774b);
        final ContactClient$getAvailableContactOptions$1 contactClient$getAvailableContactOptions$1 = new Function1<AvailableContactOptionsResponse, AvailableContactOptions>() { // from class: ee.mtakso.driver.network.client.contact.ContactClient$getAvailableContactOptions$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final AvailableContactOptions invoke(AvailableContactOptionsResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<AvailableContactOptions> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.contact.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AvailableContactOptions g9;
                g9 = ContactClient.g(Function1.this, obj);
                return g9;
            }
        });
        Intrinsics.e(x7, "contactApi.get().getAvai…availableContactOptions }");
        return x7;
    }

    public final Single<ContactOptionsDetails> h(Channel channel, OrderHandle orderHandle) {
        Intrinsics.f(channel, "channel");
        Intrinsics.f(orderHandle, "orderHandle");
        Single g8 = SingleExtKt.g(this.f21773a.get().b(new ContactOptionsDetailsRequest(channel.getId(), RecipientType.RIDER.getId(), orderHandle)), this.f21774b);
        final ContactClient$getContactOptionsDetails$1 contactClient$getContactOptionsDetails$1 = new Function1<ContactOptionsDetailsResponse, ContactOptionsDetails>() { // from class: ee.mtakso.driver.network.client.contact.ContactClient$getContactOptionsDetails$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ContactOptionsDetails invoke(ContactOptionsDetailsResponse it) {
                Intrinsics.f(it, "it");
                return it.a();
            }
        };
        Single<ContactOptionsDetails> x7 = g8.x(new Function() { // from class: ee.mtakso.driver.network.client.contact.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ContactOptionsDetails i8;
                i8 = ContactClient.i(Function1.this, obj);
                return i8;
            }
        });
        Intrinsics.e(x7, "contactApi.get().getCont…      .map { it.details }");
        return x7;
    }
}
