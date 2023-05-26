package com.sinch.android.rtc;

import java.util.Map;

/* loaded from: classes3.dex */
public interface SinchError {
    int getCode();

    ErrorType getErrorType();

    Map<String, String> getExtras();

    String getMessage();
}
