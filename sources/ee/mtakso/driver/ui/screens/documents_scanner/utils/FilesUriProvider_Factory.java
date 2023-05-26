package ee.mtakso.driver.ui.screens.documents_scanner.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FilesUriProvider_Factory implements Factory<FilesUriProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f28489a;

    public FilesUriProvider_Factory(Provider<Context> provider) {
        this.f28489a = provider;
    }

    public static FilesUriProvider_Factory a(Provider<Context> provider) {
        return new FilesUriProvider_Factory(provider);
    }

    public static FilesUriProvider c(Context context) {
        return new FilesUriProvider(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FilesUriProvider get() {
        return c(this.f28489a.get());
    }
}
