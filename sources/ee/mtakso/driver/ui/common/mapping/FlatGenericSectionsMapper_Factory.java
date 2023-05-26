package ee.mtakso.driver.ui.common.mapping;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class FlatGenericSectionsMapper_Factory implements Factory<FlatGenericSectionsMapper> {

    /* loaded from: classes3.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final FlatGenericSectionsMapper_Factory f26386a = new FlatGenericSectionsMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static FlatGenericSectionsMapper_Factory a() {
        return InstanceHolder.f26386a;
    }

    public static FlatGenericSectionsMapper c() {
        return new FlatGenericSectionsMapper();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public FlatGenericSectionsMapper get() {
        return c();
    }
}
