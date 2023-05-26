package eu.bolt.android.stories.analytics;

/* compiled from: StoryAnalyticListener.kt */
/* loaded from: classes5.dex */
public interface StoryAnalyticListener {

    /* compiled from: StoryAnalyticListener.kt */
    /* loaded from: classes5.dex */
    public enum ActionType {
        LINK("Story Link"),
        SHARE("Story Share"),
        CLOSE("Story Close");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f37537f;

        ActionType(String str) {
            this.f37537f = str;
        }

        public final String c() {
            return this.f37537f;
        }
    }

    /* compiled from: StoryAnalyticListener.kt */
    /* loaded from: classes5.dex */
    public enum CloseReason {
        CLOSE_BUTTON("close icon tap"),
        SWIPE_DOWN("swipe down"),
        LAST_SLIDE_TAP("last slide tap"),
        ERROR("error"),
        AUTO("auto"),
        DEEPLINK("deeplink"),
        LAST_STORY_SWIPED("last story swiped"),
        BACK_BUTTON("back button");
        

        /* renamed from: f  reason: collision with root package name */
        private final String f37547f;

        CloseReason(String str) {
            this.f37547f = str;
        }

        public final String c() {
            return this.f37547f;
        }
    }

    void a(ActionType actionType, String str, String str2);

    void b(CloseReason closeReason, boolean z7, String str, String str2);

    void c(String str, String str2);

    void d(String str);
}
