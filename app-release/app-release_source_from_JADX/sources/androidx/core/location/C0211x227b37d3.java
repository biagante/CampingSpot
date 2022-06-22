package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.lang.ref.WeakReference;
import java.util.function.Predicate;

/* renamed from: androidx.core.location.-$$Lambda$LocationManagerCompat$LocationListenerTransport$zMh1sPVITlcw-eMtdIvv_D4_SCM */
/* compiled from: lambda */
public final /* synthetic */ class C0211x227b37d3 implements Predicate {
    public static final /* synthetic */ C0211x227b37d3 INSTANCE = new C0211x227b37d3();

    private /* synthetic */ C0211x227b37d3() {
    }

    public final boolean test(Object obj) {
        return LocationManagerCompat.LocationListenerTransport.lambda$unregister$1((WeakReference) obj);
    }
}
