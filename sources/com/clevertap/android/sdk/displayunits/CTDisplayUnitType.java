package com.clevertap.android.sdk.displayunits;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public enum CTDisplayUnitType {
    SIMPLE("simple"),
    SIMPLE_WITH_IMAGE("simple-image"),
    CAROUSEL("carousel"),
    CAROUSEL_WITH_IMAGE("carousel-image"),
    MESSAGE_WITH_ICON("message-icon"),
    CUSTOM_KEY_VALUE("custom-key-value");
    

    /* renamed from: f  reason: collision with root package name */
    public final String f11142f;

    CTDisplayUnitType(String str) {
        this.f11142f = str;
    }

    public static CTDisplayUnitType a(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c8 = 65535;
            switch (str.hashCode()) {
                case -1799711058:
                    if (str.equals("carousel-image")) {
                        c8 = 0;
                        break;
                    }
                    break;
                case -1332589953:
                    if (str.equals("message-icon")) {
                        c8 = 1;
                        break;
                    }
                    break;
                case -902286926:
                    if (str.equals("simple")) {
                        c8 = 2;
                        break;
                    }
                    break;
                case -876980953:
                    if (str.equals("custom-key-value")) {
                        c8 = 3;
                        break;
                    }
                    break;
                case 2908512:
                    if (str.equals("carousel")) {
                        c8 = 4;
                        break;
                    }
                    break;
                case 1818845568:
                    if (str.equals("simple-image")) {
                        c8 = 5;
                        break;
                    }
                    break;
            }
            switch (c8) {
                case 0:
                    return CAROUSEL_WITH_IMAGE;
                case 1:
                    return MESSAGE_WITH_ICON;
                case 2:
                    return SIMPLE;
                case 3:
                    return CUSTOM_KEY_VALUE;
                case 4:
                    return CAROUSEL;
                case 5:
                    return SIMPLE_WITH_IMAGE;
            }
        }
        Log.d("DisplayUnit : ", "Unsupported Display Unit Type");
        return null;
    }

    @Override // java.lang.Enum
    @NonNull
    public String toString() {
        return this.f11142f;
    }
}
