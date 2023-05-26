package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

/* loaded from: classes.dex */
final class AutoValue_AndroidClientInfo extends AndroidClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f11919a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11920b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11921c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11922d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11923e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11924f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11925g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11926h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11927i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11928j;

    /* renamed from: k  reason: collision with root package name */
    private final String f11929k;

    /* renamed from: l  reason: collision with root package name */
    private final String f11930l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends AndroidClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f11931a;

        /* renamed from: b  reason: collision with root package name */
        private String f11932b;

        /* renamed from: c  reason: collision with root package name */
        private String f11933c;

        /* renamed from: d  reason: collision with root package name */
        private String f11934d;

        /* renamed from: e  reason: collision with root package name */
        private String f11935e;

        /* renamed from: f  reason: collision with root package name */
        private String f11936f;

        /* renamed from: g  reason: collision with root package name */
        private String f11937g;

        /* renamed from: h  reason: collision with root package name */
        private String f11938h;

        /* renamed from: i  reason: collision with root package name */
        private String f11939i;

        /* renamed from: j  reason: collision with root package name */
        private String f11940j;

        /* renamed from: k  reason: collision with root package name */
        private String f11941k;

        /* renamed from: l  reason: collision with root package name */
        private String f11942l;

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo a() {
            return new AutoValue_AndroidClientInfo(this.f11931a, this.f11932b, this.f11933c, this.f11934d, this.f11935e, this.f11936f, this.f11937g, this.f11938h, this.f11939i, this.f11940j, this.f11941k, this.f11942l);
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder b(String str) {
            this.f11942l = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder c(String str) {
            this.f11940j = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder d(String str) {
            this.f11934d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder e(String str) {
            this.f11938h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder f(String str) {
            this.f11933c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder g(String str) {
            this.f11939i = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder h(String str) {
            this.f11937g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder i(String str) {
            this.f11941k = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder j(String str) {
            this.f11932b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder k(String str) {
            this.f11936f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder l(String str) {
            this.f11935e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder m(Integer num) {
            this.f11931a = num;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String b() {
        return this.f11930l;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String c() {
        return this.f11928j;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String d() {
        return this.f11922d;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String e() {
        return this.f11926h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f11919a;
        if (num != null ? num.equals(androidClientInfo.m()) : androidClientInfo.m() == null) {
            String str = this.f11920b;
            if (str != null ? str.equals(androidClientInfo.j()) : androidClientInfo.j() == null) {
                String str2 = this.f11921c;
                if (str2 != null ? str2.equals(androidClientInfo.f()) : androidClientInfo.f() == null) {
                    String str3 = this.f11922d;
                    if (str3 != null ? str3.equals(androidClientInfo.d()) : androidClientInfo.d() == null) {
                        String str4 = this.f11923e;
                        if (str4 != null ? str4.equals(androidClientInfo.l()) : androidClientInfo.l() == null) {
                            String str5 = this.f11924f;
                            if (str5 != null ? str5.equals(androidClientInfo.k()) : androidClientInfo.k() == null) {
                                String str6 = this.f11925g;
                                if (str6 != null ? str6.equals(androidClientInfo.h()) : androidClientInfo.h() == null) {
                                    String str7 = this.f11926h;
                                    if (str7 != null ? str7.equals(androidClientInfo.e()) : androidClientInfo.e() == null) {
                                        String str8 = this.f11927i;
                                        if (str8 != null ? str8.equals(androidClientInfo.g()) : androidClientInfo.g() == null) {
                                            String str9 = this.f11928j;
                                            if (str9 != null ? str9.equals(androidClientInfo.c()) : androidClientInfo.c() == null) {
                                                String str10 = this.f11929k;
                                                if (str10 != null ? str10.equals(androidClientInfo.i()) : androidClientInfo.i() == null) {
                                                    String str11 = this.f11930l;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.b() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.b())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String f() {
        return this.f11921c;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String g() {
        return this.f11927i;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String h() {
        return this.f11925g;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        Integer num = this.f11919a;
        int i8 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i9 = (hashCode ^ 1000003) * 1000003;
        String str = this.f11920b;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i10 = (i9 ^ hashCode2) * 1000003;
        String str2 = this.f11921c;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i11 = (i10 ^ hashCode3) * 1000003;
        String str3 = this.f11922d;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i12 = (i11 ^ hashCode4) * 1000003;
        String str4 = this.f11923e;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i13 = (i12 ^ hashCode5) * 1000003;
        String str5 = this.f11924f;
        if (str5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str5.hashCode();
        }
        int i14 = (i13 ^ hashCode6) * 1000003;
        String str6 = this.f11925g;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i15 = (i14 ^ hashCode7) * 1000003;
        String str7 = this.f11926h;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i16 = (i15 ^ hashCode8) * 1000003;
        String str8 = this.f11927i;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i17 = (i16 ^ hashCode9) * 1000003;
        String str9 = this.f11928j;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int i18 = (i17 ^ hashCode10) * 1000003;
        String str10 = this.f11929k;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int i19 = (i18 ^ hashCode11) * 1000003;
        String str11 = this.f11930l;
        if (str11 != null) {
            i8 = str11.hashCode();
        }
        return i19 ^ i8;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String i() {
        return this.f11929k;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String j() {
        return this.f11920b;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String k() {
        return this.f11924f;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String l() {
        return this.f11923e;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public Integer m() {
        return this.f11919a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f11919a + ", model=" + this.f11920b + ", hardware=" + this.f11921c + ", device=" + this.f11922d + ", product=" + this.f11923e + ", osBuild=" + this.f11924f + ", manufacturer=" + this.f11925g + ", fingerprint=" + this.f11926h + ", locale=" + this.f11927i + ", country=" + this.f11928j + ", mccMnc=" + this.f11929k + ", applicationBuild=" + this.f11930l + "}";
    }

    private AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f11919a = num;
        this.f11920b = str;
        this.f11921c = str2;
        this.f11922d = str3;
        this.f11923e = str4;
        this.f11924f = str5;
        this.f11925g = str6;
        this.f11926h = str7;
        this.f11927i = str8;
        this.f11928j = str9;
        this.f11929k = str10;
        this.f11930l = str11;
    }
}
