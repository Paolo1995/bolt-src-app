package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @NonNull
    @KeepForSdk
    public static <T> T[] concat(@NonNull T[]... tArr) {
        if (tArr.length != 0) {
            int i8 = 0;
            for (T[] tArr2 : tArr) {
                i8 += tArr2.length;
            }
            T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i8);
            int length = tArr[0].length;
            for (int i9 = 1; i9 < tArr.length; i9++) {
                T[] tArr4 = tArr[i9];
                int length2 = tArr4.length;
                System.arraycopy(tArr4, 0, tArr3, length, length2);
                length += length2;
            }
            return tArr3;
        }
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
    }

    @NonNull
    @KeepForSdk
    public static byte[] concatByteArrays(@NonNull byte[]... bArr) {
        if (bArr.length != 0) {
            int i8 = 0;
            for (byte[] bArr2 : bArr) {
                i8 += bArr2.length;
            }
            byte[] copyOf = Arrays.copyOf(bArr[0], i8);
            int length = bArr[0].length;
            for (int i9 = 1; i9 < bArr.length; i9++) {
                byte[] bArr3 = bArr[i9];
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, copyOf, length, length2);
                length += length2;
            }
            return copyOf;
        }
        return new byte[0];
    }

    @KeepForSdk
    public static boolean contains(@NonNull int[] iArr, int i8) {
        if (iArr == null) {
            return false;
        }
        for (int i9 : iArr) {
            if (i9 == i8) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @KeepForSdk
    public static <T> T[] removeAll(@NonNull T[] tArr, @NonNull T... tArr2) {
        int length;
        int i8;
        if (tArr == null) {
            return null;
        }
        if (tArr2 != null && (length = tArr2.length) != 0) {
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
            if (length == 1) {
                i8 = 0;
                for (T t7 : tArr) {
                    if (!Objects.equal(tArr2[0], t7)) {
                        tArr3[i8] = t7;
                        i8++;
                    }
                }
            } else {
                int i9 = 0;
                for (T t8 : tArr) {
                    if (!contains(tArr2, t8)) {
                        tArr3[i9] = t8;
                        i9++;
                    }
                }
                i8 = i9;
            }
            if (tArr3 == null) {
                return null;
            }
            if (i8 == tArr3.length) {
                return tArr3;
            }
            return (T[]) Arrays.copyOf(tArr3, i8);
        }
        return (T[]) Arrays.copyOf(tArr, tArr.length);
    }

    @NonNull
    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(@NonNull T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t7 : tArr) {
            arrayList.add(t7);
        }
        return arrayList;
    }

    @NonNull
    @KeepForSdk
    public static int[] toPrimitiveArray(@NonNull Collection<Integer> collection) {
        int i8 = 0;
        if (collection != null && !collection.isEmpty()) {
            int[] iArr = new int[collection.size()];
            for (Integer num : collection) {
                iArr[i8] = num.intValue();
                i8++;
            }
            return iArr;
        }
        return new int[0];
    }

    @KeepForSdk
    public static Integer[] toWrapperArray(@NonNull int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i8 = 0; i8 < length; i8++) {
            numArr[i8] = Integer.valueOf(iArr[i8]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull double[] dArr) {
        int length = dArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i8]));
        }
    }

    @KeepForSdk
    public static void writeStringArray(@NonNull StringBuilder sb, @NonNull String[] strArr) {
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(strArr[i8]);
            sb.append("\"");
        }
    }

    @KeepForSdk
    public static <T> boolean contains(@NonNull T[] tArr, @NonNull T t7) {
        int length = tArr != null ? tArr.length : 0;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                break;
            } else if (!Objects.equal(tArr[i8], t7)) {
                i8++;
            } else if (i8 >= 0) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull float[] fArr) {
        int length = fArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i8]));
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull int[] iArr) {
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i8]));
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull long[] jArr) {
        int length = jArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i8]));
        }
    }

    @KeepForSdk
    public static <T> void writeArray(@NonNull StringBuilder sb, @NonNull T[] tArr) {
        int length = tArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(tArr[i8]);
        }
    }

    @KeepForSdk
    public static void writeArray(@NonNull StringBuilder sb, @NonNull boolean[] zArr) {
        int length = zArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            if (i8 != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i8]));
        }
    }
}
