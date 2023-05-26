package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.PhoneOptionsData;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactOptionsInteractor.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final ChatDelegate f27788a;

    /* renamed from: b  reason: collision with root package name */
    private final ContactOptionsDelegate f27789b;

    @Inject
    public ContactOptionsInteractor(ChatDelegate chatDelegate, ContactOptionsDelegate contactOptionsDelegate) {
        Intrinsics.f(chatDelegate, "chatDelegate");
        Intrinsics.f(contactOptionsDelegate, "contactOptionsDelegate");
        this.f27788a = chatDelegate;
        this.f27789b = contactOptionsDelegate;
    }

    public final Single<ContactOptionsData> a(ContactOptionsUseCase useCase, OrderHandle orderHandle) {
        Intrinsics.f(useCase, "useCase");
        return this.f27789b.j(useCase, orderHandle);
    }

    public final Single<ChatDelegate.ChatInfo> b(OrderHandle orderHandle, ChatOptionsData chatOptionsData) {
        Intrinsics.f(orderHandle, "orderHandle");
        return this.f27788a.e(orderHandle, chatOptionsData);
    }

    public final Single<Optional<PhoneOptionsData>> c(OrderHandle orderHandle) {
        Intrinsics.f(orderHandle, "orderHandle");
        return this.f27789b.n(orderHandle);
    }
}
