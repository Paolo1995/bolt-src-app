package ee.mtakso.driver.ui.screens.contact_methods.voip.callerror;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.network.client.contact.ContactOptionsUseCase;
import ee.mtakso.driver.service.voip.VoipCache;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsDelegate;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoipCallErrorDelegate.kt */
/* loaded from: classes3.dex */
public final class VoipCallErrorDelegate$getAvailableContactOptions$1 extends Lambda implements Function1<Optional<OrderHandle>, SingleSource<? extends Optional<ContactOptionsData>>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ VoipCallErrorDelegate f27846f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoipCallErrorDelegate$getAvailableContactOptions$1(VoipCallErrorDelegate voipCallErrorDelegate) {
        super(1);
        this.f27846f = voipCallErrorDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends Optional<ContactOptionsData>> invoke(Optional<OrderHandle> optionalOrderHandle) {
        VoipCache voipCache;
        ContactOptionsUseCase contactOptionsUseCase;
        ContactOptionsDelegate contactOptionsDelegate;
        Intrinsics.f(optionalOrderHandle, "optionalOrderHandle");
        voipCache = this.f27846f.f27844c;
        OrderHandle a8 = voipCache.a();
        if (Intrinsics.a(optionalOrderHandle.c(), a8)) {
            contactOptionsUseCase = ContactOptionsUseCase.ACTIVE_ORDER;
        } else {
            contactOptionsUseCase = ContactOptionsUseCase.HISTORY;
        }
        contactOptionsDelegate = this.f27846f.f27842a;
        Single<ContactOptionsData> j8 = contactOptionsDelegate.j(contactOptionsUseCase, a8);
        final AnonymousClass1 anonymousClass1 = new Function1<ContactOptionsData, Optional<ContactOptionsData>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.VoipCallErrorDelegate$getAvailableContactOptions$1.1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<ContactOptionsData> invoke(ContactOptionsData it) {
                Intrinsics.f(it, "it");
                return Optional.f(it);
            }
        };
        return j8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.callerror.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional d8;
                d8 = VoipCallErrorDelegate$getAvailableContactOptions$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
