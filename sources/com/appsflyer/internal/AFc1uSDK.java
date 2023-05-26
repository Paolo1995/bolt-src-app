package com.appsflyer.internal;

import android.util.Base64;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AFc1uSDK {
    public static final AFa1xSDK AFa1xSDK = new AFa1xSDK(null);
    public final String AFInAppEventParameterName;
    public int AFKeystoreWrapper;
    public final String valueOf;
    public final String values;

    /* loaded from: classes.dex */
    public static final class AFa1xSDK {
        private AFa1xSDK() {
        }

        public /* synthetic */ AFa1xSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static String AFInAppEventParameterName(String str, String str2) {
            CharSequence Y0;
            String substring = str.substring(str2.length());
            Intrinsics.e(substring, "");
            Y0 = StringsKt__StringsKt.Y0(substring);
            String obj = Y0.toString();
            Intrinsics.f(obj, "");
            Charset charset = Charsets.f51135b;
            byte[] bytes = obj.getBytes(charset);
            Intrinsics.e(bytes, "");
            Intrinsics.f(bytes, "");
            byte[] decode = Base64.decode(bytes, 2);
            Intrinsics.e(decode, "");
            return new String(decode, charset);
        }

        public static AFc1uSDK AFInAppEventType(String str) {
            List<String> C0;
            boolean L;
            boolean L2;
            boolean L3;
            boolean L4;
            CharSequence Y0;
            Intrinsics.f(str, "");
            C0 = StringsKt__StringsKt.C0(str, new String[]{"\n"}, false, 0, 6, null);
            if (C0.size() != 4) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            Integer num = null;
            for (String str5 : C0) {
                L = StringsKt__StringsJVMKt.L(str5, "label=", false, 2, null);
                if (L) {
                    str2 = AFInAppEventParameterName(str5, "label=");
                } else {
                    L2 = StringsKt__StringsJVMKt.L(str5, "hashName=", false, 2, null);
                    if (L2) {
                        str3 = AFInAppEventParameterName(str5, "hashName=");
                    } else {
                        L3 = StringsKt__StringsJVMKt.L(str5, "stackTrace=", false, 2, null);
                        if (L3) {
                            str4 = AFInAppEventParameterName(str5, "stackTrace=");
                        } else {
                            L4 = StringsKt__StringsJVMKt.L(str5, "c=", false, 2, null);
                            if (!L4) {
                                break;
                            }
                            String substring = str5.substring(2);
                            Intrinsics.e(substring, "");
                            Y0 = StringsKt__StringsKt.Y0(substring);
                            num = Integer.valueOf(Integer.parseInt(Y0.toString()));
                        }
                    }
                }
            }
            if (valueOf(num, str2, str3, str4)) {
                return null;
            }
            Intrinsics.c(str2);
            Intrinsics.c(str3);
            Intrinsics.c(str4);
            Intrinsics.c(num);
            return new AFc1uSDK(str2, str3, str4, num.intValue());
        }

        private static boolean valueOf(Integer num, String... strArr) {
            boolean z7;
            boolean z8;
            if (num == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            int length = strArr.length;
            for (int i8 = 0; i8 < 3; i8++) {
                String str = strArr[i8];
                if (!z7) {
                    if (str != null && str.length() != 0) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    if (!z8) {
                        z7 = false;
                    }
                }
                z7 = true;
            }
            return z7;
        }
    }

    public AFc1uSDK(String str, String str2, String str3, int i8) {
        Intrinsics.f(str, "");
        Intrinsics.f(str2, "");
        Intrinsics.f(str3, "");
        this.valueOf = str;
        this.AFInAppEventParameterName = str2;
        this.values = str3;
        this.AFKeystoreWrapper = i8;
    }

    public final JSONObject AFKeystoreWrapper() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("label", this.valueOf);
        jSONObject.put("hash_name", this.AFInAppEventParameterName);
        jSONObject.put("st", this.values);
        jSONObject.put("c", String.valueOf(this.AFKeystoreWrapper));
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AFc1uSDK) {
            AFc1uSDK aFc1uSDK = (AFc1uSDK) obj;
            return Intrinsics.a(this.valueOf, aFc1uSDK.valueOf) && Intrinsics.a(this.AFInAppEventParameterName, aFc1uSDK.AFInAppEventParameterName) && Intrinsics.a(this.values, aFc1uSDK.values) && this.AFKeystoreWrapper == aFc1uSDK.AFKeystoreWrapper;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.valueOf.hashCode() * 31) + this.AFInAppEventParameterName.hashCode()) * 31) + this.values.hashCode()) * 31) + this.AFKeystoreWrapper;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AFc1uSDK(AFKeystoreWrapper=");
        sb.append(this.valueOf);
        sb.append(", valueOf=");
        sb.append(this.AFInAppEventParameterName);
        sb.append(", values=");
        sb.append(this.values);
        sb.append(", AFInAppEventParameterName=");
        sb.append(this.AFKeystoreWrapper);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ AFc1uSDK(String str, String str2, String str3, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i9 & 8) != 0 ? 1 : i8);
    }
}
