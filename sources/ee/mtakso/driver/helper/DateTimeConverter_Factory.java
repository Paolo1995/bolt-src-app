package ee.mtakso.driver.helper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import eu.bolt.driver.core.util.DateTimeFormatter;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes3.dex */
public final class DateTimeConverter_Factory implements Factory<DateTimeConverter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DateTimeFormatter> f20954a;

    public DateTimeConverter_Factory(Provider<DateTimeFormatter> provider) {
        this.f20954a = provider;
    }

    public static DateTimeConverter_Factory a(Provider<DateTimeFormatter> provider) {
        return new DateTimeConverter_Factory(provider);
    }

    public static DateTimeConverter c(DateTimeFormatter dateTimeFormatter) {
        return new DateTimeConverter(dateTimeFormatter);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public DateTimeConverter get() {
        return c(this.f20954a.get());
    }
}
