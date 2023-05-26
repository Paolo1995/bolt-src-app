package ee.mtakso.driver.network.client.modal;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.simpleframework.xml.strategy.Name;

/* compiled from: ModalDialogResponse.kt */
@JsonAdapter(ModalDeserializer.class)
/* loaded from: classes3.dex */
public abstract class ModalDialogResponse {

    /* compiled from: ModalDialogResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Banner extends ModalDialogResponse {
        @SerializedName("modal_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f22289a;
        @SerializedName("modal_poll_entry_id")

        /* renamed from: b  reason: collision with root package name */
        private final String f22290b;
        @SerializedName("modal_poll_campaign_id")

        /* renamed from: c  reason: collision with root package name */
        private final String f22291c;
        @SerializedName("params")

        /* renamed from: d  reason: collision with root package name */
        private final Payload f22292d;

        /* compiled from: ModalDialogResponse.kt */
        /* loaded from: classes3.dex */
        public static final class Payload {
            @SerializedName("title")

            /* renamed from: a  reason: collision with root package name */
            private final String f22293a;
            @SerializedName("action")

            /* renamed from: b  reason: collision with root package name */
            private final BannerAction f22294b;

            public final BannerAction a() {
                return this.f22294b;
            }

            public final String b() {
                return this.f22293a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Payload) {
                    Payload payload = (Payload) obj;
                    return Intrinsics.a(this.f22293a, payload.f22293a) && Intrinsics.a(this.f22294b, payload.f22294b);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.f22293a.hashCode() * 31;
                BannerAction bannerAction = this.f22294b;
                return hashCode + (bannerAction == null ? 0 : bannerAction.hashCode());
            }

            public String toString() {
                String str = this.f22293a;
                BannerAction bannerAction = this.f22294b;
                return "Payload(title=" + str + ", action=" + bannerAction + ")";
            }
        }

        public String a() {
            return this.f22289a;
        }

        public final Payload b() {
            return this.f22292d;
        }

        public String c() {
            return this.f22291c;
        }

        public String d() {
            return this.f22290b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Banner) {
                Banner banner = (Banner) obj;
                return Intrinsics.a(a(), banner.a()) && Intrinsics.a(d(), banner.d()) && Intrinsics.a(c(), banner.c()) && Intrinsics.a(this.f22292d, banner.f22292d);
            }
            return false;
        }

        public int hashCode() {
            return (((((a().hashCode() * 31) + d().hashCode()) * 31) + c().hashCode()) * 31) + this.f22292d.hashCode();
        }

        public String toString() {
            String a8 = a();
            String d8 = d();
            String c8 = c();
            Payload payload = this.f22292d;
            return "Banner(modalId=" + a8 + ", pollEntryId=" + d8 + ", pollCampaignId=" + c8 + ", params=" + payload + ")";
        }
    }

    /* compiled from: ModalDialogResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Dialog extends ModalDialogResponse {
        @SerializedName("modal_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f22295a;
        @SerializedName("modal_poll_entry_id")

        /* renamed from: b  reason: collision with root package name */
        private final String f22296b;
        @SerializedName("modal_poll_campaign_id")

        /* renamed from: c  reason: collision with root package name */
        private final String f22297c;
        @SerializedName("params")

        /* renamed from: d  reason: collision with root package name */
        private final DialogPayload f22298d;

        /* compiled from: ModalDialogResponse.kt */
        /* loaded from: classes3.dex */
        public static final class DialogPayload {
            @SerializedName(Name.MARK)

            /* renamed from: a  reason: collision with root package name */
            private final String f22299a;
            @SerializedName("title")

            /* renamed from: b  reason: collision with root package name */
            private final String f22300b;
            @SerializedName("description")

            /* renamed from: c  reason: collision with root package name */
            private final String f22301c;
            @SerializedName("image_url")

            /* renamed from: d  reason: collision with root package name */
            private final String f22302d;
            @SerializedName("primary_action")

            /* renamed from: e  reason: collision with root package name */
            private final ModalDialogAction f22303e;
            @SerializedName("secondary_action")

            /* renamed from: f  reason: collision with root package name */
            private final ModalDialogAction f22304f;
            @SerializedName("layout_type")

            /* renamed from: g  reason: collision with root package name */
            private final LayoutType f22305g;

            /* compiled from: ModalDialogResponse.kt */
            /* loaded from: classes3.dex */
            public enum LayoutType {
                STATIC_IMAGE,
                RESIZABLE_IMAGE
            }

            public DialogPayload(String str, String title, String description, String str2, ModalDialogAction modalDialogAction, ModalDialogAction modalDialogAction2, LayoutType layoutType) {
                Intrinsics.f(title, "title");
                Intrinsics.f(description, "description");
                this.f22299a = str;
                this.f22300b = title;
                this.f22301c = description;
                this.f22302d = str2;
                this.f22303e = modalDialogAction;
                this.f22304f = modalDialogAction2;
                this.f22305g = layoutType;
            }

            public final String a() {
                return this.f22301c;
            }

            public final String b() {
                return this.f22302d;
            }

            public final LayoutType c() {
                return this.f22305g;
            }

            public final ModalDialogAction d() {
                return this.f22303e;
            }

            public final ModalDialogAction e() {
                return this.f22304f;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DialogPayload) {
                    DialogPayload dialogPayload = (DialogPayload) obj;
                    return Intrinsics.a(this.f22299a, dialogPayload.f22299a) && Intrinsics.a(this.f22300b, dialogPayload.f22300b) && Intrinsics.a(this.f22301c, dialogPayload.f22301c) && Intrinsics.a(this.f22302d, dialogPayload.f22302d) && Intrinsics.a(this.f22303e, dialogPayload.f22303e) && Intrinsics.a(this.f22304f, dialogPayload.f22304f) && this.f22305g == dialogPayload.f22305g;
                }
                return false;
            }

            public final String f() {
                return this.f22300b;
            }

            public int hashCode() {
                String str = this.f22299a;
                int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.f22300b.hashCode()) * 31) + this.f22301c.hashCode()) * 31;
                String str2 = this.f22302d;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                ModalDialogAction modalDialogAction = this.f22303e;
                int hashCode3 = (hashCode2 + (modalDialogAction == null ? 0 : modalDialogAction.hashCode())) * 31;
                ModalDialogAction modalDialogAction2 = this.f22304f;
                int hashCode4 = (hashCode3 + (modalDialogAction2 == null ? 0 : modalDialogAction2.hashCode())) * 31;
                LayoutType layoutType = this.f22305g;
                return hashCode4 + (layoutType != null ? layoutType.hashCode() : 0);
            }

            public String toString() {
                String str = this.f22299a;
                String str2 = this.f22300b;
                String str3 = this.f22301c;
                String str4 = this.f22302d;
                ModalDialogAction modalDialogAction = this.f22303e;
                ModalDialogAction modalDialogAction2 = this.f22304f;
                LayoutType layoutType = this.f22305g;
                return "DialogPayload(id=" + str + ", title=" + str2 + ", description=" + str3 + ", imageUrl=" + str4 + ", primaryAction=" + modalDialogAction + ", secondaryAction=" + modalDialogAction2 + ", layoutType=" + layoutType + ")";
            }
        }

        public String a() {
            return this.f22295a;
        }

        public final DialogPayload b() {
            return this.f22298d;
        }

        public String c() {
            return this.f22297c;
        }

        public String d() {
            return this.f22296b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dialog) {
                Dialog dialog = (Dialog) obj;
                return Intrinsics.a(a(), dialog.a()) && Intrinsics.a(d(), dialog.d()) && Intrinsics.a(c(), dialog.c()) && Intrinsics.a(this.f22298d, dialog.f22298d);
            }
            return false;
        }

        public int hashCode() {
            return (((((a().hashCode() * 31) + d().hashCode()) * 31) + c().hashCode()) * 31) + this.f22298d.hashCode();
        }

        public String toString() {
            String a8 = a();
            String d8 = d();
            String c8 = c();
            DialogPayload dialogPayload = this.f22298d;
            return "Dialog(modalId=" + a8 + ", pollEntryId=" + d8 + ", pollCampaignId=" + c8 + ", params=" + dialogPayload + ")";
        }
    }

    /* compiled from: ModalDialogResponse.kt */
    /* loaded from: classes3.dex */
    public static final class Story extends ModalDialogResponse {
        @SerializedName("modal_id")

        /* renamed from: a  reason: collision with root package name */
        private final String f22306a;
        @SerializedName("modal_poll_entry_id")

        /* renamed from: b  reason: collision with root package name */
        private final String f22307b;
        @SerializedName("modal_poll_campaign_id")

        /* renamed from: c  reason: collision with root package name */
        private final String f22308c;
        @SerializedName("params")

        /* renamed from: d  reason: collision with root package name */
        private final StoryPayload f22309d;

        /* compiled from: ModalDialogResponse.kt */
        /* loaded from: classes3.dex */
        public static final class StoryPayload {
            @SerializedName("story_ids")

            /* renamed from: a  reason: collision with root package name */
            private final List<String> f22310a;

            public final List<String> a() {
                return this.f22310a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof StoryPayload) && Intrinsics.a(this.f22310a, ((StoryPayload) obj).f22310a);
            }

            public int hashCode() {
                return this.f22310a.hashCode();
            }

            public String toString() {
                List<String> list = this.f22310a;
                return "StoryPayload(storyIds=" + list + ")";
            }
        }

        public String a() {
            return this.f22306a;
        }

        public final StoryPayload b() {
            return this.f22309d;
        }

        public String c() {
            return this.f22308c;
        }

        public String d() {
            return this.f22307b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Story) {
                Story story = (Story) obj;
                return Intrinsics.a(a(), story.a()) && Intrinsics.a(d(), story.d()) && Intrinsics.a(c(), story.c()) && Intrinsics.a(this.f22309d, story.f22309d);
            }
            return false;
        }

        public int hashCode() {
            return (((((a().hashCode() * 31) + d().hashCode()) * 31) + c().hashCode()) * 31) + this.f22309d.hashCode();
        }

        public String toString() {
            String a8 = a();
            String d8 = d();
            String c8 = c();
            StoryPayload storyPayload = this.f22309d;
            return "Story(modalId=" + a8 + ", pollEntryId=" + d8 + ", pollCampaignId=" + c8 + ", params=" + storyPayload + ")";
        }
    }

    /* compiled from: ModalDialogResponse.kt */
    /* loaded from: classes3.dex */
    public enum Type {
        DYNAMIC,
        STORY,
        BANNER
    }

    private ModalDialogResponse() {
    }
}
