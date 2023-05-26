package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ContactOptionsData;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContactOptionsViewModel.kt */
/* loaded from: classes3.dex */
public final class ContactOptionsViewModel$subscribeToContactOptions$1 extends Lambda implements Function1<ContactOptionsConfig, SingleSource<? extends ContactOptionsData>> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ ContactOptionsViewModel f27810f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactOptionsViewModel$subscribeToContactOptions$1(ContactOptionsViewModel contactOptionsViewModel) {
        super(1);
        this.f27810f = contactOptionsViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContactOptionsData d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ContactOptionsData) tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final SingleSource<? extends ContactOptionsData> invoke(final ContactOptionsConfig config) {
        ContactOptionsInteractor contactOptionsInteractor;
        Intrinsics.f(config, "config");
        contactOptionsInteractor = this.f27810f.f27793g;
        Single<ContactOptionsData> a8 = contactOptionsInteractor.a(config.d(), config.c());
        final Function1<ContactOptionsData, ContactOptionsData> function1 = new Function1<ContactOptionsData, ContactOptionsData>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.ContactOptionsViewModel$subscribeToContactOptions$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ContactOptionsData invoke(ContactOptionsData options) {
                Intrinsics.f(options, "options");
                return ContactOptionsData.b(options, null, false, false, options.e() & (!ContactOptionsConfig.this.b()), null, 23, null);
            }
        };
        return a8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.contactoptions.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ContactOptionsData d8;
                d8 = ContactOptionsViewModel$subscribeToContactOptions$1.d(Function1.this, obj);
                return d8;
            }
        });
    }
}
