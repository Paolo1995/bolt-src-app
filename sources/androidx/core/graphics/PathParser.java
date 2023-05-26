package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PathParser {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ExtractFloatResult {

        /* renamed from: a  reason: collision with root package name */
        int f5742a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5743b;

        ExtractFloatResult() {
        }
    }

    private PathParser() {
    }

    private static void a(ArrayList<PathDataNode> arrayList, char c8, float[] fArr) {
        arrayList.add(new PathDataNode(c8, fArr));
    }

    public static boolean b(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
            PathDataNode pathDataNode = pathDataNodeArr[i8];
            char c8 = pathDataNode.f5744a;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i8];
            if (c8 != pathDataNode2.f5744a || pathDataNode.f5745b.length != pathDataNode2.f5745b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i8, int i9) {
        if (i8 <= i9) {
            int length = fArr.length;
            if (i8 >= 0 && i8 <= length) {
                int i10 = i9 - i8;
                int min = Math.min(i10, length - i8);
                float[] fArr2 = new float[i10];
                System.arraycopy(fArr, i8, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = 1;
        int i9 = 0;
        while (i8 < str.length()) {
            int i10 = i(str, i8);
            String trim = str.substring(i9, i10).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i9 = i10;
            i8 = i10 + 1;
        }
        if (i8 - i9 == 1 && i9 < str.length()) {
            a(arrayList, str.charAt(i9), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        PathDataNode[] d8 = d(str);
        if (d8 != null) {
            try {
                PathDataNode.e(d8, path);
                return path;
            } catch (RuntimeException e8) {
                throw new RuntimeException("Error in parsing " + str, e8);
            }
        }
        return null;
    }

    public static PathDataNode[] f(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
            pathDataNodeArr2[i8] = new PathDataNode(pathDataNodeArr[i8]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.f5743b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L37
        L27:
            r10.f5743b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f5743b = r7
            goto L35
        L31:
            r2 = 0
            goto L37
        L33:
            r2 = 1
            goto L37
        L35:
            r2 = 0
            r4 = 1
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f5742a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.g(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) != 'z' && str.charAt(0) != 'Z') {
            try {
                float[] fArr = new float[str.length()];
                ExtractFloatResult extractFloatResult = new ExtractFloatResult();
                int length = str.length();
                int i8 = 1;
                int i9 = 0;
                while (i8 < length) {
                    g(str, i8, extractFloatResult);
                    int i10 = extractFloatResult.f5742a;
                    if (i8 < i10) {
                        fArr[i9] = Float.parseFloat(str.substring(i8, i10));
                        i9++;
                    }
                    if (extractFloatResult.f5743b) {
                        i8 = i10;
                    } else {
                        i8 = i10 + 1;
                    }
                }
                return c(fArr, 0, i9);
            } catch (NumberFormatException e8) {
                throw new RuntimeException("error in parsing \"" + str + "\"", e8);
            }
        }
        return new float[0];
    }

    private static int i(String str, int i8) {
        while (i8 < str.length()) {
            char charAt = str.charAt(i8);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i8;
            }
            i8++;
        }
        return i8;
    }

    public static void j(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i8 = 0; i8 < pathDataNodeArr2.length; i8++) {
            pathDataNodeArr[i8].f5744a = pathDataNodeArr2[i8].f5744a;
            int i9 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i8].f5745b;
                if (i9 < fArr.length) {
                    pathDataNodeArr[i8].f5745b[i9] = fArr[i9];
                    i9++;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PathDataNode {

        /* renamed from: a  reason: collision with root package name */
        public char f5744a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f5745b;

        PathDataNode(char c8, float[] fArr) {
            this.f5744a = c8;
            this.f5745b = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c8, char c9, float[] fArr2) {
            int i8;
            int i9;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            char c10 = c9;
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr[2];
            float f19 = fArr[3];
            float f20 = fArr[4];
            float f21 = fArr[5];
            switch (c10) {
                case 'A':
                case 'a':
                    i8 = 7;
                    break;
                case 'C':
                case 'c':
                    i8 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i8 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i8 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i8 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f20, f21);
                    f16 = f20;
                    f18 = f16;
                    f17 = f21;
                    f19 = f17;
                    i8 = 2;
                    break;
            }
            float f22 = f16;
            float f23 = f17;
            float f24 = f20;
            float f25 = f21;
            int i10 = 0;
            char c11 = c8;
            while (i10 < fArr2.length) {
                if (c10 != 'A') {
                    if (c10 != 'C') {
                        if (c10 != 'H') {
                            if (c10 != 'Q') {
                                if (c10 != 'V') {
                                    if (c10 != 'a') {
                                        if (c10 != 'c') {
                                            if (c10 != 'h') {
                                                if (c10 != 'q') {
                                                    if (c10 != 'v') {
                                                        if (c10 != 'L') {
                                                            if (c10 != 'M') {
                                                                if (c10 != 'S') {
                                                                    if (c10 != 'T') {
                                                                        if (c10 != 'l') {
                                                                            if (c10 != 'm') {
                                                                                if (c10 != 's') {
                                                                                    if (c10 == 't') {
                                                                                        if (c11 != 'q' && c11 != 't' && c11 != 'Q' && c11 != 'T') {
                                                                                            f15 = 0.0f;
                                                                                            f14 = 0.0f;
                                                                                        } else {
                                                                                            f14 = f22 - f18;
                                                                                            f15 = f23 - f19;
                                                                                        }
                                                                                        int i11 = i10 + 0;
                                                                                        int i12 = i10 + 1;
                                                                                        path.rQuadTo(f14, f15, fArr2[i11], fArr2[i12]);
                                                                                        float f26 = f14 + f22;
                                                                                        float f27 = f15 + f23;
                                                                                        f22 += fArr2[i11];
                                                                                        f23 += fArr2[i12];
                                                                                        f19 = f27;
                                                                                        f18 = f26;
                                                                                    }
                                                                                } else {
                                                                                    if (c11 != 'c' && c11 != 's' && c11 != 'C' && c11 != 'S') {
                                                                                        f13 = 0.0f;
                                                                                        f12 = 0.0f;
                                                                                    } else {
                                                                                        float f28 = f22 - f18;
                                                                                        f12 = f23 - f19;
                                                                                        f13 = f28;
                                                                                    }
                                                                                    int i13 = i10 + 0;
                                                                                    int i14 = i10 + 1;
                                                                                    int i15 = i10 + 2;
                                                                                    int i16 = i10 + 3;
                                                                                    path.rCubicTo(f13, f12, fArr2[i13], fArr2[i14], fArr2[i15], fArr2[i16]);
                                                                                    f8 = fArr2[i13] + f22;
                                                                                    f9 = fArr2[i14] + f23;
                                                                                    f22 += fArr2[i15];
                                                                                    f10 = fArr2[i16];
                                                                                }
                                                                            } else {
                                                                                float f29 = fArr2[i10 + 0];
                                                                                f22 += f29;
                                                                                float f30 = fArr2[i10 + 1];
                                                                                f23 += f30;
                                                                                if (i10 > 0) {
                                                                                    path.rLineTo(f29, f30);
                                                                                } else {
                                                                                    path.rMoveTo(f29, f30);
                                                                                    i9 = i10;
                                                                                    f25 = f23;
                                                                                    f24 = f22;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            int i17 = i10 + 0;
                                                                            int i18 = i10 + 1;
                                                                            path.rLineTo(fArr2[i17], fArr2[i18]);
                                                                            f22 += fArr2[i17];
                                                                            f11 = fArr2[i18];
                                                                        }
                                                                    } else {
                                                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                                            f22 = (f22 * 2.0f) - f18;
                                                                            f23 = (f23 * 2.0f) - f19;
                                                                        }
                                                                        int i19 = i10 + 0;
                                                                        int i20 = i10 + 1;
                                                                        path.quadTo(f22, f23, fArr2[i19], fArr2[i20]);
                                                                        float f31 = fArr2[i19];
                                                                        float f32 = fArr2[i20];
                                                                        i9 = i10;
                                                                        f19 = f23;
                                                                        f18 = f22;
                                                                        f22 = f31;
                                                                        f23 = f32;
                                                                    }
                                                                } else {
                                                                    if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                                        f22 = (f22 * 2.0f) - f18;
                                                                        f23 = (f23 * 2.0f) - f19;
                                                                    }
                                                                    float f33 = f23;
                                                                    int i21 = i10 + 0;
                                                                    int i22 = i10 + 1;
                                                                    int i23 = i10 + 2;
                                                                    int i24 = i10 + 3;
                                                                    path.cubicTo(f22, f33, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                                                    f8 = fArr2[i21];
                                                                    f9 = fArr2[i22];
                                                                    f22 = fArr2[i23];
                                                                    f23 = fArr2[i24];
                                                                    f18 = f8;
                                                                    f19 = f9;
                                                                }
                                                            } else {
                                                                f22 = fArr2[i10 + 0];
                                                                f23 = fArr2[i10 + 1];
                                                                if (i10 > 0) {
                                                                    path.lineTo(f22, f23);
                                                                } else {
                                                                    path.moveTo(f22, f23);
                                                                    i9 = i10;
                                                                    f25 = f23;
                                                                    f24 = f22;
                                                                }
                                                            }
                                                        } else {
                                                            int i25 = i10 + 0;
                                                            int i26 = i10 + 1;
                                                            path.lineTo(fArr2[i25], fArr2[i26]);
                                                            f22 = fArr2[i25];
                                                            f23 = fArr2[i26];
                                                        }
                                                    } else {
                                                        int i27 = i10 + 0;
                                                        path.rLineTo(0.0f, fArr2[i27]);
                                                        f11 = fArr2[i27];
                                                    }
                                                    f23 += f11;
                                                } else {
                                                    int i28 = i10 + 0;
                                                    int i29 = i10 + 1;
                                                    int i30 = i10 + 2;
                                                    int i31 = i10 + 3;
                                                    path.rQuadTo(fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                                                    f8 = fArr2[i28] + f22;
                                                    f9 = fArr2[i29] + f23;
                                                    f22 += fArr2[i30];
                                                    f10 = fArr2[i31];
                                                }
                                            } else {
                                                int i32 = i10 + 0;
                                                path.rLineTo(fArr2[i32], 0.0f);
                                                f22 += fArr2[i32];
                                            }
                                            i9 = i10;
                                        } else {
                                            int i33 = i10 + 2;
                                            int i34 = i10 + 3;
                                            int i35 = i10 + 4;
                                            int i36 = i10 + 5;
                                            path.rCubicTo(fArr2[i10 + 0], fArr2[i10 + 1], fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                                            f8 = fArr2[i33] + f22;
                                            f9 = fArr2[i34] + f23;
                                            f22 += fArr2[i35];
                                            f10 = fArr2[i36];
                                        }
                                        f23 += f10;
                                        f18 = f8;
                                        f19 = f9;
                                        i9 = i10;
                                    } else {
                                        int i37 = i10 + 5;
                                        float f34 = fArr2[i37] + f22;
                                        int i38 = i10 + 6;
                                        float f35 = fArr2[i38] + f23;
                                        float f36 = fArr2[i10 + 0];
                                        float f37 = fArr2[i10 + 1];
                                        float f38 = fArr2[i10 + 2];
                                        if (fArr2[i10 + 3] != 0.0f) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        if (fArr2[i10 + 4] != 0.0f) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        i9 = i10;
                                        c(path, f22, f23, f34, f35, f36, f37, f38, z9, z10);
                                        f22 += fArr2[i37];
                                        f23 += fArr2[i38];
                                    }
                                } else {
                                    i9 = i10;
                                    int i39 = i9 + 0;
                                    path.lineTo(f22, fArr2[i39]);
                                    f23 = fArr2[i39];
                                }
                            } else {
                                i9 = i10;
                                int i40 = i9 + 0;
                                int i41 = i9 + 1;
                                int i42 = i9 + 2;
                                int i43 = i9 + 3;
                                path.quadTo(fArr2[i40], fArr2[i41], fArr2[i42], fArr2[i43]);
                                float f39 = fArr2[i40];
                                float f40 = fArr2[i41];
                                f22 = fArr2[i42];
                                f23 = fArr2[i43];
                                f18 = f39;
                                f19 = f40;
                            }
                        } else {
                            i9 = i10;
                            int i44 = i9 + 0;
                            path.lineTo(fArr2[i44], f23);
                            f22 = fArr2[i44];
                        }
                    } else {
                        i9 = i10;
                        int i45 = i9 + 2;
                        int i46 = i9 + 3;
                        int i47 = i9 + 4;
                        int i48 = i9 + 5;
                        path.cubicTo(fArr2[i9 + 0], fArr2[i9 + 1], fArr2[i45], fArr2[i46], fArr2[i47], fArr2[i48]);
                        f22 = fArr2[i47];
                        float f41 = fArr2[i48];
                        float f42 = fArr2[i45];
                        float f43 = fArr2[i46];
                        f23 = f41;
                        f19 = f43;
                        f18 = f42;
                    }
                    i10 = i9 + i8;
                    c11 = c9;
                    c10 = c11;
                } else {
                    i9 = i10;
                    float f44 = f23;
                    float f45 = f22;
                    int i49 = i9 + 5;
                    float f46 = fArr2[i49];
                    int i50 = i9 + 6;
                    float f47 = fArr2[i50];
                    float f48 = fArr2[i9 + 0];
                    float f49 = fArr2[i9 + 1];
                    float f50 = fArr2[i9 + 2];
                    if (fArr2[i9 + 3] != 0.0f) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (fArr2[i9 + 4] != 0.0f) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    c(path, f45, f44, f46, f47, f48, f49, f50, z7, z8);
                    f22 = fArr2[i49];
                    f23 = fArr2[i50];
                }
                f19 = f23;
                f18 = f22;
                i10 = i9 + i8;
                c11 = c9;
                c10 = c11;
            }
            fArr[0] = f22;
            fArr[1] = f23;
            fArr[2] = f18;
            fArr[3] = f19;
            fArr[4] = f24;
            fArr[5] = f25;
        }

        private static void b(Path path, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16) {
            double d17 = d10;
            int ceil = (int) Math.ceil(Math.abs((d16 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d14);
            double sin = Math.sin(d14);
            double cos2 = Math.cos(d15);
            double sin2 = Math.sin(d15);
            double d18 = -d17;
            double d19 = d18 * cos;
            double d20 = d11 * sin;
            double d21 = (d19 * sin2) - (d20 * cos2);
            double d22 = d18 * sin;
            double d23 = d11 * cos;
            double d24 = (sin2 * d22) + (cos2 * d23);
            double d25 = d16 / ceil;
            double d26 = d15;
            double d27 = d24;
            double d28 = d21;
            int i8 = 0;
            double d29 = d12;
            double d30 = d13;
            while (i8 < ceil) {
                double d31 = d26 + d25;
                double sin3 = Math.sin(d31);
                double cos3 = Math.cos(d31);
                double d32 = (d8 + ((d17 * cos) * cos3)) - (d20 * sin3);
                double d33 = d9 + (d17 * sin * cos3) + (d23 * sin3);
                double d34 = (d19 * sin3) - (d20 * cos3);
                double d35 = (sin3 * d22) + (cos3 * d23);
                double d36 = d31 - d26;
                double tan = Math.tan(d36 / 2.0d);
                double sin4 = (Math.sin(d36) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d37 = d29 + (d28 * sin4);
                double d38 = cos;
                double d39 = sin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d37, (float) (d30 + (d27 * sin4)), (float) (d32 - (sin4 * d34)), (float) (d33 - (sin4 * d35)), (float) d32, (float) d33);
                i8++;
                d25 = d25;
                sin = d39;
                d29 = d32;
                d22 = d22;
                cos = d38;
                d26 = d31;
                d27 = d35;
                d28 = d34;
                ceil = ceil;
                d30 = d33;
                d17 = d10;
            }
        }

        private static void c(Path path, float f8, float f9, float f10, float f11, float f12, float f13, float f14, boolean z7, boolean z8) {
            double d8;
            double d9;
            boolean z9;
            double radians = Math.toRadians(f14);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d10 = f8;
            double d11 = d10 * cos;
            double d12 = f9;
            double d13 = f12;
            double d14 = (d11 + (d12 * sin)) / d13;
            double d15 = f13;
            double d16 = (((-f8) * sin) + (d12 * cos)) / d15;
            double d17 = f11;
            double d18 = ((f10 * cos) + (d17 * sin)) / d13;
            double d19 = (((-f10) * sin) + (d17 * cos)) / d15;
            double d20 = d14 - d18;
            double d21 = d16 - d19;
            double d22 = (d14 + d18) / 2.0d;
            double d23 = (d16 + d19) / 2.0d;
            double d24 = (d20 * d20) + (d21 * d21);
            if (d24 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d25 = (1.0d / d24) - 0.25d;
            if (d25 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d24);
                float sqrt = (float) (Math.sqrt(d24) / 1.99999d);
                c(path, f8, f9, f10, f11, f12 * sqrt, f13 * sqrt, f14, z7, z8);
                return;
            }
            double sqrt2 = Math.sqrt(d25);
            double d26 = d20 * sqrt2;
            double d27 = sqrt2 * d21;
            if (z7 == z8) {
                d8 = d22 - d27;
                d9 = d23 + d26;
            } else {
                d8 = d22 + d27;
                d9 = d23 - d26;
            }
            double atan2 = Math.atan2(d16 - d9, d14 - d8);
            double atan22 = Math.atan2(d19 - d9, d18 - d8) - atan2;
            int i8 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (i8 >= 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z8 != z9) {
                if (i8 > 0) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d28 = d8 * d13;
            double d29 = d9 * d15;
            b(path, (d28 * cos) - (d29 * sin), (d28 * sin) + (d29 * cos), d13, d15, d10, d12, radians, atan2, atan22);
        }

        public static void e(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c8 = 'm';
            for (int i8 = 0; i8 < pathDataNodeArr.length; i8++) {
                PathDataNode pathDataNode = pathDataNodeArr[i8];
                a(path, fArr, c8, pathDataNode.f5744a, pathDataNode.f5745b);
                c8 = pathDataNodeArr[i8].f5744a;
            }
        }

        public void d(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f8) {
            this.f5744a = pathDataNode.f5744a;
            int i8 = 0;
            while (true) {
                float[] fArr = pathDataNode.f5745b;
                if (i8 < fArr.length) {
                    this.f5745b[i8] = (fArr[i8] * (1.0f - f8)) + (pathDataNode2.f5745b[i8] * f8);
                    i8++;
                } else {
                    return;
                }
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.f5744a = pathDataNode.f5744a;
            float[] fArr = pathDataNode.f5745b;
            this.f5745b = PathParser.c(fArr, 0, fArr.length);
        }
    }
}
