package com.google.android.gms.auth.api.phone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p000authapiphone.zzr;
import com.google.android.gms.internal.p000authapiphone.zzv;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
/* loaded from: classes.dex */
public final class SmsCodeRetriever {
    @NonNull
    public static final String EXTRA_SMS_CODE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE";
    @NonNull
    public static final String EXTRA_SMS_CODE_LINE = "com.google.android.gms.auth.api.phone.EXTRA_SMS_CODE_LINE";
    @NonNull
    public static final String EXTRA_STATUS = "com.google.android.gms.auth.api.phone.EXTRA_STATUS";
    @NonNull
    public static final String SMS_CODE_RETRIEVED_ACTION = "com.google.android.gms.auth.api.phone.SMS_CODE_RETRIEVED";

    private SmsCodeRetriever() {
    }

    @NonNull
    public static SmsCodeAutofillClient getAutofillClient(@NonNull Activity activity) {
        return new zzr(activity);
    }

    @NonNull
    public static SmsCodeBrowserClient getBrowserClient(@NonNull Activity activity) {
        return new zzv(activity);
    }

    @NonNull
    public static SmsCodeAutofillClient getAutofillClient(@NonNull Context context) {
        return new zzr(context);
    }

    @NonNull
    public static SmsCodeBrowserClient getBrowserClient(@NonNull Context context) {
        return new zzv(context);
    }
}
