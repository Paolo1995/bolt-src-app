package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Options.kt */
/* loaded from: classes5.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f52612i = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private final ByteString[] f52613g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f52614h;

    /* compiled from: Options.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long j8, Buffer buffer, int i8, List<? extends ByteString> list, int i9, int i10, List<Integer> list2) {
            boolean z7;
            int i11;
            int i12;
            int i13;
            boolean z8;
            int i14;
            int i15;
            Buffer buffer2;
            boolean z9;
            int i16 = i8;
            if (i9 < i10) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                if (i9 < i10) {
                    int i17 = i9;
                    while (true) {
                        int i18 = i17 + 1;
                        if (list.get(i17).z() >= i16) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        if (z9) {
                            if (i18 >= i10) {
                                break;
                            }
                            i17 = i18;
                        } else {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    }
                }
                ByteString byteString = list.get(i9);
                ByteString byteString2 = list.get(i10 - 1);
                if (i16 == byteString.z()) {
                    int i19 = i9 + 1;
                    i11 = i19;
                    i12 = list2.get(i9).intValue();
                    byteString = list.get(i19);
                } else {
                    i11 = i9;
                    i12 = -1;
                }
                if (byteString.h(i16) != byteString2.h(i16)) {
                    int i20 = i11 + 1;
                    int i21 = 1;
                    if (i20 < i10) {
                        while (true) {
                            int i22 = i20 + 1;
                            if (list.get(i20 - 1).h(i16) != list.get(i20).h(i16)) {
                                i21++;
                            }
                            if (i22 >= i10) {
                                break;
                            }
                            i20 = i22;
                        }
                    }
                    long c8 = j8 + c(buffer) + 2 + (i21 * 2);
                    buffer.writeInt(i21);
                    buffer.writeInt(i12);
                    if (i11 < i10) {
                        int i23 = i11;
                        while (true) {
                            int i24 = i23 + 1;
                            byte h8 = list.get(i23).h(i16);
                            if (i23 == i11 || h8 != list.get(i23 - 1).h(i16)) {
                                buffer.writeInt(h8 & 255);
                            }
                            if (i24 >= i10) {
                                break;
                            }
                            i23 = i24;
                        }
                    }
                    Buffer buffer3 = new Buffer();
                    while (i11 < i10) {
                        byte h9 = list.get(i11).h(i16);
                        int i25 = i11 + 1;
                        if (i25 < i10) {
                            int i26 = i25;
                            while (true) {
                                int i27 = i26 + 1;
                                if (h9 != list.get(i26).h(i16)) {
                                    i14 = i26;
                                    break;
                                } else if (i27 >= i10) {
                                    break;
                                } else {
                                    i26 = i27;
                                }
                            }
                        }
                        i14 = i10;
                        if (i25 == i14 && i16 + 1 == list.get(i11).z()) {
                            buffer.writeInt(list2.get(i11).intValue());
                            i15 = i14;
                            buffer2 = buffer3;
                        } else {
                            buffer.writeInt(((int) (c8 + c(buffer3))) * (-1));
                            i15 = i14;
                            buffer2 = buffer3;
                            a(c8, buffer3, i16 + 1, list, i11, i14, list2);
                        }
                        buffer3 = buffer2;
                        i11 = i15;
                    }
                    buffer.V(buffer3);
                    return;
                }
                int min = Math.min(byteString.z(), byteString2.z());
                if (i16 < min) {
                    int i28 = i16;
                    i13 = 0;
                    while (true) {
                        int i29 = i28 + 1;
                        if (byteString.h(i28) != byteString2.h(i28)) {
                            break;
                        }
                        i13++;
                        if (i29 >= min) {
                            break;
                        }
                        i28 = i29;
                    }
                } else {
                    i13 = 0;
                }
                long c9 = j8 + c(buffer) + 2 + i13 + 1;
                buffer.writeInt(-i13);
                buffer.writeInt(i12);
                int i30 = i16 + i13;
                if (i16 < i30) {
                    while (true) {
                        int i31 = i16 + 1;
                        buffer.writeInt(byteString.h(i16) & 255);
                        if (i31 >= i30) {
                            break;
                        }
                        i16 = i31;
                    }
                }
                if (i11 + 1 == i10) {
                    if (i30 == list.get(i11).z()) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        buffer.writeInt(list2.get(i11).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer4 = new Buffer();
                buffer.writeInt(((int) (c(buffer4) + c9)) * (-1));
                a(c9, buffer4, i30, list, i11, i10, list2);
                buffer.V(buffer4);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(Companion companion, long j8, Buffer buffer, int i8, List list, int i9, int i10, List list2, int i11, Object obj) {
            long j9;
            int i12;
            int i13;
            int i14;
            if ((i11 & 1) != 0) {
                j9 = 0;
            } else {
                j9 = j8;
            }
            if ((i11 & 4) != 0) {
                i12 = 0;
            } else {
                i12 = i8;
            }
            if ((i11 & 16) != 0) {
                i13 = 0;
            } else {
                i13 = i9;
            }
            if ((i11 & 32) != 0) {
                i14 = list.size();
            } else {
                i14 = i10;
            }
            companion.a(j9, buffer, i12, list, i13, i14, list2);
        }

        private final long c(Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options d(okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.d(okio.ByteString[]):okio.Options");
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f52613g = byteStringArr;
        this.f52614h = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options o(ByteString... byteStringArr) {
        return f52612i.d(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection
    public int b() {
        return this.f52613g.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return d((ByteString) obj);
    }

    public /* bridge */ boolean d(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: g */
    public ByteString get(int i8) {
        return this.f52613g[i8];
    }

    public final ByteString[] i() {
        return this.f52613g;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return m((ByteString) obj);
    }

    public final int[] k() {
        return this.f52614h;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return n((ByteString) obj);
    }

    public /* bridge */ int m(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int n(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
