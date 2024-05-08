# one-record-ontologydatamodel

## Introduction

This repository contains **Java POJO classes for IATA ONE Record** (1R) data model, as per
official IATA Ontology on GitHub at https://github.com/IATA-Cargo/ONE-Record.

Note that the deliverable of this project contains POJO classes from the
Ontologies for "Data-Model", "API" and the "CoreCodeLists" part.

### Codelists and Utility
This repository additionally contains some assisting classes e.g.,
in package `org.iata.onerecord.cargo.codelists` which are not generated from the
Ontology but handcrafted and might be useful for fields where values are limited 
to code lists. 
Please note the `codelists` packages are incomplete and do not  mirror all 
codes from the Ontology.
See also [IATA-Cargo/ONE-Record Issue#92](https://github.com/IATA-Cargo/ONE-Record/issues/92) for details about
"Standard values of enumerations".

Package `org.iata.onerecord.cargo.util` contains utility 
class `ONERecordCargoUtil` which provides a `create(Class<T>)` method
which creates a logistics object created with correct types attribute
as per Vocabulary, e.g. used like

    Waybill obj = ONERecordCargoUtil.create(Waybill.class);


## How to use / integrate

To integrate this library in your own project, follow instructions at
https://jitpack.io/#riege/one-record-ontologydatamodel because this library 
is not published on Maven Central Repository. 

<!-- https://github.com/riege/one-record-converter used -->

### Related projects

Public projects like [IATA one-record-server-java](https://github.com/IATA-Cargo/one-record-server-java)
or [NE:ONE ONE Record server](https://git.openlogisticsfoundation.org/digital-air-cargo/ne-one)
use similar approaches with embedded Java POJOs.


### Versioning

Since we aim to keep the version numbers in relation to the used ontology version we decided to use a slightly different pattern for the versioning.
The most recent version of the DataModel Ontology is: **3.0.0** (as of 07-05-2024). The next release of this project will therefore get the version: **3.0.0000**. 
An internal bugfix would then result in the release version **3.0.0001** and if a new ontology is used e.g. version **3.0.1** for the DataModel, 
this would then result in the release of **3.0.1000**.

### Building

Execute the following on commandline to generate the sources from the Ontology file:

    ./mvnw generate-sources

The following maven command generates the full package (.jar-file in `target` directory):

    ./mvnw clean package

Building with a given version number (e.g. 1.2.3) is achieved with

    ./mvnw -Drevision=1.2.3 clean package

which will generate `target/one-record-cargo-1.2.3.jar`

### Generation from (a new) Ontology

Updating with a new Ontology works by updating content in directory `src/main/resources`. Please replace the TTL file(s) and adopt the `mapping` file.

## Used Ontology / Data model version

In general, the official IATA Ontology determines the 1R data model.  The IATA Ontology is available in various versions at GitHub.
The IATA [Cargo Operations and Technology Board, COTB](https://www.iata.org/en/programs/workgroups/cotb)
approved various Ontology versions.

This project aims to keep its releases and versioning in synchronization with the IATA Ontologies, starting with IATA ONE Record Ontology versions:

DataModel: 3.0.0 (as of 03-11-2023)

API: 2.0.0 (as of 02-05-2023)

CoreCodeLists: 1.0.0 (as of 23-10-2023)

### Older releases of this project

[Ontology 2.1 / 2022-December](https://github.com/IATA-Cargo/ONE-Record/tree/master/2022-12-standard) - Release version: 0.2.5, contains DataModel classes only! Used ontology version: 2.1.3 (as of 01-03-2023)

## Question and Feedback

For any issues or questions with the ONE Record Ontology data model as such,
please refer to or create new issues with the IATA-Cargo project on GitHub under
https://github.com/IATA-Cargo/ONE-Record/issues.

