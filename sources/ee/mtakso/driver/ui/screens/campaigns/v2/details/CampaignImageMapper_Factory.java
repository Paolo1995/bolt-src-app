package ee.mtakso.driver.ui.screens.campaigns.v2.details;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class CampaignImageMapper_Factory implements Factory<CampaignImageMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final CampaignImageMapper_Factory f27475a = new CampaignImageMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static CampaignImageMapper_Factory a() {
        return InstanceHolder.f27475a;
    }

    public static CampaignImageMapper c() {
        return new CampaignImageMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public CampaignImageMapper get() {
        return c();
    }
}
