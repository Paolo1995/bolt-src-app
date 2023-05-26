package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i8) {
        zzb(parcel, i8);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i8, @NonNull BigDecimal bigDecimal, boolean z7) {
        if (bigDecimal == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        zzb(parcel, zza);
    }

    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i8, @NonNull BigDecimal[] bigDecimalArr, boolean z7) {
        if (bigDecimalArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i9 = 0; i9 < length; i9++) {
            parcel.writeByteArray(bigDecimalArr[i9].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i9].scale());
        }
        zzb(parcel, zza);
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i8, @NonNull BigInteger bigInteger, boolean z7) {
        if (bigInteger == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeByteArray(bigInteger.toByteArray());
        zzb(parcel, zza);
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i8, @NonNull BigInteger[] bigIntegerArr, boolean z7) {
        if (bigIntegerArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzb(parcel, zza);
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i8, boolean z7) {
        zzc(parcel, i8, 4);
        parcel.writeInt(z7 ? 1 : 0);
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i8, @NonNull boolean[] zArr, boolean z7) {
        if (zArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeBooleanArray(zArr);
        zzb(parcel, zza);
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i8, @NonNull List<Boolean> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(list.get(i9).booleanValue() ? 1 : 0);
        }
        zzb(parcel, zza);
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i8, @NonNull Boolean bool, boolean z7) {
        if (bool == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        zzc(parcel, i8, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static void writeBundle(@NonNull Parcel parcel, int i8, @NonNull Bundle bundle, boolean z7) {
        if (bundle == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeBundle(bundle);
        zzb(parcel, zza);
    }

    public static void writeByte(@NonNull Parcel parcel, int i8, byte b8) {
        zzc(parcel, i8, 4);
        parcel.writeInt(b8);
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i8, @NonNull byte[] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeByteArray(bArr);
        zzb(parcel, zza);
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i8, @NonNull byte[][] bArr, boolean z7) {
        if (bArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzb(parcel, zza);
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<byte[]> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            parcel.writeByteArray(sparseArray.valueAt(i9));
        }
        zzb(parcel, zza);
    }

    public static void writeChar(@NonNull Parcel parcel, int i8, char c8) {
        zzc(parcel, i8, 4);
        parcel.writeInt(c8);
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i8, @NonNull char[] cArr, boolean z7) {
        if (cArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeCharArray(cArr);
        zzb(parcel, zza);
    }

    public static void writeDouble(@NonNull Parcel parcel, int i8, double d8) {
        zzc(parcel, i8, 8);
        parcel.writeDouble(d8);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i8, @NonNull double[] dArr, boolean z7) {
        if (dArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeDoubleArray(dArr);
        zzb(parcel, zza);
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i8, @NonNull List<Double> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeDouble(list.get(i9).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i8, @NonNull Double d8, boolean z7) {
        if (d8 == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        zzc(parcel, i8, 8);
        parcel.writeDouble(d8.doubleValue());
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<Double> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            parcel.writeDouble(sparseArray.valueAt(i9).doubleValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloat(@NonNull Parcel parcel, int i8, float f8) {
        zzc(parcel, i8, 4);
        parcel.writeFloat(f8);
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i8, @NonNull float[] fArr, boolean z7) {
        if (fArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeFloatArray(fArr);
        zzb(parcel, zza);
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i8, @NonNull List<Float> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeFloat(list.get(i9).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i8, @NonNull Float f8, boolean z7) {
        if (f8 == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        zzc(parcel, i8, 4);
        parcel.writeFloat(f8.floatValue());
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<Float> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            parcel.writeFloat(sparseArray.valueAt(i9).floatValue());
        }
        zzb(parcel, zza);
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i8, @NonNull IBinder iBinder, boolean z7) {
        if (iBinder == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeStrongBinder(iBinder);
        zzb(parcel, zza);
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i8, @NonNull IBinder[] iBinderArr, boolean z7) {
        if (iBinderArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeBinderArray(iBinderArr);
        zzb(parcel, zza);
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i8, @NonNull List<IBinder> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeBinderList(list);
        zzb(parcel, zza);
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<IBinder> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            parcel.writeStrongBinder(sparseArray.valueAt(i9));
        }
        zzb(parcel, zza);
    }

    public static void writeInt(@NonNull Parcel parcel, int i8, int i9) {
        zzc(parcel, i8, 4);
        parcel.writeInt(i9);
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i8, @NonNull int[] iArr, boolean z7) {
        if (iArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeIntArray(iArr);
        zzb(parcel, zza);
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i8, @NonNull List<Integer> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(list.get(i9).intValue());
        }
        zzb(parcel, zza);
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i8, @NonNull Integer num, boolean z7) {
        if (num == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        zzc(parcel, i8, 4);
        parcel.writeInt(num.intValue());
    }

    public static void writeList(@NonNull Parcel parcel, int i8, @NonNull List list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeList(list);
        zzb(parcel, zza);
    }

    public static void writeLong(@NonNull Parcel parcel, int i8, long j8) {
        zzc(parcel, i8, 8);
        parcel.writeLong(j8);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i8, @NonNull long[] jArr, boolean z7) {
        if (jArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeLongArray(jArr);
        zzb(parcel, zza);
    }

    public static void writeLongList(@NonNull Parcel parcel, int i8, @NonNull List<Long> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeLong(list.get(i9).longValue());
        }
        zzb(parcel, zza);
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i8, @NonNull Long l8, boolean z7) {
        if (l8 == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        zzc(parcel, i8, 8);
        parcel.writeLong(l8.longValue());
    }

    public static void writeParcel(@NonNull Parcel parcel, int i8, @NonNull Parcel parcel2, boolean z7) {
        if (parcel2 == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        zzb(parcel, zza);
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i8, @NonNull Parcel[] parcelArr, boolean z7) {
        if (parcelArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i8, @NonNull List<Parcel> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            Parcel parcel2 = list.get(i9);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<Parcel> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            Parcel valueAt = sparseArray.valueAt(i9);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzb(parcel, zza);
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i8, @NonNull Parcelable parcelable, int i9, boolean z7) {
        if (parcelable == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcelable.writeToParcel(parcel, i9);
        zzb(parcel, zza);
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i8, @NonNull PendingIntent pendingIntent, boolean z7) {
        if (pendingIntent == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
        zzb(parcel, zza);
    }

    public static void writeShort(@NonNull Parcel parcel, int i8, short s7) {
        zzc(parcel, i8, 4);
        parcel.writeInt(s7);
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i8, @NonNull SparseBooleanArray sparseBooleanArray, boolean z7) {
        if (sparseBooleanArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        zzb(parcel, zza);
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i8, @NonNull SparseIntArray sparseIntArray, boolean z7) {
        if (sparseIntArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseIntArray.keyAt(i9));
            parcel.writeInt(sparseIntArray.valueAt(i9));
        }
        zzb(parcel, zza);
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i8, @NonNull SparseLongArray sparseLongArray, boolean z7) {
        if (sparseLongArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseLongArray.keyAt(i9));
            parcel.writeLong(sparseLongArray.valueAt(i9));
        }
        zzb(parcel, zza);
    }

    public static void writeString(@NonNull Parcel parcel, int i8, @NonNull String str, boolean z7) {
        if (str == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeString(str);
        zzb(parcel, zza);
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i8, @NonNull String[] strArr, boolean z7) {
        if (strArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeStringArray(strArr);
        zzb(parcel, zza);
    }

    public static void writeStringList(@NonNull Parcel parcel, int i8, @NonNull List<String> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeStringList(list);
        zzb(parcel, zza);
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<String> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            parcel.writeString(sparseArray.valueAt(i9));
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i8, @NonNull T[] tArr, int i9, boolean z7) {
        if (tArr == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        parcel.writeInt(tArr.length);
        for (T t7 : tArr) {
            if (t7 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t7, i9);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i8, @NonNull List<T> list, boolean z7) {
        if (list == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = list.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            T t7 = list.get(i9);
            if (t7 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t7, 0);
            }
        }
        zzb(parcel, zza);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i8, @NonNull SparseArray<T> sparseArray, boolean z7) {
        if (sparseArray == null) {
            if (z7) {
                zzc(parcel, i8, 0);
                return;
            }
            return;
        }
        int zza = zza(parcel, i8);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i9 = 0; i9 < size; i9++) {
            parcel.writeInt(sparseArray.keyAt(i9));
            T valueAt = sparseArray.valueAt(i9);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, valueAt, 0);
            }
        }
        zzb(parcel, zza);
    }

    private static int zza(Parcel parcel, int i8) {
        parcel.writeInt(i8 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i8) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i8 - 4);
        parcel.writeInt(dataPosition - i8);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i8, int i9) {
        parcel.writeInt(i8 | (i9 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i8) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i8);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
