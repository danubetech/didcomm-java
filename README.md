# didcomm-java

## Information

This is a work-in-progress implementation of DIDComm v2.

Not ready for production use! Use at your own risk! Pull requests welcome.

## Maven

Build:

	mvn clean install

Dependency:

	<repositories>
		<repository>
			<id>danubetech-maven-public</id>
			<url>https://repo.danubetech.com/repository/maven-public/</url>
		</repository>
	</repositories>

	<dependency>
		<groupId>com.danubetech</groupId>
		<artifactId>didcomm-java</artifactId>
		<version>0.1-SNAPSHOT</version>
	</dependency>

## Example

Example code:

    // create and print a DIDComm v2 message

    DIDCommMessage didCommMessage = new DIDCommMessage();
    didCommMessage.setId("1234567890");
    didCommMessage.setFrom("did:example:alice");
    didCommMessage.setTo("did:example:bob");
    didCommMessage.setType("https://danubetech.com/example/1.0/hello");
    didCommMessage.setCreated_time(1516269022L);
    didCommMessage.setExpires_time(1516385931L);
    didCommMessage.setBody(Map.of("message", "Hello World!"));

    byte[] testEd25519PrivateKey = Hex.decodeHex("984b589e121040156838303f107e13150be4a80fc5088ccba0b0bdc9b1d89090de8777a28f8da1a74e7a13090ed974d879bf692d001cddee16e4cc9f84b60580".toCharArray());
    didCommMessage.sign_Ed25519_EdDSA(testEd25519PrivateKey);

    System.out.println(didCommMessage.getCompactSerialization());

## About

Danube Tech - https://danubetech.com/

<br clear="left" />

<img align="left" src="https://raw.githubusercontent.com/danubetech/didcomm-java/master/docs/logo-ngi-essiflab.png" width="115">

Supported by [ESSIF-Lab](https://essif-lab.eu/), which is made possible with financial support from the European Commission's [Next Generation Internet](https://ngi.eu/) programme.
