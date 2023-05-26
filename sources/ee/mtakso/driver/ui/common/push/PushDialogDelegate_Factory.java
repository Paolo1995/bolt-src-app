package ee.mtakso.driver.ui.common.push;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ee.mtakso.driver.ui.notification.UiNotificationManager;
import ee.mtakso.driver.ui.screens.dialogs.rateme.RateMeDialogDelegate;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class PushDialogDelegate_Factory implements Factory<PushDialogDelegate> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RateMeDialogDelegate> f26399a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UiNotificationManager> f26400b;

    public PushDialogDelegate_Factory(Provider<RateMeDialogDelegate> provider, Provider<UiNotificationManager> provider2) {
        this.f26399a = provider;
        this.f26400b = provider2;
    }

    public static PushDialogDelegate_Factory a(Provider<RateMeDialogDelegate> provider, Provider<UiNotificationManager> provider2) {
        return new PushDialogDelegate_Factory(provider, provider2);
    }

    public static PushDialogDelegate c(RateMeDialogDelegate rateMeDialogDelegate, UiNotificationManager uiNotificationManager) {
        return new PushDialogDelegate(rateMeDialogDelegate, uiNotificationManager);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public PushDialogDelegate get() {
        return c(this.f26399a.get(), this.f26400b.get());
    }
}
