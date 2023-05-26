package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class PrimitiveSet<P> {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<Prefix, List<Entry<P>>> f14816a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private Entry<P> f14817b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<P> f14818c;

    /* loaded from: classes.dex */
    public static final class Entry<P> {

        /* renamed from: a  reason: collision with root package name */
        private final P f14819a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f14820b;

        /* renamed from: c  reason: collision with root package name */
        private final KeyStatusType f14821c;

        /* renamed from: d  reason: collision with root package name */
        private final OutputPrefixType f14822d;

        /* renamed from: e  reason: collision with root package name */
        private final int f14823e;

        Entry(P p8, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType, int i8) {
            this.f14819a = p8;
            this.f14820b = Arrays.copyOf(bArr, bArr.length);
            this.f14821c = keyStatusType;
            this.f14822d = outputPrefixType;
            this.f14823e = i8;
        }

        public final byte[] a() {
            byte[] bArr = this.f14820b;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public OutputPrefixType b() {
            return this.f14822d;
        }

        public P c() {
            return this.f14819a;
        }

        public KeyStatusType d() {
            return this.f14821c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Prefix implements Comparable<Prefix> {

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f14824f;

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(Prefix prefix) {
            byte[] bArr = this.f14824f;
            int length = bArr.length;
            byte[] bArr2 = prefix.f14824f;
            if (length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            int i8 = 0;
            while (true) {
                byte[] bArr3 = this.f14824f;
                if (i8 >= bArr3.length) {
                    return 0;
                }
                byte b8 = bArr3[i8];
                byte b9 = prefix.f14824f[i8];
                if (b8 != b9) {
                    return b8 - b9;
                }
                i8++;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.f14824f, ((Prefix) obj).f14824f);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f14824f);
        }

        public String toString() {
            return Hex.b(this.f14824f);
        }

        private Prefix(byte[] bArr) {
            this.f14824f = Arrays.copyOf(bArr, bArr.length);
        }
    }

    private PrimitiveSet(Class<P> cls) {
        this.f14818c = cls;
    }

    public static <P> PrimitiveSet<P> f(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    public Entry<P> a(P p8, Keyset.Key key) throws GeneralSecurityException {
        if (key.N() == KeyStatusType.ENABLED) {
            Entry<P> entry = new Entry<>(p8, CryptoFormat.a(key), key.N(), key.M(), key.L());
            ArrayList arrayList = new ArrayList();
            arrayList.add(entry);
            Prefix prefix = new Prefix(entry.a());
            List<Entry<P>> put = this.f14816a.put(prefix, Collections.unmodifiableList(arrayList));
            if (put != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(put);
                arrayList2.add(entry);
                this.f14816a.put(prefix, Collections.unmodifiableList(arrayList2));
            }
            return entry;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }

    public Entry<P> b() {
        return this.f14817b;
    }

    public List<Entry<P>> c(byte[] bArr) {
        List<Entry<P>> list = this.f14816a.get(new Prefix(bArr));
        if (list == null) {
            return Collections.emptyList();
        }
        return list;
    }

    public Class<P> d() {
        return this.f14818c;
    }

    public List<Entry<P>> e() {
        return c(CryptoFormat.f14795a);
    }

    public void g(Entry<P> entry) {
        if (entry != null) {
            if (entry.d() == KeyStatusType.ENABLED) {
                if (!c(entry.a()).isEmpty()) {
                    this.f14817b = entry;
                    return;
                }
                throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
            }
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        throw new IllegalArgumentException("the primary entry must be non-null");
    }
}
