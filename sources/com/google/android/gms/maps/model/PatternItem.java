package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
@SafeParcelable.Class(creator = "PatternItemCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public class PatternItem extends AbstractSafeParcelable {
    @SafeParcelable.Field(getter = "getType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getLength", id = 3)
    private final Float zzc;
    private static final String zza = PatternItem.class.getSimpleName();
    @NonNull
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzj();

    @SafeParcelable.Constructor
    public PatternItem(@SafeParcelable.Param(id = 2) int i8, @SafeParcelable.Param(id = 3) Float f8) {
        boolean z7 = false;
        if (i8 == 1 || (f8 != null && f8.floatValue() >= 0.0f)) {
            z7 = true;
        }
        Preconditions.checkArgument(z7, "Invalid PatternItem: type=" + i8 + " length=" + f8);
        this.zzb = i8;
        this.zzc = f8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zza(List list) {
        PatternItem dash;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PatternItem patternItem = (PatternItem) it.next();
            if (patternItem == null) {
                patternItem = null;
            } else {
                int i8 = patternItem.zzb;
                boolean z7 = false;
                if (i8 != 0) {
                    if (i8 != 1) {
                        if (i8 != 2) {
                            Log.w(zza, "Unknown PatternItem type: " + i8);
                        } else {
                            if (patternItem.zzc != null) {
                                z7 = true;
                            }
                            Preconditions.checkState(z7, "length must not be null.");
                            dash = new Gap(patternItem.zzc.floatValue());
                        }
                    } else {
                        patternItem = new Dot();
                    }
                } else {
                    if (patternItem.zzc != null) {
                        z7 = true;
                    }
                    Preconditions.checkState(z7, "length must not be null.");
                    dash = new Dash(patternItem.zzc.floatValue());
                }
                patternItem = dash;
            }
            arrayList.add(patternItem);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        if (this.zzb == patternItem.zzb && Objects.equal(this.zzc, patternItem.zzc)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc);
    }

    @NonNull
    public String toString() {
        int i8 = this.zzb;
        Float f8 = this.zzc;
        return "[PatternItem: type=" + i8 + " length=" + f8 + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i8) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeFloatObject(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
