import net.jcip.annotations.GuardedBy;

import java.lang.String;

class A {

    @GuardedBy("itself")
    private String _foo;

    @javax.annotation.concurrent.GuardedBy("itself")
    private String _bar;

    public String getFoo() {
        synchronized (_foo) {
            return _foo;
        }
    }

    public String getBar() {
        synchronized (_bar) {
            return _bar;
        }
    }

    public void setFoo(String foo) {
        <warning descr="Access to field '_foo' outside of declared guards">_foo</warning> = foo;
    }

    public void setBar(String bar) {
        <warning descr="Access to field '_bar' outside of declared guards">_bar</warning> = bar;
    }
}
