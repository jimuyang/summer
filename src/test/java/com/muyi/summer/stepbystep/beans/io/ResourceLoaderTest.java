package com.muyi.summer.stepbystep.beans.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: muyi-corp
 * @Date: Created in 14:56 2018/1/31
 * @Description:
 */
public class ResourceLoaderTest {

    @Test
    public void getResource() throws IOException {

        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("bean-definition.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}