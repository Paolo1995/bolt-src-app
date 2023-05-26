package ee.mtakso.driver.helper;

import eu.bolt.driver.core.util.DateTimeFormatter;
import java.text.SimpleDateFormat;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateTimeConverter.kt */
@Singleton
/* loaded from: classes3.dex */
public final class DateTimeConverter {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f20952b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final DateTimeFormatter f20953a;

    /* compiled from: DateTimeConverter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DateTimeConverter(DateTimeFormatter impl) {
        Intrinsics.f(impl, "impl");
        this.f20953a = impl;
    }

    public final String a(Long l8) {
        if (l8 != null) {
            l8.longValue();
            return this.f20953a.a(l8.longValue());
        }
        return "";
    }

    public final String b(Long l8) {
        if (l8 != null) {
            l8.longValue();
            String format = this.f20953a.b("dd.MM.yyyy").format(l8);
            Intrinsics.e(format, "impl.getDateFormat(FORMA…EAR).format(dateTimeInMs)");
            return format;
        }
        return "";
    }

    public final SimpleDateFormat c(String dateFormatStr) {
        Intrinsics.f(dateFormatStr, "dateFormatStr");
        return this.f20953a.b(dateFormatStr);
    }

    public final void d() {
        this.f20953a.d();
    }
}
