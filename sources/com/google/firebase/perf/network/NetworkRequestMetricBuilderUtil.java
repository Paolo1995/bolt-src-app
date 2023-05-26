package com.google.firebase.perf.network;

import androidx.annotation.NonNull;
import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.logging.AndroidLogger;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;

/* loaded from: classes3.dex */
public final class NetworkRequestMetricBuilderUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f16817a = Pattern.compile("(^|.*\\s)datatransport/\\S+ android/($|\\s.*)");

    private NetworkRequestMetricBuilderUtil() {
    }

    public static Long a(@NonNull HttpMessage httpMessage) {
        try {
            Header firstHeader = httpMessage.getFirstHeader("content-length");
            if (firstHeader != null) {
                return Long.valueOf(Long.parseLong(firstHeader.getValue()));
            }
            return null;
        } catch (NumberFormatException unused) {
            AndroidLogger.e().a("The content-length value is not a valid number");
            return null;
        }
    }

    public static String b(@NonNull HttpResponse httpResponse) {
        String value;
        Header firstHeader = httpResponse.getFirstHeader("content-type");
        if (firstHeader != null && (value = firstHeader.getValue()) != null) {
            return value;
        }
        return null;
    }

    public static boolean c(String str) {
        if (str != null && f16817a.matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static void d(NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        if (!networkRequestMetricBuilder.f()) {
            networkRequestMetricBuilder.n();
        }
        networkRequestMetricBuilder.b();
    }
}
