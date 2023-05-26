package com.google.android.datatransport;

/* loaded from: classes.dex */
final class AutoValue_Event<T> extends Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f11851a;

    /* renamed from: b  reason: collision with root package name */
    private final T f11852b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f11853c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Event(Integer num, T t7, Priority priority) {
        this.f11851a = num;
        if (t7 != null) {
            this.f11852b = t7;
            if (priority != null) {
                this.f11853c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Override // com.google.android.datatransport.Event
    public Integer a() {
        return this.f11851a;
    }

    @Override // com.google.android.datatransport.Event
    public T b() {
        return this.f11852b;
    }

    @Override // com.google.android.datatransport.Event
    public Priority c() {
        return this.f11853c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f11851a;
        if (num != null ? num.equals(event.a()) : event.a() == null) {
            if (this.f11852b.equals(event.b()) && this.f11853c.equals(event.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.f11851a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return ((((hashCode ^ 1000003) * 1000003) ^ this.f11852b.hashCode()) * 1000003) ^ this.f11853c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f11851a + ", payload=" + this.f11852b + ", priority=" + this.f11853c + "}";
    }
}
