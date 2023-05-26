package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFb1mSDK {
    public final AFb1qSDK AFKeystoreWrapper;
    public final AFb1nSDK valueOf;

    public AFb1mSDK() {
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AFb1mSDK(org.json.JSONObject r13) {
        /*
            r12 = this;
            r12.<init>()
            java.lang.String r0 = "exc_mngr"
            boolean r1 = r13.has(r0)
            java.lang.String r2 = "v1"
            java.lang.String r3 = "data"
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L4a
            org.json.JSONArray r0 = r13.getJSONArray(r0)     // Catch: java.lang.Throwable -> L49
            org.json.JSONObject r0 = r0.optJSONObject(r4)     // Catch: java.lang.Throwable -> L49
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch: java.lang.Throwable -> L49
            java.util.Objects.requireNonNull(r0)     // Catch: java.lang.Throwable -> L49
            r1 = r0
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> L49
            org.json.JSONObject r0 = r0.optJSONObject(r2)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "sdk_ver"
            java.lang.String r7 = r0.getString(r1)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "min"
            r6 = -1
            int r8 = r0.optInt(r1, r6)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "expire"
            int r9 = r0.optInt(r1, r6)     // Catch: java.lang.Throwable -> L49
            java.lang.String r1 = "ttl"
            r10 = -1
            long r10 = r0.optLong(r1, r10)     // Catch: java.lang.Throwable -> L49
            com.appsflyer.internal.AFb1qSDK r0 = new com.appsflyer.internal.AFb1qSDK     // Catch: java.lang.Throwable -> L49
            r6 = r0
            r6.<init>(r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
        L4a:
            r0 = r5
        L4b:
            java.lang.String r1 = "meta_data"
            boolean r6 = r13.has(r1)
            if (r6 == 0) goto L77
            org.json.JSONArray r13 = r13.getJSONArray(r1)     // Catch: java.lang.Throwable -> L77
            org.json.JSONObject r13 = r13.optJSONObject(r4)     // Catch: java.lang.Throwable -> L77
            org.json.JSONObject r13 = r13.optJSONObject(r3)     // Catch: java.lang.Throwable -> L77
            java.util.Objects.requireNonNull(r13)     // Catch: java.lang.Throwable -> L77
            r1 = r13
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Throwable -> L77
            org.json.JSONObject r13 = r13.optJSONObject(r2)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "send_rate"
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r1 = r13.optDouble(r1, r2)     // Catch: java.lang.Throwable -> L77
            com.appsflyer.internal.AFb1nSDK r13 = new com.appsflyer.internal.AFb1nSDK     // Catch: java.lang.Throwable -> L77
            r13.<init>(r1)     // Catch: java.lang.Throwable -> L77
            r5 = r13
        L77:
            r12.AFKeystoreWrapper = r0
            r12.valueOf = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1mSDK.<init>(org.json.JSONObject):void");
    }

    public static boolean valueOf(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean values(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AFb1qSDK aFb1qSDK = this.AFKeystoreWrapper;
        if (aFb1qSDK != null) {
            return aFb1qSDK.hashCode();
        }
        return 0;
    }
}
