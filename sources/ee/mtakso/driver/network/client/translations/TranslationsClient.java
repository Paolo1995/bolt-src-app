package ee.mtakso.driver.network.client.translations;

import dagger.Lazy;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationsClient.kt */
/* loaded from: classes3.dex */
public final class TranslationsClient {

    /* renamed from: a  reason: collision with root package name */
    private final Lazy<TranslationApi> f22887a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22888b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22889c;

    @Inject
    public TranslationsClient(Lazy<TranslationApi> api) {
        Intrinsics.f(api, "api");
        this.f22887a = api;
        this.f22888b = "mobile";
        this.f22889c = "Driver apps/strings-en.xml";
    }

    public final Single<ServiceTranslations> a(String languageCode) {
        Intrinsics.f(languageCode, "languageCode");
        return this.f22887a.get().a(this.f22888b, this.f22889c, languageCode);
    }
}
