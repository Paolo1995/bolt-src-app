package eu.bolt.driver.core.util;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes5.dex */
public final class DateTimeFormatter_Factory implements Factory<DateTimeFormatter> {

    /* loaded from: classes5.dex */
    private static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final DateTimeFormatter_Factory f41303a = new DateTimeFormatter_Factory();

        private InstanceHolder() {
        }
    }

    public static DateTimeFormatter_Factory a() {
        return InstanceHolder.f41303a;
    }

    public static DateTimeFormatter c() {
        return new DateTimeFormatter();
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DateTimeFormatter get() {
        return c();
    }
}
