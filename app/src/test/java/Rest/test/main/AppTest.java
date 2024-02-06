package Rest.test.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppTest {

    @Test
    void testApp() {
        // Your test logic here
        App classUnderTest = new App();
        assertNotNull(classUnderTest, "App should not be null");
    }
}
