package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
final class AFa1aSDK extends AFb1jSDK<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AFa1aSDK(Context context, AFc1vSDK aFc1vSDK) {
        super(context, aFc1vSDK, "com.facebook.katana.provider.AttributionIdProvider", "E3F9E1E0CF99D0E56A055BA65E241B3399F7CEA524326B0CDD6EC1327ED0FDC1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.appsflyer.internal.AFb1jSDK
    /* renamed from: AFKeystoreWrapper */
    public String values() {
        Cursor cursor;
        Throwable th;
        try {
            ContentResolver contentResolver = this.values.getContentResolver();
            StringBuilder sb = new StringBuilder("content://");
            sb.append(this.AFInAppEventType);
            cursor = contentResolver.query(Uri.parse(sb.toString()), new String[]{"aid"}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("aid"));
                        cursor.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }

    public final String AFInAppEventType() {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(this.valueOf);
        return (String) super.valueOf();
    }

    @Override // com.appsflyer.internal.AFb1jSDK
    public final /* synthetic */ String valueOf() {
        this.AFKeystoreWrapper.AFKeystoreWrapper().execute(this.valueOf);
        return (String) super.valueOf();
    }
}
