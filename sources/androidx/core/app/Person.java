package androidx.core.app;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class Person {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f5646a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f5647b;

    /* renamed from: c  reason: collision with root package name */
    String f5648c;

    /* renamed from: d  reason: collision with root package name */
    String f5649d;

    /* renamed from: e  reason: collision with root package name */
    boolean f5650e;

    /* renamed from: f  reason: collision with root package name */
    boolean f5651f;

    /* loaded from: classes.dex */
    static class Api28Impl {
        private Api28Impl() {
        }

        static Person a(android.app.Person person) {
            IconCompat iconCompat;
            Builder f8 = new Builder().f(person.getName());
            if (person.getIcon() != null) {
                iconCompat = IconCompat.a(person.getIcon());
            } else {
                iconCompat = null;
            }
            return f8.c(iconCompat).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Person$Builder] */
        static android.app.Person b(Person person) {
            Icon icon;
            Person.Builder name = new Object() { // from class: android.app.Person.Builder
                static {
                    throw new NoClassDefFoundError();
                }

                @NonNull
                public native /* synthetic */ Person build();

                @NonNull
                public native /* synthetic */ Builder setBot(boolean z7);

                @NonNull
                public native /* synthetic */ Builder setIcon(@Nullable Icon icon2);

                @NonNull
                public native /* synthetic */ Builder setImportant(boolean z7);

                @NonNull
                public native /* synthetic */ Builder setKey(@Nullable String str);

                @NonNull
                public native /* synthetic */ Builder setName(@Nullable CharSequence charSequence);

                @NonNull
                public native /* synthetic */ Builder setUri(@Nullable String str);
            }.setName(person.c());
            if (person.a() != null) {
                icon = person.a().r();
            } else {
                icon = null;
            }
            return name.setIcon(icon).setUri(person.d()).setKey(person.b()).setBot(person.e()).setImportant(person.f()).build();
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f5652a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f5653b;

        /* renamed from: c  reason: collision with root package name */
        String f5654c;

        /* renamed from: d  reason: collision with root package name */
        String f5655d;

        /* renamed from: e  reason: collision with root package name */
        boolean f5656e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5657f;

        @androidx.annotation.NonNull
        public Person a() {
            return new Person(this);
        }

        @androidx.annotation.NonNull
        public Builder b(boolean z7) {
            this.f5656e = z7;
            return this;
        }

        @androidx.annotation.NonNull
        public Builder c(IconCompat iconCompat) {
            this.f5653b = iconCompat;
            return this;
        }

        @androidx.annotation.NonNull
        public Builder d(boolean z7) {
            this.f5657f = z7;
            return this;
        }

        @androidx.annotation.NonNull
        public Builder e(String str) {
            this.f5655d = str;
            return this;
        }

        @androidx.annotation.NonNull
        public Builder f(CharSequence charSequence) {
            this.f5652a = charSequence;
            return this;
        }

        @androidx.annotation.NonNull
        public Builder g(String str) {
            this.f5654c = str;
            return this;
        }
    }

    Person(Builder builder) {
        this.f5646a = builder.f5652a;
        this.f5647b = builder.f5653b;
        this.f5648c = builder.f5654c;
        this.f5649d = builder.f5655d;
        this.f5650e = builder.f5656e;
        this.f5651f = builder.f5657f;
    }

    public IconCompat a() {
        return this.f5647b;
    }

    public String b() {
        return this.f5649d;
    }

    public CharSequence c() {
        return this.f5646a;
    }

    public String d() {
        return this.f5648c;
    }

    public boolean e() {
        return this.f5650e;
    }

    public boolean f() {
        return this.f5651f;
    }

    @androidx.annotation.NonNull
    public String g() {
        String str = this.f5648c;
        if (str != null) {
            return str;
        }
        if (this.f5646a != null) {
            return "name:" + ((Object) this.f5646a);
        }
        return "";
    }

    @androidx.annotation.NonNull
    public android.app.Person h() {
        return Api28Impl.b(this);
    }

    @androidx.annotation.NonNull
    public Bundle i() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence("name", this.f5646a);
        IconCompat iconCompat = this.f5647b;
        if (iconCompat != null) {
            bundle = iconCompat.q();
        } else {
            bundle = null;
        }
        bundle2.putBundle("icon", bundle);
        bundle2.putString("uri", this.f5648c);
        bundle2.putString("key", this.f5649d);
        bundle2.putBoolean("isBot", this.f5650e);
        bundle2.putBoolean("isImportant", this.f5651f);
        return bundle2;
    }
}
