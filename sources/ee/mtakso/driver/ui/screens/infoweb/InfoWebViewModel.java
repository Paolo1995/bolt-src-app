package ee.mtakso.driver.ui.screens.infoweb;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import ee.mtakso.driver.ui.base.mvvm.BaseViewModel;
import ee.mtakso.driver.utils.CompositeUrlLauncher;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfoWebViewModel.kt */
/* loaded from: classes3.dex */
public final class InfoWebViewModel extends BaseViewModel {

    /* renamed from: f  reason: collision with root package name */
    private final CompositeUrlLauncher f30378f;

    /* compiled from: InfoWebViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class FaqConfig implements Parcelable {
        public static final Parcelable.Creator<FaqConfig> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final CharSequence f30382f;

        /* renamed from: g  reason: collision with root package name */
        private final String f30383g;

        /* compiled from: InfoWebViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<FaqConfig> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final FaqConfig createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new FaqConfig((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final FaqConfig[] newArray(int i8) {
                return new FaqConfig[i8];
            }
        }

        public FaqConfig(CharSequence buttonTitle, String faqDeeplink) {
            Intrinsics.f(buttonTitle, "buttonTitle");
            Intrinsics.f(faqDeeplink, "faqDeeplink");
            this.f30382f = buttonTitle;
            this.f30383g = faqDeeplink;
        }

        public final CharSequence a() {
            return this.f30382f;
        }

        public final String b() {
            return this.f30383g;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FaqConfig) {
                FaqConfig faqConfig = (FaqConfig) obj;
                return Intrinsics.a(this.f30382f, faqConfig.f30382f) && Intrinsics.a(this.f30383g, faqConfig.f30383g);
            }
            return false;
        }

        public int hashCode() {
            return (this.f30382f.hashCode() * 31) + this.f30383g.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f30382f;
            String str = this.f30383g;
            return "FaqConfig(buttonTitle=" + ((Object) charSequence) + ", faqDeeplink=" + str + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f30382f, out, i8);
            out.writeString(this.f30383g);
        }
    }

    /* compiled from: InfoWebViewModel.kt */
    /* loaded from: classes3.dex */
    public static abstract class WebContent implements Parcelable {

        /* compiled from: InfoWebViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Link extends WebContent {
            public static final Parcelable.Creator<Link> CREATOR = new Creator();

            /* renamed from: f  reason: collision with root package name */
            private final String f30384f;

            /* compiled from: InfoWebViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class Creator implements Parcelable.Creator<Link> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final Link createFromParcel(Parcel parcel) {
                    Intrinsics.f(parcel, "parcel");
                    return new Link(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public final Link[] newArray(int i8) {
                    return new Link[i8];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Link(String url) {
                super(null);
                Intrinsics.f(url, "url");
                this.f30384f = url;
            }

            public final String a() {
                return this.f30384f;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Link) && Intrinsics.a(this.f30384f, ((Link) obj).f30384f);
            }

            public int hashCode() {
                return this.f30384f.hashCode();
            }

            public String toString() {
                String str = this.f30384f;
                return "Link(url=" + str + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel out, int i8) {
                Intrinsics.f(out, "out");
                out.writeString(this.f30384f);
            }
        }

        /* compiled from: InfoWebViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Raw extends WebContent {
            public static final Parcelable.Creator<Raw> CREATOR = new Creator();

            /* renamed from: f  reason: collision with root package name */
            private final String f30385f;

            /* compiled from: InfoWebViewModel.kt */
            /* loaded from: classes3.dex */
            public static final class Creator implements Parcelable.Creator<Raw> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public final Raw createFromParcel(Parcel parcel) {
                    Intrinsics.f(parcel, "parcel");
                    return new Raw(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b */
                public final Raw[] newArray(int i8) {
                    return new Raw[i8];
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Raw(String content) {
                super(null);
                Intrinsics.f(content, "content");
                this.f30385f = content;
            }

            public final String a() {
                return this.f30385f;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Raw) && Intrinsics.a(this.f30385f, ((Raw) obj).f30385f);
            }

            public int hashCode() {
                return this.f30385f.hashCode();
            }

            public String toString() {
                String str = this.f30385f;
                return "Raw(content=" + str + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel out, int i8) {
                Intrinsics.f(out, "out");
                out.writeString(this.f30385f);
            }
        }

        private WebContent() {
        }

        public /* synthetic */ WebContent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public InfoWebViewModel(CompositeUrlLauncher compositeUrlLauncher) {
        Intrinsics.f(compositeUrlLauncher, "compositeUrlLauncher");
        this.f30378f = compositeUrlLauncher;
    }

    @Override // ee.mtakso.driver.ui.base.mvvm.BaseViewModel
    public void B() {
    }

    public final void D(String url) {
        Intrinsics.f(url, "url");
        this.f30378f.a(url);
    }

    /* compiled from: InfoWebViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();

        /* renamed from: f  reason: collision with root package name */
        private final CharSequence f30379f;

        /* renamed from: g  reason: collision with root package name */
        private final WebContent f30380g;

        /* renamed from: h  reason: collision with root package name */
        private final FaqConfig f30381h;

        /* compiled from: InfoWebViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new Config((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), (WebContent) parcel.readParcelable(Config.class.getClassLoader()), parcel.readInt() == 0 ? null : FaqConfig.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public final Config[] newArray(int i8) {
                return new Config[i8];
            }
        }

        public Config(CharSequence title, WebContent content, FaqConfig faqConfig) {
            Intrinsics.f(title, "title");
            Intrinsics.f(content, "content");
            this.f30379f = title;
            this.f30380g = content;
            this.f30381h = faqConfig;
        }

        public final WebContent a() {
            return this.f30380g;
        }

        public final FaqConfig b() {
            return this.f30381h;
        }

        public final CharSequence c() {
            return this.f30379f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Config) {
                Config config = (Config) obj;
                return Intrinsics.a(this.f30379f, config.f30379f) && Intrinsics.a(this.f30380g, config.f30380g) && Intrinsics.a(this.f30381h, config.f30381h);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((this.f30379f.hashCode() * 31) + this.f30380g.hashCode()) * 31;
            FaqConfig faqConfig = this.f30381h;
            return hashCode + (faqConfig == null ? 0 : faqConfig.hashCode());
        }

        public String toString() {
            CharSequence charSequence = this.f30379f;
            WebContent webContent = this.f30380g;
            FaqConfig faqConfig = this.f30381h;
            return "Config(title=" + ((Object) charSequence) + ", content=" + webContent + ", faqDeeplink=" + faqConfig + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i8) {
            Intrinsics.f(out, "out");
            TextUtils.writeToParcel(this.f30379f, out, i8);
            out.writeParcelable(this.f30380g, i8);
            FaqConfig faqConfig = this.f30381h;
            if (faqConfig == null) {
                out.writeInt(0);
                return;
            }
            out.writeInt(1);
            faqConfig.writeToParcel(out, i8);
        }

        public /* synthetic */ Config(CharSequence charSequence, WebContent webContent, FaqConfig faqConfig, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, webContent, (i8 & 4) != 0 ? null : faqConfig);
        }
    }
}
