package org.eclipse.tractusx.ssi.lib.verifiable;

import java.util.List;
import java.util.Map;

import org.eclipse.tractusx.ssi.lib.model.verifiable.credential.VerifiableCredential;
import org.eclipse.tractusx.ssi.lib.util.TestResourceUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class VerifiableCredentialTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    @SneakyThrows
    public void canSerializeVC() {
        final Map<String, Object> vpFromMap = TestResourceUtil.getAlumniVerifiableCredential();
        var vp = new VerifiableCredential(vpFromMap);
        var json = vp.toJson();
        var mapFromJson = MAPPER.readValue(json, Map.class);
        Assertions.assertEquals(mapFromJson.get(VerifiableCredential.ISSUER), vp.get(VerifiableCredential.ISSUER));
    }

}