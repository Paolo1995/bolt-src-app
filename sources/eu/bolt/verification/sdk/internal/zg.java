package eu.bolt.verification.sdk.internal;

import androidx.fragment.app.FragmentTransaction;
import j$.util.Spliterator;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes5.dex */
public class zg {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f45859f = StandardCharsets.UTF_8;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f45860g = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 106, 107, 109, 110, 112, 113, 114, 115, 116, 118, 119, 120, 121, 122};

    /* renamed from: a  reason: collision with root package name */
    private byte[] f45861a;

    /* renamed from: b  reason: collision with root package name */
    private int f45862b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45863c;

    /* renamed from: d  reason: collision with root package name */
    private int f45864d;

    /* renamed from: e  reason: collision with root package name */
    private long f45865e;

    private byte a(byte b8) {
        switch (b8) {
            case 48:
                return (byte) 0;
            case 49:
                return (byte) 1;
            case 50:
                return (byte) 2;
            case 51:
                return (byte) 3;
            case 52:
                return (byte) 4;
            case 53:
                return (byte) 5;
            case 54:
                return (byte) 6;
            case 55:
                return (byte) 7;
            case 56:
                return (byte) 8;
            case 57:
                return (byte) 9;
            default:
                switch (b8) {
                    case 65:
                        return (byte) 10;
                    case 66:
                        return (byte) 11;
                    case 67:
                        return (byte) 12;
                    case 68:
                        return (byte) 13;
                    case 69:
                        return (byte) 14;
                    case 70:
                        return (byte) 15;
                    case 71:
                        return (byte) 16;
                    case 72:
                        return (byte) 17;
                    case 73:
                    case 76:
                        return (byte) 1;
                    case 74:
                        return (byte) 18;
                    case 75:
                        return (byte) 19;
                    case 77:
                        return (byte) 20;
                    case 78:
                        return (byte) 21;
                    case 79:
                        return (byte) 0;
                    case 80:
                        return (byte) 22;
                    case 81:
                        return (byte) 23;
                    case 82:
                        return (byte) 24;
                    case 83:
                        return (byte) 25;
                    case 84:
                        return (byte) 26;
                    case 85:
                    case 86:
                        return (byte) 27;
                    case 87:
                        return (byte) 28;
                    case 88:
                        return (byte) 29;
                    case 89:
                        return (byte) 30;
                    case 90:
                        return (byte) 31;
                    default:
                        switch (b8) {
                            case 97:
                                return (byte) 10;
                            case 98:
                                return (byte) 11;
                            case 99:
                                return (byte) 12;
                            case 100:
                                return (byte) 13;
                            case 101:
                                return (byte) 14;
                            case 102:
                                return (byte) 15;
                            case 103:
                                return (byte) 16;
                            case 104:
                                return (byte) 17;
                            case 105:
                            case 108:
                                return (byte) 1;
                            case 106:
                                return (byte) 18;
                            case 107:
                                return (byte) 19;
                            case 109:
                                return (byte) 20;
                            case 110:
                                return (byte) 21;
                            case 111:
                                return (byte) 0;
                            case 112:
                                return (byte) 22;
                            case 113:
                                return (byte) 23;
                            case 114:
                                return (byte) 24;
                            case 115:
                                return (byte) 25;
                            case 116:
                                return (byte) 26;
                            case 117:
                            case 118:
                                return (byte) 27;
                            case 119:
                                return (byte) 28;
                            case 120:
                                return (byte) 29;
                            case 121:
                                return (byte) 30;
                            case 122:
                                return (byte) 31;
                            default:
                                return (byte) -1;
                        }
                }
        }
    }

    private int b() {
        if (this.f45861a != null) {
            return this.f45862b;
        }
        return 0;
    }

    private void c(int i8) {
        byte[] bArr = this.f45861a;
        if (bArr == null || bArr.length < this.f45862b + i8) {
            l();
        }
    }

    private void d(byte[] bArr, int i8) {
        int i9;
        if (this.f45863c) {
            return;
        }
        int i10 = 1;
        if (i8 < 0) {
            this.f45863c = true;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < i8) {
            int i13 = i12 + 1;
            byte b8 = bArr[i12];
            c(7);
            if (i(b8)) {
                byte a8 = a(b8);
                int i14 = (this.f45864d + i10) % 8;
                this.f45864d = i14;
                long j8 = (this.f45865e << 5) + a8;
                this.f45865e = j8;
                if (i14 == 0) {
                    byte[] bArr2 = this.f45861a;
                    int i15 = this.f45862b;
                    int i16 = i15 + 1;
                    i9 = i11;
                    bArr2[i15] = (byte) ((j8 >> 32) & 255);
                    int i17 = i16 + 1;
                    bArr2[i16] = (byte) ((j8 >> 24) & 255);
                    int i18 = i17 + 1;
                    bArr2[i17] = (byte) ((j8 >> 16) & 255);
                    int i19 = i18 + 1;
                    bArr2[i18] = (byte) ((j8 >> 8) & 255);
                    this.f45862b = i19 + 1;
                    bArr2[i19] = (byte) (j8 & 255);
                    i11 = i9 + 1;
                    i12 = i13;
                    i10 = 1;
                }
            }
            i9 = i11;
            i11 = i9 + 1;
            i12 = i13;
            i10 = 1;
        }
        if (!this.f45863c || this.f45864d < 2) {
            return;
        }
        c(7);
        switch (this.f45864d) {
            case 2:
                byte[] bArr3 = this.f45861a;
                int i20 = this.f45862b;
                this.f45862b = i20 + 1;
                bArr3[i20] = (byte) ((this.f45865e >> 2) & 255);
                return;
            case 3:
                byte[] bArr4 = this.f45861a;
                int i21 = this.f45862b;
                this.f45862b = i21 + 1;
                bArr4[i21] = (byte) ((this.f45865e >> 7) & 255);
                return;
            case 4:
                long j9 = this.f45865e >> 4;
                this.f45865e = j9;
                byte[] bArr5 = this.f45861a;
                int i22 = this.f45862b;
                int i23 = i22 + 1;
                bArr5[i22] = (byte) ((j9 >> 8) & 255);
                this.f45862b = i23 + 1;
                bArr5[i23] = (byte) (j9 & 255);
                return;
            case 5:
                long j10 = this.f45865e >> 1;
                this.f45865e = j10;
                byte[] bArr6 = this.f45861a;
                int i24 = this.f45862b;
                int i25 = i24 + 1;
                bArr6[i24] = (byte) ((j10 >> 16) & 255);
                int i26 = i25 + 1;
                bArr6[i25] = (byte) ((j10 >> 8) & 255);
                this.f45862b = i26 + 1;
                bArr6[i26] = (byte) (j10 & 255);
                return;
            case 6:
                long j11 = this.f45865e >> 6;
                this.f45865e = j11;
                byte[] bArr7 = this.f45861a;
                int i27 = this.f45862b;
                int i28 = i27 + 1;
                bArr7[i27] = (byte) ((j11 >> 16) & 255);
                int i29 = i28 + 1;
                bArr7[i28] = (byte) ((j11 >> 8) & 255);
                this.f45862b = i29 + 1;
                bArr7[i29] = (byte) (j11 & 255);
                return;
            case 7:
                long j12 = this.f45865e >> 3;
                this.f45865e = j12;
                byte[] bArr8 = this.f45861a;
                int i30 = this.f45862b;
                int i31 = i30 + 1;
                bArr8[i30] = (byte) ((j12 >> 24) & 255);
                int i32 = i31 + 1;
                bArr8[i31] = (byte) ((j12 >> 16) & 255);
                int i33 = i32 + 1;
                bArr8[i32] = (byte) ((j12 >> 8) & 255);
                this.f45862b = i33 + 1;
                bArr8[i33] = (byte) (j12 & 255);
                return;
            default:
                return;
        }
    }

    private byte[] f(byte[] bArr) {
        g();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        d(bArr, bArr.length);
        d(bArr, -1);
        byte[] bArr2 = new byte[this.f45862b];
        m(bArr2);
        return bArr2;
    }

    private void g() {
        this.f45861a = null;
        this.f45862b = 0;
        this.f45864d = 0;
        this.f45863c = false;
    }

    private void h(byte[] bArr, int i8) {
        if (this.f45863c) {
            return;
        }
        if (i8 >= 0) {
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8) {
                c(8);
                int i11 = (this.f45864d + 1) % 5;
                this.f45864d = i11;
                int i12 = i10 + 1;
                int i13 = bArr[i10];
                if (i13 < 0) {
                    i13 += Spliterator.NONNULL;
                }
                long j8 = (this.f45865e << 8) + i13;
                this.f45865e = j8;
                if (i11 == 0) {
                    byte[] bArr2 = this.f45861a;
                    int i14 = this.f45862b;
                    int i15 = i14 + 1;
                    byte[] bArr3 = f45860g;
                    bArr2[i14] = bArr3[((int) (j8 >> 35)) & 31];
                    int i16 = i15 + 1;
                    bArr2[i15] = bArr3[((int) (j8 >> 30)) & 31];
                    int i17 = i16 + 1;
                    bArr2[i16] = bArr3[((int) (j8 >> 25)) & 31];
                    int i18 = i17 + 1;
                    bArr2[i17] = bArr3[((int) (j8 >> 20)) & 31];
                    int i19 = i18 + 1;
                    bArr2[i18] = bArr3[((int) (j8 >> 15)) & 31];
                    int i20 = i19 + 1;
                    bArr2[i19] = bArr3[((int) (j8 >> 10)) & 31];
                    int i21 = i20 + 1;
                    bArr2[i20] = bArr3[((int) (j8 >> 5)) & 31];
                    this.f45862b = i21 + 1;
                    bArr2[i21] = bArr3[((int) j8) & 31];
                }
                i9++;
                i10 = i12;
            }
            return;
        }
        this.f45863c = true;
        if (this.f45864d == 0) {
            return;
        }
        c(8);
        int i22 = this.f45864d;
        if (i22 == 1) {
            byte[] bArr4 = this.f45861a;
            int i23 = this.f45862b;
            int i24 = i23 + 1;
            byte[] bArr5 = f45860g;
            long j9 = this.f45865e;
            bArr4[i23] = bArr5[((int) (j9 >> 3)) & 31];
            this.f45862b = i24 + 1;
            bArr4[i24] = bArr5[((int) (j9 << 2)) & 31];
        } else if (i22 == 2) {
            byte[] bArr6 = this.f45861a;
            int i25 = this.f45862b;
            int i26 = i25 + 1;
            byte[] bArr7 = f45860g;
            long j10 = this.f45865e;
            bArr6[i25] = bArr7[((int) (j10 >> 11)) & 31];
            int i27 = i26 + 1;
            bArr6[i26] = bArr7[((int) (j10 >> 6)) & 31];
            int i28 = i27 + 1;
            bArr6[i27] = bArr7[((int) (j10 >> 1)) & 31];
            this.f45862b = i28 + 1;
            bArr6[i28] = bArr7[((int) (j10 << 4)) & 31];
        } else if (i22 == 3) {
            byte[] bArr8 = this.f45861a;
            int i29 = this.f45862b;
            int i30 = i29 + 1;
            byte[] bArr9 = f45860g;
            long j11 = this.f45865e;
            bArr8[i29] = bArr9[((int) (j11 >> 19)) & 31];
            int i31 = i30 + 1;
            bArr8[i30] = bArr9[((int) (j11 >> 14)) & 31];
            int i32 = i31 + 1;
            bArr8[i31] = bArr9[((int) (j11 >> 9)) & 31];
            int i33 = i32 + 1;
            bArr8[i32] = bArr9[((int) (j11 >> 4)) & 31];
            this.f45862b = i33 + 1;
            bArr8[i33] = bArr9[((int) (j11 << 1)) & 31];
        } else if (i22 != 4) {
        } else {
            byte[] bArr10 = this.f45861a;
            int i34 = this.f45862b;
            int i35 = i34 + 1;
            byte[] bArr11 = f45860g;
            long j12 = this.f45865e;
            bArr10[i34] = bArr11[((int) (j12 >> 27)) & 31];
            int i36 = i35 + 1;
            bArr10[i35] = bArr11[((int) (j12 >> 22)) & 31];
            int i37 = i36 + 1;
            bArr10[i36] = bArr11[((int) (j12 >> 17)) & 31];
            int i38 = i37 + 1;
            bArr10[i37] = bArr11[((int) (j12 >> 12)) & 31];
            int i39 = i38 + 1;
            bArr10[i38] = bArr11[((int) (j12 >> 7)) & 31];
            int i40 = i39 + 1;
            bArr10[i39] = bArr11[((int) (j12 >> 2)) & 31];
            this.f45862b = i40 + 1;
            bArr10[i40] = bArr11[((int) (j12 << 3)) & 31];
        }
    }

    private boolean i(byte b8) {
        return a(b8) != -1;
    }

    private byte[] j(byte[] bArr) {
        g();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        h(bArr, bArr.length);
        h(bArr, -1);
        byte[] bArr2 = new byte[this.f45862b];
        m(bArr2);
        return bArr2;
    }

    private void l() {
        byte[] bArr = this.f45861a;
        if (bArr == null) {
            this.f45861a = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
            this.f45862b = 0;
            return;
        }
        byte[] bArr2 = new byte[bArr.length * 2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f45861a = bArr2;
    }

    private void m(byte[] bArr) {
        if (this.f45861a != null) {
            System.arraycopy(this.f45861a, 0, bArr, 0, b());
            this.f45861a = null;
        }
    }

    public byte[] e(String str) {
        return f(str.getBytes(f45859f));
    }

    public String k(byte[] bArr) {
        return new String(j(bArr), f45859f);
    }
}
