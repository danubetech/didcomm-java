package com.danubetech.didcomm;

import com.danubetech.keyformats.crypto.provider.Ed25519Provider;
import com.danubetech.keyformats.crypto.provider.RandomProvider;
import com.danubetech.keyformats.crypto.provider.SHA256Provider;
import com.danubetech.keyformats.crypto.provider.impl.JavaRandomProvider;
import com.danubetech.keyformats.crypto.provider.impl.JavaSHA256Provider;
import com.danubetech.keyformats.crypto.provider.impl.TinkEd25519Provider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DIDCommMessageTest {

	@BeforeEach
	public void before() {

		RandomProvider.set(new JavaRandomProvider());
		SHA256Provider.set(new JavaSHA256Provider());
		Ed25519Provider.set(new TinkEd25519Provider());
	}

	@Test
	public void testDIDDocument() throws Exception {

		DIDCommMessage didCommMessage = new DIDCommMessage();
		didCommMessage.setId("1234567890");
		didCommMessage.setFrom("did:example:alice");
		didCommMessage.setTo("did:example:bob");
		didCommMessage.setType("https://danubetech.com/example/1.0/hello");
		didCommMessage.setCreated_time(1516269022L);
		didCommMessage.setExpires_time(1516385931L);
		didCommMessage.setBody(Map.of("message", "Hello World!"));

		didCommMessage.sign_Ed25519_EdDSA(TestUtil.testEd25519PrivateKey);

		assertNotNull(didCommMessage.getCompactSerialization());
	}
}
