package j$.time.format;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements g {

    /* renamed from: b  reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f50028b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile AbstractMap.SimpleImmutableEntry f50029c;

    /* renamed from: a  reason: collision with root package name */
    private final j$.time.temporal.q f50030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(C0105a c0105a) {
        this.f50030a = c0105a;
    }

    private static int a(s sVar, CharSequence charSequence, int i8, int i9, k kVar) {
        String upperCase = charSequence.toString().substring(i8, i9).toUpperCase();
        if (i9 >= charSequence.length() || charSequence.charAt(i9) == '0' || sVar.a(charSequence.charAt(i9), 'Z')) {
            sVar.m(ZoneId.of(upperCase));
            return i9;
        }
        s c8 = sVar.c();
        int e8 = kVar.e(c8, charSequence, i9);
        try {
            if (e8 >= 0) {
                sVar.m(ZoneId.q(upperCase, ZoneOffset.u((int) c8.i(j$.time.temporal.a.OFFSET_SECONDS).longValue())));
                return e8;
            } else if (kVar == k.f50013d) {
                return ~i8;
            } else {
                sVar.m(ZoneId.of(upperCase));
                return i9;
            }
        } catch (DateTimeException unused) {
            return ~i8;
        }
    }

    @Override // j$.time.format.g
    public final boolean d(u uVar, StringBuilder sb) {
        ZoneId zoneId = (ZoneId) uVar.f(this.f50030a);
        if (zoneId == null) {
            return false;
        }
        sb.append(zoneId.getId());
        return true;
    }

    @Override // j$.time.format.g
    public final int e(s sVar, CharSequence charSequence, int i8) {
        int i9;
        int length = charSequence.length();
        if (i8 <= length) {
            if (i8 == length) {
                return ~i8;
            }
            char charAt = charSequence.charAt(i8);
            if (charAt == '+' || charAt == '-') {
                return a(sVar, charSequence, i8, i8, k.f50013d);
            }
            int i10 = i8 + 2;
            if (length >= i10) {
                char charAt2 = charSequence.charAt(i8 + 1);
                if (sVar.a(charAt, 'U') && sVar.a(charAt2, 'T')) {
                    int i11 = i8 + 3;
                    return (length < i11 || !sVar.a(charSequence.charAt(i10), 'C')) ? a(sVar, charSequence, i8, i10, k.f50014e) : a(sVar, charSequence, i8, i11, k.f50014e);
                } else if (sVar.a(charAt, 'G') && length >= (i9 = i8 + 3) && sVar.a(charAt2, 'M') && sVar.a(charSequence.charAt(i10), 'T')) {
                    return a(sVar, charSequence, i8, i9, k.f50014e);
                }
            }
            HashSet a8 = j$.time.zone.f.a();
            int size = a8.size();
            AbstractMap.SimpleImmutableEntry simpleImmutableEntry = sVar.j() ? f50028b : f50029c;
            if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                synchronized (this) {
                    try {
                        simpleImmutableEntry = sVar.j() ? f50028b : f50029c;
                        if (simpleImmutableEntry == null || ((Integer) simpleImmutableEntry.getKey()).intValue() != size) {
                            simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), m.e(a8, sVar));
                            if (sVar.j()) {
                                f50028b = simpleImmutableEntry;
                            } else {
                                f50029c = simpleImmutableEntry;
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            ParsePosition parsePosition = new ParsePosition(i8);
            String c8 = ((m) simpleImmutableEntry.getValue()).c(charSequence, parsePosition);
            if (c8 != null) {
                sVar.m(ZoneId.of(c8));
                return parsePosition.getIndex();
            } else if (sVar.a(charAt, 'Z')) {
                sVar.m(ZoneOffset.UTC);
                return i8 + 1;
            } else {
                return ~i8;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final String toString() {
        return "ZoneRegionId()";
    }
}
