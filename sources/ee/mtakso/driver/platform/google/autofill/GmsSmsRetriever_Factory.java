package ee.mtakso.driver.platform.google.autofill;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class GmsSmsRetriever_Factory implements Factory<GmsSmsRetriever> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f23291a;

    public GmsSmsRetriever_Factory(Provider<Context> provider) {
        this.f23291a = provider;
    }

    public static GmsSmsRetriever_Factory a(Provider<Context> provider) {
        return new GmsSmsRetriever_Factory(provider);
    }

    public static GmsSmsRetriever c(Context context) {
        return new GmsSmsRetriever(context);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public GmsSmsRetriever get() {
        return c(this.f23291a.get());
    }
}
