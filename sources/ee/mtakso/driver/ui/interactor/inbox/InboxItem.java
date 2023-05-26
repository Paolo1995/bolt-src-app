package ee.mtakso.driver.ui.interactor.inbox;

import eu.bolt.android.stories.model.StoryPreview;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InboxItem.kt */
/* loaded from: classes3.dex */
public abstract class InboxItem {

    /* compiled from: InboxItem.kt */
    /* loaded from: classes3.dex */
    public static final class BoltClub extends InboxItem {

        /* renamed from: a  reason: collision with root package name */
        public static final BoltClub f26559a = new BoltClub();

        private BoltClub() {
            super(null);
        }
    }

    /* compiled from: InboxItem.kt */
    /* loaded from: classes3.dex */
    public static final class Campaigns extends InboxItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f26560a;

        public Campaigns(int i8) {
            super(null);
            this.f26560a = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Campaigns) && this.f26560a == ((Campaigns) obj).f26560a;
        }

        public int hashCode() {
            return this.f26560a;
        }

        public String toString() {
            int i8 = this.f26560a;
            return "Campaigns(activeCampaignsCount=" + i8 + ")";
        }
    }

    /* compiled from: InboxItem.kt */
    /* loaded from: classes3.dex */
    public static final class News extends InboxItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f26561a;

        public News(int i8) {
            super(null);
            this.f26561a = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof News) && this.f26561a == ((News) obj).f26561a;
        }

        public int hashCode() {
            return this.f26561a;
        }

        public String toString() {
            int i8 = this.f26561a;
            return "News(unreadCount=" + i8 + ")";
        }
    }

    /* compiled from: InboxItem.kt */
    /* loaded from: classes3.dex */
    public static final class ScheduledRides extends InboxItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f26562a;

        public ScheduledRides(int i8) {
            super(null);
            this.f26562a = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ScheduledRides) && this.f26562a == ((ScheduledRides) obj).f26562a;
        }

        public int hashCode() {
            return this.f26562a;
        }

        public String toString() {
            int i8 = this.f26562a;
            return "ScheduledRides(acceptedRidesCount=" + i8 + ")";
        }
    }

    /* compiled from: InboxItem.kt */
    /* loaded from: classes3.dex */
    public static final class StoriesPreviews extends InboxItem {

        /* renamed from: a  reason: collision with root package name */
        private final List<StoryPreview> f26563a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoriesPreviews(List<StoryPreview> storyPreviews) {
            super(null);
            Intrinsics.f(storyPreviews, "storyPreviews");
            this.f26563a = storyPreviews;
        }

        public final List<StoryPreview> a() {
            return this.f26563a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StoriesPreviews) && Intrinsics.a(this.f26563a, ((StoriesPreviews) obj).f26563a);
        }

        public int hashCode() {
            return this.f26563a.hashCode();
        }

        public String toString() {
            List<StoryPreview> list = this.f26563a;
            return "StoriesPreviews(storyPreviews=" + list + ")";
        }
    }

    private InboxItem() {
    }

    public /* synthetic */ InboxItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
