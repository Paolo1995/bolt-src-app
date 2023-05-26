package com.google.firebase.messaging;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public final class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static final long f16456a = TimeUnit.MINUTES.toMillis(3);

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes3.dex */
    public static final class MessagePayloadKeys {
        private MessagePayloadKeys() {
        }

        public static ArrayMap<String, String> a(Bundle bundle) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        arrayMap.put(str, str2);
                    }
                }
            }
            return arrayMap;
        }
    }

    private Constants() {
    }
}
