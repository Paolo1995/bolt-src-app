package com.appsflyer.internal;

import android.util.Base64;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;

/* loaded from: classes.dex */
public interface AFc1oSDK {

    /* loaded from: classes.dex */
    public static final class AFa1xSDK {
        public final String AFInAppEventParameterName;
        public Boolean AFInAppEventType;
        public final Boolean valueOf;

        public AFa1xSDK() {
        }

        public AFa1xSDK(String str, Boolean bool) {
            this.AFInAppEventParameterName = str;
            this.valueOf = bool;
        }

        public static boolean AFInAppEventParameterName(HttpURLConnection httpURLConnection) {
            Intrinsics.f(httpURLConnection, "");
            return httpURLConnection.getResponseCode() / 100 == 2;
        }

        public static double AFInAppEventType(String str) throws ParseException {
            Intrinsics.f(str, "");
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                Number parse = NumberFormat.getInstance(Locale.getDefault()).parse(str);
                if (parse != null) {
                    return parse.doubleValue();
                }
                throw new ParseException("Failed parse String into number", 0);
            }
        }

        public static JSONArray AFKeystoreWrapper(List<AFc1uSDK> list) {
            int v7;
            Intrinsics.f(list, "");
            v7 = CollectionsKt__IterablesKt.v(list, 10);
            ArrayList arrayList = new ArrayList(v7);
            for (AFc1uSDK aFc1uSDK : list) {
                arrayList.add(aFc1uSDK.AFKeystoreWrapper());
            }
            return new JSONArray((Collection) arrayList);
        }

        public static String valueOf(String str) {
            Intrinsics.f(str, "");
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes(Charsets.f51135b);
            Intrinsics.e(bytes, "");
            byte[] digest = messageDigest.digest(bytes);
            Intrinsics.e(digest, "");
            String str2 = "";
            for (byte b8 : digest) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b8)}, 1));
                Intrinsics.e(format, "");
                sb.append(format);
                str2 = sb.toString();
            }
            return str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
            r2 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
            r4 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int AFInAppEventParameterName(java.lang.String r4) {
            /*
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.f(r4, r0)
                kotlin.text.Regex r0 = new kotlin.text.Regex
                java.lang.String r1 = "(\\d+).?(\\d+)?.?(\\d+)?(-rc\\d+)?(_.*)?"
                r0.<init>(r1)
                kotlin.text.MatchResult r4 = r0.e(r4)
                if (r4 == 0) goto L72
                kotlin.text.MatchGroupCollection r0 = r4.a()
                r1 = 1
                kotlin.text.MatchGroup r0 = r0.get(r1)
                r1 = 0
                if (r0 == 0) goto L2f
                java.lang.String r0 = r0.b()
                if (r0 == 0) goto L2f
                java.lang.Integer r0 = kotlin.text.StringsKt.m(r0)
                if (r0 == 0) goto L2f
                int r0 = r0.intValue()
                goto L30
            L2f:
                r0 = 0
            L30:
                r2 = 1000000(0xf4240, float:1.401298E-39)
                int r0 = r0 * r2
                kotlin.text.MatchGroupCollection r2 = r4.a()
                r3 = 2
                kotlin.text.MatchGroup r2 = r2.get(r3)
                if (r2 == 0) goto L51
                java.lang.String r2 = r2.b()
                if (r2 == 0) goto L51
                java.lang.Integer r2 = kotlin.text.StringsKt.m(r2)
                if (r2 == 0) goto L51
                int r2 = r2.intValue()
                goto L52
            L51:
                r2 = 0
            L52:
                int r2 = r2 * 1000
                int r0 = r0 + r2
                kotlin.text.MatchGroupCollection r4 = r4.a()
                r2 = 3
                kotlin.text.MatchGroup r4 = r4.get(r2)
                if (r4 == 0) goto L70
                java.lang.String r4 = r4.b()
                if (r4 == 0) goto L70
                java.lang.Integer r4 = kotlin.text.StringsKt.m(r4)
                if (r4 == 0) goto L70
                int r1 = r4.intValue()
            L70:
                int r0 = r0 + r1
                return r0
            L72:
                r4 = -1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1oSDK.AFa1xSDK.AFInAppEventParameterName(java.lang.String):int");
        }

        public static String AFKeystoreWrapper(String str) {
            Intrinsics.f(str, "");
            byte[] bytes = str.getBytes(Charsets.f51135b);
            Intrinsics.e(bytes, "");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.e(encodeToString, "");
            return encodeToString;
        }
    }

    void values(byte[] bArr, Map<String, String> map, int i8);
}
