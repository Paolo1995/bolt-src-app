package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Request> f10608a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<Request> f10609b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f10610c;

    public boolean a(Request request) {
        boolean z7 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.f10608a.remove(request);
        if (!this.f10609b.remove(request) && !remove) {
            z7 = false;
        }
        if (z7) {
            request.clear();
        }
        return z7;
    }

    public void b() {
        for (Request request : Util.j(this.f10608a)) {
            a(request);
        }
        this.f10609b.clear();
    }

    public void c() {
        this.f10610c = true;
        for (Request request : Util.j(this.f10608a)) {
            if (request.isRunning() || request.h()) {
                request.clear();
                this.f10609b.add(request);
            }
        }
    }

    public void d() {
        this.f10610c = true;
        for (Request request : Util.j(this.f10608a)) {
            if (request.isRunning()) {
                request.b();
                this.f10609b.add(request);
            }
        }
    }

    public void e() {
        for (Request request : Util.j(this.f10608a)) {
            if (!request.h() && !request.f()) {
                request.clear();
                if (!this.f10610c) {
                    request.j();
                } else {
                    this.f10609b.add(request);
                }
            }
        }
    }

    public void f() {
        this.f10610c = false;
        for (Request request : Util.j(this.f10608a)) {
            if (!request.h() && !request.isRunning()) {
                request.j();
            }
        }
        this.f10609b.clear();
    }

    public void g(@NonNull Request request) {
        this.f10608a.add(request);
        if (!this.f10610c) {
            request.j();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f10609b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f10608a.size() + ", isPaused=" + this.f10610c + "}";
    }
}
