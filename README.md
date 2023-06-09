# one-record-ontologydatamodel

## Introduction

This repository contains **Java POJO classes for IATA ONE Record** (1R) data model, as per
official IATA Ontology on GitHub at https://github.com/IATA-Cargo/ONE-Record.

Note that the deliverable of this project contains POJO classes from the
Ontologies for "Data-Model" _only_, excluding the "API" part.

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

See also https://github.com/riege/one-record-ontologymodel, a predecessor of 
this repository, which covers DataModel- plus API-Ontology.
<br>
Public projects like [IATA one-record-server-java](https://github.com/IATA-Cargo/one-record-server-java)
or [NE:ONE ONE Record server](https://git.openlogisticsfoundation.org/digital-air-cargo/ne-one)
use similar approaches with embedded Java POJOs.

### Comparison [one-record-ontologydatamodel](https://github.com/riege/one-record-ontologydatamodel) and [one-record-ontologymodel](https://github.com/riege/one-record-ontologymodel)

|                                                                                                                      | [one-record-ontologydatamodel](https://github.com/riege/one-record-ontologydatamodel) | [one-record-ontologymodel](https://github.com/riege/one-record-ontologymodel)                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [Ontology 1.1 / 2021-June](https://github.com/IATA-Cargo/ONE-Record/tree/master/June-2021-standard-COTB-endorsed)    | not available (Note 1)                                                                | Yes (Release 1.1.x)                                                                                                                                                                |
| [Ontology 2.0 / 2022-May](https://github.com/IATA-Cargo/ONE-Record/tree/master/May-2022-standard-forCOTBendorsement) | not available (Note 1)                                                                | Yes (Release 2.0.x)                                                                                                                                                                |
| [Ontology 2.1 / 2022-December](https://github.com/IATA-Cargo/ONE-Record/tree/master/December-2022-standard)          | Yes                                                                                   | not available                                                                                                                                                                      |
| Scope                                                                                                                | DataModel Ontology only                                                               | API + DataModel  Ontology                                                                                                                                                          |
| 3rd party Java annotations                                                                                           | none (clean API)                                                                      | [Jackson](https://github.com/FasterXML/jackson), [Swagger IO](https://github.com/swagger-api/swagger.io),  [Spring Framework](https://github.com/spring-projects/spring-framework) |

Note 1: Not released but can be build manually by replacing Ontology file and building manually within project.

### Building

Execute the following on commandline to generate the sources from the Ontology file:

    ./mvnw generate-sources

The following maven command generates the full package (.jar-file in `target` directory):

    ./mvnw clean package

Building with a given version number (e.g. 1.2.3) is achieved with

    ./mvnw -Drevision=1.2.3 clean package

which will generate `target/one-record-cargo-1.2.3.jar`

### Generation from (a new) Ontology

Updating with a new Ontology works by updating content in directory `src/main/resources`, the TTL file and adopt the `mapping` file.

## Used Ontology / Data model version

In general, the official IATA Ontology determines the 1R data model.  The IATA Ontology is available in various versions at GitHub.
The IATA [Cargo Operations and Technology Board, COTB](https://www.iata.org/en/programs/workgroups/cotb)
approved various Ontology versions.

This project aims to keep its releases and versioning in synchronization with the IATA Ontologies, starting with IATA ONE Record Ontology version 2.1.
<!--
| IATA Ontology version / endorsement                                                                           | ONE.Record Ontology-Model Library version   |
|---------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| 2.1.x / [2022-Dec](https://github.com/IATA-Cargo/ONE-Record/tree/master/December-2022-standard)               | 2.1.x see [2.1.3](../../releases/tag/2.1.3) |
-->

## Question and Feedback

For any issues or questions with the ONE Record Ontology data model as such,
please refer to or create new issues with the IATA-Cargo project on GitHub under
https://github.com/IATA-Cargo/ONE-Record/issues.

