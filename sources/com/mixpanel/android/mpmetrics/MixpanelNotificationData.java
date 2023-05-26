package com.mixpanel.android.mpmetrics;

import java.util.List;

/* loaded from: classes3.dex */
class MixpanelNotificationData {

    /* renamed from: e  reason: collision with root package name */
    private String f19278e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f19279f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f19280g;

    /* renamed from: h  reason: collision with root package name */
    private String f19281h;

    /* renamed from: i  reason: collision with root package name */
    private List<MixpanelNotificationButtonData> f19282i;

    /* renamed from: k  reason: collision with root package name */
    private String f19284k;

    /* renamed from: l  reason: collision with root package name */
    private String f19285l;

    /* renamed from: m  reason: collision with root package name */
    private String f19286m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19287n;

    /* renamed from: o  reason: collision with root package name */
    private String f19288o;

    /* renamed from: p  reason: collision with root package name */
    private int f19289p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f19290q;

    /* renamed from: r  reason: collision with root package name */
    private String f19291r;

    /* renamed from: s  reason: collision with root package name */
    private PushTapAction f19292s;

    /* renamed from: t  reason: collision with root package name */
    private String f19293t;

    /* renamed from: u  reason: collision with root package name */
    private String f19294u;

    /* renamed from: v  reason: collision with root package name */
    private String f19295v;

    /* renamed from: a  reason: collision with root package name */
    private int f19274a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f19275b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f19276c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f19277d = -1;

    /* renamed from: j  reason: collision with root package name */
    private String f19283j = "mp";

    /* loaded from: classes3.dex */
    static class MixpanelNotificationButtonData {

        /* renamed from: a  reason: collision with root package name */
        private String f19296a;

        /* renamed from: b  reason: collision with root package name */
        private PushTapAction f19297b;

        /* renamed from: c  reason: collision with root package name */
        private String f19298c;

        public MixpanelNotificationButtonData(String str, PushTapAction pushTapAction, String str2) {
            this.f19296a = str;
            this.f19297b = pushTapAction;
            this.f19298c = str2;
        }

        public String a() {
            return this.f19298c;
        }

        public String b() {
            return this.f19296a;
        }

        public PushTapAction c() {
            return this.f19297b;
        }
    }

    /* loaded from: classes3.dex */
    protected enum PushTapActionType {
        HOMESCREEN("homescreen"),
        URL_IN_BROWSER("browser"),
        DEEP_LINK("deeplink"),
        ERROR("error");
        

        /* renamed from: f  reason: collision with root package name */
        private String f19306f;

        PushTapActionType(String str) {
            this.f19306f = str;
        }

        public static PushTapActionType a(String str) {
            PushTapActionType[] values;
            for (PushTapActionType pushTapActionType : values()) {
                if (pushTapActionType.toString().equals(str)) {
                    return pushTapActionType;
                }
            }
            return ERROR;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f19306f;
        }
    }

    public void A(String str) {
        this.f19278e = str;
    }

    public void B(String str) {
        this.f19295v = str;
    }

    public void C(String str) {
        this.f19285l = str;
    }

    public void D(int i8) {
        this.f19274a = i8;
    }

    public void E(String str) {
        this.f19291r = str;
    }

    public void F(String str) {
        this.f19281h = str;
    }

    public void G(String str) {
        this.f19294u = str;
    }

    public void H(PushTapAction pushTapAction) {
        this.f19292s = pushTapAction;
    }

    public void I(boolean z7) {
        this.f19290q = z7;
    }

    public void J(boolean z7) {
        this.f19287n = z7;
    }

    public void K(CharSequence charSequence) {
        this.f19280g = charSequence;
    }

    public void L(String str) {
        this.f19284k = str;
    }

    public void M(String str) {
        this.f19286m = str;
    }

    public void N(String str) {
        this.f19288o = str;
    }

    public void O(CharSequence charSequence) {
        this.f19279f = charSequence;
    }

    public void P(int i8) {
        this.f19289p = i8;
    }

    public void Q(int i8) {
        this.f19275b = i8;
    }

    public int a() {
        return this.f19276c;
    }

    public List<MixpanelNotificationButtonData> b() {
        return this.f19282i;
    }

    public String c() {
        return this.f19293t;
    }

    public String d() {
        return this.f19283j;
    }

    public int e() {
        return this.f19277d;
    }

    public String f() {
        return this.f19278e;
    }

    public String g() {
        return this.f19295v;
    }

    public int h() {
        return this.f19274a;
    }

    public String i() {
        return this.f19291r;
    }

    public String j() {
        return this.f19281h;
    }

    public String k() {
        return this.f19294u;
    }

    public PushTapAction l() {
        return this.f19292s;
    }

    public CharSequence m() {
        return this.f19280g;
    }

    public String n() {
        return this.f19284k;
    }

    public String o() {
        return this.f19286m;
    }

    public String p() {
        return this.f19288o;
    }

    public CharSequence q() {
        return this.f19279f;
    }

    public int r() {
        return this.f19289p;
    }

    public int s() {
        return this.f19275b;
    }

    public boolean t() {
        return this.f19290q;
    }

    public boolean u() {
        return this.f19287n;
    }

    public void v(int i8) {
        this.f19276c = i8;
    }

    public void w(List<MixpanelNotificationButtonData> list) {
        this.f19282i = list;
    }

    public void x(String str) {
        this.f19293t = str;
    }

    public void y(String str) {
        this.f19283j = str;
    }

    public void z(int i8) {
        this.f19277d = i8;
    }

    /* loaded from: classes3.dex */
    protected static class PushTapAction {

        /* renamed from: a  reason: collision with root package name */
        private final PushTapActionType f19299a;

        /* renamed from: b  reason: collision with root package name */
        private final String f19300b;

        public PushTapAction(PushTapActionType pushTapActionType, String str) {
            this.f19299a = pushTapActionType;
            this.f19300b = str;
        }

        public PushTapActionType a() {
            return this.f19299a;
        }

        public String b() {
            return this.f19300b;
        }

        public PushTapAction(PushTapActionType pushTapActionType) {
            this(pushTapActionType, null);
        }
    }
}
