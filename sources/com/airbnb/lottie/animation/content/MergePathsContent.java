package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes.dex */
public class MergePathsContent implements PathContent, GreedyContent {

    /* renamed from: d  reason: collision with root package name */
    private final String f9103d;

    /* renamed from: f  reason: collision with root package name */
    private final MergePaths f9105f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f9100a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f9101b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f9102c = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final List<PathContent> f9104e = new ArrayList();

    /* renamed from: com.airbnb.lottie.animation.content.MergePathsContent$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9106a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f9106a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9106a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9106a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9106a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9106a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        this.f9103d = mergePaths.c();
        this.f9105f = mergePaths;
    }

    private void a() {
        for (int i8 = 0; i8 < this.f9104e.size(); i8++) {
            this.f9102c.addPath(this.f9104e.get(i8).getPath());
        }
    }

    @TargetApi(19)
    private void d(Path.Op op) {
        this.f9101b.reset();
        this.f9100a.reset();
        for (int size = this.f9104e.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.f9104e.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> j8 = contentGroup.j();
                for (int size2 = j8.size() - 1; size2 >= 0; size2--) {
                    Path path = j8.get(size2).getPath();
                    path.transform(contentGroup.k());
                    this.f9101b.addPath(path);
                }
            } else {
                this.f9101b.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.f9104e.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> j9 = contentGroup2.j();
            for (int i8 = 0; i8 < j9.size(); i8++) {
                Path path2 = j9.get(i8).getPath();
                path2.transform(contentGroup2.k());
                this.f9100a.addPath(path2);
            }
        } else {
            this.f9100a.set(pathContent2.getPath());
        }
        this.f9102c.op(this.f9100a, this.f9101b, op);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void b(List<Content> list, List<Content> list2) {
        for (int i8 = 0; i8 < this.f9104e.size(); i8++) {
            this.f9104e.get(i8).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void g(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.f9104e.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.f9102c.reset();
        if (this.f9105f.d()) {
            return this.f9102c;
        }
        int i8 = AnonymousClass1.f9106a[this.f9105f.b().ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 4) {
                        if (i8 == 5) {
                            d(Path.Op.XOR);
                        }
                    } else {
                        d(Path.Op.INTERSECT);
                    }
                } else {
                    d(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                d(Path.Op.UNION);
            }
        } else {
            a();
        }
        return this.f9102c;
    }
}
