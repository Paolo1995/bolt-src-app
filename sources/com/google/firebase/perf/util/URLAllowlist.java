package com.google.firebase.perf.util;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.google.firebase.perf.logging.AndroidLogger;
import java.net.URI;

/* loaded from: classes3.dex */
public class URLAllowlist {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f16900a;

    public static boolean a(@NonNull URI uri, @NonNull Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier == 0) {
            return true;
        }
        AndroidLogger.e().f("Detected domain allowlist, only allowlisted domains will be measured.");
        if (f16900a == null) {
            f16900a = resources.getStringArray(identifier);
        }
        String host = uri.getHost();
        if (host == null) {
            return true;
        }
        for (String str : f16900a) {
            if (host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
