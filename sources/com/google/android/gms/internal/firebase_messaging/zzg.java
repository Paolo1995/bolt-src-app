package com.google.android.gms.internal.firebase_messaging;

import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes.dex */
public final class zzg {
    private static final OutputStream zza = new zze();

    public static byte[] zza(InputStream inputStream) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i8 = FragmentTransaction.TRANSIT_EXIT_MASK;
        int i9 = 0;
        while (i9 < 2147483639) {
            int min = Math.min(i8, 2147483639 - i9);
            byte[] bArr = new byte[min];
            arrayDeque.add(bArr);
            int i10 = 0;
            while (i10 < min) {
                int read = inputStream.read(bArr, i10, min - i10);
                if (read == -1) {
                    return zzc(arrayDeque, i9);
                }
                i10 += read;
                i9 += read;
            }
            long j8 = i8;
            long j9 = j8 + j8;
            if (j9 > 2147483647L) {
                i8 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            } else if (j9 < -2147483648L) {
                i8 = Integer.MIN_VALUE;
            } else {
                i8 = (int) j9;
            }
        }
        if (inputStream.read() == -1) {
            return zzc(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static InputStream zzb(InputStream inputStream, long j8) {
        return new zzf(inputStream, 1048577L);
    }

    private static byte[] zzc(Queue<byte[]> queue, int i8) {
        byte[] bArr = new byte[i8];
        int i9 = i8;
        while (i9 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i9, remove.length);
            System.arraycopy(remove, 0, bArr, i8 - i9, min);
            i9 -= min;
        }
        return bArr;
    }
}
