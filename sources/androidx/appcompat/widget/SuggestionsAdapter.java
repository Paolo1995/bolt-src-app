package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    private int A;
    private int B;
    private int C;
    private int D;

    /* renamed from: q  reason: collision with root package name */
    private final SearchView f2149q;

    /* renamed from: r  reason: collision with root package name */
    private final SearchableInfo f2150r;

    /* renamed from: s  reason: collision with root package name */
    private final Context f2151s;

    /* renamed from: t  reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f2152t;

    /* renamed from: u  reason: collision with root package name */
    private final int f2153u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2154v;

    /* renamed from: w  reason: collision with root package name */
    private int f2155w;

    /* renamed from: x  reason: collision with root package name */
    private ColorStateList f2156x;

    /* renamed from: y  reason: collision with root package name */
    private int f2157y;

    /* renamed from: z  reason: collision with root package name */
    private int f2158z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ChildViewCache {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f2159a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f2160b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f2161c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f2162d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f2163e;

        public ChildViewCache(View view) {
            this.f2159a = (TextView) view.findViewById(16908308);
            this.f2160b = (TextView) view.findViewById(16908309);
            this.f2161c = (ImageView) view.findViewById(16908295);
            this.f2162d = (ImageView) view.findViewById(16908296);
            this.f2163e = (ImageView) view.findViewById(R$id.f907q);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2154v = false;
        this.f2155w = 1;
        this.f2157y = -1;
        this.f2158z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.f2149q = searchView;
        this.f2150r = searchableInfo;
        this.f2153u = searchView.getSuggestionCommitIconResId();
        this.f2151s = context;
        this.f2152t = weakHashMap;
    }

    private void A(Cursor cursor) {
        Bundle bundle;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    private Drawable j(String str) {
        Drawable.ConstantState constantState = this.f2152t.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence k(CharSequence charSequence) {
        if (this.f2156x == null) {
            TypedValue typedValue = new TypedValue();
            this.f2151s.getTheme().resolveAttribute(R$attr.M, typedValue, true);
            this.f2156x = this.f2151s.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2156x, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable l(ComponentName componentName) {
        PackageManager packageManager = this.f2151s.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable == null) {
                Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
                return null;
            }
            return drawable;
        } catch (PackageManager.NameNotFoundException e8) {
            Log.w("SuggestionsAdapter", e8.toString());
            return null;
        }
    }

    private Drawable m(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f2152t.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f2152t.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f2151s.getResources());
        }
        Drawable l8 = l(componentName);
        if (l8 != null) {
            constantState = l8.getConstantState();
        }
        this.f2152t.put(flattenToShortString, constantState);
        return l8;
    }

    public static String n(Cursor cursor, String str) {
        return v(cursor, cursor.getColumnIndex(str));
    }

    private Drawable o() {
        Drawable m8 = m(this.f2150r.getSearchActivity());
        if (m8 != null) {
            return m8;
        }
        return this.f2151s.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable p(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return q(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f2151s.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e8) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e8);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e9) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e9.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e9.getMessage());
        return null;
    }

    private Drawable r(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2151s.getPackageName() + "/" + parseInt;
            Drawable j8 = j(str2);
            if (j8 != null) {
                return j8;
            }
            Drawable drawable = ContextCompat.getDrawable(this.f2151s, parseInt);
            z(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable j9 = j(str);
            if (j9 != null) {
                return j9;
            }
            Drawable p8 = p(Uri.parse(str));
            z(str, p8);
            return p8;
        }
    }

    private Drawable s(Cursor cursor) {
        int i8 = this.B;
        if (i8 == -1) {
            return null;
        }
        Drawable r7 = r(cursor.getString(i8));
        if (r7 != null) {
            return r7;
        }
        return o();
    }

    private Drawable t(Cursor cursor) {
        int i8 = this.C;
        if (i8 == -1) {
            return null;
        }
        return r(cursor.getString(i8));
    }

    private static String v(Cursor cursor, int i8) {
        if (i8 == -1) {
            return null;
        }
        try {
            return cursor.getString(i8);
        } catch (Exception e8) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e8);
            return null;
        }
    }

    private void x(ImageView imageView, Drawable drawable, int i8) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i8);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void y(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void z(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2152t.put(str, drawable.getConstantState());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void a(Cursor cursor) {
        if (this.f2154v) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f2157y = cursor.getColumnIndex("suggest_text_1");
                this.f2158z = cursor.getColumnIndex("suggest_text_2");
                this.A = cursor.getColumnIndex("suggest_text_2_url");
                this.B = cursor.getColumnIndex("suggest_icon_1");
                this.C = cursor.getColumnIndex("suggest_icon_2");
                this.D = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e8) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e8);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor b(CharSequence charSequence) {
        String charSequence2;
        if (charSequence == null) {
            charSequence2 = "";
        } else {
            charSequence2 = charSequence.toString();
        }
        if (this.f2149q.getVisibility() == 0 && this.f2149q.getWindowVisibility() == 0) {
            try {
                Cursor u7 = u(this.f2150r, charSequence2, 50);
                if (u7 != null) {
                    u7.getCount();
                    return u7;
                }
            } catch (RuntimeException e8) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e8);
            }
        }
        return null;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public CharSequence convertToString(Cursor cursor) {
        String n8;
        String n9;
        if (cursor == null) {
            return null;
        }
        String n10 = n(cursor, "suggest_intent_query");
        if (n10 != null) {
            return n10;
        }
        if (this.f2150r.shouldRewriteQueryFromData() && (n9 = n(cursor, "suggest_intent_data")) != null) {
            return n9;
        }
        if (!this.f2150r.shouldRewriteQueryFromText() || (n8 = n(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return n8;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public void d(View view, Context context, Cursor cursor) {
        int i8;
        CharSequence v7;
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i9 = this.D;
        if (i9 != -1) {
            i8 = cursor.getInt(i9);
        } else {
            i8 = 0;
        }
        if (childViewCache.f2159a != null) {
            y(childViewCache.f2159a, v(cursor, this.f2157y));
        }
        if (childViewCache.f2160b != null) {
            String v8 = v(cursor, this.A);
            if (v8 != null) {
                v7 = k(v8);
            } else {
                v7 = v(cursor, this.f2158z);
            }
            if (TextUtils.isEmpty(v7)) {
                TextView textView = childViewCache.f2159a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    childViewCache.f2159a.setMaxLines(2);
                }
            } else {
                TextView textView2 = childViewCache.f2159a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    childViewCache.f2159a.setMaxLines(1);
                }
            }
            y(childViewCache.f2160b, v7);
        }
        ImageView imageView = childViewCache.f2161c;
        if (imageView != null) {
            x(imageView, s(cursor), 4);
        }
        ImageView imageView2 = childViewCache.f2162d;
        if (imageView2 != null) {
            x(imageView2, t(cursor), 8);
        }
        int i10 = this.f2155w;
        if (i10 != 2 && (i10 != 1 || (i8 & 1) == 0)) {
            childViewCache.f2163e.setVisibility(8);
            return;
        }
        childViewCache.f2163e.setVisibility(0);
        childViewCache.f2163e.setTag(childViewCache.f2159a.getText());
        childViewCache.f2163e.setOnClickListener(this);
    }

    @Override // androidx.cursoradapter.widget.ResourceCursorAdapter, androidx.cursoradapter.widget.CursorAdapter
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        View g8 = super.g(context, cursor, viewGroup);
        g8.setTag(new ChildViewCache(g8));
        ((ImageView) g8.findViewById(R$id.f907q)).setImageResource(this.f2153u);
        return g8;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i8, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i8, view, viewGroup);
        } catch (RuntimeException e8) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e8);
            View f8 = f(this.f2151s, c(), viewGroup);
            if (f8 != null) {
                ((ChildViewCache) f8.getTag()).f2159a.setText(e8.toString());
            }
            return f8;
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i8, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i8, view, viewGroup);
        } catch (RuntimeException e8) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e8);
            View g8 = g(this.f2151s, c(), viewGroup);
            if (g8 != null) {
                ((ChildViewCache) g8.getTag()).f2159a.setText(e8.toString());
            }
            return g8;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        A(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        A(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2149q.S((CharSequence) tag);
        }
    }

    Drawable q(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f2151s.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    Cursor u(SearchableInfo searchableInfo, String str, int i8) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i8 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i8));
        }
        return this.f2151s.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void w(int i8) {
        this.f2155w = i8;
    }
}
