package android.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.Notification;
import android.net.Uri;

/* loaded from: classes.dex */
public /* synthetic */ class Notification$MessagingStyle extends Notification.Style {

    /* loaded from: classes.dex */
    public final /* synthetic */ class Message {
        static {
            throw new NoClassDefFoundError();
        }

        public /* synthetic */ Message(@NonNull CharSequence charSequence, long j8, @Nullable Person person) {
        }

        @Deprecated
        public /* synthetic */ Message(CharSequence charSequence, long j8, CharSequence charSequence2) {
        }

        public native /* synthetic */ Message setData(String str, Uri uri);
    }

    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ Notification$MessagingStyle(@NonNull Person person) {
    }

    @Deprecated
    public /* synthetic */ Notification$MessagingStyle(@NonNull CharSequence charSequence) {
    }

    public native /* synthetic */ Notification$MessagingStyle addMessage(Message message);

    public native /* synthetic */ Notification$MessagingStyle setConversationTitle(@Nullable CharSequence charSequence);
}
