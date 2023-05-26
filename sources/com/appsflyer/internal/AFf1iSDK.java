package com.appsflyer.internal;

import android.content.Context;
import android.database.Cursor;
import java.util.Map;

/* loaded from: classes.dex */
public final class AFf1iSDK extends AFf1oSDK {
    private final AFc1vSDK AFInAppEventParameterName;

    public AFf1iSDK(Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("store", "samsung", runnable);
        this.AFInAppEventParameterName = aFc1vSDK;
    }

    @Override // com.appsflyer.internal.AFf1kSDK
    public final void valueOf(Context context) {
        AFInAppEventType(context, new AFb1jSDK<Map<String, Object>>(context, this.AFInAppEventParameterName, "com.sec.android.app.samsungapps.referrer", "FBA3AF4E7757D9016E953FB3EE4671CA2BD9AF725F9A53D52ED4A38EAAA08901") { // from class: com.appsflyer.internal.AFf1iSDK.4
            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x00bd, code lost:
                if (r2 != null) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00d1, code lost:
                if (0 == 0) goto L16;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00d3, code lost:
                r2.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00d6, code lost:
                r0 = ((android.content.pm.PackageItemInfo) r10.values.getPackageManager().resolveContentProvider(r10.AFInAppEventType, 128)).packageName;
                r10.AFInAppEventParameterName.AFInAppEventType.put("api_ver", java.lang.Long.valueOf(com.appsflyer.internal.AFa1cSDK.AFKeystoreWrapper(r10.values, r0)));
                r10.AFInAppEventParameterName.AFInAppEventType.put("api_ver_name", com.appsflyer.internal.AFa1cSDK.values(r10.values, r0));
                r10.AFInAppEventParameterName.AFInAppEventType();
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0111, code lost:
                return r10.AFInAppEventParameterName.AFInAppEventType;
             */
            @Override // com.appsflyer.internal.AFb1jSDK
            /* renamed from: AFKeystoreWrapper */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.Map<java.lang.String, java.lang.Object> values() {
                /*
                    Method dump skipped, instructions count: 280
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1iSDK.AnonymousClass4.values():java.util.Map");
            }

            private static void valueOf(String str, Map<String, Object> map, Cursor cursor) {
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1) {
                    return;
                }
                long j8 = cursor.getLong(columnIndex);
                if (j8 == 0) {
                    return;
                }
                map.put(str, Long.valueOf(j8));
            }

            private static void values(String str, Map<String, Object> map, Cursor cursor) {
                String string;
                int columnIndex = cursor.getColumnIndex(str);
                if (columnIndex == -1 || (string = cursor.getString(columnIndex)) == null) {
                    return;
                }
                map.put(str, string);
            }
        });
    }
}
