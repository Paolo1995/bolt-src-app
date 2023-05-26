package com.google.android.gms.auth.api.proxy;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
@ShowFirstParty
@KeepForSdkWithMembers
/* loaded from: classes.dex */
public class AuthApiStatusCodes extends CommonStatusCodes {
    @ShowFirstParty
    public static final int AUTH_API_ACCESS_FORBIDDEN = 3001;
    @ShowFirstParty
    public static final int AUTH_API_CLIENT_ERROR = 3002;
    @ShowFirstParty
    public static final int AUTH_API_INVALID_CREDENTIALS = 3000;
    @ShowFirstParty
    public static final int AUTH_API_SERVER_ERROR = 3003;
    @ShowFirstParty
    public static final int AUTH_APP_CERT_ERROR = 3006;
    @ShowFirstParty
    public static final int AUTH_TOKEN_ERROR = 3004;
    @ShowFirstParty
    public static final int AUTH_URL_RESOLUTION = 3005;

    private AuthApiStatusCodes() {
    }

    @NonNull
    public static String getStatusCodeString(int i8) {
        switch (i8) {
            case AUTH_API_INVALID_CREDENTIALS /* 3000 */:
                return "AUTH_API_INVALID_CREDENTIALS";
            case AUTH_API_ACCESS_FORBIDDEN /* 3001 */:
                return "AUTH_API_ACCESS_FORBIDDEN";
            case AUTH_API_CLIENT_ERROR /* 3002 */:
                return "AUTH_API_CLIENT_ERROR";
            case AUTH_API_SERVER_ERROR /* 3003 */:
                return "AUTH_API_SERVER_ERROR";
            case AUTH_TOKEN_ERROR /* 3004 */:
                return "AUTH_TOKEN_ERROR";
            case AUTH_URL_RESOLUTION /* 3005 */:
                return "AUTH_URL_RESOLUTION";
            case AUTH_APP_CERT_ERROR /* 3006 */:
                return "AUTH_APP_CERT_ERROR";
            default:
                return CommonStatusCodes.getStatusCodeString(i8);
        }
    }
}
