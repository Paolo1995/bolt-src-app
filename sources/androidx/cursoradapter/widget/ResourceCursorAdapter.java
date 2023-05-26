package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: n  reason: collision with root package name */
    private int f6162n;

    /* renamed from: o  reason: collision with root package name */
    private int f6163o;

    /* renamed from: p  reason: collision with root package name */
    private LayoutInflater f6164p;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i8, Cursor cursor, boolean z7) {
        super(context, cursor, z7);
        this.f6163o = i8;
        this.f6162n = i8;
        this.f6164p = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6164p.inflate(this.f6163o, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f6164p.inflate(this.f6162n, viewGroup, false);
    }
}
