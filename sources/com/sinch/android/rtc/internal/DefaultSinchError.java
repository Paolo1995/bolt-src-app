package com.sinch.android.rtc.internal;

import com.sinch.android.rtc.ErrorType;
import com.sinch.android.rtc.SinchError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DefaultSinchError implements SinchError {
    private final int code;
    private final ErrorType errorType;
    private Map<String, String> extras;
    private final String message;

    @Deprecated
    private DefaultSinchError(int i8, String str, int i9) {
        this.code = i8;
        this.message = str;
        this.extras = new HashMap();
        this.errorType = (i9 < 0 || i9 >= ErrorType.values().length) ? ErrorType.GENERIC : ErrorType.values()[i9];
    }

    public DefaultSinchError(int i8, String str, int i9, Map<String, String> map) {
        this.code = i8;
        this.message = str;
        this.extras = map;
        if (i9 >= 0 && i9 < ErrorType.values().length) {
            this.errorType = ErrorType.values()[i9];
            return;
        }
        throw new IllegalArgumentException("The error type " + i9 + " is invalid");
    }

    private DefaultSinchError(ErrorType errorType, int i8, String str) {
        this(i8, str, errorType.ordinal());
    }

    public static SinchError genericError(String str) {
        return new DefaultSinchError(ErrorType.GENERIC, 1, str);
    }

    public static SinchError googlePlayServicesNotAvailable() {
        return new DefaultSinchError(ErrorType.GENERIC, (int) InternalErrorCodes.FcmServiceIsNotAvailable, "Google Play Services are not available!");
    }

    public static SinchError huaweiMobileServicesNotAvailable() {
        return new DefaultSinchError(ErrorType.GENERIC, (int) InternalErrorCodes.HmsServiceIsNotAvailable, "Huawei Mobile Services are not available!");
    }

    @Override // com.sinch.android.rtc.SinchError
    public int getCode() {
        return this.code;
    }

    @Override // com.sinch.android.rtc.SinchError
    public ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // com.sinch.android.rtc.SinchError
    public Map<String, String> getExtras() {
        return this.extras;
    }

    @Override // com.sinch.android.rtc.SinchError
    public String getMessage() {
        return (this.message.isEmpty() && this.extras.containsKey("serverMessage")) ? this.extras.get("serverMessage") : this.message;
    }

    public String toString() {
        return "SinchError[errorType=" + this.errorType + ", code=" + this.code + ", message='" + this.message + "', data=" + this.extras + ']';
    }
}
