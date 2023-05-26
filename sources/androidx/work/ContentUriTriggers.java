package androidx.work;

import android.net.Uri;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class ContentUriTriggers {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Trigger> f8254a = new HashSet();

    /* loaded from: classes.dex */
    public static final class Trigger {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8255a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8256b;

        Trigger(@NonNull Uri uri, boolean z7) {
            this.f8255a = uri;
            this.f8256b = z7;
        }

        @NonNull
        public Uri a() {
            return this.f8255a;
        }

        public boolean b() {
            return this.f8256b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Trigger.class != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            if (this.f8256b == trigger.f8256b && this.f8255a.equals(trigger.f8255a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f8255a.hashCode() * 31) + (this.f8256b ? 1 : 0);
        }
    }

    public void a(@NonNull Uri uri, boolean z7) {
        this.f8254a.add(new Trigger(uri, z7));
    }

    @NonNull
    public Set<Trigger> b() {
        return this.f8254a;
    }

    public int c() {
        return this.f8254a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ContentUriTriggers.class == obj.getClass()) {
            return this.f8254a.equals(((ContentUriTriggers) obj).f8254a);
        }
        return false;
    }

    public int hashCode() {
        return this.f8254a.hashCode();
    }
}
