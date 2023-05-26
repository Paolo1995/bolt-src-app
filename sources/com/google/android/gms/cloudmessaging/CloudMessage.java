package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
@SafeParcelable.Class(creator = "CloudMessageCreator")
/* loaded from: classes.dex */
public final class CloudMessage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zzb();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @NonNull
    @SafeParcelable.Field(id = 1)
    private Intent zza;
    @GuardedBy("this")
    private Map<String, String> zzb;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MessagePriority {
    }

    @SafeParcelable.Constructor
    public CloudMessage(@NonNull @SafeParcelable.Param(id = 1) Intent intent) {
        this.zza = intent;
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        if ("normal".equals(str)) {
            return 2;
        }
        return 0;
    }

    public final String getCollapseKey() {
        return this.zza.getStringExtra("collapse_key");
    }

    @NonNull
    public final synchronized Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle extras = this.zza.getExtras();
            ArrayMap arrayMap = new ArrayMap();
            if (extras != null) {
                for (String str : extras.keySet()) {
                    Object obj = extras.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
            this.zzb = arrayMap;
        }
        return this.zzb;
    }

    public final String getFrom() {
        return this.zza.getStringExtra("from");
    }

    @NonNull
    public final Intent getIntent() {
        return this.zza;
    }

    public final String getMessageId() {
        String stringExtra = this.zza.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return this.zza.getStringExtra("message_id");
        }
        return stringExtra;
    }

    public final String getMessageType() {
        return this.zza.getStringExtra("message_type");
    }

    public final int getOriginalPriority() {
        String stringExtra = this.zza.getStringExtra("google.original_priority");
        if (stringExtra == null) {
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zza(stringExtra);
    }

    public final int getPriority() {
        String stringExtra = this.zza.getStringExtra("google.delivered_priority");
        if (stringExtra == null) {
            if ("1".equals(this.zza.getStringExtra("google.priority_reduced"))) {
                return 2;
            }
            stringExtra = this.zza.getStringExtra("google.priority");
        }
        return zza(stringExtra);
    }

    public final byte[] getRawData() {
        return this.zza.getByteArrayExtra("rawData");
    }

    public final String getSenderId() {
        return this.zza.getStringExtra("google.c.sender.id");
    }

    public final long getSentTime() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get("google.sent_time");
        } else {
            obj = null;
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 19);
                sb.append("Invalid sent time: ");
                sb.append(valueOf);
                Log.w("CloudMessage", sb.toString());
                return 0L;
            }
        }
        return 0L;
    }

    public final String getTo() {
        return this.zza.getStringExtra("google.to");
    }

    public final int getTtl() {
        Object obj;
        Bundle extras = this.zza.getExtras();
        if (extras != null) {
            obj = extras.get("google.ttl");
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(valueOf.length() + 13);
                sb.append("Invalid TTL: ");
                sb.append(valueOf);
                Log.w("CloudMessage", sb.toString());
                return 0;
            }
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i8, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
