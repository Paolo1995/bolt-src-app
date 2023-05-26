package ee.mtakso.driver.ui.screens.contact_methods.contactoptions;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.service.analytics.event.facade.ChatAnalytics;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class ContactOptionsViewModel_Factory implements Factory<ContactOptionsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ChatAnalytics> f27814a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ContactOptionsInteractor> f27815b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<CallToRiderInteractor> f27816c;

    public ContactOptionsViewModel_Factory(Provider<ChatAnalytics> provider, Provider<ContactOptionsInteractor> provider2, Provider<CallToRiderInteractor> provider3) {
        this.f27814a = provider;
        this.f27815b = provider2;
        this.f27816c = provider3;
    }

    public static ContactOptionsViewModel_Factory a(Provider<ChatAnalytics> provider, Provider<ContactOptionsInteractor> provider2, Provider<CallToRiderInteractor> provider3) {
        return new ContactOptionsViewModel_Factory(provider, provider2, provider3);
    }

    public static ContactOptionsViewModel c(ChatAnalytics chatAnalytics, ContactOptionsInteractor contactOptionsInteractor, CallToRiderInteractor callToRiderInteractor) {
        return new ContactOptionsViewModel(chatAnalytics, contactOptionsInteractor, callToRiderInteractor);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public ContactOptionsViewModel get() {
        return c(this.f27814a.get(), this.f27815b.get(), this.f27816c.get());
    }
}
