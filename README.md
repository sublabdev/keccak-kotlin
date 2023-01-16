<div align="center">

  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://sublab.dev/logo_light.png">
    <img alt="Sublab logo" src="https://sublab.dev/logo.png">
  </picture>

</div>

[![Maven Central](https://img.shields.io/maven-central/v/dev.sublab/keccak-kotlin)](https://mvnrepository.com/artifact/dev.sublab/keccak-kotlin)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Telegram channel](https://img.shields.io/badge/chat-telegram-green.svg?logo=telegram)](https://t.me/sublabsupport)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# Sublab's Common Kotlin library

This is a Kotlin repository which contains full rewrite of [Rust's keccak algorithm](https://github.com/RustCrypto/sponges).

Unfortunately, most of the existing *keccak* implementations are either in Java, or their Kotlin implementations are too closed, so internal components cannot be modified and/or withdrawn without using reflection and other low-level language features.

This repository implements base F1600 keccak hashing, while lower sizes are still missing. This is subject to be implemented in this repository.

## Sublab

At Sublab we're making mobile-first libraries for developers in [Substrate](https://substrate.io) ecosystem. However, we seek our libraries to be available not only for mobile Apple OS or Android OS, but compatible with any Swift/Kotlin environment: web servers, desktop apps, and whatnot.

Our mission is to to develop fully native open-source libraries for mobile platforms in Polkadot and Kusama ecosystems, covering everything with reliable unit-tests and providing rich documentation to the developers community. 

Our goal is to have more developers to come into the world of development of client applications in Substrate ecosystem, as we find this as most promising and intelligent blockchain project we ever seen. Thus, we as mobile development gurus trying to create enormously professional libraries which might be very complicated under the hood, but very simple and convenient for final developers.

## Installation

This library is available at Maven Central. Feel free to copy and paste code blocks below to integrate it to your application.

**build.gradle**

```groovy
repositories {
    mavenCentral()
}
```

**Maven**

```xml
<dependency>
    <groupId>dev.sublab</groupId>
    <artifactId>keccak-kotlin</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Gradle**

```groovy
implementation 'dev.sublab:keccak-kotlin:1.0.0'
```

## Documentation
https://docs.sublab.dev/kotlin-libraries/keccak
- Our GitBook: [https://docs.sublab.dev/kotlin-libraries/keccak/](https://docs.sublab.dev/kotlin-libraries/keccak/)
- API reference: [https://api-reference.sublab.dev/keccak-kotlin/](https://api-reference.sublab.dev/keccak-kotlin/)

## Contributing

Please look into our [contribution guide](CONTRIBUTING.md) and [code of conduct](CODE_OF_CONDUCT.md) prior to contributing.

## Contacts

- Website: [sublab.dev](https://sublab.dev)
- E-mail: [info@sublab.dev](mailto:info@sublab.dev)
- Telegram support channel: [t.me/sublabsupport](t.me/sublabsupport)
- Twitter: [twitter.com/sublabdev](https://twitter.com/sublabdev)
