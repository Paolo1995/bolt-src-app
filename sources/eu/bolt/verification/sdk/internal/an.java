package eu.bolt.verification.sdk.internal;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import eu.bolt.verification.core.network.adapter.VerificationCameraOverlayAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes5.dex */
public final class an {
    @SerializedName("camera")

    /* renamed from: a  reason: collision with root package name */
    private final String f42102a;
    @SerializedName("text")

    /* renamed from: b  reason: collision with root package name */
    private final String f42103b;
    @SerializedName("overlay")

    /* renamed from: c  reason: collision with root package name */
    private final a f42104c;
    @SerializedName("permission_error")

    /* renamed from: d  reason: collision with root package name */
    private final b f42105d;
    @SerializedName("next_step_id")

    /* renamed from: e  reason: collision with root package name */
    private final String f42106e;
    @SerializedName("theme")

    /* renamed from: f  reason: collision with root package name */
    private final String f42107f;

    @JsonAdapter(VerificationCameraOverlayAdapter.class)
    /* loaded from: classes5.dex */
    public static abstract class a {
        @SerializedName(Name.MARK)

        /* renamed from: a  reason: collision with root package name */
        private final String f42108a = "";
        @SerializedName("alpha")

        /* renamed from: b  reason: collision with root package name */
        private final Float f42109b;
        @SerializedName("image_type")

        /* renamed from: c  reason: collision with root package name */
        private final String f42110c;
        @SerializedName(ImagesContract.URL)

        /* renamed from: d  reason: collision with root package name */
        private final String f42111d;

        /* renamed from: eu.bolt.verification.sdk.internal.an$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0030a extends a {
            @SerializedName("shape_config")

            /* renamed from: e  reason: collision with root package name */
            private final C0031a f42112e;

            /* renamed from: eu.bolt.verification.sdk.internal.an$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0031a {
                @SerializedName("ratio_width")

                /* renamed from: a  reason: collision with root package name */
                private final int f42113a;
                @SerializedName("ratio_height")

                /* renamed from: b  reason: collision with root package name */
                private final int f42114b;

                public final int a() {
                    return this.f42114b;
                }

                public final int b() {
                    return this.f42113a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof C0031a) {
                        C0031a c0031a = (C0031a) obj;
                        return this.f42113a == c0031a.f42113a && this.f42114b == c0031a.f42114b;
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.f42113a * 31) + this.f42114b;
                }

                public String toString() {
                    int i8 = this.f42113a;
                    int i9 = this.f42114b;
                    return "ShapeConfig(ratioWidth=" + i8 + ", ratioHeight=" + i9 + ")";
                }
            }

            public final C0031a d() {
                return this.f42112e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0030a) && Intrinsics.a(this.f42112e, ((C0030a) obj).f42112e);
            }

            public int hashCode() {
                return this.f42112e.hashCode();
            }

            public String toString() {
                C0031a c0031a = this.f42112e;
                return "Oval(shapeConfig=" + c0031a + ")";
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends a {
            @SerializedName("shape_config")

            /* renamed from: e  reason: collision with root package name */
            private final C0032a f42115e;

            /* renamed from: eu.bolt.verification.sdk.internal.an$a$b$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C0032a {
                @SerializedName("ratio_width")

                /* renamed from: a  reason: collision with root package name */
                private final int f42116a;
                @SerializedName("ratio_height")

                /* renamed from: b  reason: collision with root package name */
                private final int f42117b;

                public final int a() {
                    return this.f42117b;
                }

                public final int b() {
                    return this.f42116a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj instanceof C0032a) {
                        C0032a c0032a = (C0032a) obj;
                        return this.f42116a == c0032a.f42116a && this.f42117b == c0032a.f42117b;
                    }
                    return false;
                }

                public int hashCode() {
                    return (this.f42116a * 31) + this.f42117b;
                }

                public String toString() {
                    int i8 = this.f42116a;
                    int i9 = this.f42117b;
                    return "ShapeConfig(ratioWidth=" + i8 + ", ratioHeight=" + i9 + ")";
                }
            }

            public final C0032a d() {
                return this.f42115e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && Intrinsics.a(this.f42115e, ((b) obj).f42115e);
            }

            public int hashCode() {
                return this.f42115e.hashCode();
            }

            public String toString() {
                C0032a c0032a = this.f42115e;
                return "Rectangle(shapeConfig=" + c0032a + ")";
            }
        }

        private a() {
        }

        public final Float a() {
            return this.f42109b;
        }

        public final String b() {
            return this.f42110c;
        }

        public final String c() {
            return this.f42111d;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        @SerializedName("header")

        /* renamed from: a  reason: collision with root package name */
        private final String f42118a;
        @SerializedName("text")

        /* renamed from: b  reason: collision with root package name */
        private final String f42119b;
        @SerializedName("settings_button_text")

        /* renamed from: c  reason: collision with root package name */
        private final String f42120c;
        @SerializedName("back_button_text")

        /* renamed from: d  reason: collision with root package name */
        private final String f42121d;

        public final String a() {
            return this.f42121d;
        }

        public final String b() {
            return this.f42118a;
        }

        public final String c() {
            return this.f42120c;
        }

        public final String d() {
            return this.f42119b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return Intrinsics.a(this.f42118a, bVar.f42118a) && Intrinsics.a(this.f42119b, bVar.f42119b) && Intrinsics.a(this.f42120c, bVar.f42120c) && Intrinsics.a(this.f42121d, bVar.f42121d);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f42118a.hashCode() * 31) + this.f42119b.hashCode()) * 31) + this.f42120c.hashCode()) * 31) + this.f42121d.hashCode();
        }

        public String toString() {
            String str = this.f42118a;
            String str2 = this.f42119b;
            String str3 = this.f42120c;
            String str4 = this.f42121d;
            return "CameraPermissionError(header=" + str + ", text=" + str2 + ", settingsButtonText=" + str3 + ", backButtonText=" + str4 + ")";
        }
    }

    public final String a() {
        return this.f42102a;
    }

    public final String b() {
        return this.f42107f;
    }

    public final String c() {
        return this.f42106e;
    }

    public final a d() {
        return this.f42104c;
    }

    public final b e() {
        return this.f42105d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            return Intrinsics.a(this.f42102a, anVar.f42102a) && Intrinsics.a(this.f42103b, anVar.f42103b) && Intrinsics.a(this.f42104c, anVar.f42104c) && Intrinsics.a(this.f42105d, anVar.f42105d) && Intrinsics.a(this.f42106e, anVar.f42106e) && Intrinsics.a(this.f42107f, anVar.f42107f);
        }
        return false;
    }

    public final String f() {
        return this.f42103b;
    }

    public int hashCode() {
        return (((((((((this.f42102a.hashCode() * 31) + this.f42103b.hashCode()) * 31) + this.f42104c.hashCode()) * 31) + this.f42105d.hashCode()) * 31) + this.f42106e.hashCode()) * 31) + this.f42107f.hashCode();
    }

    public String toString() {
        String str = this.f42102a;
        String str2 = this.f42103b;
        a aVar = this.f42104c;
        b bVar = this.f42105d;
        String str3 = this.f42106e;
        String str4 = this.f42107f;
        return "VerificationCameraContentNetworkModel(camera=" + str + ", text=" + str2 + ", overlay=" + aVar + ", permissionError=" + bVar + ", nextStepId=" + str3 + ", cameraTheme=" + str4 + ")";
    }
}
