package com.stratum.platform.transform;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.TransformerFactoryImpl;

/**
 * Executes XSLT transforms using Saxon HE.
 */
public class XsltTransformService {

    private final TransformerFactoryImpl factory = new TransformerFactoryImpl();

    public String transform(String stylesheet, String payload, Map<String, String> parameters) throws Exception {
        Source xsltSource = new StreamSource(new StringReader(stylesheet));
        Source xmlSource = new StreamSource(new StringReader(payload));
        var transformer = factory.newTransformer(xsltSource);
        if (parameters != null) {
            parameters.forEach(transformer::setParameter);
        }
        try (StringWriter output = new StringWriter()) {
            transformer.transform(xmlSource, new StreamResult(output));
            return output.toString();
        }
    }
}
