package androidx.core.app;

import android.app.Notification;
import android.app.Notification$MessagingStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.R$dimen;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.text.BidiFormatter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationCompat {

    /* loaded from: classes.dex */
    public static class Action {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f5571a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f5572b;

        /* renamed from: c  reason: collision with root package name */
        private final RemoteInput[] f5573c;

        /* renamed from: d  reason: collision with root package name */
        private final RemoteInput[] f5574d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5575e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5576f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5577g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f5578h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f5579i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f5580j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f5581k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f5582l;

        public Action(int i8, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i8 != 0 ? IconCompat.h(null, "", i8) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f5581k;
        }

        public boolean b() {
            return this.f5575e;
        }

        @NonNull
        public Bundle c() {
            return this.f5571a;
        }

        public IconCompat d() {
            int i8;
            if (this.f5572b == null && (i8 = this.f5579i) != 0) {
                this.f5572b = IconCompat.h(null, "", i8);
            }
            return this.f5572b;
        }

        public RemoteInput[] e() {
            return this.f5573c;
        }

        public int f() {
            return this.f5577g;
        }

        public boolean g() {
            return this.f5576f;
        }

        public CharSequence h() {
            return this.f5580j;
        }

        public boolean i() {
            return this.f5582l;
        }

        public boolean j() {
            return this.f5578h;
        }

        public Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        Action(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z7, int i8, boolean z8, boolean z9, boolean z10) {
            this.f5576f = true;
            this.f5572b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f5579i = iconCompat.j();
            }
            this.f5580j = Builder.e(charSequence);
            this.f5581k = pendingIntent;
            this.f5571a = bundle == null ? new Bundle() : bundle;
            this.f5573c = remoteInputArr;
            this.f5574d = remoteInputArr2;
            this.f5575e = z7;
            this.f5577g = i8;
            this.f5576f = z8;
            this.f5578h = z9;
            this.f5582l = z10;
        }
    }

    /* loaded from: classes.dex */
    public static class BigPictureStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        private IconCompat f5583e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f5584f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5585g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f5586h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5587i;

        /* loaded from: classes.dex */
        private static class Api16Impl {
            private Api16Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* loaded from: classes.dex */
        private static class Api23Impl {
            private Api23Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        private static class Api31Impl {
            private Api31Impl() {
            }

            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z7) {
                bigPictureStyle.showBigPictureWhenCollapsed(z7);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Context context;
            int i8 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f5627b);
            IconCompat iconCompat = this.f5583e;
            Context context2 = null;
            if (iconCompat != null) {
                if (i8 >= 31) {
                    if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                        context = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f();
                    } else {
                        context = null;
                    }
                    Api31Impl.a(bigContentTitle, this.f5583e.s(context));
                } else if (iconCompat.l() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f5583e.i());
                }
            }
            if (this.f5585g) {
                IconCompat iconCompat2 = this.f5584f;
                if (iconCompat2 == null) {
                    Api16Impl.a(bigContentTitle, null);
                } else if (i8 >= 23) {
                    if (notificationBuilderWithBuilderAccessor instanceof NotificationCompatBuilder) {
                        context2 = ((NotificationCompatBuilder) notificationBuilderWithBuilderAccessor).f();
                    }
                    Api23Impl.a(bigContentTitle, this.f5584f.s(context2));
                } else if (iconCompat2.l() == 1) {
                    Api16Impl.a(bigContentTitle, this.f5584f.i());
                } else {
                    Api16Impl.a(bigContentTitle, null);
                }
            }
            if (this.f5629d) {
                Api16Impl.b(bigContentTitle, this.f5628c);
            }
            if (i8 >= 31) {
                Api31Impl.c(bigContentTitle, this.f5587i);
                Api31Impl.b(bigContentTitle, this.f5586h);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @NonNull
        public BigPictureStyle h(Bitmap bitmap) {
            IconCompat e8;
            if (bitmap == null) {
                e8 = null;
            } else {
                e8 = IconCompat.e(bitmap);
            }
            this.f5584f = e8;
            this.f5585g = true;
            return this;
        }

        @NonNull
        public BigPictureStyle i(Bitmap bitmap) {
            IconCompat e8;
            if (bitmap == null) {
                e8 = null;
            } else {
                e8 = IconCompat.e(bitmap);
            }
            this.f5583e = e8;
            return this;
        }

        @NonNull
        public BigPictureStyle j(CharSequence charSequence) {
            this.f5628c = Builder.e(charSequence);
            this.f5629d = true;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class BigTextStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f5588e;

        @Override // androidx.core.app.NotificationCompat.Style
        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(this.f5627b).bigText(this.f5588e);
            if (this.f5629d) {
                bigText.setSummaryText(this.f5628c);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @NonNull
        public BigTextStyle h(CharSequence charSequence) {
            this.f5588e = Builder.e(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class BubbleMetadata {
        public static Notification.BubbleMetadata a(BubbleMetadata bubbleMetadata) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Style {

        /* renamed from: a  reason: collision with root package name */
        protected Builder f5626a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f5627b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f5628c;

        /* renamed from: d  reason: collision with root package name */
        boolean f5629d = false;

        public void a(@NonNull Bundle bundle) {
            if (this.f5629d) {
                bundle.putCharSequence("android.summaryText", this.f5628c);
            }
            CharSequence charSequence = this.f5627b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c8 = c();
            if (c8 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c8);
            }
        }

        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        }

        protected String c() {
            return null;
        }

        public RemoteViews d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews e(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public RemoteViews f(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        public void g(Builder builder) {
            if (this.f5626a != builder) {
                this.f5626a = builder;
                if (builder != null) {
                    builder.F(this);
                }
            }
        }
    }

    public static Bundle a(@NonNull Notification notification) {
        return notification.extras;
    }

    /* loaded from: classes.dex */
    public static class MessagingStyle extends Style {

        /* renamed from: e  reason: collision with root package name */
        private final List<Message> f5615e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        private final List<Message> f5616f = new ArrayList();

        /* renamed from: g  reason: collision with root package name */
        private Person f5617g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f5618h;

        /* renamed from: i  reason: collision with root package name */
        private Boolean f5619i;

        /* loaded from: classes.dex */
        public static final class Message {

            /* renamed from: a  reason: collision with root package name */
            private final CharSequence f5620a;

            /* renamed from: b  reason: collision with root package name */
            private final long f5621b;

            /* renamed from: c  reason: collision with root package name */
            private final Person f5622c;

            /* renamed from: d  reason: collision with root package name */
            private Bundle f5623d = new Bundle();

            /* renamed from: e  reason: collision with root package name */
            private String f5624e;

            /* renamed from: f  reason: collision with root package name */
            private Uri f5625f;

            public Message(CharSequence charSequence, long j8, Person person) {
                this.f5620a = charSequence;
                this.f5621b = j8;
                this.f5622c = person;
            }

            @NonNull
            static Bundle[] a(@NonNull List<Message> list) {
                Bundle[] bundleArr = new Bundle[list.size()];
                int size = list.size();
                for (int i8 = 0; i8 < size; i8++) {
                    bundleArr[i8] = list.get(i8).h();
                }
                return bundleArr;
            }

            @NonNull
            private Bundle h() {
                Bundle bundle = new Bundle();
                CharSequence charSequence = this.f5620a;
                if (charSequence != null) {
                    bundle.putCharSequence("text", charSequence);
                }
                bundle.putLong("time", this.f5621b);
                Person person = this.f5622c;
                if (person != null) {
                    bundle.putCharSequence("sender", person.c());
                    if (Build.VERSION.SDK_INT >= 28) {
                        bundle.putParcelable("sender_person", this.f5622c.h());
                    } else {
                        bundle.putBundle("person", this.f5622c.i());
                    }
                }
                String str = this.f5624e;
                if (str != null) {
                    bundle.putString("type", str);
                }
                Uri uri = this.f5625f;
                if (uri != null) {
                    bundle.putParcelable("uri", uri);
                }
                Bundle bundle2 = this.f5623d;
                if (bundle2 != null) {
                    bundle.putBundle("extras", bundle2);
                }
                return bundle;
            }

            public String b() {
                return this.f5624e;
            }

            public Uri c() {
                return this.f5625f;
            }

            public Person d() {
                return this.f5622c;
            }

            public CharSequence e() {
                return this.f5620a;
            }

            public long f() {
                return this.f5621b;
            }

            @NonNull
            Notification$MessagingStyle.Message g() {
                Notification$MessagingStyle.Message message;
                Person d8 = d();
                CharSequence charSequence = null;
                android.app.Person person = null;
                if (Build.VERSION.SDK_INT >= 28) {
                    CharSequence e8 = e();
                    long f8 = f();
                    if (d8 != null) {
                        person = d8.h();
                    }
                    message = new Notification$MessagingStyle.Message(e8, f8, person);
                } else {
                    CharSequence e9 = e();
                    long f9 = f();
                    if (d8 != null) {
                        charSequence = d8.c();
                    }
                    message = new Notification$MessagingStyle.Message(e9, f9, charSequence);
                }
                if (b() != null) {
                    message.setData(b(), c());
                }
                return message;
            }
        }

        MessagingStyle() {
        }

        private Message j() {
            List<Message> list;
            for (int size = this.f5615e.size() - 1; size >= 0; size--) {
                Message message = this.f5615e.get(size);
                if (message.d() != null && !TextUtils.isEmpty(message.d().c())) {
                    return message;
                }
            }
            if (!this.f5615e.isEmpty()) {
                return this.f5615e.get(list.size() - 1);
            }
            return null;
        }

        private boolean k() {
            for (int size = this.f5615e.size() - 1; size >= 0; size--) {
                Message message = this.f5615e.get(size);
                if (message.d() != null && message.d().c() == null) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        private TextAppearanceSpan m(int i8) {
            return new TextAppearanceSpan(null, 0, 0, ColorStateList.valueOf(i8), null);
        }

        private CharSequence n(@NonNull Message message) {
            CharSequence c8;
            BidiFormatter c9 = BidiFormatter.c();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i8 = -16777216;
            CharSequence charSequence = "";
            if (message.d() == null) {
                c8 = "";
            } else {
                c8 = message.d().c();
            }
            if (TextUtils.isEmpty(c8)) {
                c8 = this.f5617g.c();
                if (this.f5626a.c() != 0) {
                    i8 = this.f5626a.c();
                }
            }
            CharSequence h8 = c9.h(c8);
            spannableStringBuilder.append(h8);
            spannableStringBuilder.setSpan(m(i8), spannableStringBuilder.length() - h8.length(), spannableStringBuilder.length(), 33);
            if (message.e() != null) {
                charSequence = message.e();
            }
            spannableStringBuilder.append((CharSequence) "  ").append(c9.h(charSequence));
            return spannableStringBuilder;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
            bundle.putCharSequence("android.selfDisplayName", this.f5617g.c());
            bundle.putBundle("android.messagingStyleUser", this.f5617g.i());
            bundle.putCharSequence("android.hiddenConversationTitle", this.f5618h);
            if (this.f5618h != null && this.f5619i.booleanValue()) {
                bundle.putCharSequence("android.conversationTitle", this.f5618h);
            }
            if (!this.f5615e.isEmpty()) {
                bundle.putParcelableArray("android.messages", Message.a(this.f5615e));
            }
            if (!this.f5616f.isEmpty()) {
                bundle.putParcelableArray("android.messages.historic", Message.a(this.f5616f));
            }
            Boolean bool = this.f5619i;
            if (bool != null) {
                bundle.putBoolean("android.isGroupConversation", bool.booleanValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            boolean z7;
            CharSequence e8;
            CharSequence e9;
            Notification$MessagingStyle notification$MessagingStyle;
            o(l());
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 24) {
                if (i8 >= 28) {
                    notification$MessagingStyle = new Notification$MessagingStyle(this.f5617g.h());
                } else {
                    notification$MessagingStyle = new Notification$MessagingStyle(this.f5617g.c());
                }
                for (Message message : this.f5615e) {
                    notification$MessagingStyle.addMessage(message.g());
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    for (Message message2 : this.f5616f) {
                        notification$MessagingStyle.addHistoricMessage(message2.g());
                    }
                }
                if (this.f5619i.booleanValue() || Build.VERSION.SDK_INT >= 28) {
                    notification$MessagingStyle.setConversationTitle(this.f5618h);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    notification$MessagingStyle.setGroupConversation(this.f5619i.booleanValue());
                }
                notification$MessagingStyle.setBuilder(notificationBuilderWithBuilderAccessor.a());
                return;
            }
            Message j8 = j();
            if (this.f5618h != null && this.f5619i.booleanValue()) {
                notificationBuilderWithBuilderAccessor.a().setContentTitle(this.f5618h);
            } else if (j8 != null) {
                notificationBuilderWithBuilderAccessor.a().setContentTitle("");
                if (j8.d() != null) {
                    notificationBuilderWithBuilderAccessor.a().setContentTitle(j8.d().c());
                }
            }
            if (j8 != null) {
                Notification.Builder a8 = notificationBuilderWithBuilderAccessor.a();
                if (this.f5618h != null) {
                    e9 = n(j8);
                } else {
                    e9 = j8.e();
                }
                a8.setContentText(e9);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (this.f5618h == null && !k()) {
                z7 = false;
            } else {
                z7 = true;
            }
            for (int size = this.f5615e.size() - 1; size >= 0; size--) {
                Message message3 = this.f5615e.get(size);
                if (z7) {
                    e8 = n(message3);
                } else {
                    e8 = message3.e();
                }
                if (size != this.f5615e.size() - 1) {
                    spannableStringBuilder.insert(0, (CharSequence) "\n");
                }
                spannableStringBuilder.insert(0, e8);
            }
            new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.a()).setBigContentTitle(null).bigText(spannableStringBuilder);
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @NonNull
        protected String c() {
            return "androidx.core.app.NotificationCompat$MessagingStyle";
        }

        @NonNull
        public MessagingStyle h(Message message) {
            if (message != null) {
                this.f5615e.add(message);
                if (this.f5615e.size() > 25) {
                    this.f5615e.remove(0);
                }
            }
            return this;
        }

        @NonNull
        public MessagingStyle i(CharSequence charSequence, long j8, Person person) {
            h(new Message(charSequence, j8, person));
            return this;
        }

        public boolean l() {
            Builder builder = this.f5626a;
            if (builder != null && builder.f5589a.getApplicationInfo().targetSdkVersion < 28 && this.f5619i == null) {
                if (this.f5618h == null) {
                    return false;
                }
                return true;
            }
            Boolean bool = this.f5619i;
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        @NonNull
        public MessagingStyle o(boolean z7) {
            this.f5619i = Boolean.valueOf(z7);
            return this;
        }

        public MessagingStyle(@NonNull Person person) {
            if (!TextUtils.isEmpty(person.c())) {
                this.f5617g = person;
                return;
            }
            throw new IllegalArgumentException("User's name must not be empty.");
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Icon T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f5589a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Action> f5590b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<Person> f5591c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Action> f5592d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f5593e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f5594f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f5595g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f5596h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f5597i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f5598j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f5599k;

        /* renamed from: l  reason: collision with root package name */
        int f5600l;

        /* renamed from: m  reason: collision with root package name */
        int f5601m;

        /* renamed from: n  reason: collision with root package name */
        boolean f5602n;

        /* renamed from: o  reason: collision with root package name */
        boolean f5603o;

        /* renamed from: p  reason: collision with root package name */
        Style f5604p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f5605q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f5606r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f5607s;

        /* renamed from: t  reason: collision with root package name */
        int f5608t;

        /* renamed from: u  reason: collision with root package name */
        int f5609u;

        /* renamed from: v  reason: collision with root package name */
        boolean f5610v;

        /* renamed from: w  reason: collision with root package name */
        String f5611w;

        /* renamed from: x  reason: collision with root package name */
        boolean f5612x;

        /* renamed from: y  reason: collision with root package name */
        String f5613y;

        /* renamed from: z  reason: collision with root package name */
        boolean f5614z;

        public Builder(@NonNull Context context, @NonNull String str) {
            this.f5590b = new ArrayList<>();
            this.f5591c = new ArrayList<>();
            this.f5592d = new ArrayList<>();
            this.f5602n = true;
            this.f5614z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f5589a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f5601m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        private Bitmap f(Bitmap bitmap) {
            if (bitmap != null && Build.VERSION.SDK_INT < 27) {
                Resources resources = this.f5589a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.f5484b);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.f5483a);
                if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                    return bitmap;
                }
                double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
            }
            return bitmap;
        }

        private void t(int i8, boolean z7) {
            if (z7) {
                Notification notification = this.R;
                notification.flags = i8 | notification.flags;
                return;
            }
            Notification notification2 = this.R;
            notification2.flags = (~i8) & notification2.flags;
        }

        @NonNull
        public Builder A(int i8) {
            this.f5601m = i8;
            return this;
        }

        @NonNull
        public Builder B(boolean z7) {
            this.f5602n = z7;
            return this;
        }

        @NonNull
        public Builder C(int i8) {
            this.R.icon = i8;
            return this;
        }

        @NonNull
        public Builder D(Uri uri) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        @NonNull
        public Builder E(Uri uri, int i8) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = i8;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setLegacyStreamType(i8).build();
            return this;
        }

        @NonNull
        public Builder F(Style style) {
            if (this.f5604p != style) {
                this.f5604p = style;
                if (style != null) {
                    style.g(this);
                }
            }
            return this;
        }

        @NonNull
        public Builder G(CharSequence charSequence) {
            this.f5605q = e(charSequence);
            return this;
        }

        @NonNull
        public Builder H(CharSequence charSequence) {
            this.R.tickerText = e(charSequence);
            return this;
        }

        @NonNull
        public Builder I(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        @NonNull
        public Builder J(int i8) {
            this.F = i8;
            return this;
        }

        @NonNull
        public Builder K(long j8) {
            this.R.when = j8;
            return this;
        }

        @NonNull
        public Builder a(int i8, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f5590b.add(new Action(i8, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Notification b() {
            return new NotificationCompatBuilder(this).c();
        }

        public int c() {
            return this.E;
        }

        @NonNull
        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        @NonNull
        public Builder g(boolean z7) {
            t(16, z7);
            return this;
        }

        @NonNull
        public Builder h(int i8) {
            this.L = i8;
            return this;
        }

        @NonNull
        public Builder i(String str) {
            this.C = str;
            return this;
        }

        @NonNull
        public Builder j(@NonNull String str) {
            this.K = str;
            return this;
        }

        @NonNull
        public Builder k(int i8) {
            this.E = i8;
            return this;
        }

        @NonNull
        public Builder l(boolean z7) {
            this.A = z7;
            this.B = true;
            return this;
        }

        @NonNull
        public Builder m(PendingIntent pendingIntent) {
            this.f5595g = pendingIntent;
            return this;
        }

        @NonNull
        public Builder n(CharSequence charSequence) {
            this.f5594f = e(charSequence);
            return this;
        }

        @NonNull
        public Builder o(CharSequence charSequence) {
            this.f5593e = e(charSequence);
            return this;
        }

        @NonNull
        public Builder p(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        @NonNull
        public Builder q(RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        @NonNull
        public Builder r(int i8) {
            Notification notification = this.R;
            notification.defaults = i8;
            if ((i8 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public Builder s(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public Builder u(PendingIntent pendingIntent, boolean z7) {
            this.f5596h = pendingIntent;
            t(128, z7);
            return this;
        }

        @NonNull
        public Builder v(Bitmap bitmap) {
            this.f5598j = f(bitmap);
            return this;
        }

        @NonNull
        public Builder w(int i8, int i9, int i10) {
            int i11;
            Notification notification = this.R;
            notification.ledARGB = i8;
            notification.ledOnMS = i9;
            notification.ledOffMS = i10;
            if (i9 != 0 && i10 != 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            notification.flags = i11 | (notification.flags & (-2));
            return this;
        }

        @NonNull
        public Builder x(boolean z7) {
            this.f5614z = z7;
            return this;
        }

        @NonNull
        public Builder y(int i8) {
            this.f5600l = i8;
            return this;
        }

        @NonNull
        public Builder z(boolean z7) {
            t(2, z7);
            return this;
        }

        @Deprecated
        public Builder(@NonNull Context context) {
            this(context, null);
        }
    }
}
