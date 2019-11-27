package org.apache.ibatis.io;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertNotNull;

/**
 * @author cj
 * @date 2019/10/13
 */
public class ResourcesTest {

    @Test
    public void testResources() throws IOException {
        final String CONFIG_FILE_PATH = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(CONFIG_FILE_PATH);
        assertNotNull(inputStream);
    }
}
