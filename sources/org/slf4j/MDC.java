package org.slf4j;

import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes5.dex */
public class MDC {

    /* renamed from: a  reason: collision with root package name */
    static MDCAdapter f52818a;

    static {
        try {
            f52818a = a();
        } catch (Exception e8) {
            Util.d("MDC binding unsuccessful.", e8);
        } catch (NoClassDefFoundError e9) {
            f52818a = new NOPMDCAdapter();
            String message = e9.getMessage();
            if (message != null && message.contains("StaticMDCBinder")) {
                Util.c("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
                Util.c("Defaulting to no-operation MDCAdapter implementation.");
                Util.c("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
                return;
            }
            throw e9;
        }
    }

    private MDC() {
    }

    private static MDCAdapter a() throws NoClassDefFoundError {
        try {
            return StaticMDCBinder.getSingleton().getMDCA();
        } catch (NoSuchMethodError unused) {
            return StaticMDCBinder.SINGLETON.getMDCA();
        }
    }

    public static void b() {
        MDCAdapter mDCAdapter = f52818a;
        if (mDCAdapter != null) {
            mDCAdapter.clear();
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static Map<String, String> c() {
        MDCAdapter mDCAdapter = f52818a;
        if (mDCAdapter != null) {
            return mDCAdapter.a();
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }

    public static void d(Map<String, String> map) {
        MDCAdapter mDCAdapter = f52818a;
        if (mDCAdapter != null) {
            mDCAdapter.b(map);
            return;
        }
        throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
}
