package org.shield;

import com.google.common.collect.ImmutableList;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.shield.codegen.WebappAdapterProcessor;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;
import static org.truth0.Truth.ASSERT;

@RunWith(JUnit4.class)
public class IntegrationTest {

    private static List<? extends Processor> PROCESSORS = ImmutableList.of(new WebappAdapterProcessor());

    @Test
    public void testBasic() {
        // flagrantly "inspired" by dagger integration tests
        // personally I prefer code to be read as maths, not as English. But hey.

        JavaFileObject sourceFile = openResource("org/mywebapp/BasicResources.java");
        JavaFileObject expectedWebapp = openResource("org/mywebapp/ExpectedWebapp.java");
        ASSERT.about(javaSource()).that(sourceFile).processedWith(PROCESSORS)
                .compilesWithoutError().and()
                .generatesSources(expectedWebapp);
    }

    private JavaFileObject openResource(String filename) {
        try {
            return JavaFileObjects.forResource(new File("src/test/java/" + filename).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
