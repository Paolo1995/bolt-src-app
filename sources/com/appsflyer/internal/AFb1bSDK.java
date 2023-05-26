package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public interface AFb1bSDK {

    /* loaded from: classes.dex */
    public static final class AFa1ySDK {
        public final float AFKeystoreWrapper;
        public final String values;

        public AFa1ySDK(float f8, String str) {
            this.AFKeystoreWrapper = f8;
            this.values = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AFa1ySDK) {
                AFa1ySDK aFa1ySDK = (AFa1ySDK) obj;
                return Intrinsics.a(Float.valueOf(this.AFKeystoreWrapper), Float.valueOf(aFa1ySDK.AFKeystoreWrapper)) && Intrinsics.a(this.values, aFa1ySDK.values);
            }
            return false;
        }

        public final int hashCode() {
            int floatToIntBits = Float.floatToIntBits(this.AFKeystoreWrapper) * 31;
            String str = this.values;
            return floatToIntBits + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("BatteryData(level=");
            sb.append(this.AFKeystoreWrapper);
            sb.append(", charging=");
            sb.append(this.values);
            sb.append(')');
            return sb.toString();
        }
    }

    AFa1ySDK AFInAppEventType(Context context);
}
