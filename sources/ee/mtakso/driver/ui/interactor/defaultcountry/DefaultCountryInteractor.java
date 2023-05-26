package ee.mtakso.driver.ui.interactor.defaultcountry;

import android.content.Context;
import android.telephony.TelephonyManager;
import ee.mtakso.driver.service.country.Country;
import eu.bolt.kalev.Kalev;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultCountryInteractor.kt */
/* loaded from: classes3.dex */
public final class DefaultCountryInteractor {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26424a;

    @Inject
    public DefaultCountryInteractor(Context context) {
        Intrinsics.f(context, "context");
        this.f26424a = context;
    }

    private final String a() {
        TelephonyManager telephonyManager;
        String str;
        boolean z7;
        try {
            Object systemService = this.f26424a.getSystemService("phone");
            String str2 = null;
            if (systemService instanceof TelephonyManager) {
                telephonyManager = (TelephonyManager) systemService;
            } else {
                telephonyManager = null;
            }
            if (telephonyManager != null) {
                str = telephonyManager.getNetworkCountryIso();
            } else {
                str = null;
            }
            if (telephonyManager != null) {
                str2 = telephonyManager.getSimCountryIso();
            }
            if (telephonyManager == null) {
                String c8 = c();
                Intrinsics.e(c8, "readContextCountry()");
                return c8;
            }
            boolean z8 = true;
            if (telephonyManager.getPhoneType() != 2) {
                if (str != null && str.length() == 2) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    Locale US = Locale.US;
                    Intrinsics.e(US, "US");
                    String lowerCase = str.toLowerCase(US);
                    Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    return lowerCase;
                }
            }
            if (str2 == null || str2.length() != 2) {
                z8 = false;
            }
            if (z8) {
                Locale US2 = Locale.US;
                Intrinsics.e(US2, "US");
                String lowerCase2 = str2.toLowerCase(US2);
                Intrinsics.e(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                return lowerCase2;
            }
            String c9 = c();
            Intrinsics.e(c9, "readContextCountry()");
            return c9;
        } catch (Exception e8) {
            Kalev.c(e8, "Error fetching country");
            String c10 = c();
            Intrinsics.e(c10, "readContextCountry()");
            return c10;
        }
    }

    private final String c() {
        return this.f26424a.getResources().getConfiguration().locale.getCountry();
    }

    public final Country b() {
        return Country.f24177j.a(a());
    }
}
