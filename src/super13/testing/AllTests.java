package super13.testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ClienteTestNoThread.class, ListaCompraOMTest.class, ClienteTestThread.class })
public class AllTests {

}
