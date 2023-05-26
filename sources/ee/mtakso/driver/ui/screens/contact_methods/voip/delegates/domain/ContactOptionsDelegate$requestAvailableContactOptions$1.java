package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.AvailableContactOptions;
import ee.mtakso.driver.network.client.contact.ChatData;
import ee.mtakso.driver.network.client.contact.ContactClient;
import ee.mtakso.driver.network.client.contact.ContactOption;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContactOptionsDelegate.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsDelegate$requestAvailableContactOptions$1 extends Lambda implements Function1<OrderHandle, SingleSource<? extends ContactOptionsData>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ContactOptionsDelegate f27914f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ ContactOptionsUseCase f27915g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactOptionsDelegate$requestAvailableContactOptions$1(ContactOptionsDelegate contactOptionsDelegate, ContactOptionsUseCase contactOptionsUseCase) {
        super(1);
        this.f27914f = contactOptionsDelegate;
        this.f27915g = contactOptionsUseCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactOptionsData d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ContactOptionsData) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends ContactOptionsData> invoke(final OrderHandle orderHandle) {
        ContactClient contactClient;
        Intrinsics.f(orderHandle, "orderHandle");
        contactClient = this.f27914f.f27910a;
        Single<AvailableContactOptions> f8 = contactClient.f(this.f27915g, orderHandle);
        final Function1<AvailableContactOptions, ContactOptionsData> function1 = new Function1<AvailableContactOptions, ContactOptionsData>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate$requestAvailableContactOptions$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ContactOptionsData invoke(AvailableContactOptions result) {
                ChatData chatData;
                Object obj;
                boolean z7;
                boolean z8;
                boolean z9;
                Intrinsics.f(result, "result");
                List<ContactOption> a8 = result.a();
                Iterator<T> it = a8.iterator();
                while (true) {
                    chatData = null;
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((ContactOption) obj) instanceof ContactOption.Chat) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                ContactOption.Chat chat = (ContactOption.Chat) obj;
                boolean z10 = a8 instanceof Collection;
                if (!z10 || !a8.isEmpty()) {
                    for (ContactOption contactOption : a8) {
                        if (contactOption instanceof ContactOption.Voip) {
                            z7 = true;
                            break;
                        }
                    }
                }
                z7 = false;
                if (!z10 || !a8.isEmpty()) {
                    for (ContactOption contactOption2 : a8) {
                        if (contactOption2 instanceof ContactOption.Chat) {
                            z8 = true;
                            break;
                        }
                    }
                }
                z8 = false;
                if (!z10 || !a8.isEmpty()) {
                    for (ContactOption contactOption3 : a8) {
                        if (contactOption3 instanceof ContactOption.PhoneCall) {
                            z9 = true;
                            break;
                        }
                    }
                }
                z9 = false;
                OrderHandle orderHandle2 = OrderHandle.this;
                Intrinsics.e(orderHandle2, "orderHandle");
                if (chat != null) {
                    chatData = chat.a();
                }
                return new ContactOptionsData(orderHandle2, z7, z9, z8, chatData);
            }
        };
        return f8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.h
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ContactOptionsData d8;
                d8 = ContactOptionsDelegate$requestAvailableContactOptions$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
