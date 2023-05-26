package ee.mtakso.driver.deeplink;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DeepLinkParser_Factory implements Factory<DeepLinkParser> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DeepLinkParser_Factory f19994a = new DeepLinkParser_Factory();

        private InstanceHolder() {
        }
    }

    public static DeepLinkParser_Factory a() {
        return InstanceHolder.f19994a;
    }

    public static DeepLinkParser c() {
        return new DeepLinkParser();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DeepLinkParser get() {
        return c();
    }
}
