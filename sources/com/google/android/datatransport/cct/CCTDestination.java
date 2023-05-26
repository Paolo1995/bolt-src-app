package com.google.android.datatransport.cct;

import androidx.annotation.NonNull;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class CCTDestination implements EncodedDestination {

    /* renamed from: c  reason: collision with root package name */
    static final String f11859c;

    /* renamed from: d  reason: collision with root package name */
    static final String f11860d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11861e;

    /* renamed from: f  reason: collision with root package name */
    private static final Set<Encoding> f11862f;

    /* renamed from: g  reason: collision with root package name */
    public static final CCTDestination f11863g;

    /* renamed from: h  reason: collision with root package name */
    public static final CCTDestination f11864h;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f11865a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11866b;

    static {
        String a8 = StringMerger.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f11859c = a8;
        String a9 = StringMerger.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f11860d = a9;
        String a10 = StringMerger.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f11861e = a10;
        f11862f = Collections.unmodifiableSet(new HashSet(Arrays.asList(Encoding.b("proto"), Encoding.b("json"))));
        f11863g = new CCTDestination(a8, null);
        f11864h = new CCTDestination(a9, a10);
    }

    public CCTDestination(@NonNull String str, String str2) {
        this.f11865a = str;
        this.f11866b = str2;
    }

    @NonNull
    public static CCTDestination c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (str.startsWith("1$")) {
            String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
            if (split.length == 2) {
                String str2 = split[0];
                if (!str2.isEmpty()) {
                    String str3 = split[1];
                    if (str3.isEmpty()) {
                        str3 = null;
                    }
                    return new CCTDestination(str2, str3);
                }
                throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
            }
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        throw new IllegalArgumentException("Version marker missing from extras");
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public Set<Encoding> a() {
        return f11862f;
    }

    public byte[] b() {
        String str = this.f11866b;
        if (str == null && this.f11865a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f11865a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f11866b;
    }

    @NonNull
    public String e() {
        return this.f11865a;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.Destination
    @NonNull
    public String getName() {
        return "cct";
    }
}
