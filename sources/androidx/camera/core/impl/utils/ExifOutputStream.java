package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.ExifData;
import androidx.core.util.Preconditions;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;

/* loaded from: classes.dex */
public final class ExifOutputStream extends FilterOutputStream {

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f3805l = "Exif\u0000\u0000".getBytes(ExifAttribute.f3771e);

    /* renamed from: f  reason: collision with root package name */
    private final ExifData f3806f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f3807g;

    /* renamed from: h  reason: collision with root package name */
    private final ByteBuffer f3808h;

    /* renamed from: i  reason: collision with root package name */
    private int f3809i;

    /* renamed from: j  reason: collision with root package name */
    private int f3810j;

    /* renamed from: k  reason: collision with root package name */
    private int f3811k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class JpegHeader {
        private JpegHeader() {
        }

        public static boolean a(short s7) {
            return (s7 < -64 || s7 > -49 || s7 == -60 || s7 == -56 || s7 == -52) ? false : true;
        }
    }

    public ExifOutputStream(@NonNull OutputStream outputStream, @NonNull ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.f3807g = new byte[1];
        this.f3808h = ByteBuffer.allocate(4);
        this.f3809i = 0;
        this.f3806f = exifData;
    }

    private int a(int i8, byte[] bArr, int i9, int i10) {
        int min = Math.min(i10, i8 - this.f3808h.position());
        this.f3808h.put(bArr, i9, min);
        return min;
    }

    private void c(@NonNull ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        ExifTag[] exifTagArr;
        short s7;
        ExifTag[][] exifTagArr2 = ExifData.f3785i;
        int[] iArr = new int[exifTagArr2.length];
        int[] iArr2 = new int[exifTagArr2.length];
        for (ExifTag exifTag : ExifData.f3783g) {
            for (int i8 = 0; i8 < ExifData.f3785i.length; i8++) {
                this.f3806f.c(i8).remove(exifTag.f3813b);
            }
        }
        if (!this.f3806f.c(1).isEmpty()) {
            this.f3806f.c(0).put(ExifData.f3783g[1].f3813b, ExifAttribute.f(0L, this.f3806f.d()));
        }
        if (!this.f3806f.c(2).isEmpty()) {
            this.f3806f.c(0).put(ExifData.f3783g[2].f3813b, ExifAttribute.f(0L, this.f3806f.d()));
        }
        if (!this.f3806f.c(3).isEmpty()) {
            this.f3806f.c(1).put(ExifData.f3783g[3].f3813b, ExifAttribute.f(0L, this.f3806f.d()));
        }
        for (int i9 = 0; i9 < ExifData.f3785i.length; i9++) {
            int i10 = 0;
            for (Map.Entry<String, ExifAttribute> entry : this.f3806f.c(i9).entrySet()) {
                int j8 = entry.getValue().j();
                if (j8 > 4) {
                    i10 += j8;
                }
            }
            iArr2[i9] = iArr2[i9] + i10;
        }
        int i11 = 8;
        for (int i12 = 0; i12 < ExifData.f3785i.length; i12++) {
            if (!this.f3806f.c(i12).isEmpty()) {
                iArr[i12] = i11;
                i11 += (this.f3806f.c(i12).size() * 12) + 2 + 4 + iArr2[i12];
            }
        }
        int i13 = i11 + 8;
        if (!this.f3806f.c(1).isEmpty()) {
            this.f3806f.c(0).put(ExifData.f3783g[1].f3813b, ExifAttribute.f(iArr[1], this.f3806f.d()));
        }
        if (!this.f3806f.c(2).isEmpty()) {
            this.f3806f.c(0).put(ExifData.f3783g[2].f3813b, ExifAttribute.f(iArr[2], this.f3806f.d()));
        }
        if (!this.f3806f.c(3).isEmpty()) {
            this.f3806f.c(1).put(ExifData.f3783g[3].f3813b, ExifAttribute.f(iArr[3], this.f3806f.d()));
        }
        byteOrderedDataOutputStream.j(i13);
        byteOrderedDataOutputStream.write(f3805l);
        if (this.f3806f.d() == ByteOrder.BIG_ENDIAN) {
            s7 = 19789;
        } else {
            s7 = 18761;
        }
        byteOrderedDataOutputStream.g(s7);
        byteOrderedDataOutputStream.a(this.f3806f.d());
        byteOrderedDataOutputStream.j(42);
        byteOrderedDataOutputStream.h(8L);
        for (int i14 = 0; i14 < ExifData.f3785i.length; i14++) {
            if (!this.f3806f.c(i14).isEmpty()) {
                byteOrderedDataOutputStream.j(this.f3806f.c(i14).size());
                int size = iArr[i14] + 2 + (this.f3806f.c(i14).size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry2 : this.f3806f.c(i14).entrySet()) {
                    int i15 = ((ExifTag) Preconditions.h(ExifData.Builder.f3794f.get(i14).get(entry2.getKey()), "Tag not supported: " + entry2.getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).f3812a;
                    ExifAttribute value = entry2.getValue();
                    int j9 = value.j();
                    byteOrderedDataOutputStream.j(i15);
                    byteOrderedDataOutputStream.j(value.f3775a);
                    byteOrderedDataOutputStream.e(value.f3776b);
                    if (j9 > 4) {
                        byteOrderedDataOutputStream.h(size);
                        size += j9;
                    } else {
                        byteOrderedDataOutputStream.write(value.f3778d);
                        if (j9 < 4) {
                            while (j9 < 4) {
                                byteOrderedDataOutputStream.c(0);
                                j9++;
                            }
                        }
                    }
                }
                byteOrderedDataOutputStream.h(0L);
                for (Map.Entry<String, ExifAttribute> entry3 : this.f3806f.c(i14).entrySet()) {
                    byte[] bArr = entry3.getValue().f3778d;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        byteOrderedDataOutputStream.a(ByteOrder.BIG_ENDIAN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
        if (r9 <= 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
        ((java.io.FilterOutputStream) r6).out.write(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        return;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(@androidx.annotation.NonNull byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifOutputStream.write(byte[], int, int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.f3807g;
        bArr[0] = (byte) (i8 & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
