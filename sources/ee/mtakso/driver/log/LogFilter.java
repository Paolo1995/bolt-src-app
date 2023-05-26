package ee.mtakso.driver.log;

/* compiled from: LogFilter.kt */
/* loaded from: classes3.dex */
public final class LogFilter {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r0.equals("order state") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r0.equals("app state") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r0.equals("splash") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r0.equals("driver state") == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
        if (r6.equals("network") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
        if (r6.equals("polling result") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
        if (r6.equals("activity lifecycle") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
        if (r6.equals("driver state") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
        if (r6.equals("driver put offline") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007f, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r0.equals("location") == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(eu.bolt.kalev.LogEntry r6) {
        /*
            r5 = this;
            java.lang.String r0 = "entry"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = r6.f()
            java.lang.String r1 = "driver state"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L44
            int r4 = r0.hashCode()
            switch(r4) {
                case -1603685735: goto L3b;
                case -895866265: goto L32;
                case 38893010: goto L29;
                case 169618751: goto L20;
                case 1901043637: goto L17;
                default: goto L16;
            }
        L16:
            goto L44
        L17:
            java.lang.String r4 = "location"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L42
            goto L44
        L20:
            java.lang.String r4 = "order state"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L42
            goto L44
        L29:
            java.lang.String r4 = "app state"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L42
            goto L44
        L32:
            java.lang.String r4 = "splash"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L42
            goto L44
        L3b:
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L42
            goto L44
        L42:
            r0 = 1
            goto L45
        L44:
            r0 = 0
        L45:
            if (r0 == 0) goto L48
            return r3
        L48:
            java.lang.String r6 = r6.d()
            int r0 = r6.hashCode()
            switch(r0) {
                case -2044779046: goto L76;
                case -1603685735: goto L6f;
                case 29865881: goto L66;
                case 1668975386: goto L5d;
                case 1843485230: goto L54;
                default: goto L53;
            }
        L53:
            goto L81
        L54:
            java.lang.String r0 = "network"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L7f
            goto L81
        L5d:
            java.lang.String r0 = "polling result"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L7f
            goto L81
        L66:
            java.lang.String r0 = "activity lifecycle"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L7f
            goto L81
        L6f:
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L7f
            goto L81
        L76:
            java.lang.String r0 = "driver put offline"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L7f
            goto L81
        L7f:
            r6 = 1
            goto L82
        L81:
            r6 = 0
        L82:
            if (r6 == 0) goto L85
            return r3
        L85:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.log.LogFilter.a(eu.bolt.kalev.LogEntry):boolean");
    }
}
