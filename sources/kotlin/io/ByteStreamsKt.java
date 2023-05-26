package kotlin.io;

import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IOStreams.kt */
/* loaded from: classes5.dex */
public final class ByteStreamsKt {
    public static final long a(InputStream inputStream, OutputStream out, int i8) {
        Intrinsics.f(inputStream, "<this>");
        Intrinsics.f(out, "out");
        byte[] bArr = new byte[i8];
        int read = inputStream.read(bArr);
        long j8 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j8 += read;
            read = inputStream.read(bArr);
        }
        return j8;
    }

    public static /* synthetic */ long b(InputStream inputStream, OutputStream outputStream, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        return a(inputStream, outputStream, i8);
    }

    public static final byte[] c(InputStream inputStream) {
        Intrinsics.f(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max((int) FragmentTransaction.TRANSIT_EXIT_MASK, inputStream.available()));
        b(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.e(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
