package okio;

import java.security.MessageDigest;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes5.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: k  reason: collision with root package name */
    private final transient byte[][] f52643k;

    /* renamed from: l  reason: collision with root package name */
    private final transient int[] f52644l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f52592j.j());
        Intrinsics.f(segments, "segments");
        Intrinsics.f(directory, "directory");
        this.f52643k = segments;
        this.f52644l = directory;
    }

    private final ByteString H() {
        return new ByteString(C());
    }

    @Override // okio.ByteString
    public ByteString B() {
        return H().B();
    }

    @Override // okio.ByteString
    public byte[] C() {
        byte[] bArr = new byte[z()];
        int length = G().length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            int i11 = F()[length + i8];
            int i12 = F()[i8];
            int i13 = i12 - i9;
            ArraysKt___ArraysJvmKt.f(G()[i8], bArr, i10, i11, i11 + i13);
            i10 += i13;
            i8++;
            i9 = i12;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public void E(Buffer buffer, int i8, int i9) {
        int i10;
        Intrinsics.f(buffer, "buffer");
        int i11 = i8 + i9;
        int b8 = _SegmentedByteStringKt.b(this, i8);
        while (i8 < i11) {
            if (b8 == 0) {
                i10 = 0;
            } else {
                i10 = F()[b8 - 1];
            }
            int i12 = F()[G().length + b8];
            int min = Math.min(i11, (F()[b8] - i10) + i10) - i8;
            int i13 = i12 + (i8 - i10);
            Segment segment = new Segment(G()[b8], i13, i13 + min, true, false);
            Segment segment2 = buffer.f52580f;
            if (segment2 == null) {
                segment.f52637g = segment;
                segment.f52636f = segment;
                buffer.f52580f = segment;
            } else {
                Intrinsics.c(segment2);
                Segment segment3 = segment2.f52637g;
                Intrinsics.c(segment3);
                segment3.c(segment);
            }
            i8 += min;
            b8++;
        }
        buffer.C0(buffer.size() + i9);
    }

    public final int[] F() {
        return this.f52644l;
    }

    public final byte[][] G() {
        return this.f52643k;
    }

    @Override // okio.ByteString
    public String a() {
        return H().a();
    }

    @Override // okio.ByteString
    public ByteString e(String algorithm) {
        Intrinsics.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = G().length;
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            int i10 = F()[length + i8];
            int i11 = F()[i8];
            messageDigest.update(G()[i8], i10, i11 - i9);
            i8++;
            i9 = i11;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.e(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.z() == z() && t(0, byteString, 0, z())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int hashCode() {
        int k8 = k();
        if (k8 == 0) {
            int length = G().length;
            int i8 = 0;
            int i9 = 1;
            int i10 = 0;
            while (i8 < length) {
                int i11 = F()[length + i8];
                int i12 = F()[i8];
                byte[] bArr = G()[i8];
                int i13 = (i12 - i10) + i11;
                while (i11 < i13) {
                    i9 = (i9 * 31) + bArr[i11];
                    i11++;
                }
                i8++;
                i10 = i12;
            }
            v(i9);
            return i9;
        }
        return k8;
    }

    @Override // okio.ByteString
    public int l() {
        return F()[G().length - 1];
    }

    @Override // okio.ByteString
    public String p() {
        return H().p();
    }

    @Override // okio.ByteString
    public byte[] q() {
        return C();
    }

    @Override // okio.ByteString
    public byte r(int i8) {
        int i9;
        _UtilKt.b(F()[G().length - 1], i8, 1L);
        int b8 = _SegmentedByteStringKt.b(this, i8);
        if (b8 == 0) {
            i9 = 0;
        } else {
            i9 = F()[b8 - 1];
        }
        return G()[b8][(i8 - i9) + F()[G().length + b8]];
    }

    @Override // okio.ByteString
    public boolean t(int i8, ByteString other, int i9, int i10) {
        int i11;
        Intrinsics.f(other, "other");
        if (i8 < 0 || i8 > z() - i10) {
            return false;
        }
        int i12 = i10 + i8;
        int b8 = _SegmentedByteStringKt.b(this, i8);
        while (i8 < i12) {
            if (b8 == 0) {
                i11 = 0;
            } else {
                i11 = F()[b8 - 1];
            }
            int i13 = F()[G().length + b8];
            int min = Math.min(i12, (F()[b8] - i11) + i11) - i8;
            if (!other.u(i9, G()[b8], i13 + (i8 - i11), min)) {
                return false;
            }
            i9 += min;
            i8 += min;
            b8++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String toString() {
        return H().toString();
    }

    @Override // okio.ByteString
    public boolean u(int i8, byte[] other, int i9, int i10) {
        int i11;
        Intrinsics.f(other, "other");
        if (i8 < 0 || i8 > z() - i10 || i9 < 0 || i9 > other.length - i10) {
            return false;
        }
        int i12 = i10 + i8;
        int b8 = _SegmentedByteStringKt.b(this, i8);
        while (i8 < i12) {
            if (b8 == 0) {
                i11 = 0;
            } else {
                i11 = F()[b8 - 1];
            }
            int i13 = F()[G().length + b8];
            int min = Math.min(i12, (F()[b8] - i11) + i11) - i8;
            if (!_UtilKt.a(G()[b8], i13 + (i8 - i11), other, i9, min)) {
                return false;
            }
            i9 += min;
            i8 += min;
            b8++;
        }
        return true;
    }
}
